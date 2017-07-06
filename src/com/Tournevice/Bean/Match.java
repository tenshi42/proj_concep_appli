package com.Tournevice.Bean;

/**
 * Created by mercier on 06/07/2017.
 */
public class Match {
    private int id;
    private int teamExtId;
    private int teamDomId;
    private int scoreExt;
    private int scoreDom;
    private int stadiumId;
    private int championshipId;

    public Match() {
    }

    public Match(int id, int teamExtId, int teamDomId, int scoreExt, int scoreDom, int stadiumId, int championshipId) {
        this.id = id;
        this.teamExtId = teamExtId;
        this.teamDomId = teamDomId;
        this.scoreExt = scoreExt;
        this.scoreDom = scoreDom;
        this.stadiumId = stadiumId;
        this.championshipId = championshipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamExtId() {
        return teamExtId;
    }

    public void setTeamExtId(int teamExtId) {
        this.teamExtId = teamExtId;
    }

    public int getTeamDomId() {
        return teamDomId;
    }

    public void setTeamDomId(int teamDomId) {
        this.teamDomId = teamDomId;
    }

    public int getScoreExt() {
        return scoreExt;
    }

    public void setScoreExt(int scoreExt) {
        this.scoreExt = scoreExt;
    }

    public int getScoreDom() {
        return scoreDom;
    }

    public void setScoreDom(int scoreDom) {
        this.scoreDom = scoreDom;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public int getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(int championshipId) {
        this.championshipId = championshipId;
    }
}
