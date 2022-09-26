package com.dictionary.console.commands;

/**
 * Класс реализует метод интерфейса Command выход из программы
 */
public class ExitCommand implements Command<String> {
    private final static int ZERO_FOR_EXIT = 0;

    /**
     * Реализация метода выполнения команды(выхода из программы) интерфейса Command
     */
    @Override
    public String execute() {
        System.exit(ZERO_FOR_EXIT);
        return null;
    }
}
