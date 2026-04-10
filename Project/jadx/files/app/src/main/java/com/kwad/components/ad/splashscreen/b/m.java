package com.kwad.components.ad.splashscreen.b;

import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends e {
    private com.kwad.components.ad.splashscreen.e.a CL;
    private AdMatrixInfo.SplashSlideInfo Dg;
    private TextView Dh;
    private ImageView Di;
    private com.kwad.components.ad.splashscreen.widget.c Dj;
    private KsSplashSlidePathView Dk;
    private com.kwad.components.core.d.b.c Dl;
    private double Dm;
    private TextView hb;
    private AdInfo mAdInfo;
    private AdBaseFrameLayout mRootContainer;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initView() {
        /*
            r3 = this;
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo r0 = r0.adMatrixInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$AdDataV2 r0 = r0.adDataV2
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashInfo r0 = r0.splashInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$AdInteractionInfo r0 = r0.interactionInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r0 = r0.slideInfo
            r3.Dg = r0
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r0 = r3.Dg
            int r1 = r0.convertDistance
            double r1 = (double) r1
            r3.Dm = r1
            int r0 = r0.style
            com.kwad.components.ad.splashscreen.widget.c r1 = new com.kwad.components.ad.splashscreen.widget.c
            android.content.Context r2 = r3.getContext()
            r1.<init>(r2, r0)
            r3.Dj = r1
            android.widget.ImageView r1 = r3.Di
            com.kwad.components.ad.splashscreen.widget.c r2 = r3.Dj
            r1.setImageDrawable(r2)
            android.widget.ImageView r1 = r3.Di
            com.kwad.components.ad.splashscreen.b.m$2 r2 = new com.kwad.components.ad.splashscreen.b.m$2
            r2.<init>()
            r1.post(r2)
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.Dg
            java.lang.String r1 = r1.title
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L47
            android.widget.TextView r0 = r3.hb
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.Dg
            java.lang.String r1 = r1.title
        L43:
            r0.setText(r1)
            goto L5f
        L47:
            if (r0 == 0) goto L5a
            r1 = 1
            if (r0 == r1) goto L55
            r1 = 2
            if (r0 == r1) goto L50
            goto L5f
        L50:
            android.widget.TextView r0 = r3.hb
            java.lang.String r1 = "向右滑动"
            goto L43
        L55:
            android.widget.TextView r0 = r3.hb
            java.lang.String r1 = "向左滑动"
            goto L43
        L5a:
            android.widget.TextView r0 = r3.hb
            java.lang.String r1 = "向上滑动"
            goto L43
        L5f:
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r0 = r3.Dg
            java.lang.String r0 = r0.subtitle
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L73
            android.widget.TextView r0 = r3.Dh
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.Dg
            java.lang.String r1 = r1.subtitle
        L6f:
            r0.setText(r1)
            goto L96
        L73:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.a.a.ay(r0)
            if (r0 == 0) goto L91
            com.kwad.components.ad.splashscreen.h r0 = r3.Cx
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.mAdTemplate
            com.kwad.sdk.core.response.model.AdInfo r1 = r3.mAdInfo
            com.kwad.components.core.d.b.c r2 = r3.Dl
            int r2 = r2.nw()
            java.lang.String r0 = com.kwad.components.ad.splashscreen.d.a(r0, r1, r2)
            android.widget.TextView r1 = r3.Dh
            r1.setText(r0)
            goto L96
        L91:
            android.widget.TextView r0 = r3.Dh
            java.lang.String r1 = "跳转详情页或者第三方应用"
            goto L6f
        L96:
            com.kwad.components.ad.splashscreen.h r0 = r3.Cx
            boolean r0 = com.kwad.components.ad.splashscreen.e.c.c(r0)
            if (r0 == 0) goto Laa
            int r0 = com.kwad.sdk.R.id.ksad_splash_slide_actiontext
            android.view.View r0 = r3.findViewById(r0)
            r1 = 60
            r2 = -1
            com.kwad.components.ad.splashscreen.e.c.a(r0, r2, r1, r2, r2)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.m.initView():void");
    }

    private void ly() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.CL;
        if (aVar != null) {
            aVar.setAdTemplate(this.Cx.mAdTemplate);
        } else {
            this.CL = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cx.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.m.3
                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void aa(String str) {
                    m.this.Dh.setText(str);
                }
            };
            this.Dl.b(this.CL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        if (this.Dg != null) {
            y.b bVar = new y.b();
            bVar.bt(this.Dg.style);
            com.kwad.sdk.core.report.a.a(this.Cx.mAdTemplate, 190, bVar, (JSONObject) null);
            com.kwad.components.ad.splashscreen.local.b.Y(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
        this.Dl = this.Cx.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            ly();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((ViewStub) findViewById(R.id.ksad_slide_layout)).inflate();
        this.hb = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.Dh = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.Di = (ImageView) findViewById(R.id.ksad_splash_slideView);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_splash_root_container);
        this.Dk = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.ksad_splash_slideTouchView)).inflate();
        this.Dk.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f2, float f3, float f4, float f5) {
                m mVar;
                com.kwad.components.ad.splashscreen.h hVar;
                final float fB = com.kwad.sdk.b.kwai.a.b(m.this.getContext(), (float) Math.sqrt(Math.pow(f4 - f2, 2.0d) + Math.pow(f5 - f3, 2.0d)));
                if (fB < m.this.Dm || (hVar = (mVar = m.this).Cx) == null) {
                    return;
                }
                hVar.a(1, mVar.getContext(), TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1.1
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.bn(m.this.Dg.style);
                        iVar.bo((int) fB);
                    }
                });
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void lA() {
                m mVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (!o.o(m.this.mAdInfo) || (hVar = (mVar = m.this).Cx) == null) {
                    return;
                }
                hVar.c(1, mVar.getContext(), 53, 2);
            }
        });
    }
}
