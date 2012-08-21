
package aceui;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author yunj
 */

//http://localhost:8080/AgMIPWebService/index.html
//http://localhost:8080/AgMIPWebService
//http://localhost:8080/AgMIPWebService/webresources/ACE

@Stateless
@Path("/ACE")
public class ACEResource {

    ACEMetaDataDAO dao = new ACEMetaDataDAO();
    

    /**
     * is accessed?
     * @return 
     */
    @GET
    @Produces("text/html")
    public String getAccessFlag() {
        //return "<html><body><h1>Hello !</h1></body></html>";
        return "Accessed to WebService!!";
    }
    
    @GET @Path("search")    
    @Produces("text/html")
    public String getStringHelloworld(){
        return "Helloworld1";
    }
    
    // query : country, crop
    @GET @Path("search/{query}")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<String> getList(@PathParam("query") String query){

        dao.getReady();
        List childs = new ArrayList();
        if(query.equals("country")){
            childs = dao.getCountryList();            
        }else if(query.equals("crop")){
            childs = dao.getCropList();
        }else{
            childs.add("else A");
            childs.add("else B");
            childs.add("else C");
        }        
        
                
        return childs;
        //return new Wine("A","Avalue");
    }
    
    // query : json string of filer/value
    @GET @Path("search/data/{query}")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<String> search(@PathParam("query") String jsonquery){

        //System.out.println("input : "+jsonquery);
        dao.getReady();
        List<ACEMetaData> result = dao.search(jsonquery);
        List childs = new ArrayList();

        //String resultStr = "JSON{\"type\": \"FeatureCollection\",\"features\": [";
        //int i=0;
        for(ACEMetaData d : result){
            //if(i>0)resultStr += ",";
            //resultStr += d.toJSONElementString();
            //i++;
            childs.add(d.toJSONElementString());
        }
        //resultStr += "]}";
        //childs.add(resultStr);        
                
        return childs;
    }

    // query : json string of datakey/model for export
    @GET @Path("data/download/{query}")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<String> download(@PathParam("query") String jsonquery){

        //System.out.println("input : "+jsonquery);
        dao.getReady();
        
        dao.exportData(jsonquery);
        
        List childs = new ArrayList();
        /*
        List<ACEMetaData> result = dao.search(jsonquery);
        List childs = new ArrayList();

        for(ACEMetaData d : result){
            childs.add(d.toJSONElementString());
        }
        */
        childs.add("message arrived at server : [Under construction]");
                
        return childs;
    }    
    /*
    // query : json string of filer/value
    @GET @Path("search/data/{query}")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<String> search(@PathParam("query") String jsonquery){

        System.out.println("input : "+jsonquery);
        dao.getReady();
        List<ACEMetaData> result = dao.search(jsonquery);
        List childs = new ArrayList();
        String resultStr = "JSON{\"type\": \"FeatureCollection\",\"features\": [";
        int i=0;
        for(ACEMetaData d : result){
            if(i>0)resultStr += ",";
            resultStr += d.toJSONElementString();
            i++;
        }
        resultStr += "]}";
        childs.add(resultStr);
        
                
        return childs;
    }    
    */
    /*
    @GET @Path("searchjson/{query}")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Wine> getStringHelloworldjson(@PathParam("query") String query){
        //List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        List<Wine> messages = dao.findAll();
        return messages;
    }
    */
    /*
    @GET @Path("searchjson")    
    //@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces("application/json")
    public List<Wine> findAll(){
        //List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        List<Wine> messages = dao.findAll();
        return messages;
    }
    */
    
    //http://localhost:8080/HelloWorldREST/index.html
    //http://localhost:8080/HelloWorldREST/resources/helloWorld/search
    
    /*
    @GET @Path("searchjson")    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    //@Produces("application/json")
    public List<Wine> findAll(){
        //List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        List<Wine> messages = dao.findAll();
        return messages;
        //return new Wine("A","Avalue");
    }
    */

    /**
     * PUT method for updating an instance of HelloWorldResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    /*
    @PUT
    @Consumes("text/plain")
    public void putXml(String content) {
        nameStorage.setName(content);
    }
    */
    
}