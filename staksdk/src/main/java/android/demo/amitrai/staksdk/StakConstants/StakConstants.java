package android.demo.amitrai.staksdk.StakConstants;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakConstants {

    // api key
    private final String API_KEY = "";

    public final static int VOICE_LISTENING_REQUEST_CODE = 342;

    // search url
    public static final String BASE_STAK_URL = "http://appqa.oyokey.com:3000/";

    // search url
    //http://192.168.1.236:3000/gettaghtml?keyword=call&ipAddress=&os=Win32&browser=&device=&resolution=&language=&accessType=TYPE&city=&country=&domain=evontech.com
    public static final String BASE_URL = "http://appqa.oyokey.com:3000/";

    // search url
    //http://192.168.1.236:3000/getkeytaghtml?q=tech&ipAddress=&os=Win32&browser=&device=&resolution=&language=&accessType=TYPE&city=&country=
    public static final String BASE_DOMAIN_SEARCH_URL = "http://appqa.oyokey.com:3000/";


    public static String apiKey="f92ecd00-d3ed-11e2-a6db-e9a269320bf6";
    public static String getWebUISearchUrl(){
        return BASE_URL+"searchn?q=";

    }
    public static String getkeytagSearchUrl(){
        return BASE_URL+"keytagsearch?q=";
    }

    public static String getSearchUrl(){
        return BASE_URL+"getkeytaghtml?q=";
    }

    public static String getDomainSearchUrl(){
        return BASE_DOMAIN_SEARCH_URL+"gettaghtml?keyword=";
    }

    /**
     * returns url with for detail card.
     * @return
     */
    public static String getDetailCardUrl(){
        return BASE_URL+"keyworddetail?domain=";
//        return urlBase+"keyworddetail?";

    }

    /**
     * returns url with for detail card.
     * @return
     */
    public static String getDetailCardSearchUrl(){
        return BASE_URL+"keyworddetail?searchn=";
    }


}
