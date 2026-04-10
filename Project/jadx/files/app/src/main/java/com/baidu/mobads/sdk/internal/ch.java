package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static final String b = "404";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final bq f13012c = bq.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f13013g;
    public static final String a = w.b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ch f13007f = new ch();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f13005d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f13006e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static AtomicBoolean f13008h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f13009i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static AtomicBoolean f13010j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f13011k = "";

    private ch() {
    }

    public static ch a() {
        return f13007f;
    }

    private String d() {
        String str = ci.f13016e;
        if (!"0.0".equals(str)) {
            return str;
        }
        try {
            double dB = bw.b(bw.a(this.f13013g));
            return dB > PangleAdapterUtils.CPM_DEFLAUT_VALUE ? String.valueOf(dB) : str;
        } catch (Throwable th) {
            this.f13012c.a(th);
            return str;
        }
    }

    public String b() {
        try {
            if (f13008h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f13009i = str;
                }
            }
            return f13009i;
        } catch (Throwable th) {
            this.f13012c.a(th);
            return f13009i;
        }
    }

    public String c() {
        try {
            if (f13010j.get()) {
                return f13011k;
            }
            if (!f13008h.get()) {
                b();
            }
            if (f13009i.equalsIgnoreCase("")) {
                f13010j.set(true);
                return "";
            }
            if (f13010j.compareAndSet(false, true)) {
                String strA = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(strA)) {
                    f13011k = strA;
                }
            }
            return f13011k;
        } catch (Throwable th) {
            this.f13012c.a(th);
            return f13011k;
        }
    }

    public void a(Context context) {
        if (this.f13013g == null) {
            this.f13013g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("ad", str3);
            map.put("stacktrace", str2);
            a(str, b, map);
        } catch (Exception e2) {
            this.f13012c.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> map) {
        Uri.Builder builder = new Uri.Builder();
        try {
            builder.appendQueryParameter("type", str2).appendQueryParameter(com.umeng.analytics.pro.am.bd, "9.26").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + "_" + ci.f13017f).appendQueryParameter("pack", this.f13013g != null ? this.f13013g.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f13013g)).appendQueryParameter("cuid", a("encodedCUID", this.f13013g)).appendQueryParameter("os", DispatchConstants.ANDROID).appendQueryParameter("osv", bj.a(this.f13013g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bj.a(this.f13013g).a()).appendQueryParameter("brd", "" + a(bj.a(this.f13013g).e()));
            if (str != null && str.length() > 128) {
                int iIndexOf = str.indexOf(10);
                if (iIndexOf <= 0) {
                    iIndexOf = 127;
                }
                str = str.substring(0, iIndexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f13012c.a(th);
        }
        am amVar = new am(a, "POST");
        amVar.a(builder);
        amVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory iXAdContainerFactoryC;
        z zVarA = z.a();
        if (zVarA == null || (iXAdContainerFactoryC = zVarA.c()) == null) {
            return "";
        }
        Object remoteParam = iXAdContainerFactoryC.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f13012c.a(th);
            return str2;
        }
    }
}
