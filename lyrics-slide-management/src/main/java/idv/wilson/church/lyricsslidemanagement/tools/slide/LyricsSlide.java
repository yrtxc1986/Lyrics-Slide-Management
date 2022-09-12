package idv.wilson.church.lyricsslidemanagement.tools.slide;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.springframework.stereotype.Component;

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;

@Component
public class LyricsSlide {

    public Path create(LyricsEntity data) throws IOException {
        Path tempPath = Files.createTempFile("lyric", ".pptx");

        XMLSlideShow pptx = new XMLSlideShow();
        String name = data.getName();
        for (String[] page : data.getPages()) {
            addPage(pptx, name,  page);
        }

        pptx.write(Files.newOutputStream(tempPath));

        return tempPath;
    }

    private void addPage(XMLSlideShow pptx, String name,  String[] contents) {

        XSLFSlide slide = createSlide(pptx, name);

        XSLFTextShape body = slide.getPlaceholder(0);
        for (String line : contents) {
            addNewLine(body, line);
        }
    }

    private XSLFSlide createSlide(XMLSlideShow pptx, String name) {
        Double TextMargin = 10d;
        XSLFSlideMaster defaultMaster = pptx.getSlideMasters().get(0);

        // title and content
        XSLFSlideLayout titleBodyLayout = defaultMaster.getLayout(SlideLayout.TITLE_ONLY);
        XSLFSlide slide = pptx.createSlide(titleBodyLayout);

        slide.getBackground().setFillColor(Color.BLACK);

        Dimension pageSize = pptx.getPageSize();
        XSLFTextShape placeholder = slide.getPlaceholder(0);
        placeholder.setAnchor(new Rectangle2D.Double(TextMargin, TextMargin, pageSize.getWidth() - (2 * TextMargin),
                pageSize.getHeight() - (2 * TextMargin)));

        placeholder.clearText();
        placeholder.setVerticalAlignment(VerticalAlignment.TOP);

        return slide;
    }

    private void addNewLine(XSLFTextShape body, String text) {
        XSLFTextParagraph paragraph = body.addNewTextParagraph();
        paragraph.setTextAlign(TextAlign.LEFT);

        XSLFTextRun textRun = paragraph.addNewTextRun();

        textRun.setText(text);
        textRun.setFontColor(Color.WHITE);
    }

}
