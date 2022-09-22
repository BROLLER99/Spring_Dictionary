package com.dictionary.work.console.commands;

import com.dictionary.work.DAO.Storage;
import com.dictionary.work.console.Commands;
import com.dictionary.work.exeption.FileException;

import static com.dictionary.work.console.View.getInputWord;
import static com.dictionary.work.console.View.getPattern;

/**
 * Класс предназначен для создания и определения объекта выбранной команды
 */
public class FactoryOfCommands {
    private final static String COMMAND_EXCEPTION = "Выбран неверный пункт";
    Storage typeOfStorage;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для определения объекта команды
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     */
    public FactoryOfCommands(Storage typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }

    /**
     * Метод определения объекта команды по выбранному пункту
     *
     * @param command - передаваемое имя команды
     * @return возвращает новый объект команды с определенными параметрами
     */
    public Command<?> nameOfCommand(Commands command) {
        switch (command) {
            case ADD_ELEMENT:
                return new AddCommand(typeOfStorage, getInputWord(), getInputWord(), getPattern());
            case OUTPUT_ALL_ELEMENTS:
                return new OutputAllCommand(typeOfStorage);
            case DELETE_ELEMENT:
                return new DeleteCommand(typeOfStorage, getInputWord());
            case SEARCH_ELEMENT:
                return new SearchCommand(typeOfStorage, getInputWord());
            case EXIT:
                return new ExitCommand();
            default:
                throw new FileException(COMMAND_EXCEPTION);
        }
    }
}
