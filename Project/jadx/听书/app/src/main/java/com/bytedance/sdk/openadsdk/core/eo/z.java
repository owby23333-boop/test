package com.bytedance.sdk.openadsdk.core.eo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.r;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final z z = new z();
    private r e;
    private int[] fo;
    private boolean gz;
    private String g = "";
    private String dl = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1040a = "";
    private String gc = "";
    private JSONArray m = new JSONArray();

    public static z z() {
        return z;
    }

    private z() {
    }

    public void z(Context context) {
        if (!zw.g().wp()) {
            this.gz = false;
            return;
        }
        if (this.gz) {
            return;
        }
        try {
            g();
            a();
            dl();
            g(context);
            dl(context);
            this.e = io.kb();
            this.gz = true;
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(r rVar) {
        this.e = rVar;
    }

    public void z(int[] iArr) {
        this.fo = iArr;
    }

    private String g() {
        Enumeration<InetAddress> inetAddresses;
        String hostAddress;
        String str = null;
        if (!kb.uy()) {
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null && (inetAddresses = byName.getInetAddresses()) != null) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.isLinkLocalAddress() && (hostAddress = inetAddressNextElement.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                        str = hostAddress;
                    }
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        this.g = TextUtils.isEmpty(str) ? "" : str;
        return str;
    }

    private Long dl() {
        Long.valueOf(-1L);
        Long lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.dl = lValueOf.toString();
        return lValueOf;
    }

    private ActivityManager.MemoryInfo g(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.f1040a = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    private Long a() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.gc = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private JSONArray dl(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put("com.ss.android.ugc.aweme", "a");
            map.put("com.ss.android.ugc.aweme.lite", "al");
            map.put("com.dragon.read", "r");
            map.put("com.ss.android.article.news", t.h);
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(t.h, entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), t.h)) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.m = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    public void z(JSONObject jSONObject) {
        if (zw.g().wp()) {
            try {
                r rVar = this.e;
                if (rVar != null) {
                    JSONObject jSONObjectDl = rVar.dl();
                    jSONObjectDl.put("sl", 0);
                    jSONObject.put("u_t", jSONObjectDl);
                }
                jSONObject.put("boot_time_sec", this.gc);
                jSONObject.put("memory", this.f1040a);
                jSONObject.put("disk", this.dl);
                jSONObject.put("client_tun", this.g);
                jSONObject.put("pkg_info", this.m);
                int[] iArr = this.fo;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
