package com.anythink.expressad.out;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class j implements com.anythink.expressad.e.b, com.anythink.expressad.foundation.g.d.c, Serializable {
    private static final long a = 1;
    public static final int cR = 1;
    public static final int cS = 2;
    public static final int cT = 3;
    public String cU;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f10904j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f10906l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f10908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f10909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f10910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private q f10911q;
    private String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10897c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10898d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10899e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10900f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10901g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10902h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10903i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10905k = 33333;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10907m = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f10912r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f10913s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f10914t = 0;

    private Drawable a() {
        return this.f10909o;
    }

    private Drawable b() {
        return this.f10910p;
    }

    private void c(q qVar) {
        this.f10911q = qVar;
    }

    private String d() {
        return this.cU;
    }

    private int e() {
        return this.f10912r;
    }

    private int f() {
        return this.f10913s;
    }

    private String g() {
        return this.f10908n;
    }

    public final void A(String str) {
        this.f10902h = str;
    }

    public final void B(String str) {
        this.f10900f = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(String str, String str2) {
    }

    public final double aX() {
        return this.f10904j;
    }

    public final int aY() {
        return this.f10905k;
    }

    public final String aZ() {
        return this.b;
    }

    public final String ba() {
        return this.f10897c;
    }

    public final String bb() {
        return this.f10898d;
    }

    public final String bc() {
        return this.f10899e;
    }

    public final String bd() {
        return this.f10901g;
    }

    public final String be() {
        return this.f10902h;
    }

    public final int bf() {
        return this.f10907m;
    }

    public final long bg() {
        return this.f10903i;
    }

    public final String bh() {
        return this.f10900f;
    }

    public final int bi() {
        return this.f10914t;
    }

    public final void o(int i2) {
        this.f10905k = i2;
    }

    public final void p(int i2) {
        this.f10907m = i2;
    }

    public final void q(int i2) {
        this.f10914t = i2;
    }

    public final void v(String str) {
        this.b = str;
    }

    public final void w(String str) {
        this.f10897c = str;
    }

    public final void x(String str) {
        this.f10898d = str;
    }

    public final void y(String str) {
        this.f10899e = str;
    }

    public final void z(String str) {
        this.f10901g = str;
    }

    private void a(q qVar) {
        this.f10911q = qVar;
        if (TextUtils.isEmpty(this.f10901g)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.f10901g, this);
    }

    private void b(q qVar) {
        this.f10911q = qVar;
        if (TextUtils.isEmpty(this.f10902h)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.f10902h, this);
    }

    private Object c() {
        return this.f10906l;
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cU = str;
    }

    private void b(int i2) {
        this.f10913s = i2;
    }

    public final void a(double d2) {
        this.f10904j = d2;
    }

    private void a(Object obj) {
        this.f10906l = obj;
    }

    private void b(Drawable drawable) {
        this.f10910p = drawable;
    }

    public final void a(long j2) {
        this.f10903i = j2;
    }

    private void a(int i2) {
        this.f10912r = i2;
    }

    private void a(String str) {
        this.f10908n = str;
    }

    private static Drawable a(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    private void a(Drawable drawable) {
        this.f10909o = drawable;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        String str2;
        if (!TextUtils.isEmpty(this.f10902h) && this.f10902h.equals(str) && bitmap != null) {
            this.f10910p = a(bitmap);
            if (this.f10911q != null) {
                a(bitmap);
            }
        }
        if (TextUtils.isEmpty(this.f10901g) || (str2 = this.f10901g) == null || !str2.equals(str) || bitmap == null) {
            return;
        }
        this.f10909o = a(bitmap);
        if (this.f10911q != null) {
            a(bitmap);
        }
    }
}
