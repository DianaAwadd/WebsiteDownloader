/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_downloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author RANEEM
 */
public class Download_Js {
    
    public String strJSName1;
    public String strJSName;
    private Object url;
    private String executePost(String targetURL, String urlParameters){

    URL url;
    HttpURLConnection connection = null;        
    try{
        //Create connection

        url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", 
                   "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US"); 
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //send Request 
        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
        dataout.writeBytes(urlParameters);
        dataout.flush();
        dataout.close();

        //get response
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();

        while((line = br.readLine()) != null){
            response.append(line);
            response.append('\n');

        }
        System.out.println(response.toString());
        br.close();
        return response.toString();
    }catch(Exception e){
        System.out.println("Unable to full create connection");
        e.printStackTrace();
        return null;
    }finally {

          if(connection != null) {
            connection.disconnect(); 
          }
    }


}
     
    
    public void download_js(String strJsUrl,String js_path){
        
        try {     
        //get file name from js path
        strJSName1 = strJsUrl.substring( strJsUrl.lastIndexOf("/") + 1 );
        strJSName = strJSName1.substring(0, strJSName1.lastIndexOf(".") +3);
        System.out.println("Saving: " + strJSName + ", from: " + strJsUrl);
        
        if (!(strJSName1.contains("."))) { 
                return;
            }
         
         
            //open the stream from URL
            URLConnection urlConnection = new URL(strJsUrl).openConnection();
            urlConnection.addRequestProperty("User-Agent", "Chrome");
            urlConnection.setReadTimeout(5000);
            urlConnection.setConnectTimeout(5000);

             InputStream is =urlConnection.getInputStream();
             BufferedReader readr = new BufferedReader(new InputStreamReader(is));
             
            BufferedWriter writer = new BufferedWriter(new FileWriter(js_path + "/" + strJSName)); 

            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
  
            readr.close(); 
            writer.close(); 
        }   
        
        //catch(SocketInputStream e){}
        catch(FileNotFoundException r){}
           catch (IOException e) {
            e.printStackTrace();
        }  catch (StringIndexOutOfBoundsException d) {
            //d.printStackTrace();
        } 
        
    }
}
