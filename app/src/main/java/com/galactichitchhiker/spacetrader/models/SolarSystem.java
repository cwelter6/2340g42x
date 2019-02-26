package com.galactichitchhiker.spacetrader.models;

/**
 * Holds information for solar systems
 */
public class SolarSystem {

    private String name;

    private int x;
    private int y;

    private TechLevel techLevel;
    private Resources resources;

    /**
     * Constructs a new solar system
     * 
     * @param n  - name
     * @param x  - x coordinate
     * @param y  - y coordinate
     * @param tl - Tech level
     * @param r  - Resources
     */
    public SolarSystem(String n, int x, int y, TechLevel tl, Resources r) {
        name = n;
        this.x = x;
        this.y = y;
        techLevel = tl;
        resources = r;
    }

    /**
     * Constructs a new solar system with random tech level and random resources
     * 
     * @param n - name
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public SolarSystem(String n, int x, int y) {
        this(n, x, y, TechLevel.random(), Resources.random());
    }

    /**
     * Set name of solar system
     * 
     * @param n - name
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Get name of solar system
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set x coordinate
     * 
     * @param x - x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y coordinate
     * 
     * @param y - y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get x coordinate
     * 
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Get y coordinate
     * 
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Set tech level
     * 
     * @param tl - tech level
     */
    public void setTechLevel(TechLevel tl) {
        techLevel = tl;
    }

    /**
     * Get tech level
     * 
     * @return TechLevel
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Set resources
     * 
     * @param r - Resources
     */
    public void setResources(Resources r) {
        resources = r;
    }

    /**
     * Get resources
     * 
     * @return Resources
     */
    public Resources getResources() {
        return resources;
    }

}