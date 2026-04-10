package com.bytedance.sdk.openadsdk.core.v;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z.g {
    private static volatile dl g;
    private float i;
    private final ConcurrentHashMap<Integer, a> dl = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Float> f1390a = new ConcurrentHashMap();
    private a gc = null;
    private JSONArray e = new JSONArray();
    private final String gz = "realtime_feature";
    private long fo = 0;
    private long uy = 0;
    private long kb = 0;
    private long wp = 0;
    public long z = 0;
    private Handler m = com.bytedance.sdk.component.utils.gz.z();

    private Handler i() {
        return this.m;
    }

    public long dl() {
        if (this.kb == 0) {
            this.kb = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return this.kb;
    }

    public long a() {
        if (this.wp == 0) {
            this.wp = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - q.gc);
        }
        return this.wp;
    }

    private dl() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        if (zVarA != null) {
            zVarA.z(this);
        }
    }

    public static dl gc() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    public void m() {
        dl();
        a();
        z.z(z.z, 0L, 0L);
        z.z(z.f1397a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !zw.g().li()) {
            return;
        }
        if (i <= 0 || i > 10) {
            if (this.gc == null) {
                this.gc = new a(str2);
            }
            this.gc.z(str, str3);
        } else {
            a aVar = this.dl.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(str2);
                this.dl.put(Integer.valueOf(i), aVar);
            }
            aVar.z(str, str3);
        }
    }

    public void z(final String str, final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !zw.g().li()) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
            case "show":
            case "skip":
            case "click":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                i().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.dl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String strOptString = str3;
                            int iOptInt = 0;
                            if (jSONObject != null) {
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject.optString("req_id");
                                }
                                iOptInt = jSONObject.optInt("ad_slot_type", 0);
                            } else if (str4 != null) {
                                JSONObject jSONObject2 = new JSONObject(str4);
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject2.optString("req_id");
                                }
                                iOptInt = jSONObject2.optInt("ad_slot_type", 0);
                            }
                            dl.this.z(str, str2, strOptString, iOptInt);
                        } catch (Exception e) {
                            wp.z(e);
                        }
                    }
                });
                break;
        }
    }

    public void z(final String str, final na naVar) {
        if (!TextUtils.isEmpty(str) && zw.g().li() && "videoPercent30".equals(str)) {
            i().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    na naVar2 = naVar;
                    if (naVar2 != null) {
                        String strMj = naVar2.mj();
                        if (TextUtils.isEmpty(strMj)) {
                            return;
                        }
                        dl.this.z(str, strMj, naVar.aq(), eo.gz(naVar));
                    }
                }
            });
        }
    }

    public void z(final String str, final na naVar, final String str2) {
        if (TextUtils.isEmpty(str) || !zw.g().li()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            i().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.dl.3
                @Override // java.lang.Runnable
                public void run() {
                    na naVar2 = naVar;
                    if (naVar2 != null) {
                        String strMj = naVar2.mj();
                        if (TextUtils.isEmpty(strMj)) {
                            return;
                        }
                        dl.this.z(str, strMj, naVar.aq() + str2, eo.gz(naVar));
                    }
                }
            });
        }
    }

    public JSONArray e() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.dl.keySet().isEmpty()) {
            this.e = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    Iterator<Integer> it = this.dl.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        a aVar = this.dl.get(Integer.valueOf(iIntValue));
                        if (aVar != null && aVar.z().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", iIntValue);
                            jSONObject.put("event_cnts", aVar.z());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.gc != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.gc.z());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    wp.dl(e.getMessage());
                }
            } catch (Throwable th) {
                wp.dl(th.getMessage());
            }
            this.e = jSONArray;
        }
        if (zw.g().lw()) {
            double dCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            wp.z("FeatureCalc", "calc result is " + this.e.toString());
            try {
                jSONObject3.put("cost", dCurrentTimeMillis);
                jSONObject3.put("feature_cnt", this.e.length());
            } catch (JSONException e2) {
                wp.dl(e2.getMessage());
            }
            v.z().e(jSONObject3);
        }
        return this.e;
    }

    public void gz() {
        long jFo = fo();
        if (jFo != this.z) {
            z.z(z.gc);
            this.z = jFo;
        }
    }

    public long fo() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.z == 0) {
            this.z = timeInMillis;
        }
        return timeInMillis;
    }

    public long uy() {
        return this.fo;
    }

    public long kb() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
        if (zw.g().li()) {
            i().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.dl.4
                @Override // java.lang.Runnable
                public void run() {
                    z.z(z.dl, z.m(), 0L);
                    if (dl.this.gc != null) {
                        dl.this.gc.g();
                    }
                    Iterator it = dl.this.dl.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).g();
                    }
                    dl.this.uy = System.currentTimeMillis();
                }
            });
        }
    }

    public float wp() {
        if (this.i == 0.0f) {
            this.i = kb.ls();
        }
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
        if (zw.g().li()) {
            i().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.dl.5
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.i = kb.ls();
                    z.z(z.g, 0L, z.e());
                    z.z(z.m);
                    dl.this.fo = System.currentTimeMillis();
                }
            });
        }
    }

    public void z(na naVar, float f) {
        if (naVar != null) {
            this.f1390a.put(eo.z(naVar, ""), Float.valueOf(f));
        }
    }

    public float z(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.f1390a.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
