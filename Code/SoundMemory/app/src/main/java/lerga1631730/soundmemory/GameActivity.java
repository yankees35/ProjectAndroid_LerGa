package lerga1631730.soundmemory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity {

    MediaPlayer []mp;
    int lastTag,newTag,cpt=0;
    ArrayList<ImageView> pics;
    Random rnd;
    ImageView ancien,ancien2,nouveau;

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        rnd = new Random();

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
        mp =  new MediaPlayer[]{mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12};


        }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void NewTag() {
        int[] integerArray = new int[12];
        for (int i = 0; i < 12; i++)
            integerArray[i] = i;

        shuffleArray(integerArray);
        ColorFilter filter = new LightingColorFilter( Color.BLUE, Color.BLUE);

        pics.get(0).setTag(integerArray[0]);
        pics.get(0).setColorFilter(filter);
        pics.get(1).setTag(integerArray[1]);
        pics.get(1).setColorFilter(filter);
        pics.get(2).setTag(integerArray[2]);
        pics.get(2).setColorFilter(filter);
        pics.get(3).setTag(integerArray[3]);
        pics.get(3).setColorFilter(filter);
        pics.get(4).setTag(integerArray[4]);
        pics.get(4).setColorFilter(filter);
        pics.get(5).setTag(integerArray[5]);
        pics.get(5).setColorFilter(filter);
        pics.get(6).setTag(integerArray[6]);
        pics.get(6).setColorFilter(filter);
        pics.get(7).setTag(integerArray[7]);
        pics.get(7).setColorFilter(filter);
        pics.get(8).setTag(integerArray[8]);
        pics.get(8).setColorFilter(filter);
        pics.get(9).setTag(integerArray[9]);
        pics.get(9).setColorFilter(filter);
        pics.get(10).setTag(integerArray[10]);
        pics.get(10).setColorFilter(filter);
        pics.get(11).setTag(integerArray[11]);
        pics.get(11).setColorFilter(filter);


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

    protected void Musique(View view) throws IOException {


        ColorFilter filter = new LightingColorFilter(Color.RED,Color.RED);
        ColorFilter filter2 = new LightingColorFilter(Color.BLUE,Color.BLUE);
        nouveau = (ImageView) view;
        newTag = (int) view.getTag();

        if (cpt == 2) {
            ancien.setColorFilter(filter2);
            ancien2.setColorFilter(filter2);
            cpt = 0;
            Musique(view);
        }
        else {
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

        myDialog.setTitle("Menu Pause");
        myDialog.setContentView(R.layout.dialog);

        Button replay = (Button)myDialog.findViewById(R.id.Rejouer);

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                mp[lastTag].start();
            }
        });


        Button home = (Button)myDialog.findViewById(R.id.Back);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });


        myDialog.show();
    }


}
