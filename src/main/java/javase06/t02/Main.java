package javase06.t02;

import java.util.*;


//Создать “универсальный” класс, позволяющий получить значение
//        из любого properties- файла.
//Физическое чтение файла должно происходить только один раз.
//Результаты чтения храните в коллекции типа Map.
//Ответьте на вопрос:
//как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?

public class Main {

    public static void main(String[] args)
    {
        Logic logic = new Logic();
        logic.addPropFile("test.properties");

    }
}
