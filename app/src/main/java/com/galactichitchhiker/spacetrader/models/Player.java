package com.galactichitchhiker.spacetrader.models;

public class Player {

    private String name;

    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;

    private int credits;

    public Player(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints) {

        this.name = name;

        this.pilotPoints = pilotPoints;
        this.engineerPoints = engineerPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;

        credits = 1000;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public void addCredits(int add) {
        this.credits += add;
    }

    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    public int getCredits() {
        return credits;
    }

}
