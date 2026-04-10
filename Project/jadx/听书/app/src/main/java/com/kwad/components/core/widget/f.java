package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends FrameLayout {
    private boolean ajm;
    protected g kR;
    protected boolean lj;
    protected Context mContext;

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.lj = aq.QW();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.kR = gVar;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.ajm = i == 0;
        wg();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        wg();
    }

    private void wg() {
        boolean zQW = aq.QW();
        if (!this.ajm || zQW == this.lj) {
            return;
        }
        this.lj = zQW;
        g gVar = this.kR;
        if (gVar != null) {
            gVar.k(!zQW);
        }
    }
}
