package com.example.sharif.sliders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    AppCompatSeekBar compatSeekBar;
    TextView seekbar_value,rangeBar_value;
    RangeBar rangeBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        compatSeekBar = findViewById(R.id.appcompat_seekbar_id);
        seekbar_value = findViewById(R.id.seek_bar_value);
        compatSeekBar.setProgress(0);
        compatSeekBar.setKeyProgressIncrement(1);
        compatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println(progress);
                seekbar_value.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                System.out.println("OnStartTrakingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("OnStopTrackingTouch");
            }
        });
        rangeBar_value = findViewById(R.id.range_bar_value);

        rangeBar1 = findViewById(R.id.ranBar1_id);
        rangeBar1.setSeekPinByIndex(0);
        rangeBar1.setSelectorColor(getResources().getColor(R.color.colorConnectingColor));
        rangeBar1.setPinTextColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setTickColors(getResources().getColor(R.color.colorAccent));
        rangeBar1.setConnectingLineColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                System.out.println("Right PIN value: "+rightPinValue);
                System.out.println("Left PIN value: "+leftPinValue);
                rangeBar_value.setText(rightPinValue);
            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }
        });

    }
}
