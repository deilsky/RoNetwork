package com.deilsky.simple.ronetworksimple.mvc;

import com.deilsky.network.listener.RoResultCallBack;
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

import java.util.ArrayList;

/**
 * Created by 帷幕 on 2017/12/23.
 */

public interface MainContract {
    /**
     * 登录
     */
    void login(UserModel userModel, RoResultCallBack<User> listener);

    /**
     * 获取用户信息
     */
    void getUser(int id, RoResultCallBack<User> listener);

    /**
     * 更新用户的设备id（推送用的）推送SDK 初始化完成后调用
     */
    void updateUserDeviceId(int userId, String deviceId, RoResultCallBack<String> listener);

    /**
     * 修改密码
     */
    void changePassword(int userId, String passWord, RoResultCallBack<String> listener);

    /**
     * 投诉信息列表
     */
    void getComplainList(String companyId, String stationId, int state, int page, int pageSize, RoResultCallBack<Complain> listener);

    /**
     * 投诉信息详细
     */
    void getComplain(int id, RoResultCallBack<Complain> listener);

    /**
     * 保存投诉信息
     */
    void saveComplain(SaveComplain saveComplain, RoResultCallBack<String> listener);

    /**
     * 通知公告列表
     */
    void getTopicList(int page, int pageSize, RoResultCallBack<Topic> listener);

    /**
     * 通知公告内容
     */
    void getTopic(int id, RoResultCallBack<Topic> listener);

    void uploadPic(ArrayList<String> file, RoResultCallBack<String> listener);

    void getVersion(RoResultCallBack<Version> listener);

    void getDeviceList(String cid, String sid, int page, int pageSize, RoResultCallBack<Device> listener);

    void getDevice(int id, RoResultCallBack<Device> listener);

    void updateComplain(UpdateComplain updateComplain, RoResultCallBack<String> listener);

    void updateComplainCompany(UpdateComplainCompany updateComplainCompany, RoResultCallBack<String> listener);

    void updateComplainStation(UpdateComplainStation data, RoResultCallBack<String> listener);

    void getCompanyData(RoResultCallBack<CompanyModel> listener);

    void getCategoryData(RoResultCallBack<CategoryModel> listener);

    void getStationData(int id, RoResultCallBack<StationModel> listener);

    void insertAlert(Device device, RoResultCallBack<String> listener);
}
