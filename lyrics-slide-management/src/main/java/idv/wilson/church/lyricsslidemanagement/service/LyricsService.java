package idv.wilson.church.lyricsslidemanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import idv.wilson.church.lyricsslidemanagement.Exception.RecordNotFindException;
import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsRequest;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsListItem;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LyricsService {

    private final LyricsRepository repo;

    public List<LyricsListItem> getList() {
        return repo.findBy();
    }

    public LyricsEntity getDetial(UUID id) {
        return repo.findById(id).orElseThrow(
                () -> new RecordNotFindException(id));
    }

    public UUID create(LyricsRequest data) {
        LyricsEntity input = new LyricsEntity();
        input.setName(data.getName());
        input.setBookName(data.getBookName());
        input.setBookIndex(data.getBookIndex());
        input.setPages(data.getPages());
        input.setCode(data.getCode());
        input.setNameLength(data.getName().length());

        repo.save(input);
        return input.getId();
    }

    public void update(UUID id, LyricsRequest data) {
        LyricsEntity record = getDetial(id);
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
        repo.save(record);
    }

}
