package com.kwad.components.core.page.c;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Presenter {
    private int Ty;
    private FeedVideoView Tz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) NN();
        KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Tz = feedVideoView;
        feedVideoView.d(com.kwad.sdk.core.response.b.c.dW(eVar.adTemplate));
        this.Tz.a(ksAdVideoPlayConfigBuild, eVar.Pc);
        this.Tz.setVisibility(0);
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(eVar.adTemplate);
        this.Tz.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
                        if (eVar.Pc != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0333a(a.this.getActivity()).aq(false).ar(false).av(true).aB(eVar.adTemplate).at(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Tz.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    if (eVar.Vb == null || eVar.Vb.getAdapter() == null || eVar.Vb.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.Vb.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Tz.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aq(adInfoEl)) {
            this.Tz.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
                            if (eVar.Pc != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0333a(a.this.getActivity()).aq(false).ar(false).av(true).aB(eVar.adTemplate).at(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, a.this.Tz.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        if (eVar.Vb == null || eVar.Vb.getAdapter() == null || eVar.Vb.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        eVar.Vb.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, a.this.Tz.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.Tz.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rb() {
                if (eVar.Vb != null) {
                    a.this.Ty = eVar.Vb.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void rc() {
                if (eVar.Vb != null) {
                    eVar.Vb.scrollToPosition(a.this.Ty);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Tz.release();
    }
}
