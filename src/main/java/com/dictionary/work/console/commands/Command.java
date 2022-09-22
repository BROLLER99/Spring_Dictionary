package com.dictionary.work.console.commands;

/**
 * Интерфейс для выполнения операции
 */
public interface Command<T> {
    String COMPLETE = "Операция выполнена";
    String NOT_COMPLETE = "Операция не выполнена";

    /**
     * Метод выполнения команды
     */
    T execute();
}
