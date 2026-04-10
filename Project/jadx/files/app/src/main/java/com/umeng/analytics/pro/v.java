package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19816c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONArray f19817d = new JSONArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f19818e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f19819f = new HashMap();
    Stack<String> a = new Stack<>();
    com.umeng.analytics.vshelper.a b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f19818e) {
                    string = f19817d.toString();
                    f19817d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f19819f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.a.size() == 0) {
                UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f19819f) {
            l2 = this.f19819f.get(str);
            this.f19819f.remove(str);
        }
        if (l2 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
            this.a.pop();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l2.longValue();
        synchronized (f19818e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.f19631v, str);
                jSONObject.put("duration", jCurrentTimeMillis);
                jSONObject.put(d.f19633x, l2);
                jSONObject.put("type", a());
                f19817d.put(jSONObject);
                if (f19817d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.a.size() == 0) {
            return;
        }
        UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.a.peek()}, null, null);
        }
        this.b.customPageBegin(str);
        synchronized (this.f19819f) {
            this.f19819f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.a.push(str);
            }
        }
    }

    public void b() {
        String key;
        synchronized (this.f19819f) {
            key = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f19819f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j2 = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}
