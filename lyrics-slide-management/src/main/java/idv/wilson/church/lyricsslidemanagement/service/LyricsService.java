package idv.wilson.church.lyricsslidemanagement.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsTitle;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LyricsService {

    private final LyricsRepository repo;

    public List<LyricsTitle> getList(){
        return Collections.emptyList();
    }

    public LyricsEntity getDetial(UUID id){
        LyricsEntity ret = new LyricsEntity();
        ret.setBookindex("1");
        ret.setBookname("good");
        ret.setId(id);
        ret.setName("hello");

        return ret;
    }

    // public LyricsEntity getById(Long id) {
    //     return repo.getReferenceById(id);
    // }

}
