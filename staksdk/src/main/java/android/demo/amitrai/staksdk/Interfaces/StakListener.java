package android.demo.amitrai.staksdk.Interfaces;

import android.demo.amitrai.staksdk.Modal.KiTAG;

import java.util.List;

/**
 * Created by amitrai on 20/1/16.
 */
public interface StakListener {

    public void onJsonReceived(List<KiTAG> jsonobject_response);
    public void onFailure(String message);

}


