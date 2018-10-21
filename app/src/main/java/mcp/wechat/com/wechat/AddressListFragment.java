package mcp.wechat.com.wechat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mcp.wechat.com.R;

/**
 * @name WeChat
 * @class name：mcp.wechat.com.wechat
 * @class describe
 * @anthor fengxing QQ:296016140
 * @time 2018/10/20 下午4:56
 * @change
 * @chang time
 * @class describe
 */
public class AddressListFragment extends Fragment {

    public static AddressListFragment getInstance() {
        AddressListFragment addressListFragment = new AddressListFragment();
        return addressListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_list_layout, container, false);
        return view;
    }
}
