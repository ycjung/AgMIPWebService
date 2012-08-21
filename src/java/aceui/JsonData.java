/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aceui;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yunj
 */
public class JsonData {
    
    private String file = "http://localhost:8080/AgMIPWebService/simplemetadata.json";
    private JSONObject jsonObject = null;
    private List<ACEMetaData> aceListData = null;
    
    public JsonData(String filePath){
        //if(filePath.length()>0)
        //    file = filePath;
        
        loadData();
    }
    
    public List<ACEMetaData> getListData(){
        return aceListData;
    }
    
    private void loadData(){
        JSONParser parser = new JSONParser();
        try{
            //Object obj = parser.parse(new FileReader(file));            
            //Object obj = parser.parse(new FileReader(new File(new URL(file).toURI())));
            Object obj = parser.parse(new InputStreamReader(new URL(file).openStream(), "UTF-8"));
            jsonObject = (JSONObject)obj;
            aceListData = new ArrayList();
            ACEMetaData aceData;
            //System.out.println(jsonObject.toJSONString());
            
            JSONArray msg = (JSONArray) jsonObject.get("features");
            //Iterator<String> iterator = msg.iterator();
            Iterator<Object> iterator = msg.iterator();
            int counter = 0;
            while (iterator.hasNext()) {
                //System.out.println(iterator.next().toString());

                JSONObject data = (JSONObject) iterator.next();
                data = (JSONObject)data.get("properties");
                //System.out.println(data.toJSONString());
                
                aceData = new ACEMetaData();
                aceData.setDatakey((String)data.get("datakey"));
                //System.out.println(aceData.getDatakey());
                //aceData.setFieldloc((String)data.get("fieldloc"));
                JSONArray msg2 = (JSONArray) data.get("fieldloc");
                //System.out.println(data.get("fieldloc"));
                Object[] value = msg2.toArray();                
                aceData.setLon(Float.parseFloat(value[0].toString()));
                aceData.setLat(Float.parseFloat(value[1].toString()));
                //System.out.println(aceData.getLon()+"/"+aceData.getLat());
                
                
                aceData.setCountry((String)data.get("Country"));
                aceData.setState((String)data.get("State"));
                aceData.setCity((String)data.get("City"));
                
                aceData.setInstitute((String)data.get("Institute"));
                aceData.setData_source((String)data.get("Data_source"));
                aceData.setData_source_version((String)data.get("Data_source_version"));
                
                aceData.setCrop((String)data.get("Crop"));
                aceData.setPlantingyear((String)data.get("PlantingYear"));
                aceData.setHarvestyear((String)data.get("HarvestYear"));
                
                aceData.setSoiltexture((String)data.get("SoilTexture"));
                aceData.setWeastat((String)data.get("WeaStat"));
                aceData.setCultivarid((String)data.get("CultivarID"));
                aceData.setSoilid((String)data.get("SoilID"));
                aceData.setSoilsource((String)data.get("SoilSource"));
                //System.out.println(aceData.toJSONElementString());
                aceListData.add(aceData);
            }
                
            /*
                String name = (String) jsonObject.get("name");
		System.out.println(name);
 
		long age = (Long) jsonObject.get("age");
		System.out.println(age);
 
		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("messages");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
             */
            
        }catch(FileNotFoundException e){
            e.printStackTrace();            
        }catch(IOException e){
            e.printStackTrace();            
        }catch(ParseException e){
            e.printStackTrace();            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
