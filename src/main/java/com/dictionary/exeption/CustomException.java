package com.dictionary.exeption;

/**
 * Класс предназначен для создания своего исключения для защиты приложения
 */
public class CustomException extends RuntimeException {
    /**
     * Метод создания кастомного исключения
     *
     * @param message сообщение при генерации исключения
     */
    public CustomException(String message) {
        super(message);
    }
}
