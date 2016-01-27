package android.demo.amitrai.staksdk.Backend;

import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.StakUtil.AppConstants;
import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakJsonRequester implements Callback<KitagList> {

    private StakListener listener = null;
    private final String TAG = getClass().getSimpleName();

    public StakJsonRequester(Context context, String query, StakListener listener){
        this.listener = listener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_STAK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StakBrowserApi stakAPI = retrofit.create(StakBrowserApi.class);

        Call<KitagList> call = stakAPI.loadData(query);
        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<KitagList> response, Retrofit retrofit) {
        if(response != null){
//            JSONObject jrsopnse = response.body();
                KitagList respo = response.body();
//            DataModal body = response.body();
//            Log.e("data receive3d", ""+body);
            listener.onJsonReceived(respo.getKiTAGS());
//            Log.e(TAG, ""+respo);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e("error", "error");
        listener.onFailure(""+t.getMessage());
    }
}
