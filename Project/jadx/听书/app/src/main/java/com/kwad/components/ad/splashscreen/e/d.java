package com.kwad.components.ad.splashscreen.e;

import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.config.e;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.core.widget.a.b {
    public d(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        long jGp = e.Gp();
        if (message.what == 666) {
            wh();
            this.bQ.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, jGp);
        }
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.Ho();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ae();
        }
        return super.ae();
    }
}
