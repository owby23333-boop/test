package cn.bmob.v3.http.interceptor;

import android.text.TextUtils;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RequestUtils;
import cn.bmob.v3.http.bean.Api;
import cn.bmob.v3.http.bean.Result;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.EncryptUtils;
import cn.bmob.v3.util.HtmlUtils;
import cn.bmob.v3.util.ZipUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes.dex */
public class ResponseInterceptor implements Interceptor {
    public static boolean validate(String str) {
        try {
            JsonElement jsonElement = new JsonParser().parse(str);
            return jsonElement != null && jsonElement.isJsonObject();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String strDecryDataWithSecretKey;
        Request request = chain.request();
        String url = request.url().getUrl();
        Response responseProceed = chain.proceed(request);
        String realString = ZipUtil.getRealString(responseProceed.body().bytes());
        BLog.i("before enc:" + realString);
        if (TextUtils.isEmpty(realString)) {
            Api api = new Api();
            Result result = new Result();
            result.setCode(ErrorCode.E9016);
            result.setMessage("The response content is null or empty.");
            api.setResult(result);
            realString = new Gson().toJson(api, Api.class);
        } else if (validate(realString)) {
            BLog.i("JSON DATA:" + realString);
        } else if (TextUtils.isEmpty(HtmlUtils.getTitle(realString))) {
            try {
                if (url.contains("/secret")) {
                    BmobURL.getDefault().getClass();
                    String strHeader = responseProceed.header("Response-Id", "");
                    if (TextUtils.isEmpty(strHeader)) {
                        BLog.e(BmobConstants.TAG, "responseId is null");
                        Api api2 = new Api();
                        Result result2 = new Result();
                        result2.setCode(-1);
                        result2.setMessage(realString);
                        api2.setResult(result2);
                        strDecryDataWithSecretKey = new Gson().toJson(api2, Api.class);
                    } else {
                        strDecryDataWithSecretKey = RequestUtils.decrySecretDataWithKey2(strHeader, realString);
                        if (TextUtils.isEmpty(strDecryDataWithSecretKey)) {
                            BLog.e(strHeader);
                            String strSubstring = strHeader.substring(strHeader.length() - 16);
                            strDecryDataWithSecretKey = EncryptUtils.decrypt(strSubstring, strSubstring, realString);
                            BLog.e("Java Secret API Response :" + strDecryDataWithSecretKey);
                        }
                    }
                } else {
                    BLog.e(BmobNative.SECRET_KEY);
                    strDecryDataWithSecretKey = RequestUtils.decryDataWithSecretKey(realString);
                    if (TextUtils.isEmpty(strDecryDataWithSecretKey)) {
                        String strSubstring2 = BmobNative.SECRET_KEY.substring(BmobNative.SECRET_KEY.length() - 16);
                        strDecryDataWithSecretKey = EncryptUtils.decrypt(strSubstring2, strSubstring2, realString);
                        BLog.e("Java Other API Response :" + strDecryDataWithSecretKey);
                    }
                }
                BLog.i("Secret Decrypt DATA:" + strDecryDataWithSecretKey);
                realString = strDecryDataWithSecretKey;
            } catch (Exception unused) {
                BLog.i("Decrypt Exception, Encrypt DATA:" + realString);
            }
        } else {
            Api api3 = new Api();
            Result result3 = new Result();
            result3.setMessage(realString);
            api3.setResult(result3);
            realString = new Gson().toJson(api3, Api.class);
            BLog.i("HTML DATA:" + realString);
        }
        return responseProceed.newBuilder().body(ResponseBody.create(BmobClient.MEDIA_TYPE, realString)).build();
    }
}
