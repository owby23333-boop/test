package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    protected View Bn;
    protected ImageView Bo;
    private com.kwad.components.ad.widget.tailframe.appbar.a Bp;
    private TailFrameBarH5View Bq;
    private b Br;
    private TextProgressBar Bs;
    private View Bt;
    private int Bu;
    private TextView dQ;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private j qS;

    public a(int i2) {
        this.Bu = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.a.d.q(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.j r0 = r5.qS
            android.view.View r3 = r5.Bn
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.Bt
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.a.a.ay(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.Bs
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.dQ
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.d.b.a$a r0 = new com.kwad.components.core.d.b.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.d.b.a$a r0 = r0.J(r3)
            com.kwad.components.core.d.b.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.d.b.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.d.b.a$a r0 = r0.ao(r4)
            com.kwad.components.core.d.b.a$a r0 = r0.an(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.Bs
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.d.b.a$a r6 = r0.al(r2)
            com.kwad.components.core.d.b.a$a r6 = r6.ap(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.d.b.a$a r6 = r6.a(r0)
            com.kwad.components.core.d.b.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.ax(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.aI(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.ax(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.U(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.bv(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                a.this.Bp.x(a.this.mAdInfo);
                a.this.Bs.f(com.kwad.sdk.core.response.a.a.bu(i2), i2);
            }
        });
    }

    private void kw() {
        this.Bn.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void ky() {
        if (!com.kwad.sdk.core.response.a.a.ay(this.mAdInfo) && !d.q(this.mAdTemplate)) {
            this.Bq.bindView(this.mAdTemplate);
            this.dQ = this.Bq.getH5OpenBtn();
            this.dQ.setClickable(true);
            this.Bq.setVisibility(0);
            new f(this.dQ, this);
            return;
        }
        this.Bp.bindView(this.mAdTemplate);
        this.Bp.setVisibility(0);
        this.Bs = this.Bp.getTextProgressBar();
        if (d.q(this.mAdTemplate)) {
            this.Bt = this.Bp.getBtnInstallContainer();
            this.Bt.setClickable(true);
            new f(this.Bt, this);
        } else {
            this.Bs.setClickable(true);
            new f(this.Bs, this);
            bindDownloadListener();
        }
    }

    public void D(Context context) {
        this.Bn = com.kwad.sdk.i.a.a(context, this.Bu, null, false);
        this.Bo = (ImageView) this.Bn.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.Bn.findViewById(R.id.ksad_video_tf_logo);
        this.Bp = (com.kwad.components.ad.widget.tailframe.appbar.a) this.Bn.findViewById(R.id.ksad_video_app_tail_frame);
        this.Bq = (TailFrameBarH5View) this.Bn.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.mReportExtData = jSONObject;
        this.Br = bVar;
        this.mLogoView.U(this.mAdTemplate);
        ky();
        this.Bn.setClickable(true);
        new f(this.Bn, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void d(boolean z2, boolean z3) {
        this.Bq.e(z2, z3);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Bp;
        if (aVar != null) {
            aVar.kA();
            this.Bp.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.Bq;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kA();
            this.Bq.setVisibility(8);
        }
        kw();
    }

    public final void kc() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Bp;
        if (aVar != null) {
            aVar.kA();
        }
        TailFrameBarH5View tailFrameBarH5View = this.Bq;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kA();
        }
    }

    public final View kx() {
        return this.Bn;
    }

    public final void setCallerContext(j jVar) {
        this.qS = jVar;
    }
}
