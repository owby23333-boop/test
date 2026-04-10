package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a EL;
    private g tm;

    public TailFrameView(Context context) {
        super(context);
    }

    public TailFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TailFrameView(Context context, View view) {
        super(context, view);
    }

    public void setCallerContext(g gVar) {
        this.tm = gVar;
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.EL.setCallerContext(this.tm);
        this.EL.a(this.tm.mAdTemplate, this.tm.mReportExtData, bVar);
    }

    public final void a(Context context, boolean z, boolean z2) {
        f(z, z2);
        this.EL.B(context);
        this.EL.f(z, z2);
        addView(this.EL.ls(), -1, -1);
    }

    public final void la() {
        this.EL.la();
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.EL;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    private void f(boolean z, boolean z2) {
        if (this.EL != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.EL = new d();
                return;
            } else {
                this.EL = new c();
                return;
            }
        }
        if (z2) {
            this.EL = new b();
        } else {
            this.EL = new a();
        }
    }

    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.O(this.mAdTemplate)) {
                this.EA.setBackground(null);
                this.EB.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.EB, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private View EP;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.EP = this.EA.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.O(this.mAdTemplate)) {
                this.EP.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.EA.setBackground(null);
            }
            lw();
        }

        private void lw() {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
            int i = materialFeatureAX.width;
            int i2 = materialFeatureAX.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.EA.getContext());
            int i3 = (int) (screenWidth * (i2 / i));
            ViewGroup.LayoutParams layoutParams = this.EB.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i3;
            KSImageLoader.loadImage(this.EB, materialFeatureAX.coverUrl, this.mAdTemplate);
        }
    }

    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private ImageView EM;
        private ImageView EN;
        private ImageView EO;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.EM = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_left);
            this.EN = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_mid);
            this.EO = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            lw();
        }

        private void lw() {
            KSImageLoader.loadImage(this.EM, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.EN, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.EO, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.EB, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }
}
