package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.t;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import com.bytedance.sdk.openadsdk.hh.uy;

/* JADX INFO: loaded from: classes2.dex */
public class z implements l.z {
    private final na dl;
    private PlayableVideoContainer e;
    private final Context g;
    private final int gc;
    private dl gz;
    private boolean kb;
    private FrameLayout m;
    private final com.bytedance.sdk.openadsdk.core.video.g.g v;
    private final String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f1297a = new l(Looper.getMainLooper(), this);
    private boolean fo = false;
    private boolean uy = true;
    private boolean wp = false;
    private boolean i = false;

    public z(String str, Activity activity, na naVar, int i, com.bytedance.sdk.openadsdk.core.video.g.g gVar, FrameLayout frameLayout) {
        this.z = str;
        this.g = activity;
        this.dl = naVar;
        this.gc = i;
        if (!js.a(naVar)) {
            this.m = frameLayout;
        }
        gc();
        this.v = gVar;
    }

    private void gc() {
        if (this.m == null) {
            return;
        }
        if (t.z(this.dl, this.gc) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.g);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(oq.dl(this.g, 156.0f), oq.dl(this.g, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = oq.dl(this.g, 55.0f);
            layoutParams.rightMargin = oq.dl(this.g, 20.0f);
            this.m.addView(playableVideoContainer, layoutParams);
            this.e = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.g);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(oq.dl(this.g, 73.0f), oq.dl(this.g, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = oq.dl(this.g, 55.0f);
        layoutParams2.rightMargin = oq.dl(this.g, 30.0f);
        this.m.addView(playableVideoContainer2, layoutParams2);
        this.e = playableVideoContainer2;
    }

    public void z(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.i = true;
        this.uy = z;
        z(j);
        if (this.fo) {
            if (this.v != null && (playableVideoContainer = this.e) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.uy();
                    }
                }, 500L);
                this.e.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.z.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (z.this.m != null) {
                            z.this.z();
                            z.this.v.g();
                        }
                    }
                });
            } else if (uy.z(this.dl)) {
                m();
            } else {
                e();
            }
        }
    }

    public void z() {
        this.i = false;
        a();
        m();
    }

    private void m() {
        oq.z((View) this.m, 8);
        oq.z((View) this.e, 8);
    }

    private void e() {
        oq.z((View) this.m, 0);
        oq.z((View) this.e, 0);
    }

    private void z(long j) {
        if (this.e == null) {
            return;
        }
        if (this.v != null || uy.z(this.dl)) {
            if (this.fo) {
                dl dlVar = this.gz;
                if (dlVar != null) {
                    dlVar.g(j);
                    this.gz.z(j);
                    return;
                }
                return;
            }
            this.fo = true;
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(1, this.dl, this.gc);
            aVarZ.g(this.dl.mj());
            aVarZ.g(this.e.getWidth());
            aVarZ.dl(this.e.getHeight());
            aVarZ.dl(this.dl.vk());
            aVarZ.z(j);
            aVarZ.g(this.uy);
            if (uy.z(this.dl)) {
                aVarZ.z(true);
            }
            dl dlVar2 = new dl(this.g, this.e.getVideoContainer(), this.dl, null);
            this.gz = dlVar2;
            dlVar2.z(new z.InterfaceC0210z() { // from class: com.bytedance.sdk.openadsdk.core.playable.z.3
                @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
                public void z() {
                    if (z.this.v == null) {
                        if (!uy.z(z.this.dl) || z.this.gz == null || z.this.gz.gc()) {
                            return;
                        }
                        z.this.z();
                        return;
                    }
                    z.this.z();
                    z.this.v.dl();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
                public void z(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    z.this.e.z(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
                public void g() {
                    z.this.e.z(true);
                    if (z.this.v != null) {
                        z.this.v.uy();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
                public void z(long j2, long j3) {
                    z.this.e.z(false);
                    if (z.this.v != null) {
                        z.this.v.z(j2, j3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
                public void dl() {
                    z.this.gz();
                }
            });
            this.gz.g(j);
            this.gz.z(aVarZ);
            if (this.v != null) {
                this.gz.io();
                this.gz.e(false);
                this.e.z();
            } else {
                if (uy.z(this.dl)) {
                    this.gz.e(true);
                }
                fo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz() {
        this.wp = true;
        if (this.kb) {
            this.kb = false;
            g();
        }
        z(this.uy);
    }

    public void g() {
        if (this.i && this.fo && this.gz != null) {
            this.f1297a.removeMessages(1);
            if (this.wp) {
                this.gz.m();
            } else {
                this.kb = true;
            }
        }
    }

    public void dl() {
        if (this.i && this.fo && this.gz != null) {
            this.kb = false;
            this.f1297a.sendEmptyMessageDelayed(1, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            if (this.gz.f()) {
                return;
            }
            this.gz.gz();
        }
    }

    public void a() {
        dl dlVar = this.gz;
        if (dlVar == null) {
            return;
        }
        dlVar.uy();
        this.gz = null;
        this.fo = false;
        this.kb = false;
        this.wp = false;
    }

    public void z(boolean z) {
        dl dlVar = this.gz;
        if (dlVar == null) {
            return;
        }
        this.uy = z;
        dlVar.g(z);
    }

    private void fo() {
        PlayableVideoContainer playableVideoContainer = this.e;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.g(true);
        this.f1297a.sendEmptyMessageDelayed(1, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        PlayableVideoContainer playableVideoContainer = this.e;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.g(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy() {
        if (this.e == null || this.m == null) {
            return;
        }
        e();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationX", -oq.dl(this.g, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "translationY", -oq.dl(this.g, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.e, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}
