package idv.wilson.church.lyricsslidemanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsRepository;
import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;

@SpringBootTest
class LyricsSlideManagementApplicationTests {

    //@Test
    public void addPage(){
        SlideHelper helper = new SlideHelper();
        Slide slide = helper.newSlide("testing.pptx");
        slide.addPage(new String[]{"Testing Message", "Line2 Message"});
        helper.saveSlide(slide);
    }

    @Autowired
    LyricsRepository repo;

    @Test
    public void dbTest(){
        LyricsEntity entity = new LyricsEntity();
        entity.setBookname("123");

        repo.save(entity);    

        LyricsEntity entityLoad = repo.findById(entity.getId()).get();
        assertEquals("123", entityLoad.getBookname());
        System.out.println(entityLoad.getId().toString());


    }
}
