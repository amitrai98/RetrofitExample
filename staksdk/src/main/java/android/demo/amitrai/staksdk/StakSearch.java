package android.demo.amitrai.staksdk;

import android.content.Context;
import android.demo.amitrai.staksdk.StakConstants.AnalyticsUrlManager;
import android.demo.amitrai.staksdk.StakConstants.StakConstants;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakSearch{

    private static String searchUrl = null;

    private static String analyticsUrl = null;

    private static Animation mSlideUpAnimation = null;

    public static void search(String searchQuery, Context context, WebView webView){

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


    /**
     * initializing web view
     * @param webView
     */
    private static void initWebView(final WebView webView, Context context){

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




    /**
     * Method will start the animation and toggle visibility of other views
     */
    private static void startLoading(WebView webview) {
        webview.setVisibility(View.INVISIBLE);
    }

    /**
     * Method will stop the animation and toggle visibility of other views
     */
    private static void stopLoading(WebView webview) {
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.KITKAT) {
//            webview.startAnimation(mSlideUpAnimation);
        }
        webview.setVisibility(WebView.VISIBLE);
    }

}
