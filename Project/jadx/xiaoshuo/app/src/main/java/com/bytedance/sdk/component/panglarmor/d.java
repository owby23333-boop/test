package com.bytedance.sdk.component.panglarmor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.ArrayMap;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d p;
    private Application v;
    private final ArrayList<String> e = new ArrayList<>();
    private final AtomicBoolean bf = new AtomicBoolean(false);
    private long d = System.currentTimeMillis();
    private long tg = 0;
    private long ga = 0;
    private String vn = "";
    private boolean zk = false;
    private boolean m = false;

    public static d e(Application application) {
        if (p == null) {
            synchronized (d.class) {
                if (p == null) {
                    p = new d();
                    p.v = application;
                    p.zk = e((Context) application);
                    p.m = ga.e(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    p.e();
                }
            }
        }
        return p;
    }

    public void bf(@ForbidWrapParam Activity activity) {
        if (this.e.contains(activity.toString())) {
            this.e.remove(activity.toString());
            if (this.e.size() == 0) {
                this.d = System.currentTimeMillis();
                this.bf.set(true);
            }
        }
    }

    public void e(@ForbidWrapParam Activity activity) {
        if (this.e.size() == 0) {
            this.vn = activity.toString();
            this.tg = System.currentTimeMillis();
            this.ga = System.currentTimeMillis() - this.d;
        }
        if (this.e.contains(activity.toString())) {
            return;
        }
        this.e.add(activity.toString());
        this.bf.set(false);
    }

    @DungeonFlag
    private void e() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap == null || (size = arrayMap.size()) <= 0) {
                return;
            }
            Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
            Field declaredField2 = cls2.getDeclaredField("stopped");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
            declaredField3.setAccessible(true);
            cls2.getDeclaredField("paused").setAccessible(true);
            for (int i = 0; i < size; i++) {
                Object objValueAt = arrayMap.valueAt(i);
                if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                    String string = declaredField3.get(objValueAt).toString();
                    if (!this.e.contains(string)) {
                        this.e.add(string);
                    }
                }
            }
            this.bf.set(this.e.size() <= 0);
        } catch (Exception unused) {
        }
    }

    private static boolean e(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String e(java.lang.String r19, long r20) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglarmor.d.e(java.lang.String, long):java.lang.String");
    }
}
