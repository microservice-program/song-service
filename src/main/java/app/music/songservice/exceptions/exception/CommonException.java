package app.music.songservice.exceptions.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends RuntimeException {
    private final HttpStatus status;

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
