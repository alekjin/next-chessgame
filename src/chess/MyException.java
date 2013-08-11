package chess;

import java.lang.Exception;

public class MyException extends Exception {
    MyException(String error){
        super(error);
    }

    void EmptyPieceException() {
        System.out.println("Empty");
    }

    void InvalidPlaceException() {

    }
}
