package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import cn.bmob.v3.datatype.up.ParallelUploader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.d f1977s;
    private Application a;
    private Context b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f1988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f1989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f1990o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f1991p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1992q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f1978c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Long> f1979d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f1980e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<Long> f1981f = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f1993r = new a();

    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b.this.f1982g = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            b.this.f1983h = System.currentTimeMillis();
            b.this.f1978c.add(b.this.f1982g);
            b.this.f1979d.add(Long.valueOf(b.this.f1983h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            int iIndexOf = b.this.f1978c.indexOf(name);
            if (iIndexOf > -1 && iIndexOf < b.this.f1978c.size()) {
                b.this.f1978c.remove(iIndexOf);
                b.this.f1979d.remove(iIndexOf);
            }
            b.this.f1980e.add(name);
            b.this.f1981f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            b.this.f1988m = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            b.this.f1989n = System.currentTimeMillis();
            b.h(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b.this.f1986k = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            b.this.f1987l = System.currentTimeMillis();
            b.g(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b.this.f1984i = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            b.this.f1985j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            b.this.f1990o = b.f1977s == null ? activity.getClass().getName() : b.f1977s.a(activity);
            b.this.f1991p = System.currentTimeMillis();
        }
    }

    b(@NonNull Context context) {
        this.b = context;
        if (this.b instanceof Application) {
            this.a = (Application) context;
        }
        f();
    }

    private JSONObject a(String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f1978c;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f1978c.size(); i2++) {
                try {
                    jSONArray.put(a(this.f1978c.get(i2), this.f1979d.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f1980e;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f1980e.size(); i2++) {
                try {
                    jSONArray.put(a(this.f1980e.get(i2), this.f1981f.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private void f() {
        Application application;
        if (Build.VERSION.SDK_INT < 14 || (application = this.a) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.f1993r);
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.f1992q;
        bVar.f1992q = i2 + 1;
        return i2;
    }

    static /* synthetic */ int h(b bVar) {
        int i2 = bVar.f1992q;
        bVar.f1992q = i2 - 1;
        return i2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.f1982g, this.f1983h));
            jSONObject.put("last_start_activity", a(this.f1984i, this.f1985j));
            jSONObject.put("last_resume_activity", a(this.f1986k, this.f1987l));
            jSONObject.put("last_pause_activity", a(this.f1988m, this.f1989n));
            jSONObject.put("last_stop_activity", a(this.f1990o, this.f1991p));
            jSONObject.put("alive_activities", d());
            jSONObject.put("finish_activities", e());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray b() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(5)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", runningTaskInfo.id);
                            jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                            jSONObject.put(ParallelUploader.Params.DESCRIPTION, runningTaskInfo.description);
                            jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                            jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                            jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                            jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }
}
