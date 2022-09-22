package com.dictionary.work.exeption;

/**
 * Класс предназначен для создания своего исключения для защиты приложения
 */
public class FileException extends RuntimeException{
    public FileException(String message){
        super(message);
    }
}
