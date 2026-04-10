package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class c extends View implements bk.a {
    private View Ru;
    private boolean VB;
    private boolean VC;
    private a VX;
    private boolean VY;
    private final int VZ;
    private final bk gH;
    private final AtomicBoolean mIsViewDetached;

    public interface a {
        void eN();
    }

    public c(Context context, View view) {
        super(context);
        this.gH = new bk(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.VZ = (int) (com.kwad.sdk.core.config.d.uR() * 100.0f);
        this.Ru = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void rI() {
        if (this.VC) {
            this.gH.removeCallbacksAndMessages(null);
            this.VC = false;
        }
    }

    private void rJ() {
        if (!this.VY || this.VC) {
            return;
        }
        this.VC = true;
        this.gH.sendEmptyMessage(1);
    }

    private void viewAttached() {
        this.mIsViewDetached.getAndSet(false);
    }

    private void viewDetached() {
        this.mIsViewDetached.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        a aVar;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.Ru, this.VZ, false)) {
                if (this.VB) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.VX) != null) {
                    aVar.eN();
                }
                this.gH.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.b.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.VC) {
            if (!com.kwad.sdk.b.kwai.a.a(this.Ru, this.VZ, false)) {
                this.gH.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            rI();
            Message messageObtainMessage = this.gH.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.arg1 = 1000;
            this.gH.sendMessageDelayed(messageObtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.d("EmptyView", "onAttachedToWindow:" + this);
        rJ();
        this.VB = false;
        viewAttached();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.d("EmptyView", "onDetachedFromWindow" + this);
        rI();
        this.VB = true;
        viewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.d("EmptyView", "onFinishTemporaryDetach:" + this.Ru.getParent());
        viewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.d("EmptyView", "onStartTemporaryDetach:" + this.Ru.getParent());
        viewDetached();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        com.kwad.sdk.core.d.b.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z2);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.b.d("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public final void setNeedCheckingShow(boolean z2) {
        this.VY = z2;
        if (!z2 && this.VC) {
            rI();
        } else {
            if (!z2 || this.VC) {
                return;
            }
            rJ();
        }
    }

    public final void setViewCallback(a aVar) {
        this.VX = aVar;
    }
}
