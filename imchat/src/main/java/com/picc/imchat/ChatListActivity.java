package com.picc.imchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatListActivity extends AppCompatActivity {

    private static final String[] titles = {"消息", "通讯录"};
    private static final int[] drawables = {R.drawable.im_select_bottom_home, R.drawable.im_select_bottom_message};

    private TabLayout bottomLayout;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.im_activity_chat_list);
        initData();
        initView();

    }

    private void initData() {
//        fragmentList = new ArrayList<>();
//        fragmentList.add(MessageFragment.getInstance());
//        fragmentList.add(AddressListFragment.getInstance());
    }

    private void initView() {
        bottomLayout = (TabLayout) findViewById(R.id.im_tl_bottom_layout);
        bottomLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //selectFragmentPage(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for (int i = 0; i < titles.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.im_item_bottom_tab, bottomLayout, false);
            ((ImageView) view.findViewById(R.id.im_iv_bottom_icon)).setImageResource(drawables[i]);
            ((TextView) view.findViewById(R.id.im_tv_bottom_text)).setText(titles[i]);
            bottomLayout.addTab(bottomLayout.newTab().setCustomView(view));
        }
    }

    private void selectFragmentPage(int position) {
        Fragment fragment = fragmentList.get(position);
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.im_container, fragment).commit();
        }
    }


}
