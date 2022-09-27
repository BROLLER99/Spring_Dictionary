package com.dictionary.console;

import com.dictionary.model.ModelOfCommand;
import com.dictionary.config.DictionaryConfig;
import com.dictionary.console.commands.FactoryOfCommands;
import com.dictionary.console.commands.Invoker;
import com.dictionary.exeption.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;


/**
 * Класс для работы с пользователем через консоль, предоставляет пользователю выбор словаря и действий внутри него
 */
@Component
public class View {

    private static final String MAIN_MENU = "Выберете действие: \n1 - Словарь №1 \n2 - Словарь №2 \n0 - Выход из программы";
    private static final String DICTIONARY_MENU = "Выберете действие: \n1 - Просмотр всех пар слов \n2 - Добавить элемент (ключ:значение) \n3 - Удалить элемент (ключ) \n4 - Поиск по ключу (ключ) \n5 - Выйти из программы";
    private static final String MENU_EXCEPTION = "Выбран не существующий пункт!";
    private static final String WRITE_EXCEPTION = "Ошибка ввода";
    private static final String WRITE_KEY_WORD = "Введите ключ";
    private static final String WRITE_VALUE_WORD = "Введите значение";
    private final static String ZERO_FOR_EXIT = "0";
    private static int numberOfDictionary;
    private final DictionaryConfig dictionaryConfig;
    private final FactoryOfCommands factoryOfCommands;
    static Scanner scanner;

    /**
     * Конструктор задает состояние объекта view необходимыми параметрами
     *
     * @param dictionaryConfig  объект для работы с правилами словарей
     * @param factoryOfCommands объект выбора исполняемой команды
     */
    @Autowired
    public View(DictionaryConfig dictionaryConfig, FactoryOfCommands factoryOfCommands) {
        this.dictionaryConfig = dictionaryConfig;
        this.factoryOfCommands = factoryOfCommands;
    }

    /**
     * Метод обеспечивает ввод-вывод в консоль запросов для работы со словарем
     *
     * @throws CustomException - кастомное исключение для обработки исключений возникающих в методе startApp
     */
    public void startApp() throws CustomException {
        try {
            ModelOfCommand modelOfCommand = new ModelOfCommand();
            String pattern = mainMenu();
            while (true) {
                System.out.println(dictionaryConfig.getMapEntry(numberOfDictionary + "").getDescription());
                System.out.println(DICTIONARY_MENU);

                int userChoice = userChoiceToInt();
                for (Commands c : Commands.values()) {
                    if (c.getSerialNumberOfCommand() == userChoice) {
                        if (c.getNeedKey()) {
                            System.out.println(WRITE_KEY_WORD);
                            modelOfCommand.setKey(getInputWord());
                        }
                        if (c.getNeedValue()) {
                            System.out.println(WRITE_VALUE_WORD);
                            modelOfCommand.setValue(getInputWord());
                        }
                        modelOfCommand.setPattern(pattern);
                        System.out.println(Invoker.executeCommand(factoryOfCommands.nameOfCommand(c, modelOfCommand)));
                        break;
                    }
                }
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
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

    private static Scanner getScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        } else return scanner;
    }

    /**
     * Метод получения введенного слова
     *
     * @return возвращает метод для введения слова
     * @throws CustomException - кастомное исключение для обработки исключений метода inputWord()
     */
    public String getInputWord() throws CustomException {
        return inputWord();
    }

    private static String inputWord() throws CustomException {
        try {
            Console console = System.console();
            if (console == null) {
                return getScanner().nextLine();
            } else {
                return console.readLine();
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            throw new CustomException(WRITE_EXCEPTION);
        }
    }

    private String mainMenu() throws CustomException {
        String pattern;
        try {
            System.out.println(MAIN_MENU);
            String userChoice = getInputWord();
            if (Objects.equals(userChoice, ZERO_FOR_EXIT)) {
                System.exit(Integer.parseInt(ZERO_FOR_EXIT));
            }
            pattern = dictionaryConfig.getMapEntry(userChoice).getPattern();
            numberOfDictionary = Integer.parseInt(userChoice);
        } catch (CustomException | NumberFormatException | NullPointerException e) {
            throw new CustomException(MENU_EXCEPTION);
        }
        return pattern;
    }

    private int userChoiceToInt() throws CustomException {
        try {
            return Integer.parseInt(getInputWord());
        } catch (NumberFormatException e) {
            throw new CustomException(MENU_EXCEPTION);
        }
    }
}
