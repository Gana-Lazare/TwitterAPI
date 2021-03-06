package common;





import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class RestApi {
    protected String apiKey;
    protected String apiSecretKey;
    protected String accessToken;
    protected String accessTokenSecret;
    protected Properties properties;
    protected InputStream inputStream;
    protected String baseUrl;

    public RestApi() {

        this.baseUrl="https://api.twitter.com/1.1";
        this.properties= new Properties();
        inputStream=null;
        try{
            //read the secret propreties file
          this .inputStream=new FileInputStream("C:\\Users\\micromedia\\IdeaProjects\\RestApiGana\\TwiterApi\\secret.properties");
          this.properties.load(this.inputStream);
          this.apiKey=this.properties.getProperty("apiKey");
          this.apiSecretKey=this.properties.getProperty("apiSecretKey");
          this.accessToken=this.properties.getProperty("accessToken");
          this.accessTokenSecret=this.properties.getProperty("accessTokenSecret");

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("File not load Properly");
        }
        finally {
            try {
                this.inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }







}
