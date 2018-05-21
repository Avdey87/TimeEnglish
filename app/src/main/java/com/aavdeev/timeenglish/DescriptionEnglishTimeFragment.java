package com.aavdeev.timeenglish;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionEnglishTimeFragment extends Fragment {

    private long englishTimeID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            englishTimeID = savedInstanceState.getLong("englishTimeID");
        } else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            WatchFragment watchFragment = new WatchFragment();
            ft.replace(R.id.)
        }

        return inflater.inflate(R.layout.fragment_description_english_time, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            EnglishTime timeList = EnglishTime.timeList[(int) englishTimeID];
            TextView name = view.findViewById(R.id.nameEnglishTime);
            name.setText(timeList.getName());
            TextView description = view.findViewById(R.id.descriptionEnglishTime);
            description.setText(timeList.getDescription());

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("englishTimeID",englishTimeID);
    }

    public void setEnglishTimeID(long englishTimeID) {
        this.englishTimeID = englishTimeID;
    }
}
