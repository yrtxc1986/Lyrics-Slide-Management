package idv.wilson.church.lyricsslidemanagement.tools.slide.poiImpl;

import java.nio.file.Path;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlideImpl implements Slide {
    private XMLSlideShow ppt;
    private Path orgPath;

    public XMLSlideShow getRaw(){
        return ppt;
    }
    public Path getOrgPath(){
        return orgPath;
    }

    public SlideImpl(XMLSlideShow ppt, Path orgPath) {
        this.ppt = ppt;
        this.orgPath = orgPath;
    }

    public void addPage(String content) {
        
        // XSLFSlide blankSlide = ppt.createSlide();
        
        XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);

        // title and content
        XSLFSlideLayout titleBodyLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide slide2 = ppt.createSlide(titleBodyLayout);
        XSLFTextShape title2 = slide2.getPlaceholder(0);
        title2.setText("Second Title");
        XSLFTextShape body2 = slide2.getPlaceholder(1);
        body2.clearText(); // unset any existing text
        body2.addNewTextParagraph().addNewTextRun().setText("First paragraph");
        body2.addNewTextParagraph().addNewTextRun().setText("Second paragraph");
        body2.addNewTextParagraph().addNewTextRun().setText("Third paragraph");
        
    }

    public String readText(int page) {
        log.debug("PPT page count:" + ppt.getSlides().size());
        return "";
    }
}
