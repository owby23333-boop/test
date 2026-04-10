package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    private static int ls = 8;
    protected ComplianceTextView cq;
    protected DownloadProgressView eG;
    protected TextView oC;
    protected TextView oD;
    protected TextView oE;
    protected ImageView oF;
    protected ImageView oG;
    protected KsLogoView oH;
    private com.kwad.components.ad.reflux.a oI;
    private b.InterfaceC0422b oJ;

    public a(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    private void bC() {
        b.InterfaceC0422b interfaceC0422b;
        com.kwad.components.ad.reflux.a aVar = this.oI;
        if (aVar == null) {
            return;
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.mPvReported && (interfaceC0422b = this.oJ) != null) {
            interfaceC0422b.onAdShow();
        }
        i iVar = new i();
        com.kwad.components.ad.reflux.a aVar2 = this.oI;
        if (aVar2 != null) {
            iVar.bl(aVar2.ft());
        }
        com.kwad.components.core.r.c.qa().a(adTemplate, null, iVar);
    }

    private void c(int i2, boolean z2) {
        com.kwad.components.ad.reflux.a aVar = this.oI;
        if (aVar == null) {
            return;
        }
        final AdTemplate adTemplate = aVar.getAdTemplate();
        com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).J(adTemplate).b(this.oI.fx()).ap(i2).an(7).ao(i2 == 1 ? 1 : 0).al(true).a(new a.b() { // from class: com.kwad.components.ad.reflux.kwai.a.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                a.this.l(adTemplate);
            }
        }));
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        O(context);
        DownloadProgressView downloadProgressView = this.eG;
        if (downloadProgressView != null) {
            downloadProgressView.setOnClickListener(this);
        }
        setOnClickListener(this);
    }

    protected abstract void O(@NonNull Context context);

    public void a(com.kwad.components.ad.reflux.a aVar) {
        if (aVar == null) {
            return;
        }
        this.oI = aVar;
        if (this.oC != null && aVar.getTitle() != null) {
            this.oC.setText(aVar.getTitle());
        }
        if (this.oD != null && aVar.fp() != null) {
            this.oD.setText(aVar.fp());
        }
        if (this.oE != null && aVar.fq() != null) {
            this.oE.setText(aVar.fq());
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (adTemplate != null) {
            if (this.oF != null && aVar.fo() != null) {
                KSImageLoader.loadAppIcon(this.oF, aVar.fo(), adTemplate, ls);
            }
            if (this.oG != null && aVar.fr() != null) {
                KSImageLoader.loadImage(this.oG, aVar.fr(), adTemplate);
            }
            KsLogoView ksLogoView = this.oH;
            if (ksLogoView != null) {
                ksLogoView.U(adTemplate);
            }
            ComplianceTextView complianceTextView = this.cq;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(adTemplate);
            }
            DownloadProgressView downloadProgressView = this.eG;
            if (downloadProgressView != null) {
                downloadProgressView.E(adTemplate);
            }
            AdInfo adInfoCb = d.cb(adTemplate);
            DownloadProgressView downloadProgressView2 = this.eG;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(adInfoCb, aVar.fv(), aVar.fw());
            }
        }
    }

    protected final void l(AdTemplate adTemplate) {
        i iVarC = new i().c(getTouchCoords());
        com.kwad.components.ad.reflux.a aVar = this.oI;
        if (aVar != null) {
            iVarC.bl(aVar.ft());
        }
        com.kwad.sdk.core.report.a.a(adTemplate, iVarC, (JSONObject) null);
        b.InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onAdClicked();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.eG)) {
            c(1, true);
        } else if (view.equals(this)) {
            c(3, true);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public void onFirstVisible(View view) {
        super.onFirstVisible(view);
        com.kwad.sdk.core.d.b.d("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
        bC();
    }

    public void setAdClickListener(b.InterfaceC0422b interfaceC0422b) {
        this.oJ = interfaceC0422b;
    }
}
