package com.kwad.components.ad.reward.k;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends r {

    @IdRes
    private int Ak;
    private ImageView Al;

    @Nullable
    private com.kwad.components.ad.reward.model.a Am;
    private View An;

    public s(@IdRes int i2) {
        this.Ak = i2;
        this.Ai = R.layout.ksad_reward_apk_info_card_tag_white_item;
        this.Aj = false;
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final void a(com.kwad.components.ad.reward.model.a aVar) {
        super.a(aVar);
        this.Am = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void ad(boolean z2) {
        super.ad(z2);
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        Resources resources = viewGroup.getResources();
        ImageView imageView = this.oF;
        if (imageView != null && this.Am != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int i2 = 18;
            if (layoutParams != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size);
                if (!z2) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_horizontal);
                    i2 = 14;
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.oF.setLayoutParams(layoutParams);
                KSImageLoader.loadAppIcon(this.oF, this.Am.fo(), this.Am.hs(), i2);
            }
        }
        TextView textView = this.Af;
        if (textView != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.Am != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Af.getLayoutParams();
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_desc_margin_top_small);
            if (!this.Am.hu() && z2) {
                dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_desc_margin_top);
            }
            marginLayoutParams.topMargin = dimensionPixelSize2;
            this.Af.setLayoutParams(marginLayoutParams);
        }
        View view = this.An;
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || this.Am == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.An.getLayoutParams();
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_btn_margin_top_small);
        if (z2) {
            dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_btn_margin_top);
        }
        marginLayoutParams2.topMargin = dimensionPixelSize3;
        this.An.setLayoutParams(marginLayoutParams2);
    }

    public final void d(AdTemplate adTemplate, boolean z2) {
        ImageView imageView = this.Al;
        if (imageView == null || adTemplate == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(this.Al, com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.cb(adTemplate)), adTemplate);
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_playabale_logo);
        this.oF = (ImageView) viewGroup.findViewById(R.id.ksad_playabale_end_icon);
        this.oC = (TextView) viewGroup.findViewById(R.id.ksad_playabale_end_title);
        this.yg = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_playable_end_tags);
        this.Af = (TextView) viewGroup.findViewById(R.id.ksad_playabale_end_desc);
        this.Ac = (KSCornerButton) viewGroup.findViewById(R.id.ksad_playabale_try);
        this.Ad = (KsConvertButton) viewGroup.findViewById(R.id.ksad_playabale_end_btn_action);
        this.Ae = viewGroup.findViewById(R.id.ksad_playabale_middle_divider);
        this.Al = (ImageView) viewGroup.findViewById(R.id.ksad_playabale_end_blur_img);
        this.An = viewGroup.findViewById(R.id.ksad_playabale_end_btn_container);
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final int kq() {
        return this.Ak;
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final int kr() {
        return R.id.ksad_playabale_end_card;
    }
}
