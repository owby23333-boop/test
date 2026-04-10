package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.l.p;
import com.bumptech.glide.load.engine.x.k;
import com.bumptech.glide.load.engine.y.a;
import com.bumptech.glide.load.engine.y.i;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.i f13292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.x.e f13293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.x.b f13294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.engine.y.h f13295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.a f13296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.a f13297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a.InterfaceC0261a f13298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.load.engine.y.i f13299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.bumptech.glide.l.d f13300k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private p.b f13303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.a f13304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f13305p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private List<com.bumptech.glide.request.g<Object>> f13306q;
    private final Map<Class<?>, j<?, ?>> a = new ArrayMap();
    private final f.a b = new f.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13301l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private c.a f13302m = new a(this);

    /* JADX INFO: compiled from: GlideBuilder.java */
    class a implements c.a {
        a(d dVar) {
        }

        @Override // com.bumptech.glide.c.a
        @NonNull
        public com.bumptech.glide.request.h build() {
            return new com.bumptech.glide.request.h();
        }
    }

    /* JADX INFO: compiled from: GlideBuilder.java */
    static final class b implements f.b {
        b() {
        }
    }

    /* JADX INFO: compiled from: GlideBuilder.java */
    static final class c implements f.b {
        c() {
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideBuilder.java */
    public static final class C0254d implements f.b {
    }

    /* JADX INFO: compiled from: GlideBuilder.java */
    public static final class e implements f.b {
        private e() {
        }
    }

    @NonNull
    public d a(@Nullable com.bumptech.glide.load.engine.x.e eVar) {
        this.f13293d = eVar;
        return this;
    }

    @NonNull
    public d a(@Nullable com.bumptech.glide.load.engine.y.h hVar) {
        this.f13295f = hVar;
        return this;
    }

    @NonNull
    public d a(@Nullable a.InterfaceC0261a interfaceC0261a) {
        this.f13298i = interfaceC0261a;
        return this;
    }

    void a(@Nullable p.b bVar) {
        this.f13303n = bVar;
    }

    @NonNull
    com.bumptech.glide.c a(@NonNull Context context) {
        if (this.f13296g == null) {
            this.f13296g = com.bumptech.glide.load.engine.z.a.g();
        }
        if (this.f13297h == null) {
            this.f13297h = com.bumptech.glide.load.engine.z.a.e();
        }
        if (this.f13304o == null) {
            this.f13304o = com.bumptech.glide.load.engine.z.a.c();
        }
        if (this.f13299j == null) {
            this.f13299j = new i.a(context).a();
        }
        if (this.f13300k == null) {
            this.f13300k = new com.bumptech.glide.l.f();
        }
        if (this.f13293d == null) {
            int iB = this.f13299j.b();
            if (iB > 0) {
                this.f13293d = new k(iB);
            } else {
                this.f13293d = new com.bumptech.glide.load.engine.x.f();
            }
        }
        if (this.f13294e == null) {
            this.f13294e = new com.bumptech.glide.load.engine.x.j(this.f13299j.a());
        }
        if (this.f13295f == null) {
            this.f13295f = new com.bumptech.glide.load.engine.y.g(this.f13299j.c());
        }
        if (this.f13298i == null) {
            this.f13298i = new com.bumptech.glide.load.engine.y.f(context);
        }
        if (this.f13292c == null) {
            this.f13292c = new com.bumptech.glide.load.engine.i(this.f13295f, this.f13298i, this.f13297h, this.f13296g, com.bumptech.glide.load.engine.z.a.h(), this.f13304o, this.f13305p);
        }
        List<com.bumptech.glide.request.g<Object>> list = this.f13306q;
        if (list == null) {
            this.f13306q = Collections.emptyList();
        } else {
            this.f13306q = Collections.unmodifiableList(list);
        }
        f fVarA = this.b.a();
        return new com.bumptech.glide.c(context, this.f13292c, this.f13295f, this.f13293d, this.f13294e, new p(this.f13303n, fVarA), this.f13300k, this.f13301l, this.f13302m, this.a, this.f13306q, fVarA);
    }
}
