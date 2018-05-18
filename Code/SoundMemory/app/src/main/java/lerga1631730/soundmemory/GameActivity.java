package lerga1631730.soundmemory;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    MediaPlayer []mp;
    int lastTag,newTag,cpt=0, tagDif = 0,tagDif2 = 0, pts = 0, essai = 0;
    ArrayList<ImageView> pics;
    ImageView ancien,ancien2,nouveau;
    String choix;
    TextView textView;
    ObjectAnimator flip;
    ColorFilter filter = new LightingColorFilter(Color.RED,Color.RED);
    ColorFilter filter2 = new LightingColorFilter(Color.BLUE,Color.BLUE);
    ColorFilter filter3 = new LightingColorFilter(Color.GREEN,Color.GREEN);

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        textView = findViewById(R.id.textView2);
        textView.setText(pts + " nombre de chansons associées");

        choix = getIntent().getStringExtra("Choix");


        pics = new ArrayList<ImageView>();
        pics.add((ImageView) findViewById(R.id.imageView));
        pics.add((ImageView) findViewById(R.id.imageView2));
        pics.add((ImageView) findViewById(R.id.imageView3));
        pics.add((ImageView) findViewById(R.id.imageView4));
        pics.add((ImageView) findViewById(R.id.imageView5));
        pics.add((ImageView) findViewById(R.id.imageView6));
        pics.add((ImageView) findViewById(R.id.imageView7));
        pics.add((ImageView) findViewById(R.id.imageView8));
        pics.add((ImageView) findViewById(R.id.imageView9));
        pics.add((ImageView) findViewById(R.id.imageView10));
        pics.add((ImageView) findViewById(R.id.imageView11));
        pics.add((ImageView) findViewById(R.id.imageView12));

        NewTag();

        switch(choix)
        {
            case "genesis":
                MediaPlayer mp1 = MediaPlayer.create(GameActivity.this,R.raw.genesis11);
                MediaPlayer mp2 = MediaPlayer.create(GameActivity.this,R.raw.genesis12);
                MediaPlayer mp3 = MediaPlayer.create(GameActivity.this,R.raw.genesis21);
                MediaPlayer mp4 = MediaPlayer.create(GameActivity.this,R.raw.genesis22);
                MediaPlayer mp5 = MediaPlayer.create(GameActivity.this,R.raw.genesis31);
                MediaPlayer mp6 = MediaPlayer.create(GameActivity.this,R.raw.genesis32);
                MediaPlayer mp7 = MediaPlayer.create(GameActivity.this,R.raw.genesis41);
                MediaPlayer mp8 = MediaPlayer.create(GameActivity.this,R.raw.genesis42);
                MediaPlayer mp9 = MediaPlayer.create(GameActivity.this,R.raw.genesis51);
                MediaPlayer mp10 = MediaPlayer.create(GameActivity.this,R.raw.genesis52);
                MediaPlayer mp11 = MediaPlayer.create(GameActivity.this,R.raw.genesis61);
                MediaPlayer mp12 = MediaPlayer.create(GameActivity.this,R.raw.genesis62);
                MediaPlayer mpS =  MediaPlayer.create(GameActivity.this,R.raw.music00);

                mp =  new MediaPlayer[]{mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mpS};
                break;

            case "disturbed":
                MediaPlayer mp13 = MediaPlayer.create(GameActivity.this,R.raw.disturbed11);
                MediaPlayer mp14 = MediaPlayer.create(GameActivity.this,R.raw.disturbed12);
                MediaPlayer mp15 = MediaPlayer.create(GameActivity.this,R.raw.disturbed21);
                MediaPlayer mp16 = MediaPlayer.create(GameActivity.this,R.raw.disturbed22);
                MediaPlayer mp17 = MediaPlayer.create(GameActivity.this,R.raw.disturbed31);
                MediaPlayer mp18 = MediaPlayer.create(GameActivity.this,R.raw.disturbed32);
                MediaPlayer mp19 = MediaPlayer.create(GameActivity.this,R.raw.disturbed41);
                MediaPlayer mp20 = MediaPlayer.create(GameActivity.this,R.raw.disturbed42);
                MediaPlayer mp21 = MediaPlayer.create(GameActivity.this,R.raw.disturbed51);
                MediaPlayer mp22 = MediaPlayer.create(GameActivity.this,R.raw.disturbed52);
                MediaPlayer mp23 = MediaPlayer.create(GameActivity.this,R.raw.disturbed61);
                MediaPlayer mp24 = MediaPlayer.create(GameActivity.this,R.raw.disturbed62);
                MediaPlayer mpstart =  MediaPlayer.create(GameActivity.this,R.raw.music00);

                mp =  new MediaPlayer[]{mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mpstart};
                break;

            case "random":
                MediaPlayer mp25 = MediaPlayer.create(GameActivity.this,R.raw.music11);
                MediaPlayer mp26 = MediaPlayer.create(GameActivity.this,R.raw.music12);
                MediaPlayer mp27 = MediaPlayer.create(GameActivity.this,R.raw.music21);
                MediaPlayer mp28 = MediaPlayer.create(GameActivity.this,R.raw.music22);
                MediaPlayer mp29 = MediaPlayer.create(GameActivity.this,R.raw.music31);
                MediaPlayer mp30 = MediaPlayer.create(GameActivity.this,R.raw.music32);
                MediaPlayer mp31 = MediaPlayer.create(GameActivity.this,R.raw.music41);
                MediaPlayer mp32 = MediaPlayer.create(GameActivity.this,R.raw.music42);
                MediaPlayer mp33 = MediaPlayer.create(GameActivity.this,R.raw.music51);
                MediaPlayer mp34 = MediaPlayer.create(GameActivity.this,R.raw.music52);
                MediaPlayer mp35 = MediaPlayer.create(GameActivity.this,R.raw.music61);
                MediaPlayer mp36 = MediaPlayer.create(GameActivity.this,R.raw.music62);
                MediaPlayer mpSt =  MediaPlayer.create(GameActivity.this,R.raw.music00);

                mp =  new MediaPlayer[]{mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp26,mpSt};
                break;

            default:
                break;
        }


        lastTag = 12;
        mp[lastTag].start();

        }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void NewTag() {
        int[] integerArray = new int[12];
        for (int i = 0; i < 12; i++)
            integerArray[i] = i;

        shuffleArray(integerArray);

        pics.get(0).setTag(integerArray[0]);
        pics.get(0).setColorFilter(filter2);
        pics.get(1).setTag(integerArray[1]);
        pics.get(1).setColorFilter(filter2);
        pics.get(2).setTag(integerArray[2]);
        pics.get(2).setColorFilter(filter2);
        pics.get(3).setTag(integerArray[3]);
        pics.get(3).setColorFilter(filter2);
        pics.get(4).setTag(integerArray[4]);
        pics.get(4).setColorFilter(filter2);
        pics.get(5).setTag(integerArray[5]);
        pics.get(5).setColorFilter(filter2);
        pics.get(6).setTag(integerArray[6]);
        pics.get(6).setColorFilter(filter2);
        pics.get(7).setTag(integerArray[7]);
        pics.get(7).setColorFilter(filter2);
        pics.get(8).setTag(integerArray[8]);
        pics.get(8).setColorFilter(filter2);
        pics.get(9).setTag(integerArray[9]);
        pics.get(9).setColorFilter(filter2);
        pics.get(10).setTag(integerArray[10]);
        pics.get(10).setColorFilter(filter2);
        pics.get(11).setTag(integerArray[11]);
        pics.get(11).setColorFilter(filter2);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void shuffleArray(int[] intArray)
    {
        @SuppressLint({"NewApi","LocalSuppress"}) Random rnd = ThreadLocalRandom.current();
        for (int i = intArray.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = intArray[index];
            intArray[index] = intArray[i];
            intArray[i] = a;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void Musique(View view) throws IOException, InterruptedException {

        if(cpt == 2) {
            if (ancien.isEnabled() == true && ancien2.isEnabled() == true) {
                ancien.setColorFilter(filter2);
                ancien2.setColorFilter(filter2);
                cpt=0;
            }
        }

        nouveau = (ImageView) view;
        newTag = (int) nouveau.getTag();

        nouveau.setColorFilter(filter);
        nouveau.setEnabled(false);

        if (mp[lastTag].isPlaying()) {
            mp[lastTag].stop();
            mp[lastTag].prepare();
            if (cpt == 1) {
                flip.end();
            }
        }
        flip = ObjectAnimator.ofFloat(view,"rotationY",0f,180f);
        flip.setDuration(1000);
        flip.start();
        mp[newTag].start();
        lastTag = newTag;
        ancien2 = ancien;
        ancien = nouveau;
        nouveau = null;
        cpt++;



        if (cpt == 2) {
            tagDif = (int) ancien.getTag() % 2;
            tagDif2 = (int) ancien2.getTag() % 2;
            essai++;
            if (tagDif == 1) {
                if ((int)ancien.getTag() - 1 == (int) ancien2.getTag()) {
                    ancien.setColorFilter(filter3);
                    ancien2.setColorFilter(filter3);
                    ancien.setEnabled(false);
                    ancien2.setEnabled(false);
                    cpt = 0;
                    pts++;
                    textView.setText(pts + " nombre de chansons associées");
                }
                else {
                    ancien.setColorFilter(filter);
                    ancien2.setColorFilter(filter);
                    ancien.setEnabled(true);
                    ancien2.setEnabled(true);
                }
            } else if (tagDif2 == 1) {
                if ( (int)ancien2.getTag() - 1 == (int) ancien.getTag()) {
                    ancien.setColorFilter(filter3);
                    ancien2.setColorFilter(filter3);
                    ancien.setEnabled(false);
                    ancien2.setEnabled(false);
                    cpt = 0;
                    pts++;
                    textView.setText(pts + " nombre de chansons associées");
                }
                else {
                    ancien.setColorFilter(filter);
                    ancien2.setColorFilter(filter);
                    ancien.setEnabled(true);
                    ancien2.setEnabled(true);
                }
            } else {
                ancien.setColorFilter(filter);
                ancien2.setColorFilter(filter);
                ancien.setEnabled(true);
                ancien2.setEnabled(true);
            }
        }
        if(pts == 6 || essai == 12)
        {
            showDialog();
            mp[lastTag].stop();
        }

    }

    protected void Pause(View view){

        Button button = view.findViewById(R.id.btnPause);

        mp[lastTag].pause();
        showDialog();

    }

    protected void onPause() {

        super.onPause();
        mp[lastTag].stop();
        mp[lastTag].reset();
    }

    private void showDialog(){
        final Dialog myDialog = new Dialog(this);

        if (pts == 6) {
            myDialog.setTitle("Menu Fin");
            myDialog.setContentView(R.layout.dialog);

            TextView textView2 = myDialog.findViewById(R.id.textView);
            textView2.setText("Congratulation! You Just Win!");

            ImageView replay = (ImageView) myDialog.findViewById(R.id.Rejouer);
            replay.setVisibility(replay.GONE);

            ImageView home = (ImageView) myDialog.findViewById(R.id.Home);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    Intent intent = new Intent(GameActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);

                }
            });

            ImageView restart = (ImageView) myDialog.findViewById(R.id.Restart);
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    showDialogChoix();
                }
            });
            myDialog.show();

        }else if(essai == 12) {
            myDialog.setTitle("Menu Fin");
            myDialog.setContentView(R.layout.dialog);

            TextView textView2 = myDialog.findViewById(R.id.textView);
            textView2.setText("Oh No, You just lose! ");

            ImageView replay = (ImageView) myDialog.findViewById(R.id.Rejouer);
            replay.setVisibility(replay.GONE);

            ImageView home = (ImageView) myDialog.findViewById(R.id.Home);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    Intent intent = new Intent(GameActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);

                }
            });

            ImageView restart = (ImageView) myDialog.findViewById(R.id.Restart);
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    showDialogChoix();
                }
            });
            myDialog.show();

        }else{
            myDialog.setTitle("Menu Pause");
            myDialog.setContentView(R.layout.dialog);

            ImageView replay = (ImageView) myDialog.findViewById(R.id.Rejouer);
            replay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    mp[lastTag].start();
                }
            });

            ImageView home = (ImageView) myDialog.findViewById(R.id.Home);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    Intent intent = new Intent(GameActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);

                }
            });

            ImageView restart = (ImageView) myDialog.findViewById(R.id.Restart);
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=0;i<12;i++)
                    {
                        mp[i].reset();
                    }
                    showDialogChoix();

                }
            });
            myDialog.show();
        }
    }

    private void showDialogChoix(){
        final Dialog myDialog = new Dialog(this);


        myDialog.setTitle("Menu Choix");
        myDialog.setContentView(R.layout.choix);

        ImageView genesis = (ImageView) myDialog.findViewById(R.id.Genesis);
        genesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent intent = new Intent(GameActivity.this,GameActivity.class);
                String choix = "genesis";
                intent.putExtra("Choix",choix);
                finish();
                startActivity(intent);
            }
        });

        ImageView disturbed = (ImageView) myDialog.findViewById(R.id.Disturbed);
        disturbed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent intent = new Intent(GameActivity.this,GameActivity.class);
                String choix = "disturbed";
                intent.putExtra("Choix",choix);
                finish();
                startActivity(intent);
            }
        });

        ImageView random = (ImageView) myDialog.findViewById(R.id.Random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent intent = new Intent(GameActivity.this,GameActivity.class);
                String choix = "random";
                intent.putExtra("Choix",choix);
                finish();
                startActivity(intent);
            }
        });
        myDialog.show();
    }



}
