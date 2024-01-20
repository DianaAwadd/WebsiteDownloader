/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_downloader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchTask implements Runnable{
  download_more_of_page DMP=new download_more_of_page();
  download_one_page DOP;
   private final ArrayList<String> sites;
   public FetchTask(ArrayList<String> sites){
        this.DOP = new download_one_page();
        this.sites = sites;
        
    } 
    public Object lock = this;
    public boolean pause = false;
    @Override
    public void run() {
        

        ExecutorService executor = Executors.newFixedThreadPool(2);                
        
        
        for(int i=0;i<sites.size();i++){
            executor.execute(new Fix(i));
            if(pause=true)
      synchronized (lock)
        {
          
                try {
                    lock.wait(); 
                } catch (InterruptedException ex) {
                    Logger.getLogger(FetchTask.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            
            else{
                pause=false;
                 synchronized (lock)
                   {
                      lock.notifyAll();
                   }
            }
        }
         executor.shutdown();
        
        }  
    public class Fix implements Runnable{
        
        int i;
        Fix(int i){
        this.i = i;}

        @Override
        public void run() {
            try {
               DOP.download_page(sites.get(i));
            }  catch (IOException ex) {
               Logger.getLogger(FetchTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    
            
}