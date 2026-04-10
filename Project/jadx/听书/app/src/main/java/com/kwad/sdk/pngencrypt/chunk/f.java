package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends e {
    private final List<PngChunk> aVV;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + OD().size() + " queue: " + this.aVV.size();
    }
}
