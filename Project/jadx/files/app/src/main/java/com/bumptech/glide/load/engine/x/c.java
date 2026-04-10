package com.bumptech.glide.load.engine.x;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: AttributeStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements l {
    private final b a = new b();
    private final h<a, Bitmap> b = new h<>();

    /* JADX INFO: compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        a a(int i2, int i3, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i2, i3, config);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.x.d
        public a a() {
            return new a(this);
        }
    }

    c() {
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public void a(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public Bitmap removeLast() {
        return this.b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    static String c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
    }

    /* JADX INFO: compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class a implements m {
        private final b a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f13611d;

        public a(b bVar) {
            this.a = bVar;
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.b = i2;
            this.f13610c = i3;
            this.f13611d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.f13610c == aVar.f13610c && this.f13611d == aVar.f13611d;
        }

        public int hashCode() {
            int i2 = ((this.b * 31) + this.f13610c) * 31;
            Bitmap.Config config = this.f13611d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.b, this.f13610c, this.f13611d);
        }

        @Override // com.bumptech.glide.load.engine.x.m
        public void a() {
            this.a.a(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.b.a(this.a.a(i2, i3, config));
    }
}
