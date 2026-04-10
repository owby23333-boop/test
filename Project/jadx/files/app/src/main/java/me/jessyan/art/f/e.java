package me.jessyan.art.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import androidx.annotation.NonNull;
import retrofit2.HttpException;

/* JADX INFO: compiled from: MkUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static int a(@NonNull Context context, float f2) {
        return (int) ((f2 * getResources(context).getDisplayMetrics().density) + 0.5f);
    }

    public static Resources getResources(Context context) {
        return context.getResources();
    }

    public static void startActivity(Class cls) {
        me.jessyan.art.d.d.e().startActivity(cls);
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void startActivity(Intent intent) {
        me.jessyan.art.d.d.e().startActivity(intent);
    }

    public static String a(HttpException httpException) {
        int iCode = httpException.code();
        if (iCode == 500) {
            return "服务器发生错误";
        }
        if (iCode == 404) {
            return "请求地址不存在";
        }
        if (iCode == 403) {
            return "请求被服务器拒绝";
        }
        if (iCode == 307) {
            return "请求被重定向到其他页面";
        }
        if (iCode == 409) {
            return "手机系统时间不正确!";
        }
        return "请求出现错误: " + iCode;
    }

    public static void startActivity(Activity activity, Class cls) {
        activity.startActivity(new Intent(activity.getApplicationContext(), (Class<?>) cls));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, boolean r6) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.jessyan.art.f.e.a(android.content.Context, boolean):java.lang.String");
    }

    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }

    public static me.jessyan.art.a.a.a a(Context context) {
        g.a(context, "%s cannot be null", Context.class.getName());
        g.a(context.getApplicationContext() instanceof me.jessyan.art.base.b, "%s must be implements %s", context.getApplicationContext().getClass().getName(), me.jessyan.art.base.b.class.getName());
        return ((me.jessyan.art.base.b) context.getApplicationContext()).getAppComponent();
    }
}
