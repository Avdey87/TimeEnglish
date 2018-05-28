package com.aavdeev.timeenglish;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WatchFragment extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_watch, container, false);
        runTimer(layout);
        Button startButton = layout.findViewById(R.id.buttonStart);
        startButton.setOnClickListener(this);
        Button stopButton = layout.findViewById(R.id.buttonStop);
        stopButton.setOnClickListener(this);
        Button resumeButton = layout.findViewById(R.id.buttonResume);
        resumeButton.setOnClickListener(this);

        return layout;
    }



    private void runTimer(View view) {
        final TextView timer = view.findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%2d:%02d:%02d", hour, minutes, sec);
                timer.setText(time);

                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickedStop(View view) {
        running = false;
    }

    public void onClickResume(View view) {
        running = false;
        seconds = 0;
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            wasRunning = running;
            running = true;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                onClickStart(v);
                break;
            case R.id.buttonStop:
                onClickedStop(v);
                break;
            case R.id.buttonResume:
                onClickResume(v);
                break;
        }
    }
}
