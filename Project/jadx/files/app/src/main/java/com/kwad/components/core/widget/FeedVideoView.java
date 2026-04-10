package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.r.p;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FeedVideoView extends b<AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper MR;
    private com.kwad.components.core.video.e Nj;
    private p WA;
    private RatioFrameLayout Wa;
    private TextView Wb;
    private TextView Wc;
    private TextView Wd;
    private View We;
    private KSCornerImageView Wf;
    private TextView Wg;
    private ScaleAnimSeekBar Wh;
    private ImageView Wi;
    private ImageView Wj;
    private ImageView Wk;
    private ViewGroup Wl;
    private ViewGroup Wm;
    private TextView Wn;
    private ViewGroup Wo;
    private ViewGroup Wp;
    private int Wq;
    private boolean Wr;
    private boolean Ws;
    private long Wt;
    private boolean Wu;
    private KsAdVideoPlayConfig Wv;
    private a Ww;
    private View Wx;
    private boolean Wy;
    private Runnable Wz;
    private KsAppDownloadListener cE;
    private List<Integer> cI;
    private View.OnClickListener cc;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private TextView ez;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public interface a {
        void oB();

        void oC();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.Wq = 100;
        this.Wz = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wl.setVisibility(8);
                FeedVideoView.this.Wk.setVisibility(8);
                if (FeedVideoView.this.Nj != null) {
                    FeedVideoView.this.Nj.aJ(true);
                }
            }
        };
        this.WA = new p(this.Wz);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wq = 100;
        this.Wz = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wl.setVisibility(8);
                FeedVideoView.this.Wk.setVisibility(8);
                if (FeedVideoView.this.Nj != null) {
                    FeedVideoView.this.Nj.aJ(true);
                }
            }
        };
        this.WA = new p(this.Wz);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Wq = 100;
        this.Wz = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wl.setVisibility(8);
                FeedVideoView.this.Wk.setVisibility(8);
                if (FeedVideoView.this.Nj != null) {
                    FeedVideoView.this.Nj.aJ(true);
                }
            }
        };
        this.WA = new p(this.Wz);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.Wo.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.Wl.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.Wz);
                        if (FeedVideoView.this.Wu) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WA, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.eM.isCompleted()) {
                    FeedVideoView.this.Wl.setVisibility(0);
                    FeedVideoView.this.Wk.setVisibility(0);
                    if (FeedVideoView.this.Nj != null) {
                        FeedVideoView.this.Nj.aJ(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.Wz);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WA, 5000L);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.Wq != 101) {
                    if (FeedVideoView.this.cc != null) {
                        FeedVideoView.this.cc.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.Wl.setVisibility(0);
                FeedVideoView.this.Wk.setVisibility(8);
                if (FeedVideoView.this.Nj != null) {
                    FeedVideoView.this.Nj.aJ(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.Wz);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WA, 5000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            private boolean cJ = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.ax(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.Wl.setVisibility(8);
                FeedVideoView.this.Wk.setVisibility(8);
                FeedVideoView.this.Wh.setProgress(100);
                FeedVideoView.this.Wc.setText(bf.H(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                FeedVideoView.this.c(j2);
                float duration = (j2 * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.Wu) {
                    FeedVideoView.this.Wh.setProgress((int) duration);
                    FeedVideoView.this.Wc.setText(bf.H(j2));
                }
                FeedVideoView.this.Wb.setText(bf.H(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.Wy) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eM.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.a.a.ah(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eM.setLooping(com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.report.a.h(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.Wb.setText(bf.H(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!FeedVideoView.this.Wy) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eM.setVideoSoundEnable(!com.kwad.sdk.core.response.a.a.ah(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eM.setLooping(com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.cJ) {
                    return;
                }
                this.cJ = true;
                com.kwad.components.core.m.a.pr().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        });
        this.Nj.setAdClickListener(new a.InterfaceC0410a() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // com.kwad.components.core.video.a.InterfaceC0410a
            public final void a(int i2, ab.a aVar3) {
                int i3 = 171;
                int i4 = 2;
                boolean z2 = false;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            i3 = com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i4 = 1;
                            z2 = true;
                        } else if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) == 0) {
                            i3 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) == 0) {
                        i3 = 82;
                    }
                } else if (com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo) == 0) {
                    i3 = 13;
                }
                y.b bVar = new y.b();
                bVar.jU = aVar3;
                bVar.jS = i3;
                com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(FeedVideoView.this.Wo)).J(FeedVideoView.this.mAdTemplate).aq(true).b(FeedVideoView.this.mApkDownloadHelper).ap(i4).al(z2).an(true).a(bVar).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.eh();
                    }
                }));
            }
        });
        this.Wh.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.Wh.aU(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress())));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WA);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WA, 5000L);
                }
                FeedVideoView.this.Wu = false;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z2) {
                if (z2) {
                    FeedVideoView.this.Wh.aU(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WA);
                    FeedVideoView.this.Wu = true;
                    FeedVideoView.this.Wc.setText(bf.H((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress()))));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void rQ() {
                FeedVideoView.this.Wh.aU(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WA);
                FeedVideoView.this.Wu = true;
            }
        });
        this.Wi.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onClick(android.view.View r4) {
                /*
                    r3 = this;
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isPaused()
                    if (r4 != 0) goto L58
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isIdle()
                    if (r4 == 0) goto L11
                    goto L58
                L11:
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isPlaying()
                    if (r4 == 0) goto L8b
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                    r4.qN()
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    r0 = 0
                    r4.setVisibility(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.Context r0 = r0.getContext()
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_play_176
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.q(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.Context r0 = r0.getContext()
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_play_btn
                    goto L84
                L58:
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                    r4.qO()
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.q(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_btn
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_center
                L84:
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                L8b:
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    if (r4 == 0) goto Lb3
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.r.p r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                    r4.removeCallbacks(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.r.p r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                    r1 = 5000(0x1388, double:2.4703E-320)
                    r4.postDelayed(r0, r1)
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.widget.FeedVideoView.AnonymousClass10.onClick(android.view.View):void");
            }
        });
        this.Wk.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.eM.isPaused() || FeedVideoView.this.eM.isIdle()) {
                    FeedVideoView.this.pk();
                } else if (FeedVideoView.this.eM.isPlaying()) {
                    FeedVideoView.this.qt();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WA);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WA, 5000L);
                }
            }
        });
        this.Wm.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.rO();
            }
        });
        this.Wj.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.Wq == 100) {
                    FeedVideoView.this.rN();
                } else if (FeedVideoView.this.Wq == 101) {
                    FeedVideoView.this.rO();
                }
            }
        });
    }

    static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z2) {
        feedVideoView.Wy = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        int iCeil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.ax(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.aI(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.ax(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.U(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.bv(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    FeedVideoView.this.Wd.setText(com.kwad.sdk.core.response.a.a.bu(i2));
                }
            };
        }
        return this.cE;
    }

    private boolean rM() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - this.Wt;
        if (j2 > 888) {
            this.Wt = jElapsedRealtime;
        }
        return j2 > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN() {
        a aVar = this.Ww;
        if (aVar != null) {
            aVar.oB();
        }
        if ((this.Wq == 100) && rM()) {
            this.Wm.setVisibility(0);
            this.Wn.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z2 = com.kwad.sdk.core.response.a.a.K(this.mAdInfo) > com.kwad.sdk.core.response.a.a.J(this.mAdInfo);
            this.Wr = ah.cq(getContext());
            this.Ws = ah.cu(getContext());
            Context context = getContext();
            if (z2) {
                ah.ct(context);
            } else {
                ah.cs(context);
            }
            ViewGroup viewGroup = (ViewGroup) this.Wo.getParent();
            this.Wp = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.Wo);
                this.Wx = new View(this.Wo.getContext());
                this.Wx.setLayoutParams(new ViewGroup.LayoutParams(this.Wo.getWidth(), this.Wo.getHeight()));
                viewGroup.addView(this.Wx);
            }
            ah.b(getContext(), false);
            Context contextC = com.kwad.sdk.b.kwai.a.C(this);
            if (contextC instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) contextC).getWindow().getDecorView();
                this.Wo.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z2 && viewGroup2.getWidth() != 0) {
                    this.Wa.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.Wo, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if ((this.Wq == 101) & rM()) {
            this.Wm.setVisibility(8);
            if (this.Wr) {
                ah.cq(getContext());
            } else {
                ah.cr(getContext());
            }
            if (this.Ws) {
                ah.ct(getContext());
            } else {
                ah.cs(getContext());
            }
            ah.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.Wo.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.Wo);
            }
            this.Wo.setLayoutParams(new ViewGroup.LayoutParams(this.Wp.getWidth(), this.Wp.getHeight()));
            this.Wa.setRatio(0.5600000023841858d);
            View view = this.Wx;
            if (view != null) {
                this.Wp.removeView(view);
                this.Wx = null;
            }
            this.Wp.addView(this.Wo, new FrameLayout.LayoutParams(-1, -2));
            this.Wo.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.Ww;
        if (aVar != null) {
            aVar.oC();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.Wy = false;
        com.kwad.sdk.core.response.model.b bVarBh = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo);
        this.Wv = ksAdVideoPlayConfig;
        String url = bVarBh.getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eL.setVisibility(8);
        } else {
            this.eL.setImageDrawable(null);
            KSImageLoader.loadImage(this.eL, url, this.mAdTemplate);
            this.eL.setVisibility(0);
        }
        this.cI = com.kwad.sdk.core.response.a.a.bc(this.mAdInfo);
        String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.eM = AdVideoPlayerViewCache.getInstance().cv(strE);
        if (com.kwad.sdk.core.response.a.a.ai(this.mAdInfo)) {
            this.ez.setVisibility(8);
            View view = this.We;
            if (view != null) {
                view.setVisibility(0);
                this.Wd.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
                this.Wg.setText(com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.Wf, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.Wd.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.cc != null) {
                            FeedVideoView.this.cc.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.We;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.ez.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar == null) {
            this.eM = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.a.a.T(this.mAdInfo);
            this.eM.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).bd(com.kwad.sdk.core.response.a.d.cd(this.mAdTemplate)).be(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).uc(), null);
            this.Nj = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eM, ksAdVideoPlayConfig);
            this.Nj.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eM.setController(this.Nj);
            this.Nj.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.uh() == 2) {
                AdVideoPlayerViewCache.getInstance().a(strE, this.eM);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cI = (List) this.eM.getTag();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.Nj = (com.kwad.components.core.video.e) this.eM.getController();
            this.Nj.setAutoRelease(false);
            this.Nj.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eM.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eM.getParent() != null) {
            ((ViewGroup) this.eM.getParent()).removeView(this.eM);
            this.Nj.qL();
        }
        if (this.Wa.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.Wa;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.Wa.setTag(null);
        }
        this.Wa.addView(this.eM);
        this.Wa.setTag(this.eM);
        this.Wl.setVisibility(8);
        this.Wk.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.ez.setVisibility(8);
        } else {
            this.ez.setVisibility(0);
            this.ez.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Nj, this.eM);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void aS() {
        super.aS();
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        pk();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.WA);
            getHandler().postDelayed(this.WA, 5000L);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void aT() {
        super.aT();
        if (this.eM != null) {
            qt();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.WA);
                getHandler().postDelayed(this.WA, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
    }

    @Override // com.kwad.components.core.widget.b
    protected final void bk() {
        this.MR = new NestedScrollingChildHelper(this);
        this.Wa = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.Wa.setRatio(0.5600000023841858d);
        this.eL = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.ez = (TextView) findViewById(R.id.ksad_video_text_below);
        this.Wh = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.Wh.setMaxProgress(100);
        this.Wh.setMinProgress(0);
        this.Wd = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.We = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.Wg = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.Wf = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.Wb = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.Wc = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.Wi = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.Wk = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.Wj = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.Wl = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.Wo = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.Wm = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.Wn = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.MR.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.MR.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.MR.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.MR.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    protected int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.MR.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.MR.isNestedScrollingEnabled();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public void onFirstVisible(View view) {
        super.onFirstVisible(view);
    }

    public final void pg() {
        this.Nj.qL();
    }

    public final void pk() {
        this.Nj.qO();
        this.Nj.setVisibility(0);
        this.Nj.setAlpha(1.0f);
        this.Wi.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.Wk.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void qt() {
        this.Nj.qN();
        this.Wk.setVisibility(0);
        this.Wk.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.Wi.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final boolean rP() {
        if (this.Wq != 101) {
            return false;
        }
        rO();
        return true;
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Nj;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.MR.setNestedScrollingEnabled(z2);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.cc = onClickListener;
    }

    protected void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
        if (i2 == 101) {
            imageView = this.Wj;
            resources = getContext().getResources();
            i3 = R.drawable.ksad_video_player_exit_fullscreen_btn;
        } else {
            imageView = this.Wj;
            resources = getContext().getResources();
            i3 = R.drawable.ksad_video_player_fullscreen_btn;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
        this.Wq = i2;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.Ww = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.MR.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.MR.stopNestedScroll();
    }
}
