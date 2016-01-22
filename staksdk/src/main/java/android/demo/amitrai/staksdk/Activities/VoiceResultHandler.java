package android.demo.amitrai.staksdk.Activities;

import android.app.Activity;
import android.content.Intent;
import android.demo.amitrai.staksdk.StakConstants.StakConstants;
import android.demo.amitrai.staksdk.StakSearch;
import android.os.Bundle;

/**
 * Created by amitrai on 20/1/16.
 */
public class VoiceResultHandler extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, VoiceListeningDailogActivity.class);
        i.putExtra("isDialog", true);
        startActivityForResult(i, StakConstants.VOICE_LISTENING_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == StakConstants.VOICE_LISTENING_REQUEST_CODE) {

            if (data != null) {
                String searchQuery = data.getStringExtra("query");
                if (searchQuery != null) {
                    searchQuery = searchQuery.toLowerCase();
                    StakSearch.speechListener.onVoiceResult(searchQuery);
                }
            }
        }
        finish();


    }
}
