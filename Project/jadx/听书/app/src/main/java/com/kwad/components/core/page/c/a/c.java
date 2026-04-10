package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private LinearLayout TQ;
    private TextView TR;
    private TextView TS;
    private TextView TT;
    private TextView TU;
    private int TV;
    private boolean TW = false;
    private boolean TX = false;
    private Runnable TY = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (!c.this.TW) {
                if (c.this.TV <= 0) {
                    c.this.TR.setText("任务已完成");
                    c.this.TS.setVisibility(8);
                    c.this.TT.setVisibility(8);
                    c.this.TU.setVisibility(8);
                    h hVar = (h) com.kwad.sdk.components.d.f(h.class);
                    if (hVar != null && !c.this.TX) {
                        hVar.notifyRewardVerify();
                    }
                } else {
                    c.this.rh();
                    bw.runOnUiThreadDelay(this, 1000L);
                }
                c.i(c.this);
                return;
            }
            bw.runOnUiThreadDelay(this, 500L);
        }
    };
    private final com.kwad.sdk.core.c.c An = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.TW = false;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.TW = true;
        }
    };

    static /* synthetic */ int i(c cVar) {
        int i = cVar.TV;
        cVar.TV = i - 1;
        return i;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.TQ = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.TR = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.TS = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.TT = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.TU = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(this.An);
        this.TV = com.kwad.sdk.core.config.e.FC();
        rg();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.b(this.An);
        bw.c(this.TY);
    }

    private void rg() {
        this.TQ.setVisibility(0);
        if (this.TJ.mAdTemplate.mRewardVerifyCalled) {
            this.TR.setText("任务已完成");
            this.TS.setVisibility(8);
            this.TT.setVisibility(8);
            this.TU.setVisibility(8);
            return;
        }
        rh();
        bw.runOnUiThreadDelay(this.TY, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        this.TS.setText(ri());
        this.TU.setText(rj());
    }

    private String ri() {
        int i = this.TV / 60;
        if (i >= 10) {
            return new StringBuilder().append(i).toString();
        }
        return "0" + i;
    }

    private String rj() {
        int i = this.TV % 60;
        if (i >= 10) {
            return new StringBuilder().append(i).toString();
        }
        return "0" + i;
    }
}
