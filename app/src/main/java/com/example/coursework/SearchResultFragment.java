package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class SearchResultFragment extends Fragment implements Observer<Search> {
    public static String[] params;
    public static final String ARG_PARAMS="ARG_PARAMS";
    private static String TAG="MyLogs (SearchResultFragment)";
    private RecyclerView recycler;
    private static Search search =null;
    private LiveData<Search> liveData;
    private static DataViewModel dataViewModel;
    final static SearchAdapter adapter = new SearchAdapter(search);


    public static SearchResultFragment newInstance(String[] params) {
        Bundle args=new Bundle();
        args.putStringArray(ARG_PARAMS,params);
        SearchResultFragment fragment = new SearchResultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            params = args.getStringArray(ARG_PARAMS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.search_result_frament, container, false);
        recycler = view.findViewById(R.id.recycler_view);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        Button mButton=view.findViewById(R.id.refresh_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataViewModel.searchData(params);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataViewModel=new ViewModelProvider(this, ((App) Objects.requireNonNull(getActivity()).getApplication()).getViewModeFactory()).get(DataViewModel.class);
        if(dataViewModel.getData().getValue()==null){
            dataViewModel.searchData(params);
        }
        liveData = dataViewModel.getData();//Api  с постоянным обновлением.
        dataViewModel.searchData(params);
        liveData.observe(this, this);
    }

    @Override
    public void onChanged(Search search) {
        adapter.setData(search);
    }
}
