package myid.dika.komik.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.akshay.library.CurveBottomBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import myid.dika.komik.R;
import myid.dika.komik.fragment.GenreFragment;
import myid.dika.komik.fragment.HomeFragment;
import myid.dika.komik.utils.BottomBarBehavior;

public class MainActivity extends AppCompatActivity {

    CurveBottomBar navigation;
    FloatingActionButton fab;
    TextView tvmail,tvdev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.curveBottomBar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

       

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomBarBehavior());

        if (savedInstanceState == null){
            navigation.setSelectedItemId(R.id.navigation_home);
        }

    }


    private final CurveBottomBar.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new CurveBottomBar.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameContainer, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_list:
                    fragment = new GenreFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameContainer, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
            }
            return false;
        }
    };

}
