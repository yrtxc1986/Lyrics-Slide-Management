package idv.wilson.church.lyricsslidemanagement.tools.slide;

import java.nio.file.Path;

public interface SlideHelper {
    public Slide openSlide(Path slide);
    public Slide newSlide(String fileName);
    public Slide newSlide(Path location, String fileName);
    public Slide saveSlide(Slide slide);
    public void close(Slide slide);
    public void close(Slide slide, boolean isSave);
}
