package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.bw;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class a implements IAsync {
    a() {
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        com.kwad.sdk.utils.h.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        com.kwad.sdk.utils.h.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        com.kwad.sdk.utils.h.schedule(runnable, j, timeUnit);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        bw.runOnUiThread(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j) {
        bw.runOnUiThreadDelay(runnable, j);
    }
}
