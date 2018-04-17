package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by sudhanshu on 4/17/18.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }


    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int list = position/12;
        int imageIndex = position - 12*list;

        switch (list) {
            case 1:
                headIndex = imageIndex;
                break;
            case 2:
                bodyIndex = imageIndex;
                break;
            case 3:
                legIndex = imageIndex;
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);


        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}
