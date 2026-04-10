package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements c {
    private HashMap<String, n> aLI = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eS(String str) {
        if (this.aLI.containsKey(str)) {
            return this.aLI.get(str);
        }
        return null;
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aLI.put(str, nVar);
    }
}
