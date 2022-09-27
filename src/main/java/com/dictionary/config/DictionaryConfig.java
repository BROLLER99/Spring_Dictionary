package com.dictionary.config;

import com.dictionary.model.RuleOfDictionary;
import com.dictionary.exeption.CustomException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предназначен для хранения номеров и правил словарей
 */
@Component
public class DictionaryConfig {
    private static final String FIRST_PATTERN = "[a-zA-Z]{4}";
    private static final String SECOND_PATTERN = "[0-9]{5}";
    private static final String FIRST_NUMBER_OF_DICTIONARY = "1";
    private static final String SECOND_NUMBER_OF_DICTIONARY = "2";
    private static final String FIRST_DICTIONARY_AND_TERMS = "Выбран словарь № 1. \nВ данном словаре длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки";
    private static final String SECOND_DICTIONARY_AND_TERMS = "Выбран словарь № 2. \nВ данном словаре длина слов может быть только 5 символа и эти символы только цифры.";
    private static final String CONFIG_EXCEPTION = "Ошибка выбора словаря";

    Map<String, RuleOfDictionary> map;

    /**
     * Конструктор задает состояние объекта DictionaryConfig
     */
    public DictionaryConfig() {
        map = new HashMap<>();
        map.put(FIRST_NUMBER_OF_DICTIONARY, new RuleOfDictionary(FIRST_PATTERN, FIRST_DICTIONARY_AND_TERMS));
        map.put(SECOND_NUMBER_OF_DICTIONARY, new RuleOfDictionary(SECOND_PATTERN, SECOND_DICTIONARY_AND_TERMS));

    }

    /**
     * Метод геттер, возвращает соответсвующее значение(правила словаря) введенного ключа(номера словаря)
     *
     * @param key - вводимый ключ(выбранный словарь)
     * @return значение, хранящее правила словаря
     */
    public RuleOfDictionary getMapEntry(String key) {
        try {
            return map.get(key);
        } catch (ClassCastException | NullPointerException e) {
            throw new CustomException(CONFIG_EXCEPTION);
        }
    }

}
