package idv.wilson.church.lyricsslidemanagement.persistence.lyrics;

import java.util.UUID;

public interface LyricsListItem {
    public UUID getId();
    public String getCode();
    public String getName();
    public String getBookName();
    public String getBookIndex();
}
