package android.stakbrowser.amitrai.retrofitexample.Modal;

import android.graphics.drawable.Drawable;

/**
 * Created by amitrai on 28/1/16.
 */
public class NavigationOptionModal {

    String option_name = null;
    Drawable option_id = null;


    public NavigationOptionModal(String option_name, Drawable option_id){
        this.option_name = option_name;
        this.option_id = option_id;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }

    public Drawable getOption_id() {
        return option_id;
    }

    public void setOption_id(Drawable option_id) {
        this.option_id = option_id;
    }
}
