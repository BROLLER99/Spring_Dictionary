package com.dictionary.work.console;

/**
 * Перечисление команд для работы со словарем
 */
public enum Commands {
    OUTPUT_ALL_ELEMENTS, ADD_ELEMENT, DELETE_ELEMENT, SEARCH_ELEMENT, EXIT;
    private final static int ONE_TO_START_SERIAL_NUMBER_FROM_ONE = 1;

    /**
     * Метод геттер возвращает номер выбранной команды
     *
     * @return number - номер выбранной команды
     */
    public int getSerialNumberOfCommand() {
        return ordinal() + ONE_TO_START_SERIAL_NUMBER_FROM_ONE;
    }
}

