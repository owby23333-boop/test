package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class h extends s implements View.OnClickListener {
    protected ImageView BA;
    protected KsAppTagsView BE;
    protected KsConvertButton BV;
    protected TextView BW;
    protected TextView BX;
    protected TextView BY;
    protected a BZ;
    protected int Ca = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Cb = true;
    protected KsLogoView mLogoView;

    public interface a {
        void jk();

        void jl();

        void jm();

        void jn();

        void jo();

        void jp();
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, jj(), le());
        g(this.vV);
        if (this.vV != null) {
            this.vV.setOnClickListener(this);
            this.BV.setOnClickListener(this);
            this.BA.setOnClickListener(this);
            this.BW.setOnClickListener(this);
            TextView textView = this.BX;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.BY;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.BE;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    protected int jj() {
        return R.id.ksad_common_app_card_stub;
    }

    private static int le() {
        return R.id.ksad_common_app_card_root;
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.BA = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.BW = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.BE = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.BX = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.BY = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.BV = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    public final void a(a aVar) {
        this.BZ = aVar;
    }

    public final void show() {
        if (this.vV != null) {
            this.vV.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Cb));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.im()
            r5.ag(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.ii()
            r0.aP(r1)
        L15:
            android.widget.TextView r0 = r5.BW
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.BX
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.hp()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.BY
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L59
            java.lang.String r3 = r6.hp()
            r0.setText(r3)
            java.lang.String r0 = r6.hp()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L44
            r0 = r2
            r3 = r0
            goto L4f
        L44:
            boolean r0 = r6.il()
            if (r0 == 0) goto L4d
            r3 = r1
            r0 = r2
            goto L4f
        L4d:
            r0 = r1
            r3 = r2
        L4f:
            android.widget.TextView r4 = r5.BX
            if (r4 == 0) goto L56
            r4.setVisibility(r0)
        L56:
            android.widget.TextView r0 = r5.BY
            goto L6a
        L59:
            android.widget.TextView r0 = r5.BX
            if (r0 == 0) goto L6d
            java.lang.String r3 = r6.hp()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L69
            r3 = r2
            goto L6a
        L69:
            r3 = r1
        L6a:
            r0.setVisibility(r3)
        L6d:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.BE
            if (r0 == 0) goto L86
            java.util.List r3 = r6.ik()
            int r4 = r5.Ca
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.BE
            boolean r3 = r6.il()
            if (r3 == 0) goto L83
            r1 = r2
        L83:
            r0.setVisibility(r1)
        L86:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.BV
            if (r0 == 0) goto L95
            com.kwad.components.core.e.d.c r1 = r6.ij()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.ii()
            r0.a(r1, r2)
        L95:
            android.widget.ImageView r0 = r5.BA
            java.lang.String r1 = r6.ho()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.ii()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }

    private void ag(int i) {
        KsConvertButton ksConvertButton = this.BV;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().cp(false).cs(false).cr(true).cq(true);
        }
        this.BV.postInvalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.BV)) {
            a aVar2 = this.BZ;
            if (aVar2 != null) {
                aVar2.jk();
                return;
            }
            return;
        }
        if (view.equals(this.BA)) {
            a aVar3 = this.BZ;
            if (aVar3 != null) {
                aVar3.jl();
                return;
            }
            return;
        }
        if (view.equals(this.BW)) {
            a aVar4 = this.BZ;
            if (aVar4 != null) {
                aVar4.jm();
                return;
            }
            return;
        }
        if (view.equals(this.BX) || view.equals(this.BY)) {
            a aVar5 = this.BZ;
            if (aVar5 != null) {
                aVar5.jn();
                return;
            }
            return;
        }
        if (view.equals(this.BE)) {
            a aVar6 = this.BZ;
            if (aVar6 != null) {
                aVar6.jo();
                return;
            }
            return;
        }
        if (!view.equals(this.vV) || (aVar = this.BZ) == null) {
            return;
        }
        aVar.jp();
    }
}
