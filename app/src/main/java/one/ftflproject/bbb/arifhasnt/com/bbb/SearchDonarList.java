package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SearchDonarList extends Activity {
    private Spinner spinner1, spinner2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donar_search);
//        this is activity sizing
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0;
        params.height = 450;
        params.width = 490;
        params.y = 0;

        addCategoryOnSpinner2();
        addListenerOnButton();
        //addListenerOnSpinnerItemSelection();
    }
    //this spinner is about category
    public void addCategoryOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinnerBloodGroupFromdonarPage);
        List list = new ArrayList();
        list.add("All");
        list.add("A+");
        list.add("A-");
        list.add("B+");
        list.add("B-");
        list.add("AB+");
        list.add("AB-");
        list.add("O+");
        list.add("O-");

        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
    //this spinner is about place

    public void addListenerOnButton() {

        //spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinnerBloodGroupFromdonarPage);
        button = (Button) findViewById(R.id.buttonSearchFromDonarSearch);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Toast.makeText(DoctorSearch.this,
//                        "Result : " +
//                                "\nPlace : " + String.valueOf(spinner1.getSelectedItem()) +
//                                "\nField : " + String.valueOf(spinner2.getSelectedItem()),
//                        Toast.LENGTH_SHORT).show();


                //String place=spinner1.getSelectedItem().toString();
                String bloodGroup=spinner2.getSelectedItem().toString();

                Intent intent=new Intent(SearchDonarList.this,SeachResultFromDonarList.class);

                intent.putExtra("bGroup",bloodGroup);
                startActivity(intent);
            }

        });
    }
}
