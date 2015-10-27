package one.ftflproject.bbb.arifhasnt.com.bbb;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by Arif on 17/10/2015.
 */
public class SlashScreen extends Activity{


    private static int SPLASH_TIME_OUT=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent theIntent=new Intent(getApplicationContext(),HomePage.class);
                startActivity(theIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }


}
