package com.dictionary;

import com.dictionary.work.config.DictionaryConfig;
import com.dictionary.work.console.View;
import com.dictionary.work.console.commands.FactoryOfCommands;
import static com.dictionary.work.config.StorageConfig.createStorage;


/**
 * Точка входа в программу
 */
public class Main {
    /**
     * Запуск консольного приложения и создание объектов для работы с ним
     *
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        FactoryOfCommands factoryOfCommands = new FactoryOfCommands(createStorage(args));
        DictionaryConfig dictionaryConfig = new DictionaryConfig();
        View view = new View(dictionaryConfig, factoryOfCommands);
        view.startApp();
    }
}