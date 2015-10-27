package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SearchDonar extends ListActivity {
    Button btnLogin;

    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://bloodbank.3eeweb.com/regLog/get_all_products.php";

    // JSON Node names
    private static final String TAG_CONTACTS = "products";

    private static final String TAG_ID = "pid";
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "price";
    private static final String TAG_BLOOOD_Group = "description";


/*    private static final String TAG_EMAIL = "email";

    private static final String TAG_ADDRESS = "age";
    private static final String TAG_GENDER = "weight";

    private static final String TAG_PHONE_MOBILE = "height";
    private static final String TAG_PHONE_HOME = "district";
    private static final String TAG_PHONE_OFFICE = "upzilla";*/

    // contacts JSONArray
    static JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList1;
    String str_place;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_donar_list_search);

        //ui-----------------

        //ui end-------------------

        contactList1 = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

        // Listview on item click listener
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String name = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                String price = ((TextView) view.findViewById(R.id.email))
                        .getText().toString();
                String description = ((TextView) view.findViewById(R.id.mobile))
                        .getText().toString();

                // Starting single contact activity
                Intent in = new Intent(getApplicationContext(),
                        SingleContactActivity.class);
                in.putExtra(TAG_NAME, name);
                in.putExtra(TAG_PHONE, price);
                in.putExtra(TAG_BLOOOD_Group, description);
                startActivity(in);

            }
        });

        Intent intent=getIntent();
        str_place=intent.getExtras().getString("bGroup");

        // Calling async task to get json
       // new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     * */
    public class GetContacts extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          /*  // Showing progress dialog
            pDialog = new ProgressDialog(SearchDonar.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();*/

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);
            // Check your log cat for JSON reponse





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
                        // String gender = c.getString(TAG_GENDER);
                        //String phone = c.getString(TAG_PHONE);

						/*// Phone node is JSON Object
						JSONObject phone = c.getJSONObject(TAG_PHONE);
						String mobile = phone.getString(TAG_PHONE_MOBILE);
						String home = phone.getString(TAG_PHONE_HOME);
						String office = phone.getString(TAG_PHONE_OFFICE);*/

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        if(bloodGroup.equals(str_place)){
                            contact.put(TAG_ID, id);
                            contact.put(TAG_BLOOOD_Group, bloodGroup);
                            // adding HashList to ArrayList
                            contactList1.add(contact);
                        }else{
                            Toast.makeText(getApplicationContext(),"not item",Toast.LENGTH_LONG).show();
                            contact.put(TAG_ID, id);
                            contact.put(TAG_NAME, name);
                            contact.put(TAG_PHONE, phone);
                            contact.put(TAG_BLOOOD_Group, bloodGroup);
                            // adding HashList to ArrayList
                            contactList1.add(contact);

                        }


                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_PHONE, phone);
                        contact.put(TAG_BLOOOD_Group, bloodGroup);

                        // adding contact to contact list
                        contactList1.add(contact);
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
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    SearchDonar.this, contactList1,
                    R.layout.list_item, new String[] { TAG_NAME, TAG_PHONE,
                    TAG_BLOOOD_Group }, new int[] { R.id.name,
                    R.id.email, R.id.mobile });




            setListAdapter(adapter);

        }

    }




}