package com.deilsky.simple.ronetworksimple.mvc;

import com.deilsky.network.RoResult;
import com.deilsky.simple.ronetworksimple.mvc.model.CategoryModel;
import com.deilsky.simple.ronetworksimple.mvc.model.CompanyModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Complain;
import com.deilsky.simple.ronetworksimple.mvc.model.SaveComplain;
import com.deilsky.simple.ronetworksimple.mvc.model.StationModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Topic;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplain;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplainCompany;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplainStation;
import com.deilsky.simple.ronetworksimple.mvc.model.User;
import com.deilsky.simple.ronetworksimple.mvc.model.UserModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Version;
import com.deilsky.simple.ronetworksimple.mvc.model.Device;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by 帷幕 on 2017/12/23.
 */

public interface MainService {
    @POST("User/Login")
    Call<RoResult<User>> login(@Body UserModel userModel);

    @GET("User/GetUser")
    Call<RoResult<User>> GetUser(@Query("id") int id);

    @GET("User/UpdateUserDeviceId")
    Call<RoResult<String>> UpdateUserDeviceId(@Query("userId") int userId, @Query("deviceId") String deviceId);

    @GET("User/ChangePassword")
    Call<RoResult<String>> ChangePassword(@Query("userId") int userId, @Query("password") String passWord);


    @GET("User/GetComplainList")
    Call<RoResult<Complain>> GetComplainList(@Query("companyId") String companyId, @Query("stationId") String stationId, @Query("state") int state, @Query("page") int page, @Query("pageSize") int pageSize);

    @GET("User/GetComplain")
    Call<RoResult<Complain>> GetComplain(@Query("id") int id);

    @POST("User/SaveComplain")
    Call<RoResult<String>> SaveComplain(@Body SaveComplain saveComplain);

    @Multipart
    @POST("User/UploadPic")
    Call<RoResult<String>> uploadPic(@Part List<MultipartBody.Part> file);

    @GET("Article/GetTopicList")
    Call<RoResult<Topic>> GetTopicList(@Query("page") int page, @Query("pageSize") int pageSize);

    @GET("Article/GetTopic")
    Call<RoResult<Topic>> GetTopic(@Query("id") int id);

    @GET("User/Getversion")
    Call<RoResult<Version>> Getversion();

    @GET("Article/GetAlertList")
    Call<RoResult<Device>> getDeviceList(@Query("companyId") String cid, @Query("stationId") String sid, @Query("page") int page, @Query("pageSize") int size);

    @GET("Article/GetAlert")
    Call<RoResult<Device>> getDevice(@Query("id") int id);

    @POST("User/UpdateComplain")
    Call<RoResult<String>> UpdateComplain(@Body UpdateComplain updateComplain);

    @POST("User/UpdateComplainCompany")
    Call<RoResult<String>> UpdateComplainCompany(@Body UpdateComplainCompany updateComplainCompany);

    //UpdateComplainStation
    /*@Multipart
    @POST("User/UpdateComplainStation")
    Call<RoResult<String>> UpdateComplainStation(@Part List<MultipartBody.Part> file);*/
    @POST("User/UpdateComplainStation")
    Call<RoResult<String>> UpdateComplainStation(@Body UpdateComplainStation updateComplainStation);

    @GET("User/GetCompanyData")
    Call<RoResult<CompanyModel>> GetCompanyData();

    @GET("User/GetCategoryData")
    Call<RoResult<CategoryModel>> GetCategoryData();

    @GET("User/GetStationData")
    Call<RoResult<StationModel>> GetStationData(@Query("id") int id);

    @POST("Article/InsertAlert")
    Call<RoResult<String>> InsertAlert(@Body Device device);
}
