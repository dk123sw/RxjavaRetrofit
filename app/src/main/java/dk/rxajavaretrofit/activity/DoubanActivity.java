package dk.rxajavaretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import dk.rxajavaretrofit.Adapter.MoiveAdapter;
import dk.rxajavaretrofit.R;
import dk.rxajavaretrofit.entity.HttpEntity;
import dk.rxajavaretrofit.http.MoiveMethods;
import rx.Subscriber;

public class DoubanActivity extends AppCompatActivity {

    @Bind(R.id.movie_listview)
    ListView listView;
    Toolbar mtoolbar;
    MoiveAdapter moiveAdapter;
    Subscriber subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        ButterKnife.bind(this);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        moiveAdapter = new MoiveAdapter(DoubanActivity.this);
        listView.setAdapter(moiveAdapter);
        getMovie();
    }

    private void getMovie(){
        subscriber = new Subscriber<HttpEntity>() {
            @Override
            public void onCompleted() {
                Toast.makeText(DoubanActivity.this, "完成加载",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HttpEntity httpEntity) {

            }
        };
        MoiveMethods.getInstance().getMovie(subscriber , 0 ,10);
    }

}
