package mcp.wechat.com.wechat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mcp.wechat.com.R;

/**
 * @name WeChat
 * @class name：mcp.wechat.com.wechat
 * @class describe
 * @anthor fengxing QQ:296016140
 * @time 2018/10/20 下午3:45
 * @change
 * @chang time
 * @class describe
 */
public class MessageFragment extends Fragment {

    private MessageAdapter adapter;

    public static MessageFragment getInstance() {
        MessageFragment messageFragment = new MessageFragment();
        return messageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MessageAdapter(R.layout.layout_message_adapter, null);
        adapter.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MessageAdapter.MessageViewHolder commonHolder, View v, int layoutPosition) {
                Toast.makeText(getContext(), "点击了第" + layoutPosition + "条数据", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        setupData();
    }

    private void setupData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是第" + i + "条数据");
        }
        adapter.setData(list);
    }


}
