package com.amgcyo.cuttadon.app;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.utils.otherutils.r;
import java.io.IOException;
import me.jessyan.art.base.convert.ApiException;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.http.log.RequestInterceptor;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GlobalHttpHandlerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements me.jessyan.art.c.b {
    public l(Context context) {
    }

    @Override // me.jessyan.art.c.b
    @NonNull
    public Request a(@NonNull Interceptor.Chain chain, @NonNull Request request) {
        return request;
    }

    @Override // me.jessyan.art.c.b
    @NonNull
    public Response a(@Nullable String str, @NonNull Interceptor.Chain chain, @NonNull Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Request request = chain.request();
        Headers headers = request.headers();
        if (headers.size() > 0) {
            String str2 = headers.get("xf-appid");
            if (TextUtils.isEmpty(headers.get("volley-branches-tags")) && !TextUtils.isEmpty(str2) && "11000011".equals(str2)) {
                if (responseBodyBody != null) {
                    responseBodyBody.close();
                }
                throw new ApiException(634, "您当前使用的版本已经停用，请访问App官网下载最新版本。");
            }
        }
        if (TextUtils.isEmpty(str) || responseBodyBody == null || !RequestInterceptor.c(responseBodyBody.get$contentType())) {
            return response;
        }
        BaseModel baseModel = (BaseModel) r.a(str, BaseModel.class);
        if (baseModel.getCode() == com.amgcyo.cuttadon.f.n.f3695i) {
            return response;
        }
        responseBodyBody.close();
        throw new ApiException(baseModel.getCode(), request.url().getUrl(), baseModel.getMsg());
    }
}
