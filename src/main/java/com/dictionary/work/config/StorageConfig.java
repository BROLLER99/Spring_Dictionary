package com.dictionary.work.config;

import com.dictionary.work.DAO.Storage;
import com.dictionary.work.DAO.LocalStorage;
import com.dictionary.work.DAO.RunTimeStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс определяет тип хранилища для словаря
 */
@Component
public class StorageConfig {
    private static final int MORE_THAN_ZERO_ARGUMENTS_ON_THE_COMMAND_LINE = 1;
    private static final int ZERO_ARGUMENTS_ON_THE_COMMAND_LINE = 0;

    /**
     * Метод определяет тип хранения словаря в зависимости от наличия аргументов командной строки
     *
     * @param args аргументы командной строки
     * @return Создает локальный словарь, если есть аргументы командной строки и runtime словарь, если их нет
     */
    public static Storage createStorage(String[] args) {
        if (parsCommandLineArgs(args) == MORE_THAN_ZERO_ARGUMENTS_ON_THE_COMMAND_LINE) {
            return new LocalStorage();
        } else {
            return new RunTimeStorage();
        }
    }

    private static int parsCommandLineArgs(String[] args) {
        if (args.length > ZERO_ARGUMENTS_ON_THE_COMMAND_LINE) {
            return MORE_THAN_ZERO_ARGUMENTS_ON_THE_COMMAND_LINE;
        } else {
            return ZERO_ARGUMENTS_ON_THE_COMMAND_LINE;
        }
    }
}
