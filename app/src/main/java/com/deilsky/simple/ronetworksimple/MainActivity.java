package com.deilsky.simple.ronetworksimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.deilsky.network.RoDownLoad;
import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoProgressDownLoadListener;
import com.deilsky.network.listener.RoProgressUpLoadListener;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.login.TestApi;
import com.deilsky.simple.ronetworksimple.mvc.model.Banner;
import com.deilsky.simple.ronetworksimple.mvc.model.Users;
import com.deilsky.simple.ronetworksimple.mvc.net.DownLoadApi;
import com.deilsky.simple.ronetworksimple.mvc.net.UploadApi;

import java.util.ArrayList;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar1, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TestApi.create().banners(new RoResultListener<RoResult<Banner>>() {
                    @Override
                    public void onSuccess(RoResult<Banner> result) {
                        if (200 == result.getStatus()) {
                            for (Banner banner : result.getList()) {
                                Log.d("banners:", banner.getPath());
                            }
                        }
                    }

                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onError(String msg) {
                        alert(msg);
                    }
                });
            }
        });

        findViewById(R.id.post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users model = new Users();
                model.setPhone("17XXXXXXXX1");
                model.setPassWord("123456");
                TestApi.create().login(model, new RoResultListener<RoResult<Users>>() {
                    @Override
                    public void onSuccess(RoResult<Users> result) {
                        if (200 == result.getStatus()) {
                            Log.d("post", result.getMsg() + "");
                            alert(result.getMsg() + "");
                        }
                    }

                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onError(String msg) {
                        Log.e("onError", msg);
                    }
                });
            }
        });

        findViewById(R.id.upload1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> paths = new ArrayList<String>();
                paths.add("/storage/emulated/0/程序/Cclocation.zip");
                paths.add("/storage/emulated/0/snapshot/20170724120021495.jpeg");
                //无上传进度
                UploadApi.create().upload(paths, new RoResultListener<RoResult<String>>() {

                    @Override
                    public void onSuccess(RoResult<String> result) {
                        Log.d("result:", result.toString());
                        if (200 == result.getStatus()) {
                            for (String s : result.getList()) {
                                Log.d("path:", s + "");
                            }
                        }
                    }

                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onError(String msg) {
                        Log.e("onError", msg);
                    }
                });

            }
        });
        findViewById(R.id.upload2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 有上传进度
                ArrayList<String> paths = new ArrayList<String>();
                paths.add("/storage/emulated/0/程序/text.zip");
                paths.add("/storage/emulated/0/程序/text2.zip");
                UploadApi.create().upload(paths, new RoProgressUpLoadListener<RoResult<String>>() {

                    @Override
                    public void onProgress(long progress, long size, boolean hasFinish) {
                        showProgress(progress, size, hasFinish);
                    }

                    @Override
                    public void onSuccess(RoResult<String> result) {
                        Log.d("result:", result.toString());
                        if (200 == result.getStatus()) {
                            for (Object s : result.getList()) {
                                Log.d("path:", s + "");
                            }
                        }
                    }

                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onError(String msg) {
                        Log.e("onError", msg);
                    }
                });
            }
        });
        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownLoadApi.create().download("resources/text.zip",
                        new RoResultListener<ResponseBody>() {

                            @Override
                            public void onSuccess(ResponseBody result) {
                                Log.d("download", result.toString());
                                    download(result);
                            }

                            @Override
                            public void onLoading() {

                            }

                            @Override
                            public void onError(String msg) {
                                Log.e("download--onError:", msg);
                            }
                        });
            }


        });

    }

    private void download(final ResponseBody data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoDownLoad.writeResponseBodyToDisk(MainActivity.this, data, null, new RoProgressDownLoadListener() {
                    @Override
                    public void onFinashed(String path) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onProgress(long progress, long size) {
                        downloadProgress(progress, size);
                    }

                    @Override
                    public void onReady(long max) {
                    }
                });
            }
        }).start();

    }


    private void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void showProgress(long progress, long total, final boolean done) {
        final int p = Integer.parseInt(String.format("%1d", (progress * 100 / total)));
        //Log.d("showProgress", "progress:" + progress + "," + total + "," + p);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar1.setProgress(p);
            }
        });
    }

    private void downloadProgress(long progress, long total) {
        final int p = Integer.parseInt(String.format("%1d", (progress * 100 / total)));
        Log.d("showProgress", "progress:" + progress + "," + total + "," + p);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar2.setProgress(p);
            }
        });
    }
}
