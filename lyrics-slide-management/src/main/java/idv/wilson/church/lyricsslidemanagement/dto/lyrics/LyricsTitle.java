package idv.wilson.church.lyricsslidemanagement.dto.lyrics;

import java.util.UUID;

import lombok.Data;

@Data
public class LyricsTitle {
    private UUID id;
    private String name;
    private String book;
    private String index;
}
