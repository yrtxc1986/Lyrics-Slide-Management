package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import lombok.Data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class LyricsEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;
    private String bookname;
    private String bookindex;

    private String[] lyricsPerPage;

}
