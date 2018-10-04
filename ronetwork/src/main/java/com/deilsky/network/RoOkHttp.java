package com.deilsky.network;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/**
 * Created by 帷幕 on 2017/10/9.
 */
public enum RoOkHttp {
    INSTANCE;
    OkHttpClient instance;

    public OkHttpClient getInstance() {
        return instance;
    }

    RoOkHttp() {
        OkHttpClient.Builder build = new OkHttpClient.Builder();

        build.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (RoContract.PRINT) {
                    HttpUrl url = request.url();
                    String method = request.method();
                    @SuppressLint("DefaultLocale")
                    String info = String.format(RoContract.BASE, url, url.port(), method, response.isSuccessful(), response.code());
                    Log.d(RoContract.TAG, info);
                    if (TextUtils.equals("GET", method)) {
                        Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, "paramer.size", String.valueOf(url.querySize())));
                        Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, "name", "value"));
                        Set<String> set = url.queryParameterNames();
                        for (String name : set) {
                            String value = TextUtils.isEmpty(url.queryParameter(name)) ? "" : url.queryParameter(name);
                            Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, name, value));
                        }
                        Log.d(RoContract.TAG, RoContract.END);
                    } else if (TextUtils.equals("POST", method)) {
                        RequestBody requestBody = request.body();
                        Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, "contentType", requestBody.contentType()));
                        if (requestBody instanceof FormBody) {
                            FormBody body = (FormBody) requestBody;
                            int size = body.size();
                            Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, "paramer.size", String.valueOf(size)));
                            for (int i = 0; i < size; i++) {
                                String name = body.encodedName(i);
                                String value = TextUtils.isEmpty(body.encodedValue(i)) ? "" : body.encodedValue(i);
                                Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, name, value));
                            }
                        } else if (!(requestBody instanceof MultipartBody)) {
                            requestBody.writeTo(sink);
                        }
                        Log.d(RoContract.TAG, RoContract.END);
                    }
                }
                return response;
            }
        });
        this.instance = build.build();
    }

    private BufferedSink sink = new BufferedSink() {
        @Override
        public int write(ByteBuffer src) throws IOException {
            return 0;
        }

        @Override
        public Buffer buffer() {
            return null;
        }

        @Override
        public BufferedSink write(ByteString byteString) throws IOException {
            if (byteString != null && !TextUtils.isEmpty(byteString.utf8())) {
                String str = byteString.utf8();
                HashMap map = new Gson().fromJson(str, HashMap.class);
                if (map != null && !map.isEmpty()) {
                    Set set = map.keySet();
                    for (Object aSet : set) {
                        String key = (String) aSet;
                        String value = String.valueOf(map.get(key));
                        Log.d(RoContract.TAG, String.format(RoContract.PARAMTER, key, value));
                    }
                }
            }
            return null;
        }

        @Override
        public BufferedSink write(byte[] source) throws IOException {
            return null;
        }

        @Override
        public BufferedSink write(byte[] source, int offset, int byteCount) throws IOException {
            return null;
        }

        @Override
        public long writeAll(Source source) throws IOException {
            return 0;
        }

        @Override
        public BufferedSink write(Source source, long byteCount) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeUtf8(String string) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeUtf8(String string, int beginIndex, int endIndex) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeUtf8CodePoint(int codePoint) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeString(String string, Charset charset) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeString(String string, int beginIndex, int endIndex, Charset charset) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeByte(int b) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeShort(int s) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeShortLe(int s) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeInt(int i) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeIntLe(int i) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeLong(long v) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeLongLe(long v) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeDecimalLong(long v) throws IOException {
            return null;
        }

        @Override
        public BufferedSink writeHexadecimalUnsignedLong(long v) throws IOException {
            return null;
        }

        @Override
        public void flush() throws IOException {

        }

        @Override
        public BufferedSink emit() throws IOException {
            return null;
        }

        @Override
        public BufferedSink emitCompleteSegments() throws IOException {
            return null;
        }

        @Override
        public OutputStream outputStream() {
            return null;
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {

        }

        @Override
        public Timeout timeout() {
            return null;
        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public void close() throws IOException {

        }
    };
}
