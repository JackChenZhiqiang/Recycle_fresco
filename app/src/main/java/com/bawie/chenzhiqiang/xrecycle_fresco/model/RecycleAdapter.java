package com.bawie.chenzhiqiang.xrecycle_fresco.model;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.chenzhiqiang.xrecycle_fresco.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecycleAdapter";
    private final Context context;
    private final List<PicBean.DataBean> list;
    private MyViewHodler2 hodler2;
    private MyViewHolder1 holder1;
    private int Type_cout = 1;
    private int Type_cout1 = 2;


    public RecycleAdapter(Context context, List<PicBean.DataBean> list) {
        this.context = context;
        Log.d (TAG, "RecycleAdapter: " + list.size ());
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Type_cout) {
            View view = View.inflate (context, R.layout.layout_left, null);

            holder1 = new MyViewHolder1 (view);

            return holder1;
        } else if (viewType ==  Type_cout1) {
            View view = View.inflate (context, R.layout.layout_right, null);

            hodler2 = new MyViewHodler2 (view);

            return hodler2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            holder1 = (MyViewHolder1) holder;

            SimpleDraweeView left_pic = holder1.getLeft_pic ();

            String images = list.get (position).getImages ();

            String img = images.split ("\\|")[0];

            Uri uri = Uri.parse(img);

            left_pic.setImageURI (uri);

        } else if (holder instanceof MyViewHodler2) {
            hodler2 = (MyViewHodler2) holder;

            SimpleDraweeView right_pic = hodler2.getRight_pic ();

            String images1 = list.get (position).getImages ();

            String img1 = images1.split ("\\|")[0];

            Uri uri = Uri.parse(img1);

            right_pic.setImageURI (uri);
        }
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return Type_cout;
        } else {
            return Type_cout1;
        }

    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView left_pic;

        public MyViewHolder1(View itemView) {
            super (itemView);

            left_pic = itemView.findViewById (R.id.left_pic);
        }

        public SimpleDraweeView getLeft_pic() {
            return left_pic;
        }
    }

    class MyViewHodler2 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView right_pic;

        public MyViewHodler2(View itemView) {
            super (itemView);

            right_pic = itemView.findViewById (R.id.right_pic);
        }

        public SimpleDraweeView getRight_pic() {
            return right_pic;
        }
    }

}
