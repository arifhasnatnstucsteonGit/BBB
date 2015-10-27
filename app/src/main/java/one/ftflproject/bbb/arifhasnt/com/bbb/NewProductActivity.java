package one.ftflproject.bbb.arifhasnt.com.bbb;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewProductActivity extends Activity {

    String name ;
    String price ;
    String description;

    // Progress Dialog
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText inputName;
    EditText inputPhone;
    EditText inputBloodgroup;

    // url to create new product
    private static String url_create_product = "http://bloodbank.3eeweb.com/regLog/create_product.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Edit Text
        inputName = (EditText) findViewById(R.id.editTextNameFromNewProductActivtiyPage);
        inputPhone = (EditText) findViewById(R.id.editTextPhoneFromRegisterPage);
        inputBloodgroup = (EditText) findViewById(R.id.editTestBloodGroupFromRegisterPage);






        // Create button
        Button btnCreateProduct = (Button) findViewById(R.id.btnRegisterFromRegisterPage);

        // button click event
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new product in background thread
                String name = inputName.getText().toString().trim();
                String phone = inputPhone.getText().toString().trim();
                String bGroup = inputBloodgroup.getText().toString().trim();

                if (!name.isEmpty() && !phone.isEmpty() && !bGroup.isEmpty()) {
                    new CreateNewProduct().execute();


                }else {
                    Toast.makeText(getApplicationContext(),"Please fill up all fields ! Name ,phone and Blood Group is required ",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    /**
     * Background Async Task to Create new product
     * */
    class CreateNewProduct extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(NewProductActivity.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {

            name = inputName.getText().toString();
            price = inputPhone.getText().toString();
            description = inputBloodgroup.getText().toString();


            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("price", price));
            params.add(new BasicNameValuePair("description", description));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                    "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }

    public void linkToGoLoginPageFromRegisterPage(View view){
        Intent intent=new Intent(getApplicationContext(),LoginPage.class);
        startActivity(intent);



    }
}
