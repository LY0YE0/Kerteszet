/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import kertészet.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author PC
 */
public class Időjárás {
    public Object get() {
        try {
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=47.4984&longitude=19.0408&hourly=temperature_2m");
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(inputLine);
                JSONObject d = (JSONObject) jsonObject.get("hourly");
                JSONArray array = (JSONArray) d.get("temperature_2m");
                
                return array.get(array.size()-1) + " °C";
            }
            in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return "Nem elérhető!";
        } catch (ParseException ex) {
            Logger.getLogger(Időjárás.class.getName()).log(Level.SEVERE, null, ex);
            return "Nem elérhető!";
        }
        return 0 + " °C";
    }
}
