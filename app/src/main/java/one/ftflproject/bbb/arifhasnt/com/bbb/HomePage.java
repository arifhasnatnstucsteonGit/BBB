package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Arif on 20/10/2015.
 */
public class HomePage extends Activity {

    Boolean isInternetPresent=false;
    ConnectionDetector cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_page);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        cd=new ConnectionDetector(getApplicationContext());
        isInternetPresent=cd.isConnectingToInternet();

    }

   public void  liveBBOnClick(View view){


     //  if(isInternetPresent){

           Intent intent=new Intent(getApplicationContext(),Hometab.class);
           startActivity(intent);

      // } else{
        //   showAlertDialog(HomePage.this,"No Internet Connection","Please,Connect the Internet");
       //}


   }
    public void aboutBBBOnClik(View view){


        //if(isInternetPresent){

            Intent intent=new Intent(getApplicationContext(),About.class);
            startActivity(intent);

        //} else{
            //howAlertDialog(HomePage.this,"No Internet Connection","Please,Connect the Internet");
        //}


    }
   public void joinBBBOnClick(View view){


      // if(isInternetPresent){

           Intent intent=new Intent(getApplicationContext(),NewProductActivity.class);
           startActivity(intent);


       //} else{
          // showAlertDialog(HomePage.this,"No Internet Connection","Please,Connect the Internet");
      // }


   }
    public void SearchBloodOnClick(View view){
      //  if(isInternetPresent){

            Intent intent=new Intent(getApplicationContext(),About.class);
            startActivity(intent);


        //} else{
          //  showAlertDialog(HomePage.this,"No Internet Connection","Please,Connect the Internet");
        //}


    }
   public void  BBBForumOnClick(View view){
       //if(isInternetPresent){

           Intent intent=new Intent(getApplicationContext(),BBBForum.class);
           startActivity(intent);


      //} else{
          // showAlertDialog(HomePage.this,"No Internet Connection","Please,Connect the Internet");
       //}

   }

    public void showAlertDialog(Context context,String title,String message){
        AlertDialog alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.alert);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}
