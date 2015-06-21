package com.goka.sample;

import com.goka.blurredgridmenu.Config;
import com.goka.blurredgridmenu.GridMenuFragment;
import com.goka.blurredgridmenu.MenuItem;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private GridMenuFragment mGridMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Config.build(new Config.Builder()
//                .radius(1)
//                .downsample(1)
//                .overlayColor(Color.parseColor("#000000")));

        setContentView(R.layout.activity_main);

        mGridMenuFragment = GridMenuFragment.newInstance(R.drawable.back);

        findViewById(R.id.show_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.main_frame, mGridMenuFragment);
                tx.addToBackStack(null);
                tx.commit();
            }
        });


        List<MenuItem> menus = new ArrayList<>();
        menus.add(new MenuItem("Home", R.drawable.home));
        menus.add(new MenuItem("Calendar", R.drawable.calendar));
        menus.add(new MenuItem("Overview", R.drawable.overview));
        menus.add(new MenuItem("Groups", R.drawable.groups));
        menus.add(new MenuItem("Lists", R.drawable.lists));
        menus.add(new MenuItem("Profile", R.drawable.profile));
        menus.add(new MenuItem("Timeline", R.drawable.timeline));
        menus.add(new MenuItem("Setting", R.drawable.settings));


        mGridMenuFragment.setMenu(menus);
        mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
            @Override
            public void onClickMenu(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, menuItem.title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (0 == getSupportFragmentManager().getBackStackEntryCount()){
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

}
