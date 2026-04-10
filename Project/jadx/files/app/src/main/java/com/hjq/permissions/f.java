package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: XXPermissions.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f16404c;
    private FragmentActivity a;
    private List<String> b;

    private f(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public static f a(FragmentActivity fragmentActivity) {
        return new f(fragmentActivity);
    }

    public static f a(Context context) {
        return a(e.a(context));
    }

    public f a(String... strArr) {
        List<String> list = this.b;
        if (list == null) {
            this.b = e.a(strArr);
        } else {
            list.addAll(e.a(strArr));
        }
        return this;
    }

    public void a(a aVar) {
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !this.a.isDestroyed()) {
            List<String> list = this.b;
            if (list != null && !list.isEmpty()) {
                if (f16404c == null) {
                    f16404c = Boolean.valueOf(e.c(this.a));
                }
                e.b(this.b);
                if (f16404c.booleanValue()) {
                    e.a((Context) this.a, this.b);
                    e.a((Activity) this.a, this.b);
                }
                if (!e.b((Context) this.a, this.b)) {
                    c.a(this.a, new ArrayList(this.b), aVar);
                    return;
                } else {
                    if (aVar != null) {
                        aVar.b(this.b, true);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("The requested permission cannot be empty");
        }
    }

    public static boolean a(Context context, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return a(context, e.a(strArr));
        }
        return a(context, e.b(context));
    }

    public static boolean a(Context context, List<String> list) {
        return e.b(context, list);
    }

    public static void a(Activity activity, List<String> list) {
        activity.startActivityForResult(d.a(activity, list), 1024);
    }
}
