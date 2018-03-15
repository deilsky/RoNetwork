package com.deilsky.simple.ronetworksimple.mvc;

import com.deilsky.network.RoResponse;
import com.deilsky.network.RoResult;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoResultCallBack;
import com.deilsky.simple.ronetworksimple.mvc.model.CategoryModel;
import com.deilsky.simple.ronetworksimple.mvc.model.CompanyModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Complain;
import com.deilsky.simple.ronetworksimple.mvc.model.Device;
import com.deilsky.simple.ronetworksimple.mvc.model.SaveComplain;
import com.deilsky.simple.ronetworksimple.mvc.model.StationModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Topic;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplain;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplainCompany;
import com.deilsky.simple.ronetworksimple.mvc.model.UpdateComplainStation;
import com.deilsky.simple.ronetworksimple.mvc.model.User;
import com.deilsky.simple.ronetworksimple.mvc.model.UserModel;
import com.deilsky.simple.ronetworksimple.mvc.model.Version;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 帷幕 on 2017/12/23.
 */

public class MainApi implements MainContract {

    private MainService service = null;
    private static MainApi instance;

    private MainApi() {
        service = RoRetrofit.getInstance().create(MainService.class);
    }

    public static MainApi create() {
        instance = new MainApi();
        return instance;
    }

    @Override
    public void login(UserModel userModel, final RoResultCallBack<User> listener) {
        Call<RoResult<User>> call = service.login(userModel);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<User>>() {
            @Override
            public void onResponse(Call<RoResult<User>> call, Response<RoResult<User>> response) {
                new RoResponse<User>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<User>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });

    }

    @Override
    public void getUser(int id, final RoResultCallBack<User> listener) {
        Call<RoResult<User>> call = service.GetUser(id);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<User>>() {
            @Override
            public void onResponse(Call<RoResult<User>> call, Response<RoResult<User>> response) {
                new RoResponse<User>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<User>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void updateUserDeviceId(int userId, String deviceId, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.UpdateUserDeviceId(userId, deviceId);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void changePassword(int userId, String passWord, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.ChangePassword(userId, passWord);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getComplainList(String companyId, String stationId, int state, int page, int pageSize, final RoResultCallBack<Complain> listener) {
        Call<RoResult<Complain>> call = service.GetComplainList(companyId, stationId, state, page, pageSize);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Complain>>() {
            @Override
            public void onResponse(Call<RoResult<Complain>> call, Response<RoResult<Complain>> response) {
                new RoResponse<Complain>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Complain>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getComplain(int id, final RoResultCallBack<Complain> listener) {
        Call<RoResult<Complain>> call = service.GetComplain(id);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Complain>>() {
            @Override
            public void onResponse(Call<RoResult<Complain>> call, Response<RoResult<Complain>> response) {
                new RoResponse<Complain>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Complain>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void saveComplain(SaveComplain saveComplain, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.SaveComplain(saveComplain);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getTopicList(int page, int pageSize, final RoResultCallBack<Topic> listener) {
        Call<RoResult<Topic>> call = service.GetTopicList(page, pageSize);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Topic>>() {
            @Override
            public void onResponse(Call<RoResult<Topic>> call, Response<RoResult<Topic>> response) {
                new RoResponse<Topic>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Topic>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getTopic(int id, final RoResultCallBack<Topic> listener) {
        Call<RoResult<Topic>> call = service.GetTopic(id);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Topic>>() {
            @Override
            public void onResponse(Call<RoResult<Topic>> call, Response<RoResult<Topic>> response) {
                new RoResponse<Topic>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Topic>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void uploadPic(ArrayList<String> pics, final RoResultCallBack<String> listener) {
        MultipartBody.Builder build = new MultipartBody.Builder();
        for (String path : pics) {
            File file = new File(path);
            if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
                build.addFormDataPart("image", file.getPath(), RequestBody.create(MediaType.parse("image/jpeg"), file)).build();
            } else if (path.endsWith(".png") || path.endsWith(".png")) {
                build.addFormDataPart("image", file.getPath(), RequestBody.create(MediaType.parse("image/png"), file)).build();
            }
        }
        Call<RoResult<String>> call = service.uploadPic(build.build().parts());
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getVersion(final RoResultCallBack<Version> listener) {
        Call<RoResult<Version>> call = service.Getversion();
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Version>>() {
            @Override
            public void onResponse(Call<RoResult<Version>> call, Response<RoResult<Version>> response) {
                new RoResponse<Version>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Version>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getDeviceList(String cid, String sid, int page, int pageSize, final RoResultCallBack<Device> listener) {
        Call<RoResult<Device>> call = service.getDeviceList(cid, sid, page, pageSize);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Device>>() {
            @Override
            public void onResponse(Call<RoResult<Device>> call, Response<RoResult<Device>> response) {
                new RoResponse<Device>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Device>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getDevice(int id, final RoResultCallBack<Device> listener) {
        Call<RoResult<Device>> call = service.getDevice(id);
        call.enqueue(new Callback<RoResult<Device>>() {
            @Override
            public void onResponse(Call<RoResult<Device>> call, Response<RoResult<Device>> response) {
                new RoResponse<Device>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Device>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void updateComplain(UpdateComplain updateComplain, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.UpdateComplain(updateComplain);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void updateComplainCompany(UpdateComplainCompany updateComplainCompany, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.UpdateComplainCompany(updateComplainCompany);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void updateComplainStation(UpdateComplainStation data, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.UpdateComplainStation(data);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getCompanyData(final RoResultCallBack<CompanyModel> listener) {
        Call<RoResult<CompanyModel>> call = service.GetCompanyData();
        listener.onLoading();
        call.enqueue(new Callback<RoResult<CompanyModel>>() {
            @Override
            public void onResponse(Call<RoResult<CompanyModel>> call, Response<RoResult<CompanyModel>> response) {
                new RoResponse<CompanyModel>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<CompanyModel>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getCategoryData(final RoResultCallBack<CategoryModel> listener) {
        Call<RoResult<CategoryModel>> call = service.GetCategoryData();
        listener.onLoading();
        call.enqueue(new Callback<RoResult<CategoryModel>>() {
            @Override
            public void onResponse(Call<RoResult<CategoryModel>> call, Response<RoResult<CategoryModel>> response) {
                new RoResponse<CategoryModel>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<CategoryModel>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getStationData(int id, final RoResultCallBack<StationModel> listener) {
        Call<RoResult<StationModel>> call = service.GetStationData(id);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<StationModel>>() {
            @Override
            public void onResponse(Call<RoResult<StationModel>> call, Response<RoResult<StationModel>> response) {
                new RoResponse<StationModel>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<StationModel>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void insertAlert(Device device, final RoResultCallBack<String> listener) {
        Call<RoResult<String>> call = service.InsertAlert(device);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable throwable) {
                listener.onError(throwable.getMessage());
            }
        });
    }
}
