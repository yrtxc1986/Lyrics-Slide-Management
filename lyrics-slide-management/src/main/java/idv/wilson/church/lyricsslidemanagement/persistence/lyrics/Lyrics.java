package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;



@Data
public class Lyrics {
    @Id
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
