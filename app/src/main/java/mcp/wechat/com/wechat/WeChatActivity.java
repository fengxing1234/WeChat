package mcp.wechat.com.wechat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mcp.wechat.com.R;

/**
 * @name WeChat
 * @class name：mcp.wechat.com.wechat
 * @class describe
 * @anthor fengxing QQ:296016140
 * @time 2018/10/18 下午9:34
 * @change
 * @chang time
 * @class describe
 */
public class WeChatActivity extends AppCompatActivity {

    private static final String[] titles = {"消息", "通讯录"};
    private static final int[] drawables = {R.drawable.select_bottom_home, R.drawable.select_bottom_message};
    private static final String TAG = WeChatActivity.class.getSimpleName();

    private TabLayout bottomLayout;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);
        initData();
        initView();

    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(MessageFragment.getInstance());
        fragmentList.add(AddressListFragment.getInstance());
    }

    private void initView() {
        bottomLayout = (TabLayout) findViewById(R.id.tl_bottom_layout);
        bottomLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: " + tab);
                selectFragmentPage(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for (int i = 0; i < titles.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_bottom_tab, bottomLayout, false);
            ((ImageView) view.findViewById(R.id.iv_bottom_icon)).setImageResource(drawables[i]);
            ((TextView) view.findViewById(R.id.tv_bottom_text)).setText(titles[i]);
            bottomLayout.addTab(bottomLayout.newTab().setCustomView(view));
        }
    }

    private void selectFragmentPage(int position) {
        Fragment fragment = fragmentList.get(position);
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }


}
