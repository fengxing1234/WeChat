package mcp.wechat.com.wechat;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import mcp.wechat.com.R;

/**
 * @name WeChat
 * @class name：mcp.wechat.com.wechat
 * @class describe
 * @anthor fengxing QQ:296016140
 * @time 2018/10/21 上午8:59
 * @change
 * @chang time
 * @class describe
 */
class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private int layoutRes;
    private List<String> list;


    public MessageAdapter(@LayoutRes int layoutRes, List<String> list) {
        this.layoutRes = layoutRes;
        this.list = list;
    }

    public void setData(List<String> list) {
        this.list = list == null ? new ArrayList<String>() : list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MessageViewHolder holder = MessageViewHolder.get(parent, layoutRes);
        bindItemOnClickListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        ImageView iv_icon = (ImageView) holder.getView(R.id.iv_icon);
        TextView tv_name = (TextView) holder.getView(R.id.tv_name);
        TextView tv_draft = (TextView) holder.getView(R.id.tv_draft);
        TextView tv_history_msg = (TextView) holder.getView(R.id.tv_history_msg);
        TextView tv_history_time = (TextView) holder.getView(R.id.tv_history_time);

        tv_name.setText("张" + position);
        if (position % 3 == 0) {
            tv_draft.setVisibility(View.VISIBLE);
        }

        tv_history_msg.setText("历史消息:" + position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(MessageViewHolder commonHolder, View v, int layoutPosition);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private void bindItemOnClickListener(final MessageViewHolder holder) {
        if (holder == null) {
            return;
        }
        if (holder.itemView == null) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder, v, holder.getLayoutPosition());
                }
            }
        });
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        private View itemView;

        private SparseArray<View> views;

        public MessageViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            views = new SparseArray<>();
        }

        public static MessageViewHolder get(ViewGroup parent, int layoutId) {
            View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            return new MessageViewHolder(view);
        }

        public <T extends View> T getView(@IdRes int resId) {
            if (itemView == null) {
                return null;
            }
            View view = views.get(resId);
            if (view == null) {
                view = itemView.findViewById(resId);
                views.put(resId, view);
            }
            return (T) view;
        }
    }
}
