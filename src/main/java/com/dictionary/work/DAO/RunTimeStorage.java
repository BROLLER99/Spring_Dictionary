package com.dictionary.work.DAO;

import com.dictionary.work.exeption.FileException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует методы интерфейса InterfaceDictionary по работе с map
 */
@Component
public class RunTimeStorage implements Storage {
    /**
     * Объект dictionary который будет хранить коллекцию Map
     */
    private final Map<String, String> dictionary = new HashMap<>();

    /**
     * Реализация метода добавления записи в map, интерфейса InterfaceDictionary
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws FileException if the put operation is not supported by this map(UnsupportedOperationException)
     *                       if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    @Override
    public void addElement(String key, String value) {
        try {
            dictionary.put(key, value);
        } catch (IllegalArgumentException | NullPointerException | ClassCastException |
                 UnsupportedOperationException e) {
            throw new FileException(ADD_EXCEPTION);
        }
    }

    /**
     * Реализация метода удаления записи из map, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     * @throws FileException if the put operation is not supported by this map(UnsupportedOperationException)
     *                       if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public void deleteElement(String key) {
        try {
            dictionary.remove(key);
        } catch (NullPointerException | ClassCastException | UnsupportedOperationException e) {
            throw new FileException(DELETE_EXCEPTION);
        }
    }

    /**
     * Реализация метода поиска записи в map, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @return true если элемент найден и false если нет
     * @throws FileException if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public boolean searchElement(String key) {
        try {
            return dictionary.containsKey(key);
        } catch (ClassCastException | NullPointerException e) {
            throw new FileException(SEARCH_EXCEPTION);
        }
    }

    /**
     * Реализация метода вывода всех записей из map, интерфейса InterfaceDictionary
     *
     * @return возвращает строку в которой содержаться все элементы
     * @throws FileException if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    @Override
    public StringBuilder outputAllElements() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> pair : dictionary.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                stringBuilder.append(key).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
            }
            return stringBuilder;
        } catch (IllegalStateException | NullPointerException e) {
            throw new FileException(OUTPUT_ALL_EXCEPTION);
        }
    }

}
