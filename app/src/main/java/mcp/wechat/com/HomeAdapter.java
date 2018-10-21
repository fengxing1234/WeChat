package mcp.wechat.com;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @name WeChat
 * @class name：mcp.wechat.com
 * @class describe
 * @anthor fengxing QQ:296016140
 * @time 2018/10/20 下午3:16
 * @change
 * @chang time
 * @class describe
 */
public class HomeAdapter extends RecyclerView.Adapter {

    private int layoutIds;
    private List<String> list;


    public HomeAdapter(@LayoutRes int layoutIds, List<String> list) {
        this.layoutIds = layoutIds;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutIds, parent, false);
        HomeHolder homeHolder = new HomeHolder(view);
        return homeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class HomeHolder extends RecyclerView.ViewHolder {

        public HomeHolder(View itemView) {
            super(itemView);
        }
    }
}
