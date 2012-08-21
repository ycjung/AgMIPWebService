/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aceui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author yunj
 */
public class ACEMetaDataDAO {
    
    JsonData data;
    public ACEMetaDataDAO(){
        /*
        try{
            String path = new File(".").getCanonicalPath();
            System.out.println(path);//E:\NetbeansProjects\AgMIP Group\AgMIPWebService
        }catch(Exception e){
            e.printStackTrace();
        }
        */
        /*
        //String filePath = "./web/simplemetadata.json";
        String filePath = "";
        data = new JsonData(filePath);
        System.out.println(data.getListData().size());
        */
    }
    
    public void exportData(String jsonquery){
        // example : var query = {"datakey":[], "model":[]};
        //jsonquery = "{\"datakey\":[\"Sahelian_Center_Niger\", \"TILLABERY_\"], \"model\":[\"APSIM\", \"AquaCrop\", \"DSSAT\", \"STICS\", \"WOFOST\"]}";
        try{
            JSONParser parser = new JSONParser();        
            //JSONObject jobj = (JSONObject)parser.parse(sampleInput);
            JSONObject jobj = (JSONObject)parser.parse(jsonquery);
            
            List<String> datakeyList = new ArrayList();
            JSONArray msg = (JSONArray) jobj.get("datakey");
            //Iterator<String> iterator = msg.iterator();
            Iterator<Object> iterator = msg.iterator();
            while (iterator.hasNext()) {
                //System.out.println("what? " + iterator.next());
                datakeyList.add(iterator.next().toString());
            }
            
            List<String> modelList = new ArrayList();
            JSONArray msg2 = (JSONArray) jobj.get("model");
            //Iterator<String> iterator = msg.iterator();
            Iterator<Object> iterator2 = msg2.iterator();
            while (iterator2.hasNext()) {
                //System.out.println("what? " + iterator2.next());
                modelList.add(iterator2.next().toString());
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * String sampleInput = "{\"country\":\"country\", \"lon\":\"40.0\", \"lat\":\"40.1\", \"crop\":\"crop\", \"plantyear\":\"plantyear\", \"harvestyear\":\"harvestyear\"}";
     * @param jsonfilterlist
     * @return 
     */
    public List<ACEMetaData> search(String jsonfilterlist){
        List<ACEMetaData> result = new ArrayList();
        System.out.println(jsonfilterlist);
        //String sampleInput = "{\"country\":\"country\", \"lon\":\"40.0\", \"lat\":\"40.1\", \"crop\":\"crop\", \"plantyear\":\"plantyear\", \"harvestyear\":\"harvestyear\"}";
        //String sampleInput = "{\"country\":\"Niger\", \"lon\":\"\", \"lat\":\"\", \"crop\":\"\", \"plantyear\":\"\", \"harvestyear\":\"\"}";
        try{
            JSONParser parser = new JSONParser();        
            //JSONObject jobj = (JSONObject)parser.parse(sampleInput);
            JSONObject jobj = (JSONObject)parser.parse(jsonfilterlist);
            String country = (String)jobj.get("country");
            String lons = (String)jobj.get("lon");
            String lats = (String)jobj.get("lat");
            String crop = (String)jobj.get("crop");
            String plantyear = (String)jobj.get("plantyear");
            String harvestyear = (String)jobj.get("harvestyear");
            
            //System.out.println(country+"/"+lons+"/"+lats+"/"+crop+"/"+plantyear+"/"+harvestyear);
            
            List<ACEMetaData> data = this.getListData();
            boolean dirtyFlag = false;
            float lonbuffer = 5.0f;
            float latbuffer = 5.0f;
            boolean isNeedStop = false;
            //System.out.println("size : "+data.size());
            //for(ACEMetaData d : data){
            //Iterator<ACEMetaData> iterator = data.iterator();
            for(int i=0; i<data.size();i++){
                for(int j = 0; j<1;j++){
            //while(iterator.hasNext()){
                //ACEMetaData d = iterator.next();
                ACEMetaData d = data.get(i);    
                //System.out.println("country ; "+d.getCountry());
                dirtyFlag = false;
                // location category : country, lon/lat - Or search
                if( !country.equals("") || !lons.equals("") ){
                    // country
                    if( !country.equals("") ){
                        if ( !country.equals(d.getCountry()) ){

                        }else{
                            dirtyFlag = true;
                        }
                    }
                    // lon/lat
                    if( !lons.equals("") ){
                        float dlon = d.getLon();
                        float dlat = d.getLat();
                        float lon = Float.parseFloat(lons);
                        float lat = Float.parseFloat(lats);
                        if( (dlon < lon+lonbuffer) && (dlon > lon-lonbuffer) 
                                && (dlat < lat+latbuffer) && (dlat > lat-latbuffer) ){
                                dirtyFlag = true;
                        }
                    }
                    // 'Or' search
                    if(!dirtyFlag) {
                            //_clearSearchResults();
                            break;				
                    }
                }
                // crop
                if(!crop.equals("")){
                    if( !crop.equals("") ){
                        if ( !crop.equals(d.getCrop()) ){
                            //_clearSearchResults();
                            break;
                        }else{
                            dirtyFlag = true;
                        }
                    }
                }
                
                // year : planting / harvesting - Or search
                if( !plantyear.equals("") || !harvestyear.equals("") ){
                    isNeedStop = true;// search 'planting year' or 'harvesting year'
                    // planting year
                    if( !plantyear.equals("") ){
                        if ( !plantyear.equals(d.getPlantingyear()) ){

                        }else{
                            dirtyFlag = true;
                            isNeedStop = false;
                        }
                    }
                    // harvest year
                    if( !harvestyear.equals("") ){
                        if ( !harvestyear.equals(d.getHarvestyear()) ){

                        }else{
                            dirtyFlag = true;
                            isNeedStop = false;
                        }
                    }                    
                    // 'Or' search
                    if(isNeedStop){
                        //_clearSearchResults();
                        break;
                    }	
                }
                
                //add searched data
                if(dirtyFlag) {
                    //System.out.println("reach here?");
                    //jsonString += d.toJSONElementString();
                    result.add(d);
                }
            }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return result;
    }
    
    public boolean getReady(){
        boolean flag = false;
        //String filePath = "./web/simplemetadata.json";
        String filePath = "";
        if(data != null) return true;
        
        data = new JsonData(filePath);
        //System.out.println(data.getListData().size());
        if(data.getListData().size() > 0)
            flag = true;
        return flag;
    }
    
    public List<ACEMetaData> getListData(){
        return data.getListData();
    }
    
    public List<String> getCountryList(){
        List data = new ArrayList();
        List<ACEMetaData> srcData = getListData();
        Hashtable hash = new Hashtable();
        String key;
        // duplication check
        for(ACEMetaData mdata : srcData){
            key = mdata.getCountry().trim();
            //System.out.println("key : " + key);
            if(!hash.containsKey(key)){
                hash.put(key, key);
                data.add(key);
            }
        }
        // sort
        Object[] sdata = data.toArray();
        Arrays.sort(sdata);
        data = Arrays.asList(sdata);
        return data;
    }
    
    public List<String> getCropList(){
        List data = new ArrayList();
        List<ACEMetaData> srcData = getListData();
        Hashtable hash = new Hashtable();
        String key;
        // duplication check
        for(ACEMetaData mdata : srcData){
            key = mdata.getCrop().trim();
            //System.out.println("key : " + key);
            if(!hash.containsKey(key)){
                hash.put(key, key);
                data.add(key);
            }
        }
        // sort
        Object[] sdata = data.toArray();
        Arrays.sort(sdata);
        data = Arrays.asList(sdata);
        return data;
    }
    
    public static void main(String[] args){
        //System.out.println("test?");
        ACEMetaDataDAO dao = new ACEMetaDataDAO();
        dao.getReady();
        //dao.getCountryList();
        //dao.search("");
        dao.exportData("");
    }
    
}
