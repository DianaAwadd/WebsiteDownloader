/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1final;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import website_downloader.*;
//import website.downloader.download_one_page;
/**
 *
 * @author CSC
 */
public class Project1final extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //////////////////////////////SCENE1/////////////////////////////////////////////
      try{
           Sound sound=new Sound();

        ProgressBar pb = new ProgressBar(); 
        Image scene1 = new Image (Project1final.class.getResourceAsStream("mobile-application-development-on-laptop-screen-concept-background-app-coding-and-web-development-cross-platform-devices-smartphone-tablet-and-computer-vector.jpg"),800,600,true,true);
      ImageView imageview_scene1 = new ImageView(scene1);
       
      
        Image logo = new Image (Project1final.class.getResourceAsStream("_______________2__1.png"),50,50,true,true);
        ImageView imageview_logo = new ImageView(logo);
        imageview_logo.setTranslateX(-350);
        imageview_logo .setTranslateY(-180);
        
        Label Title=new Label("WebSite Extractor");
        Title.setTranslateX(-220);
        Title.setTranslateY(-180);
        Title.setFont(new Font("Algerian",20));
        Title.setTextFill(Color.CADETBLUE);
        
        
      Image image1 = new Image (Project1final.class.getResourceAsStream("default1.png"),100,100,true,true);
      ImageView default1 = new ImageView(image1);
      default1.setTranslateX(150);
      default1.setTranslateY(-120);
      
//       Button Dweb=new Button();
//       Dweb.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(100), Insets.EMPTY)));
//       Dweb.setGraphic(default1);
//      
      Image image2 = new Image (Project1final.class.getResourceAsStream("default2.png"),100,100,true,true);
      ImageView default2 = new ImageView(image2);
      default2.setTranslateX(260);
      default2.setTranslateY(-30);
//      
////       Button Dmulti=new Button();
////       Dmulti.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(100), Insets.EMPTY)));
////       Dmulti.setGraphic(default2);
//      
      Image image3 = new Image (Project1final.class.getResourceAsStream("default.png"),100,100,true,true);
      ImageView default3 = new ImageView(image3);
      default3.setTranslateX(150);
      default3.setTranslateY(50);
//      
////       Button Dimg=new Button();
////       Dimg.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(100), Insets.EMPTY)));
////       Dimg.setGraphic(default3);
//       
      Image image4= new Image (Project1final.class.getResourceAsStream("default4.png"),100,100,true,true);
      ImageView default4 = new ImageView(image4);
      default4.setTranslateX(260);
      default4.setTranslateY(130);
//      
////       Button Dvid=new Button();
////       Dvid.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(100), Insets.EMPTY)));
////       Dvid.setGraphic(default4);
//       
       
       Button about=new Button("About The Application");
       about.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
       about.setFont(new Font("Arial Black",10));
       about.setUnderline(true);
       about.setTranslateY(200);
          
      
       StackPane root1=new StackPane();
       root1.getChildren().addAll(imageview_scene1,imageview_logo,Title,default1,default2,default3,default4,about);
      
    
        ///////////////////////////////END SCENE1////////////////////////////////////////
        //////////////////////////////scene2////////////////////////////////////////////
    Image scene2 = new Image (Project1final.class.getResourceAsStream("mobile-application-development-on-laptop-screen-concept-background-app-coding-and-web-development-cross-platform-devices-smartphone-tablet-and-computer-vector.jpg"),800,600,true,true);
      ImageView imageview_scene2= new ImageView(scene2);
      
       Image logo2 = new Image (Project1final.class.getResourceAsStream("_______________2__1.png"),50,50,true,true);
        ImageView imageview_logo2 = new ImageView(logo2);
        imageview_logo2.setTranslateX(-350);
        imageview_logo2.setTranslateY(-180);
        
        Label Title2=new Label("WebSite Extractor");
        Title2.setTranslateX(-220);
        Title2.setTranslateY(-180);
        Title2.setFont(new Font("Algerian",20));
        Title2.setTextFill(Color.CADETBLUE);
        
      
        
        Label web1=new Label("Download WebSite");
        web1.setTranslateX(0);
        web1.setTranslateY(-150);
        web1.setFont(new Font("Bodoni MT Black",20));
        web1.setTextFill(Color.DEEPSKYBLUE);
         
        HBox first=new HBox();
        first.getChildren().addAll(web1);

       Button Download1=new Button("Download");
       Download1.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(40), Insets.EMPTY)));
       Download1.setFont(new Font("Arial Black",15));
       Download1.setUnderline(true);
       

        TextField tttt=new TextField();
        tttt.setPrefSize(500, 30);
        tttt.setFocusTraversable(false);
        tttt.setPromptText("Enter Your URL");
        tttt.setTranslateY(-50);
        
       EventHandler<ActionEvent>handler=e-> {
            try {
               // System.out.println("fffff");
                  sound.clockTickSound();
                Website_downloader.start(tttt.getText().toString());
                System.out.println("fffff");
            } catch (Exception ex) {
                Logger.getLogger(Project1final.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        };
       tttt.setOnAction(handler);
       Download1.setOnAction(handler);
       HBox first1=new HBox();
       first1.getChildren().addAll(tttt,Download1);
       first1.setSpacing(50);
       first1.setTranslateX(70);
       first1.setTranslateY(150);
       
         Image pause = new Image (Project1final.class.getResourceAsStream("495304-200.png"),0,20,true,true);
      ImageView imageview_pause = new ImageView(pause);
      
        Image Resume = new Image (Project1final.class.getResourceAsStream("pngtree-vector-pause-icon-png-image_4233261.jpg"),20,20,true,true);
      ImageView imageview_Resume = new ImageView(Resume);
      
//        Image back = new Image (PROJECT1.class.getResourceAsStream("web-development-application-design-coding-and-vector-25708584.jpg"),20,20,true,true);
//      ImageView imageview_back = new ImageView(back);
        Button back1=new Button("Back");
      back1.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
     back1.setTranslateX(0);
      back1.setTranslateY(200);
      back1.setFont(new Font("Arial Black",8));
       back1.setUnderline(true);
       
      VBox options=new VBox();
      options.getChildren().addAll(imageview_pause,imageview_Resume);
//       options.setTranslateX(20);
//       options.setTranslateY(-30);
       
       StackPane root2=new StackPane();
       root2.getChildren().addAll(imageview_scene2,imageview_logo2,Title2,web1,options,back1,tttt,Download1);
////        ///////////////////////////////END scene2///////////////////////////////////////
////        ///////////////////////////////scene3//////////////////////////////////////////
//       
 Image scene3 = new Image (Project1final.class.getResourceAsStream("mobile-application-development-on-laptop-screen-concept-background-app-coding-and-web-development-cross-platform-devices-smartphone-tablet-and-computer-vector.jpg"),800,600,true,true);
      ImageView imageview_scene3 = new ImageView(scene3);
       
      
        Image logo3 = new Image (Project1final.class.getResourceAsStream("_______________2__1.png"),50,50,true,true);
        ImageView imageview_logo3 = new ImageView(logo3);
        imageview_logo3.setTranslateX(-350);
        imageview_logo3.setTranslateY(-180);
        
        Label Title3=new Label("WebSite Extractor");
        Title3.setTranslateX(-220);
        Title3.setTranslateY(-180);
        Title3.setFont(new Font("Algerian",20));
        Title3.setTextFill(Color.CADETBLUE);
        
     
        
        Label multiweb1=new Label("Multi WebsSites");
        multiweb1.setTranslateX(270);
        multiweb1.setTranslateY(70);
        multiweb1.setFont(new Font("Bodoni MT Black",20));
       multiweb1.setTextFill(Color.DEEPSKYBLUE);
        
        HBox second=new HBox();
        second.getChildren().addAll(multiweb1);
        
        TextArea TA=new TextArea();
        TA.autosize();
        TA.setPrefColumnCount(45);
        TA.setPrefRowCount(15);
//        TA.setPrefRowCount(7);
//        TA.setPrefHeight(50);
        TA.setTranslateX(60);
        TA.setTranslateY(100);
//        
         Button Downloadmulti=new Button("Download");
         Downloadmulti.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
         Downloadmulti.setTranslateX(600);
         Downloadmulti.setTranslateY(5);
         Downloadmulti.setFont(new Font("Arial Black",12));
         Downloadmulti.setUnderline(true);
         
          GridPane diana=new GridPane();
         diana.getChildren().addAll(TA,Downloadmulti);
       
         Button back2=new Button("Back");
         back2.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
         back2.setTranslateX(0);
         back2.setTranslateY(200);
         back2.setFont(new Font("Arial Black",8));
         back2.setUnderline(true);
       
         StackPane root3=new StackPane();
       root3.getChildren().addAll(imageview_scene3,imageview_logo3,Title3,second,diana,back2);
////        
////        //////////////////////////////////END scene3///////////////////////////////////
////        //////////////////////////////scene4///////////////////////////////////////////
        
     
 Image scene4 = new Image (Project1final.class.getResourceAsStream("mobile-application-development-on-laptop-screen-concept-background-app-coding-and-web-development-cross-platform-devices-smartphone-tablet-and-computer-vector.jpg"),800,600,true,true);
      ImageView imageview_scene4 = new ImageView(scene4);
       
      
        Image logo4= new Image (Project1final.class.getResourceAsStream("_______________2__1.png"),50,50,true,true);
        ImageView imageview_logo4 = new ImageView(logo4);
        imageview_logo4.setTranslateX(-350);
        imageview_logo4.setTranslateY(-180);
        
        Label Title4=new Label("WebSite Extractor");
        Title4.setTranslateX(-220);
        Title4.setTranslateY(-180);
        Title4.setFont(new Font("Algerian",20));
        Title4.setTextFill(Color.CADETBLUE);
//        Image img = new Image (Project1final.class.getResourceAsStream("icon1.png"),50,50,true,true);
//        ImageView imageview_img = new ImageView(img);
        
        Label images=new Label("Download Image");
        images.setTranslateX(-370);
        images.setFont(new Font("Berlin Sans FB Demi",20));
        
        
        HBox Third=new HBox();
        Third.getChildren().addAll(images);
        
         TextField timg=new TextField();
        timg.setPrefSize(500, 30);
        timg.setFocusTraversable(false);
        timg.setPromptText("Enter Your URL");
        
        
        
        Button Downloadimg=new Button("Download");
       Downloadimg.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(40), Insets.EMPTY)));
       Downloadimg.setFont(new Font("Arial Black",15));
       Downloadimg.setUnderline(true);
       
       
        HBox H=new HBox();
        H.getChildren().addAll(timg,Downloadimg);
         H.setSpacing(50);
       H.setTranslateX(70);
       H.setTranslateY(150);
       
//        TextField bimg=new TextField();
//        bimg.setPrefSize(500, 30);
//        bimg.setFocusTraversable(false);
//        bimg.setPromptText("Select Folder");
//        
//        
//        
//        Button browseimg=new Button("Browse");
//       browseimg.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(40), Insets.EMPTY)));
//       browseimg.setFont(new Font("Arial Black",15));
//       browseimg.setUnderline(true);
//       
       
//        HBox Hb=new HBox();
//        Hb.getChildren().addAll(bimg,browseimg);
//        Hb.setSpacing(50);
//        Hb.setTranslateX(70);
//        Hb.setTranslateY(200);
//          Image pause3 = new Image (Project1final.class.getResourceAsStream("495304-200.png"),20,20,true,true);
//      ImageView imageview_pause3 = new ImageView(pause3);
//      
//        Image Resume3 = new Image (Project1final.class.getResourceAsStream("pngtree-vector-pause-icon-png-image_4233261.jpg"),20,20,true,true);
//      ImageView imageview_Resume3 = new ImageView(Resume3);
      
//        Image back3 = new Image (PROJECT1.class.getResourceAsStream("web-development-application-design-coding-and-vector-25708584.jpg"),20,20,true,true);
//      ImageView imageview_back3 = new ImageView(back3);
      
      VBox options3=new VBox();
      options3.getChildren().addAll(imageview_pause,imageview_Resume);
      
        Button back3=new Button("Back");
      back3.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
     back3.setTranslateX(0);
      back3.setTranslateY(200);
      back3.setFont(new Font("Arial Black",8));
       back3.setUnderline(true);
       
       StackPane root4=new StackPane();
       root4.getChildren().addAll(imageview_scene4,imageview_logo4,Title4, Third, H,back3);
//        ///////////////////////////////end scene 4////////////////////////////////////
//        /////////////////////////////////scene5///////////////////////////////////////
      
       Image scene5 = new Image (Project1final.class.getResourceAsStream("mobile-application-development-on-laptop-screen-concept-background-app-coding-and-web-development-cross-platform-devices-smartphone-tablet-and-computer-vector.jpg"),800,600,true,true);
      ImageView imageview_scene5 = new ImageView(scene5);
       
      
        Image logo5 = new Image (Project1final.class.getResourceAsStream("_______________2__1.png"),50,50,true,true);
        ImageView imageview_logo5 = new ImageView(logo5);
        imageview_logo5.setTranslateX(-350);
        imageview_logo5.setTranslateY(-180);
        
        Label Title5=new Label("WebSite Extractor");
        Title5.setTranslateX(-220);
        Title5.setTranslateY(-180);
        Title5.setFont(new Font("Algerian",20));
        Title5.setTextFill(Color.CADETBLUE);
//        Image video = new Image (Project1final.class.getResourceAsStream("icon5.png"),50,50,true,true);
//        ImageView imageview_video = new ImageView(video);
        
        Label videos=new Label("Download Video");
        videos.setTranslateX(-670);
       videos.setFont(new Font("Berlin Sans FB Demi",20));
     
        
        HBox fourth=new HBox();
        fourth.getChildren().addAll(videos);
        
         TextField tvid=new TextField();
        tvid.setPrefSize(500, 30);
        tvid.setFocusTraversable(false);
        tvid.setPromptText("Enter Your URL");
        
        Button Downloadvid=new Button("Download");
       Downloadvid.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(40), Insets.EMPTY)));
       Downloadvid.setFont(new Font("Arial Black",15));
       Downloadvid.setUnderline(true);
       
        HBox H2=new HBox();
        H2.getChildren().addAll(tvid,Downloadvid);
         H2.setSpacing(50);
       H2.setTranslateX(70);
       H2.setTranslateY(150);
        
          
        Button back4=new Button("Back");
      back4.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
     back4.setTranslateX(0);
      back4.setTranslateY(200);
      back4.setFont(new Font("Arial Black",8));
       back4.setUnderline(true);
       
//      Image pause4 = new Image (Project1final.class.getResourceAsStream("495304-200.png"),20,20,true,true);
//      ImageView imageview_pause4 = new ImageView(pause4);
//      
//        Image Resume4 = new Image (Project1final.class.getResourceAsStream("pngtree-vector-pause-icon-png-image_4233261.jpg"),20,20,true,true);
//      ImageView imageview_Resume4 = new ImageView(Resume4);
      
//        Image back4 = new Image (PROJECT1.class.getResourceAsStream("web-development-application-design-coding-and-vector-25708584.jpg"),20,20,true,true);
//      ImageView imageview_back4 = new ImageView(back4);
      
//      VBox options4=new VBox();
//      options4.getChildren().addAll(imageview_pause,imageview_Resume);
     
        StackPane root5=new StackPane();
       root5.getChildren().addAll(imageview_scene5,imageview_logo5,Title5,back4,fourth,H2);
////       /////////////////////////////////end scene 5/////////////////////////////////////
////       //////////////////////////////////scene6/////////////////////////////////////////
//        
 Image scene6 = new Image (Project1final.class.getResourceAsStream("ikigaiHub-Full-Stack-Web-Development.png"),800,600,true,true);
      ImageView imageview_scene6 = new ImageView(scene6);
       
     
        Label details=new Label("Website Extractor is an appliacation to download"
               + "\n"
               + " whole website"
               + "\n"
               + "allow for users to download website and open it"
               + "\n"
               + " online");
       details.setTranslateX(-90);
       details.setTranslateY(-80);
       details.setFont(new Font("Arial Black",18));
       details.setTextFill(Color.DARKGRAY);
       
       Label details2=new Label("1-just Enter your URL in its specific place"
               + "\n"
               +"\n"
               + "2-Click on browse to choose place to save website on your PC"
               + "\n"
               +"\n"
               + "3-Click on GO to start downloading");
       details2.setFont(new Font("Arial Black",15));
       details2.setTextFill(Color.DARKGRAY);
       details2.setTranslateX(-50);
       details2.setTranslateY(50);
       
        Button back5=new Button("Back");
      back5.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(100), Insets.EMPTY)));
     back5.setTranslateX(0);
      back5.setTranslateY(200);
      back5.setFont(new Font("Arial Black",8));
       back5.setUnderline(true);
       
       StackPane root6=new StackPane();
       root6.getChildren().addAll(imageview_scene6,details,details2,back5);
////       ///////////////////////////////////end scene6///////////////////////////////////
////      
//    
////      btn.setOnAction(event->primaryStage.setScene(scene2)  
////      );
////      
////       back.setOnAction(event->primaryStage.setScene(scene)  
////      );
////       
////        browse.setOnAction(event -> {
////
////        DirectoryChooser dc = new DirectoryChooser();
////      File file = dc.showDialog(null);
////      if (file != null) {
////            file = new File(file.getAbsolutePath() + "/dafaultFilename.extension");}  
////        });
//     
    
  
        // create a tile pane 
//        TilePane r = new TilePane(); 
       
        // action event 
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
//            public void handle(ActionEvent e) 
//            { 
//               double ii = 0;  // set progress to different level of progressbar 
//                ii += 0.1; 
//                pb.setProgress(ii); 
//            } 
//  
//        }; 
     
     Scene scene11=new Scene(root1,800,460);
     Scene scene22=new Scene(root2,800,460);
     Scene scene33=new Scene(root3,800,460);
     Scene scene44=new Scene(root4,800,460);
     Scene scene55=new Scene(root5,800,460);
     Scene scene66=new Scene(root6,800,440);
     
      default1.setOnMouseClicked(event->{primaryStage.setScene(scene22);
      sound.introSound();
      });
      default2.setOnMouseClicked(event->{primaryStage.setScene(scene33);
      sound.introSound();
      });
       default3.setOnMouseClicked(event->{primaryStage.setScene(scene44);
       sound.introSound();
      });
      default4.setOnMouseClicked(event->{primaryStage.setScene(scene55);
       sound.introSound();
      });
      about.setOnAction(event->{primaryStage.setScene(scene66);
      sound.clockTickSound();
      }  
       );
      back1.setOnAction(event->{primaryStage.setScene(scene11);
      System.out.println(Download1);
      sound.clockTickSound();
      }  
     );
      back2.setOnAction(event->{primaryStage.setScene(scene11);
          
      sound.clockTickSound();
      }  
     );
      back3.setOnAction(event->{primaryStage.setScene(scene11);
      sound.clockTickSound();
      }  
     );
      back4.setOnAction(event->{primaryStage.setScene(scene11);
      sound.clockTickSound();
      }  
     );
      back5.setOnAction(event->{primaryStage.setScene(scene11);
      sound.clockTickSound();
      }  
     );

         Download_image DI=new Download_image();
     EventHandler<ActionEvent>handler1=e-> {
            try {
               // System.out.println("fffff");
                  sound.clockTickSound();
               DI.downloadImage(timg.getText(), "C:\\Users\\CSC\\Downloads");
                System.out.println("fffff");
            } catch (Exception ex) {
                Logger.getLogger(Project1final.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        };
       timg.setOnAction(handler1);
       Downloadimg.setOnAction(handler1);

      Image image= new Image(Project1final.class.getResourceAsStream("icon2.png"));
      primaryStage.getIcons().add(image);
      primaryStage.setOnShowing(Event->{sound.introSound();});
      primaryStage.setTitle("Downloader");
      primaryStage.setScene(scene11);
      primaryStage.show();
    }
        catch(Exception e)
      {
          e.printStackTrace();
      }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void showDialog(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

