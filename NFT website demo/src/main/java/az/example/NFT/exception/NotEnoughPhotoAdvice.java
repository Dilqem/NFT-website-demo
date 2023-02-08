package az.example.NFT.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class NotEnoughPhotoAdvice {

    @ResponseBody
    @ExceptionHandler(NotEnoughPhotoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotEnoughPhotoHandler(NotEnoughPhotoException ex) {
        return ex.getMessage();
    }
}
