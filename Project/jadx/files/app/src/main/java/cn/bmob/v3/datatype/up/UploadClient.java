package cn.bmob.v3.datatype.up;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.util.BmobDbOpenHelper;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class UploadClient {
    private OkHttpClient client = new OkHttpClient.Builder().connectTimeout(Bmob.getConnectTimeout(), TimeUnit.SECONDS).readTimeout(UpConfig.READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(UpConfig.WRITE_TIMEOUT, TimeUnit.SECONDS).followRedirects(true).build();

    public String blockMultipartPost(String str, PostData postData) throws BmobException, IOException {
        Map<String, String> map = postData.params;
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            type.addFormDataPart(entry.getKey(), entry.getValue());
        }
        type.addFormDataPart(BmobDbOpenHelper.FILE, URLEncoder.encode(postData.fileName), RequestBody.create((MediaType) null, postData.data));
        Response responseExecute = this.client.newCall(new Request.Builder().addHeader("x-upyun-api-version", "2").url(str).post(type.build()).build()).execute();
        if (responseExecute.isSuccessful()) {
            return responseExecute.body().string();
        }
        throw new BmobException(responseExecute.code(), responseExecute.body().string());
    }

    public Response download(String str) throws BmobException, IOException {
        Response responseExecute = this.client.newCall(new Request.Builder().url(str).build()).execute();
        if (responseExecute.isSuccessful()) {
            return responseExecute;
        }
        throw new BmobException(responseExecute.code(), responseExecute.body().string());
    }

    public String fromUpLoad(File file, String str, String str2, String str3, UpProgressListener upProgressListener) throws BmobException, IOException {
        RequestBody requestBodyBuild = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(BmobDbOpenHelper.FILE, URLEncoder.encode(file.getName()), RequestBody.create((MediaType) null, file)).addFormDataPart("policy", str2).addFormDataPart("signature", str3).build();
        if (upProgressListener != null) {
            requestBodyBuild = ProgressHelper.addProgressListener(requestBodyBuild, upProgressListener);
        }
        Response responseExecute = this.client.newCall(new Request.Builder().addHeader("x-upyun-api-version", "2").url(str).post(requestBodyBuild).build()).execute();
        if (responseExecute.isSuccessful()) {
            return responseExecute.body().string();
        }
        throw new BmobException(responseExecute.code(), responseExecute.body().string());
    }

    public String post(String str, Map<String, String> map) throws BmobException, IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        Response responseExecute = this.client.newCall(new Request.Builder().addHeader("x-upyun-api-version", "2").url(str).post(builder.build()).build()).execute();
        if (responseExecute.isSuccessful()) {
            return responseExecute.body().string();
        }
        throw new BmobException(responseExecute.code(), responseExecute.body().string());
    }
}
