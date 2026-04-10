package com.alibaba.sdk.android.httpdns;

import android.text.Html;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e {
    private String a;
    private long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f17b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2192c;
    private String hostName;
    private String[] ips;

    e(com.alibaba.sdk.android.httpdns.b.e eVar) {
        this.hostName = eVar.host;
        this.f2192c = com.alibaba.sdk.android.httpdns.b.c.a(eVar.f2170n);
        this.b = -1000L;
        ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList = eVar.f7a;
        if (arrayList != null && arrayList.size() > 0) {
            int size = eVar.f7a.size();
            this.ips = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.ips[i2] = eVar.f7a.get(i2).f2172o;
            }
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m28a()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList3 = eVar.f8b;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i3 = 0; i3 < eVar.f8b.size(); i3++) {
                    arrayList2.add(eVar.f8b.get(i3).f2172o);
                }
            }
            com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName, arrayList2);
        }
        this.a = eVar.a;
        this.f17b = eVar.b;
    }

    e(String str) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(str);
        this.hostName = jSONObject.getString(Constants.KEY_HOST);
        try {
            if (jSONObject.has("ips")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ips");
                int length = jSONArray2.length();
                this.ips = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.ips[i2] = jSONArray2.getString(i2);
                }
            }
            if (com.alibaba.sdk.android.httpdns.net64.a.a().m28a() && jSONObject.has("ipsv6") && (jSONArray = jSONObject.getJSONArray("ipsv6")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
                com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName, arrayList);
            }
            if (jSONObject.has("extra")) {
                this.a = jSONObject.getString("extra");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.b = jSONObject.getLong("ttl");
        this.f2192c = System.currentTimeMillis() / 1000;
    }

    e(String str, String[] strArr, long j2, long j3, String str2, String str3) {
        this.hostName = str;
        this.ips = strArr;
        this.b = j2;
        this.f2192c = j3;
        this.a = str2;
        this.f17b = str3;
    }

    long a() {
        return this.b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    com.alibaba.sdk.android.httpdns.b.e m21a() {
        List<String> listA;
        com.alibaba.sdk.android.httpdns.b.e eVar = new com.alibaba.sdk.android.httpdns.b.e();
        eVar.host = this.hostName;
        eVar.f2170n = String.valueOf(this.f2192c);
        eVar.f2169m = com.alibaba.sdk.android.httpdns.b.b.i();
        String[] strArr = this.ips;
        if (strArr != null && strArr.length > 0) {
            eVar.f7a = new ArrayList<>();
            for (String str : this.ips) {
                com.alibaba.sdk.android.httpdns.b.g gVar = new com.alibaba.sdk.android.httpdns.b.g();
                gVar.f2172o = str;
                gVar.f2173p = String.valueOf(this.b);
                eVar.f7a.add(gVar);
            }
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m28a() && (listA = com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName)) != null && listA.size() > 0) {
            eVar.f8b = new ArrayList<>();
            for (String str2 : listA) {
                com.alibaba.sdk.android.httpdns.b.g gVar2 = new com.alibaba.sdk.android.httpdns.b.g();
                gVar2.f2172o = str2;
                gVar2.f2173p = String.valueOf(this.b);
                eVar.f8b.add(gVar2);
            }
        }
        eVar.a = this.a;
        eVar.b = this.f17b;
        return eVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    String m22a() {
        return this.a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    Map<String, String> m23a() {
        HashMap map = new HashMap();
        String str = this.a;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(Html.fromHtml(Html.fromHtml(str).toString()).toString());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.get(next) == null ? null : jSONObject.get(next).toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    long b() {
        return this.f2192c;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    boolean m24b() {
        return b() + a() < System.currentTimeMillis() / 1000 || c();
    }

    boolean c() {
        return a() == -1000;
    }

    String getCacheKey() {
        return this.f17b;
    }

    String[] getIps() {
        return this.ips;
    }

    void setCacheKey(String str) {
        this.f17b = str;
    }

    public String toString() {
        String str = "host: " + this.hostName + " ip cnt: " + this.ips.length + " ttl: " + this.b;
        for (int i2 = 0; i2 < this.ips.length; i2++) {
            str = str + "\n ip: " + this.ips[i2];
        }
        return str;
    }
}
