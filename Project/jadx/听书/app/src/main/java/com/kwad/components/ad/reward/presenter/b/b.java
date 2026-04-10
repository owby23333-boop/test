package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest iS;
    private long jY;
    private p se;
    private View xj;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        public final /* synthetic */ BaseResultData parseData(String str) {
            return W(str);
        }

        private static AdLiveEndResultData W(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* JADX INFO: renamed from: cM, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.iS);
        }
    };
    private final m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.jY = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.iZ();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.ja();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.ja();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        com.kwad.components.core.o.a.b.a aVar;
        super.at();
        if (this.tm.rE.kW()) {
            this.tm.rE.a(this.vR);
            String strBh = com.kwad.sdk.core.response.b.a.bh(e.el(this.tm.mAdTemplate));
            if (TextUtils.isEmpty(strBh) || (aVar = (com.kwad.components.core.o.a.b.a) d.f(com.kwad.components.core.o.a.b.a.class)) == null) {
                return;
            }
            this.iS = aVar.getAdLiveEndRequest(strBh);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.tm.rE.kW()) {
            this.tm.rE.b(this.vR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        if (this.iS == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.liveEnd.a aVar, final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.tm.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (b.this.se == null) {
                            b.this.se = new p(b.this.tm);
                        }
                        b.this.se.h(b.this.tm.mRootContainer);
                        b.this.se.b(r.aa(b.this.tm.mAdTemplate));
                        b.this.se.a(b.this.tm, adLiveEndResultData.mQLivePushEndInfo, b.this.jY);
                        b.this.tm.se = b.this.se;
                        if (b.this.tm.mContext.getResources().getConfiguration().orientation == 2) {
                            b.this.xj = b.this.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b.this.xj = b.this.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.xj.setVisibility(0);
                        b.this.iI();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.liveEnd.a aVar, int i, String str) {
                super.onError(aVar, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        View view = this.xj;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0392a c0392a = new a.C0392a();
        bVar.dm(24);
        bVar.b(c0392a);
        com.kwad.components.ad.reward.j.b.a(true, this.tm.mAdTemplate, null, bVar);
    }
}
