package az.example.NFT.exception;

public class NotEnoughPhotoException extends RuntimeException{

    public NotEnoughPhotoException() {
        super("Ən azı 2 şəkil yüklənməlidir...");
    }
}