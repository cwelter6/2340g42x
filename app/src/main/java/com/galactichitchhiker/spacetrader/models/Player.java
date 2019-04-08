package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds player information and all getter and setter methods
 *
 */
public class Player {

    private String name;

    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private final int MAXIMUM_SKILL_POINTS = 16;

    private int credits;

    private Ship currentShip;
    private List<Ship> ownedShips;

    private SolarSystem currentSolarSystem;

    /**
     * Creates a player object
     *
     * @param name           - Player's name
     * @param pilotPoints    - pilot skill points
     * @param engineerPoints - engineer skill points
     * @param traderPoints   - trader skill points
     * @param fighterPoints  - fighter skill points
     */
    public Player(String name, int pilotPoints, int engineerPoints, int traderPoints,
                  int fighterPoints) {

        this.name = name;

        this.pilotPoints = pilotPoints;
        this.engineerPoints = engineerPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;

        credits = 1000;

        currentShip = new Ship();
        ownedShips = new ArrayList<Ship>();
        ownedShips.add(currentShip);

    }

    /**
     * Get player's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set player's name
     *
     * @param name Player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get pilot skill points
     *
     * @return int
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Get engineer skill points
     *
     * @return int
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Get trader skill points
     *
     * @return int
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Get fighter skill points
     *
     * @return int
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Set pilot skill points
     *
     * @param pilotPoints
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * Set engineer skill points
     *
     * @param engineerPoints
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * Set trader skill points
     *
     * @param traderPoints
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * Set fighter skill points
     *
     * @param fighterPoints
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * Get maximum sum of skill points for player
     *
     * @return int
     */
    public int getMaximumSkillPoints() {
        return MAXIMUM_SKILL_POINTS;
    }

    /**
     * Give credits to player
     *
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        this.credits += add;
    }

    /**
     * Take credits from player
     *
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    /**
     * Get number of player's credits
     *
     * @return credits - int
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Get player's current ship
     *
     * @return Ship
     */
    public Ship getCurrentShip() {
        return currentShip;
    }

    /**
     * Set player's current ship
     *
     * @param ship
     */
    public void setCurrentShip(Ship ship) {
        this.currentShip = ship;
    }

    /**
     * Get list of all player's owned ships
     *
     * @return List<Ship>
     */
    public List<Ship> getOwnedShips() {
        return ownedShips;
    }

    /**
     * Add ship to player's list of ships
     *
     * @param ship
     */
    public void addShip(Ship ship) {
        ownedShips.add(ship);
    }

    /**
     * Get player's current solar system
     *
     * @return SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * Set player's current solar system
     *
     * @param s player's new solar system
     */
    public void setCurrentSolarSystem(SolarSystem s) {
        this.currentSolarSystem = s;
    }

    /**
     * Get player's x coordinate
     *
     * @return int
     */
    public int getX() {
        return currentSolarSystem.getX();
    }

    /**
     * Get player's y coordinate
     *
     * @return int
     */
    public int getY() {
        return currentSolarSystem.getY();
    }

    /**
     * Moves the player to another solar system
     *
     * @param s - solar system to travel to
     * @return String - message summarizing the travel
     */
    public String travel(SolarSystem s) {
        if (canTravelTo(s)) {
            currentShip.subtractFuel(distanceTo(s.getX(), s.getY())/10);
            setCurrentSolarSystem(s);


            if (Math.random()*100 < 50) {

                credits += 100;
                return "Traveled to " + s.getName() + " and found 100 credits!";

            }


            return "Traveled to " + s.getName();
        } else {
            return "Not enough fuel!";
        }
    }

    /**
     * Determine if player has enough fuel to travel to a solar system
     *
     * @param s - solar system
     * @return boolean - whether the player can travel to the solar system
     */
    public boolean canTravelTo(SolarSystem s) {
        return currentShip.getFuel() >= distanceTo(s.getX(), s.getY())/10;
    }


    /**
     * Calculate the distance from the player to a certain coordinate
     *
     * @param finalX - x coord of destination
     * @param finalY - y coord of destination
     * @return double - distance to destination
     */
    private double distanceTo(int finalX, int finalY) {
        int distanceX = finalX - getX();
        int distanceY = finalY - getY();
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
    }


    /**
     * Get current fuel level
     *
     * @return double - fuel
     */
    public double getCurrentFuel() {
        return currentShip.getFuel();
    }

    /**
    * Get max fuel level
    *
    * @return double - max fuel
    */
    public double getMaxFuel() {
        return currentShip.getFuelCapacity();
    }

    /**
    * Get used cargo space
    *
    * @return int
    */
    public int getUsedCargoSpace() {
       return currentShip.getUsedCargoSpace();
    }

    /**
    * Get max cargo space
    *
    * @return int
    */
    public int getMaxCargoSpace() {
       return currentShip.getMaxCargoSpace();
    }

    /**
    * Get remaining cargo space
    *
    * @return int
    */
    public int getRemainingCargoSpace() {
       return currentShip.getRemainingCargoSpace();
    }

    /**
    * Get tech level as int
    *
    * @return int
    */
    public int getTechLevelAsInt() {
       return currentSolarSystem.getTechLevel().ordinal();
    }

   /**
     * get the amount of cargo of type g we have
     * @param g the type of the trade good
     * @return the amount of type g good we have
     */
    public int getCargoAmountOf(TradeGoods g) {
        return currentShip.getCargoAmountOf(g);
    }

    /**
     * add cargo
     * @param g the type of goods to be added
     * @param num the number of goods to be added
     */
    public void addCargoOf(TradeGoods g, int num) {

        currentShip.addCargoOf(g, num);

    }

    /**
     * remove cargo
     * @param g the type of goods to be removed
     * @param num the number of goods to be removed
     */
    public void removeCargoOf(TradeGoods g, int num) {

        currentShip.removeCargoOf(g, num);

    }

    /**
     * Get name of current solar system
     * @return String
     */
    public String getCurrentSolarSystemName(){
        return currentSolarSystem.getName();
    }

}
