RoNetwork 基于 retrofit 2, okhttp 3, gson实现的网络请求框架。

```
框架主要功能如下
1.Get请求 如http://baidu.com?key=1,同时支持REST请求 如http://baidu.com/1
2.Post请求
3.文件上传/下载 以及进度监听
4.实时打印日志，请求参数等
```
# How to
## To get a Git project into your build:
### Step 1. Add the JitPack repository to your build file
#### Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2. Add the dependency
```
dependencies {
   compile 'com.github.deilsky:RoNetwork:v1.0'
}
```
### Step 3. Used
#### Step 3.1 Application 设置
```
public class App extends Application {
  ………
  @Override
  public void onCreate() {
    super.onCreate();
    Contract contract = Contract.create()
        .service("http://192.168.1.21:8021/api/")//url前缀
        .sources("http://192.168.1.21:8021/")//资源前缀或备用url
        .print(true);//是否打印日志
        RoContract.create(contract);
  }
}
```
#### Step 3.2. 普通get/post请求
```
service
public interface LoginService {
    @POST("post")
    Call<RoResult<Integer>> post(@Body LoginModel loginModel);
    @POST("get")
    Call<RoResult<String>> get();
}
接口定义
public interface LoginContract {
    void post(LoginModel loginModel, RoResultListener<Integer> listener);
    void get(RoResultListener<String> listener);
}
具体请求
public class LoginApi implements LoginContract {
    private LoginService service = null;
    static LoginApi instance;

    private LoginApi() {
        service = RoRetrofit.getInstance().create(LoginService.class);
    }

    public static LoginApi create() {
        instance = new LoginApi();
        return instance;
    }

    @Override
    public void post(LoginModel loginModel, final RoResultListener<Integer> listener) {
        Call<RoResult<Integer>> call = service.post(loginModel);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Integer>>() {
            @Override
            public void onResponse(Call<RoResult<Integer>> call, Response<RoResult<Integer>> response) {
                new RoResponse<Integer>().formatter(response, listener);
            }
            @Override
            public void onFailure(Call<RoResult<Integer>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
    @Override
    public void get(final RoResultListener<String> listener) {
        Call<RoResult<String>> call = service.get();
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
}
调用get
LoginApi.create().get(new RoResultListener<String>() {
    @Override
    public void onSuccess(RoResult<String> result) {
        if (200 == result.getStatus()) {
            Log.d("GET", result.getData());
        }
    }
    @Override
    public void onLoading() {}
    @Override
    public void onError(String msg) {
        Log.e("onError", msg);
    }
});
调用post
LoginModel model = new LoginModel();
model.setUserName("admin");
model.setPassWord("123456");
LoginApi.create().post(model, new RoResultListener<Integer>() {
    @Override
    public void onSuccess(RoResult<Integer> result) {
        if (200 == result.getStatus()) {
            Log.d("post", result.getData()+"");
        }
    }
    @Override
    public void onLoading() {}
    @Override
    public void onError(String msg) {
        Log.e("onError", msg);
    }
});
文件上传/下载以及进度监听
service
public interface NetContract {
    interface UploadContract {
        void upload(ArrayList<String> paths, RoUpLoadProgressListener<String> listener);
        void upload(ArrayList<String> paths, RoResultListener<String> listener);
    }
    interface DownLoadContract {
        void download(String path, RoResultListener<ResponseBody> listener);
    }
}
接口定义
public interface NetService {
    @Multipart
    @POST("upload")
    Call<RoResult<String>> upload(@Part List<MultipartBody.Part> file);
    @GET
    Call<RoResult<ResponseBody>> download(@Url String path);
}
上传实现
public class UploadApi implements NetContract.UploadContract {
    private NetService service = null;
    public static UploadApi instance;
    private UploadApi() {
        service = RoRetrofit.getInstance().create(NetService.class);
    }

    public static UploadApi create() {
        instance = new UploadApi();
        return instance;
    }
    @Override
    public void upload(ArrayList<String> paths, final RoUpLoadProgressListener<String> listener) {
        MultipartBody.Builder build = new MultipartBody.Builder();
        build.setType(MultipartBody.FORM);
        for (String path : paths) {
            File file = new File(path);
            RequestBody body = new RoRequestBody(RequestBody.create(MediaType.parse("application/zip"),file),listener);
            build.addFormDataPart("upload", file.getPath(), body);
            build.build();
        }
        Call<RoResult<String>> call = service.upload(build.build().parts());
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response,listener);
            }
            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                    listener.onError(stackTraceElement.toString());
                }
            }
        });
    }

    @Override
    public void upload(ArrayList<String> paths, final RoResultListener<String> listener) {
        MultipartBody.Builder build = new MultipartBody.Builder();
        build.setType(MultipartBody.FORM);
        for (String path : paths) {
            File file = new File(path);
            build.addFormDataPart("upload", file.getPath(), RequestBody.create(MediaType.parse("application/zip"),file));
            build.build();
        }
        Call<RoResult<String>> call = service.upload(build.build().parts());
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response,listener);
            }
            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                    listener.onError(stackTraceElement.toString());
                }
            }
        });
    }
}
下载实现
public class DownLoadApi implements NetContract.DownLoadContract {
    private NetService service = null;
    public static DownLoadApi instance;
    private DownLoadApi() {
        service = RoRetrofit.getOtherInstance().create(NetService.class);
    }
    public static DownLoadApi create() {
        instance = new DownLoadApi();
        return instance;
    }

    @Override
    public void download(String path, final RoResultListener<ResponseBody> listener) {
        Call<RoResult<ResponseBody>> call = service.download(path);
        call.enqueue(new Callback<RoResult<ResponseBody>>() {
            @Override
            public void onResponse(Call<RoResult<ResponseBody>> call, Response<RoResult<ResponseBody>> response) {
                new RoResponse<ResponseBody>().formatter(response, listener);
            }
            @Override
            public void onFailure(Call<RoResult<ResponseBody>> call, Throwable t) {
                for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                    listener.onError(stackTraceElement.toString());
                }
            }
        });
    }
}
具体调用
//上传文件，无进度
ArrayList<String> paths = new ArrayList<String>();
paths.add("/storage/emulated/0/XX/Cclocation.zip");
paths.add("/storage/emulated/0/snapshot/20170724120021495.jpeg");
UploadApi.create().upload(paths, new RoResultListener<String>() {
    @Override
    public void onSuccess(RoResult<String> result) {
        Log.d("result:",result.toString());
        if (200 == result.getStatus()) {
            for (String s : result.getList()) {
                Log.d("path:", s+"");
            }
        }
    }
    @Override
    public void onLoading() {}
    @Override
    public void onError(String msg) {
        Log.e("onError",msg);
    }
});
//上传文件，有进度
ArrayList<String> paths = new ArrayList<String>();
paths.add("/storage/emulated/0/程序/Cclocation.zip");
paths.add("/storage/emulated/0/snapshot/20170724120021495.jpeg");
UploadApi.create().upload(paths, new RoUpLoadProgressListener<String>() {

    @Override
    public void onProgress(long progress, long size, boolean hasFinish) {
        showProgress(progress, size, hasFinish);
    }

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
    public void onLoading() {}
    @Override
    public void onError(String msg) {
        Log.e("onError", msg);
    }
});
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
//下载文件
DownLoadApi.create().download("resources/upload/header/e9c8c3f0/7b12/4750/8681/8794badc9407/20171129105444823.zip",
        new RoResultListener<ResponseBody>() {
            @Override
            public void onSuccess(RoResult<ResponseBody> result) {
                Log.d("download", result.toString());
                if (result.getStatus() == 200) {
                    download(result.getData());
                }
            }
            @Override
            public void onLoading() {}
            @Override
            public void onError(String msg) {
                Log.e("download--onError:", msg);
            }
        });
private void download(final ResponseBody data) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            RoDownLoad.writeResponseBodyToDisk(MainActivity.this, data, null, new RoDownLoadProgressListener() {
                @Override
                public void onFinashed(String path) {
                }
                @Override
                public void onError() {}
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
private void downloadProgress(long progress, long total) {
    final int p = Integer.parseInt(String.format("%1d", (progress * 100 / total)));
    //Log.d("showProgress", "progress:" + progress + "," + total + "," + p);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            progressBar2.setProgress(p);
        }
    });
}
```
[![](https://jitpack.io/v/deilsky/RoNetwork.svg)](https://jitpack.io/#deilsky/RoNetwork)
#### 欢迎留言~
