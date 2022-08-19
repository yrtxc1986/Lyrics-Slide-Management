package idv.wilson.church.lyricsslidemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LyricsSlideManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LyricsSlideManagementApplication.class, args);
		// ConfigurableApplicationContext ctx =  SpringApplication.run(LyricsSlideManagementApplication.class, args);
		// SlideHelper bean = ctx.getBean(SlideHelperImpl.class);
		// Slide slide = bean.openSlide(Paths.get("C:\\Users\\xfas0002\\Documents\\Testing.pptx"));
		// slide.readText(1);
		// slide.addPage("aa");
		// bean.saveSlide(slide);
	}
}
