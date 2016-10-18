package dk.rxajavaretrofit.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dk.rxajavaretrofit.R;
import dk.rxajavaretrofit.entity.HttpEntity;
import dk.rxajavaretrofit.http.HttpMethods;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @NonNull @Bind(R.id.result_TV) TextView resultTV;

    private Subscriber subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.click_me_BN)
    public void onClick(){
        getMovie();
    }

    private void getMovie(){
        subscriber = new Subscriber<HttpEntity>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "完成加载",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                resultTV.setText(e.getMessage());
            }

            @Override
            public void onNext(HttpEntity httpEntity) {
                resultTV.setText(httpEntity.toString());
            }
        };
        HttpMethods.getInstance().getTopMovie(subscriber , 0 ,10);
    }
}
