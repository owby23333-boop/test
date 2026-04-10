package com.anythink.expressad.video.dynview;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private Context a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f11598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f11599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f11602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<com.anythink.expressad.foundation.d.c> f11603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11607m;

    public static class a implements b {
        private Context a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f11609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f11610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f11613h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<com.anythink.expressad.foundation.d.c> f11614i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f11615j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11616k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f11617l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f11618m;

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(Context context) {
            this.a = context.getApplicationContext();
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(float f2) {
            this.f11610e = f2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b c(int i2) {
            this.f11612g = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b d(int i2) {
            this.f11615j = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b e(int i2) {
            this.f11618m = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(String str) {
            this.b = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(int i2) {
            this.f11611f = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(int i2) {
            this.f11608c = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b b(String str) {
            this.f11617l = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(float f2) {
            this.f11609d = f2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(View view) {
            this.f11613h = view;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(List<com.anythink.expressad.foundation.d.c> list) {
            this.f11614i = list;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final b a(boolean z2) {
            this.f11616k = z2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final c a() {
            return new c(this, (byte) 0);
        }
    }

    public interface b {
        b a(float f2);

        b a(int i2);

        b a(Context context);

        b a(View view);

        b a(String str);

        b a(List<com.anythink.expressad.foundation.d.c> list);

        b a(boolean z2);

        c a();

        b b(float f2);

        b b(int i2);

        b b(String str);

        b c(int i2);

        b d(int i2);

        b e(int i2);
    }

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private static a l() {
        return new a();
    }

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final float c() {
        return this.f11598d;
    }

    public final float d() {
        return this.f11599e;
    }

    public final int e() {
        return this.f11600f;
    }

    public final View f() {
        return this.f11602h;
    }

    public final List<com.anythink.expressad.foundation.d.c> g() {
        return this.f11603i;
    }

    public final int h() {
        return this.f11597c;
    }

    public final int i() {
        return this.f11604j;
    }

    public final int j() {
        return this.f11601g;
    }

    public final boolean k() {
        return this.f11605k;
    }

    private c(a aVar) {
        this.f11599e = aVar.f11610e;
        this.f11598d = aVar.f11609d;
        this.f11600f = aVar.f11611f;
        this.f11601g = aVar.f11612g;
        this.a = aVar.a;
        this.b = aVar.b;
        this.f11597c = aVar.f11608c;
        this.f11602h = aVar.f11613h;
        this.f11603i = aVar.f11614i;
        this.f11604j = aVar.f11615j;
        this.f11605k = aVar.f11616k;
    }
}
