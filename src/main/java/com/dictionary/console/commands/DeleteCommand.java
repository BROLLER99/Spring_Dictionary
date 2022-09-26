package com.dictionary.console.commands;

import com.dictionary.DAO.Storage;

/**
 * Класс реализует метод интерфейса Command удалением записи из словаря
 */
public class DeleteCommand implements Command<String> {
    private final Storage typeOfStorage;
    private final String keyWord;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для удаления записи из словаря
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord       - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public DeleteCommand(Storage typeOfStorage, String keyWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord = keyWord;
    }

    /**
     * Реализация метода выполнения команды(удаление записи) интерфейса Command
     */
    @Override
    public String execute() {
        typeOfStorage.deleteElement(keyWord);
        return COMPLETE;
    }

}
