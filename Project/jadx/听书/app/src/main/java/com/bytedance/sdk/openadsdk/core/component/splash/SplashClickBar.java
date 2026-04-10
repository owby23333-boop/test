package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f987a;
    private int dl;
    private boolean e;
    private SplashClickBarBtn fo;
    private int g;
    private int gc;
    private int gz;
    private String m;
    private int z;

    public SplashClickBar(Context context, na naVar) {
        super(context);
        z(context, naVar);
    }

    public void z(Context context, na naVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), naVar);
        this.fo = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.fo.setClipChildren(false);
    }

    public void z(na naVar) {
        this.z = naVar.wn();
        this.g = naVar.ja();
        this.dl = naVar.nb();
        this.f987a = naVar.zz();
        this.gc = naVar.bm();
        this.m = naVar.sd();
        this.gz = naVar.vo();
        this.e = naVar.tf();
        SplashClickBarBtn splashClickBarBtn = this.fo;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(naVar.fn());
            this.fo.setDeepShakeValue(naVar.vl());
            this.fo.setWriggleValue(naVar.hs());
            this.fo.setTwistConfig(naVar.kk());
            this.fo.setShakeInteractConf(naVar.eb());
            this.fo.setTwistInteractConf(naVar.jb());
            this.fo.setCalculationTwistMethod(naVar.s());
            this.fo.setCalculationMethod(naVar.yw());
        }
        this.fo.z(naVar.xf());
        if (this.gc == 1 && this.e) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setBtnLayout(boolean z) {
        int i;
        int iDl;
        int i2 = this.g + MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        if (this.z <= i2 && this.gz != 4) {
            this.z = i2;
        }
        if (z) {
            i = this.dl;
        } else {
            i = this.f987a;
        }
        if (i < 0) {
            i = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fo.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.gz;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iDl = oq.dl(getContext(), 10.0f);
            } else if (i3 == 7) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iDl = oq.dl(getContext(), 20.0f);
            } else {
                layoutParams.height = oq.dl(zw.getContext(), this.g);
                layoutParams.width = oq.dl(zw.getContext(), this.z);
            }
            i += iDl;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = oq.dl(zw.getContext(), i);
        layoutParams.gravity = 81;
        this.fo.setLayoutParams(layoutParams);
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.fo.z(zVar);
    }
}
