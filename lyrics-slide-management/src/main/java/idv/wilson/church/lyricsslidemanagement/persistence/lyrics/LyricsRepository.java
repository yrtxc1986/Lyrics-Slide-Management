package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<LyricsEntity, Long> {
    
}
