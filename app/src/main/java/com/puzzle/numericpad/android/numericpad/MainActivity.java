package com.puzzle.numericpad.android.numericpad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int[] arrayAnswers = {8, 1, 3, 2, 7, 6, 3, 7, 4, 7};

    private EditText edit11, edit15, edit17,
                     edit31, edit33,
                     edit53, edit55, edit57,
                     edit71, edit75;

    private Button btnClear, btnSubmit;

    private EditText[] arrayEditTexts = new EditText[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrayEditTexts[0] = edit11 = (EditText) findViewById(R.id.editText11);
        arrayEditTexts[1] = edit15 = (EditText) findViewById(R.id.editText15);
        arrayEditTexts[2] = edit17 = (EditText) findViewById(R.id.editText17);
        arrayEditTexts[3] = edit31 = (EditText) findViewById(R.id.editText31);
        arrayEditTexts[4] = edit33 = (EditText) findViewById(R.id.editText33);
        arrayEditTexts[5] = edit53 = (EditText) findViewById(R.id.editText53);
        arrayEditTexts[6] = edit55 = (EditText) findViewById(R.id.editText55);
        arrayEditTexts[7] = edit57 = (EditText) findViewById(R.id.editText57);
        arrayEditTexts[8] = edit71 = (EditText) findViewById(R.id.editText71);
        arrayEditTexts[9] = edit75 = (EditText) findViewById(R.id.editText75);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (EditText element: arrayEditTexts) {
                    element.setText("");
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = true;

                if (!hasEmpty(arrayEditTexts)) {

                    for (int i = 0; i < arrayAnswers.length; i++) {
                        Log.d("Counter i is:", String.valueOf(i));
                        if (arrayEditTexts[i].getText().length() > 0) {
                            int operand = Integer.parseInt(arrayEditTexts[i].getText().toString());
                            Log.d("Operand value is:", Integer.toString(operand));

                            if (operand != arrayAnswers[i]) {
                                Toast.makeText(MainActivity.this, "Oops! Try again!",
                                        Toast.LENGTH_LONG).show();
                                result = false;
                                break;
                            }
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Did you leave empty cells?",
                            Toast.LENGTH_LONG).show();
                    result = false;
                }

                if (result) {
                    Toast.makeText(MainActivity.this, "Congratulations! You solved the puzzle!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }


    private boolean hasEmpty(EditText[] arrayEditTexts) {
        for (EditText editText: arrayEditTexts) {
            if ( editText.getText().length() <= 0)
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
