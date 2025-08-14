package ru.netology.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.rest.Exceptions.InvalidCredentials;
import ru.netology.rest.Exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    // на InvalidCredentials он должен отсылать обратно клиенту HTTP-статус с кодом 400 и
    // телом в виде сообщения из exception;
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> InvalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // на UnauthorizedUser он должен отсылать обратно клиенту HTTP-статус с кодом 401 и
    // телом в виде сообщения из exception и писать в консоль сообщение из exception.
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> UnauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println("[UnauthorizedUser]: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
