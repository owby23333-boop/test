package com.kwad.components.ad.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private InterfaceC0340a cM;

    @Nullable
    private b cN;
    private boolean cO = false;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.ad.draw.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0340a {
        void ay();
    }

    public interface b {
        boolean az();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0340a interfaceC0340a) {
        this.cM = interfaceC0340a;
    }

    @MainThread
    public final void a(b bVar) {
        this.cN = bVar;
    }

    public final void ax() {
        InterfaceC0340a interfaceC0340a;
        if (this.cO) {
            return;
        }
        this.cO = true;
        if (d.cb(this.mAdTemplate).status == 1 || d.cb(this.mAdTemplate).status == 2 || d.cb(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.cN;
        if ((bVar == null || !bVar.az()) && (interfaceC0340a = this.cM) != null) {
            interfaceC0340a.ay();
        }
    }
}
