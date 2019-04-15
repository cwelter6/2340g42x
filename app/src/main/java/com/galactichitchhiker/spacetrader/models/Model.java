package com.galactichitchhiker.spacetrader.models;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

/**
 * Holds game object and loads and saves to file
 * 
 */
public final class Model {

    private Game game;
    private static Model model = new Model();

    /**
     * Singleton constructor
     */
    private Model() {
    }

    /**
     * Get Model instance
     * this getInstance() method allow other class to access the model
     * while still maintain its singleton property
     * If want to access data in model, just use Model.getInstance().getXXX()
     *
     * @return model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     * Initialize the game
     *
     * @param player          - Player object
     * @param difficultyLevel - game difficulty level
     */
    public void setGame(Player player, Game.GameDifficulty difficultyLevel) {
        game = new Game(player, difficultyLevel);
    }

    /**
     * Get game object
     *
     * @return Game
     */
    public Game getGame() {
        return game;
    }


    /**
     * Get set of solar systems
     *
     * @return Set<SolarSystem>
     */
    public Set<SolarSystem> getSolarSystems() {
        return game.getSolarSystems();
    }


    /**
     * Log output
     *
     * @param tag - Log tag
     * @param content - Log
     */
    public static void largeLog(String tag, String content) {
        int l = 4000;
        if (content.length() > l) {
            Log.d(tag, content.substring(0, l));
            largeLog(tag, content.substring(l));
        } else {
            Log.d(tag, content);
        }
    }

    /**
     * Load game object from file
     *
     * @param context - context
     * @return boolean - whether game was loaded
     */
    public static boolean loadGame(Context context) {

        Gson gson = new Gson();


        try {
            InputStream inputStream = context.openFileInput("savegame.json");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                receiveString = bufferedReader.readLine();
                while ( receiveString != null ) {
                    stringBuilder.append(receiveString);
                    receiveString = bufferedReader.readLine();
                }

                inputStream.close();

                model = gson.fromJson(stringBuilder.toString(), Model.class);

                Log.e("Load", "Loaded game!");

                return true;

            }
        }
        catch (FileNotFoundException e) {
            Log.e("Load", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Load", "Can not read file: " + e.toString());
        } catch (Exception e) {
            Log.e("Load", "Error while reading file: " + e.toString());
        }
        return false;

    }

    /**
     * Save game object to file
     *
     * @param context - Activity context
     * @return boolean - whether game was saved
     */
    public static boolean saveGame(Context context) {
        try {

            Gson gson = new Gson();

            String game = gson.toJson(model);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    context.openFileOutput("savegame.json", Context.MODE_PRIVATE));
            outputStreamWriter.write(game);
            outputStreamWriter.close();

            return true;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return false;
        }
    }

    /**
     * Get player X
     * @return int
     */
    public int getX() {
        return game.getX();
    }

    /**
     * Get player Y
     * @return int
     */
    public int getY() {
        return game.getY();
    }

    /**
     * Get current solar system
     * @return SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {
        return game.getCurrentSolarSystem();
    }

    /**
     * Get current fuel level
     *
     * @return double - fuel
     */
    public double getCurrentFuel() {
        return game.getCurrentFuel();
    }

    /**
     * Get max fuel level
     *
     * @return double - max fuel
     */
    public double getMaxFuel() {
        return game.getMaxFuel();
    }

    /**
     * Get credits
     *
     * @return int - credits
     */
    public int getCredits() {
        return game.getCredits();
    }


    /**
     * Get used cargo space
     *
     * @return int
     */
    public int getUsedCargoSpace() {
        return game.getUsedCargoSpace();
    }

    /**
     * Get max cargo space
     *
     * @return int
     */
    public int getMaxCargoSpace() {
        return game.getMaxCargoSpace();
    }

    /**
     * Get remaining cargo space
     *
     * @return int
     */
    public int getRemainingCargoSpace() {
        return game.getRemainingCargoSpace();
    }


    /**
     * Get tech level as int
     *
     * @return int
     */
    public int getTechLevelAsInt() {
        return game.getTechLevelAsInt();
    }

    /**
     * Give credits to player
     *
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        game.addCredits(add);
    }

    /**
     * Take credits from player
     *
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        game.subtractCredits(subtract);
    }

    /**
     * get the amount of cargo of type g we have
     * @param g the type of the trade good
     * @return the amount of type g good we have
     */
    public int getCargoAmountOf(TradeGoods g) {
        return game.getCargoAmountOf(g);
    }

    /**
     * add cargo
     * @param g the type of goods to be added
     * @param num the number of goods to be added
     */
    public void addCargoOf(TradeGoods g, int num) {

        game.addCargoOf(g, num);

    }

    /**
     * remove cargo
     * @param g the type of goods to be removed
     * @param num the number of goods to be removed
     */
    public void removeCargoOf(TradeGoods g, int num) {

        game.removeCargoOf(g, num);

    }

    /**
     * Get player's name
     *
     * @return String
     */
    public String getName() {
        return game.getName();
    }

    /**
     * Get pilot skill points
     *
     * @return int
     */
    public int getPilotPoints() {
        return game.getPilotPoints();
    }

    /**
     * Get engineer skill points
     *
     * @return int
     */
    public int getEngineerPoints() {
        return game.getEngineerPoints();
    }

    /**
     * Get trader skill points
     *
     * @return int
     */
    public int getTraderPoints() {
        return game.getTraderPoints();
    }

    /**
     * Get fighter skill points
     *
     * @return int
     */
    public int getFighterPoints() {
        return game.getFighterPoints();
    }

    /**
     * Get difficulty level as string
     *
     * @return String
     */
    public String getDifficultyLevelAsString() {
        return game.getDifficultyLevelAsString();
    }

    /**
     * Moves the player to another solar system
     *
     * @param s - solar system to travel to
     * @return String - message summarizing the travel
     */
    public String travel(SolarSystem s) {
        return game.travel(s);
    }

    /**
     * Determine if player has enough fuel to travel to a solar system
     *
     * @param s - solar system
     * @return boolean - whether the player can travel to the solar system
     */
    public boolean canTravelTo(SolarSystem s) {
        return game.canTravelTo(s);
    }

    /**
     * Get name of current solar system
     * @return String
     */
    public String getCurrentSolarSystemName(){
        return game.getCurrentSolarSystemName();
    }
}
