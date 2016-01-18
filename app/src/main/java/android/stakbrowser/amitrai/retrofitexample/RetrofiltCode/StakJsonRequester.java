package android.stakbrowser.amitrai.retrofitexample.RetrofiltCode;

import android.content.Context;
import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by amitrai on 18/1/16.
 */
public class StakJsonRequester implements Callback<DataModal> {

    public StakJsonRequester(Context context, String query){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_STAK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StakBrowserApi stakAPI = retrofit.create(StakBrowserApi.class);

        Call<DataModal> call = stakAPI.loadData(query);
        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<DataModal> response, Retrofit retrofit) {
        if(response != null){
            String respo = response.toString();
            DataModal body = response.body();
            Log.e("data receive3d", ""+body);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e("error", "error");
    }
}
