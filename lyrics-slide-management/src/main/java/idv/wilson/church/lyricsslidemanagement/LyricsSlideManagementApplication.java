package idv.wilson.church.lyricsslidemanagement;

import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import idv.wilson.church.lyricsslidemanagement.tools.slide.Slide;
import idv.wilson.church.lyricsslidemanagement.tools.slide.SlideHelper;
import idv.wilson.church.lyricsslidemanagement.tools.slide.poiImpl.SlideHelperImpl;

@SpringBootApplication
public class LyricsSlideManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(LyricsSlideManagementApplication.class, args);
		SlideHelper bean = ctx.getBean(SlideHelperImpl.class);
		Slide slide = bean.openSlide(Paths.get("C:\\Users\\xfas0002\\Documents\\Testing.pptx"));
		slide.readText(1);
		slide.addPage("aa");
		bean.saveSlide(slide);
	}
}
