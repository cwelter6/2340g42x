package com.galactichitchhiker.spacetrader.models;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

/**
 * Holds game object
 * 
 */
public class Model {

    private Game game;
    private static Model model = new Model();
    /* create a new model here to allow other classes access model without
    * having to create one themselves (which breaks the singleton property)
    */

    private Model() {
        /*Model here is a singleton here. We want global access to it, 
        but we also want this class to be the only one that could create it. 
        That is why we are making the constructor private, then have a getInstance()
        method to access it*/
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
     * initialize the data
     *
     * @param player          - Player object
     * @param difficultyLevel - game difficulty level
     */
    public void setGame(Player player, Game.GameDifficulty difficultyLevel) {
        game = new Game(player, difficultyLevel);
    }

    public Game getGame() {
        return game;
    }

    public Set<SolarSystem> getSolarSystems() {
        return game.getSolarSystems();
    }


    /**
     * Log output
     * @param tag
     * @param content
     */
    public static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }

    public static boolean loadGame(Context context) {

        Gson gson = new Gson();


        try {
            InputStream inputStream = context.openFileInput("savegame.json");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
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

    public static boolean saveGame(Context context) {
        try {

            Gson gson = new Gson();

            String game = gson.toJson(model);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("savegame.json", Context.MODE_PRIVATE));
            outputStreamWriter.write(game);
            outputStreamWriter.close();

            return true;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return false;
        }
    }
    
}
