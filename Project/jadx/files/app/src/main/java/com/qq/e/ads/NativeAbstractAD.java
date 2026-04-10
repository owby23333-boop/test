package com.qq.e.ads;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownAPPConfirmPolicy f17698f;

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(T t2) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f17698f;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f17698f = downAPPConfirmPolicy;
        T t2 = this.a;
        if (t2 == null || downAPPConfirmPolicy == null) {
            return;
        }
        t2.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
