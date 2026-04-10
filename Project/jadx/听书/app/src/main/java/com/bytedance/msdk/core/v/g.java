package com.bytedance.msdk.core.v;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.api.a.gc;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.iq;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.pf;
import com.bytedance.msdk.gz.sy;
import com.bytedance.msdk.m.a;
import com.bytedance.msdk.z.gc.gz;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements gz.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f417a;
    private static volatile boolean z;
    private final Context dl;
    private final com.bytedance.msdk.core.v.z g;
    private final gz gz;
    private final AtomicInteger gc = new AtomicInteger(0);
    private final AtomicBoolean m = new AtomicBoolean(false);
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean fo = new AtomicBoolean(false);
    private int uy = -1;

    interface z {
        public static final String z = mc.z() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static g z(com.bytedance.msdk.core.v.z zVar) {
        if (f417a == null) {
            synchronized (g.class) {
                if (f417a == null) {
                    f417a = new g(zVar);
                }
            }
        }
        return f417a;
    }

    private g(com.bytedance.msdk.core.v.z zVar) {
        this.g = zVar == null ? com.bytedance.msdk.core.g.g() : zVar;
        Context context = com.bytedance.msdk.core.g.getContext();
        this.dl = context;
        this.gz = new gz(Looper.getMainLooper(), this);
        if (com.bytedance.msdk.core.z.kb().i()) {
            try {
                context.registerReceiver(new dl(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), z.z, null);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    private class dl extends BroadcastReceiver {
        private dl() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || uy.ls().gk()) {
                return;
            }
            com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (!TextUtils.equals(intent.getStringExtra("b_msg_process_name"), sy.g(g.this.dl))) {
                        if (g.this.g != null) {
                            com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "--==-- settings receiver loadData");
                            g.this.g.z(false);
                            com.bytedance.msdk.e.z.dl.z().g();
                            com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "--==-- settings receiver loadData end");
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
    }

    private static void gc() {
        if (uy.ls().gk() || com.bytedance.msdk.core.g.getContext() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(mc.z());
            intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_process_name", sy.g(com.bytedance.msdk.core.g.getContext()));
            com.bytedance.msdk.core.g.getContext().sendBroadcast(intent, z.z);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public g z() {
        com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting resetRetryCount...");
        this.gc.set(0);
        this.fo.set(false);
        gz gzVar = this.gz;
        if (gzVar != null) {
            gzVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void z(int i) {
        try {
            if (this.m.get()) {
                this.uy = i;
                com.bytedance.msdk.z.gc.dl.g("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                m.a(new RunnableC0076g(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void g(int i) {
        if (this.fo.get()) {
            com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting 尝试拉取配置...");
        z();
        dl(i);
    }

    public void dl(int i) {
        io.z();
        try {
            if (!m()) {
                com.bytedance.msdk.z.gc.dl.g("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.m.get()) {
                com.bytedance.msdk.z.gc.dl.g("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                m.a(new RunnableC0076g(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean m() {
        long jG = com.bytedance.msdk.e.z.z().g("max_expire_time", 0L);
        if (this.e.get() && System.currentTimeMillis() > jG) {
            com.bytedance.msdk.z.gc.dl.g("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.e.set(false);
            z();
        }
        return System.currentTimeMillis() > jG;
    }

    private void z(gc gcVar, com.bytedance.msdk.api.z zVar, int i) throws Throwable {
        long j;
        com.bytedance.msdk.e.z.z().m("server_dist_host");
        z(gcVar, zVar);
        com.bytedance.msdk.m.dl.gc();
        com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.e.get() + " mRetryCount:" + (this.gc.get() + 1));
        this.m.set(false);
        if (this.e.get()) {
            this.fo.set(false);
            this.gz.removeCallbacksAndMessages(null);
            return;
        }
        if (this.gc.get() > 3) {
            com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.fo.set(true);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.gc.get();
        messageObtain.arg2 = i;
        int i2 = this.gc.get();
        if (i2 < 3) {
            long j2 = 1;
            for (int i3 = 0; i3 <= i2; i3++) {
                j2 *= 3;
            }
            j = j2 * 1000;
        } else {
            j = 120000;
        }
        this.gc.incrementAndGet();
        this.gz.removeCallbacksAndMessages(null);
        this.gz.sendMessageDelayed(messageObtain, j);
        com.bytedance.msdk.z.gc.dl.g("SdkSettingsHelper", "setting 重试次数:" + (i2 + 1) + "  重试间隔：" + j);
    }

    private Map<String, String> z(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                map2.put(str.toLowerCase(), map.get(str));
            }
        }
        return map2;
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.v.g$g, reason: collision with other inner class name */
    private class RunnableC0076g implements Runnable {
        private int dl;
        private final gc g;

        RunnableC0076g(gc gcVar, int i) {
            this.g = gcVar;
            this.dl = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!io.z(g.this.dl)) {
                try {
                    g.this.g.z(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            g.this.m.set(true);
            boolean zL = com.bytedance.msdk.core.g.g().l();
            if (!g.z) {
                boolean unused2 = g.z = true;
                a.z(zL);
            }
            if (com.bytedance.msdk.gz.a.z.z()) {
                return;
            }
            g.this.z(zL, this.g, this.dl);
        }
    }

    private void z(final gc gcVar, final com.bytedance.msdk.api.z zVar) {
        m.dl(new Runnable() { // from class: com.bytedance.msdk.core.v.g.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void z(final gc gcVar) {
        int i = this.uy;
        if (i == 2 || i == 3) {
            this.uy = -1;
            z(i);
        }
        if (gcVar != null) {
            final List<String> listHh = com.bytedance.msdk.core.z.kb().hh();
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.v.g.2
                @Override // java.lang.Runnable
                public void run() {
                    gcVar.z(com.bytedance.msdk.core.g.g().z(listHh));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final boolean z2, final gc gcVar, final int i) {
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> mapG = com.bytedance.msdk.core.fo.gc.a().g(i);
        final JSONObject jSONObject = mapG.get("event_label_value_root");
        JSONObject jSONObject2 = mapG.get("config_req_label_value_root");
        com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.msdk.a.g.z().g().g();
        gcVarG.z(com.bytedance.msdk.core.dl.z());
        String strGz = com.bytedance.msdk.core.z.kb().gz();
        if (!TextUtils.isEmpty(strGz)) {
            gcVarG.g("X-Tt-Env", strGz);
            gcVarG.g("x-use-ppe", "1");
        }
        gcVarG.g("User-Agent", com.bytedance.msdk.g.g.z);
        try {
            JSONObject jSONObjectG = g(jSONObject2);
            final boolean z3 = !com.bytedance.msdk.core.g.g().a();
            if (z3) {
                gcVarG.g("x-pglcypher", "4");
                gcVarG.z("application/octet-stream", mc.g(jSONObjectG.toString()));
            } else {
                gcVarG.dl(dl(jSONObjectG));
            }
            gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.msdk.core.v.g.3
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, final com.bytedance.sdk.component.fo.g gVar) {
                    m.z(new Runnable() { // from class: com.bytedance.msdk.core.v.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject3;
                            JSONObject jSONObject4;
                            int iOptInt;
                            long jElapsedRealtime;
                            String strOptString;
                            String str;
                            String strG;
                            JSONObject jSONObject5;
                            JSONObject jSONObject6;
                            JSONObject jSONObject7 = new JSONObject();
                            int[] iArr3 = {-1};
                            if (gVar != null) {
                                iArr2[0] = gVar.z();
                                if (mc.z(gVar)) {
                                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                    String strZ = mc.z(gVar.uy());
                                    try {
                                        jSONObject7.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime2);
                                    } catch (JSONException unused) {
                                    }
                                    if (!TextUtils.isEmpty(strZ)) {
                                        try {
                                            jSONObject3 = jSONObject7;
                                        } catch (Throwable th) {
                                            th = th;
                                            jSONObject3 = jSONObject7;
                                        }
                                        try {
                                            g.this.z(iArr2, iArr, gVar, new JSONObject(strZ), strZ, iArr3, gcVar, jSONObject7, i, z3, jCurrentTimeMillis);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            iArr2[0] = 81014;
                                            g.this.z(gcVar, i, iArr2[0], th.getMessage(), z3);
                                        }
                                    } else {
                                        jSONObject3 = jSONObject7;
                                        iArr2[0] = 81015;
                                        g.this.z(gcVar, i, iArr2[0], "response body is null", z3);
                                    }
                                } else {
                                    jSONObject3 = jSONObject7;
                                    if (gVar.a() != null) {
                                        try {
                                            jSONObject4 = new JSONObject(gVar.a());
                                            iOptInt = jSONObject4.optInt("cypher", -1);
                                            jElapsedRealtime = SystemClock.elapsedRealtime();
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                        if (iOptInt == 2) {
                                            strG = mc.z(jSONObject4.optString("message"));
                                            try {
                                                if (!TextUtils.isEmpty(strG)) {
                                                    try {
                                                        jSONObject5 = new JSONObject(strG);
                                                        str = strG;
                                                        jSONObject6 = jSONObject5;
                                                    } catch (Throwable th4) {
                                                        com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", ">>>>> setting data error: " + th4.toString());
                                                        str = strG;
                                                        jSONObject6 = jSONObject4;
                                                    }
                                                    jSONObject3.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
                                                    jSONObject3 = jSONObject3;
                                                    g.this.z(iArr2, iArr, gVar, jSONObject6, str, iArr3, gcVar, jSONObject3, i, z3, jCurrentTimeMillis);
                                                }
                                                jSONObject3.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
                                                jSONObject3 = jSONObject3;
                                                g.this.z(iArr2, iArr, gVar, jSONObject6, str, iArr3, gcVar, jSONObject3, i, z3, jCurrentTimeMillis);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                jSONObject3 = jSONObject3;
                                                iArr2[0] = 81006;
                                                g.this.z(gcVar, i, iArr2[0], th.getMessage(), z3);
                                            }
                                            str = strG;
                                            jSONObject6 = jSONObject4;
                                        } else {
                                            if (iOptInt == 1) {
                                                strG = com.bytedance.msdk.gz.z.g(jSONObject4.optString("message"), com.bytedance.msdk.gz.g.z());
                                                if (!TextUtils.isEmpty(strG)) {
                                                    try {
                                                        com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "setting data : " + strG.toString());
                                                        jSONObject5 = new JSONObject(strG);
                                                        str = strG;
                                                        jSONObject6 = jSONObject5;
                                                    } catch (Throwable th6) {
                                                        com.bytedance.msdk.z.gc.dl.z("SdkSettingsHelper", "setting data error: ", th6);
                                                        str = strG;
                                                        jSONObject6 = jSONObject4;
                                                    }
                                                    jSONObject3.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
                                                    jSONObject3 = jSONObject3;
                                                    g.this.z(iArr2, iArr, gVar, jSONObject6, str, iArr3, gcVar, jSONObject3, i, z3, jCurrentTimeMillis);
                                                }
                                                str = strG;
                                                jSONObject6 = jSONObject4;
                                                jSONObject3.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
                                                jSONObject3 = jSONObject3;
                                                g.this.z(iArr2, iArr, gVar, jSONObject6, str, iArr3, gcVar, jSONObject3, i, z3, jCurrentTimeMillis);
                                            } else {
                                                if (iOptInt == 0) {
                                                    strOptString = jSONObject4.optString("message");
                                                    jSONObject4 = new JSONObject(strOptString);
                                                } else {
                                                    strOptString = null;
                                                }
                                                str = strOptString;
                                                jSONObject6 = jSONObject4;
                                                jSONObject3.put("decrypt_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
                                                jSONObject3 = jSONObject3;
                                                g.this.z(iArr2, iArr, gVar, jSONObject6, str, iArr3, gcVar, jSONObject3, i, z3, jCurrentTimeMillis);
                                            }
                                            iArr2[0] = 81006;
                                            g.this.z(gcVar, i, iArr2[0], th.getMessage(), z3);
                                        }
                                    } else {
                                        iArr2[0] = 81013;
                                        g.this.z(gcVar, i, iArr2[0], "response body is null", z3);
                                    }
                                }
                            } else {
                                jSONObject3 = jSONObject7;
                                iArr2[0] = 81007;
                                g.this.z(gcVar, i, iArr2[0], "response is null", z3);
                            }
                            a.z(iArr[0], iArr2[0], System.currentTimeMillis() - jCurrentTimeMillis, z2, i == 0, jSONObject, iArr3[0], jSONObject3);
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, final IOException iOException) {
                    m.z(new Runnable() { // from class: com.bytedance.msdk.core.v.g.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + iOException.getMessage());
                            g.this.m.set(false);
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            g.this.z(gcVar, i, iArr2[0], "request fail：" + iOException.getMessage(), z3);
                            a.z(iArr[0], iArr2[0], System.currentTimeMillis() - jCurrentTimeMillis, z2, i == 0, jSONObject, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError e) {
            wp.z(e);
            com.bytedance.msdk.core.kb.z.z().z(81017, "GM接口请求异常");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int[] iArr, int[] iArr2, com.bytedance.sdk.component.fo.g gVar, JSONObject jSONObject, String str, int[] iArr3, gc gcVar, JSONObject jSONObject2, int i, boolean z2, long j) throws Throwable {
        String str2;
        String str3;
        String str4;
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        Map<String, String> mapZ = z(gVar.dl());
        if (mapZ != null) {
            str3 = mapZ.get("active-control");
            str4 = mapZ.get("ts");
            str2 = mapZ.get(t.s);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String strZ = iq.z(str + str3 + str4);
        if (!TextUtils.isEmpty(strZ) && strZ.equalsIgnoreCase(str2)) {
            com.bytedance.msdk.core.g.g().a(str3);
        }
        z(jSONObject);
        int iOptInt = jSONObject.optInt("state_code", -80000);
        String strOptString = jSONObject.optString("message");
        if (iOptInt == 20000) {
            iArr[0] = 20000;
        }
        if (iOptInt == 30004) {
            iArr[0] = 30004;
            this.m.set(false);
            this.fo.set(false);
            this.gz.removeCallbacksAndMessages(null);
            this.g.z(jSONObject);
            z(gcVar);
            com.bytedance.msdk.m.dl.a();
            z(z2, jCurrentTimeMillis);
            return;
        }
        if (iOptInt == 20000 && jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String strA = gVar.a();
            if (strA != null) {
                iArr3[0] = strA.length();
            }
            this.fo.set(false);
            this.gz.removeCallbacksAndMessages(null);
            this.e.set(true);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.g.z(jSONObject, false);
            jSONObject2.put("parse_save_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.m.set(false);
            z(gcVar);
            com.bytedance.msdk.m.dl.a();
            if (com.bytedance.msdk.core.z.kb().i()) {
                gc();
            }
            z(z2, jCurrentTimeMillis);
            return;
        }
        if (iOptInt != -80000) {
            iArr[0] = iOptInt;
        }
        if (TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE))) {
            strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        }
        z(gcVar, i, iArr[0], strOptString, z2);
    }

    private void z(boolean z2, long j) {
        l.z(z2 ? "v4Enc_config" : "v2Enc_config", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(gc gcVar, int i, int i2, String str, boolean z2) {
        if (z2) {
            try {
                com.bytedance.msdk.core.g.g().g(true);
            } catch (Throwable th) {
                wp.z(th);
                return;
            }
        }
        l.z(z2 ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i2 + "，msg = " + str);
        com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "----拉取配置失败: " + i2 + " msg = " + str);
        z(gcVar, new com.bytedance.msdk.api.z(i2, str), i);
        if (com.bytedance.msdk.core.g.g().l()) {
            return;
        }
        com.bytedance.msdk.core.kb.z.z().z(i2, "聚合config请求失败 code = " + i2 + " msg = " + str);
    }

    public static String z(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String string = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return string;
            } catch (Exception unused2) {
                stringWriter.close();
                printWriter.close();
                return null;
            } catch (Throwable th2) {
                try {
                    stringWriter.close();
                } catch (IOException unused3) {
                }
                printWriter.close();
                throw th2;
            }
        } catch (IOException unused4) {
            printWriter.close();
            return null;
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.bytedance.msdk.z.gc.dl.z();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject g(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.bytedance.msdk.g.g.g());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.g.g.a());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put(PluginConstants.KEY_APP_ID, com.bytedance.msdk.core.z.kb().wp());
            jSONObject2.put(an.o, mc.z());
            jSONObject2.put("app_version", mc.dl());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", io.a());
            jSONObject3.put("imei", io.q());
            jSONObject3.put("imei_md5", iq.z(io.q()));
            jSONObject3.put("oaid", io.g());
            jSONObject3.put("gaid", com.bytedance.msdk.gz.gz.z().g());
            jSONObject3.put("applog_did", io.z());
            jSONObject3.put("publisher_did", com.bytedance.msdk.core.z.kb().p());
            jSONObject3.put("conn_type", io.gc());
            jSONObject3.put(an.x, io.i());
            jSONObject3.put(an.y, io.v());
            jSONObject3.put("vendor", io.p());
            jSONObject3.put("device_model", io.e());
            jSONObject3.put("mcc", io.kb());
            jSONObject3.put("mnc", io.wp());
            jSONObject3.put("time_zone", io.fv());
            jSONObject3.put("ip", io.iq());
            jSONObject3.put("locale_language", io.uy());
            jSONObject3.put("total_space", io.ls());
            jSONObject3.put("carrier_name", io.tb());
            jSONObject3.put(an.J, io.gz());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", io.js());
            jSONObject3.put("country_code", com.bytedance.msdk.core.g.g().gz());
            jSONObject3.put("total_mem", io.pf());
            jSONObject3.put(an.ai, io.e());
            jSONObject3.put("language", io.fo());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.bytedance.msdk.core.z.kb().dl());
            jSONObject2.put("app", jSONObject4);
            jSONObject2.put("grouping_params", g());
            JSONObject jSONObjectDl = dl();
            if (jSONObjectDl != null) {
                jSONObject2.put("user_defined_grouping_params", jSONObjectDl);
            }
            if (!com.bytedance.msdk.core.z.kb().e()) {
                jSONObject2.put("etag", com.bytedance.msdk.core.g.g().uy());
            }
            if (com.bytedance.msdk.gz.m.z(this.dl) != null) {
                jSONObject2.put("latitude", r1.z);
                jSONObject2.put("longitude", r1.g);
            }
            jSONObject2.put("adn_version_list", e());
            com.bytedance.msdk.core.fo.gc.a().z(jSONObject2, jSONObject);
            com.bytedance.msdk.core.fo.gc.a().z(jSONObject2);
            List<String> listHh = com.bytedance.msdk.core.z.kb().hh();
            if (listHh != null && listHh.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = listHh.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!pf.z()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObject2;
    }

    public static JSONObject g() {
        String strG;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.a.m mVarIq = com.bytedance.msdk.core.z.kb().iq();
        if (mVarIq != null) {
            try {
                strG = mVarIq.g();
            } catch (JSONException e) {
                wp.z(e);
            }
        } else {
            strG = "";
        }
        jSONObject.put("user_id", strG);
        jSONObject.put("channel", mVarIq != null ? mVarIq.dl() : "");
        jSONObject.put("sub_channel", mVarIq != null ? mVarIq.a() : "");
        jSONObject.put("age", mVarIq != null ? mVarIq.gc() : 0);
        jSONObject.put("gender", mVarIq != null ? mVarIq.m() : "");
        jSONObject.put("user_value_group", mVarIq != null ? mVarIq.e() : "");
        return jSONObject;
    }

    public static JSONObject dl() {
        Map<String, String> mapZ;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.a.m mVarIq = com.bytedance.msdk.core.z.kb().iq();
        if (mVarIq != null && (mapZ = mVarIq.z()) != null) {
            try {
                for (String str : mapZ.keySet()) {
                    jSONObject.put(str, mapZ.get(str));
                }
                return jSONObject;
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return null;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.m.g.g.z();
        List<String> listGz = gz();
        if (listGz != null) {
            for (String str : listGz) {
                com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(str);
                if (aVarZ != null) {
                    try {
                        jSONObject.put(str, aVarZ.g());
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> gz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add(MediationConstant.ADN_GDT);
        arrayList.add(MediationConstant.ADN_ADMOB);
        arrayList.add(MediationConstant.ADN_UNITY);
        arrayList.add("baidu");
        arrayList.add(MediationConstant.ADN_SIGMOB);
        arrayList.add(MediationConstant.ADN_MINTEGRAL);
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_KLEVIN);
        arrayList.add(MediationConstant.ADN_XIAOMI);
        return arrayList;
    }

    private String dl(JSONObject jSONObject) {
        JSONObject jSONObjectZ = mc.z(jSONObject);
        if (jSONObjectZ != null) {
            return jSONObjectZ.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.z.gc.gz.z
    public void z(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = message.arg1;
        int i2 = message.arg2;
        if (i == 3) {
            this.fo.set(false);
        }
        com.bytedance.msdk.z.gc.dl.a("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.e.get() + "tryCount:" + (i + 1));
        try {
            if (this.e.get()) {
                return;
            }
            dl(i2);
        } catch (Throwable unused) {
        }
    }
}
