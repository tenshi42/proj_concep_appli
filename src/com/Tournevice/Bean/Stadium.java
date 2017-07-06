package com.Tournevice.Bean;

/**
 * Created by mercier on 06/07/2017.
 */
public class Stadium {
    private int id;
    private String Name;
    private int capacity;

    public Stadium() {
    }

    public Stadium(int id, String name, int capacity) {
        this.id = id;
        Name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
