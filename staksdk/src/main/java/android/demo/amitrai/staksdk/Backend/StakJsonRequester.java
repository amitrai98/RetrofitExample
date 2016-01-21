package android.demo.amitrai.staksdk.Backend;

import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.StakUtil.AppConstants;
import android.util.Log;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakJsonRequester implements Callback<JSONObject> {

    private StakListener listener = null;

    public StakJsonRequester(Context context, String query, StakListener listener){
        this.listener = listener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_STAK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StakBrowserApi stakAPI = retrofit.create(StakBrowserApi.class);

        Call<JSONObject> call = stakAPI.loadData(query);
        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
        if(response != null){
            JSONObject jrsopnse = response.body();
            String respo = response.toString();
//            DataModal body = response.body();
//            Log.e("data receive3d", ""+body);
            listener.onJsonReceived(jrsopnse);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e("error", "error");
        listener.onJsonReceived(null);
    }
}
