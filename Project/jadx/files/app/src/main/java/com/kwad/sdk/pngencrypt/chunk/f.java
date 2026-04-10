package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends e {
    private final List<PngChunk> awj;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Ci().size() + " queue: " + this.awj.size();
    }
}
