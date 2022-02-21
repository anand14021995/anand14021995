package com.alo.eparts.catalog;

import com.alo.eparts.RestApi.User;
import com.alo.eparts.ui.ModelData;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @Headers(value = {
            "Accept:application/json",
            "Content-Type: application/json;charset=UTF-8",
            "Accept-Language: en",

    })
    // as we are making get request so we are displaying
    // GET as annotation.
    // and inside we are passing last parameter for our url.
    @GET("WO6S")

    // as we are calling data from array so we are calling
    // it with array list and naming that method as getAllCourses();
    Call<ArrayList<RecyclerData>> getAllCourses();
    @GET("andgetcountrylist")
    Call<ArrayList<BrandData>> getAllBrand();

    @GET("andgetstatelist/{countryid}")
    Call<ArrayList<ModelData>> getAllModel(@Path("countryid") String countryid);

    @GET("andgetby_id/{id}")
    Call<List<VinData>> getAllVin(@Path("id") String id);
}