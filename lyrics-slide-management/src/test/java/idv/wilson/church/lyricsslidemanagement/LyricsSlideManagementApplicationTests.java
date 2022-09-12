package idv.wilson.church.lyricsslidemanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsRepository;
import idv.wilson.church.lyricsslidemanagement.service.SlideService;
import idv.wilson.church.lyricsslidemanagement.tools.slide.LyricsSlide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;

@SpringBootTest
class LyricsSlideManagementApplicationTests {

    // @Test
    public void addPage() {
        SlideHelper helper = new SlideHelper();
        Slide slide = helper.newSlide("testing.pptx");
        slide.addPage(new String[] { "Testing Message", "Line2 Message" });
        helper.saveSlide(slide);
    }

    @Autowired
    LyricsRepository repo;

    // @Test
    public void dbTest() {
        LyricsEntity entity = new LyricsEntity();
        entity.setBookName("123");

        repo.save(entity);

        LyricsEntity entityLoad = repo.findById(entity.getId()).get();
        assertEquals("123", entityLoad.getBookName());
        System.out.println(entityLoad.getId().toString());

    }

    //@Test
    public void createLyricsSldie() throws Exception{
        String jsonObject = "{\"name\": \"我是主的羊\",\"bookName\": \"青年聖歌 III\",\"bookIndex\": \"43\",\"pages\":[[\"主領我到青草地，安歇在溪水旁；\",\"黃昏時主與我一路同行，\",\"牧場上主的羊都得飽足心快暢，\",\"我是主的羊。\"],"+            
                    "[\"青草地（死蔭幽谷），溪水旁（高山峻嶺），\",\"黃昏時（黃昏時），有主與我同行 (有主與我同行)。\",\"黑暗夜（死蔭幽谷），路崎嶇（高山峻嶺），\",\"每一步（每一步），跟隨主行 (跟隨主行)。\"]]}";
        
        ObjectMapper objectMapper = new ObjectMapper();
        LyricsEntity lyric = objectMapper.readValue(jsonObject, LyricsEntity.class);
        
        LyricsSlide helper = new LyricsSlide();
        SlideService service = new SlideService(helper);
        service.createLyricsSide(lyric);
    }
}
