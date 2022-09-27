package com.dictionary.console.commands;

import com.dictionary.DAO.Storage;


/**
 * Класс реализует метод интерфейса Command добавлением записи в словарь
 */
public class AddCommand implements Command<String> {
    private final Storage typeOfStorage;
    private final String keyWord;
    private final String valueWord;
    private final String patternOfWord;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для записи значения в словарь
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord       - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param valueWord     - аргумент, хранящий слово - значение, который необходимо добавить
     * @param patternOfWord - правило записи слова
     */
    public AddCommand(Storage typeOfStorage, String keyWord, String valueWord, String patternOfWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord = keyWord;
        this.valueWord = valueWord;
        this.patternOfWord = patternOfWord;
    }

    /**
     * Реализация метода выполнения команды(добавление записи в словарь) интерфейса Command
     */
    @Override
    public String execute() {
        if (keyWord.matches(patternOfWord)) {
            typeOfStorage.addElement(keyWord, valueWord);
            return COMPLETE;
        } else {
            return NOT_COMPLETE;
        }
    }
}
