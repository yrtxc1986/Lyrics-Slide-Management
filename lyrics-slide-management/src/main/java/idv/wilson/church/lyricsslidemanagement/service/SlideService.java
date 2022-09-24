package idv.wilson.church.lyricsslidemanagement.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.tools.slide.LyricsSlide;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SlideService{

    private final LyricsSlide slideHelper;


    public Path createLyricsSide(LyricsEntity lyric) throws IOException{

        Path tempPath = slideHelper.create(lyric);
        return tempPath;

    }

}