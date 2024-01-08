package ru.jucharick;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    //region Поля
    public static final String FILE_JSON = "persons_journal.json";
    public static final String FILE_BIN = "persons_journal.bin";
    public static final String FILE_XML = "persons_journal.xml";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final XmlMapper xmlMapper = new XmlMapper();
    //endregion

    //region Методы
    public static void saveJournalToFile(String fileName, List<Person> persons) {
        try {
            if (fileName.endsWith(".json")) {
                try(FileWriter writer = new FileWriter(new File(fileName),true)) {
                    writer.write(gson.toJson(persons));
                    writer.flush();
                }
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(persons);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), persons);
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static List<Person> loadJournalFromFile(String fileName) {
        List<Person> persons = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    JsonReader jsonReader = new JsonReader(new FileReader(fileName));
                    Type type = new TypeToken<ArrayList<Person>>() {}.getType();
                    persons = gson.fromJson(jsonReader, type);
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        persons = (List<Person>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    xmlMapper.writeValue(new File(fileName), persons);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return persons;
    }

    public static void displayJournal(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            System.out.println((i + 1) + person.toString());
        }
    }
    //endregion
}

