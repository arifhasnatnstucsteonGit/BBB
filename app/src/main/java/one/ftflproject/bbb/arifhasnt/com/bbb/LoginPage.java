package one.ftflproject.bbb.arifhasnt.com.bbb;


import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;

public class LoginPage extends ListActivity {
    public boolean flag;

    EditText editText_name,editText_phone;
    Button button_login;
    String stringName,stringPhone;


    private ProgressDialog pDialog;


    // JSON Node names
    private static final String TAG_CONTACTS = "products";

    private static final String TAG_ID = "pid";
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "price";
    private static final String TAG_BLOOOD_Group = "description";

    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
    // URL to get contacts JSON
    private static String url = "http://bloodbank.3eeweb.com/regLog/get_all_products.php";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // login page ui ----------------
        editText_name= (EditText) findViewById(R.id.editTextNameFromActivityLoginPage);
        editText_phone= (EditText) findViewById(R.id.editTextPhoneFromActivityLoginPage);
        button_login= (Button) findViewById(R.id.btnLoginFromActivityLoginPage);


        //------------login page ui ---------------
        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

    }





    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(LoginPage.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    contacts = jsonObj.getJSONArray(TAG_CONTACTS);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String phone = c.getString(TAG_PHONE);
                        String bloodGroup = c.getString(TAG_BLOOOD_Group);



						/*// Phone node is JSON Object
						JSONObject phone = c.getJSONObject(TAG_PHONE);
						String mobile = phone.getString(TAG_PHONE_MOBILE);
						String home = phone.getString(TAG_PHONE_HOME);
						String office = phone.getString(TAG_PHONE_OFFICE);*/

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_PHONE, phone);
                        contact.put(TAG_BLOOOD_Group, bloodGroup);


                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            stringName = editText_name.getText().toString();
            stringPhone = editText_phone.getText().toString();

            for (int i = 0; i < contactList.size(); i++) {
//                Log.d("Response: ", " > " + credentialList.get(i).toString());
                //if(email.equalsIgnoreCase(credentialList.get(i).get(TAG_EMAIL).toString()) && password.equals(credentialList.get(i).get(TAG_PASSWORD).toString()))
//                if((email.compareTo(credentialList.get(i).get(TAG_EMAIL).toString()) == 0) && (password.compareTo(credentialList.get(i).get(TAG_PASSWORD).toString()) == 0))

                String e = contactList.get(i).get(TAG_NAME).toString();
                String p = contactList.get(i).get(TAG_PHONE).toString();


                if (stringName.equals(e) && stringPhone.equals(p)) {

                    flag = true;
                    break;
                }
            }

            Log.d("Flag", " > " + flag);

            if (flag) {
                Intent in = new Intent(LoginPage.this, DisplayDonarList.class);
                startActivity(in);
            } else {
                Toast.makeText(LoginPage.this, "Name or Phone No. mismatch.", Toast.LENGTH_SHORT).show();
            }
            pDialog.dismiss();


        }
    }
   public void loginOnClick(View view){
        new GetContacts().execute();


    }

    public void linkToRegisterFromLoginPage(View view) {
        Intent intent = new Intent(getApplicationContext(), NewProductActivity.class);
        startActivity(intent);


    }
    //end GetContacts class



}