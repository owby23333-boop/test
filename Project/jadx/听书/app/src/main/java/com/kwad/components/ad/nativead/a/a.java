package com.kwad.components.ad.nativead.a;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Presenter {
    public l mVideoPlayStateListener;
    public b pq;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.pq = (b) NN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.pq.pr.a(this.mVideoPlayStateListener);
    }

    protected static void a(View view, String str) {
        if (view == null) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException(" findViewById failed " + str));
        }
    }
}
