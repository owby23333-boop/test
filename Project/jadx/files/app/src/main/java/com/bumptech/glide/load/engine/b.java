package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements e, d.a<Object> {
    private File A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f13505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final f<?> f13506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final e.a f13507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.bumptech.glide.load.c f13509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<com.bumptech.glide.load.j.n<File, ?>> f13510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f13511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile n.a<?> f13512z;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean b() {
        return this.f13511y < this.f13510x.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (b() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f13510x;
        r3 = r7.f13511y;
        r7.f13511y = r3 + 1;
        r7.f13512z = r0.get(r3).a(r7.A, r7.f13506t.n(), r7.f13506t.f(), r7.f13506t.i());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f13512z == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f13506t.c(r7.f13512z.f13681c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f13512z.f13681c.a(r7.f13506t.j(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f13512z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r1 != false) goto L40;
     */
    @Override // com.bumptech.glide.load.engine.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            com.bumptech.glide.util.m.b.a(r0)
        L5:
            java.util.List<com.bumptech.glide.load.j.n<java.io.File, ?>> r0 = r7.f13510x     // Catch: java.lang.Throwable -> Lb4
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L6c
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> Lb4
            if (r0 != 0) goto L12
            goto L6c
        L12:
            r0 = 0
            r7.f13512z = r0     // Catch: java.lang.Throwable -> Lb4
        L15:
            if (r1 != 0) goto L68
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L68
            java.util.List<com.bumptech.glide.load.j.n<java.io.File, ?>> r0 = r7.f13510x     // Catch: java.lang.Throwable -> Lb4
            int r3 = r7.f13511y     // Catch: java.lang.Throwable -> Lb4
            int r4 = r3 + 1
            r7.f13511y = r4     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.j.n r0 = (com.bumptech.glide.load.j.n) r0     // Catch: java.lang.Throwable -> Lb4
            java.io.File r3 = r7.A     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r4 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            int r4 = r4.n()     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r5 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            int r5 = r5.f()     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r6 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.f r6 = r6.i()     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.j.n$a r0 = r0.a(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb4
            r7.f13512z = r0     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.j.n$a<?> r0 = r7.f13512z     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.f<?> r0 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.j.n$a<?> r3 = r7.f13512z     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.data.d<Data> r3 = r3.f13681c     // Catch: java.lang.Throwable -> Lb4
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> Lb4
            boolean r0 = r0.c(r3)     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L15
            com.bumptech.glide.load.j.n$a<?> r0 = r7.f13512z     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.data.d<Data> r0 = r0.f13681c     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r1 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.Priority r1 = r1.j()     // Catch: java.lang.Throwable -> Lb4
            r0.a(r1, r7)     // Catch: java.lang.Throwable -> Lb4
            r1 = 1
            goto L15
        L68:
            com.bumptech.glide.util.m.b.a()
            return r1
        L6c:
            int r0 = r7.f13508v     // Catch: java.lang.Throwable -> Lb4
            int r0 = r0 + r2
            r7.f13508v = r0     // Catch: java.lang.Throwable -> Lb4
            int r0 = r7.f13508v     // Catch: java.lang.Throwable -> Lb4
            java.util.List<com.bumptech.glide.load.c> r2 = r7.f13505s     // Catch: java.lang.Throwable -> Lb4
            int r2 = r2.size()     // Catch: java.lang.Throwable -> Lb4
            if (r0 < r2) goto L7f
            com.bumptech.glide.util.m.b.a()
            return r1
        L7f:
            java.util.List<com.bumptech.glide.load.c> r0 = r7.f13505s     // Catch: java.lang.Throwable -> Lb4
            int r2 = r7.f13508v     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.c r0 = (com.bumptech.glide.load.c) r0     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.c r2 = new com.bumptech.glide.load.engine.c     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r3 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.c r3 = r3.l()     // Catch: java.lang.Throwable -> Lb4
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r3 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.y.a r3 = r3.d()     // Catch: java.lang.Throwable -> Lb4
            java.io.File r2 = r3.a(r2)     // Catch: java.lang.Throwable -> Lb4
            r7.A = r2     // Catch: java.lang.Throwable -> Lb4
            java.io.File r2 = r7.A     // Catch: java.lang.Throwable -> Lb4
            if (r2 == 0) goto L5
            r7.f13509w = r0     // Catch: java.lang.Throwable -> Lb4
            com.bumptech.glide.load.engine.f<?> r0 = r7.f13506t     // Catch: java.lang.Throwable -> Lb4
            java.io.File r2 = r7.A     // Catch: java.lang.Throwable -> Lb4
            java.util.List r0 = r0.a(r2)     // Catch: java.lang.Throwable -> Lb4
            r7.f13510x = r0     // Catch: java.lang.Throwable -> Lb4
            r7.f13511y = r1     // Catch: java.lang.Throwable -> Lb4
            goto L5
        Lb4:
            r0 = move-exception
            com.bumptech.glide.util.m.b.a()
            goto Lba
        Lb9:
            throw r0
        Lba:
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.b.a():boolean");
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f13512z;
        if (aVar != null) {
            aVar.f13681c.cancel();
        }
    }

    b(List<com.bumptech.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f13508v = -1;
        this.f13505s = list;
        this.f13506t = fVar;
        this.f13507u = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object obj) {
        this.f13507u.a(this.f13509w, obj, this.f13512z.f13681c, DataSource.DATA_DISK_CACHE, this.f13509w);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(@NonNull Exception exc) {
        this.f13507u.a(this.f13509w, exc, this.f13512z.f13681c, DataSource.DATA_DISK_CACHE);
    }
}
