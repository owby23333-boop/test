package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class c {
    public final File amQ;
    public final com.kwad.sdk.core.videocache.kwai.c amR;
    public final com.kwad.sdk.core.videocache.kwai.a amS;
    public final com.kwad.sdk.core.videocache.c.b amT;
    public final com.kwad.sdk.core.videocache.a.b amU;

    c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.amQ = file;
        this.amR = cVar;
        this.amS = aVar;
        this.amT = bVar;
        this.amU = bVar2;
    }

    final File cw(String str) {
        return new File(this.amQ, this.amR.generate(str));
    }
}
