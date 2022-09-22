package com.dictionary.work.console;

import com.dictionary.work.config.DictionaryConfig;
import com.dictionary.work.console.commands.FactoryOfCommands;
import com.dictionary.work.console.commands.Invoker;
import com.dictionary.work.exeption.FileException;

import java.io.Console;
import java.util.Scanner;


/**
 * Класс для работы с пользователем через консоль, предоставляет пользователю выбор словаря и действий внутри него
 */

public class View {

    private static final String MAIN_MENU = "Выберете действие: \n1 - Словарь №1 \n2 - Словарь №2 \n0 - Выход из программы";
    private static final String DICTIONARY_MENU = "Выберете действие: \n1 - Просмотр всех пар слов \n2 - Добавить элемент (ключ:значение) \n3 - Удалить элемент (ключ) \n4 - Поиск по ключу (ключ) \n5 - Выйти из программы";
    private static final String MENU_EXCEPTION = "Выбран не существующий пункт!";
    private static int numberOfDictionary;
    private final DictionaryConfig dictionaryConfig;
    private final FactoryOfCommands factoryOfCommands;
    private static String pattern;
    static Scanner scanner;

    /**
     * Конструктор задает состояние объекта view необходимыми параметрами
     *
     * @param dictionaryConfig  объект для работы с правилами словарей
     * @param factoryOfCommands объект выбора исполняемой команды
     */
    public View(DictionaryConfig dictionaryConfig, FactoryOfCommands factoryOfCommands) {
        this.dictionaryConfig = dictionaryConfig;
        this.factoryOfCommands = factoryOfCommands;
    }

    /**
     * Метод обеспечивает ввод-вывод в консоль запросов для работы со словарем
     */
    public void startApp() {
        {
            try {
                System.out.println(MAIN_MENU);
                String userChoice = getInputWord();

                pattern = dictionaryConfig.getMapEntry(userChoice).getPattern();
                numberOfDictionary = Integer.parseInt(userChoice);
            } catch (NullPointerException e) {
                throw new FileException(MENU_EXCEPTION);
            }
        }
        while (true) {
            System.out.println(dictionaryConfig.getMapEntry(numberOfDictionary + "").getDescription());
            System.out.println(DICTIONARY_MENU);
            int userChoice = Integer.parseInt(getInputWord());
            try {
                for (Commands c : Commands.values()) {
                    if (c.getSerialNumberOfCommand() == userChoice) {
                        System.out.println(Invoker.executeCommand(factoryOfCommands.nameOfCommand(c)));
                        break;
                    }
                }
            } catch (FileException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод геттер возвращает номер выбранного словаря
     *
     * @return numberOfDictionary - номер выбранного словаря
     */
    public static int getNumberOfDictionary() {
        return numberOfDictionary;
    }

    /**
     * Метод геттер возвращает паттерн выбранного словаря
     *
     * @return pattern - паттерн выбранного словаря
     */
    public static String getPattern() {
        return pattern;
    }

    private static Scanner getScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        } else return scanner;
    }

    /**
     * Метод получения введенного слова
     *
     * @return возвращает метод для введения слова
     */
    public static String getInputWord() {
        return inputWord();
    }

    private static String inputWord() {
        Console console = System.console();
        if (console == null) {
            return getScanner().nextLine();
        } else {
            return console.readLine();
        }
    }
}
