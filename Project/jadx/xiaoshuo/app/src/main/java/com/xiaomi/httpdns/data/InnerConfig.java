package com.xiaomi.httpdns.data;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.market.sdk.utils.Region;
import com.xiaomi.httpdns.data.Config;
import com.xiaomi.uplink.SmsUplinkConfig;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class InnerConfig {
    public static final String[] f;
    public static String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7354b;
    public String c;
    public Config d = new Config.Builder().build();
    public static final String[] e = {"8.8.8.8", "8.8.4.4"};
    public static final ConcurrentHashMap<String, String> g = new ConcurrentHashMap<String, String>() { // from class: com.xiaomi.httpdns.data.InnerConfig.1
        {
            put("CN", InnerConfig.f[0]);
            put("TW", InnerConfig.f[1]);
            put("HK", InnerConfig.f[1]);
            put(SmsUplinkConfig.ACTIVATION_SMS_PREFIX, InnerConfig.f[1]);
            put(Region.RU, InnerConfig.f[2]);
            put("BY", InnerConfig.f[2]);
        }
    };
    public static int h = 60;
    public static String j = "";
    public static final HashMap<String, String> k = new HashMap<>();
    public static String l = "";
    public static int m = 0;
    public static final DnsConfig n = new DnsConfig();
    public static boolean o = true;
    public static long p = 0;

    static {
        String[] strArr = {"110.43.0.168", "34.36.192.126", "169.197.117.129"};
        f = strArr;
        i = strArr[0];
    }

    public boolean a() {
        return !this.d.getPersistentCoreHosts().isEmpty();
    }

    public boolean b() {
        return MiCache.d && p != 0 && SystemClock.elapsedRealtime() - p < this.d.getPersistentInvalidTime();
    }

    public final void c() {
        String str = g.get(this.d.getCountry());
        if (TextUtils.isEmpty(str)) {
            str = f[1];
        }
        i = str;
    }

    public final boolean a(String str) {
        return this.d.getCoreHosts().contains(str);
    }

    public static void a(HashMap<String, String> map, @IntRange(from = 0, to = 1) int i2) {
        String string = "";
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(a.p);
                sb.append(entry.getKey());
                sb.append(MscKeys.KEY_VAL_SEP);
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (Exception unused) {
                    sb.append("");
                }
            }
            if (sb.length() != 0) {
                string = sb.toString();
            }
        }
        l = string;
        m = i2;
        HashMap<String, String> map2 = k;
        map2.clear();
        if (map == null || map.isEmpty()) {
            return;
        }
        map2.putAll(map);
    }
}
