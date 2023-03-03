package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LyricsRepository extends ReactiveCrudRepository<Lyrics, UUID> {
    
    public Flux<LyricsListItem> findBy();
    public Flux<LyricsListItem> findByNameLength(Integer lenght);
}
