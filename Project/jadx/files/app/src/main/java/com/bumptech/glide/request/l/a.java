package com.bumptech.glide.request.l;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements e<Drawable> {
    private final int a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f13888c;

    /* JADX INFO: renamed from: com.bumptech.glide.request.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
    public static class C0279a {
        private final int a;
        private boolean b;

        public C0279a() {
            this(300);
        }

        public a a() {
            return new a(this.a, this.b);
        }

        public C0279a(int i2) {
            this.a = i2;
        }
    }

    protected a(int i2, boolean z2) {
        this.a = i2;
        this.b = z2;
    }

    @Override // com.bumptech.glide.request.l.e
    public d<Drawable> a(DataSource dataSource, boolean z2) {
        return dataSource == DataSource.MEMORY_CACHE ? c.a() : a();
    }

    private d<Drawable> a() {
        if (this.f13888c == null) {
            this.f13888c = new b(this.a, this.b);
        }
        return this.f13888c;
    }
}
