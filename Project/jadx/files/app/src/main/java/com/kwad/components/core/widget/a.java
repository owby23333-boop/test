package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class a extends KSFrameLayout implements bk.a {
    private final View Ru;
    private InterfaceC0421a VA;
    private boolean VB;
    private boolean VC;
    private int VD;
    private boolean VE;
    private long VF;
    private boolean VG;
    private final float VH;
    private final int VI;
    private final bk gH;

    /* JADX INFO: renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0421a {
        void eM();

        void k(View view);

        void onViewDetached();
    }

    public a(Context context, View view) {
        super(context, view);
        this.gH = new bk(this);
        this.VD = 5;
        this.Ru = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        this.VH = com.kwad.sdk.core.config.d.uR();
        setVisiblePercent(this.VH);
        float fUS = com.kwad.sdk.core.config.d.uS();
        this.VI = (int) ((fUS < 0.0f ? 1.0f : fUS) * 1000.0f);
    }

    private void rH() {
        InterfaceC0421a interfaceC0421a;
        if (this.VI == 0 && (interfaceC0421a = this.VA) != null) {
            interfaceC0421a.k(this.Ru);
            return;
        }
        Message messageObtainMessage = this.gH.obtainMessage();
        messageObtainMessage.what = 2;
        this.gH.sendMessageDelayed(messageObtainMessage, this.VI);
    }

    private void rI() {
        this.gH.removeCallbacksAndMessages(null);
        this.VC = false;
    }

    private void rJ() {
        if (this.VC) {
            return;
        }
        this.VC = true;
        this.gH.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (this.VB) {
            return;
        }
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.Ru, (int) (this.VH * 100.0f), false)) {
                this.VD = 5;
                this.gH.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0421a interfaceC0421a = this.VA;
                if (interfaceC0421a != null) {
                    interfaceC0421a.k(this.Ru);
                    return;
                }
                return;
            }
        }
        com.kwad.sdk.core.d.b.d("AdExposureView", "handleMsg MSG_CHECKING");
        if (!com.kwad.sdk.b.kwai.a.a(this.Ru, (int) (this.VH * 100.0f), false)) {
            InterfaceC0421a interfaceC0421a2 = this.VA;
            if (interfaceC0421a2 != null && !this.VG) {
                interfaceC0421a2.eM();
            }
            this.VG = true;
            bk bkVar = this.gH;
            int i3 = this.VD;
            this.VD = i3 - 1;
            bkVar.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
            return;
        }
        rI();
        if (this.VE) {
            InterfaceC0421a interfaceC0421a3 = this.VA;
            if (interfaceC0421a3 != null) {
                interfaceC0421a3.k(this.Ru);
            }
        } else {
            this.VE = true;
            this.VF = System.currentTimeMillis();
            rH();
        }
        this.VG = false;
        bk bkVar2 = this.gH;
        int i4 = this.VD;
        this.VD = i4 - 1;
        bkVar2.sendEmptyMessageDelayed(1, i4 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void onFirstVisible(View view) {
        InterfaceC0421a interfaceC0421a;
        InterfaceC0421a interfaceC0421a2;
        super.onFirstVisible(view);
        if (this.VI == 0 && (interfaceC0421a2 = this.VA) != null) {
            interfaceC0421a2.k(view);
            return;
        }
        if (!this.VE) {
            this.VE = true;
            this.VF = System.currentTimeMillis();
            rI();
            rH();
            return;
        }
        if (System.currentTimeMillis() - this.VF <= this.VI || (interfaceC0421a = this.VA) == null) {
            return;
        }
        interfaceC0421a.k(view);
        rI();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.VD = 5;
        this.VB = false;
        this.VE = false;
        rJ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        rI();
        this.VD = 0;
        this.VF = 0L;
        this.VB = true;
        InterfaceC0421a interfaceC0421a = this.VA;
        if (interfaceC0421a != null) {
            interfaceC0421a.onViewDetached();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        com.kwad.sdk.core.d.b.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z2);
    }

    public final void rK() {
        rJ();
    }

    public final void setViewCallback(InterfaceC0421a interfaceC0421a) {
        this.VA = interfaceC0421a;
    }
}
