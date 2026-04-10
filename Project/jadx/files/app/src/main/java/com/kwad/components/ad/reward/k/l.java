package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends d implements View.OnClickListener {
    private ImageView fo;
    private TextView hb;
    private k.a qB;
    private DialogFragment yS;
    private View yV;
    private ViewGroup zk;
    private View zl;
    private TextView zm;
    private TextView zn;
    private TextView zo;
    private View zp;

    public l(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, k.a aVar) {
        this.yS = dialogFragment;
        this.qB = aVar;
        if (com.kwad.sdk.core.response.a.a.co(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            this.zk = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            s(true);
        } else {
            this.zk = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            s(false);
        }
    }

    private void s(boolean z2) {
        this.zl = this.zk.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.hb = (TextView) this.zk.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.fo = (ImageView) this.zk.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.zn = (TextView) this.zk.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.zm = (TextView) this.zk.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.yV = this.zk.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.zp = this.zk.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.zo = (TextView) this.zk.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z2) {
            this.zl.setVisibility(8);
        }
        this.zl.setOnClickListener(this);
        this.yV.setOnClickListener(this);
        this.zp.setOnClickListener(this);
        this.zo.setOnClickListener(this);
    }

    public final void a(k.c cVar) {
        KSImageLoader.loadCircleIcon(this.fo, cVar.fo(), this.zk.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.hb != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = hc().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.hb.setText(spannableString);
        }
        this.zm.setText(cVar.gE());
        this.zn.setText(cVar.gF());
        this.zo.setText(String.format("%s", cVar.qK));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.zk;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k.a aVar;
        if (view.equals(this.zl)) {
            this.yS.dismiss();
            k.a aVar2 = this.qB;
            if (aVar2 != null) {
                aVar2.gz();
                return;
            }
            return;
        }
        if (view.equals(this.yV)) {
            this.yS.dismiss();
            k.a aVar3 = this.qB;
            if (aVar3 != null) {
                aVar3.gz();
                return;
            }
            return;
        }
        if (!view.equals(this.zp)) {
            if (!view.equals(this.zo) || (aVar = this.qB) == null) {
                return;
            }
            aVar.g(131, 2);
            return;
        }
        this.yS.dismiss();
        k.a aVar4 = this.qB;
        if (aVar4 != null) {
            aVar4.J(false);
        }
    }
}
