package com.xiaomi.ad;

import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.URLEncodeUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class i {
    public static final String g = "HttpRequest";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7264b;
    public String c;
    public String d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7263a = a.GET;
    public List<k> e = new ArrayList();
    public List<k> f = new ArrayList();

    public enum a {
        POST,
        GET
    }

    public i(String str) {
        this.f7264b = str;
        int iIndexOf = str.indexOf("://");
        if (iIndexOf >= 0) {
            String str2 = this.f7264b;
            String strSubstring = str2.substring(iIndexOf + 3, str2.length());
            int iIndexOf2 = strSubstring.indexOf("/");
            this.d = strSubstring.substring(0, iIndexOf2);
            this.c = strSubstring.substring(iIndexOf2, strSubstring.contains("?") ? strSubstring.indexOf("?") : strSubstring.length());
        }
    }

    public static i b(String str) {
        try {
            return new i(str);
        } catch (Exception e) {
            MLog.e(g, "Exception when building http request for " + str, e);
            return null;
        }
    }

    public String a() {
        if (this.f7263a != a.GET) {
            return this.f7264b;
        }
        String strFromParamListToString = URLEncodeUtils.fromParamListToString(this.e);
        String str = this.f7264b;
        if (!str.contains("?")) {
            str = str + "?";
        }
        return str + strFromParamListToString;
    }

    public String c() {
        return this.d;
    }

    public a d() {
        return this.f7263a;
    }

    public String e() {
        return this.c;
    }

    public List<k> f() {
        return this.e;
    }

    public String g() {
        return this.f7264b;
    }

    public String toString() {
        try {
            String str = "";
            boolean z = true;
            for (k kVar : this.e) {
                if (z) {
                    z = false;
                } else {
                    str = str + com.alipay.sdk.m.w.a.p;
                }
                str = str + kVar.a() + MscKeys.KEY_VAL_SEP + kVar.b();
            }
            String str2 = this.f7264b;
            if (!str2.contains("?")) {
                str2 = str2 + "?";
            }
            return str2 + str;
        } catch (Exception unused) {
            return this.f7264b;
        }
    }

    public void a(a aVar) {
        this.f7263a = aVar;
    }

    public List<k> b() {
        return this.f;
    }

    public void a(String str) {
        this.f7264b = str;
    }

    public void b(String str, String str2) {
        this.e.add(new k(str, str2));
    }

    public void a(String str, String str2) {
        this.f.add(new k(str, str2));
    }
}
