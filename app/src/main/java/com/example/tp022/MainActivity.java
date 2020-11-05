package com.example.tp022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button ;
EditText editText ;
TextView textView ;
int number ;
    private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the view variables.
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);


        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                textView.setText(savedInstanceState
                        .getString("count"));
                textView.setVisibility(View.VISIBLE);

            }
        }

        button=(Button)findViewById((R.id.button));
        reponse() ;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (textView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("count",
                    textView.getText().toString());

        }
    }

    public void count(){
        textView =findViewById(R.id.textView);
        number =Integer.parseInt(textView.getText().toString()) +1 ;
        textView.setText(Integer.toString(number));
    }

    public void reponse(){
        Log.d(TAG,"Question 1") ;
        Log.d(TAG,"Le compteur est réinitialisé à 0, mais le contenu de " +
                "l'EditText est préservé.") ;

        Log.d(TAG,"Question 2") ;
        Log.d(TAG,"Android arrête votre activité en appelant onPause(), onStop() " +
                "et onDestroy(), puis redémarre l'opération en appelant onCreate()," +
                " onStart() et onResume().") ;

        Log.d(TAG,"Question 3") ;
        Log.d(TAG,"onSaveInstanceState() est appelée avant la méthode onStop().") ;

        Log.d(TAG,"Question 4") ;
        Log.d(TAG,"onPause() ou onStop()") ;

    }
}