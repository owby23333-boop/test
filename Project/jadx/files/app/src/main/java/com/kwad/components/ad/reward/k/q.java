package com.kwad.components.ad.reward.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends d implements View.OnClickListener {
    private View Aa;

    @Nullable
    private com.kwad.components.ad.reward.g.b Ab;
    private ViewGroup yX;
    private KsStyledTextButton zZ;

    public q(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.yX = (ViewGroup) layoutInflater.inflate(R.layout.ksad_play_again_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.zZ = (KsStyledTextButton) this.yX.findViewById(R.id.ksad_play_again_btn_action);
        this.Aa = this.yX.findViewById(R.id.ksad_play_again_btn_exit);
        this.zZ.setOnClickListener(this);
        this.Aa.setOnClickListener(this);
    }

    public final void b(@Nullable com.kwad.components.ad.reward.g.b bVar) {
        this.Ab = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.yX;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Ab == null) {
            return;
        }
        if (view.equals(this.zZ)) {
            this.Ab.onPlayAgainClick(false);
        } else if (view.equals(this.Aa)) {
            this.Ab.gL();
        }
    }
}
