/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_downloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author RANEEM
 */

public class Download_Css {
    
        public String strCssName1;
        public String strCssName;
        public void download_css(String strCssUrl,String image_path){

        try { 
        //get file name from css path
        strCssName1 = strCssUrl.substring( strCssUrl.lastIndexOf("/") + 1 );
         if (!(strCssName1.contains("."))) {
                return;
            }
        strCssName = strCssName1.substring(0, strCssName1.lastIndexOf(".") +4);
        System.out.println("Saving: " + strCssName + ", from: " + strCssUrl);
        
            //open the stream from URL
            URLConnection urlConnection = new URL(strCssUrl).openConnection();
            urlConnection.addRequestProperty("User-Agent", "Chrome");
            urlConnection.setReadTimeout(3000);
            urlConnection.setConnectTimeout(3000);

            InputStream is =urlConnection.getInputStream();
            BufferedReader readr = new BufferedReader(new InputStreamReader(is));
            
            // Enter filename in which you want to download 
            BufferedWriter writer = new BufferedWriter(new FileWriter(image_path + "/" + strCssName)); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
  
            readr.close(); 
            writer.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (StringIndexOutOfBoundsException d) {
        }

    }
}
