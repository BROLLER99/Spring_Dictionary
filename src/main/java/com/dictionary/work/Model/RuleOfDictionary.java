package com.dictionary.work.Model;

/**
 * Класс для хранения правил словаря
 */
public class RuleOfDictionary {
    String pattern;
    String description;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами хранения правил
     *
     * @param pattern     - строка для хранения правил заполнения
     * @param description - строка для описания правил словаря
     */
    public RuleOfDictionary(String pattern, String description) {
        this.pattern = pattern;
        this.description = description;
    }

    /**
     * Метод геттер для получения правил заполнения словаря
     *
     * @return возвращает правила заполнения словаря
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод геттер для получения описания правил словаря
     *
     * @return возвращает описание правил словаря
     */
    public String getPattern() {
        return pattern;
    }
}
