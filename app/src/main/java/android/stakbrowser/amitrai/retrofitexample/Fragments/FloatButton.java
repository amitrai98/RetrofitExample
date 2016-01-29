package android.stakbrowser.amitrai.retrofitexample.Fragments;

import android.app.Activity;
import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.Modal.KiTAG;
import android.demo.amitrai.staksdk.StakSearch;
import android.net.Uri;
import android.os.Bundle;
import android.stakbrowser.amitrai.retrofitexample.Adapters.JsonResultAdapter;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.stakbrowser.amitrai.retrofitexample.R;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FloatButton.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FloatButton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FloatButton extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Activity context = null;


    protected final String TAG = getClass().getSimpleName();

    private JsonResultAdapter adapter = null;

    private List<KiTAG> resonse = new ArrayList<>();

    private RecyclerView recycle_result_list = null;
    private ProgressBar progress = null;
    private EditText edt_query = null;


    public FloatButton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FloatButton.
     */
    // TODO: Rename and change types and number of parameters
    public static FloatButton newInstance(String param1, String param2) {
        FloatButton fragment = new FloatButton();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_float_button, container, false);
                initview(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initview(View view){
        recycle_result_list = (RecyclerView) view.findViewById(R.id.recycle_result_list);
        progress = (ProgressBar) view.findViewById(R.id.progress);
        edt_query = (EditText) view.findViewById(R.id.edt_query);
        setJsonListener();

    }

    private void setJsonListener(){
        StakSearch search = new StakSearch(context, new StakListener() {
            @Override
            public void onJsonReceived(List<KiTAG> resonse) {
                FloatButton.this.resonse = resonse;
                Log.e(TAG, "" + resonse);
                if(resonse != null){
                    adapter = new JsonResultAdapter(context, FloatButton.this.resonse = resonse);
                    recycle_result_list.setAdapter(adapter);
                    progress.setVisibility(View.GONE);
                    recycle_result_list.setVisibility(View.VISIBLE);
                    recycle_result_list.setLayoutManager(new LinearLayoutManager(context));
                    if(resonse.size() >0 && resonse.get(0).getSearchString() != null)
                        edt_query.setText(resonse.get(0).getSearchString());
                }
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, ""+message);
            }

            @Override
            public void onListeningStart() {
                progress.setVisibility(View.VISIBLE);
                Log.e(TAG, "progress start");
//                resonse.clear();
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onVoiceDataReceived(String query) {
                edt_query.setText(query);
            }
        });

    }

}
