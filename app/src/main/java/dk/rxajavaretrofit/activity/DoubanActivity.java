package dk.rxajavaretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dk.rxajavaretrofit.Adapter.MoiveAdapter;
import dk.rxajavaretrofit.R;

public class DoubanActivity extends AppCompatActivity {

    @Bind(R.id.movie_listview)
    ListView listView;
    Toolbar mtoolbar;
    MoiveAdapter moiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        ButterKnife.bind(this);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        moiveAdapter = new MoiveAdapter(DoubanActivity.this);
        listView.setAdapter(moiveAdapter);
    }


}
