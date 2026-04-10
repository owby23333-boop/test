package com.danikula.videocache;

import java.io.File;

/* JADX INFO: compiled from: Config.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    public final File a;
    public final com.danikula.videocache.q.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.danikula.videocache.q.a f14751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.danikula.videocache.s.b f14752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.danikula.videocache.r.b f14753e;

    c(File file, com.danikula.videocache.q.c cVar, com.danikula.videocache.q.a aVar, com.danikula.videocache.s.b bVar, com.danikula.videocache.r.b bVar2) {
        this.a = file;
        this.b = cVar;
        this.f14751c = aVar;
        this.f14752d = bVar;
        this.f14753e = bVar2;
    }

    File a(String str) {
        return new File(this.a, this.b.generate(str));
    }
}
