package com.bytedance.e.e.ga.e;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yuewen.et;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static com.bytedance.e.e.tg l;
    private Context bf;
    private String bh;
    private Application e;
    private int f;
    private long m;
    private String p;
    private String s;
    private long t;
    private long v;
    private long w;
    private String wu;
    private long xu;
    private String zk;
    private List<String> d = new ArrayList();
    private List<Long> tg = new ArrayList();
    private List<String> ga = new ArrayList();
    private List<Long> vn = new ArrayList();
    private final Application.ActivityLifecycleCallbacks k = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.e.e.ga.e.bf.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            bf.this.p = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            bf.this.v = System.currentTimeMillis();
            bf.this.d.add(bf.this.p);
            bf.this.tg.add(Long.valueOf(bf.this.v));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            int iIndexOf = bf.this.d.indexOf(name);
            if (iIndexOf > -1 && iIndexOf < bf.this.d.size()) {
                bf.this.d.remove(iIndexOf);
                bf.this.tg.remove(iIndexOf);
            }
            bf.this.ga.add(name);
            bf.this.vn.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            bf.this.bh = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            bf.this.t = System.currentTimeMillis();
            bf.vn(bf.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            bf.this.wu = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            bf.this.xu = System.currentTimeMillis();
            bf.ga(bf.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            bf.this.zk = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            bf.this.m = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            bf.this.s = bf.l == null ? activity.getClass().getName() : bf.l.e(activity);
            bf.this.w = System.currentTimeMillis();
        }
    };

    public bf(@NonNull Context context) {
        this.bf = context;
        if (context instanceof Application) {
            this.e = (Application) context;
        }
        tg();
    }

    public static /* synthetic */ int ga(bf bfVar) {
        int i = bfVar.f;
        bfVar.f = i + 1;
        return i;
    }

    public static /* synthetic */ int vn(bf bfVar) {
        int i = bfVar.f;
        bfVar.f = i - 1;
        return i;
    }

    private JSONArray vn() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.ga;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.ga.size(); i++) {
                try {
                    jSONArray.put(e(this.ga.get(i), this.vn.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static void e(com.bytedance.e.e.tg tgVar) {
        l = tgVar;
    }

    private JSONArray ga() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.d;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.d.size(); i++) {
                try {
                    jSONArray.put(e(this.d.get(i), this.tg.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private void tg() {
        Application application = this.e;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.k);
        }
    }

    public JSONArray bf() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.bf.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
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

    private JSONObject e(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put(et.j, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", e(this.p, this.v));
            jSONObject.put("last_start_activity", e(this.zk, this.m));
            jSONObject.put("last_resume_activity", e(this.wu, this.xu));
            jSONObject.put("last_pause_activity", e(this.bh, this.t));
            jSONObject.put("last_stop_activity", e(this.s, this.w));
            jSONObject.put("alive_activities", ga());
            jSONObject.put("finish_activities", vn());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
