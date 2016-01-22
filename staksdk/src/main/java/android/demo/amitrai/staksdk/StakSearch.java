package android.demo.amitrai.staksdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.demo.amitrai.staksdk.Activities.VoiceResultHandler;
import android.demo.amitrai.staksdk.Backend.StakJsonRequester;
import android.demo.amitrai.staksdk.Interfaces.SpeechListener;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.Interfaces.VoiceListener;
import android.demo.amitrai.staksdk.StakConstants.AnalyticsUrlManager;
import android.demo.amitrai.staksdk.StakConstants.StakConstants;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakSearch implements VoiceListener, SpeechListener{

    private  String searchUrl = null;

    private  String analyticsUrl = null;

    private  Animation mSlideUpAnimation = null;

    private  ImageView chatHead;
    private  WindowManager windowManager;
    public  static  Activity activity = null;
    private  WebView webView = null;
    private  String searchQuery = null;
    public static  VoiceListener listener = null;
    public static SpeechListener speechListener = null;
    private static StakListener stakListener = null;
    private  final String TAG = StakSearch.class.getSimpleName();

    public StakSearch(Activity activity, StakListener stakListener){
        listener = this;
        this.stakListener = stakListener;
        speechListener = this;
        this.activity = activity;
    }

    public  void search(String searchQuery, Context context, WebView webView){

        if(searchQuery == null || searchQuery.trim().length() == 0 || context == null || webView == null)
            return;
        else {
            try{
                analyticsUrl = (AnalyticsUrlManager.getInstance(context)).getAnalyticsurl("VOICE", false, null);
                searchUrl = StakConstants.getWebUISearchUrl() + Uri.encode(searchQuery.trim()) + "&apiKey=" + StakConstants.apiKey + analyticsUrl;
                initWebView(webView, context);

                startLoading(webView);
                webView.loadUrl(searchUrl);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public  void search(String searchQuery){

        if(searchQuery == null || searchQuery.trim().length() == 0 )
            return;
        else {
            try{
                // todo make api request
                Log.e(TAG, ""+searchQuery);
                new StakJsonRequester(activity, searchQuery, stakListener);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }




    /**
     * initializing web view
     * @param webView
     */
    private  void initWebView(final WebView webView, Context context){

        try{
            if (Build.VERSION.SDK_INT != Build.VERSION_CODES.KITKAT) {
//                mSlideUpAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
            }

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                public void onPageFinished(WebView view, String url) {
                   stopLoading(webView);
                }
            });
            webView.setWebChromeClient(new WebChromeClient() {
                public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                    return true;
                }

                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    //Calling the handleJSON method of WebViewClickManager to parse the JSON and perform the desire action.
                    //This console message are working as a bridge between Serch Result WebPage and Android WebView.
//                (WebViewClickManager.getInstance(ResultActivity.this)).handleJSON(consoleMessage.message(), mQuery);
                    return true;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void addMic(final Activity context , final WebView webView){
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
//                Intent i = new Intent(context, VoiceListeningDailogActivity.class);
//                i.putExtra("isDialog", true);
//                context.startActivityForResult(i, StakConstants.VOICE_LISTENING_REQUEST_CODE);

            }
        });

        windowManager.addView(chatHead, params);
    }


    /**
     * Method will start the animation and toggle visibility of other views
     */
    private void startLoading(WebView webview) {
        webview.setVisibility(View.INVISIBLE);
    }

    /**
     * Method will stop the animation and toggle visibility of other views
     */
    private void stopLoading(WebView webview) {
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.KITKAT) {
//            webview.startAnimation(mSlideUpAnimation);
        }
        webview.setVisibility(WebView.VISIBLE);
    }


    /**
     * searches the keyword received on oyokey servers
     * @param voiceResult
     */
    public  void voiceReceived(String voiceResult){
            if (voiceResult != null) {
                voiceResult = voiceResult.toLowerCase();
                if(activity != null && webView != null)
                    search(voiceResult, activity, webView);
            }

    }

    @Override
    public void startListening() {
        if(activity != null){
            Intent i = new Intent(activity, VoiceResultHandler.class);
            activity.startActivity(i);
//
//            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
//            intent.setComponent(new ComponentName("packagename//ex-com.hello",
//                    "classname//ex-com.hello.ExampleActivity"));
//            activity.startActivity(intent);


//            Toast.makeText(activity, "this is a simple toast", Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(
//                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//
//            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
//            activity.startActivity(intent);


        }

    }

    @Override
    public void onVoiceResult(String query) {
        if(query != null && query.trim().length() >0){
            search(query);
        }
    }

    @Override
    public void onRecognizerFailed() {
        Log.e(TAG, "listinig failed");
        stakListener.onJsonReceived(null);
    }
}
