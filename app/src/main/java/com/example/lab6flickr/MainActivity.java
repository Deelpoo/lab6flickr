package com.example.lab6flickr;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab6flickr.model.Feed;
import com.example.lab6flickr.model.entry.Entry;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "https://www.flickr.com/services/feeds/";

    ListView listView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        listView = (ListView)findViewById(R.id.listview);
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        final FeedAPI feedAPI = retrofit.create(FeedAPI.class);
        Call<Feed> call = feedAPI.getFeed();

        TextView feed = (TextView)findViewById(R.id.feed);
        feed.setTextColor(Color.parseColor("#0059d6"));

        createImageLinkList(call);
    }

    private void createImageLinkList(Call<Feed> call){

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                List<Entry> entrys = response.body().getEntrys();

                List<String> titles = new ArrayList<>();
                List<String> publisheds = new ArrayList<>();
                List<String> imagesUrl = new ArrayList<>();

                for(Entry e : entrys){
                    titles.add(e.getTitle());
                    publisheds.add(e.getPublished());
                    imagesUrl.add(e.getLinks().get(1).getHref());
                }

                MyAdapter myAdapter = new MyAdapter(MainActivity.this, titles, publisheds, imagesUrl);
                listView.setAdapter(myAdapter);

                Log.d(TAG,"onResponse: feed: " + response.body().getEntrys());
                Log.d(TAG,"onResponse: Server Response: " + response.toString());
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(MainActivity.this, "An Error Ocurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

