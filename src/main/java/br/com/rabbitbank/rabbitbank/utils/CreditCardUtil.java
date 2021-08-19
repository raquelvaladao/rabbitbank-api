package br.com.rabbitbank.rabbitbank.utils;

public class CreditCardUtil {
    public static String maskNumber(String cardNumber) {
        return cardNumber.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }
}
