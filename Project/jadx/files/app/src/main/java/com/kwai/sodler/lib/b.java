package com.kwai.sodler.lib;

import com.kwai.sodler.lib.a.b;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwai.sodler.lib.a.b {
    private b.a aIn;

    @Override // com.kwai.sodler.lib.a.b
    public final void e(com.kwai.sodler.lib.a.f fVar) {
        b.a aVar = this.aIn;
        if (aVar != null) {
            fVar.b(aVar.Jn());
        } else {
            a.w("Sodler.PluginConfigUpdater", "config reqester not set");
        }
    }
}
