package com.kwad.components.core.page.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Presenter {
    private int LA;
    private FeedVideoView LB;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Bs();
        KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        this.LB = (FeedVideoView) getRootView();
        this.LB.bindView(eVar.adTemplate);
        this.LB.a(ksAdVideoPlayConfigBuild, eVar.IZ);
        this.LB.setVisibility(0);
        final AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(eVar.adTemplate);
        this.LB.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
                    if (eVar.IZ != null) {
                        com.kwad.components.core.d.b.a.a(new a.C0395a(a.this.getActivity()).al(false).am(false).aq(true).J(eVar.adTemplate).ao(false));
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.LB.getTouchCoords());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.MV;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MV.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.MV.scrollToPosition(1);
                com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.LB.getTouchCoords());
            }
        });
        if (com.kwad.sdk.core.response.a.a.ai(adInfoCb)) {
            this.LB.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
                        if (eVar.IZ != null) {
                            com.kwad.components.core.d.b.a.a(new a.C0395a(a.this.getActivity()).al(false).am(false).aq(true).J(eVar.adTemplate).ao(false));
                            com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.LB.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.MV;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MV.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.MV.scrollToPosition(1);
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.LB.getTouchCoords());
                }
            });
        }
        this.LB.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.a.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oB() {
                RecyclerView recyclerView = eVar.MV;
                if (recyclerView != null) {
                    a.this.LA = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oC() {
                RecyclerView recyclerView = eVar.MV;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.LA);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.LB.release();
    }
}
