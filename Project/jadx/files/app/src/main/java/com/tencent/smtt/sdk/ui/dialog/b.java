package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private Context a;
    private ResolveInfo b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f19108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f19111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f19113h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19114i;

    b(Context context, int i2, String str, String str2) {
        Drawable drawable;
        this.f19109d = "";
        this.f19110e = "";
        this.f19112g = false;
        this.f19113h = false;
        this.f19114i = "";
        if (i2 != -1) {
            try {
                drawable = context.getResources().getDrawable(i2);
            } catch (Exception unused) {
                drawable = null;
            }
        } else {
            drawable = null;
        }
        drawable = drawable == null ? e.a("application_icon") : drawable;
        this.a = context.getApplicationContext();
        this.b = null;
        this.f19111f = null;
        this.f19108c = drawable;
        this.f19109d = str2;
        this.f19112g = true;
        this.f19114i = str;
    }

    b(Context context, ResolveInfo resolveInfo) {
        this.f19109d = "";
        this.f19110e = "";
        this.f19112g = false;
        this.f19113h = false;
        this.f19114i = "";
        this.a = context.getApplicationContext();
        this.b = resolveInfo;
        this.f19108c = null;
        this.f19109d = null;
        this.f19111f = null;
    }

    b(Context context, Drawable drawable, String str, String str2, String str3) {
        this.f19109d = "";
        this.f19110e = "";
        this.f19112g = false;
        this.f19113h = false;
        this.f19114i = "";
        this.a = context.getApplicationContext();
        this.b = null;
        this.f19108c = drawable;
        this.f19109d = str;
        this.f19111f = str2;
        this.f19113h = true;
        this.f19110e = str3;
    }

    public static Drawable a(Context context, String str) {
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return e.a("application_icon");
            } catch (Throwable th) {
                String str2 = "getApkIcon Error:" + Log.getStackTraceString(th);
                return null;
            }
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            TypedValue typedValue = new TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e2) {
            String str3 = "e = " + e2;
            return null;
        }
    }

    public Drawable a() {
        Drawable drawable = this.f19108c;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawableA = a(this.a, d());
        if (drawableA != null) {
            return drawableA;
        }
        ResolveInfo resolveInfo = this.b;
        return resolveInfo != null ? resolveInfo.loadIcon(this.a.getPackageManager()) : this.f19108c;
    }

    public void a(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public void a(Drawable drawable) {
        this.f19108c = drawable;
    }

    public void a(String str) {
        this.f19110e = str;
    }

    public void a(boolean z2) {
        this.f19113h = z2;
    }

    public String b() {
        ResolveInfo resolveInfo = this.b;
        return resolveInfo != null ? resolveInfo.loadLabel(this.a.getPackageManager()).toString() : this.f19109d;
    }

    public ResolveInfo c() {
        return this.b;
    }

    public String d() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.f19111f;
        return str == null ? "" : str;
    }

    public boolean e() {
        return this.f19112g;
    }

    public boolean f() {
        return this.f19113h;
    }

    public String g() {
        return this.f19114i;
    }

    public String h() {
        return this.f19110e;
    }
}
