package cn.bmob.v3.http.interceptor;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.helper.RequestHelper;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RequestUtils;
import cn.bmob.v3.util.BLog;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().getUrl();
        BLog.i("url:" + url);
        String userAgent = RequestHelper.getUserAgent(Bmob.getApplicationContext());
        JSONObject jSONObjectCreateParams = BmobClient.createParams(Bmob.getApplicationContext(), new JSONObject(), url);
        BLog.i("obj:" + jSONObjectCreateParams);
        Request.Builder builderPost = request.newBuilder().header("Content-Type", "text/plain; charset=utf-8").header("Accept-Encoding", "gzip,deflate,sdch").header("User-Agent", userAgent).post(RequestBody.create(BmobClient.MEDIA_TYPE, url.equals(BmobURL.getDefault().getSecretUrl()) ? RequestUtils.encrySecretDataWithKey1(userAgent, jSONObjectCreateParams.toString()) : RequestUtils.encryDataWithSecretKey(jSONObjectCreateParams.toString())));
        if (!url.equals(BmobURL.getDefault().getSecretUrl())) {
            builderPost.addHeader("Accept-Id", RequestUtils.getAcceptId());
        }
        Request requestBuild = builderPost.build();
        BLog.i("请求头:" + requestBuild.headers().toString());
        return chain.proceed(requestBuild);
    }
}
