package android.demo.amitrai.staksdk.StakConstants;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Created by amitrai on 18/1/16.
 */
public class AnalyticsUrlManager {

    private AnalyticsUrlManager(){

    }
    private static AnalyticsUrlManager analyticsUrlManager=null;
    public static AnalyticsUrlManager getInstance(Context _context){
        if(analyticsUrlManager==null){
            analyticsUrlManager=new AnalyticsUrlManager();
        }
        context=_context;
        return analyticsUrlManager;
    }
    static Context context=null;
    public String getAnalyticsurl(String accessType,boolean withDomainParam,String currentSelectedDomain){
        String resolution=getDeviceResolution();
        String ipAddress=getLocalIpAddress();
        String deviceLanguage=getDeviceLanguage();
        String deviceversion=getDeviceVersion();
        String browser=getBrowserNameUrl();
        String os=getOSName();
        String city=getcityUrl();
        String country=getCountryUrl();

        StringBuffer analyticsurl=new StringBuffer();
        if(resolution!=null){
            analyticsurl.append("&resolution="+resolution);
        }
        if(accessType!=null){
            analyticsurl.append("&accessType="+accessType);
        }
        if(ipAddress!=null){
            analyticsurl.append("&ipAddress="+ipAddress);
        }
        if(deviceLanguage!=null){
            analyticsurl.append("&language="+deviceLanguage);
        }
        if(deviceversion!=null){
            analyticsurl.append("&device="+deviceversion);
        }
        if(browser!=null){

            analyticsurl.append("&browser="+browser);
        }
        if(os!=null){
            analyticsurl.append("&os="+os);
        }
        if(country!=null){
            analyticsurl.append("&country="+country);
        }
        if(city!=null){
            analyticsurl.append("&city="+city);
        }
        if(withDomainParam){
            if(currentSelectedDomain!=null){
                analyticsurl.append("&domain="+currentSelectedDomain);
            }
        }
        return analyticsurl.toString();
    }
    // extracting the device resolution information.
    public String getDeviceResolution(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        String resolution=screenWidth+"x"+screenHeight;
        return resolution;
    }
    //extracting device's current langauge
    public String getDeviceLanguage(){
        String language= Locale.getDefault().getDisplayLanguage();
        return Uri.encode(language);
    }
    //extracting device's version information
    public String getDeviceVersion(){
        String deviceVersion = Build.BRAND;
        return Uri.encode(deviceVersion);
    }
    public String getcityUrl(){
        // LocationManager locationManager=new LocationManager.getInstance(this);
        //return locationManager.getCity();
        return null;
    }
    public String getCountryUrl(){
        //LocationManager locationManager=new LocationManager.getInstance(this);
        //return locationManager.getCountry();
        return null;
    }

    //extracting device's browser user agent string
    public String getBrowserNameUrl(){
        //String ua=System.getProperty( "http.agent" );
        try {
            String ua=new WebView(context).getSettings().getUserAgentString();
            if(ua!=null){
                return Uri.encode(ua);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //extracting device's browser user agent string
    public String getOSName(){
        String deviceName = "Android "+ Build.VERSION.RELEASE;
        return Uri.encode(deviceName);
    }
    //extracting device's ip address information.
    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
