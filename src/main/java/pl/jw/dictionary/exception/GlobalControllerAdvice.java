package pl.jw.dictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseEntity<String> handleException(FileNotFoundException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NoDictionaryDetectedException.class)
    public ResponseEntity<String> handleException(NoDictionaryDetectedException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleException(MissingServletRequestParameterException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DictionaryValueTypeException.class)
    public ResponseEntity<String> handleException(DictionaryValueTypeException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
