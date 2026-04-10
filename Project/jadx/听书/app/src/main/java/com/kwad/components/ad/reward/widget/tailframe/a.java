package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements d {
    protected View EA;
    protected ImageView EB;
    private com.kwad.components.ad.widget.tailframe.appbar.a ED;
    private TailFrameBarH5View EE;
    private b EF;
    private TextProgressBar EG;
    private View EH;
    private int EI;
    private TextView gD;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g tm;

    public a(int i) {
        this.EI = i;
    }

    public final void setCallerContext(g gVar) {
        this.tm = gVar;
    }

    public void B(Context context) {
        View viewA = m.a(context, this.EI, null, false);
        this.EA = viewA;
        this.EB = (ImageView) viewA.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.EA.findViewById(R.id.ksad_video_tf_logo);
        this.ED = (com.kwad.components.ad.widget.tailframe.appbar.a) this.EA.findViewById(R.id.ksad_video_app_tail_frame);
        this.EE = (TailFrameBarH5View) this.EA.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void f(boolean z, boolean z2) {
        this.EE.g(z, z2);
    }

    public void a(AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.el(adTemplate);
        this.mReportExtData = jSONObject;
        this.EF = bVar;
        this.mLogoView.aP(this.mAdTemplate);
        lt();
        this.EA.setClickable(true);
        new h(this.EA, this);
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.dF(i), i);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.dG(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.cl(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.ED.D(a.this.mAdInfo);
                a.this.EG.e(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo), 0);
            }
        });
    }

    private void lr() {
        this.EA.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    public final View ls() {
        return this.EA;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.ED;
        if (aVar != null) {
            aVar.lv();
            this.ED.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.EE;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lv();
            this.EE.setVisibility(8);
        }
        lr();
    }

    public final void la() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.ED;
        if (aVar != null) {
            aVar.lv();
        }
        TailFrameBarH5View tailFrameBarH5View = this.EE;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lv();
        }
    }

    private void lt() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo) || e.O(this.mAdTemplate)) {
            this.ED.j(this.mAdTemplate);
            this.ED.setVisibility(0);
            this.EG = this.ED.getTextProgressBar();
            if (!e.O(this.mAdTemplate)) {
                this.EG.setClickable(true);
                new h(this.EG, this);
                bindDownloadListener();
                return;
            } else {
                View btnInstallContainer = this.ED.getBtnInstallContainer();
                this.EH = btnInstallContainer;
                btnInstallContainer.setClickable(true);
                new h(this.EH, this);
                return;
            }
        }
        this.EE.j(this.mAdTemplate);
        TextView h5OpenBtn = this.EE.getH5OpenBtn();
        this.gD = h5OpenBtn;
        h5OpenBtn.setClickable(true);
        this.EE.setVisibility(0);
        new h(this.gD, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.b.e.O(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = r2
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.tm
            android.view.View r3 = r5.EA
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.EH
            if (r6 != r4) goto L1d
            r1 = r2
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.aF(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.EG
            if (r6 != r0) goto L34
        L2d:
            r1 = r2
            goto L34
        L2f:
            android.widget.TextView r0 = r5.gD
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.aB(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = r2
            goto L4f
        L4e:
            r4 = r3
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.aA(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.az(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.EG
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = r3
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.aq(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.aB(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.a(r0)
            com.kwad.components.core.e.d.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.d(android.view.View, boolean):void");
    }
}
