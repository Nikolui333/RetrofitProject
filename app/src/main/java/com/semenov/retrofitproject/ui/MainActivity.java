package com.semenov.retrofitproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.semenov.retrofitproject.R;
import com.semenov.retrofitproject.model.Example;
import com.semenov.retrofitproject.service.Client;
import com.semenov.retrofitproject.ui.adapter.MyAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.pagination_list);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://favqs.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Client client = retrofit.create(Client.class);
        Call/*<List*/<Example>/*>*/ call = client.reposForUser();
        Log.d("mylog1","внешний log");
        call.enqueue(new Callback/*<List*/<Example>/*>*/() {
            @Override
            public void onResponse(Call/*<List*/<Example>/*>*/ call, Response/*<List*/<Example>/*>*/ response) {
                /*List<*/Example/*> */repos = response.body();
                Log.d("mylog1", String.valueOf(repos));
                Log.d("mylog1","mylog");

                listView.setAdapter(new MyAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call/*<List*/<Example>/*>*/ call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}