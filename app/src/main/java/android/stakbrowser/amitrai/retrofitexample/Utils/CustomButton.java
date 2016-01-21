package android.stakbrowser.amitrai.retrofitexample.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by amitrai on 20/1/16.
 */
public class CustomButton extends Button implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    public CustomButton(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

    }
}
