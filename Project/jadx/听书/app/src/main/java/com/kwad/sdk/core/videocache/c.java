package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class c {
    public final File aKK;
    public final com.kwad.sdk.core.videocache.a.c aKL;
    public final com.kwad.sdk.core.videocache.a.a aKM;
    public final com.kwad.sdk.core.videocache.d.c aKN;
    public final com.kwad.sdk.core.videocache.b.b aKO;
    public final int aKP;
    public final int aKQ;

    c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.aKK = file;
        this.aKL = cVar;
        this.aKM = aVar;
        this.aKN = cVar2;
        this.aKO = bVar;
        this.aKP = i;
        this.aKQ = i2;
    }

    final File eG(String str) {
        return new File(this.aKK, this.aKL.generate(str));
    }
}
