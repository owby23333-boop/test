package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class z<T extends f, R extends com.kwad.sdk.core.network.g> implements Runnable {
    protected final n<T> ahA;
    protected final b<T, R> akv;
    protected final AtomicInteger akw;
    protected final Context mContext;

    public z(Context context, n<T> nVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.ahA = nVar;
        this.akv = bVar;
        this.akw = atomicInteger;
    }

    private void s(@NonNull List<T> list) {
        List listD = com.kwad.sdk.utils.y.d(list, 200);
        int size = listD.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i2 = 0; i2 < size; i2++) {
            this.akv.a((List) listD.get(i2), atomicBoolean);
        }
    }

    private void xz() {
        try {
            List<T> listXh = this.ahA.xh();
            if (listXh.isEmpty()) {
                return;
            }
            s(listXh);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.akw.get() > 0 || !af.isNetworkConnected(this.mContext)) {
            return;
        }
        xz();
    }
}
