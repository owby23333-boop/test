package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends e implements com.kwad.sdk.core.j.c {
    private static long nA = 400;
    private com.kwad.components.ad.splashscreen.e.a Gy;
    private Vibrator gZ;

    protected abstract void fM();

    protected abstract void i(int i, String str);

    protected abstract void initView();

    protected abstract void mn();

    protected abstract void mo();

    protected abstract void mp();

    protected abstract void mq();

    protected abstract void mr();

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        if (this.Gf == null) {
            return;
        }
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        mp();
        mn();
        if (com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            ms();
        }
        mo();
        fM();
        this.Gf.Fs.a(this);
    }

    private void ms() {
        if (this.Gf != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Gy;
            if (aVar == null) {
                this.Gy = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Gf.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    public final void j(int i, String str) {
                        i.this.i(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(this.Gf.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Gf.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Gy);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.Gf != null && this.Gf.Fs != null) {
            this.Gf.Fs.b(this);
        }
        mr();
        bw.b(getContext(), this.gZ);
    }

    protected final void mt() {
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
        bw.a(getContext(), this.gZ);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        if (this.Gf.Fv) {
            return;
        }
        mq();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        mr();
    }
}
