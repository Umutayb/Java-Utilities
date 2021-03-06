package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import java.io.IOException;
import org.junit.Assert;
import java.io.*;

public class JsonUtilities {

    public JSONObject urlsJson = new JSONObject();
    public JSONObject notificationJson = new JSONObject();
    private final Printer log = new Printer(JsonUtilities.class);
    FileUtilities fileUtil = new FileUtilities();

    public void saveJson(JSONObject inputJson, String directory){
        try {

            //JSONParser parser = new JSONParser();

            //JSONObject object = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("src/test/java/resources/database/"+"Getir"+".JSON")));

            FileWriter file = new FileWriter(directory);

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputJson);

            if(file.toString().isEmpty())
                file.write(String.valueOf(json));
            else
                file.append(String.valueOf(json));

            file.close();

        }catch (Exception gamma){
            Assert.fail(String.valueOf(gamma));
        }

    }

    public JsonObject parseJsonFile(String directory) {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonElement object;

            FileReader fileReader = new FileReader(directory);

            object = jsonParser.parse(fileReader);
            JsonObject jsonObject = (JsonObject) object;

            assert jsonObject != null;

            return jsonObject;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public JSONObject parseJSONFile(String distance) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject object;

        FileReader fileReader = new FileReader(distance);

        object = (JSONObject) jsonParser.parse(fileReader);
        JSONObject jsonObject = object;

        assert jsonObject != null;

        return jsonObject;

    }

    public JsonObject getJsonObject(JsonObject json, String key){

        JsonObject jsonObject = json.get(key).getAsJsonObject();

        assert jsonObject != null;

        return jsonObject;
    }

    public String getElementAttribute(JsonObject attributes, String attributeType){

        return attributes.get(attributeType).getAsString();

    }

    public JSONObject str2json(String inputString){
        JSONObject object = null;
        try {
            JSONParser parser = new JSONParser();
            object = (JSONObject) parser.parse(inputString);
        }
        catch (Exception gamma){
            //log.new Warning(gamma.fillInStackTrace());
        }
        return object;
    }

    public String formatJsonString(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object jsonObject = mapper.readValue(json, Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        }
        catch (IOException e) {e.printStackTrace();}
        return null;
    }

}