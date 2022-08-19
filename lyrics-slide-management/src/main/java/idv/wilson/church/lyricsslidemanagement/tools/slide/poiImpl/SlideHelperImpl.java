package idv.wilson.church.lyricsslidemanagement.tools.slide.poiImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.springframework.stereotype.Component;

import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SlideHelperImpl implements SlideHelper {
    public Slide openSlide(Path slide) {
        try {
            return new SlideImpl(new XMLSlideShow(Files.newInputStream(slide)), slide);
        } catch (IOException e) {
            log.info("Please Update the Error Handler");
            log.error("Cannot load PPT", e);
            return null;
        }
    }

    public Slide newSlide(String fileName) {
       return SlideImpl.createNew(Paths.get(fileName));
    }

    public Slide newSlide(Path location, String fileName) {
        return null;
    }

    public Slide saveSlide(Slide slide) {

        if(!(slide instanceof SlideImpl)){
            log.error("Not Support Slide");
        }
        XMLSlideShow ppt = ((SlideImpl)slide).getRaw();
        Path orgPath = ((SlideImpl)slide).getOrgPath();
        try{
        ppt.write(Files.newOutputStream(orgPath));
        
        return openSlide(orgPath);
        }catch(IOException e){
            log.error("Please add Error Handler");
            log.error("Cannot Save PPT",e);
            return slide;
        }

    }

    public void close(Slide slide) {
    }

    public void close(Slide slide, boolean isSave) {

    }
}
