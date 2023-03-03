package idv.wilson.church.lyricsslidemanagement.tools.slide;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.Lyrics;

@Component
public class LyricsSlide {

    private final Double TextMargin = 10d;
    private final Double FontSize = 60d;
    private final Double NameSize = 30d;
    private final Dimension pageSize = new Dimension(1280,720);

    public Path create(Lyrics data) throws IOException {
        Path tempPath = Files.createTempFile("lyric", ".pptx");

        XMLSlideShow pptx = new XMLSlideShow();       
        pptx.setPageSize(pageSize);


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
        
        XSLFSlideMaster defaultMaster = pptx.getSlideMasters().get(0);

        // title and content
        XSLFSlideLayout titleBodyLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide slide = pptx.createSlide(titleBodyLayout);

        slide.getBackground().setFillColor(java.awt.Color.black);

        Dimension pageSize = pptx.getPageSize();
        XSLFTextShape placeholder = slide.getPlaceholder(0);
        placeholder.setAnchor(new Rectangle2D.Double(TextMargin, FontSize, pageSize.getWidth() - (2 * TextMargin),
                pageSize.getHeight() - TextMargin-FontSize));

        placeholder.clearText();
        placeholder.setVerticalAlignment(VerticalAlignment.TOP);

        placeholder = slide.getPlaceholder(1);
        placeholder.setAnchor(new Rectangle2D.Double(TextMargin, (pageSize.getHeight() - NameSize-TextMargin), pageSize.getWidth() - (2 * TextMargin),
        NameSize));
        placeholder.clearText();
        placeholder.setLineCap(null);
        addName(placeholder, name);

        return slide;
    }

    private void addName(XSLFTextShape body, String text){
        XSLFTextParagraph paragraph = body.addNewTextParagraph();
        paragraph.setTextAlign(TextAlign.RIGHT);
        paragraph.setBullet(false);

        XSLFTextRun textRun = paragraph.addNewTextRun();

        textRun.setFontSize(NameSize); 
        textRun.setFontColor(java.awt.Color.white);
        textRun.setText(text);

    }

    private void addNewLine(XSLFTextShape body, String text) {
        XSLFTextParagraph paragraph = body.addNewTextParagraph();
        paragraph.setTextAlign(TextAlign.CENTER);

        XSLFTextRun textRun = paragraph.addNewTextRun();

        //textRun.setCharacterSpacing(1.0);

        textRun.setText(text);
        textRun.setFontSize(FontSize); 
        textRun.setFontColor(java.awt.Color.white);
    }

}
