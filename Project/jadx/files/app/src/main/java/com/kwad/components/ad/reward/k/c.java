package com.kwad.components.ad.reward.k;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.sdk.core.download.kwai.a implements com.kwad.sdk.widget.c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ImageView oF;
    private View xY;
    private View xZ;
    private Button ya;
    private Button yb;
    private TextView yc;
    private TextView yd;
    private TextView ye;
    private KSRatingBar yf;
    private KsAppTagsView yg;
    private a yh;
    private volatile boolean yi = false;
    private com.kwad.components.ad.g.a yj;
    private Runnable yk;

    public interface a {
        void c(boolean z2, int i2);
    }

    static class b {
        private String appName;
        private String os;
        private String qM;
        private float ym;
        private List<String> yn;
        private int yo = 15;
        private String yp;

        b() {
        }

        public static b A(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            b bVar = new b();
            bVar.appName = com.kwad.sdk.core.response.a.d.q(adTemplate) ? com.kwad.sdk.core.response.a.a.aq(adInfoCb) : com.kwad.sdk.core.response.a.a.ap(adInfoCb);
            bVar.ym = com.kwad.sdk.core.response.a.a.av(adInfoCb);
            bVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
            bVar.os = com.kwad.sdk.core.response.a.d.q(adTemplate) ? com.kwad.sdk.core.response.a.a.cl(adInfoCb) : com.kwad.sdk.core.response.a.a.bL(adInfoCb);
            if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                bVar.yo = com.kwad.components.ad.reward.kwai.b.gQ();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.yo = com.kwad.sdk.core.config.d.uM();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.yp = str;
            bVar.yn = com.kwad.sdk.core.response.a.c.bS(adTemplate);
            return bVar;
        }

        public final String kd() {
            return String.format(this.yp, Integer.valueOf(this.yo));
        }
    }

    public c(View view) {
        this.xY = view;
        initView();
        this.yj = new com.kwad.components.ad.g.a(view);
    }

    private void c(View view, boolean z2) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.b.d("ApkInfoCardViewHelper", "onClick install");
            this.yi = true;
            a aVar = this.yh;
            if (aVar != null) {
                aVar.c(z2, 1);
            }
        }
    }

    private void initView() {
        this.ya = (Button) this.xY.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yb = (Button) this.xY.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xZ = this.xY.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.oF = (ImageView) this.xY.findViewById(R.id.ksad_reward_apk_info_icon);
        this.yc = (TextView) this.xY.findViewById(R.id.ksad_reward_apk_info_name);
        this.yd = (TextView) this.xY.findViewById(R.id.ksad_reward_apk_info_desc);
        this.yf = (KSRatingBar) this.xY.findViewById(R.id.ksad_reward_apk_info_score);
        this.yg = (KsAppTagsView) this.xY.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    public final void a(a aVar) {
        this.yh = aVar;
    }

    public final void a(com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            c(view, false);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z2) {
        this.mAdTemplate = adTemplate;
        b bVarA = b.A(adTemplate);
        if (bVarA == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.oF, bVarA.os, adTemplate, 12);
        this.yc.setText(bVarA.appName);
        this.yd.setText(bVarA.qM);
        this.yf.setStar(bVarA.ym);
        if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
            this.yb.setText(com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
            this.yf.setVisibility(0);
        } else {
            this.yb.setText("查看详情");
            this.yf.setVisibility(8);
        }
        this.ya.setText(bVarA.kd());
        this.ya.setClickable(true);
        this.yb.setClickable(true);
        this.xZ.setClickable(true);
        new com.kwad.sdk.widget.f(this.ya, this);
        new com.kwad.sdk.widget.f(this.yb, this);
        new com.kwad.sdk.widget.f(this.xZ, this);
        List<String> list = bVarA.yn;
        if (z2 && list.size() == 0) {
            this.yd.setVisibility(8);
            this.ye = (TextView) this.xY.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.ye.setVisibility(0);
            this.ye.setText(bVarA.qM);
        }
        if (list.size() == 0) {
            this.yg.setVisibility(8);
        }
        this.yg.setAppTags(list);
        if (this.yk == null) {
            this.yk = new Runnable() { // from class: com.kwad.components.ad.reward.k.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.xZ.getHeight());
                    if (c.this.yi) {
                        return;
                    }
                    c.this.yj.lW();
                }
            };
        }
        this.xZ.postDelayed(this.yk, 1600L);
    }

    public final void j(String str, int i2) {
        Button button = this.yb;
        if (button == null || str == null || i2 == 0) {
            return;
        }
        button.setText(str);
    }

    public final void kb() {
        Runnable runnable;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.g.a aVar = this.yj;
        if (aVar != null) {
            aVar.kb();
        }
        View view = this.xZ;
        if (view == null || (runnable = this.yk) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.yk = null;
    }

    public final void kc() {
        this.yj.lY();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yb.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yb.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aI(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yb.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yb.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.U(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i2) {
        super.onPaused(i2);
        if (i2 != 0) {
            this.yj.lY();
            this.yb.setText(com.kwad.sdk.core.response.a.a.bv(i2));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i2) {
        if (i2 != 0) {
            this.yj.lY();
            this.yb.setText(com.kwad.sdk.core.response.a.a.bu(i2));
        }
    }
}
