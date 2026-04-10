package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aul;
    List<PngChunk> awf = new ArrayList();
    boolean awg = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aul = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.awb.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.awb.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).Cr().equals(str2);
                }
                return false;
            }
        });
    }

    public final List<PngChunk> Ci() {
        return this.awf;
    }

    public final List<? extends PngChunk> V(String str, String str2) {
        return a(this.awf, str, str2);
    }

    public final void a(PngChunk pngChunk, int i2) {
        pngChunk.bQ(i2);
        this.awf.add(pngChunk);
        if (pngChunk.awb.equals("PLTE")) {
            this.awg = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.awf.size();
    }
}
