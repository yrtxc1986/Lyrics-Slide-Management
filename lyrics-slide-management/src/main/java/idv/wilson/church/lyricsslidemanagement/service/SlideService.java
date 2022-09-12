package idv.wilson.church.lyricsslidemanagement.service;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.tools.slide.LyricsSlide;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlideService{

    private final LyricsSlide slideHelper;


    public void createLyricsSide(LyricsEntity lyric) throws Exception{


        Path tempPath = slideHelper.create(lyric);
        log.info(tempPath.toString());

    }

}