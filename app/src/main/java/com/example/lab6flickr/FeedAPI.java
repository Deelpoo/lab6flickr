package com.example.lab6flickr;

import com.example.lab6flickr.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FeedAPI {

    String BASE_URL = "https://www.flickr.com/services/feeds/";

    @GET("photos_public.gne")
    Call<Feed> getFeed();
}
