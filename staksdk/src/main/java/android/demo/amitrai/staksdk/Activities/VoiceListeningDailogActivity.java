package android.demo.amitrai.staksdk.Activities;

import android.app.Activity;
import android.content.Intent;
import android.demo.amitrai.staksdk.Interfaces.SpeechListener;
import android.demo.amitrai.staksdk.R;
import android.demo.amitrai.staksdk.StakUtil.NetworkConnection;
import android.demo.amitrai.staksdk.StakUtil.StakBrowserSpeechRecognizer;
import android.demo.amitrai.staksdk.StakUtil.StakLogger;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * @Page/VoiceListeniVoiceListeningDailogActivitygActivity.java:
 * @Author Ajmer Singh:
 * @Date: 20 July 2015
 * @Purpose: VoiceListeningDailogActivity used as a utility class to provide Speech Recognition functionality as a Dailog
 * 1. Starting the VoiceListeningActivity from Any other activity using startActivityForResult.
 * 2. When VoiceListeningDailogActivity finishes it set the result as string extra i.e parameter name is "query"
 * 3. This activity will utilise the StakBrowserSpeechRecognizer util.
 * 4. Implements the SpeechListener interface to pass the text back to VoiceListeningActivity from StakBrowserSpeechRecognizer..
 **/
public class VoiceListeningDailogActivity extends Activity implements SpeechListener,View.OnClickListener {
    //    private ImageView imMicImageView=null;
    private ImageButton imCloseButton=null;
    private ImageView imRecordImageView=null;

    private AnimationSet animationSet=null;

    private ImageView img_stop_listening = null;

    public static Activity act = null;

    private RelativeLayout layout_cancel = null;


    private StakBrowserSpeechRecognizer stakBrowserSpeechRecognizer =null;

    private MicClickListener        micClickListener=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_up, R.anim.stay);

        setContentView(R.layout.activity_voice_listening_dialog);

        act = this;
        //Initializing the StakBrowserSpeechRecognizer
        stakBrowserSpeechRecognizer = StakBrowserSpeechRecognizer.getInstance(act);
        //Setting the stakBrowserSpeechRecognizer SpeechListener to this
        stakBrowserSpeechRecognizer.setSpeechListener(this);
        initId();
        initAnimation();
//        enableAnimation(true);
        startVoiceListening();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(StakBrowserSpeechRecognizer.stakBrowserSpeechRecognizer != null)
            StakBrowserSpeechRecognizer.stakBrowserSpeechRecognizer.destroy();
//        AppConstants.AUTO_LISTENING = true;
//
//        if(stakBrowserSpeechRecognizer !=null){
//            stakBrowserSpeechRecognizer.destroy();
//        }

    }

    @Override
    public void finish() {
        if(StakBrowserSpeechRecognizer.stakBrowserSpeechRecognizer != null)
            StakBrowserSpeechRecognizer.stakBrowserSpeechRecognizer.destroy();

        StakBrowserSpeechRecognizer.stakBrowserSpeechRecognizer = null;
        super.finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_down);
    }

    /**
     * Initializing the views ids from layout.
     */
    private void initId(){
        micClickListener    =   new MicClickListener();
//        imMicImageView      =   (ImageView)this.findViewById(R.id.imMicImageView);

//        imMicImageView.setOnClickListener(micClickListener);
        layout_cancel = (RelativeLayout) findViewById(R.id.layout_cancel);
        imCloseButton       =  (ImageButton)this.findViewById(R.id.imCloseButton);
        img_stop_listening  =  (ImageView)this.findViewById(R.id.img_stop_listening);
        imRecordImageView   =   (ImageView)this.findViewById(R.id.imRecordImageView);
        img_stop_listening.setOnClickListener(this);

        layout_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * Method will intializse the Alpha Animation for RED dot,
     *
     */
    private void initAnimation(){
        animationSet=new AnimationSet(true);
        AlphaAnimation micAnimation = new AlphaAnimation(1, 0.5f); // Change alpha from fully visible to invisible
        micAnimation.setDuration(500); // duration - half a second
        micAnimation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        micAnimation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        micAnimation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        animationSet.addAnimation(micAnimation);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.img_stop_listening){
            finish();
        }
    }

    class MicClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (NetworkConnection.isConnectedToNetwork(VoiceListeningDailogActivity.this)) {
//                enableAnimation(true);
                startVoiceListening();
            }
            else{
                Toast.makeText(getApplicationContext(),
                        getString(R.string.no_internet_connection_Closing), Toast.LENGTH_SHORT)
                        .show();
                finish();
            }
        }
    }
    /**
     * Enable or Disable Mic Animation based on the boolean value;
//     * @param enableAnimation
     */
//    private void enableAnimation(boolean enableAnimation){
//        if(enableAnimation) {
//            imRecordImageView.setVisibility(ImageView.VISIBLE);
//            imRecordImageView.startAnimation(animationSet);
//        }
//        else{
//            imRecordImageView.setVisibility(ImageView.INVISIBLE);
//            imRecordImageView.clearAnimation();
//        }
//    }
    private void onSearchSubmit(String query){
        //set the query as a result and then finish
        Intent resultIntent=new Intent();
        resultIntent.putExtra("query", query);
        this.setResult(23,resultIntent);
        finish();
    }
    /**
     * Function to stop Voice listening if Speech Recognition is working. T
     * his method will also stop the Mic animation.`
     */
    private void stopVoiceListeningIfEnabled(){
//        enableAnimation(false);
    }

    /**
     * Function to start Voice listening using Android Speech Recognition.
     * This method will also initiate the Mic animation.
     */
    private void startVoiceListening(){
//        enableAnimation(true);
        stakBrowserSpeechRecognizer.startSpeechEngine();
    }

    @Override
    public void onVoiceResult(String query) {
        stopVoiceListeningIfEnabled();
        if(query!=null) {
            StakLogger.log("StakBrowser queries ", query);

            onSearchSubmit(query);
        }
        else{
            StakLogger.log("StakBrowser queries null", "");
            finish();
        }
    }
    @Override
    public void onRecognizerFailed() {
        stopVoiceListeningIfEnabled();
        Toast.makeText(this, "Voice Recognizer not available.", Toast.LENGTH_SHORT).show();
        finish();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        AppConstants.AUTO_LISTENING = false;
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        AppConstants.AUTO_LISTENING = true;
//    }
}