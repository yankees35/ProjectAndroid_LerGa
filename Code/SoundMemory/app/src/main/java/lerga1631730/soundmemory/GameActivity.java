package lerga1631730.soundmemory;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
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

public class GameActivity extends AppCompatActivity {

    MediaPlayer []mp;
    int lastTag;
    int newTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        final MediaPlayer mp1 = MediaPlayer.create(GameActivity.this,R.raw.claude);
        final MediaPlayer mp2 = MediaPlayer.create(GameActivity.this,R.raw.jean);
        mp =  new MediaPlayer[]{mp1,mp2};


        }

    protected void Musique(View view) throws IOException {
        newTag = Integer.parseInt((String) view.getTag());


        if (mp[lastTag].isPlaying()) {
            mp[lastTag].stop();
            mp[lastTag].prepare();
        }
        mp[newTag].start();


        lastTag = newTag;
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
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Button quit = (Button)myDialog.findViewById(R.id.Quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                finish();
                System.exit(0);
            }
        });

        myDialog.show();
    }


}
