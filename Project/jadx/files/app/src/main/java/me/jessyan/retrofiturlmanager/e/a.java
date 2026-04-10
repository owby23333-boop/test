package me.jessyan.retrofiturlmanager.e;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AdvancedUrlParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements e {
    private me.jessyan.retrofiturlmanager.a a;
    private me.jessyan.retrofiturlmanager.c.a<String, String> b;

    private String b(HttpUrl httpUrl, HttpUrl httpUrl2) {
        return httpUrl.encodedPath() + httpUrl2.encodedPath() + this.a.c();
    }

    @Override // me.jessyan.retrofiturlmanager.e.e
    public void a(me.jessyan.retrofiturlmanager.a aVar) {
        this.a = aVar;
        this.b = new me.jessyan.retrofiturlmanager.c.b(100);
    }

    @Override // me.jessyan.retrofiturlmanager.e.e
    public HttpUrl a(HttpUrl httpUrl, HttpUrl httpUrl2) {
        if (httpUrl == null) {
            return httpUrl2;
        }
        HttpUrl.Builder builderNewBuilder = httpUrl2.newBuilder();
        if (TextUtils.isEmpty(this.b.get(b(httpUrl, httpUrl2)))) {
            for (int i2 = 0; i2 < httpUrl2.pathSize(); i2++) {
                builderNewBuilder.removePathSegment(0);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(httpUrl.encodedPathSegments());
            if (httpUrl2.pathSize() > this.a.c()) {
                List<String> listEncodedPathSegments = httpUrl2.encodedPathSegments();
                for (int iC = this.a.c(); iC < listEncodedPathSegments.size(); iC++) {
                    arrayList.add(listEncodedPathSegments.get(iC));
                }
            } else if (httpUrl2.pathSize() < this.a.c()) {
                throw new IllegalArgumentException(String.format("Your final path is %s, but the baseUrl of your RetrofitUrlManager#startAdvancedModel is %s", httpUrl2.scheme() + HttpConstant.SCHEME_SPLIT + httpUrl2.host() + httpUrl2.encodedPath(), this.a.a().scheme() + HttpConstant.SCHEME_SPLIT + this.a.a().host() + this.a.a().encodedPath()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addEncodedPathSegment((String) it.next());
            }
        } else {
            builderNewBuilder.encodedPath(this.b.get(b(httpUrl, httpUrl2)));
        }
        HttpUrl httpUrlBuild = builderNewBuilder.scheme(httpUrl.scheme()).host(httpUrl.host()).port(httpUrl.port()).build();
        if (TextUtils.isEmpty(this.b.get(b(httpUrl, httpUrl2)))) {
            this.b.put(b(httpUrl, httpUrl2), httpUrlBuild.encodedPath());
        }
        return httpUrlBuild;
    }
}
