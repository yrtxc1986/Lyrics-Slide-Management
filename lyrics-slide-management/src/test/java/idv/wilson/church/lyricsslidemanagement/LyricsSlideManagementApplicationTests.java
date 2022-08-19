package idv.wilson.church.lyricsslidemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;
import idv.wilson.church.lyricsslidemanagement.tools.slide.poiImpl.SlideHelperImpl;

@SpringBootTest
class LyricsSlideManagementApplicationTests {


    @Test
    public void addPage(){
        SlideHelper helper = new SlideHelperImpl();
        Slide slide = helper.newSlide("testing.pptx");
        slide.addPage("Testing Message");
        helper.saveSlide(slide);
    }
}
