package android.stakbrowser.amitrai.retrofitexample.Adapters;

import android.content.Context;
import android.stakbrowser.amitrai.retrofitexample.Modal.NavigationOptionModal;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by amitrai on 28/1/16.
 */
public class NavigationItemAdapter extends RecyclerView.Adapter<NavigationItemAdapter.NavigationItemHolder> {

    private Context context = null;
    private static NavigationListener listener = null;

    public interface NavigationListener{
        public void onNavigatorClicked(int position);
    }

    private List<NavigationOptionModal> list_navigation = Collections.emptyList();

    public NavigationItemAdapter(Context context, List<NavigationOptionModal> list_navigation, NavigationListener listener){
        this.context = context;
        this.list_navigation = list_navigation;
        NavigationItemAdapter.listener = listener;
    }

    @Override
    public NavigationItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_navigation, parent, false) ;
        return new NavigationItemHolder(view);
    }

    @Override
    public void onBindViewHolder(NavigationItemHolder holder, int position) {
        NavigationOptionModal navigationOptionModal = list_navigation.get(position);
        if(navigationOptionModal != null){
            holder.txt_option_item.setText(navigationOptionModal.getOption_name());

            if(navigationOptionModal.getOption_id() != null)
                holder.img_option_item.setImageDrawable(navigationOptionModal.getOption_id());
        }
    }

    @Override
    public int getItemCount() {
        return list_navigation.size();
    }

    public static class NavigationItemHolder extends RecyclerView.ViewHolder {

        private TextView txt_option_item = null;
        private ImageView img_option_item = null;

        public NavigationItemHolder(View itemView) {
           super(itemView);
            txt_option_item = (TextView) itemView.findViewById(R.id.txt_option);
            img_option_item = (ImageView) itemView.findViewById(R.id.img_option);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNavigatorClicked(getAdapterPosition());
                }
            });
       }


   }
}
