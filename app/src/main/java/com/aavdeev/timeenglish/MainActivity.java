package com.aavdeev.timeenglish;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements ListEnglishTimeFragment.ListEnglishTimeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View container = findViewById(R.id.containerDescription);
        if (container != null) {
            DescriptionEnglishTimeFragment descrition = new DescriptionEnglishTimeFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            descrition.setEnglishTimeID(id);
            ft.replace(R.id.containerDescription, descrition);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
}
