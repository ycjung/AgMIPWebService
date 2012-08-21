/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//var rootURL = "http://localhost:8080/HelloWorldREST/resources/helloWorld";
//var rootURLa = "http://localhost:8080/HelloWorldREST";
//http://localhost:8080/AgMIPWebService
var rootURL = "http://localhost:8080/AgMIPWebService/webresources/ACE";


//var ajax_load = "<img class='loading' src='img/load.gif' alt='loading...' />";


show();
function show(){
    /*
    $.ajaxSetup ({  
        cache: false  
    });
    */
    alert('test show');
    /*
    $.ajax({
        type: "GET",
        url: rootURLa + "/js/test1.js",
        dataType: "script"
      });
    alert('test show0');
    */
    /*
    $.ajax({
        type: 'GET',
        url: rootURL,
        //url: rootURL+'/search/',
        dataType: "html",
        //success: display
        success: function(data){alert('success test');},
        error: function(jqXHR, textStatus, errorThrown){
            alert('error'+textStatus);
        }
    });
    */
   /*
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/searchjson/',
        dataType: "json",
        success: display,
        //success: function(data){alert('success test');},
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });
    */
   /*
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/search/'+'query',
        dataType: "json",
        success: createCountryCombo,
        //success: function(data){alert('success test');},
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });
    */
    //createCountryCombo();
    //testText();
    /*
    var query = {"country":"Niger", "lon":"", "lat":"", "crop":"", "plantyear":"", "harvestyear":""};
    var squery = JSON.stringify(query);
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/search/data/'+squery,
        contentType: 'application/json',
        dataType: "json",
        //success: createCountryCombo,
        success: function(data){
            alert('success test : ');
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            alert('result :'+data[0]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });
    */
   
   /*
    var query = {"datakey":[], "model":[]};
    query.datakey.push('Sahelian_Center_Niger');
    query.datakey.push('TILLABERY_');
    query.model.push('APSIM');
    query.model.push('AquaCrop');
    query.model.push('DSSAT');
    query.model.push('STICS');
    query.model.push('WOFOST');
    
    var squery = JSON.stringify(query);
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/data/download/'+squery,
        contentType: 'application/json',
        dataType: "json",
        //success: createCountryCombo,
        success: function(data){
            alert('success test : ');
            //var list = data == null ? [] : (data instanceof Array ? data : [data]);
            //alert('result :'+data[0]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });
    */
    
    exportData();
    //testSearch();
    
    alert('test show1');
    
}

function exportData(){
    var query = {"datakey":[], "model":[]};
    query.datakey.push('Sahelian_Center_Niger');
    query.datakey.push('TILLABERY_');
    query.model.push('APSIM');
    query.model.push('AquaCrop');
    query.model.push('DSSAT');
    query.model.push('STICS');
    query.model.push('WOFOST');
    
    var squery = JSON.stringify(query);
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/data/download/'+squery,
        contentType: 'application/json',
        dataType: "json",
        //success: createCountryCombo,
        success: function(data){
            alert('success test : ');
            //var list = data == null ? [] : (data instanceof Array ? data : [data]);
            //alert('result :'+data[0]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });
}

function testSearch(){
    var query = {"country":"Niger", "lon":"", "lat":"", "crop":"", "plantyear":"", "harvestyear":""};
    var squery = JSON.stringify(query);
    $.ajax({
        type: 'GET',
        //url: rootURL,
        url: rootURL+'/search/data/'+squery,
        contentType: 'application/json',
        dataType: "json",
        //success: createCountryCombo,
        success: function(data){
            alert('success test : ');
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            alert('result :'+data[0]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus);
            alert('error : '+jqXHR);
            alert('error : '+errorThrown);
        }
    });    
}

function testText(){
    $.ajax({
        type: 'GET',
        url: rootURL,
        //url: rootURL+'/search/',
        dataType: "html",
        //success: display
        success: function(data){alert('success test');},
        error: function(jqXHR, textStatus, errorThrown){
            alert('error'+textStatus);
        }
    });
}
function createCountryCombo(){        
    $.ajax({
        type: 'GET',
        url: rootURL+'/search/'+'country',
        dataType: "json",
        success: function(data){
            alert('create coutnry combobox');
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            alert('country :'+data[0]+'/'+data[1]+'/'+data[2]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus+'/'+jqXHR+'/'+errorThrown);
        }
    });    
}

function createCropCombo(){        
    $.ajax({
        type: 'GET',
        url: rootURL+'/search/'+'crop',
        dataType: "json",
        success: function(data){
            alert('create crop combobox');
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            alert('crop : '+data[0]+'/'+data[1]);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error : '+textStatus+'/'+jqXHR+'/'+errorThrown);
        }
    });    
}


