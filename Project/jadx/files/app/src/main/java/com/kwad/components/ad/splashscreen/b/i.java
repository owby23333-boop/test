package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends e {
    private static long jY = 400;
    private com.kwad.components.ad.splashscreen.e.a CL;
    private Vibrator ef;

    private void ls() {
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.CL;
            if (aVar == null) {
                this.CL = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cx.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.i.1
                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void aa(String str) {
                        i.this.Z(str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cx.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.CL);
            }
        }
    }

    protected abstract void Z(String str);

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        if (this.Cx == null) {
            return;
        }
        lr();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        lo();
        ll();
        if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            ls();
        }
        lm();
        lp();
        lq();
        ln();
    }

    protected abstract void initView();

    protected abstract void ll();

    protected abstract void lm();

    protected abstract void ln();

    protected abstract void lo();

    protected abstract void lp();

    protected abstract void lq();

    protected abstract void lr();

    protected final void lt() {
        Context context = getContext();
        if (context != null) {
            this.ef = (Vibrator) context.getSystemService("vibrator");
        }
        bh.a(getContext(), this.ef);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        bh.b(getContext(), this.ef);
    }
}
