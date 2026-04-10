package com.amgcyo.cuttadon.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.amgcyo.cuttadon.utils.otherutils.v0;
import com.taobao.accs.common.Constants;
import com.umeng.message.utils.HttpRequest;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: MkApiInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements Interceptor {
    private static final String a = com.amgcyo.cuttadon.utils.otherutils.g.q();

    static {
        String str = "静态代码块sha1：" + a;
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        String strA;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        if (TextUtils.isEmpty(a)) {
            strA = "";
        } else {
            strA = com.open.hule.library.c.b.a(a + jCurrentTimeMillis);
        }
        String strA0 = com.amgcyo.cuttadon.utils.otherutils.g.a0();
        String strC0 = com.amgcyo.cuttadon.utils.otherutils.g.c0();
        if (!TextUtils.isEmpty(strA0) && !TextUtils.isEmpty(strC0)) {
            builderNewBuilder.addHeader(BmobDbOpenHelper.USER, strA0);
            builderNewBuilder.addHeader("token", strC0);
        }
        String strT = com.amgcyo.cuttadon.utils.otherutils.h.t();
        CacheControl.Builder builder = new CacheControl.Builder();
        builder.noCache();
        builder.noStore();
        return chain.proceed(builderNewBuilder.addHeader("Content-Type", "text/html; charset=UTF-8").addHeader("Connection", com.anythink.expressad.foundation.d.c.cf).addHeader(HttpRequest.HEADER_ACCEPT, "*/*").addHeader("Access-Control-Allow-Origin", "*").addHeader("Access-Control-Allow-Headers", "X-Requested-With").addHeader("Vary", "Accept-Encoding").addHeader("User-Agent", v0.a() + "_" + strT).addHeader("pt", "1").addHeader("version", "5.0.2").addHeader("channel", com.amgcyo.cuttadon.utils.otherutils.g.T()).addHeader("xf-appid", com.amgcyo.cuttadon.utils.otherutils.g.d()).addHeader("fc-session-id", "").addHeader(Constants.KEY_PACKAGE, strT).addHeader("stamp", strA).addHeader("time", String.valueOf(jCurrentTimeMillis)).addHeader("sign", me.jessyan.retrofiturlmanager.a.a(jCurrentTimeMillis, strC0, strT)).cacheControl(builder.build()).build());
    }
}
