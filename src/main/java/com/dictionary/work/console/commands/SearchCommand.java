package com.dictionary.work.console.commands;

import com.dictionary.work.DAO.Storage;

/**
 * Класс реализует метод интерфейса Command поиском записи из словаря
 */
public class SearchCommand implements Command<String> {
    private final Storage typeOfStorage;
    private final String keyWord;
    private static final String YES_ELEMENT = "Такой элемент есть";
    private static final String NO_ELEMENT = "Такого элемента нет";

    /**
     * Конструктор задает состояние объекта необходимыми параметрами поиска записи в словаре
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord       - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public SearchCommand(Storage typeOfStorage, String keyWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord = keyWord;

    }

    /**
     * Реализация метода выполнения команды(поиск записи) интерфейса Command
     */
    @Override
    public String execute() {
        if (typeOfStorage.searchElement(keyWord)) {
            return YES_ELEMENT;
        } else {
            return NO_ELEMENT;
        }
    }
}

