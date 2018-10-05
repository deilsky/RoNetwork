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

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar1, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        findViewById(R.id.get1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TestApi.create().banners(new RoResultListener<RoResult<ArrayList<Banner>>>() {
                    @Override
                    public void onSuccess(RoResult<ArrayList<Banner>> result) {
                        Log.d("TAG:", "无RxJava方式");
                        if (200 == result.getStatus()) {
                            for (Banner banner : result.getData()) {
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
        findViewById(R.id.get2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestApi.create().rxDisposableBanners(new Consumer<RoResult<ArrayList<Banner>>>() {
                    @Override
                    public void accept(RoResult<ArrayList<Banner>> bannerRoResult) throws Exception {
                        Log.d("rxDisposableBanners", "accept");
                    }
                });
            }
        });
        findViewById(R.id.get3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestApi.create().rxObservableBanners(new Observer<RoResult<ArrayList<Banner>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("rxObservableBanners", "onSubscribe");
                    }

                    @Override
                    public void onNext(RoResult<ArrayList<Banner>> bannerRoResult) {
                        Log.d("rxObservableBanners", "onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("rxObservableBanners", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("rxObservableBanners", "onComplete");
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
                paths.add("/storage/emulated/0/程序/text.zip");
                paths.add("/storage/emulated/0/程序/text2.zip");
                //无上传进度
                /*UploadApi.create().upload(paths, new RoResultListener<RoResult<String>>() {

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
                */
                UploadApi.create().upload(paths, new Observer<RoResult<ArrayList<String>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("upload", "onSubscribe");
                    }

                    @Override
                    public void onNext(RoResult<ArrayList<String>> stringRoResult) {
                        Log.d("upload", "onNext");
                        if (200 == stringRoResult.getStatus()) {
                            for (String s : stringRoResult.getData()) {
                                Log.d("upload-onNext", s);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("upload", "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("upload", "onComplete");
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
                UploadApi.create().upload(paths, new RoProgressUpLoadListener<RoResult<ArrayList<String>>>() {

                    @Override
                    public void onProgress(long progress, long size, boolean hasFinish) {
                        showProgress(progress, size, hasFinish);
                    }

                    @Override
                    public void onSuccess(RoResult<ArrayList<String>> result) {
                        Log.d("result:", result.toString());
                        if (200 == result.getStatus()) {
                            for (Object s : result.getData()) {
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
                /*
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
                        */
                DownLoadApi.create().download("resources/text.zip", new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("download", "onSubscribe");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Log.d("download", "onNext");
                        download(responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("download", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("download", "onComplete");
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
