package lerga1631730.soundmemory;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void Click(View view)
    {
        showDialog();
    }

    private void showDialog(){
            final Dialog myDialog = new Dialog(this);


            myDialog.setTitle("Menu Choix");
            myDialog.setContentView(R.layout.choix);

            ImageView genesis = (ImageView) myDialog.findViewById(R.id.Genesis);
             genesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
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
                    Intent intent = new Intent(MainActivity.this,GameActivity.class);
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
                    Intent intent = new Intent(MainActivity.this,GameActivity.class);
                    String choix = "random";
                    intent.putExtra("Choix",choix);
                    finish();
                    startActivity(intent);
                }
            });
            myDialog.show();
    }

    public void Quit(View v)
    {
        finish();
        System.exit(0);
    }


}
