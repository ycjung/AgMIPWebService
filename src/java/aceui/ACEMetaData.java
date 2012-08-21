/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aceui;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yunj
 */
@XmlRootElement
public class ACEMetaData {
    
    private float lon;
    private float lat;
    private String datakey;
    private String fieldloc;
    private String country;
    private String state;
    private String city;
    private String institute;
    private String data_source;
    private String data_source_version;
    private String crop;
    private String plantingyear;
    private String harvestyear;
    private String soiltexture;
    private String weastat;
    private String cultivarid;
    private String soilid;
    private String soilsource;
    
    public ACEMetaData(){}

    public String toJSONElementString(){
        String json="";
        /* example
          { "type": "Feature", "geometry": {"type": "Point", "coordinates": [-60.549,-33.929]},
            "properties": {"datakey":"PERGAMINO",
                             "fieldloc":[-60.549,-33.929],
                             "Country":"Argentina",
                             "State":"",
                             "City":"PERGAMINO",
                             "Institute":"University of Florida, Gainesville, FL.USA",
                             "Data_source":"Palantir",
                             "Data_source_version":"4.5",
                             "Crop":"WH",
                             "PlantingYear":"1971",
                             "HarvestYear":"1971",
                             "SoilTexture":"CSI",
                             "WeaStat":"PERG",
                             "CultivarID":"PE0202",
                             "SoilID":"PE9",
                             "SoilSource":"WISE"
                            }
           }
         */
        //json += "JSON";
        json += "{ \"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": ["+lon+","+lat+"]},";
        json += "\"properties\": {\"datakey\":\""+datakey+"\",";
        json += "\"fieldloc\":["+lon+","+lat+"],";
        json += "\"Country\":\""+country+"\",";
        json += "\"State\":\""+state+"\",";
        json += "\"City\":\""+city+"\",";
        json += "\"Institute\":\""+institute+"\",";
        json += "\"Data_source\":\""+data_source+"\",";
        json += "\"Data_source_version\":\""+data_source_version+"\",";
        json += "\"Crop\":\""+crop+"\",";
        json += "\"PlantingYear\":\""+plantingyear+"\",";
        json += "\"HarvestYear\":\""+harvestyear+"\",";
        json += "\"SoilTexture\":\""+soiltexture+"\",";
        json += "\"WeaStat\":\""+weastat+"\",";
        json += "\"CultivarID\":\""+cultivarid+"\",";
        json += "\"SoilID\":\""+soilid+"\",";
        json += "\"SoilSource\":\""+soilsource+"\"";
        json += "}";
        json += "}";
        return json;
    }
    /**
     * @return the lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    /**
     * @return the lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     * @return the datakey
     */
    public String getDatakey() {
        return datakey;
    }

    /**
     * @param datakey the datakey to set
     */
    public void setDatakey(String datakey) {
        this.datakey = datakey;
    }

    /**
     * @return the fieldloc
     */
    public String getFieldloc() {
        return fieldloc;
    }

    /**
     * @param fieldloc the fieldloc to set
     */
    public void setFieldloc(String fieldloc) {
        this.fieldloc = fieldloc;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the institute
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * @param institute the institute to set
     */
    public void setInstitute(String institute) {
        this.institute = institute;
    }

    /**
     * @return the data_source
     */
    public String getData_source() {
        return data_source;
    }

    /**
     * @param data_source the data_source to set
     */
    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    /**
     * @return the data_source_version
     */
    public String getData_source_version() {
        return data_source_version;
    }

    /**
     * @param data_source_version the data_source_version to set
     */
    public void setData_source_version(String data_source_version) {
        this.data_source_version = data_source_version;
    }

    /**
     * @return the crop
     */
    public String getCrop() {
        return crop;
    }

    /**
     * @param crop the crop to set
     */
    public void setCrop(String crop) {
        this.crop = crop;
    }

    /**
     * @return the plantingyear
     */
    public String getPlantingyear() {
        return plantingyear;
    }

    /**
     * @param plantingyear the plantingyear to set
     */
    public void setPlantingyear(String plantingyear) {
        this.plantingyear = plantingyear;
    }

    /**
     * @return the harvestyear
     */
    public String getHarvestyear() {
        return harvestyear;
    }

    /**
     * @param harvestyear the harvestyear to set
     */
    public void setHarvestyear(String harvestyear) {
        this.harvestyear = harvestyear;
    }

    /**
     * @return the soiltexture
     */
    public String getSoiltexture() {
        return soiltexture;
    }

    /**
     * @param soiltexture the soiltexture to set
     */
    public void setSoiltexture(String soiltexture) {
        this.soiltexture = soiltexture;
    }

    /**
     * @return the weastat
     */
    public String getWeastat() {
        return weastat;
    }

    /**
     * @param weastat the weastat to set
     */
    public void setWeastat(String weastat) {
        this.weastat = weastat;
    }

    /**
     * @return the cultivarid
     */
    public String getCultivarid() {
        return cultivarid;
    }

    /**
     * @param cultivarid the cultivarid to set
     */
    public void setCultivarid(String cultivarid) {
        this.cultivarid = cultivarid;
    }

    /**
     * @return the soilid
     */
    public String getSoilid() {
        return soilid;
    }

    /**
     * @param soilid the soilid to set
     */
    public void setSoilid(String soilid) {
        this.soilid = soilid;
    }

    /**
     * @return the soilsource
     */
    public String getSoilsource() {
        return soilsource;
    }

    /**
     * @param soilsource the soilsource to set
     */
    public void setSoilsource(String soilsource) {
        this.soilsource = soilsource;
    }
    
}
