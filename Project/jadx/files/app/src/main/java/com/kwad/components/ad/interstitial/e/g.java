package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends FrameLayout {
    protected h hL;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    protected boolean f63if;

    @NonNull
    protected Context mContext;
    private boolean mw;

    public g(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.f63if = ah.cu(this.mContext);
    }

    private void eH() {
        boolean zCu = ah.cu(this.mContext);
        if (!this.mw || zCu == this.f63if) {
            return;
        }
        this.f63if = zCu;
        h hVar = this.hL;
        if (hVar != null) {
            hVar.j(!zCu);
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        eH();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.mw = i2 == 0;
        eH();
    }

    public final void setOrientationChangeListener(h hVar) {
        this.hL = hVar;
    }
}
