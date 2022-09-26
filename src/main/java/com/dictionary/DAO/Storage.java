package com.dictionary.DAO;


public interface Storage {
    String ADD_EXCEPTION = "Ошибка добавления элемента";
    String DELETE_EXCEPTION = "Ошибка удаления элемента";
    String SEARCH_EXCEPTION = "Ошибка поиска элемента";
    String OUTPUT_ALL_EXCEPTION = "Ошибка вывода всех элементов";
    String KEY_VALUE_SEPARATOR = ":";

    /**
     * Метод добавление элемента
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    void addElement(String key, String value);


    /**
     * Метод удаления элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    void deleteElement(String key);

    /**
     * Метод поиска элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     */
    boolean searchElement(String key);

    /**
     * Метод для вывода всех элементов
     */
    StringBuilder outputAllElements();
}