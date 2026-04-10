package com.bytedance.sdk.openadsdk.core.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.na;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.funny.audio.core.utils.FileUtils;
import com.qq.e.comm.pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1259a = "com.bytedance.sdk.openadsdk.core.m.z";
    private static HashMap<String, Long> gc;
    private static final HashSet m;
    private static volatile z z;
    private com.bytedance.sdk.openadsdk.core.un.z dl;
    private CopyOnWriteArrayList<JSONObject> g = new CopyOnWriteArrayList<>();

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
    }

    static {
        String name = z.class.getName();
        gc = new HashMap<>();
        m = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    public static z dl() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private z() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        this.dl = zVarA;
        if (zVarA != null) {
            zVarA.g(this);
        }
    }

    public void z(int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (gVar == null) {
            return;
        }
        z(i, gVar.a());
    }

    private boolean z(Long l) {
        return !z(new Date(), new Date(l.longValue()));
    }

    private boolean z(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = gc.get(str);
            if (l != null && l.longValue() != 0) {
                if (!z(l)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    gc.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            wp.dl("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void z(final int i, final String str) {
        if (g.z() && z(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            e.z(new fo("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.m.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.g.add(z.this.z(i, str, stackTrace));
                    if (z.this.g.size() < 3) {
                        return;
                    }
                    try {
                        z.this.a();
                    } catch (OutOfMemoryError e) {
                        wp.z(e);
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.g.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e) {
            wp.z(e);
        }
        this.g.clear();
        String strFo = eo.fo("/api/ad/union/sdk/callstack/batch/");
        na naVar = new na(gc.z().g().m());
        naVar.z(strFo);
        naVar.dl(jSONObject, "callstack");
        naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.m.z.2
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar != null) {
                    wp.z("CallChainStatistic", Boolean.valueOf(gVar.gz()), gVar.a());
                } else {
                    wp.z("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, IOException iOException) {
                wp.z("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject z(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put(ACTD.APPID_KEY, uy.ls().q());
            jSONObject.put("app_version", eo.kb());
            jSONObject.put("ad_sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put("adtype", i);
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("callstack", z(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), i));
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject;
    }

    private JSONArray z(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null && !m.contains(stackTraceElement.getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTraceElement.getMethodName())) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.startsWith("android.app")) {
                    break;
                }
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
        if (uy.ls().gk()) {
            return;
        }
        a();
    }
}
