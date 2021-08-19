package br.com.rabbitbank.rabbitbank.exceptions;

public class RulesException extends RuntimeException {

    private static final Long serialVersionUID = 1L;
    public RulesException(String message) {
        super(message);
    }

    public RulesException(String message, Exception exception) {
        super(message, exception);
    }
}
