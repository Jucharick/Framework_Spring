package ru.jucharick;
/*
Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
Задание:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ru.jucharick.Journal.*;

public class Program {
    public static void main(String[] args) {
        List<Person> persons;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            persons = loadJournalFromFile(FILE_JSON);
        else {
            persons = preparePersons();
            Journal.saveJournalToFile(FILE_JSON, persons);
            Journal.saveJournalToFile(FILE_BIN, persons);
            Journal.saveJournalToFile(FILE_XML, persons);
        }

        displayJournal(persons);
        System.out.println("toString()");
        System.out.println(persons.get(1));
    }

    public static List<Person> preparePersons() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Иван","Иванов", 21));
        list.add(new Person("Петр","Петров", 18));
        list.add(new Person("Родион","Раскольников", 27));
        list.add(new Person("Остап","Бендер", 27));
        //list.add(new Person("Бильбо","Бэггинс", 135));
        return list;
    }
}
