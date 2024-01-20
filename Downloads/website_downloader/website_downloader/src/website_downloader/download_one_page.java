package website_downloader;

import java.io.BufferedReader;
import java.io.File;
import java.security.cert.Certificate;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class download_one_page {

// public String data;
    private Download_image D_img = new Download_image();
    private Download_Css D_css = new Download_Css();
    private Download_Js D_Js = new Download_Js();
    private static String path;
    String file_path;
    Document doc;
    static int i = 0;
    public int e = 0;

    public download_one_page() {
        path = (System.getProperty("user.home").toString() + "\\Documents\\downloader\\");
        File website = new File(path);
        website.mkdirs();
    }

    ////get all kinds of attributes related to image src
    private String GetSrc(Element img) {
        String src = "";
        if (img.hasAttr("src")) {
            src = img.attr("abs:src");
        } else if (img.hasAttr("data-src")) {
            src = img.attr("abs:data-src");
        } else if (img.hasAttr("data-lazy-src")) {
            src = img.attr("abs:data-lazy-src");
        } else if (img.hasAttr("srcset")) {
            src = img.attr("abs:srcset");
        }
        return src;
    }

    private String GetjsSrc(Element script) {
        String src = "";
        if (script.hasAttr("src")) {
            src = script.attr("abs:src");
        } else if (script.hasAttr("data-src")) {
            src = script.attr("abs:data-src");
        } else if (script.hasAttr("data-lazy-src")) {
            src = script.attr("abs:data-lazy-src");
        } else if (script.hasAttr("async src")) {
            src = script.attr("abs:async src");
        }
        return src;
    }

    private String Getjsnameattr(Element script) {
        String src = "";
        if (script.hasAttr("src")) {
            src = "src";
        } else if (script.hasAttr("data-src")) {
            src = "data-src";
        } else if (script.hasAttr("data-lazy-src")) {
            src = "data-lazy-src";
        } else if (script.hasAttr("async src")) {
            src = "async src";
        }
        return src;
    }

    private String Getnameattr(Element name) {
        String src = "";
        if (name.hasAttr("src")) {
            src = "src";
        } else if (name.hasAttr("data-src")) {
            src = "data-src";
        } else if (name.hasAttr("data-lazy-src")) {
            src = "data-lazy-src";
        } else if (name.hasAttr("async src")) {
            src = "async src";
        } else if (name.hasAttr("srcset")) {
            src = "abs:srcset";
        }
        return src;
    }

    public void download_page(String link) throws IOException {

        // Create a trust manager that does not validate certificate chains like the default 
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }
            }
        };
        // Install the all-trusting trust manager
        try {

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        } catch (Exception e) {
            System.out.println(e);
        }

        doc = Jsoup.connect(link).ignoreContentType(true).timeout(3000).userAgent("Chrome").get();
        //  Download_video D_video = new Download_video();
        try {

            if (e == 0) {

                file_path = path + doc.title();
                File Website_folder = new File(file_path);
                Website_folder.mkdirs();

                Elements linksOnPage = doc.select("a[href]");

                for (Element page : linksOnPage) {
                    if (page.attr("href").contains("/")) {
                        Document doc1 = Jsoup.connect(page.attr("href")).timeout(5000).get();
                        page.removeAttr("href");
                        String Myhref = ("../" + doc1.title() + ".html");
                        page.attr("href", Myhref);
                    }
                }
                e = 1;
            } else if (e == 4) {
                String file_path1 = file_path + "/" + doc.title();
                File linkfile = new File(file_path1);
                linkfile.mkdirs();

                String hh = (doc.title() + ".html");
                FileWriter html_file = new FileWriter(file_path1 + "\\" + hh);
                String css_path = (file_path1 + "\\" + "css");
                File css_file = new File(css_path);
                css_file.mkdirs();

                String js_path = (file_path1 + "\\" + "js");
                File js_file = new File(js_path);
                js_file.mkdirs();

                String img_path = (file_path1 + "\\" + "images");
                File img_file = new File(img_path);
                img_file.mkdirs();

                //css
                Elements style = doc.select("link[href]");
                for (Element stylee : style) {

                    System.out.println("css   :  " + stylee.attr("href") + "type of rel : " + stylee.attr("rel"));
                    if (stylee.attr("rel").equals("stylesheet")) {
                        String Css_src = stylee.attr("abs:href");
                        System.out.println("SSSSSSSSSSSSSSSSS" + Css_src);
                        D_css.download_css(Css_src, css_path);
                        stylee.removeAttr("href");
                        stylee.attr("href", ("./css/" + D_css.strCssName));
                    }

                    if ((stylee.attr("rel").equals("icon")) || (stylee.attr("rel").equals("shortcut icon")) || (stylee.attr("rel").equals("apple-touch-icon")) || (stylee.attr("rel").equals("image_src")) || stylee.attr("rel").equals("image_src")) {
                        String img_src = stylee.attr("abs:href");
                        D_img.downloadImage(img_src, img_path);
                        stylee.removeAttr("href");
                        stylee.attr("href", ("./images/" + D_img.strImageName));

                    }
                }

                //img
                System.out.println("all the images in the website: ");
                Elements images = doc.getElementsByTag("img");
                for (Element image : images) {

                    String image_src = GetSrc(image);

                    System.out.println("src     :" + image_src);

                    D_img.downloadImage(image_src, img_path);//بس إعمل تابع تحميل الصوؤة بستدعيه هون
                    image.removeAttr(Getnameattr(image));
                    image.attr("src", ("./images/" + D_img.strImageName));
                }

                //js
                Elements script = doc.getElementsByTag("script");
                for (Element scriptee : script) {
                    String js_data = GetjsSrc(scriptee);
                    D_Js.download_js(js_data, js_path);
                    if (scriptee.hasAttr("src") || scriptee.hasAttr("data-src") || script.hasAttr("data-lazy-src") || scriptee.hasAttr("async src")) {
                        scriptee.removeAttr(Getjsnameattr(scriptee));
                        scriptee.attr("src", ("./js/" + D_Js.strJSName));
                    }
                }

                //html
                Elements Html = doc.getElementsByTag("html");
                for (Element htmlee : Html) {
                    if ((Html != script) && (Html != style)) {
                        String html_data = htmlee.toString();
                        html_file.write(html_data);
                    }
                    html_file.close();
                }

            } 
            else if (e == 1) {
                String hh = (doc.title() + ".html");
                FileWriter html_file = new FileWriter(file_path + "\\" + hh);
                
                String css_path = (file_path + "\\" + "css");
                File css_file = new File(css_path);
                css_file.mkdirs();

                String js_path = (file_path + "\\" + "js");
                File js_file = new File(js_path);
                js_file.mkdirs();

                String img_path = (file_path + "\\" + "images");
                File img_file = new File(img_path);
                img_file.mkdirs();

                //css
                Elements style = doc.select("link[href]");
                for (Element stylee : style) {

                    System.out.println("css   :  " + stylee.attr("href") + "type of rel : " + stylee.attr("rel"));
                    if (stylee.attr("rel").equals("stylesheet")) {
                        String Css_src = stylee.attr("abs:href");
                        System.out.println("SSSSSSSSSSSSSSSSS" + Css_src);
                        D_css.download_css(Css_src, css_path);
                        stylee.removeAttr("href");
                        stylee.attr("href", ("./css/" + D_css.strCssName));
                    }

                    if ((stylee.attr("rel").equals("icon")) || (stylee.attr("rel").equals("shortcut icon")) || (stylee.attr("rel").equals("apple-touch-icon")) || (stylee.attr("rel").equals("image_src")) || stylee.attr("rel").equals("image_src")) {
                        String img_src = stylee.attr("abs:href");
                        D_img.downloadImage(img_src, img_path);
                        stylee.removeAttr("href");
                        stylee.attr("href", ("./images/" + D_img.strImageName));

                    }
                }

                //img
                System.out.println("all the images in the website: ");
                Elements images = doc.getElementsByTag("img");
                for (Element image : images) {

                    String image_src = GetSrc(image);

                    System.out.println("src     :" + image_src);

                    D_img.downloadImage(image_src, img_path);//بس إعمل تابع تحميل الصوؤة بستدعيه هون
                    image.removeAttr(Getnameattr(image));
                    image.attr("src", ("./images/" + D_img.strImageName));
                }

                //js
                Elements script = doc.getElementsByTag("script");
                for (Element scriptee : script) {
                    String js_data = GetjsSrc(scriptee);
                    D_Js.download_js(js_data, js_path);
                    if (scriptee.hasAttr("src") || scriptee.hasAttr("data-src") || script.hasAttr("data-lazy-src") || scriptee.hasAttr("async src")) {
                        scriptee.removeAttr(Getjsnameattr(scriptee));
                        scriptee.attr("src", ("./js/" + D_Js.strJSName));
                    }
                }

                //html
                Elements Html = doc.getElementsByTag("html");
                for (Element htmlee : Html) {
                    if ((Html != script) && (Html != style)) {
                        String html_data = htmlee.toString();
                        html_file.write(html_data);
                    }
                    html_file.close();
                }
               // e = 2;
            }
            System.out.println("\n finish " + (++i));
        } catch (SocketException em) {
            System.out.println("not response from the server!!There is no Enternet");
        } catch (IllegalArgumentException e) {
            System.out.println("link is wrong type");
        } catch (UnknownHostException e) {
            System.out.println("no internet");
        } catch (SocketTimeoutException e) {
            System.out.println("Poor connection");
        }

    }
}
