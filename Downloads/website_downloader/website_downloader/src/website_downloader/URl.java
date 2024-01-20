/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_downloader;

/**
 *
 * @author RANEEM
 */
public class URl {
   public String url;
   public int depth; 
   public URl(String url,int depth)
   {
       this.depth=depth;
       this.url=url;
   }
}
