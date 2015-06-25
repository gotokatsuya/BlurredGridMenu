package com.goka.sample;


import com.goka.blurredgridmenu.GridMenu;
import com.goka.blurredgridmenu.GridMenuFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private GridMenuFragment mGridMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        setupGridMenu();

        mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
            @Override
            public void onClickMenu(GridMenu gridMenu, int position) {
                Toast.makeText(MainActivity.this, "Title:" + gridMenu.getTitle() + ", Position:" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupGridMenu() {
        List<GridMenu> menus = new ArrayList<>();
        menus.add(new GridMenu("Home", R.drawable.home));
        menus.add(new GridMenu("Calendar", R.drawable.calendar));
        menus.add(new GridMenu("Overview", R.drawable.overview));
        menus.add(new GridMenu("Groups", R.drawable.groups));
        menus.add(new GridMenu("Lists", R.drawable.lists));
        menus.add(new GridMenu("Profile", R.drawable.profile));
        menus.add(new GridMenu("Timeline", R.drawable.timeline));
        menus.add(new GridMenu("Setting", R.drawable.settings));

        mGridMenuFragment.setupMenu(menus);
    }

    @Override
    public void onBackPressed() {
        if (0 == getSupportFragmentManager().getBackStackEntryCount()) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

}
