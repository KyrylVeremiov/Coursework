package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class SearchFragment extends Fragment {
    private static final String TAG="MyLogs";
    private static final String ARG_ACTIVITY = "ARG_ACTIVITY";
    private static int paramsCount=14;
    private static String[] params;
    private static SearchActivity searchActivity;
    private static Fragment fragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        params=new String[paramsCount];
        fragment=this;


//        Bundle args = getArguments();
//        if (args != null) {
//        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.search_fragment, container, false);


        Button mButton=view.findViewById(R.id.search_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateParams();
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().hide(fragment).add(R.id.fragment_container,SearchResultFragment.newInstance(params)).commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void updateParams(){
        for(int i=0;i<paramsCount;i++){
            int id=getResources().getIdentifier("param"+(i+1),"id", Objects.requireNonNull(getActivity()).getPackageName());
            EditText editText=getActivity().findViewById(id);
            params[i] =editText.getText().toString();
        }
    }
}
