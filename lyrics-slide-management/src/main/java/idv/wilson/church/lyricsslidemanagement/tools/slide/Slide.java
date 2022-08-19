package idv.wilson.church.lyricsslidemanagement.tools.slide;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.nio.file.Path;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slide  {
    private XMLSlideShow ppt;
    private Path orgPath;

    public static Slide createNew(Path file) {
        XMLSlideShow ppt = new XMLSlideShow();
        return new Slide(ppt, file);
    }

    public XMLSlideShow getRaw() {
        return ppt;
    }

    public Path getOrgPath() {
        return orgPath;
    }

    public Slide(XMLSlideShow ppt, Path orgPath) {
        this.ppt = ppt;
        this.orgPath = orgPath;
    }

    public void addPage(String[] contents) {

        XSLFSlide slide = createSlide(ppt);

        XSLFTextShape body = slide.getPlaceholder(0);
        for(String line : contents){
        addNewLine(body, line);
        }
    }

    private XSLFSlide createSlide(XMLSlideShow ppt) {
        Double TextMargin = 10d;
        XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);

        // title and content
        XSLFSlideLayout titleBodyLayout = defaultMaster.getLayout(SlideLayout.TITLE_ONLY);
        XSLFSlide slide = ppt.createSlide(titleBodyLayout);

        slide.getBackground().setFillColor(Color.BLACK);

        Dimension pageSize = ppt.getPageSize();
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

    public String readText(int page) {
        log.debug("PPT page count:" + ppt.getSlides().size());
        return "";
    }
}
