/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jw0rmc.timeline;


/**
 *
 * @author jw0rmc
 */

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 


public class JsonSimple {
    //final static String localPath="/var/lib/tomcat7/webapps/Seller-Map_v2/"; //amazon
    final private String localPath;//"C:\Lanconta\Proyectos\JSFLogin\web\secured\js\timeline"; //local
    public static void main(String arga[]){
    System.out.println("jsoneando again!!!");
    new JsonSimple("C:\\Users\\DellXps15\\Documents\\NetBeansProjects\\Uploader\\web\\timeline\\json\\").escribidor();
    }
    
    public JsonSimple(String absolutoPath){
        this.localPath=absolutoPath;
    }
    
 
     public  boolean escribidor(List<Elementos> l_his,String fileName) {
         //NOTA : en calendario gregoriano enero es el 0.
        
        Calendar calDesde=Calendar.getInstance();
        Calendar calHasta=Calendar.getInstance();
        JSONObject objson;
        JSONArray list = new JSONArray();
         
         for(Elementos his:l_his){
             
             calDesde.setTime(his.getInicio());
             calHasta.setTime(his.getFinal_());
             /*System.out.println(his.getId() +"    " + calDesde.get(Calendar.YEAR) + "     " + calDesde.get(Calendar.MONTH) + "     " +  calDesde.get(Calendar.DAY_OF_MONTH)  +
             "  motivo:" + his.getMotivo().getDescripcion()+ "    obj reservable:" + his.getObjetoReservable().getNombre());*/
            objson=new JSONObject();
            objson.put("start"  , "new Date("+calDesde.get(Calendar.YEAR)+","+
                                             (calDesde.get(Calendar.MONTH)+1)+","+
                                              calDesde.get(Calendar.DAY_OF_MONTH)+","+
                                              calDesde.get(Calendar.HOUR)+","+
                                              calDesde.get(Calendar.MINUTE)+","+
                                              calDesde.get(Calendar.SECOND)+")");
            objson.put("end"    , "new Date("+calHasta.get(Calendar.YEAR)+","+
                                             (calHasta.get(Calendar.MONTH)+1)+","+
                                              calHasta.get(Calendar.DAY_OF_MONTH)+","+
                                              calHasta.get(Calendar.HOUR)+","+
                                              calHasta.get(Calendar.MINUTE)+","+
                                              calHasta.get(Calendar.SECOND)+")");
            objson.put("content", "Descripcion:"+his.getDescripcion()+"<br><img src='img/32/tmp.jpg' style='width:32px; height:32px;'><h2>"+his.getNombre()+"</h2>");
            list.add(objson);
         }
        
        
	try {
                System.out.println(" " + list.toJSONString());
		FileWriter file = new FileWriter(localPath+fileName+".json");
		file.write(list.toJSONString());
		file.flush();
		file.close();
                return true;
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
 return false;
     }
     
     public  boolean escribidor() {
         
	JSONObject obj = new JSONObject();
	obj.put("start"  , "new Date(2013,5,23)");
        obj.put("end"    , "new Date(2013,6,15,23,30,0)");
	obj.put("content", "Probando1<br><img src='img/icon.png' style='width:32px; height:32px;'>");
       
        JSONObject obj2 = new JSONObject();
	obj2.put("start"  , "new Date(2013,6,20)");
        obj2.put("end"    , "new Date(2013,7,5,23,30,0)");
	obj2.put("content", "Probando2<br><img src='img/mail-icon.png' style='width:32px; height:32px;'>");
        
 
        
        
	JSONArray list = new JSONArray();
	list.add(obj);
        list.add(obj2);
 
	try {
 
		FileWriter file = new FileWriter(localPath+"test.json");
		file.write(list.toJSONString());
		file.flush();
		file.close();
                return true;
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
 return false;
     }
     
     public String leedor(String fileName){
         JSONParser parser = new JSONParser();
         JSONArray jsonObject=null;
         String name="";
         String ofertas="";
         int cont=0;
        try {
 
                Object obj = parser.parse(new FileReader(localPath+fileName+".json"));
 
                jsonObject = (JSONArray) obj;
               
 /*
                name = (String) jsonObject.get("titulo");
                String descripcion = (String) jsonObject.get("descripcion");
                JSONArray msg = (JSONArray) jsonObject.get("clientes");
                Iterator<JSONObject> iterator = msg.iterator();
                while (iterator.hasNext()) {
                        JSONObject objJtmp=iterator.next();
                        System.out.println("Generando lista de ofertas......");
                        ofertas+="<li id=\""+objJtmp.get("nombre") +"\" title=\""+ objJtmp.get("lonlat") +"\" ><h1>"+ objJtmp.get("mensage") +"<h1></li>";
                        System.out.println("----->>>>        " + ofertas);
                        System.out.println("Lista de Ofertas OK!");
                       cont++;
                }
 */
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
                e.printStackTrace();
        }
     
       
        return jsonObject.toJSONString();
       
     }
 
}