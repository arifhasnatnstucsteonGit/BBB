package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by Arif on 20/10/2015.
 */
public class Hometab extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hometab);

        TabHost th=(TabHost) findViewById(R.id.tabHost);
        th.setup();
        TabHost.TabSpec specs=th.newTabSpec("Teacher");
        specs.setContent(R.id.tab1);
        specs.setIndicator("Live Blood Bank");
        th.addTab(specs);



        specs=th.newTabSpec("Students");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Nearby BloodBank");
        th.addTab(specs);



        specs=th.newTabSpec("About me");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Common BloodBankList");
        th.addTab(specs);


    }

    public void registerOnClick(View view){
        Intent intent=new Intent(getApplicationContext(),NewProductActivity.class);
        startActivity(intent);

    }
    public void loginOnClick(View view){
        Intent intent=new Intent(getApplicationContext(),LoginPage.class);
        startActivity(intent);

    }
    public void joinToOurCommunity(View view){
        Intent intent=new Intent(getApplicationContext(),JoinToCommunity.class);
        startActivity(intent);

    }

    public void CommonBloodBankListOnClick(View view){
        Intent intent=new Intent(getApplicationContext(),CommonBloodBankList.class);
        startActivity(intent);


    }
}
