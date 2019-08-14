package web.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public String doexception3(Exception ex){
        System.out.println(ex);
        return "error";
    }
}
