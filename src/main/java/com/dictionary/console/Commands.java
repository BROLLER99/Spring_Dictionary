package com.dictionary.console;

/**
 * Перечисление команд для работы со словарем
 */
public enum Commands {
    OUTPUT_ALL_ELEMENTS(false, false),
    ADD_ELEMENT(true, true),
    DELETE_ELEMENT(true, false),
    SEARCH_ELEMENT(true, false),
    EXIT(false, false);
    private final static int ONE_TO_START_SERIAL_NUMBER_FROM_ONE = 1;

    Commands(boolean needKey, boolean needValue) {
        this.needKey = needKey;
        this.needValue = needValue;
    }

    public boolean getNeedKey() {
        return needKey;
    }

    public boolean getNeedValue() {
        return needValue;
    }

    private final boolean needKey;
    private final boolean needValue;

    /**
     * Метод геттер возвращает номер выбранной команды
     *
     * @return number - номер выбранной команды
     */
    public int getSerialNumberOfCommand() {
        return ordinal() + ONE_TO_START_SERIAL_NUMBER_FROM_ONE;
    }
}

