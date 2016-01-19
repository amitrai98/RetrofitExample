package android.demo.amitrai.staksdk.Interfaces;

public interface SpeechListener {
    public void onVoiceResult(String query);
    public void onRecognizerFailed();
}