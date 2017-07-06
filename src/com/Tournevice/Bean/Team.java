package com.Tournevice.Bean;

/**
 * Created by mercier on 05/07/2017.
 */
public class Team {
    private int id;
    private String name;
    private String city;
    private String trainingOfficer;
    private int stadiumId;

    public Team(int id, String name, String city, String trainingOfficer, int stadiumId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.trainingOfficer = trainingOfficer;
        this.stadiumId = stadiumId;
    }

    public Team(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTrainingOfficer() {
        return trainingOfficer;
    }

    public void setTrainingOfficer(String trainingOfficer) {
        this.trainingOfficer = trainingOfficer;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }
}
