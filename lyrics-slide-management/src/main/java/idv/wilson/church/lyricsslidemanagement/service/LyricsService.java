package idv.wilson.church.lyricsslidemanagement.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsRequest;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.Lyrics;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsListItem;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class LyricsService {

    private final LyricsRepository repo;
    private final SlideService slide;
    
    public Flux<LyricsListItem> getList() {
        return repo.findBy();
    }

    public Mono<Lyrics> getDetial(UUID id) {
        return repo.findById(id);
    }

    public Mono<Lyrics> create(LyricsRequest data) {
        Lyrics input = new Lyrics();
        input.setName(data.getName());
        input.setBookName(data.getBookName());
        input.setBookIndex(data.getBookIndex());
        input.setPages(data.getPages());
        input.setCode(data.getCode());
        input.setNameLength(data.getName().length());

        return repo.save(input);
    }

    public Mono<Lyrics> update(UUID id, LyricsRequest data) {

        return getDetial(id).map(record->{
            if(data.getBookName() != null){
                record.setBookName(data.getBookName());
            }
            if(data.getBookIndex() != null){
                record.setBookIndex(data.getBookIndex());
            }
            if(data.getName() != null){
                record.setName(data.getName());
            }
            if(data.getPages() != null){
                record.setPages(data.getPages());
            }
            return record;
        }).flatMap(record -> repo.save(record));
    }


}
