package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl z;
    private final ArrayList<String> g = new ArrayList<>();
    private final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f779a = System.currentTimeMillis();
    private long gc = 0;
    private long m = 0;
    private String e = "";
    private String gz = "";
    private String fo = "";
    private boolean uy = false;
    private boolean kb = false;

    public static dl z(Application application) {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    dl dlVar = new dl();
                    z = dlVar;
                    dlVar.uy = uy.z(application);
                    z.kb = uy.z(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    z.z();
                }
            }
        }
        return z;
    }

    public void z(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.g.size() == 0) {
            this.e = localClassName;
            this.gc = System.currentTimeMillis();
            this.m = System.currentTimeMillis() - this.f779a;
            this.dl.set(false);
        }
        if (!this.g.contains(localClassName)) {
            this.g.add(localClassName);
        }
        this.fo = localClassName;
    }

    public void g(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.g.contains(localClassName)) {
            this.g.remove(localClassName);
        }
        if (this.g.size() == 0) {
            this.f779a = System.currentTimeMillis();
            this.dl.set(true);
            this.gz = localClassName;
        }
    }

    private void z() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.g.contains(localClassName)) {
                            this.g.add(localClassName);
                        }
                    }
                }
                this.dl.set(this.g.size() <= 0);
            }
        } catch (Exception unused) {
        }
    }

    public String z(String str, long j, int i, boolean z2) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.gc;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.dl.get() && this.kb) {
            i2 |= 2;
        }
        if (!this.dl.get() && this.m >= 5000 && j2 < 1000) {
            i2 = this.gz.equals(this.fo) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.m).put("popt", j2).put("uct", j3).put("isbak", this.dl).put("alert", this.kb).put("rit", i).put("tag", str).put(NotificationCompat.CATEGORY_SYSTEM, this.uy).put("size", this.g.size()).put("mutipro", z2).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.e = "";
        this.m = 0L;
        this.gc = 0L;
        this.f779a = System.currentTimeMillis();
        return string;
    }
}
