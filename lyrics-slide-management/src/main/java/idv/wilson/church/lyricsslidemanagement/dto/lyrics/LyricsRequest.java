package idv.wilson.church.lyricsslidemanagement.dto.lyrics;

import lombok.Data;

@Data
public class LyricsRequest {
   String name;
   String bookName;
   String bookIndex;
   String[][] pages;
   String code;
}
