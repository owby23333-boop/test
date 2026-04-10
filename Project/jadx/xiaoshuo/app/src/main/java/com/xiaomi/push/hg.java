package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes8.dex */
public abstract class hg {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DateFormat f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8036b;
    private static String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hk f499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<hd> f500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f501a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f8035a = Locale.getDefault().getLanguage().toLowerCase();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f497b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f496a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = hr.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f8036b = 0L;
    }

    public hg() {
        this.d = f497b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f500a = new CopyOnWriteArrayList();
        this.f501a = new HashMap();
        this.f499a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(c);
        long j = f8036b;
        f8036b = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    public static String q() {
        return f8035a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hk m497a() {
        return this.f499a;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo496a();

    public synchronized Collection<String> b() {
        if (this.f501a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f501a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hg hgVar = (hg) obj;
        hk hkVar = this.f499a;
        if (hkVar == null ? hgVar.f499a != null : !hkVar.equals(hgVar.f499a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? hgVar.g != null : !str.equals(hgVar.g)) {
            return false;
        }
        if (!this.f500a.equals(hgVar.f500a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? hgVar.e != null : !str2.equals(hgVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? hgVar.h != null : !str3.equals(hgVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f501a;
        if (map == null ? hgVar.f501a != null : !map.equals(hgVar.f501a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? hgVar.f != null : !str4.equals(hgVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = hgVar.d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f500a.hashCode()) * 31) + this.f501a.hashCode()) * 31;
        hk hkVar = this.f499a;
        return iHashCode5 + (hkVar != null ? hkVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public void k(String str) {
        this.e = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.f = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }

    public void a(hk hkVar) {
        this.f499a = hkVar;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String o() {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.hg.o():java.lang.String");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<hd> m499a() {
        if (this.f500a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f500a));
    }

    public hd a(String str) {
        return a(str, null);
    }

    public hd a(String str, String str2) {
        for (hd hdVar : this.f500a) {
            if (str2 == null || str2.equals(hdVar.b())) {
                if (str.equals(hdVar.m493a())) {
                    return hdVar;
                }
            }
        }
        return null;
    }

    public void a(hd hdVar) {
        this.f500a.add(hdVar);
    }

    public hg(Bundle bundle) {
        this.d = f497b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f500a = new CopyOnWriteArrayList();
        this.f501a = new HashMap();
        this.f499a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f500a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                hd hdVarA = hd.a((Bundle) parcelable);
                if (hdVarA != null) {
                    this.f500a.add(hdVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f499a = new hk(bundle2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Object m498a(String str) {
        Map<String, Object> map = this.f501a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        hk hkVar = this.f499a;
        if (hkVar != null) {
            bundle.putBundle("ext_ERROR", hkVar.a());
        }
        List<hd> list = this.f500a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<hd> it = this.f500a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i] = bundleA;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
