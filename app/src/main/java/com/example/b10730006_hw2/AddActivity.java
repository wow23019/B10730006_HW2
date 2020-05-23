package com.example.b10730006_hw2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText add_Name;
    private EditText add_Number;
    private Button add_Ok;
    private Button add_Cancel;
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add_Name=(EditText)findViewById(R.id.add_name);
        add_Number=(EditText)findViewById(R.id.add_number);
        add_Ok=(Button) findViewById(R.id.add_ok);
        add_Cancel=(Button) findViewById(R.id.add_cancel);

        add_Ok.setOnClickListener(new View.OnClickListener() {

            /**
             * The onClick method is triggered when this button (mDoSomethingCoolButton) is clicked.
             *
             * @param v The view that is clicked. In this case, it's mDoSomethingCoolButton.
             */
            @Override
            public void onClick(View v) {
                if (add_Name.getText().length() == 0 ||
                        add_Number.getText().length() == 0) {
                    return;
                }
                String name= add_Name.getText().toString();
                int number=1 ;//default

                try {
                    number = Integer.parseInt(add_Number.getText().toString());
                } catch (NumberFormatException ex) {
                    Log.e(LOG_TAG, "Failed to parse party size text to number: " + ex.getMessage());
                }

                Context context = AddActivity.this;
                Class destinationActivity = MainActivity.class;

                Intent startMainActivityIntent = new Intent(context, destinationActivity);
                Guest guest=new Guest();
                guest.setName(name);
                guest.setNumber(number);
                startMainActivityIntent.putExtra("GUEST",guest);

                add_Name.getText().clear();
                add_Number.getText().clear();

                startActivity(startMainActivityIntent);
            }
        });

        add_Cancel.setOnClickListener(new View.OnClickListener() {

            /**
             * The onClick method is triggered when this button (mDoSomethingCoolButton) is clicked.
             *
             * @param v The view that is clicked. In this case, it's mDoSomethingCoolButton.
             */
            @Override
            public void onClick(View v) {
                Context context = AddActivity.this;
                Class destinationActivity = MainActivity.class;

//                add_Name.getText().clear();
//                add_Number.getText().clear();

                Intent startMainActivityIntent = new Intent(context, destinationActivity);
                startActivity(startMainActivityIntent);
            }
        });
    }
}
