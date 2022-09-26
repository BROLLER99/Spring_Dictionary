package com.dictionary.console.commands;

/**
 * Класс для выполнения команд словаря
 */
public class Invoker {
    /**
     * Метод исполнения команды
     *
     * @param command - объект исполняемой команды
     * @return вызов метода выполнения команды
     */
    public static <T> T executeCommand(Command<T> command) {
        return command.execute();
    }
}
