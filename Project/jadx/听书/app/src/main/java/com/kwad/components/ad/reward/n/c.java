package com.kwad.components.ad.reward.n;

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
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.d {
    private ImageView BA;
    private TextView BB;
    private TextView BC;
    private KSRatingBar BD;
    private KsAppTagsView BE;
    private a BF;
    private volatile boolean BG = false;
    private com.kwad.components.ad.j.a BH;
    private Runnable BI;
    private View Bv;
    private View Bw;
    private Button Bx;
    private Button By;
    private TextView Bz;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public interface a {
        void d(boolean z, int i);
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    public c(View view) {
        this.Bv = view;
        initView();
        this.BH = new com.kwad.components.ad.j.a(view);
    }

    private void initView() {
        this.Bx = (Button) this.Bv.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.By = (Button) this.Bv.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.Bw = this.Bv.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.BA = (ImageView) this.Bv.findViewById(R.id.ksad_reward_apk_info_icon);
        this.Bz = (TextView) this.Bv.findViewById(R.id.ksad_reward_apk_info_name);
        this.BB = (TextView) this.Bv.findViewById(R.id.ksad_reward_apk_info_desc);
        this.BD = (KSRatingBar) this.Bv.findViewById(R.id.ksad_reward_apk_info_score);
        this.BE = (KsAppTagsView) this.Bv.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b bVarY = b.Y(adTemplate);
        if (bVarY == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.BA, bVarY.sW, adTemplate, 12);
        this.Bz.setText(bVarY.appName);
        this.BB.setText(bVarY.sX);
        this.BD.setStar(bVarY.BK);
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)))) {
            this.By.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)));
            this.BD.setVisibility(0);
        } else {
            this.By.setText("查看详情");
            this.BD.setVisibility(8);
        }
        this.Bx.setText(bVarY.lb());
        this.Bx.setClickable(true);
        this.By.setClickable(true);
        this.Bw.setClickable(true);
        new com.kwad.sdk.widget.h(this.Bx, this);
        new com.kwad.sdk.widget.h(this.By, this);
        new com.kwad.sdk.widget.h(this.Bw, this);
        List<String> list = bVarY.BL;
        if (z && list.size() == 0) {
            this.BB.setVisibility(8);
            TextView textView = (TextView) this.Bv.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.BC = textView;
            textView.setVisibility(0);
            this.BC.setText(bVarY.sX);
        }
        if (list.size() == 0) {
            this.BE.setVisibility(8);
        }
        this.BE.setAppTags(list);
        if (this.BI == null) {
            this.BI = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.Bw.getHeight());
                    if (c.this.BG) {
                        return;
                    }
                    c.this.BH.je();
                }
            };
        }
        this.Bw.postDelayed(this.BI, 1600L);
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void kZ() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.j.a aVar = this.BH;
        if (aVar != null) {
            aVar.kZ();
        }
        View view = this.Bw;
        if (view == null || (runnable = this.BI) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.BI = null;
    }

    public final void la() {
        this.BH.nF();
    }

    public final void a(a aVar) {
        this.BF = aVar;
    }

    public final void j(String str, int i) {
        Button button = this.By;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            e(view, false);
        }
    }

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", "onClick install");
            this.BG = true;
            a aVar = this.BF;
            if (aVar != null) {
                aVar.d(z, 1);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.By.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.BH.nF();
            this.By.setText(com.kwad.sdk.core.response.b.a.dG(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.BH.nF();
            this.By.setText(com.kwad.sdk.core.response.b.a.dF(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.By.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cl(adTemplate));
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.By.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.By.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载");
    }

    static class b {
        private float BK;
        private List<String> BL;
        private int BM = 15;
        private String BN;
        private String appName;
        private String sW;
        private String sX;

        b() {
        }

        public static b Y(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.O(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.ax(adInfoEl);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.av(adInfoEl);
            }
            bVar.BK = com.kwad.sdk.core.response.b.a.aC(adInfoEl);
            bVar.sX = com.kwad.sdk.core.response.b.a.au(adInfoEl);
            if (com.kwad.sdk.core.response.b.e.O(adTemplate)) {
                bVar.sW = com.kwad.sdk.core.response.b.a.cO(adInfoEl);
            } else {
                bVar.sW = com.kwad.sdk.core.response.b.a.co(adInfoEl);
            }
            if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)))) {
                bVar.BM = com.kwad.components.ad.reward.a.b.hB();
                bVar.BN = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.BM = com.kwad.sdk.core.config.e.FC();
                bVar.BN = "浏览详情页%s秒，领取奖励";
            }
            bVar.BL = com.kwad.sdk.core.response.b.d.ec(adTemplate);
            return bVar;
        }

        public final String lb() {
            return String.format(this.BN, Integer.valueOf(this.BM));
        }
    }
}
