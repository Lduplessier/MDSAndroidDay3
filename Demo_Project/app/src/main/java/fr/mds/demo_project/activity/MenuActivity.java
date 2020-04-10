package fr.mds.demo_project.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.mds.demo_project.R;
import fr.mds.demo_project.model.Virus;

public class MenuActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "DemoProject";

    private Button bt_menu_spinner, bt_menu_picasso, bt_menu_demo_extra, bt_menu_demo_open_url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_menu_spinner = findViewById(R.id.bt_menu_spinner);
        bt_menu_picasso = findViewById(R.id.bt_menu_picasso);
        bt_menu_demo_extra = findViewById(R.id.bt_menu_demo_extra);
        bt_menu_demo_open_url = findViewById(R.id.bt_menu_demo_open_url);

        bt_menu_spinner.setOnClickListener(this);
        bt_menu_picasso.setOnClickListener(this);
        bt_menu_demo_extra.setOnClickListener(this);
        bt_menu_demo_open_url.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == bt_menu_spinner) {
            Log.d(TAG, "MenuActivity - onClick - bt_menu_spinner");

            Intent intent = new Intent(this, SpinnerActivity.class);
            startActivity(intent);

            return;
        }

        if (v == bt_menu_picasso) {
            Log.d(TAG, "MenuActivity - onClick - bt_menu_picasso");

            Intent intent = new Intent(this, PicassoActivity.class);
            startActivity(intent);

            return;
        }

        if (v == bt_menu_demo_extra) {
            Log.d(TAG, "MenuActivity - onClick - bt_menu_demo_extra");

            Virus virus = new Virus("Covid-19", "China", 4);
            Intent intent = new Intent(this, DemoExtraActivity.class);
            intent.putExtra("message", "This a message from MenuActivity");
            startActivityForResult(intent, 0);

            return;
        }

        if (v == bt_menu_demo_open_url) {
            Log.d(TAG, "MenuActivity - onClick - bt_menu_demo_open_url");

            Uri uri = Uri.parse("https://www.mydigitalschool.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "MenuActivity - onActivityResult");
        Log.d(TAG, "ResultCode " + resultCode);

        if (data != null && data.getExtras() != null) {
            String response = data.getExtras().getString("response");
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        }
    }
}
