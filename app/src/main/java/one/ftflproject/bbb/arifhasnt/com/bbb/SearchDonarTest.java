package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Arif on 20/10/2015.
 */
public class SearchDonarTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_bbb);

        Intent intent = getIntent();

        String str_place = intent.getExtras().getString("bGroup");
        Toast.makeText(getApplicationContext(), str_place, Toast.LENGTH_LONG).show();

        SeachResultFromDonarList list = new SeachResultFromDonarList();


    }
}