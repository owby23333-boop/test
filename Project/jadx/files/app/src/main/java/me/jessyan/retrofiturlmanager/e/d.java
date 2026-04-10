package me.jessyan.retrofiturlmanager.e;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SuperUrlParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements e {
    private me.jessyan.retrofiturlmanager.c.a<String, String> a;

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
        int iA = a(httpUrl2, builderNewBuilder);
        if (TextUtils.isEmpty(this.a.get(a(httpUrl, httpUrl2, iA)))) {
            for (int i2 = 0; i2 < httpUrl2.pathSize(); i2++) {
                builderNewBuilder.removePathSegment(0);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(httpUrl.encodedPathSegments());
            if (httpUrl2.pathSize() > iA) {
                List<String> listEncodedPathSegments = httpUrl2.encodedPathSegments();
                for (int i3 = iA; i3 < listEncodedPathSegments.size(); i3++) {
                    arrayList.add(listEncodedPathSegments.get(i3));
                }
            } else if (httpUrl2.pathSize() < iA) {
                throw new IllegalArgumentException(String.format("Your final path is %s, the pathSize = %d, but the #baseurl_path_size = %d, #baseurl_path_size must be less than or equal to pathSize of the final path", httpUrl2.scheme() + HttpConstant.SCHEME_SPLIT + httpUrl2.host() + httpUrl2.encodedPath(), Integer.valueOf(httpUrl2.pathSize()), Integer.valueOf(iA)));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addEncodedPathSegment((String) it.next());
            }
        } else {
            builderNewBuilder.encodedPath(this.a.get(a(httpUrl, httpUrl2, iA)));
        }
        HttpUrl httpUrlBuild = builderNewBuilder.scheme(httpUrl.scheme()).host(httpUrl.host()).port(httpUrl.port()).build();
        if (TextUtils.isEmpty(this.a.get(a(httpUrl, httpUrl2, iA)))) {
            this.a.put(a(httpUrl, httpUrl2, iA), httpUrlBuild.encodedPath());
        }
        return httpUrlBuild;
    }

    private String a(HttpUrl httpUrl, HttpUrl httpUrl2, int i2) {
        return httpUrl.encodedPath() + httpUrl2.encodedPath() + i2;
    }

    private int a(HttpUrl httpUrl, HttpUrl.Builder builder) {
        String strFragment = httpUrl.fragment();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        if (strFragment.indexOf("#") == -1) {
            String[] strArrSplit = strFragment.split("=");
            if (strArrSplit.length > 1) {
                i2 = Integer.parseInt(strArrSplit[1]);
            }
        } else if (strFragment.indexOf("#baseurl_path_size=") == -1) {
            int iIndexOf = strFragment.indexOf("#");
            stringBuffer.append(strFragment.substring(iIndexOf + 1, strFragment.length()));
            String[] strArrSplit2 = strFragment.substring(0, iIndexOf).split("=");
            if (strArrSplit2.length > 1) {
                i2 = Integer.parseInt(strArrSplit2[1]);
            }
        } else {
            String[] strArrSplit3 = strFragment.split("#baseurl_path_size=");
            stringBuffer.append(strArrSplit3[0]);
            if (strArrSplit3.length > 1) {
                int iIndexOf2 = strArrSplit3[1].indexOf("#");
                if (iIndexOf2 != -1) {
                    stringBuffer.append(strArrSplit3[1].substring(iIndexOf2, strArrSplit3[1].length()));
                    String strSubstring = strArrSplit3[1].substring(0, iIndexOf2);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        i2 = Integer.parseInt(strSubstring);
                    }
                } else {
                    i2 = Integer.parseInt(strArrSplit3[1]);
                }
            }
        }
        if (TextUtils.isEmpty(stringBuffer.toString())) {
            builder.fragment(null);
        } else {
            builder.fragment(stringBuffer.toString());
        }
        return i2;
    }
}
