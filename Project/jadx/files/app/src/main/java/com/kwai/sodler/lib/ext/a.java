package com.kwai.sodler.lib.ext;

import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    @Nullable
    private static b n(f fVar) {
        return fVar.Jw();
    }

    public final void c(f fVar, com.kwai.sodler.lib.a.a aVar) {
        b bVarN = n(fVar);
        if (bVarN != null) {
            bVarN.a(fVar, aVar);
        }
    }

    public final void c(f fVar, PluginError pluginError) {
        b bVarN = n(fVar);
        if (bVarN != null) {
            bVarN.a(fVar, pluginError);
        }
    }

    public final void o(f fVar) {
        b bVarN = n(fVar);
        if (bVarN != null) {
            bVarN.a(fVar);
        }
    }

    public final void p(f fVar) {
        b bVarN = n(fVar);
        if (bVarN != null) {
            bVarN.c(fVar);
        }
    }

    public final void q(f fVar) {
        b bVarN = n(fVar);
        if (bVarN != null) {
            bVarN.b(fVar);
        }
    }
}
