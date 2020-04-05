package com.vishal.buffershare.Api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 28/6/17.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("oauth2/token.json")
    Call<JsonObject> getAccessToken(@Field("client_id") String client_id,
                                    @Field("client_secret") String client_secret,
                                    @Field("redirect_uri") String redirect_uri,
                                    @Field("code") String code,
                                    @Field("grant_type") String grant_type);

    //profile get
    @GET("profiles.json")
    Call<JsonObject> getProfile(@Query("access_token") String access_token);

    //get User
    @GET("user.json")
    Call<JsonObject> getUser(@Query("access_token") String access_token);

    //get Profile with iD
    @GET("profiles/{id}.json")
    Call<JsonObject> getProfileWithId(@Path("id") String id, @Query("access_token") String access_token);


    //get Profile with iD schedules
    @GET("profiles/{id}/schedules.json")
    Call<JsonObject> getProfileWithIdSchedule(@Path("id") String id, @Query("access_token") String access_token);

    //get Profile with iD schedules and Update
    @POST("profiles/{id}/schedules/update.json")
    Call<JsonObject> getProfileWithIdScheduleUpdate(@Path("id") String id, @Query("access_token") String access_token);

    //create link post
    @POST("updates/create.json")
    Call<JsonObject> createLinkPost(@Query("access_token") String access_token,
                                @Field("text") String text,
                                @Field("profile_ids[]") String ids,
                                @Field("profile_ids[]") String ids1,
                                @Field("media[link]") String link,
                                @Field("media[description]") String description);

    //create image post
    @POST("updates/create.json")
    Call<JsonObject> createImagePost(@Query("access_token") String access_token,
                                @Field("text") String text,
                                @Field("profile_ids[]") String ids,
                                @Field("profile_ids[]") String ids1,
                                @Field("media[photo]") String link,
                                @Field("media[thumbnail]") String description);

    //share post-update_id
    @POST("updates/{id}/share.json")
    Call<JsonObject> sharePost(@Path("id") String id,@Query("access_token") String access_token);

    //delete post-update_id
    @POST("updates/{id}/destroy.json")
    Call<JsonObject> destroyPost(@Path("id") String id,@Query("access_token") String access_token);

}
