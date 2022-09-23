package com.dictionary.work.Model;

/**
 * Класс для хранения параметров команды
 */
public class ModelOfCommand {

    private String key;
    private String value;
    private String pattern;

    /**
     * Метод сеттер для установки ключа команды
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Метод сеттер для установки значения команды
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Метод сеттер для установки паттерна команды
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Метод геттер для получения ключа для команды
     *
     * @return возвращает ключ
     */
    public String getKey() {
        return key;
    }

    /**
     * Метод геттер для получения значения для команды
     *
     * @return возвращает значение
     */
    public String getValue() {
        return value;
    }

    /**
     * Метод геттер для получения паттерна для команды
     *
     * @return возвращает паттерн
     */
    public String getPattern() {
        return pattern;
    }
}
