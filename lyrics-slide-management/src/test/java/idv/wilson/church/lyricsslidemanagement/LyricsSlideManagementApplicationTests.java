package idv.wilson.church.lyricsslidemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;

@SpringBootTest
class LyricsSlideManagementApplicationTests {

    @Test
    public void addPage(){
        SlideHelper helper = new SlideHelper();
        Slide slide = helper.newSlide("testing.pptx");
        slide.addPage(new String[]{"Testing Message", "Line2 Message"});
        helper.saveSlide(slide);
    }
}
