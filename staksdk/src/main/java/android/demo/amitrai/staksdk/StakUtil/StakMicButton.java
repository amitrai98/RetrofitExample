package android.demo.amitrai.staksdk.StakUtil;

import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.R;
import android.demo.amitrai.staksdk.StakSearch;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by amitrai on 20/1/16.
 */
public class StakMicButton extends Button implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    StakListener listener ;

    public StakMicButton(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public StakMicButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public StakMicButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
    }

    public StakMicButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnClickListener(this);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(getResources().getDrawable(R.drawable.mic_image_blue));
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText("", type);
    }

    @Override
    public void onClick(View v) {
        if(StakSearch.listener != null)
            StakSearch.listener.startListening();
    }

}
