package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class LyricsEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String bookname;
    private String bookindex;

    private String[] lyricsPerPage;

}
