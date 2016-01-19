package android.demo.amitrai.staksdk.StakUtil;

import android.util.Log;

/**
 * Created by amitrai on 19/1/16.
 */
public class StakLogger {

    private static boolean isLoggerEnabled=true;
    public static void log(String tag,String message){
        if(isLoggerEnabled){
            Log.d(tag, message);
        }
    }
}
