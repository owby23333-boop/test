package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String Eg;
    private String Eh;
    private ProgressBar Ei;
    private TextView Ej;
    private long Ek;
    private long El;
    private boolean Em;
    private a En;
    private ImageView cw;
    private TextView vW;

    public interface a {
        void G(boolean z);

        void H(boolean z);
    }

    public RewardPreviewTopBarView(Context context) {
        super(context);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Ei = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.vW = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Ej = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.cw = imageView;
        imageView.setVisibility(8);
        this.cw.setOnClickListener(this);
    }

    public void setRewardTips(String str) {
        TextView textView = this.vW;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setCloseBtnDelayShowDuration(long j) {
        this.El = j;
        if (j <= 0) {
            this.cw.setVisibility(0);
        }
    }

    public void setTotalCountDuration(long j) {
        this.Ek = j;
        this.Ei.setMax((int) j);
    }

    public void setTopBarListener(a aVar) {
        this.En = aVar;
    }

    public final void s(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        TextView textView = this.Ej;
        if (textView != null) {
            textView.setText(iCeil + this.Eg);
        }
        e(j, this.Ek);
        if (this.Ek - j >= this.El && this.cw.getVisibility() != 0) {
            this.cw.setVisibility(0);
        }
        if (iCeil <= 0) {
            e(true, false);
        }
    }

    public final boolean ln() {
        return this.Em;
    }

    private void e(boolean z, boolean z2) {
        if (!this.Em) {
            this.vW.setVisibility(8);
            this.Ej.setText(this.Eh);
            a aVar = this.En;
            if (aVar != null) {
                aVar.H(false);
            }
        } else {
            this.vW.setVisibility(0);
        }
        this.Em = true;
    }

    private void e(long j, long j2) {
        this.Ei.setProgress((int) (j2 - j));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.cw) || (aVar = this.En) == null) {
            return;
        }
        aVar.G(this.Em);
    }
}
