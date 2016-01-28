package android.stakbrowser.amitrai.retrofitexample.Fragments;

import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakWeblistener;
import android.demo.amitrai.staksdk.StakSearch;
import android.net.Uri;
import android.os.Bundle;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentWebSearch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentWebSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWebSearch extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btn_search = null;
    private TextView edt_search = null;
    private ProgressBar progressBar = null;
    private WebView webView = null;
    private Context context = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentWebSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWebSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWebSearch newInstance(String param1, String param2) {
        FragmentWebSearch fragment = new FragmentWebSearch();
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
        View view =inflater.inflate(R.layout.fragment_fragment_web_search, container, false);
        context = getActivity();
        initView(view);
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


    private void initView(View view){
        edt_search = (TextView) view.findViewById(R.id.edt_query);
        btn_search = (Button) view.findViewById(R.id.btn_search);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        webView = (WebView) view.findViewById(R.id.web_view);

        btn_search.setOnClickListener(this);
        edt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    submitSearch();
                }
                return false;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_search:
                submitSearch();
                break;
        }
    }


    private void submitSearch(){

        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);

        final String searchtext = edt_search.getText().toString().trim();

        if(edt_search.getText() == null || searchtext.length() == 0){
            edt_search.setError("Canmot search empty string");
            edt_search.requestFocus();
        }else {
            new StakSearch(new StakWeblistener() {
                @Override
                public void onProgresStarted() {
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onProgressFinished() {
                    progressBar.setVisibility(View.GONE);
                }
            }).search(searchtext, context, webView);
        }
    }
}
