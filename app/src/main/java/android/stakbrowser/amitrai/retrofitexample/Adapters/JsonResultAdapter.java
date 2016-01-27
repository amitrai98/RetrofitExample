package android.stakbrowser.amitrai.retrofitexample.Adapters;

import android.content.Context;
import android.demo.amitrai.staksdk.Modal.KiTAG;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by amitrai on 27/1/16.
 */
public class JsonResultAdapter extends RecyclerView.Adapter<JsonResultAdapter.JsonViewHolder> {

    private Context context = null;
    private  List<KiTAG> list_keytags= Collections.emptyList();


    public JsonResultAdapter(Context context, List<KiTAG> list_keytags){
        this.context = context;
        this.list_keytags = list_keytags;
    }


    @Override
    public JsonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_result, parent, false);
        return new JsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JsonViewHolder holder, int position) {
        KiTAG modal = list_keytags.get(position);
        if(modal != null){
            String result_text = "";
            if(modal.getBusinessId() != null)
                result_text += "business id ="+ modal.getBusinessId()+"\n";
            if(modal.getIsDomainCard() != null)
                result_text += "is domain card ="+ modal.getIsDomainCard()+"\n";
            if(modal.getAddress() != null)
                result_text += "address ="+ modal.getAddress()+"\n";
            if(modal.getDomain() != null)
                result_text += "domain="+ modal.getDomain()+"\n";
            if(modal.getSeo() != null)
                result_text += "business id ="+ modal.getBusinessId()+"\n";
            if(modal.getBusinessId() != null)
                result_text += "seo ="+ modal.getSeo()+"\n";
            if(modal.getId() != null)
                result_text += "id ="+ modal.getId()+"\n";
            if(modal.getKiTAG() != null)
                result_text += "key tag ="+ modal.getKiTAG() +"\n";
            if(modal.getObjects() != null)
                result_text += "business id ="+ modal.getObjects()+"\n";

            holder.txt_result.setText(""+result_text);


        }
    }

    @Override
    public int getItemCount() {
        return list_keytags.size();
    }

    public static class JsonViewHolder extends RecyclerView.ViewHolder{

        private TextView txt_result = null;

        public JsonViewHolder(View itemView) {
            super(itemView);
            txt_result = (TextView) itemView.findViewById(R.id.txt_result);
        }
    }
}
