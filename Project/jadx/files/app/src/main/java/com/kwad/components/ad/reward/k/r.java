package com.kwad.components.ad.reward.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: classes3.dex */
public class r extends w implements View.OnClickListener {
    protected KSCornerButton Ac;
    protected KsConvertButton Ad;
    protected View Ae;
    protected TextView Af;

    @Nullable
    protected TextView Ag;
    protected a Ah;

    @LayoutRes
    protected int Ai = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Aj = true;
    protected KsLogoView mLogoView;
    protected TextView oC;
    protected ImageView oF;

    @Nullable
    protected KsAppTagsView yg;

    public interface a {
        void ir();

        void is();

        void it();

        void iu();
    }

    private void X(int i2) {
        KSCornerButton kSCornerButton = this.Ac;
        if (kSCornerButton == null || this.Ad == null) {
            return;
        }
        if (i2 == 1) {
            kSCornerButton.getCornerConf().setAllCorner(true);
            this.Ad.getCornerConf().setAllCorner(true);
            this.Ae.setVisibility(0);
        } else if (i2 == 2) {
            kSCornerButton.getCornerConf().bF(true).bI(true).bH(false).bG(false);
            this.Ad.getCornerConf().bF(false).bI(false).bH(true).bG(true);
            this.Ae.setVisibility(8);
        }
        this.Ac.postInvalidate();
        this.Ad.postInvalidate();
    }

    public final void a(a aVar) {
        this.Ah = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        a(com.kwad.components.ad.reward.model.a.a(vVar, this.Aj));
    }

    protected void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i2;
        int i3;
        if (aVar == null || this.Ac == null) {
            return;
        }
        X(aVar.hv());
        this.mLogoView.U(aVar.hs());
        this.oC.setText(aVar.getTitle());
        this.Af.setText(aVar.gE());
        TextView textView2 = this.Ag;
        if (textView2 != null) {
            textView2.setText(aVar.gE());
            if (TextUtils.isEmpty(aVar.gE())) {
                i3 = 8;
            } else if (aVar.hu()) {
                i3 = 8;
                i2 = 0;
                this.Af.setVisibility(i3);
                textView = this.Ag;
            } else {
                i3 = 0;
            }
            i2 = 8;
            this.Af.setVisibility(i3);
            textView = this.Ag;
        } else {
            textView = this.Af;
            i2 = TextUtils.isEmpty(aVar.gE()) ? 8 : 0;
        }
        textView.setVisibility(i2);
        KsAppTagsView ksAppTagsView = this.yg;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.ht(), this.Ai);
            this.yg.setVisibility(aVar.hu() ? 8 : 0);
        }
        this.Ad.a(aVar.fx(), aVar.hs());
        KSImageLoader.loadAppIcon(this.oF, aVar.fo(), aVar.hs(), 12);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, kq(), kr());
        g(this.sN);
        ViewGroup viewGroup2 = this.sN;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.Ac.setOnClickListener(this);
            this.Ad.setOnClickListener(this);
        }
    }

    protected void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_reward_playable_logo);
        this.oF = (ImageView) viewGroup.findViewById(R.id.ksad_reward_playable_icon);
        this.oC = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_name);
        this.yg = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_reward_playable_tags);
        this.Af = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc);
        this.Ag = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc2);
        this.Ac = (KSCornerButton) viewGroup.findViewById(R.id.ksad_reward_playable_install_try);
        this.Ad = (KsConvertButton) viewGroup.findViewById(R.id.ksad_reward_playable_action);
        this.Ae = viewGroup.findViewById(R.id.ksad_reward_playable_middle_divider);
    }

    protected int kq() {
        return R.id.ksad_reward_playable_card_stub;
    }

    protected int kr() {
        return R.id.ksad_reward_playable_card_root;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.Ac)) {
            a aVar2 = this.Ah;
            if (aVar2 != null) {
                aVar2.is();
                return;
            }
            return;
        }
        if (view.equals(this.Ad)) {
            a aVar3 = this.Ah;
            if (aVar3 != null) {
                aVar3.it();
                return;
            }
            return;
        }
        if (!view.equals(this.sN) || (aVar = this.Ah) == null) {
            return;
        }
        aVar.iu();
    }

    public final void show() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            a aVar = this.Ah;
            if (aVar != null) {
                aVar.ir();
            }
        }
    }
}
