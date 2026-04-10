package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends View implements ca.a {
    private boolean ahY;
    private boolean ahZ;
    private a ais;
    private boolean ait;
    private final int aiu;
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void fs();
    }

    public c(Context context, View view) {
        super(context);
        this.bQ = new ca(this);
        this.bR = new AtomicBoolean(true);
        this.aiu = (int) (com.kwad.sdk.core.config.e.FH() * 100.0f);
        this.bP = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public final void setViewCallback(a aVar) {
        this.ais = aVar;
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onAttachedToWindow:" + this);
        vT();
        this.ahY = false;
        vX();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onDetachedFromWindow" + this);
        vS();
        this.ahY = true;
        vY();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onFinishTemporaryDetach:" + this.bP.getParent());
        vX();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onStartTemporaryDetach:" + this.bP.getParent());
        vY();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    private void vX() {
        this.bR.getAndSet(false);
    }

    private void vY() {
        this.bR.getAndSet(true);
    }

    private void vS() {
        if (this.ahZ) {
            this.bQ.removeCallbacksAndMessages(null);
            this.ahZ = false;
        }
    }

    private void vT() {
        if (!this.ait || this.ahZ) {
            return;
        }
        this.ahZ = true;
        this.bQ.sendEmptyMessage(1);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.ait = z;
        if (!z && this.ahZ) {
            vS();
        } else {
            if (!z || this.ahZ) {
                return;
            }
            vT();
        }
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bz.a(this.bP, this.aiu, false)) {
                if (this.ahY) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.ais) != null) {
                    aVar.fs();
                }
                this.bQ.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.ahZ) {
            if (bz.a(this.bP, this.aiu, false)) {
                vS();
                Message messageObtainMessage = this.bQ.obtainMessage();
                messageObtainMessage.what = 2;
                messageObtainMessage.arg1 = 1000;
                this.bQ.sendMessageDelayed(messageObtainMessage, 1000L);
                return;
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
