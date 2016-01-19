package android.demo.amitrai.staksdk.StakUtil;

import android.app.Activity;
import android.content.Intent;
import android.demo.amitrai.staksdk.Activities.VoiceListeningDailogActivity;
import android.demo.amitrai.staksdk.R;
import android.demo.amitrai.staksdk.StakConstants.StakConstants;
import android.graphics.PixelFormat;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by amitrai on 19/1/16.
 */
public class AddMic{

    private static ImageView chatHead;
    private static WindowManager windowManager;
    public static Activity activity = null;
    private static WebView webView = null;
    private static String searchQuery = null;




    public static void addMic(final Activity context , final WebView webView){
        activity = context;
         windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);

         chatHead = new ImageView(context);
         chatHead.setImageResource(R.drawable.mic_image_blue);

         WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                 WindowManager.LayoutParams.WRAP_CONTENT,
                 WindowManager.LayoutParams.WRAP_CONTENT,
                 WindowManager.LayoutParams.TYPE_PHONE,
                 WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                 PixelFormat.TRANSLUCENT);


        Display display = context.getWindowManager().getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();

         params.gravity = Gravity.TOP | Gravity.LEFT;
         params.x = screenWidth;
         params.y = screenHeight;

        chatHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VoiceListeningDailogActivity.class);
                i.putExtra("isDialog", true);
                context.startActivityForResult(i, StakConstants.VOICE_LISTENING_REQUEST_CODE);
            }
        });

         windowManager.addView(chatHead, params);
     }



}
