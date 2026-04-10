package me.jessyan.retrofiturlmanager.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DomainUrlParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements e {
    private me.jessyan.retrofiturlmanager.c.a<String, String> a;

    private String b(HttpUrl httpUrl, HttpUrl httpUrl2) {
        return httpUrl.encodedPath() + httpUrl2.encodedPath();
    }

    @Override // me.jessyan.retrofiturlmanager.e.e
    public void a(me.jessyan.retrofiturlmanager.a aVar) {
        this.a = new me.jessyan.retrofiturlmanager.c.b(100);
    }

    @Override // me.jessyan.retrofiturlmanager.e.e
    public HttpUrl a(HttpUrl httpUrl, HttpUrl httpUrl2) {
        if (httpUrl == null) {
            return httpUrl2;
        }
        HttpUrl.Builder builderNewBuilder = httpUrl2.newBuilder();
        if (TextUtils.isEmpty(this.a.get(b(httpUrl, httpUrl2)))) {
            for (int i2 = 0; i2 < httpUrl2.pathSize(); i2++) {
                builderNewBuilder.removePathSegment(0);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(httpUrl.encodedPathSegments());
            arrayList.addAll(httpUrl2.encodedPathSegments());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addEncodedPathSegment((String) it.next());
            }
        } else {
            builderNewBuilder.encodedPath(this.a.get(b(httpUrl, httpUrl2)));
        }
        HttpUrl httpUrlBuild = builderNewBuilder.scheme(httpUrl.scheme()).host(httpUrl.host()).port(httpUrl.port()).build();
        if (TextUtils.isEmpty(this.a.get(b(httpUrl, httpUrl2)))) {
            this.a.put(b(httpUrl, httpUrl2), httpUrlBuild.encodedPath());
        }
        return httpUrlBuild;
    }
}
