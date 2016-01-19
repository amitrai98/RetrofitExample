package android.stakbrowser.amitrai.retrofitexample.Backend;

import android.stakbrowser.amitrai.retrofitexample.Modal.DataModal;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by amitrai on 18/1/16.
 */
public interface StakBrowserApi {

    @GET("/api/v1/search?&apiKey=f92ecd00-d3ed-11e2-a6db-e9a269320bf6&accessType=TYPE&ipAddress=9.9.9.9")
    Call<DataModal> loadData(@Query("q") String query);
}
