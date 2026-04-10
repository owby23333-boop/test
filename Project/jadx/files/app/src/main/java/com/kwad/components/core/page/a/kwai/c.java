package com.kwad.components.core.page.a.kwai;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private LinearLayout LS;
    private TextView LT;
    private TextView LU;
    private TextView LV;
    private TextView LW;
    private int LX;
    private boolean counterPaused = false;
    private Runnable LY = new Runnable() { // from class: com.kwad.components.core.page.a.kwai.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.counterPaused) {
                bh.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.LX <= 0) {
                c.this.LT.setText("任务已完成");
                c.this.LU.setVisibility(8);
                c.this.LV.setVisibility(8);
                c.this.LW.setVisibility(8);
                com.kwad.components.ad.a.g gVar = (com.kwad.components.ad.a.g) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.g.class);
                if (gVar != null) {
                    gVar.notifyRewardVerify();
                }
            } else {
                c.this.oH();
                bh.runOnUiThreadDelay(this, 1000L);
            }
            c.h(c.this);
        }
    };
    private final com.kwad.sdk.core.b.c xe = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.page.a.kwai.c.2
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            c.this.counterPaused = true;
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            c.this.counterPaused = false;
        }
    };

    static /* synthetic */ int h(c cVar) {
        int i2 = cVar.LX;
        cVar.LX = i2 - 1;
        return i2;
    }

    private void oG() {
        this.LS.setVisibility(0);
        if (!this.LL.mAdTemplate.mRewardVerifyCalled) {
            oH();
            bh.runOnUiThreadDelay(this.LY, 1000L);
        } else {
            this.LT.setText("任务已完成");
            this.LU.setVisibility(8);
            this.LV.setVisibility(8);
            this.LW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH() {
        this.LU.setText(oI());
        this.LW.setText(oJ());
    }

    private String oI() {
        int i2 = this.LX / 60;
        StringBuilder sb = i2 >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i2);
        return sb.toString();
    }

    private String oJ() {
        int i2 = this.LX % 60;
        StringBuilder sb = i2 >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(this.xe);
        this.LX = com.kwad.sdk.core.config.d.uM();
        oG();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.LS = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.LT = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.LU = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.LV = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.LW = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.b(this.xe);
        bh.b(this.LY);
    }
}
