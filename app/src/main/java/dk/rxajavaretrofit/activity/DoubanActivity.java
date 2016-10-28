package dk.rxajavaretrofit.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import dk.rxajavaretrofit.Adapter.MoiveListsProvider;
import dk.rxajavaretrofit.R;
import dk.rxajavaretrofit.entity.BookListResponse;
import dk.rxajavaretrofit.entity.Movie;
import dk.rxajavaretrofit.http.MoiveMethods;
import me.drakeet.multitype.MultiTypeAdapter;
import retrofit2.Response;
import rx.Subscriber;

public class DoubanActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

//    @Bind(R.id.movie_listview)
//    ListView listView;
//    MoiveAdapter moiveAdapter;
    Toolbar mtoolbar;
    Subscriber subscriber;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    MultiTypeAdapter adapter;
    Object result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
//        ButterKnife.bind(this);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
//        moiveAdapter = new MoiveAdapter(DoubanActivity.this);
//        listView.setAdapter(moiveAdapter);
        getMovie();
//        initView();
        this.swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        this.recyclerView = (RecyclerView) findViewById(R.id.rv_details);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initView();
    }

    private void initView(){
        BookListResponse response = (BookListResponse) result;
        adapter = new MultiTypeAdapter(response.getBooks());
        adapter.register(Movie.class ,new MoiveListsProvider());
        recyclerView.setAdapter(adapter);
        onRefresh();
    }


    private void getMovie(){
        subscriber = new Subscriber<Response<Movie>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(DoubanActivity.this, "完成加载",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(DoubanActivity.this , "出错" ,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Response<Movie> movie) {

            }
        };
        MoiveMethods.getInstance().getMovie(subscriber , 0 ,10);
    }

    @Override
    public void onRefresh() {
        MoiveMethods.getInstance().getMovie(subscriber , 0 ,10);
    }
}
