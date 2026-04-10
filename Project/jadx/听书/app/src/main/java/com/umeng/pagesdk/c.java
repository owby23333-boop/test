package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f2381a;
    long b;
    int c;
    int d;
    int e;
    boolean g;
    long h;
    long i;
    String j;
    private Context k;
    Map<String, Double> f = new HashMap();
    private Choreographer.FrameCallback l = new Choreographer.FrameCallback() { // from class: com.umeng.pagesdk.c.1
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            boolean z = PageManger.isDebug;
            if (c.this.g) {
                if (c.this.h == 0) {
                    c.this.h = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - c.this.h > c.this.i) {
                    c.this.b();
                    return;
                }
                if (c.this.b == 0) {
                    c.this.b = j;
                }
                float f = (j - c.this.b) / 1000000.0f;
                if (f > c.this.f2381a) {
                    double d = (((long) c.this.c) * 1000) / ((double) f);
                    c.this.c = 0;
                    c.this.b = 0L;
                    if (PageManger.isDebug) {
                        Log.i("PageManger-PageFPSImpl", "doFrame: " + d + ", map size is " + c.this.f.size() + ", page is " + c.this.j);
                    }
                    c.this.f.put(new StringBuilder().append(System.currentTimeMillis()).toString(), Double.valueOf(d));
                    c.this.d++;
                    if (c.this.d >= c.this.e) {
                        c.this.c();
                        c cVar = c.this;
                        cVar.d = 0;
                        if (cVar.f != null) {
                            cVar.f.clear();
                        }
                    }
                } else {
                    c.this.c++;
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    public c(Context context) {
        SharedPreferences sharedPreferences;
        this.f2381a = 1000.0f;
        this.e = 6;
        this.i = 300000L;
        this.k = context;
        if (context == null || (sharedPreferences = context.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.f2381a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000L);
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "init fps. diff is " + this.f2381a + ", count diff is " + this.e + ", dlealt time is " + this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVarA;
        Iterator<Map.Entry<String, Double>> it = this.f.entrySet().iterator();
        if (it != null) {
            JSONArray jSONArray = null;
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<String, Double> next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (PageManger.getRefreshRate() > 0.0f && next.getValue().doubleValue() < ((double) PageManger.getRefreshRate()) * 1.1d) {
                            jSONObject.put(next.getKey(), next.getValue());
                            if (next.getValue().doubleValue() < 40.0d) {
                                z = true;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.j);
                    jSONObject2.put("pF", jSONArray);
                    if (z && (aVarA = b.a(this.k).a()) != null) {
                        jSONObject2.put("te", aVarA.c);
                        jSONObject2.put("le", aVarA.f2377a);
                    }
                    EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                    efsJSONLog.put("fps", jSONObject2);
                    EfsReporter reporter = PageManger.getReporter();
                    if (reporter != null) {
                        reporter.send(efsJSONLog);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.g) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "state is start!");
            }
        } else {
            this.g = true;
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "start, page is " + this.j);
            }
            Choreographer.getInstance().removeFrameCallback(this.l);
            Choreographer.getInstance().postFrameCallback(this.l);
        }
    }

    public final void b() {
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "stop, page is " + this.j);
        }
        c();
        this.g = false;
        this.h = 0L;
        this.b = 0L;
        this.c = 0;
        Map<String, Double> map = this.f;
        if (map != null) {
            map.clear();
        }
        this.d = 0;
    }
}
