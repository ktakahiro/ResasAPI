package jp.ac.titech.itpro.sdl.resasapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import jp.ac.titech.itpro.sdl.resasapi.model.Prefecture;
import jp.ac.titech.itpro.sdl.resasapi.model.Prefectures;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private APIInterface mApiInterface;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                // BASE URL
                .baseUrl(APIInterface.END_POINT)
                // gsonコンバーター
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // インタフェース作成
        mApiInterface = retrofit.create(APIInterface.class);
        getPrefecture(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPrefecture(int prefCode){

        // Hatena API呼び出し
        Call<Prefectures> call = mApiInterface.getPrefCode(prefCode);
        call.enqueue(new Callback<Prefectures>() {
            @Override
            public void onResponse(Call<Prefectures> call, Response<Prefectures> response) {
                Log.d(TAG, "onResponse: " + response.isSuccessful());
                Prefectures prefectures = response.body();
                List<Prefecture> prefecture = prefectures.getResult();

                for (Prefecture p : prefecture){
                    Log.v("prefecture",p.getPrefName());
                }
            }

            @Override
            public void onFailure(Call<Prefectures> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getCause() + ", " + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
