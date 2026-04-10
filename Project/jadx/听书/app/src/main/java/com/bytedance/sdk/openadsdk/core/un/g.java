package com.bytedance.sdk.openadsdk.core.un;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;
    private com.bytedance.sdk.component.a.g.dl e;
    private com.bytedance.sdk.component.a.g.dl fo;
    private com.bytedance.sdk.component.a.g.dl gz;
    private com.bytedance.sdk.component.a.g.dl uy;
    private volatile int kb = 0;
    private int wp = 0;
    private int i = 0;
    private final Map<String, Integer> g = new HashMap();
    private final ConcurrentHashMap<String, Integer> dl = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f1374a = new HashMap();
    private final ConcurrentHashMap<String, Long> gc = new ConcurrentHashMap<>();
    private final long m = SystemClock.elapsedRealtime();

    private g() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.g.get(str);
        this.g.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.gc.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.gc.size() > 1) {
            this.wp++;
        }
        g(str);
    }

    public void g(final String str) {
        com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.a().put(str, g.this.a().get(str, 0) + 1);
                if (g.this.kb == 0) {
                    g gVar = g.this;
                    gVar.kb = gVar.e().get("histRunningCount", 0) + 1;
                    g.this.e().put("histRunningCount", g.this.kb);
                }
            }
        });
    }

    public void dl(String str) {
        Long lRemove;
        if (TextUtils.isEmpty(str) || (lRemove = this.gc.remove(str)) == null) {
            return;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - lRemove.longValue()) / 1000;
        if (jElapsedRealtime >= 0) {
            Long l = this.f1374a.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.f1374a.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
            z(str, jElapsedRealtime);
        }
    }

    public void z(final String str, final long j) {
        com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.g.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = g.this.m().get(str, 0L);
                g.this.m().put(str, (j2 >= 0 ? j2 : 0L) + j);
                g.this.dl();
                g.this.z(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j) {
        int i = this.i;
        if (i == 0) {
            try {
                Map all = m().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.i = (int) (((long) this.i) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.i = -1;
            }
        } else {
            this.i = (int) (((long) i) + j);
        }
        io.z(this.i, this.kb);
    }

    public void g() {
        if (this.gc.size() == 1) {
            for (String str : this.gc.keySet()) {
                Integer num = this.dl.get(str);
                this.dl.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                a(str);
            }
        }
    }

    public void a(final String str) {
        com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.gc().put(str, g.this.gc().get(str, 0) + 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        try {
            Map all = a().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.g.keySet()) {
                    Integer num = this.g.get(str);
                    Long l = this.f1374a.get(str);
                    Integer num2 = this.dl.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = m().getAll();
                Map all3 = gc().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l2 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.wp.z(e2);
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.m) / 1000;
                com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.g.4
                    @Override // com.bytedance.sdk.openadsdk.kb.z.z
                    public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", jElapsedRealtime);
                        jSONObject3.put("hrc", g.this.kb);
                        jSONObject3.put("drc", g.this.wp);
                        return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("ad_activity_record").g(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl a() {
        if (this.e == null) {
            this.e = x.z("activity_resume_count");
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl gc() {
        if (this.gz == null) {
            this.gz = x.z("activity_adshow_count");
        }
        return this.gz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl m() {
        if (this.fo == null) {
            this.fo = x.z("activity_foreground_time");
        }
        return this.fo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl e() {
        if (this.uy == null) {
            this.uy = x.z("activity_recorder");
        }
        return this.uy;
    }
}
