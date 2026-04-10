package com.anythink.expressad.foundation.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String a = "a";
    private static volatile a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10115e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONObject f10117g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f10120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private WeakReference<Activity> f10121k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10116f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10118h = false;

    private a() {
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final String a() {
        try {
            if (this.f10113c != null) {
                return this.f10113c.getPackageName();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void c() {
        if (this.f10118h) {
            return;
        }
        try {
            this.f10117g = new JSONObject();
            this.f10117g.put("webgl", 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final Context d() {
        return this.f10113c;
    }

    public final String e() {
        return !TextUtils.isEmpty(this.f10114d) ? this.f10114d : "";
    }

    public final String f() {
        return !TextUtils.isEmpty(this.f10115e) ? this.f10115e : "";
    }

    public final Context g() {
        WeakReference<Context> weakReference = this.f10120j;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final int h() {
        return this.f10116f;
    }

    public final JSONObject i() {
        return this.f10117g;
    }

    public final void a(Context context) {
        this.f10113c = context;
    }

    public final void a(String str) {
        this.f10114d = str;
    }

    private void a(int i2) {
        this.f10116f = i2;
    }

    private void a(JSONObject jSONObject) {
        this.f10117g = jSONObject;
    }

    public final void b(String str) {
        this.f10115e = str;
    }

    public final void b(Context context) {
        this.f10120j = new WeakReference<>(context);
    }
}
