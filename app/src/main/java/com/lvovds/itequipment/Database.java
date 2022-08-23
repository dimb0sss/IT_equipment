package com.lvovds.itequipment;

import java.util.ArrayList;

public class Database {
    private static ArrayList<String> processors = new ArrayList<>();

    public static Database getInstance() {
        if (instance ==null) {
            instance = new Database();
            instance.add("Выбор модели процессора");
            instance.add("Добавить запись");
        }
        return instance;
    }

    public void add(String name) {
        processors.add(name);
    }

    public ArrayList<String> getProcessors() {
        return new ArrayList<>(processors);
    }

    private static Database instance = null;
}
