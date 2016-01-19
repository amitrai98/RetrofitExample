package android.demo.amitrai.staksdk.StakUtil;

import android.content.Context;
import android.content.Intent;
import android.demo.amitrai.staksdk.Interfaces.SpeechListener;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

import java.util.ArrayList;

/**
 * Created by ajmersingh on 14/7/15.
 * Singleton class to create as a manager for speech listener, To use this StakBrowserSpeechRecognizer
 * 1.Class should implement SpeechListener interface.
 * 2.Set the stakBrowserSpeechRecognizer.setSpeechListener()
 * 3.On Success Speech recognition text read will be passed as parameter to the SpeechListener.onVoiceResult();
 * 4.Null is passed as parameter if no text is read or in case of error.
 */
public class StakBrowserSpeechRecognizer implements RecognitionListener {
    private static StakBrowserSpeechRecognizer stakBrowserSpeechRecognizer =null;
    private SpeechListener speechListener=null;
    private Intent speechIntent=null;


    private int error_time = 0;

    private StakBrowserSpeechRecognizer(){

    }
    public static StakBrowserSpeechRecognizer getInstance(Context context){
        if(stakBrowserSpeechRecognizer ==null){
            stakBrowserSpeechRecognizer =new StakBrowserSpeechRecognizer();
        }
        stakBrowserSpeechRecognizer.initSpeechEngine(context);
        return stakBrowserSpeechRecognizer;
    }
    public void setSpeechListener(SpeechListener speechListener){
        this.speechListener=speechListener;
    }
    private SpeechRecognizer mCommandSpeechRecognizer=null;

    public void initSpeechEngine(Context context){
        mCommandSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
        mCommandSpeechRecognizer.setRecognitionListener(this);
        speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);
        speechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                context.getPackageName());
    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }

    public void startSpeechEngine(){
        StakLogger.log("StakBrowser Speech Recogizer ", (mCommandSpeechRecognizer != null) + "");

        if(mCommandSpeechRecognizer!=null){
            mCommandSpeechRecognizer.setRecognitionListener(this);
            mCommandSpeechRecognizer.startListening(speechIntent);
        }
        else{
            mCommandSpeechRecognizer=null;
            speechListener.onRecognizerFailed();
        }

    }
    public void stopSpeechEngine(){
        if(mCommandSpeechRecognizer!=null){
//            mCommandSpeechRecognizer.stopListening();
            mCommandSpeechRecognizer.cancel();
            mCommandSpeechRecognizer.destroy();
            mCommandSpeechRecognizer = null;
        }
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {
        StakLogger.log("StakBrowser Speech Recogizer", "Ready to Speech Recongition");
    }

    @Override
    public void onBeginningOfSpeech() {
        StakLogger.log("StakBrowser Speech Recogizer", "Speech begin now");
    }

    @Override
    public void onEndOfSpeech() {
        StakLogger.log("StakBrowser Speech Recogizer", "End of Speech");
    }

    @Override
    public void onError(int i) {
        StakLogger.log("StakBrowser Speech Error", i + "");
        getErrorText(i);
        if(i == 7 ){
            if(error_time <5){
                startSpeechEngine();
            }else {

                if(speechListener!=null){
                    speechListener.onVoiceResult(null);
                }
                error_time = 0;
            }
            error_time++;
        }else{
            if(speechListener!=null){
                speechListener.onVoiceResult(null);
            }
        }
    }

    @Override
    public void onResults(Bundle bundle) {
        StakLogger.log("StakBrowser Speech Recogizer", "Result of the Speech");
        mCommandSpeechRecognizer.stopListening();
        mCommandSpeechRecognizer.cancel();
        mCommandSpeechRecognizer.destroy();
        mCommandSpeechRecognizer = null;
        if(speechListener!=null){

            ArrayList arraylist = bundle.getStringArrayList("results_recognition");
            if (arraylist.size()>0) {
                speechListener.onVoiceResult((String)arraylist.get(0));
            }
            else {

                speechListener.onVoiceResult(null);
            }
        }
    }
    public void destroy(){
        if(mCommandSpeechRecognizer!=null){
            mCommandSpeechRecognizer.cancel();
            mCommandSpeechRecognizer.destroy();
        }
    }


    /**
     * getting the error message from the error code
     * @param errorCode
     * @return
     */
    public static String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }


}
