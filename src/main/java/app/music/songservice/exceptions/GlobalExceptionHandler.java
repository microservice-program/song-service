package app.music.songservice.exceptions;

import app.music.songservice.common.ResultMessage;
import app.music.songservice.exceptions.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ResultMessage> handleCommonException(CommonException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(new ResultMessage(exception.getMessage()));
    }
}
