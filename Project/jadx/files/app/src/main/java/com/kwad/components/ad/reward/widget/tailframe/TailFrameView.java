package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a Bx;
    private j qS;

    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.Bo, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private ImageView BA;
        private ImageView By;
        private ImageView Bz;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void kB() {
            KSImageLoader.loadImage(this.By, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Bz, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BA, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void D(Context context) {
            super.D(context);
            this.By = (ImageView) this.Bn.findViewById(R.id.ksad_video_thumb_left);
            this.Bz = (ImageView) this.Bn.findViewById(R.id.ksad_video_thumb_mid);
            this.BA = (ImageView) this.Bn.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            kB();
        }
    }

    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private View BB;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void kB() {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
            int i2 = materialFeatureAO.width;
            int i3 = materialFeatureAO.height;
            int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(this.Bn.getContext());
            int i4 = (int) (screenWidth * (i3 / i2));
            ViewGroup.LayoutParams layoutParams = this.Bo.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i4;
            KSImageLoader.loadImage(this.Bo, materialFeatureAO.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void D(Context context) {
            super.D(context);
            this.BB = this.Bn.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.q(this.mAdTemplate)) {
                this.BB.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.Bn.setBackground(null);
            }
            kB();
        }
    }

    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.q(this.mAdTemplate)) {
                this.Bn.setBackground(null);
                this.Bo.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.Bo, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }

    private void d(boolean z2, boolean z3) {
        if (this.Bx != null) {
            return;
        }
        this.Bx = z2 ? z3 ? new d() : new c() : z3 ? new b() : new a();
    }

    public final void a(Context context, boolean z2, boolean z3) {
        d(z2, z3);
        this.Bx.D(context);
        this.Bx.d(z2, z3);
        addView(this.Bx.kx(), -1, -1);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.Bx.setCallerContext(this.qS);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Bx;
        j jVar = this.qS;
        aVar.a(jVar.mAdTemplate, jVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Bx;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void kc() {
        this.Bx.kc();
    }

    public void setCallerContext(j jVar) {
        this.qS = jVar;
    }
}
