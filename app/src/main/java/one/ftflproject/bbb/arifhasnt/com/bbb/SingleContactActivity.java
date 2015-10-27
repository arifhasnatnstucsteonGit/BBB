package one.ftflproject.bbb.arifhasnt.com.bbb;

/**
 * Created by Arif on 19/10/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SingleContactActivity  extends Activity {

    //variable
    String name ;
    String phone ;
    String bloodGroup ;


    Button btnCalltoDonar,btnSmstoDonar,btnSMStoPateient;

    private static final String TAG_ID = "pid";
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "price";
    private static final String TAG_BLOOOD_Group = "description";
/*
    // JSON node keys
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "phone";
    private static final String TAG_PHONE_MOBILE = "height";// phone and height has interchange .so use height for mobile and phone for height*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);
        btnCalltoDonar= (Button) findViewById(R.id.buttonCallFromSingleContacActivtivity);
        btnSmstoDonar= (Button) findViewById(R.id.buttonSMSFromSingleContactActivity);
        btnSMStoPateient= (Button) findViewById(R.id.buttonSMStoPaient);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        name = in.getStringExtra(TAG_NAME);
        phone = in.getStringExtra(TAG_PHONE);
        bloodGroup = in.getStringExtra(TAG_BLOOOD_Group);

        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.textViewName);
        TextView lblEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView lblMobile = (TextView) findViewById(R.id.textViewPhone);

        lblName.setText(name);
        lblEmail.setText(phone);
        lblMobile.setText(bloodGroup);
    }

    public void CallToDonar(View view){
        Toast.makeText(getApplicationContext(),phone,Toast.LENGTH_LONG).show();
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

        //callIntent.setData(Uri.parse("tel:" + mobile));
        startActivity(callIntent);



    }
    public void SMStoDonar(View view){
        Uri uri = Uri.parse("smsto:" + phone);

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);

        smsIntent.putExtra("sms_body", "Donar  phone no :");

        startActivity(smsIntent);

    }

    public void smstopatient(View view){
        Uri uri = Uri.parse("smsto:" + "");

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);

        smsIntent.putExtra("sms_body", "Name:  "+name+" \n"+"Blood Group:  " +bloodGroup +"\n "+"Phone No: "+phone);

        startActivity(smsIntent);


    }


}
