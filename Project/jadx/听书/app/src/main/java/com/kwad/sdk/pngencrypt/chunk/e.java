package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aTY;
    List<PngChunk> aVR = new ArrayList();
    boolean aVS = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aTY = kVar;
    }

    public final List<PngChunk> OD() {
        return this.aVR;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.c
                public final boolean a(PngChunk pngChunk) {
                    return pngChunk.aoB.equals(str);
                }
            });
        }
        return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.aoB.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).OM().equals(str2);
                }
                return false;
            }
        });
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.ep(i);
        this.aVR.add(pngChunk);
        if (pngChunk.aoB.equals("PLTE")) {
            this.aVS = true;
        }
    }

    public final List<? extends PngChunk> am(String str, String str2) {
        return a(this.aVR, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.aVR.size();
    }
}
