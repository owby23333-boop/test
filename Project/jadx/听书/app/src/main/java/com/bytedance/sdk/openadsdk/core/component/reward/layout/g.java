package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f962a;
    protected final na dl;
    protected ViewGroup e;
    protected FrameLayout fo;
    protected final TTBaseVideoActivity g;
    protected final float gc;
    protected RelativeLayout gz;
    protected int i = 3;
    protected RelativeLayout kb;
    protected final boolean m;
    protected TextView uy;
    protected TextView wp;
    protected final String z;

    public void a(int i) {
    }

    public void dl(int i) {
    }

    public void g(int i) {
    }

    public void uy() {
    }

    public void z(DownloadListener downloadListener) {
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
    }

    public g(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        this.g = tTBaseVideoActivity;
        this.dl = naVar;
        this.f962a = naVar.zr();
        this.gc = naVar.tk();
        this.m = z;
        this.z = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public void z() {
        ViewGroup viewGroup = (ViewGroup) this.g.findViewById(2114387959);
        this.e = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
        com.bytedance.sdk.openadsdk.core.v.gz.z(this.e);
    }

    protected void kb() {
        if (this.m) {
            int iMe = this.dl.me();
            this.i = iMe;
            if (iMe == -200) {
                this.i = zw.g().wp(new StringBuilder().append(eo.fo(this.dl)).toString());
            }
            if (this.i == -1) {
                oq.z((View) this.gz, 0);
            }
        }
    }

    public void gc(int i) {
        oq.z((View) this.uy, i);
    }

    public void m(int i) {
        oq.z((View) this.gz, i);
    }

    public FrameLayout wp() {
        return this.fo;
    }

    public RelativeLayout i() {
        return this.gz;
    }

    protected String v() {
        return eo.p(this.dl);
    }

    protected String pf() {
        return eo.fv(this.dl);
    }

    protected void z(ImageView imageView, UpieImageView upieImageView) {
        List<gk> listJz = this.dl.jz();
        if (listJz == null || listJz.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.gz.g.z(listJz.get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.dl)) {
            com.bytedance.sdk.openadsdk.gc.z.z(imageView, upieImageView);
        }
    }

    public void dl(boolean z) {
        this.g.mc().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void ls() {
        na naVar = this.dl;
        String strSa = naVar != null ? naVar.sa() : null;
        if (this.uy == null || !TextUtils.isEmpty(strSa)) {
            return;
        }
        tb.z(this.g, "tt_ad_logo_backup", this.uy);
    }
}
