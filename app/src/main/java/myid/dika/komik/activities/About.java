package myid.dika.komik.activities;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import myid.dika.komik.R;

public class About extends AppCompatActivity {
    LinearLayout personalinfo;
    TextView tvmail, tvig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        personalinfo = findViewById(R.id.personalinfo);

        tvmail = findViewById(R.id.tv_mail);
        tvmail.setMovementMethod(LinkMovementMethod.getInstance());

        tvig = findViewById(R.id.tv_ig);
        tvig.setMovementMethod(LinkMovementMethod.getInstance());

        /*making personal info visible*/
        personalinfo.setVisibility(View.VISIBLE);
    }

    public void onBackPressed() {
        return;
    }
    public void BackPressed() {
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                BackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
