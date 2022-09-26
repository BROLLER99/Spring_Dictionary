package com.dictionary;

import com.dictionary.config.SpringConfig;
import com.dictionary.console.View;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        View view = (View) context.getBean("view");
        view.startApp();
    }
}