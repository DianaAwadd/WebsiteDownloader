package website_downloader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Project1final.*;
public class Website_downloader {

    public static void start(String link) throws Exception {
        try {
       System.out.println("dddddddddddddddddddddddddddd");
       
       // Scanner scan = new Scanner(System.in);
        //link = scan.nextLine();
       
            System.out.println("dddddddddddddddddddddddddddd");
            download_one_page DL = new download_one_page();
                    System.out.println("dddddddddddddddddddddddddddd");
            DL.download_page(link);
            download_more_of_page DMP = new download_more_of_page();
                    System.out.println("dddddddddddddddddddddddddddd");

            //   DL.download_page(link);
            DMP.getPageLinks(link, 0);
                    System.out.println("dddddddddddddddddddddddddddd");

            ExecutorService executor = Executors.newFixedThreadPool(3);
            FetchTask DLP=new FetchTask(DMP.sites);
            executor.execute(DLP);
            executor.shutdown();
            
            System.out.println(">>>>"+DMP.sites.size());
        }  catch (IllegalArgumentException r) {
            System.out.println("ReEnter URL!!");
        }
      

    }
}
