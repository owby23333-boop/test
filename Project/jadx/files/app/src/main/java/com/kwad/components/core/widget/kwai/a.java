package com.kwad.components.core.widget.kwai;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bk;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements com.kwad.sdk.core.g.a, bk.a {
    private Set<c> WT;
    private final int WU;
    private final View mRootView;
    private final AtomicBoolean WS = new AtomicBoolean(false);
    protected final bk gH = new bk(this);

    public a(@NonNull View view, int i2) {
        this.mRootView = view;
        this.WU = i2;
    }

    private void aQ(boolean z2) {
        Set<c> set = this.WT;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z2) {
                    cVar.aS();
                } else {
                    cVar.aT();
                }
            }
        }
    }

    private void jo() {
        if (this.WS.getAndSet(true)) {
            return;
        }
        aQ(true);
    }

    private void rT() {
        if (et()) {
            jo();
        } else {
            rW();
        }
    }

    private void rW() {
        if (this.WS.getAndSet(false)) {
            aQ(false);
        }
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (message.what == 666) {
            rT();
            this.gH.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final void a(c cVar) {
        ag.checkUiThread();
        if (cVar == null) {
            return;
        }
        if (et()) {
            cVar.aS();
        } else {
            cVar.aT();
        }
        if (this.WT == null) {
            this.WT = new HashSet();
        }
        this.WT.add(cVar);
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        ag.checkUiThread();
        if (cVar == null || (set = this.WT) == null) {
            return;
        }
        set.remove(cVar);
    }

    public abstract boolean et();

    public final void rU() {
        this.gH.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.gH.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    public final void rV() {
        rT();
        this.gH.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final boolean rX() {
        return this.WS.get();
    }

    @Override // com.kwad.sdk.core.g.a
    @CallSuper
    public final void release() {
        rV();
        Set<c> set = this.WT;
        if (set != null) {
            set.clear();
        }
    }
}
