package idv.wilson.church.lyricsslidemanagement.Exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class RecordNotFindException extends ResponseStatusException{

    public RecordNotFindException(UUID id) {
        super(HttpStatus.NOT_FOUND, "Record "+id +" Not Find");
    }

    public RecordNotFindException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
    public RecordNotFindException(String reason, Throwable cause) {
        super(HttpStatus.NOT_FOUND, reason, cause);
    }
    
}
