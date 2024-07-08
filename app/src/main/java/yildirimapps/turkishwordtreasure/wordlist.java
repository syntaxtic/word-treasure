package yildirimapps.turkishwordtreasure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class wordlist extends AppCompatActivity {

    String[] mygroup, englishList, extrasList, titles;
    TextView turkish, english, englishExt, title;
    ImageButton rightB, leftB;
    int current, length;
    SeekBar seekbar;
    int[] voiceLibrary;
    MediaPlayer myPlayer;
    private AdView mAdView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("F10CCF84E3F1605915C1F5BB0BE4D629")
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.inter_id));

        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("F10CCF84E3F1605915C1F5BB0BE4D629")
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest2);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        turkish = (TextView) findViewById(R.id.turkish_word);
        english = (TextView) findViewById(R.id.english_word);
        englishExt = (TextView) findViewById(R.id.englishExt);
        rightB = (ImageButton) findViewById(R.id.right_button);
        leftB = (ImageButton) findViewById(R.id.left_button);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        title = (TextView) findViewById(R.id.view_title);

        Intent caller = getIntent();
        int groupNo = caller.getIntExtra("groupNumber", 0);
        titles = getResources().getStringArray(R.array.main_menu);


        if (groupNo == 0) {
            mygroup = getResources().getStringArray(R.array.alphabet);
            englishList = getResources().getStringArray(R.array.group0);
            extrasList =  getResources().getStringArray(R.array.group0ext);
        } else if (groupNo == 1){
            mygroup = getResources().getStringArray(R.array.numbers);
            englishList = getResources().getStringArray(R.array.group1);
            extrasList =  getResources().getStringArray(R.array.group1ext);
        } else if (groupNo == 2){
            mygroup = getResources().getStringArray(R.array.questions);
            englishList = getResources().getStringArray(R.array.group2);
            extrasList =  getResources().getStringArray(R.array.group2ext);
        } else if (groupNo == 3){
            mygroup = getResources().getStringArray(R.array.colors);
            englishList = getResources().getStringArray(R.array.group3);
            extrasList =  getResources().getStringArray(R.array.group4ext);
        } else if (groupNo == 4){
            mygroup = getResources().getStringArray(R.array.days);
            englishList = getResources().getStringArray(R.array.group4);
            extrasList =  getResources().getStringArray(R.array.group4ext);
        } else if (groupNo == 5){
            mygroup = getResources().getStringArray(R.array.months);
            englishList = getResources().getStringArray(R.array.group5);
            extrasList =  getResources().getStringArray(R.array.group5ext);
        } else if (groupNo == 6){
            mygroup = getResources().getStringArray(R.array.pronouns);
            englishList = getResources().getStringArray(R.array.group6);
            extrasList =  getResources().getStringArray(R.array.group6ext);
        } else if (groupNo == 7){
            mygroup = getResources().getStringArray(R.array.bodyParts);
            englishList = getResources().getStringArray(R.array.group7);
            extrasList =  getResources().getStringArray(R.array.group7ext);
        } else if (groupNo == 8){
            mygroup = getResources().getStringArray(R.array.electronics);
            englishList = getResources().getStringArray(R.array.group8);
            extrasList =  getResources().getStringArray(R.array.group8ext);
        } else if (groupNo == 9){
            mygroup = getResources().getStringArray(R.array.family);
            englishList = getResources().getStringArray(R.array.group9);
            extrasList =  getResources().getStringArray(R.array.group9ext);
        } else if (groupNo == 10){
            mygroup = getResources().getStringArray(R.array.top100);
            englishList = getResources().getStringArray(R.array.group10);
            extrasList =  getResources().getStringArray(R.array.group10ext);
        }



        turkish.setText(mygroup[0]);
        if (!englishList[0].equals("null"))
            english.setText(englishList[0]);
        if (!extrasList[0].equals("null"))
            englishExt.setText(extrasList[0]);

        length = mygroup.length;
        seekbar.setMax(length);
        title.setText(titles[groupNo]);
        current = 0;
        voiceLibrary = new int[length];

        if (groupNo == 0) {
            voiceLibrary[0] = R.raw.a;
            voiceLibrary[1] = R.raw.b;
            voiceLibrary[2] = R.raw.c;
            voiceLibrary[3] = R.raw.ch;
            voiceLibrary[4] = R.raw.d;
            voiceLibrary[5] = R.raw.e;
            voiceLibrary[6] = R.raw.f;
            voiceLibrary[7] = R.raw.g;
            voiceLibrary[8] = R.raw.gh;
            voiceLibrary[9] = R.raw.h;
            voiceLibrary[10] = R.raw.i;
            voiceLibrary[11] = R.raw.ii;
            voiceLibrary[12] = R.raw.j;
            voiceLibrary[13] = R.raw.k;
            voiceLibrary[14] = R.raw.l;
            voiceLibrary[15] = R.raw.m;
            voiceLibrary[16] = R.raw.n;
            voiceLibrary[17] = R.raw.o;
            voiceLibrary[18] = R.raw.oo;
            voiceLibrary[19] = R.raw.p;
            voiceLibrary[20] = R.raw.r;
            voiceLibrary[21] = R.raw.s;
            voiceLibrary[22] = R.raw.sh;
            voiceLibrary[23] = R.raw.t;
            voiceLibrary[24] = R.raw.u;
            voiceLibrary[25] = R.raw.uu;
            voiceLibrary[26] = R.raw.v;
            voiceLibrary[27] = R.raw.y;
            voiceLibrary[28] = R.raw.z;
            voiceLibrary[29] = R.raw.alfabe;
            voiceLibrary[30] = R.raw.harf;
            voiceLibrary[31] = R.raw.kelime;
            voiceLibrary[32] = R.raw.cumle;
        } else if (groupNo == 1){
            voiceLibrary[0] = R.raw.numbers0;
            voiceLibrary[1] = R.raw.numbers1;
            voiceLibrary[2] = R.raw.numbers2;
            voiceLibrary[3] = R.raw.numbers3;
            voiceLibrary[4] = R.raw.numbers4;
            voiceLibrary[5] = R.raw.numbers5;
            voiceLibrary[6] = R.raw.numbers6;
            voiceLibrary[7] = R.raw.numbers7;
            voiceLibrary[8] = R.raw.numbers8;
            voiceLibrary[9] = R.raw.numbers9;
            voiceLibrary[10] = R.raw.numbers10;
            voiceLibrary[11] = R.raw.numbers11;
            voiceLibrary[12] = R.raw.numbers12;
            voiceLibrary[13] = R.raw.numbers20;
            voiceLibrary[14] = R.raw.numbers29;
            voiceLibrary[15] = R.raw.numbers30;
            voiceLibrary[16] = R.raw.numbers36;
            voiceLibrary[17] = R.raw.numbers40;
            voiceLibrary[18] = R.raw.numbers50;
            voiceLibrary[19] = R.raw.numbers60;
            voiceLibrary[20] = R.raw.numbers70;
            voiceLibrary[21] = R.raw.numbers80;
            voiceLibrary[22] = R.raw.numbers90;
            voiceLibrary[23] = R.raw.numbers100;
            voiceLibrary[24] = R.raw.numbers105;
            voiceLibrary[25] = R.raw.numbers127;
            voiceLibrary[26] = R.raw.numbers200;
            voiceLibrary[27] = R.raw.numbers262;
            voiceLibrary[28] = R.raw.numbers600;
            voiceLibrary[29] = R.raw.numbers999;
            voiceLibrary[30] = R.raw.numbers1000;
            voiceLibrary[31] = R.raw.numbers1002;
            voiceLibrary[32] = R.raw.numbers1001;
        } else if (groupNo == 2){
            voiceLibrary[0] = R.raw.questions1;
            voiceLibrary[1] = R.raw.questions2;
            voiceLibrary[2] = R.raw.questions3;
            voiceLibrary[3] = R.raw.questions4;
            voiceLibrary[4] = R.raw.questions5;
            voiceLibrary[5] = R.raw.questions6;
            voiceLibrary[6] = R.raw.questions7;
            voiceLibrary[7] = R.raw.questions8;
            voiceLibrary[8] = R.raw.questions9;
            voiceLibrary[9] = R.raw.questions10;
            voiceLibrary[10] = R.raw.questions11;
            voiceLibrary[11] = R.raw.questions12;
            voiceLibrary[12] = R.raw.questions13;
            voiceLibrary[13] = R.raw.questions14;
            voiceLibrary[14] = R.raw.questions15;
        } else if (groupNo == 3){
            voiceLibrary[0] = R.raw.colors1;
            voiceLibrary[1] = R.raw.colors2;
            voiceLibrary[2] = R.raw.colors3;
            voiceLibrary[3] = R.raw.colors4;
            voiceLibrary[4] = R.raw.colors5;
            voiceLibrary[5] = R.raw.colors6;
            voiceLibrary[6] = R.raw.colors7;
            voiceLibrary[7] = R.raw.colors8;
            voiceLibrary[8] = R.raw.colors9;
            voiceLibrary[9] = R.raw.colors10;
            voiceLibrary[10] = R.raw.colors11;
            voiceLibrary[11] = R.raw.colors12;
        } else if (groupNo == 4){
            voiceLibrary[0] = R.raw.days1;
            voiceLibrary[1] = R.raw.days2;
            voiceLibrary[2] = R.raw.days3;
            voiceLibrary[3] = R.raw.days4;
            voiceLibrary[4] = R.raw.days5;
            voiceLibrary[5] = R.raw.days6;
            voiceLibrary[6] = R.raw.days7;
            voiceLibrary[7] = R.raw.days8;
            voiceLibrary[8] = R.raw.days9;
            voiceLibrary[9] = R.raw.days10;
            voiceLibrary[10] = R.raw.days11;
            voiceLibrary[11] = R.raw.days12;
            voiceLibrary[12] = R.raw.days13;
            voiceLibrary[13] = R.raw.days14;
            voiceLibrary[14] = R.raw.days15;
        } else if (groupNo == 5){
            voiceLibrary[0] = R.raw.months1;
            voiceLibrary[1] = R.raw.months2;
            voiceLibrary[2] = R.raw.months3;
            voiceLibrary[3] = R.raw.months4;
            voiceLibrary[4] = R.raw.months5;
            voiceLibrary[5] = R.raw.months6;
            voiceLibrary[6] = R.raw.months7;
            voiceLibrary[7] = R.raw.months8;
            voiceLibrary[8] = R.raw.months9;
            voiceLibrary[9] = R.raw.months10;
            voiceLibrary[10] = R.raw.months11;
            voiceLibrary[11] = R.raw.months12;
            voiceLibrary[12] = R.raw.months13;
            voiceLibrary[13] = R.raw.months14;
            voiceLibrary[14] = R.raw.months15;
        } else if (groupNo == 6){
            voiceLibrary[0] = R.raw.pron1;
            voiceLibrary[1] = R.raw.pron2;
            voiceLibrary[2] = R.raw.pron3;
            voiceLibrary[3] = R.raw.pron4;
            voiceLibrary[4] = R.raw.pron5;
            voiceLibrary[5] = R.raw.pron6;
            voiceLibrary[6] = R.raw.pron7;
            voiceLibrary[7] = R.raw.pron8;
            voiceLibrary[8] = R.raw.pron9;
        } else if (groupNo == 7){
            voiceLibrary[0] = R.raw.bodyparts1;
            voiceLibrary[1] = R.raw.bodyparts2;
            voiceLibrary[2] = R.raw.bodyparts3;
            voiceLibrary[3] = R.raw.bodyparts4;
            voiceLibrary[4] = R.raw.bodyparts5;
            voiceLibrary[5] = R.raw.bodyparts6;
            voiceLibrary[6] = R.raw.bodyparts7;
            voiceLibrary[7] = R.raw.bodyparts8;
            voiceLibrary[8] = R.raw.bodyparts9;
            voiceLibrary[9] = R.raw.bodyparts10;
            voiceLibrary[10] = R.raw.bodyparts11;
            voiceLibrary[11] = R.raw.bodyparts12;
            voiceLibrary[12] = R.raw.bodyparts13;
            voiceLibrary[13] = R.raw.bodyparts14;
            voiceLibrary[14] = R.raw.bodyparts15;
            voiceLibrary[15] = R.raw.bodyparts16;
            voiceLibrary[16] = R.raw.bodyparts17;
        } else if (groupNo == 8){
            voiceLibrary[0] = R.raw.electronics1;
            voiceLibrary[1] = R.raw.electronics2;
            voiceLibrary[2] = R.raw.electronics3;
            voiceLibrary[3] = R.raw.electronics4;
            voiceLibrary[4] = R.raw.electronics5;
            voiceLibrary[5] = R.raw.electronics6;
            voiceLibrary[6] = R.raw.electronics7;
            voiceLibrary[7] = R.raw.electronics8;
            voiceLibrary[8] = R.raw.electronics9;
            voiceLibrary[9] = R.raw.electronics10;
            voiceLibrary[10] = R.raw.electronics11;
            voiceLibrary[11] = R.raw.electronics12;
        } else if (groupNo == 9){
            voiceLibrary[0] = R.raw.family1;
            voiceLibrary[1] = R.raw.family2;
            voiceLibrary[2] = R.raw.family3;
            voiceLibrary[3] = R.raw.family4;
            voiceLibrary[4] = R.raw.family5;
            voiceLibrary[5] = R.raw.family6;
            voiceLibrary[6] = R.raw.family7;
            voiceLibrary[7] = R.raw.family8;
            voiceLibrary[8] = R.raw.family9;
        } else if (groupNo == 10){
            voiceLibrary[0] = R.raw.top1;
            voiceLibrary[1] = R.raw.top2;
            voiceLibrary[2] = R.raw.top3;
            voiceLibrary[3] = R.raw.top4;
            voiceLibrary[4] = R.raw.top5;
            voiceLibrary[5] = R.raw.top6;
            voiceLibrary[6] = R.raw.top7;
            voiceLibrary[7] = R.raw.top8;
            voiceLibrary[8] = R.raw.top9;
            voiceLibrary[9] = R.raw.top10;
            voiceLibrary[10] = R.raw.top11;
            voiceLibrary[11] = R.raw.top12;
            voiceLibrary[12] = R.raw.top13;
            voiceLibrary[13] = R.raw.top14;
            voiceLibrary[14] = R.raw.top15;
            voiceLibrary[15] = R.raw.top16;
            voiceLibrary[16] = R.raw.top17;
            voiceLibrary[17] = R.raw.top18;
            voiceLibrary[18] = R.raw.top19;
            voiceLibrary[19] = R.raw.top20;
            voiceLibrary[20] = R.raw.top21;
            voiceLibrary[21] = R.raw.top22;
            voiceLibrary[22] = R.raw.top23;
            voiceLibrary[23] = R.raw.top24;
            voiceLibrary[24] = R.raw.top25;
            voiceLibrary[25] = R.raw.top26;
            voiceLibrary[26] = R.raw.top27;
            voiceLibrary[27] = R.raw.top28;
            voiceLibrary[28] = R.raw.top29;
            voiceLibrary[29] = R.raw.top30;
            voiceLibrary[30] = R.raw.top31;
            voiceLibrary[31] = R.raw.top32;
            voiceLibrary[32] = R.raw.top33;
            voiceLibrary[33] = R.raw.top34;
            voiceLibrary[34] = R.raw.top35;
            voiceLibrary[35] = R.raw.top36;
            voiceLibrary[36] = R.raw.top37;
            voiceLibrary[37] = R.raw.top38;
            voiceLibrary[38] = R.raw.top39;
            voiceLibrary[39] = R.raw.top40;
            voiceLibrary[40] = R.raw.top41;
            voiceLibrary[41] = R.raw.top42;
            voiceLibrary[42] = R.raw.top43;
            voiceLibrary[43] = R.raw.top44;
            voiceLibrary[44] = R.raw.top45;
            voiceLibrary[45] = R.raw.top46;
            voiceLibrary[46] = R.raw.top47;
            voiceLibrary[47] = R.raw.top48;
            voiceLibrary[48] = R.raw.top49;
            voiceLibrary[49] = R.raw.top50;
            voiceLibrary[50] = R.raw.top51;
            voiceLibrary[51] = R.raw.top52;
            voiceLibrary[52] = R.raw.top53;
            voiceLibrary[53] = R.raw.top54;
            voiceLibrary[54] = R.raw.top55;
            voiceLibrary[55] = R.raw.top56;
            voiceLibrary[56] = R.raw.top57;
            voiceLibrary[57] = R.raw.top58;
            voiceLibrary[58] = R.raw.top59;
            voiceLibrary[59] = R.raw.top60;
            voiceLibrary[60] = R.raw.top61;
            voiceLibrary[61] = R.raw.top62;
            voiceLibrary[62] = R.raw.top63;
            voiceLibrary[63] = R.raw.top64;
            voiceLibrary[64] = R.raw.top65;
            voiceLibrary[65] = R.raw.top66;
            voiceLibrary[66] = R.raw.top67;
            voiceLibrary[67] = R.raw.top68;
            voiceLibrary[68] = R.raw.top69;
            voiceLibrary[69] = R.raw.top70;
            voiceLibrary[70] = R.raw.top71;
            voiceLibrary[71] = R.raw.top72;
            voiceLibrary[72] = R.raw.top73;
            voiceLibrary[73] = R.raw.top74;
            voiceLibrary[74] = R.raw.top75;
            voiceLibrary[75] = R.raw.top76;
            voiceLibrary[76] = R.raw.top77;
            voiceLibrary[77] = R.raw.top78;
            voiceLibrary[78] = R.raw.top79;
            voiceLibrary[79] = R.raw.top80;
            voiceLibrary[80] = R.raw.top81;
            voiceLibrary[81] = R.raw.top82;
            voiceLibrary[82] = R.raw.top83;
            voiceLibrary[83] = R.raw.top84;
            voiceLibrary[84] = R.raw.top85;
            voiceLibrary[85] = R.raw.top86;
            voiceLibrary[86] = R.raw.top87;
            voiceLibrary[87] = R.raw.top88;
            voiceLibrary[88] = R.raw.top89;
            voiceLibrary[89] = R.raw.top90;
            voiceLibrary[90] = R.raw.top91;
            voiceLibrary[91] = R.raw.top92;
            voiceLibrary[92] = R.raw.top93;
            voiceLibrary[93] = R.raw.top94;
            voiceLibrary[94] = R.raw.top95;
            voiceLibrary[95] = R.raw.top96;
            voiceLibrary[96] = R.raw.top97;
            voiceLibrary[97] = R.raw.top98;
            voiceLibrary[98] = R.raw.top99;
            voiceLibrary[99] = R.raw.top100;
        }

        playSound(current);

        rightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNextItem();
            }
        });

        leftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goPeviousItem();
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                current = i-1;
                if (i == 0) {
                    current = i;
                    seekbar.setProgress(1);
                }
                turkish.setText(mygroup[current]);
                if (englishList[current].equals("null"))
                    english.setText("");
                else
                    english.setText(englishList[current]);

                if (extrasList[current].equals("null"))
                    englishExt.setText("");
                else
                    englishExt.setText(extrasList[current]);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void goMain(View v){
        Intent goMain = new Intent(this, MainMenu.class);
        startActivity(goMain);
        finish();
    }

    public void goNextItem(){
        if (current != (length-1))
            current++;
        else
            current = 0;

        turkish.setText(mygroup[current]);
        if (englishList[current].equals("null"))
            english.setText("");
        else
            english.setText(englishList[current]);

        if (extrasList[current].equals("null"))
            englishExt.setText("");
        else
            englishExt.setText(extrasList[current]);

        playSound(current);


        seekbar.setProgress(current+1);
    }
    public void goPeviousItem(){
        if (current != 0)
            current--;
        else
            current = length-1;

        turkish.setText(mygroup[current]);
        if (englishList[current].equals("null"))
            english.setText("");
        else
            english.setText(englishList[current]);

        if (extrasList[current].equals("null"))
            englishExt.setText("");
        else
            englishExt.setText(extrasList[current]);

        playSound(current);

        seekbar.setProgress(current+1);
    }

    @Override
    public void onBackPressed(){
        Intent goMain = new Intent(this, MainMenu.class);
        startActivity(goMain);
        finish();
    }

    public void playSound(int i){

        if(myPlayer!=null)
        {
            myPlayer.release();
            myPlayer=null;
        }
        myPlayer = MediaPlayer.create(this, voiceLibrary[i]);
        myPlayer.start();
    }

    public void soundAgain(View v){
        playSound(current);
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
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
