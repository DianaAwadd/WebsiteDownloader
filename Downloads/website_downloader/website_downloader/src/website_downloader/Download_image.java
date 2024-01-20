/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_downloader;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import com.sun.webkit.dom.NodeImpl;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.UnknownHostException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author RANEEM
 */
public class Download_image {

    public String strImageName1;
    public String strImageName;
    public void downloadImage(String strImageURL, String image_path) {

        try {

            //get file name from image path
            strImageName1 = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);
            strImageName = strImageName1.substring(0, strImageName1.lastIndexOf(".")+4);
            if (!(strImageName1.contains("."))) {
                return;
            }
            System.out.println("saving : " + strImageName);

            //open the stream from URL
            URLConnection urlConnection = new URL(strImageURL).openConnection();
            urlConnection.addRequestProperty("User-Agent", "Chrome");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);

             InputStream is =urlConnection.getInputStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os = new FileOutputStream(image_path + "/" + strImageName);

            //write bytes to the output stream
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        }
        catch(FileNotFoundException r){}
        catch(UnknownHostException e){}
        catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException d) {
        }
        

    }
}
