package com.aavdeev.timeenglish;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListEnglishTimeFragment extends ListFragment {

interface ListEnglishTimeListener {
    void itemClicked(long id);
}

    private ListEnglishTimeListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] listTieme = new String[EnglishTime.timeList.length];
        for (int i = 0; i<listTieme.length;i++) {
            listTieme[i] = EnglishTime.timeList[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, listTieme);

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.listener = (ListEnglishTimeListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
