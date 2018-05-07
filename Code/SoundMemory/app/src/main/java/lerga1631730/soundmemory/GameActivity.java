package lerga1631730.soundmemory;

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
    int lastTag,newTag,cpt=0, tagDif = 0,tagDif2 = 0, pts = 0;
    ArrayList<ImageView> pics;
    ImageView ancien,ancien2,nouveau;
    TextView textView;
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


        final MediaPlayer mp1 = MediaPlayer.create(GameActivity.this,R.raw.music11);
        final MediaPlayer mp2 = MediaPlayer.create(GameActivity.this,R.raw.music12);
        final MediaPlayer mp3 = MediaPlayer.create(GameActivity.this,R.raw.music21);
        final MediaPlayer mp4 = MediaPlayer.create(GameActivity.this,R.raw.music22);
        final MediaPlayer mp5 = MediaPlayer.create(GameActivity.this,R.raw.music31);
        final MediaPlayer mp6 = MediaPlayer.create(GameActivity.this,R.raw.music32);
        final MediaPlayer mp7 = MediaPlayer.create(GameActivity.this,R.raw.music41);
        final MediaPlayer mp8 = MediaPlayer.create(GameActivity.this,R.raw.music42);
        final MediaPlayer mp9 = MediaPlayer.create(GameActivity.this,R.raw.music51);
        final MediaPlayer mp10 = MediaPlayer.create(GameActivity.this,R.raw.music52);
        final MediaPlayer mp11 = MediaPlayer.create(GameActivity.this,R.raw.music61);
        final MediaPlayer mp12 = MediaPlayer.create(GameActivity.this,R.raw.music62);
        final MediaPlayer mpS =  MediaPlayer.create(GameActivity.this,R.raw.music00);

        mp =  new MediaPlayer[]{mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mpS};

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

        nouveau = (ImageView) view;
        newTag = (int) nouveau.getTag();

        nouveau.setColorFilter(filter);

        if (mp[lastTag].isPlaying()) {
            mp[lastTag].stop();
            mp[lastTag].prepare();
        }
        mp[newTag].start();
        lastTag = newTag;
        ancien2 = ancien;
        ancien = nouveau;


        cpt++;


        if (cpt == 2) {
            tagDif = (int) ancien.getTag() % 2;
            tagDif2 = (int) ancien2.getTag() % 2;
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
                    ancien.setColorFilter(filter2);
                    ancien2.setColorFilter(filter2);
                    cpt = 0;
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
                    ancien.setColorFilter(filter2);
                    ancien2.setColorFilter(filter2);
                    cpt = 0;
                }
            } else {
                ancien.setColorFilter(filter2);
                ancien2.setColorFilter(filter2);
                cpt = 0;
            }
        }
        if(pts == 6)
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
        try {
            mp[lastTag].prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDialog(){
        final Dialog myDialog = new Dialog(this);

        if (pts == 6) {
            myDialog.setTitle("Menu Fin");
            myDialog.setContentView(R.layout.dialog);

            TextView textView2 = myDialog.findViewById(R.id.textView);
            textView2.setText("Bravo! Vous avez fini!");

            Button replay = (Button) myDialog.findViewById(R.id.Rejouer);


            Button home = (Button) myDialog.findViewById(R.id.Back);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    Intent intent = new Intent(GameActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

            Button restart = (Button) myDialog.findViewById(R.id.Restart);
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    Intent intent = new Intent(GameActivity.this,GameActivity.class);
                    startActivity(intent);
                }
            });
            myDialog.show();

        }else {
            myDialog.setTitle("Menu Pause");
            myDialog.setContentView(R.layout.dialog);

            Button replay = (Button) myDialog.findViewById(R.id.Rejouer);

            replay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    mp[lastTag].start();
                }
            });


            Button home = (Button) myDialog.findViewById(R.id.Back);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    finish();

                }
            });

            Button restart = (Button) myDialog.findViewById(R.id.Restart);
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                    finish();
                    Intent intent = new Intent(GameActivity.this,GameActivity.class);
                    startActivity(intent);
                }
            });

            myDialog.show();
        }
    }



}
