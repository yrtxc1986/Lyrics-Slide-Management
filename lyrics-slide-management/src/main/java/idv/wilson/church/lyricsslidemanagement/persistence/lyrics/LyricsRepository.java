package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<LyricsEntity, UUID> {
    
    public List<LyricsListItem> findBy();
    public List<LyricsListItem> findByNameLength(Integer lenght);
}
