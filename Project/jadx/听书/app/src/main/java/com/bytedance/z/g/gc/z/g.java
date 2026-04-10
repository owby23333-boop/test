package com.bytedance.z.g.gc.z;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static com.bytedance.z.g.a p;
    private String e;
    private String fo;
    private Context g;
    private long gz;
    private String i;
    private String kb;
    private long ls;
    private String pf;
    private long uy;
    private long v;
    private long wp;
    private Application z;
    private List<String> dl = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Long> f1518a = new ArrayList();
    private List<String> gc = new ArrayList();
    private List<Long> m = new ArrayList();
    private int fv = 0;
    private boolean js = false;
    private final Application.ActivityLifecycleCallbacks tb = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.z.g.gc.z.g.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strZ;
            g gVar = g.this;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            gVar.e = strZ;
            g.this.gz = System.currentTimeMillis();
            g.this.dl.add(g.this.e);
            g.this.f1518a.add(Long.valueOf(g.this.gz));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strZ;
            g gVar = g.this;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            gVar.fo = strZ;
            g.this.uy = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strZ;
            g gVar = g.this;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            gVar.kb = strZ;
            g.this.wp = System.currentTimeMillis();
            g.this.js = true;
            g.gc(g.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strZ;
            g gVar = g.this;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            gVar.i = strZ;
            g.this.v = System.currentTimeMillis();
            g.m(g.this);
            if (g.this.fv <= 0) {
                g.this.js = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strZ;
            g gVar = g.this;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            gVar.pf = strZ;
            g.this.ls = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strZ;
            if (g.p != null) {
                strZ = g.p.z(activity);
            } else {
                strZ = activity.getClass().getName();
            }
            int iIndexOf = g.this.dl.indexOf(strZ);
            if (iIndexOf >= 0 && iIndexOf < g.this.dl.size()) {
                g.this.dl.remove(iIndexOf);
                g.this.f1518a.remove(iIndexOf);
            }
            g.this.gc.add(strZ);
            g.this.m.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    static /* synthetic */ int gc(g gVar) {
        int i = gVar.fv;
        gVar.fv = i + 1;
        return i;
    }

    static /* synthetic */ int m(g gVar) {
        int i = gVar.fv;
        gVar.fv = i - 1;
        return i;
    }

    g(Context context) {
        this.g = context;
        if (context instanceof Application) {
            this.z = (Application) context;
        }
        gc();
    }

    private void gc() {
        Application application = this.z;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.tb);
        }
    }

    private JSONArray m() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.dl;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.dl.size(); i++) {
                try {
                    jSONArray.put(z(this.dl.get(i), this.f1518a.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.gc;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.gc.size(); i++) {
                try {
                    jSONArray.put(z(this.gc.get(i), this.m.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject z(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", z(this.e, this.gz));
            jSONObject.put("last_start_activity", z(this.fo, this.uy));
            jSONObject.put("last_resume_activity", z(this.kb, this.wp));
            jSONObject.put("last_pause_activity", z(this.i, this.v));
            jSONObject.put("last_stop_activity", z(this.pf, this.ls));
            jSONObject.put("alive_activities", m());
            jSONObject.put("finish_activities", e());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray g() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.g.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put(an.o, runningTaskInfo.baseActivity.getPackageName());
                        jSONObject.put("description", runningTaskInfo.description);
                        jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                        jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                        jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                        jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    public boolean dl() {
        return this.js;
    }
}
