package com.kwad.components.core.page.a.kwai;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    private View Ma;
    private TextView Mb;
    private int Mc;
    private Runnable Md = new Runnable() { // from class: com.kwad.components.core.page.a.kwai.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.p.a.pJ().pM()) {
                bh.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.Mc <= 0) {
                d.this.Mb.setText("已获得权益");
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.Ma.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.p.a.pJ().aF(true);
            } else {
                d.this.Mb.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.Mc)));
                d.c(d.this);
                com.kwad.components.core.p.a.pJ().aF(d.this.Mc);
                bh.runOnUiThreadDelay(this, 1000L);
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i2 = dVar.Mc;
        dVar.Mc = i2 - 1;
        return i2;
    }

    private void oK() {
        TextView textView;
        if (this.Ma == null || (textView = this.Mb) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.Mc)));
        this.Ma.setVisibility(0);
        bh.runOnUiThreadDelay(this.Md, 1000L);
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Mc = com.kwad.sdk.core.response.a.a.aF(com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate));
        com.kwad.components.core.p.a.pJ().aF(this.Mc);
        oK();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ma = findViewById(R.id.ksad_web_reward_task_layout);
        this.Mb = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bh.b(this.Md);
    }
}
