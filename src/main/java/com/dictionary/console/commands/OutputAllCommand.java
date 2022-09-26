package com.dictionary.console.commands;

import com.dictionary.DAO.Storage;


/**
 * Класс реализует метод интерфейса Command выводом всех записей из словаря
 */
public class OutputAllCommand implements Command<StringBuilder> {
    private final Storage typeOfStorage;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для вывода всех записей из словаря
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     */
    public OutputAllCommand(Storage typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }

    /**
     * Реализация метода выполнения команды(вывод всех записей) интерфейса Command
     */
    @Override
    public StringBuilder execute() {
        return typeOfStorage.outputAllElements();
    }
}
