package lerga1631730.soundmemory;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

    protected void Musique(View view) {
        newTag = Integer.parseInt((String) view.getTag());

        if (mp[lastTag].isPlaying()) {
            mp[lastTag].stop();
        }
        mp[newTag].start();


        lastTag = newTag;
    }


}
