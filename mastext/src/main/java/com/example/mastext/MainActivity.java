package com.example.mastext;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private LinearLayout mLl;
    private NavigationView mNv;
    private Toolbar mToolbar;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNv = (NavigationView) findViewById(R.id.nv);

        mToolbar.setTitle("我的");
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InformationFragment());
        fragments.add(new LinkmanFragment());
        fragments.add(new DynamicFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("消息").setIcon(R.drawable.a);
        mTab.getTabAt(1).setText("联系人").setIcon(R.drawable.b);
        mTab.getTabAt(2).setText("动态").setIcon(R.drawable.c);

    }
}
