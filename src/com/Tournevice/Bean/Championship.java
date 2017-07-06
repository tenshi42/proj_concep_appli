package com.Tournevice.Bean;

/**
 * Created by mercier on 06/07/2017.
 */
public class Championship {
    private int id;
    private String name;
    private int countryId;
    private int pointsOnWin;
    private int pointsOnNul;
    private int pointsOnLose;

    public Championship() {
    }

    public Championship(int id, String name, int countryId, int pointsOnWin, int pointsOnNul, int pointsOnLose) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.pointsOnWin = pointsOnWin;
        this.pointsOnNul = pointsOnNul;
        this.pointsOnLose = pointsOnLose;
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getPointsOnWin() {
        return pointsOnWin;
    }

    public void setPointsOnWin(int pointsOnWin) {
        this.pointsOnWin = pointsOnWin;
    }

    public int getPointsOnNul() {
        return pointsOnNul;
    }

    public void setPointsOnNul(int pointsOnNul) {
        this.pointsOnNul = pointsOnNul;
    }

    public int getPointsOnLose() {
        return pointsOnLose;
    }

    public void setPointsOnLose(int pointsOnLose) {
        this.pointsOnLose = pointsOnLose;
    }
}
