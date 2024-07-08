package yildirimapps.turkishwordtreasure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainMenu extends AppCompatActivity {

    ListView mainMenu;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("F10CCF84E3F1605915C1F5BB0BE4D629")
                .build();
        mAdView.loadAd(adRequest);

        mainMenu = (ListView) findViewById(R.id.list_menu);

        final ArrayAdapter<CharSequence> adapter_mainmenu = ArrayAdapter.createFromResource(this,
                R.array.main_menu, android.R.layout.simple_list_item_1);
        mainMenu.setAdapter(adapter_mainmenu);

        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                goNext(i);
            }
        });
    }

    public void goAbout(View v){
        Intent goAbout = new Intent(this, AboutPage.class);
        startActivity(goAbout);
        finish();
    }

    public void goNext(int i){
        Intent goNext = new Intent(this, wordlist.class);
        goNext.putExtra("groupNumber", i);
        startActivity(goNext);
        finish();
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}
