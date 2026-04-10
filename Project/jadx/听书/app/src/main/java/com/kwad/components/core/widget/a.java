package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends KSFrameLayout implements ca.a {
    private InterfaceC0364a ahX;
    private boolean ahY;
    private boolean ahZ;
    private int aia;
    private boolean aib;
    private long aic;
    private boolean aid;
    private final float aie;
    private final int aif;
    private final View bP;
    private final ca bQ;

    /* JADX INFO: renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public interface InterfaceC0364a {
        void aa();

        void ab();

        void ay();

        void c(View view);

        void onWindowFocusChanged(boolean z);
    }

    public a(Context context, View view) {
        super(context, view);
        this.bQ = new ca(this);
        this.aia = 5;
        this.bP = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float fFH = com.kwad.sdk.core.config.e.FH();
        this.aie = fFH;
        setVisiblePercent(fFH);
        float fFJ = com.kwad.sdk.core.config.e.FJ();
        this.aif = (int) ((fFJ < 0.0f ? 1.0f : fFJ) * 1000.0f);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void E(View view) {
        InterfaceC0364a interfaceC0364a;
        InterfaceC0364a interfaceC0364a2;
        super.E(view);
        if (this.aif == 0 && (interfaceC0364a2 = this.ahX) != null) {
            interfaceC0364a2.c(view);
            return;
        }
        if (!this.aib) {
            this.aib = true;
            this.aic = System.currentTimeMillis();
            vS();
            vR();
            return;
        }
        if (System.currentTimeMillis() - this.aic <= this.aif || (interfaceC0364a = this.ahX) == null) {
            return;
        }
        interfaceC0364a.c(view);
        vS();
    }

    private void vR() {
        InterfaceC0364a interfaceC0364a;
        if (this.aif == 0 && (interfaceC0364a = this.ahX) != null) {
            interfaceC0364a.c(this.bP);
            return;
        }
        Message messageObtainMessage = this.bQ.obtainMessage();
        messageObtainMessage.what = 2;
        this.bQ.sendMessageDelayed(messageObtainMessage, this.aif);
    }

    public final void setViewCallback(InterfaceC0364a interfaceC0364a) {
        this.ahX = interfaceC0364a;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0364a interfaceC0364a = this.ahX;
        if (interfaceC0364a != null) {
            interfaceC0364a.onWindowFocusChanged(z);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.aia = 5;
        this.ahY = false;
        this.aib = false;
        vT();
        InterfaceC0364a interfaceC0364a = this.ahX;
        if (interfaceC0364a != null) {
            interfaceC0364a.aa();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        vS();
        this.aia = 0;
        this.aic = 0L;
        this.ahY = true;
        InterfaceC0364a interfaceC0364a = this.ahX;
        if (interfaceC0364a != null) {
            interfaceC0364a.ab();
        }
    }

    private void vS() {
        this.bQ.removeCallbacksAndMessages(null);
        this.ahZ = false;
    }

    private void vT() {
        if (this.ahZ) {
            return;
        }
        this.ahZ = true;
        this.bQ.sendEmptyMessage(1);
    }

    public final void vU() {
        vT();
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (this.ahY) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (bz.a(this.bP, (int) (this.aie * 100.0f), false)) {
                InterfaceC0364a interfaceC0364a = this.ahX;
                if (interfaceC0364a != null) {
                    interfaceC0364a.c(this.bP);
                    return;
                }
                return;
            }
            this.aia = 5;
            this.bQ.sendEmptyMessage(1);
            return;
        }
        if (bz.a(this.bP, (int) (this.aie * 100.0f), false)) {
            vS();
            if (this.aib) {
                InterfaceC0364a interfaceC0364a2 = this.ahX;
                if (interfaceC0364a2 != null) {
                    interfaceC0364a2.c(this.bP);
                }
            } else {
                this.aib = true;
                this.aic = System.currentTimeMillis();
                vR();
            }
            this.aid = false;
            ca caVar = this.bQ;
            int i2 = this.aia;
            this.aia = i2 - 1;
            caVar.sendEmptyMessageDelayed(1, i2 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC0364a interfaceC0364a3 = this.ahX;
        if (interfaceC0364a3 != null && !this.aid) {
            interfaceC0364a3.ay();
        }
        this.aid = true;
        ca caVar2 = this.bQ;
        int i3 = this.aia;
        this.aia = i3 - 1;
        caVar2.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
    }
}
