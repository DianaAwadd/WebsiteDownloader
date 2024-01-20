package website_downloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class download_more_of_page {

    public  ArrayList<String> sites = new ArrayList<String>();
    //public static final ArrayList<URL> URL_LIST = new ArrayList<URL>();

    private static final int MAX_DEPTH=1;
    Document document;
    public void getPageLinks(String URL, int depth) {
         
        if ((!sites.contains(URL) && (depth < MAX_DEPTH))) {
           System.out.println(">> Depth: " + depth + " [" + URL + "]");
            try {
           
                document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("a[href]");
                
                ExecutorService executor = Executors.newFixedThreadPool(4);
               
                for (Element page : linksOnPage) {
                  executor.execute(new Fix(page));
                }
               
             executor.shutdown();
             
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
               // System.out.println("poor network >>please re connect");
                
            }
        }
    }
   public class Fix implements Runnable
   { 
       int  depth;
       Element e;
       public Fix( Element e)
       {
            this.e=e;
       }
        @Override
        public void run() {
              if (e.attr("abs:href") != "") {
                  sites.add(e.attr("abs:href"));
                        System.out.println("href : " + e.attr("abs:href"));
//                        if(e.attr("href").contains("/")){
//                            e.removeAttr("href");
//                            String Myhref= ("./"+document.title()+"/"+document.title()+".html");
//                            e.attr("href",Myhref);
                        getPageLinks(e.attr("abs:href"), depth);
//                        }
                   }
              depth++;
        }
   }
}
