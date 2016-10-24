package dk.rxajavaretrofit.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dk on 2016/10/24.
 */

public class MoiveAdapter extends BaseAdapter {

    public Context context;

    public MoiveAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = new LinearLayout(context);
//         ImageView imageView = new ImageView(DoubanActivity.this);
        TextView textView = new TextView(context);
        textView.setText("测试" + (position + 1) + "1");
        textView.setTextSize(40);
        linearLayout.addView(textView);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }
}
