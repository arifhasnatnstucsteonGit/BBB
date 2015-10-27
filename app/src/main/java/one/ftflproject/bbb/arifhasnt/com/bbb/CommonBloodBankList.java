package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shanto on 10/17/2015.
 */
public class CommonBloodBankList extends Activity{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_blood_bank);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        expListView=(ExpandableListView)findViewById(R.id.expandableListView);

        prepareListData();
       listAdapter = new one.ftflproject.bbb.arifhasnt.com.bbb.ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

    }
    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Shandhani DMC ");
        listDataHeader.add("Shandhani Dhaka Dental Colledge");
        listDataHeader.add("Retina Blood Bank ");
        listDataHeader.add("Shandhani Bangladesh Medical College ");

        listDataHeader.add("Red Crescent Blood Bank ");
        listDataHeader.add("Shandhani International Eye Bank ");
        listDataHeader.add("Sir Salimullah College Blood Bank ");
        listDataHeader.add("Islami Bank Hospital Blood Bank ");
        listDataHeader.add("Quantum Foundation");

        // Adding child data
        List<String> ShandhaniDMC = new ArrayList<String>();
        ShandhaniDMC.add("Where:Dhaka Medical College Branch\n" +
                "Contact: 9668690,861674");

        List<String> ShandhaniDhakaDentalColledge = new ArrayList<String>();
        ShandhaniDhakaDentalColledge.add("Where:Dhaka Dental College Branch\n" +
                "Contact: 9011887");


        List<String> RetinaBloodBank = new ArrayList<String>();
        RetinaBloodBank.add("Where:2 \\KA \\ 5, Nowab Habibullah Road, Shahbag, Dhaka (Behind PG Hospital)\n" +
                "Price: As it is under a foundation, general people are getting blood at a very cheap rate, only taka 450/ with exchange & taka 700/ without exchange.\n" +
                "Contact: 01614-606411, 02-9663853");
        List<String> ShandhaniBangladeshMedicalCollege = new ArrayList<String>();
        ShandhaniBangladeshMedicalCollege.add("Where:2 \\KA \\ 5, Nowab Habibullah Road, Shahbag, Dhaka (Behind PG Hospital)\n" +
                "Price: As it is under a foundation, general people are getting blood at a very cheap rate, only taka 450/ with exchange & taka 700/ without exchange.\n" +
                "Contact: 01614-606411, 02-9663853");
        List<String> RedCrescentBloodBank  = new ArrayList<String>();
        RedCrescentBloodBank.add("Where:2 \\KA \\ 5, Nowab Habibullah Road, Shahbag, Dhaka (Behind PG Hospital)\n" +
                "Price: As it is under a foundation, general people are getting blood at a very cheap rate, only taka 450/ with exchange & taka 700/ without exchange.\n" +
                "Contact: 01614-606411, 02-9663853");

        List<String> ShandhaniInternationalEyeBank   = new ArrayList<String>();
        ShandhaniInternationalEyeBank.add("Contact: 9124353,01190151480");

        List<String> SirSalimullahCollegeBloodBank  = new ArrayList<String>();
        SirSalimullahCollegeBloodBank.add("Where:2 \\KA \\ 5, Nowab Habibullah Road, Shahbag, Dhaka (Behind PG Hospital)\n" +
                "Price: As it is under a foundation, general people are getting blood at a very cheap rate, only taka 450/ with exchange & taka 700/ without exchange.\n" +
                "Contact: 01614-606411, 02-9663853");
        List<String> IslamiBankHospitalBloodBank  = new ArrayList<String>();
        IslamiBankHospitalBloodBank.add("Contact: 8317090,8321495");
        
        List<String> QuantumFoundation  = new ArrayList<String>();
        QuantumFoundation.add("Contact: 9351969,8322987,9341441,8319377");

        listDataChild.put(listDataHeader.get(0), ShandhaniDMC); // Header, Child data
        listDataChild.put(listDataHeader.get(1), ShandhaniDhakaDentalColledge);
        listDataChild.put(listDataHeader.get(2), RetinaBloodBank);
        listDataChild.put(listDataHeader.get(3), ShandhaniBangladeshMedicalCollege);

        listDataChild.put(listDataHeader.get(4), RedCrescentBloodBank);
        listDataChild.put(listDataHeader.get(5), ShandhaniInternationalEyeBank);
        listDataChild.put(listDataHeader.get(6), ShandhaniBangladeshMedicalCollege);
        listDataChild.put(listDataHeader.get(7), IslamiBankHospitalBloodBank);
        listDataChild.put(listDataHeader.get(8), QuantumFoundation);
    }
}
