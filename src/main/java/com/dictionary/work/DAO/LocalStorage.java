package com.dictionary.work.DAO;

import com.dictionary.work.exeption.FileException;
import org.springframework.stereotype.Component;

import java.io.*;

import static com.dictionary.work.console.View.getNumberOfDictionary;


/**
 * Класс реализует методы интерфейса InterfaceDictionary по работе с файлом
 */
@Component
public class LocalStorage implements Storage {
    private static final String CREATE_FILE_EXCEPTION = "Ошибка создания файла";
    private static final String WORDS_FILE = "words.txt";
    private static final String NUMBERS_FILE = "chisla.txt";
    private static final String TMP_FILE = "tmp";
    private static final int ONE_FOR_NUMBER_OF_DICTIONARY = 1;
    private static final int ONE_FOR_SPLIT = 1;
    private static final int ZERO_FOR_SPLIT = 0;
    private String nameFile;

    /**
     * Реализация метода добавления записи в файл, интерфейса InterfaceDictionary
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws FileException If a security manager exists and method denies write access to the file (SecurityException)
     *                       If an I/O error occurs(IOException)
     */
    @Override
    public void addElement(String key, String value) {
        try {
            FileWriter fileWriter = new FileWriter(createFile(), true);
            fileWriter.write(key + KEY_VALUE_SEPARATOR + value + "\n");
            fileWriter.close();
        } catch (SecurityException | IOException e) {
            throw new FileException(ADD_EXCEPTION);
        }
    }

    /**
     * Реализация метода вывода всех записей из файла, интерфейса InterfaceDictionary
     *
     * @return возвращает строку в которой содержаться все элементы
     * @throws FileException If an I/O error occurs(IOException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public StringBuilder outputAllElements() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();

                String value = parts[ONE_FOR_SPLIT].trim();
                if (!name.equals("") && !value.equals(""))
                    stringBuilder.append(name).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
            }
            bufferedReader.close();
            return stringBuilder;
        } catch (NullPointerException | IOException e) {
            throw new FileException(OUTPUT_ALL_EXCEPTION);
        }
    }

    /**
     * Реализация метода поиска записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @return true если элемент найден и false если нет
     * @throws FileException If an I/O error occurs(IOException)
     */
    @Override
    public boolean searchElement(String key) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (splitAndPartsString(line).equals(key)) {
                    return true;
                }
            }
            bufferedReader.close();
            return false;
        } catch (IOException e) {
            throw new FileException(SEARCH_EXCEPTION);
        }
    }

    /**
     * Реализация метода удаления записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     * @throws FileException If an I/O error occurs(IOException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       If a security manager exists and method denies write access to the file (SecurityException)
     */
    @Override
    public void deleteElement(String key) {
        File tmpFile = new File(TMP_FILE + nameFile);
        try {
            File file = createFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!splitAndPartsString(line).equals(key)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            file.delete();
            tmpFile.renameTo(file);

        } catch (NullPointerException | SecurityException | IOException e) {
            throw new FileException(DELETE_EXCEPTION);
        }
    }

    private String nameOfFile() {
        if (getNumberOfDictionary() == ONE_FOR_NUMBER_OF_DICTIONARY) {
            return nameFile = WORDS_FILE;
        } else return nameFile = NUMBERS_FILE;
    }

    private File createFile() throws IOException {
        File file = new File(nameOfFile());
        if (!file.exists() && !file.createNewFile()) {
            throw new FileException(CREATE_FILE_EXCEPTION);
        }
        return file;
    }

    private String splitAndPartsString(String line) {
        String[] parts = line.split(KEY_VALUE_SEPARATOR);
        String name = parts[ZERO_FOR_SPLIT].trim();
        return name;
    }
}
