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

    //字數-首字筆劃數-INDEXNUMBER
    //XX-XX-XX
    private String code;

    private String name;
    private String bookName;
    private String bookIndex;
    
    private String[][] pages;
    private Integer nameLength;
}
