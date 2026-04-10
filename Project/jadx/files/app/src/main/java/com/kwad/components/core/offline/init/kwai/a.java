package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.bh;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class a implements IAsync {
    a() {
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        com.kwad.sdk.utils.g.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        com.kwad.sdk.utils.g.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        bh.runOnUiThread(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j2) {
        bh.runOnUiThreadDelay(runnable, j2);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        com.kwad.sdk.utils.g.schedule(runnable, j2, timeUnit);
    }
}
