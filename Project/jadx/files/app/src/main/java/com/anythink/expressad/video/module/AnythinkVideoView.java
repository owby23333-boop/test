package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener;
import com.anythink.expressad.playercommon.PlayerView;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.dynview.widget.AnyThinkSegmentsProgressBar;
import com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView;
import com.anythink.expressad.video.module.a.a.m;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.j;
import com.anythink.expressad.video.widget.SoundImageView;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.e.d;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkVideoView extends AnythinkBaseView implements f, j {
    private static int A = 0;
    private static int B = 0;
    private static final String C = "2";
    public static final String TAG = "AnythinkVideoView";
    private static boolean av = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f11859s = "anythink_reward_videoview_item";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f11860t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f11861u = 1280.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final float f11862v = 720.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f11863w = 0.1f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static int f11864x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static int f11865y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f11866z;
    private PlayerView D;
    private SoundImageView E;
    private TextView F;
    private View G;
    private RelativeLayout H;
    private ImageView I;
    private ProgressBar J;
    private FeedBackButton K;
    private boolean L;
    private AnyThinkSegmentsProgressBar M;
    private com.anythink.expressad.video.dynview.f.a N;
    private int O;
    private FrameLayout P;
    private AnythinkClickCTAView Q;
    private com.anythink.expressad.video.signal.factory.b R;
    private int S;
    private RelativeLayout T;
    private com.anythink.expressad.video.module.a.a U;
    private boolean V;
    private boolean W;
    private int aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private AlphaAnimation aJ;
    private AnythinkBaitClickView aK;
    private b aL;
    private boolean aM;
    private Runnable aN;
    private String aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private com.anythink.expressad.widget.a.a af;
    private com.anythink.expressad.widget.a.b ag;
    private String ah;
    private double ai;
    private double aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private int at;
    private boolean au;
    private int aw;
    private String ax;
    private int ay;
    private int az;
    public List<c> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkVideoView$11, reason: invalid class name */
    final class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkVideoView.p(AnythinkVideoView.this);
        }
    }

    public static class a {
        public int a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11871c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.a + ", allDuration=" + this.b + '}';
        }
    }

    private static final class b extends DefaultVideoPlayerStatusListener {
        private AnythinkVideoView a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11873d;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11878i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f11879j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private c f11880k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f11881l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f11882m;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a f11874e = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f11875f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11876g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11877h = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f11883n = false;

        public b(AnythinkVideoView anythinkVideoView) {
            this.a = anythinkVideoView;
        }

        private void b(int i2) {
            AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null || anythinkVideoView.F == null) {
                return;
            }
            String str = "anythink_reward_video_time_count_num_bg";
            if (this.f11880k.k() == 5) {
                AnythinkVideoView anythinkVideoView2 = this.a;
                if (anythinkVideoView2.mCurrPlayNum > 1 && i2 <= 0) {
                    anythinkVideoView2.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f10645c));
                    d();
                    return;
                }
            }
            if (i2 > 0) {
                d();
            } else {
                str = "anythink_reward_shape_progress";
            }
            this.a.F.setBackgroundResource(i.a(n.a().g(), str, i.f10645c));
        }

        private c c() {
            return this.f11880k;
        }

        private void d() {
            AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anythinkVideoView.F.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = t.b(n.a().g(), 25.0f);
                this.a.F.setLayoutParams(layoutParams);
            }
            int iB = t.b(n.a().g(), 5.0f);
            this.a.F.setPadding(iB, 0, iB, 0);
        }

        public final void a(c cVar) {
            this.f11880k = cVar;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                this.a.f11787e.a(14, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                this.a.f11787e.a(13, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            AnythinkVideoView anythinkVideoView;
            super.onPlayCompleted();
            AnythinkVideoView.w(this.a);
            c cVar = this.f11880k;
            if (cVar != null) {
                if (cVar.i() > 0) {
                    this.a.F.setText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
                } else {
                    this.a.F.setText("0");
                }
                this.f11880k.n(100);
                if (this.f11880k.f() == 2) {
                    this.a.G.setVisibility(4);
                    if (this.a.K != null) {
                        this.a.K.setClickable(false);
                    }
                    if (this.a.E != null) {
                        this.a.E.setClickable(false);
                    }
                }
            } else {
                this.a.F.setText("0");
            }
            this.a.D.setClickable(false);
            String strB = this.a.b(true);
            c cVar2 = this.f11880k;
            if (cVar2 != null && cVar2.k() == 5 && (anythinkVideoView = this.a) != null && anythinkVideoView.N != null) {
                AnythinkVideoView anythinkVideoView2 = this.a;
                if (anythinkVideoView2.mCampaignSize > anythinkVideoView2.mCurrPlayNum) {
                    HashMap map = new HashMap();
                    map.put("position", Integer.valueOf(this.a.mCurrPlayNum));
                    int i2 = this.a.mMuteSwitch;
                    if (i2 != 0) {
                        map.put("mute", Integer.valueOf(i2));
                    }
                    this.a.N.a(map);
                    return;
                }
            }
            this.a.f11787e.a(121, "");
            this.a.f11787e.a(11, strB);
            int i3 = this.f11872c;
            this.b = i3;
            this.a.mCurrentPlayProgressTime = i3;
            boolean unused = AnythinkVideoView.av = true;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            o.d("DefaultVideoPlayerStatusListener", "errorStr".concat(String.valueOf(str)));
            super.onPlayError(str);
            AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView != null) {
                anythinkVideoView.f11787e.a(12, str);
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i2, int i3) {
            int i4;
            String str;
            String strValueOf;
            super.onPlayProgress(i2, i3);
            if (this.a.f11788f) {
                int i5 = 0;
                c cVar = this.f11880k;
                if (cVar != null) {
                    i5 = cVar.i();
                    com.anythink.expressad.foundation.f.b.a().a(this.f11880k.K() + "_1", i2);
                }
                String str2 = "0";
                if (this.f11880k.j() && this.f11880k.k() == 5) {
                    try {
                        int i6 = this.a.O;
                        if (this.a != null) {
                            String strValueOf2 = (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
                            String str3 = (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", i.f10649g));
                            if (i5 >= 0) {
                                int i7 = i5 - i2;
                                if (i7 > 0) {
                                    strValueOf2 = i7 + str3;
                                }
                            } else {
                                int i8 = i6 - i2;
                                if (i8 <= 0) {
                                    if (i5 <= 0) {
                                    }
                                    this.f11874e.a = i2;
                                    this.a.F.setText(str2);
                                    if (this.a.J != null && this.a.J.getVisibility() == 0) {
                                        this.a.J.setProgress(i2);
                                    }
                                } else if (i5 <= 0) {
                                    strValueOf2 = String.valueOf(i8);
                                } else {
                                    strValueOf2 = i8 + str3;
                                }
                            }
                            str2 = strValueOf2;
                            this.f11874e.a = i2;
                            this.a.F.setText(str2);
                            if (this.a.J != null) {
                                this.a.J.setProgress(i2);
                            }
                        }
                    } catch (Exception e2) {
                        o.d("DefaultVideoPlayerStatusListener", e2.getMessage());
                    }
                } else {
                    if (this.a != null) {
                        if (i5 > i3) {
                            i5 = i3;
                        }
                        int i9 = i5 <= 0 ? i3 - i2 : i5 - i2;
                        if (i9 > 0) {
                            if (i5 <= 0) {
                                strValueOf = String.valueOf(i9);
                            } else {
                                strValueOf = i9 + ((String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", i.f10649g)));
                            }
                            str2 = strValueOf;
                        } else if (i5 > 0) {
                            str2 = (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
                        }
                        this.a.F.setText(str2);
                        if (this.a.J != null && this.a.J.getVisibility() == 0) {
                            this.a.J.setProgress(i2);
                        }
                    }
                    this.f11874e.a = i2;
                }
            }
            this.f11872c = i3;
            AnythinkVideoView anythinkVideoView = this.a;
            anythinkVideoView.mCurrentPlayProgressTime = i2;
            a aVar = this.f11874e;
            aVar.a = i2;
            aVar.b = i3;
            aVar.f11871c = anythinkVideoView.aG;
            this.b = i2;
            this.a.f11787e.a(15, this.f11874e);
            if (this.a.au && !this.a.aB && this.a.ay == com.anythink.expressad.foundation.g.a.cs) {
                this.a.e();
            }
            try {
                if (this.a != null && this.a.M != null) {
                    int i10 = (i2 * 100) / i3;
                    this.a.M.setProgress(i10, this.a.mCurrPlayNum - 1);
                    this.f11880k.n(i10);
                }
                if (this.a != null && this.a.S != -1 && i2 == this.a.S && this.a.b != null && this.a.b.j()) {
                    this.a.setCTALayoutVisibleOrGone();
                }
            } catch (Throwable th) {
                o.d("DefaultVideoPlayerStatusListener", th.getMessage());
            }
            int i11 = this.f11881l;
            if (i11 == 100 || this.f11883n || i11 == 0) {
                return;
            }
            if (this.f11882m > i11) {
                this.f11882m = i11 / 2;
            }
            int i12 = this.f11882m;
            if (i12 < 0 || i2 < (i4 = (i3 * i12) / 100)) {
                return;
            }
            if (this.f11880k.w() == 94 || this.f11880k.w() == 287) {
                str = this.f11880k.Z() + this.f11880k.aZ() + this.f11880k.S();
            } else {
                str = this.f11880k.aZ() + this.f11880k.S() + this.f11880k.B();
            }
            com.anythink.expressad.videocommon.b.c cVarA = e.a().a(this.f11879j, str);
            if (cVarA != null) {
                cVarA.i();
                this.f11883n = true;
                o.d("DefaultVideoPlayerStatusListener", "CDRate is : " + i4 + " and start download !");
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onPlayStarted(int r9) {
            /*
                Method dump skipped, instruction units count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkVideoView.b.onPlayStarted(int):void");
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            String str;
            if (this.f11880k.w() == 94 || this.f11880k.w() == 287) {
                str = this.f11880k.Z() + this.f11880k.aZ() + this.f11880k.S();
            } else {
                str = this.f11880k.aZ() + this.f11880k.S() + this.f11880k.B();
            }
            com.anythink.expressad.videocommon.b.c cVarA = e.a().a(this.f11879j, str);
            if (cVarA != null) {
                cVarA.i();
                this.f11883n = true;
                o.d("DefaultVideoPlayerStatusListener", "onVideoDownloadResume is : and start download !");
            }
        }

        public final void a(boolean z2) {
            this.f11878i = z2;
        }

        public final void a(String str) {
            this.f11879j = str;
        }

        public final int a() {
            return this.b;
        }

        public final void a(int i2, int i3) {
            this.f11881l = i2;
            this.f11882m = i3;
        }

        private void a(int i2) {
            if (i2 > 0) {
                this.a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f10645c));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t.b(n.a().g(), 30.0f));
                int iB = t.b(n.a().g(), 5.0f);
                layoutParams.addRule(1, i.a(n.a().g(), "anythink_native_endcard_feed_btn", "id"));
                layoutParams.setMargins(iB, 0, 0, 0);
                this.a.F.setPadding(iB, 0, iB, 0);
                this.a.F.setLayoutParams(layoutParams);
                return;
            }
            this.a.F.setBackgroundResource(i.a(n.a().g(), "anythink_reward_shape_progress", i.f10645c));
        }

        private void b(int i2, int i3, int i4) {
            String strValueOf;
            if (this.a == null) {
                return;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            int i5 = i2 <= 0 ? i3 - i4 : i2 - i4;
            if (i5 <= 0) {
                strValueOf = i2 <= 0 ? "0" : (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
            } else if (i2 <= 0) {
                strValueOf = String.valueOf(i5);
            } else {
                strValueOf = i5 + ((String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", i.f10649g)));
            }
            this.a.F.setText(strValueOf);
            if (this.a.J == null || this.a.J.getVisibility() != 0) {
                return;
            }
            this.a.J.setProgress(i4);
        }

        public final void b() {
            this.a = null;
            boolean unused = AnythinkVideoView.av = false;
        }

        private void a(int i2, int i3, int i4) {
            AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null) {
                return;
            }
            String strValueOf = (String) anythinkVideoView.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
            String str = (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", i.f10649g));
            if (i2 >= 0) {
                int i5 = i2 - i4;
                if (i5 > 0) {
                    strValueOf = i5 + str;
                }
            } else {
                int i6 = i3 - i4;
                if (i6 <= 0) {
                    if (i2 <= 0) {
                        strValueOf = "0";
                    }
                } else if (i2 <= 0) {
                    strValueOf = String.valueOf(i6);
                } else {
                    strValueOf = i6 + str;
                }
            }
            this.f11874e.a = i4;
            this.a.F.setText(strValueOf);
            if (this.a.J == null || this.a.J.getVisibility() != 0) {
                return;
            }
            this.a.J.setProgress(i4);
        }
    }

    public AnythinkVideoView(Context context) {
        super(context);
        this.mMuteSwitch = 0;
        this.O = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.V = false;
        this.W = false;
        this.ah = "";
        this.ak = false;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.au = false;
        this.aw = 2;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = true;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aL = new b(this);
        this.aM = false;
        this.aN = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AnythinkVideoView.this.P != null) {
                    AnythinkVideoView.this.P.setVisibility(8);
                }
            }
        };
    }

    static /* synthetic */ boolean e(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aH = true;
        return true;
    }

    static /* synthetic */ boolean h(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.V = false;
        return false;
    }

    static /* synthetic */ boolean k(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aC = true;
        return true;
    }

    static /* synthetic */ boolean l(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aG = true;
        return true;
    }

    static /* synthetic */ boolean n(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aD = true;
        return true;
    }

    static /* synthetic */ boolean p(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.ar = true;
        return true;
    }

    static /* synthetic */ boolean q(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.L = true;
        return true;
    }

    static /* synthetic */ boolean w(AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aF = true;
        return true;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void alertWebViewShowed() {
        this.V = true;
        setShowingAlertViewCover(this.V);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void closeVideoOperate(int i2, int i3) {
        if (i2 == 1) {
            this.aH = true;
            if (getVisibility() == 0) {
                e();
            }
        }
        if (i3 == 1) {
            gonePlayingCloseView();
            return;
        }
        if (i3 == 2) {
            if ((this.aG && getVisibility() == 0) || !this.f11788f || this.G.getVisibility() == 0) {
                return;
            }
            if (!this.f11791i || this.L) {
                this.G.setVisibility(0);
            }
            this.ao = true;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
        this.ak = true;
        showVideoLocation(0, 0, t.f(this.a), t.e(this.a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.ab == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void dismissAllAlert() {
        com.anythink.expressad.widget.a.a aVar = this.af;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.anythink.expressad.video.module.a.a aVar2 = this.f11787e;
        if (aVar2 != null) {
            aVar2.a(125, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewHeight() {
        return B;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewLeft() {
        return f11866z;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewRadius() {
        return f11864x;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewTop() {
        return f11865y;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewWidth() {
        return A;
    }

    public int getCloseAlert() {
        return this.ad;
    }

    @Override // com.anythink.expressad.video.signal.j
    public String getCurrentProgress() {
        try {
            int iA = this.aL.a();
            int iBi = this.b != null ? this.b.bi() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(iA, iBi));
            jSONObject.put("time", iA);
            jSONObject.put("duration", String.valueOf(iBi));
            return jSONObject.toString();
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public int getMute() {
        return this.aw;
    }

    public String getUnitId() {
        return this.ah;
    }

    public int getVideoSkipTime() {
        return this.ab;
    }

    public void gonePlayingCloseView() {
        if (this.f11788f && this.G.getVisibility() != 8) {
            this.G.setVisibility(8);
            this.ao = false;
        }
        if (this.aM || this.ar || this.ap) {
            return;
        }
        this.aM = true;
        int i2 = this.ab;
        if (i2 >= 0) {
            if (i2 == 0) {
                this.ar = true;
            } else {
                new Handler().postDelayed(new AnonymousClass11(), this.ab * 1000);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void hideAlertView(int i2) {
        if (this.V) {
            this.V = false;
            this.aB = true;
            setShowingAlertViewCover(this.V);
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false);
            if (i2 == 0) {
                i();
                if (this.au) {
                    int i3 = this.ay;
                    if (i3 == com.anythink.expressad.foundation.g.a.cs || i3 == com.anythink.expressad.foundation.g.a.cr) {
                        this.aC = true;
                        com.anythink.expressad.video.module.a.a aVar = this.f11787e;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        this.aG = true;
                        gonePlayingCloseView();
                        return;
                    }
                    return;
                }
                return;
            }
            this.aD = true;
            if (this.au && this.ay == com.anythink.expressad.foundation.g.a.cs) {
                i();
                return;
            }
            if (this.au && this.ay == com.anythink.expressad.foundation.g.a.cr) {
                com.anythink.expressad.video.module.a.a aVar2 = this.f11787e;
                if (aVar2 != null) {
                    aVar2.a(2, b(this.aF));
                    return;
                }
                return;
            }
            com.anythink.expressad.video.module.a.a aVar3 = this.f11787e;
            if (aVar3 != null) {
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    @Override // com.anythink.expressad.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < t.e(this.a.getApplicationContext());
    }

    public boolean isInstallDialogShowing() {
        return this.W;
    }

    public boolean isMiniCardShowing() {
        return this.an;
    }

    public boolean isShowingAlertView() {
        return this.V;
    }

    public boolean isShowingTransparent() {
        return this.as;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i2 = iIndexOfChild + 1;
        boolean z2 = false;
        while (i2 <= childCount - 1) {
            if (viewGroup.getChildAt(i2).getVisibility() == 0 && this.an) {
                return false;
            }
            i2++;
            z2 = true;
        }
        return z2;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void notifyCloseBtn(int i2) {
        if (i2 == 0) {
            this.ap = true;
            this.ar = false;
        } else if (i2 == 1) {
            this.aq = true;
        }
    }

    public void notifyVideoClose() {
        this.f11787e.a(2, "");
    }

    public void onBackPress() {
        if (this.an || this.V || this.aC) {
            return;
        }
        if (this.ao) {
            e();
            return;
        }
        if (this.ap && this.aq) {
            e();
        } else {
            if (this.ap || !this.ar) {
                return;
            }
            e();
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c cVar = this.b;
        if ((cVar == null || !cVar.j()) && this.f11788f && this.ak) {
            l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aN != null) {
                getHandler().removeCallbacks(this.aN);
            }
        } catch (Throwable th) {
            o.d(TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        c cVar;
        this.R = bVar;
        if (!this.f11788f) {
            com.anythink.expressad.video.module.a.a aVar = this.f11787e;
            if (aVar != null) {
                aVar.a(12, "AnyThinkVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.aa) && (cVar = this.b) != null) {
            if (cVar != null && w.b(cVar.U())) {
                String strU = this.b.U();
                o.b(TAG, "AnythinkBaseView videoResolution:".concat(String.valueOf(strU)));
                String[] strArrSplit = strU.split("x");
                if (strArrSplit.length == 2) {
                    if (t.b(strArrSplit[0]) > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                        this.ai = t.b(strArrSplit[0]);
                    }
                    if (t.b(strArrSplit[1]) > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                        this.aj = t.b(strArrSplit[1]);
                    }
                    o.b(TAG, "AnythinkBaseView mVideoW:" + this.ai + "  mVideoH:" + this.aj);
                }
                if (this.ai <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    this.ai = 1280.0d;
                }
                if (this.aj <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    this.aj = 720.0d;
                }
            }
            this.D.initBufferIngParam(this.ac);
            this.D.initVFPData(this.aa, this.b.S(), this.b.ao(), this.aL);
            soundOperate(this.aw, -1, null);
        }
        av = false;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressBarOperate(int i2) {
        ProgressBar progressBar;
        if (this.f11788f) {
            if (i2 == 1) {
                ProgressBar progressBar2 = this.J;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i2 != 2 || (progressBar = this.J) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressOperate(int i2, int i3) {
        if (this.f11788f) {
            o.b(TAG, "progressOperate progress:".concat(String.valueOf(i2)));
            c cVar = this.b;
            int iBi = cVar != null ? cVar.bi() : 0;
            if (i2 > 0 && i2 <= iBi && this.D != null) {
                o.b(TAG, "progressOperate progress:".concat(String.valueOf(i2)));
                this.D.seekTo(i2 * 1000);
            }
            if (i3 == 1) {
                this.F.setVisibility(8);
            } else if (i3 == 2) {
                this.F.setVisibility(0);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            if (this.D != null && !this.am) {
                this.D.release();
            }
            if (this.aL != null) {
                this.aL.b();
            }
            if (this.U != null) {
                this.U = null;
            }
        } catch (Exception e2) {
            o.d(TAG, e2.getMessage());
        }
    }

    public void setBufferTimeout(int i2) {
        this.ac = i2;
    }

    public void setCTALayoutVisibleOrGone() {
        FrameLayout frameLayout;
        c cVar = this.b;
        if (cVar != null && cVar.j() && (frameLayout = this.P) != null && this.S >= -1) {
            AnythinkClickCTAView anythinkClickCTAView = this.Q;
            if (anythinkClickCTAView == null && frameLayout != null) {
                if (anythinkClickCTAView == null) {
                    this.Q = new AnythinkClickCTAView(getContext());
                    this.Q.setCampaign(this.b);
                    this.Q.setUnitId(this.ah);
                    com.anythink.expressad.video.module.a.a aVar = this.U;
                    if (aVar != null) {
                        this.Q.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
                    }
                    this.Q.preLoadData(this.R);
                }
                this.P.addView(this.Q);
            }
            int i2 = this.S;
            if (i2 >= 0) {
                this.P.setVisibility(0);
                return;
            }
            if (i2 == -1) {
                if (this.P.getVisibility() != 0) {
                    this.P.setVisibility(0);
                    postDelayed(this.aN, m.ag);
                } else {
                    this.P.setVisibility(8);
                    getHandler().removeCallbacks(this.aN);
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, List<c> list, int i2, int i3) {
        AnyThinkSegmentsProgressBar anyThinkSegmentsProgressBar;
        this.N = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i2;
        this.O = i3;
        this.mCampOrderViewData = list;
        c cVar = this.b;
        if (cVar == null || cVar.k() != 5 || (anyThinkSegmentsProgressBar = this.M) == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize <= 1) {
            anyThinkSegmentsProgressBar.setVisibility(8);
            return;
        }
        anyThinkSegmentsProgressBar.setVisibility(0);
        this.M.init(this.mCampaignSize, 2);
        for (int i4 = 0; i4 < this.mCampOrderViewData.size(); i4++) {
            int iAF = this.mCampOrderViewData.get(i4).aF();
            if (iAF > 0) {
                this.M.setProgress(iAF, i4);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setCampaign(c cVar) {
        super.setCampaign(cVar);
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(cVar);
            b bVar2 = this.aL;
            int iV = (cVar == null || cVar.ao() == -1) ? com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v() : cVar.ao();
            bVar2.a(iV, com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).x());
        }
    }

    public void setCloseAlert(int i2) {
        this.ad = i2;
    }

    public void setContainerViewOnNotifyListener(com.anythink.expressad.video.module.a.a aVar) {
        this.U = aVar;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setCover(boolean z2) {
        if (this.f11788f) {
            this.D.setIsCovered(z2);
        }
    }

    public void setDialogRole(int i2) {
        this.aE = i2 == 1;
        o.d(TAG, i2 + " " + this.aE);
    }

    public void setIVRewardEnable(int i2, int i3, int i4) {
        this.ay = i2;
        this.az = i3;
        this.aA = i4;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setInstallDialogState(boolean z2) {
        this.W = z2;
        this.D.setIsCovered(z2);
    }

    public void setIsIV(boolean z2) {
        this.au = z2;
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setMiniEndCardState(boolean z2) {
        this.an = z2;
    }

    public void setNotchPadding(final int i2, final int i3, final int i4, final int i5) {
        try {
            o.d(TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            if (!(Math.max(Math.max(layoutParams.leftMargin, layoutParams.rightMargin), Math.max(layoutParams.topMargin, layoutParams.bottomMargin)) > Math.max(Math.max(i2, i3), Math.max(i4, i5))) && this.H != null) {
                this.H.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (AnythinkVideoView.this.H == null) {
                            return;
                        }
                        AnythinkVideoView.this.H.setVisibility(0);
                        c cVar = AnythinkVideoView.this.b;
                        if (cVar != null && !cVar.j() && AnythinkVideoView.this.b.f() != 2) {
                            AnythinkVideoView.this.H.setPadding(i2, i4, i3, i5);
                            AnythinkVideoView.this.H.startAnimation(AnythinkVideoView.this.aJ);
                        }
                        AnythinkVideoView.this.H.setVisibility(0);
                    }
                }, 200L);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
        } catch (Exception e2) {
            o.d(TAG, e2.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.aa = str;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setScaleFitXY(int i2) {
        this.at = i2;
    }

    public void setShowingAlertViewCover(boolean z2) {
        this.D.setIsCovered(z2);
    }

    public void setShowingTransparent(boolean z2) {
        this.as = z2;
    }

    public void setSoundState(int i2) {
        this.aw = i2;
    }

    public void setUnitId(String str) {
        this.ah = str;
        b bVar = this.aL;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void setVideoLayout(c cVar) {
        if (cVar != null) {
            this.b = cVar;
            this.f11791i = cVar.j();
        }
        if (this.f11791i) {
            new com.anythink.expressad.video.dynview.j.c();
            com.anythink.expressad.video.dynview.c cVarA = com.anythink.expressad.video.dynview.j.c.a(this, cVar);
            com.anythink.expressad.video.dynview.b.a();
            com.anythink.expressad.video.dynview.b.a(cVarA, new AnonymousClass1(this, cVarA));
            return;
        }
        int iFindLayout = findLayout(f11859s);
        if (iFindLayout > 0) {
            this.f11785c.inflate(iFindLayout, this);
            b();
        }
        av = false;
    }

    public void setVideoSkipTime(int i2) {
        this.ab = i2;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showAlertView() {
        if (this.an) {
            return;
        }
        if (this.ag == null) {
            this.ag = new com.anythink.expressad.widget.a.b() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.9
                @Override // com.anythink.expressad.widget.a.b
                public final void a() {
                    AnythinkVideoView.h(AnythinkVideoView.this);
                    AnythinkVideoView anythinkVideoView = AnythinkVideoView.this;
                    anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.V);
                    if (AnythinkVideoView.this.au && (AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cs || AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cr)) {
                        AnythinkVideoView.k(AnythinkVideoView.this);
                        com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        AnythinkVideoView.l(AnythinkVideoView.this);
                        AnythinkVideoView.this.gonePlayingCloseView();
                    }
                    AnythinkVideoView.this.i();
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void b() {
                    AnythinkVideoView.h(AnythinkVideoView.this);
                    AnythinkVideoView.n(AnythinkVideoView.this);
                    AnythinkVideoView anythinkVideoView = AnythinkVideoView.this;
                    anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.V);
                    if (AnythinkVideoView.this.au && AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cr) {
                        AnythinkVideoView anythinkVideoView2 = AnythinkVideoView.this;
                        com.anythink.expressad.video.module.a.a aVar = anythinkVideoView2.f11787e;
                        if (aVar != null) {
                            aVar.a(2, anythinkVideoView2.b(anythinkVideoView2.aF));
                            return;
                        }
                        return;
                    }
                    if (AnythinkVideoView.this.au && AnythinkVideoView.this.ay == com.anythink.expressad.foundation.g.a.cs) {
                        AnythinkVideoView.this.i();
                        return;
                    }
                    com.anythink.expressad.video.module.a.a aVar2 = AnythinkVideoView.this.f11787e;
                    if (aVar2 != null) {
                        aVar2.a(2, "");
                    }
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void c() {
                    a();
                }
            };
        }
        if (this.af == null) {
            this.af = new com.anythink.expressad.widget.a.a(getContext(), this.ag);
        }
        if (this.au) {
            this.af.a(this.ay, this.ah);
        } else {
            this.af.b();
        }
        PlayerView playerView = this.D;
        if (playerView == null || playerView.isComplete()) {
            return;
        }
        this.af.show();
        this.aB = true;
        this.V = true;
        setShowingAlertViewCover(this.V);
        com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false);
        this.ax = d.J();
    }

    public void showBaitClickView() {
        int i2;
        c cVar = this.b;
        if (cVar == null || !cVar.j() || this.b.M() == null) {
            return;
        }
        String strE = this.b.M().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = x.a(strE, "bait_click");
            if (TextUtils.isEmpty(strA) || (i2 = Integer.parseInt(strA)) == 0 || this.aK == null) {
                return;
            }
            this.aK.setVisibility(0);
            this.aK.init(i2);
            this.aK.startAnimation();
            this.aK.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                    if (aVar != null) {
                        aVar.a(1, "");
                    }
                }
            });
        } catch (Exception e2) {
            o.d(TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.f11787e.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        c cVar = this.b;
        if (cVar == null || this.T == null || !cVar.j() || this.b.M() == null || TextUtils.isEmpty(this.b.M().e())) {
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showVideoLocation(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        o.b(TAG, "showVideoLocation marginTop:" + i2 + " marginLeft:" + i3 + " width:" + i4 + "  height:" + i5 + " radius:" + i6 + " borderTop:" + i7 + " borderLeft:" + i8 + " borderWidth:" + i9 + " borderHeight:" + i10);
        if (this.f11788f) {
            this.H.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.H.getVisibility() != 0) {
                this.H.setVisibility(0);
            }
            if (this.F.getVisibility() == 0) {
                n();
            }
            if (!(i4 > 0 && i5 > 0 && t.f(this.a) >= i4 && t.e(this.a) >= i5) || this.ak) {
                l();
                return;
            }
            f11865y = i7;
            f11866z = i8;
            A = i9 + 4;
            B = i10 + 4;
            float f2 = i4 / i5;
            float f3 = 0.0f;
            try {
                f3 = (float) (this.ai / this.aj);
            } catch (Throwable th) {
                o.b(TAG, th.getMessage(), th);
            }
            if (i6 > 0) {
                f11864x = i6;
                if (i6 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(t.b(getContext(), i6));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    if (Build.VERSION.SDK_INT >= 16) {
                        setBackground(gradientDrawable);
                        this.D.setBackground(gradientDrawable);
                    } else {
                        setBackgroundDrawable(gradientDrawable);
                        this.D.setBackgroundDrawable(gradientDrawable);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        this.D.setClipToOutline(true);
                    }
                }
            }
            if (Math.abs(f2 - f3) > 0.1f && this.at != 1) {
                l();
                videoOperate(1);
                return;
            }
            l();
            if (!this.as) {
                setLayoutParam(i3, i2, i4, i5);
                return;
            }
            setLayoutCenter(i4, i5);
            if (av) {
                this.f11787e.a(114, "");
            } else {
                this.f11787e.a(116, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i2, int i3) {
        soundOperate(i2, i3, "2");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void videoOperate(int i2) {
        o.a(TAG, "VideoView videoOperate:".concat(String.valueOf(i2)));
        if (this.f11788f) {
            if (i2 == 1) {
                if (getVisibility() == 0 && isfront()) {
                    o.a(TAG, "VideoView videoOperate:play");
                    if (this.V || this.an || this.W || com.anythink.expressad.foundation.f.b.f10401c) {
                        return;
                    }
                    i();
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (getVisibility() == 0) {
                    o.a(TAG, "VideoView videoOperate:pause");
                    h();
                    return;
                }
                return;
            }
            if (i2 == 3) {
                if (this.am) {
                    return;
                }
                this.D.release();
                this.am = true;
                return;
            }
            if (i2 == 5) {
                this.W = true;
                if (this.am) {
                    return;
                }
                h();
                return;
            }
            if (i2 == 4) {
                this.W = false;
                if (this.am || isMiniCardShowing()) {
                    return;
                }
                i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (!this.au || (this.ay != com.anythink.expressad.foundation.g.a.cr && this.ay != com.anythink.expressad.foundation.g.a.cs)) {
                if (this.b == null || this.b.f() == 2) {
                    if (this.f11787e != null) {
                        this.f11787e.a(2, "");
                        return;
                    }
                    return;
                }
                int i2 = this.b.i();
                int curPosition = this.D.getCurPosition() / 1000;
                boolean z2 = false;
                if (this.b.k() != 5 || this.mCurrPlayNum <= 1 ? !((i2 <= 0 || curPosition >= i2) && i2 != 0) : !(i2 == 0 || i2 <= 0 || curPosition >= i2)) {
                    z2 = true;
                }
                if (!z2 || this.ad != 1 || this.as) {
                    if (this.f11787e != null) {
                        this.f11787e.a(2, "");
                        return;
                    }
                    return;
                } else {
                    h();
                    if (this.f11787e != null) {
                        this.f11787e.a(8, "");
                        return;
                    }
                    return;
                }
            }
            if (this.aB) {
                if (this.ay != com.anythink.expressad.foundation.g.a.cs || this.f11787e == null) {
                    return;
                }
                this.f11787e.a(2, b(this.aF));
                return;
            }
            if (this.ay == com.anythink.expressad.foundation.g.a.cs && this.aH) {
                if (this.f11787e != null) {
                    this.f11787e.a(2, b(this.aF));
                    return;
                }
                return;
            }
            if (this.aE) {
                int curPosition2 = this.D.getCurPosition() / 1000;
                int iBi = (int) ((curPosition2 / (this.D.getDuration() == 0 ? this.b.bi() : this.D.getDuration())) * 100.0f);
                if (this.ay == com.anythink.expressad.foundation.g.a.cr) {
                    h();
                    if (this.az == com.anythink.expressad.foundation.g.a.ct && iBi >= this.aA) {
                        if (this.f11787e != null) {
                            this.f11787e.a(2, b(this.aF));
                            return;
                        }
                        return;
                    } else if (this.az == com.anythink.expressad.foundation.g.a.cu && curPosition2 >= this.aA) {
                        if (this.f11787e != null) {
                            this.f11787e.a(2, b(this.aF));
                            return;
                        }
                        return;
                    } else if (this.f11787e != null) {
                        this.f11787e.a(8, "");
                    }
                }
                if (this.ay == com.anythink.expressad.foundation.g.a.cs) {
                    if (this.az == com.anythink.expressad.foundation.g.a.ct && iBi >= this.aA) {
                        h();
                        if (this.f11787e != null) {
                            this.f11787e.a(8, "");
                            return;
                        }
                        return;
                    }
                    if (this.az != com.anythink.expressad.foundation.g.a.cu || curPosition2 < this.aA) {
                        return;
                    }
                    h();
                    if (this.f11787e != null) {
                        this.f11787e.a(8, "");
                    }
                }
            }
        } catch (Exception e2) {
            o.d(TAG, e2.getMessage());
        }
    }

    private boolean f() {
        try {
            this.D = (PlayerView) findViewById(filterFindViewId(this.aI, "anythink_vfpv"));
            this.E = (SoundImageView) findViewById(filterFindViewId(this.aI, "anythink_sound_switch"));
            this.F = (TextView) findViewById(filterFindViewId(this.aI, "anythink_tv_count"));
            this.G = findViewById(filterFindViewId(this.aI, "anythink_rl_playing_close"));
            this.G.setVisibility(4);
            this.H = (RelativeLayout) findViewById(filterFindViewId(this.aI, "anythink_top_control"));
            this.I = (ImageView) findViewById(filterFindViewId(this.aI, "anythink_videoview_bg"));
            this.J = (ProgressBar) findViewById(filterFindViewId(this.aI, "anythink_video_progress_bar"));
            this.K = (FeedBackButton) findViewById(filterFindViewId(this.aI, "anythink_native_endcard_feed_btn"));
            this.M = (AnyThinkSegmentsProgressBar) findViewById(filterFindViewId(this.aI, "anythink_reward_segment_progressbar"));
            this.P = (FrameLayout) findViewById(filterFindViewId(this.aI, "anythink_reward_cta_layout"));
            this.aK = (AnythinkBaitClickView) findViewById(filterFindViewId(this.aI, "anythink_animation_click_view"));
            this.T = (RelativeLayout) findViewById(filterFindViewId(this.aI, "anythink_reward_moreoffer_layout"));
            try {
                String strAE = this.b.aE();
                if (TextUtils.isEmpty(strAE)) {
                    strAE = com.anythink.expressad.a.ab;
                }
                if (!TextUtils.isEmpty(strAE)) {
                    com.anythink.expressad.foundation.g.d.b.a(this.a).a(strAE, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.10
                        @Override // com.anythink.expressad.foundation.g.d.c
                        public final void a(Bitmap bitmap, String str) {
                            int iB = t.b(AnythinkVideoView.this.a, 12.0f);
                            ImageView imageView = new ImageView(AnythinkVideoView.this.a);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setImageBitmap(bitmap);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (iB * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight())), iB);
                            layoutParams.addRule(11);
                            layoutParams.addRule(12);
                            layoutParams.bottomMargin = t.b(AnythinkVideoView.this.a, 5.0f);
                            layoutParams.rightMargin = t.b(AnythinkVideoView.this.a, 12.0f);
                            AnythinkVideoView.this.addView(imageView, layoutParams);
                        }

                        @Override // com.anythink.expressad.foundation.g.d.c
                        public final void a(String str, String str2) {
                        }
                    });
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d(TAG, e2.getLocalizedMessage());
                }
            }
            return isNotNULL(this.D, this.E, this.F, this.G);
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    private void g() {
        c cVar = this.b;
        if (cVar == null || !w.b(cVar.U())) {
            return;
        }
        String strU = this.b.U();
        o.b(TAG, "AnythinkBaseView videoResolution:".concat(String.valueOf(strU)));
        String[] strArrSplit = strU.split("x");
        if (strArrSplit.length == 2) {
            if (t.b(strArrSplit[0]) > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                this.ai = t.b(strArrSplit[0]);
            }
            if (t.b(strArrSplit[1]) > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                this.aj = t.b(strArrSplit[1]);
            }
            o.b(TAG, "AnythinkBaseView mVideoW:" + this.ai + "  mVideoH:" + this.aj);
        }
        if (this.ai <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            this.ai = 1280.0d;
        }
        if (this.aj <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            this.aj = 720.0d;
        }
    }

    private void h() {
        try {
            if (this.D != null) {
                this.D.setIsCovered(this.W || this.V);
                this.D.onPause();
                if (this.b == null || this.b.L() == null || this.b.aw()) {
                    return;
                }
                this.b.ax();
                com.anythink.expressad.a.a.a(n.a().g(), this.b, this.ah, this.b.L().m(), false);
            }
        } catch (Throwable th) {
            o.b(TAG, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.al) {
                if (this.W || this.V) {
                    return;
                }
                this.D.setIsCovered(false);
                this.D.onResume();
                return;
            }
            boolean zPlayVideo = this.D.playVideo();
            if (this.b != null && this.b.J() != 2 && !zPlayVideo) {
                o.d("MediaPlayer", "播放失败");
                if (this.aL != null) {
                    this.aL.onPlayError("play video failed");
                }
            }
            this.al = true;
        } catch (Exception e2) {
            o.b(TAG, e2.getMessage(), e2);
        }
    }

    private void j() {
        if (!this.f11788f || this.G.getVisibility() == 0) {
            return;
        }
        if (!this.f11791i || this.L) {
            this.G.setVisibility(0);
        }
        this.ao = true;
    }

    private void k() {
        if (this.aM || this.ar || this.ap) {
            return;
        }
        this.aM = true;
        int i2 = this.ab;
        if (i2 >= 0) {
            if (i2 == 0) {
                this.ar = true;
            } else {
                new Handler().postDelayed(new AnonymousClass11(), this.ab * 1000);
            }
        }
    }

    private void l() {
        float f2;
        float f3 = t.f(this.a);
        float fE = t.e(this.a);
        c.C0205c c0205cM = this.b.M();
        if (c0205cM != null && ((c0205cM.c() == 1 && f3 > fE) || (c0205cM.c() == 2 && fE > f3))) {
            float f4 = f3 + fE;
            fE = f4 - fE;
            f3 = f4 - fE;
        }
        int iB = t.b(getContext(), 58.0f);
        int iB2 = t.b(getContext(), 104.0f);
        c cVar = this.b;
        if (cVar != null && cVar.f() == 2) {
            int iC = this.b.M().c();
            if (iC == 1) {
                f3 -= iB * 2;
                fE -= iB2 * 2;
            }
            if (iC == 2) {
                f3 -= iB2 * 2;
                fE -= iB * 2;
            }
            if (iC == 0) {
                if (this.f11786d == 1) {
                    f3 -= iB * 2;
                    f2 = iB2 * 2;
                } else {
                    f3 -= iB2 * 2;
                    f2 = iB * 2;
                }
                fE -= f2;
            }
        }
        double d2 = this.ai;
        if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            double d3 = this.aj;
            if (d3 > PangleAdapterUtils.CPM_DEFLAUT_VALUE && f3 > 0.0f && fE > 0.0f) {
                double d4 = d2 / d3;
                double d5 = f3 / fE;
                o.b(TAG, "videoWHDivide:" + d4 + "  screenWHDivide:" + d5);
                double dA = t.a(Double.valueOf(d4));
                double dA2 = t.a(Double.valueOf(d5));
                o.b(TAG, "videoWHDivideFinal:" + dA + "  screenWHDivideFinal:" + dA2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
                if (dA > dA2) {
                    double d6 = f3;
                    double d7 = this.aj;
                    Double.isNaN(d6);
                    double d8 = (d6 * d7) / this.ai;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d8;
                    layoutParams.gravity = 17;
                } else if (dA < dA2) {
                    double d9 = fE;
                    Double.isNaN(d9);
                    layoutParams.width = (int) (d9 * d4);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    if (this.b != null && this.b.j()) {
                        int iB3 = this.b.M().b();
                        int iC2 = this.b.M().c();
                        if (iB3 == 102 || iB3 == 202) {
                            if (iC2 == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                double d10 = this.aj;
                                double d11 = this.ai;
                                double d12 = f3;
                                Double.isNaN(d12);
                                layoutParams.height = (int) (d10 / (d11 / d12));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                double d13 = fE;
                                Double.isNaN(d13);
                                layoutParams.width = (int) (d13 * d4);
                            }
                        }
                        if (iB3 == 202 && !TextUtils.isEmpty(this.b.be())) {
                            a(this.b.be());
                        }
                        if (iB3 == 302 || iB3 == 802) {
                            if (this.ai / this.aj > 1.0d) {
                                layoutParams.width = -1;
                                double d14 = this.aj;
                                double d15 = f3;
                                Double.isNaN(d15);
                                layoutParams.height = (int) ((d14 * d15) / this.ai);
                            } else {
                                int iB4 = t.b(getContext(), 220.0f);
                                double d16 = this.ai;
                                double d17 = iB4;
                                Double.isNaN(d17);
                                layoutParams.width = (int) ((d16 * d17) / this.aj);
                                layoutParams.height = iB4;
                            }
                        }
                    }
                } catch (Throwable th) {
                    o.d(TAG, th.getMessage());
                }
                this.D.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        m();
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.f11788f) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
            int iF = t.f(this.a);
            layoutParams.width = -1;
            layoutParams.height = (iF * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = this.K;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ah);
        com.anythink.expressad.foundation.f.b.a().a(this.ah + "_1", this.b);
        com.anythink.expressad.foundation.f.b.a().a(this.ah + "_1", this.K);
    }

    private int o() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).x();
    }

    private void p() {
        if (this.P == null) {
            return;
        }
        if (this.Q == null) {
            this.Q = new AnythinkClickCTAView(getContext());
            this.Q.setCampaign(this.b);
            this.Q.setUnitId(this.ah);
            com.anythink.expressad.video.module.a.a aVar = this.U;
            if (aVar != null) {
                this.Q.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
            }
            this.Q.preLoadData(this.R);
        }
        this.P.addView(this.Q);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f11788f) {
            if (!this.f11791i) {
                this.D.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                        if (aVar != null) {
                            aVar.a(1, "");
                        }
                    }
                });
            } else if (com.anythink.expressad.video.dynview.i.c.a(this.b) == -1 || com.anythink.expressad.video.dynview.i.c.a(this.b) == 100) {
                this.D.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                        if (aVar != null) {
                            aVar.a(1, "");
                        }
                        AnythinkVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.E;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Integer num = 2;
                        if (AnythinkVideoView.this.D != null && AnythinkVideoView.this.D.isSilent()) {
                            num = 1;
                        }
                        if (num.intValue() == 1) {
                            AnythinkVideoView.this.mMuteSwitch = 2;
                        } else {
                            AnythinkVideoView.this.mMuteSwitch = 1;
                        }
                        com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                        if (aVar != null) {
                            aVar.a(5, num);
                        }
                    }
                });
            }
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (!AnythinkVideoView.this.au) {
                        AnythinkVideoView.this.e();
                        return;
                    }
                    AnythinkVideoView.e(AnythinkVideoView.this);
                    if (AnythinkVideoView.this.aE) {
                        AnythinkVideoView.this.e();
                        return;
                    }
                    com.anythink.expressad.video.module.a.a aVar = AnythinkVideoView.this.f11787e;
                    if (aVar != null) {
                        aVar.a(123, "");
                    }
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i2, int i3, String str) {
        com.anythink.expressad.video.module.a.a aVar;
        SoundImageView soundImageView;
        if (this.f11788f) {
            this.aw = i2;
            if (i2 == 1) {
                SoundImageView soundImageView2 = this.E;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.D.closeSound();
            } else if (i2 == 2) {
                SoundImageView soundImageView3 = this.E;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.D.openSound();
            }
            c cVar = this.b;
            if (cVar != null && cVar.j()) {
                SoundImageView soundImageView4 = this.E;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i3 == 1) {
                SoundImageView soundImageView5 = this.E;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i3 == 2 && (soundImageView = this.E) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.f11787e) == null) {
            return;
        }
        aVar.a(7, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f11788f = f();
        if (!this.f11788f) {
            o.d(TAG, "AnythinkVideoView init fail");
        }
        c();
        this.aJ = new AlphaAnimation(0.0f, 100.0f);
        this.aJ.setDuration(200L);
    }

    private void a() {
        int iFindLayout = findLayout(f11859s);
        if (iFindLayout > 0) {
            this.f11785c.inflate(iFindLayout, this);
            b();
        }
        av = false;
    }

    private void a(ViewGroup viewGroup, c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c cVarA = com.anythink.expressad.video.dynview.j.c.a(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(cVarA, new AnonymousClass1(viewGroup, cVarA));
    }

    private void b(int i2) {
        if (i2 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t.b(getContext(), i2));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(gradientDrawable);
                this.D.setBackground(gradientDrawable);
            } else {
                setBackgroundDrawable(gradientDrawable);
                this.D.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(true);
                this.D.setClipToOutline(true);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkVideoView$1, reason: invalid class name */
    final class AnonymousClass1 implements h {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ com.anythink.expressad.video.dynview.c b;

        AnonymousClass1(ViewGroup viewGroup, com.anythink.expressad.video.dynview.c cVar) {
            this.a = viewGroup;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            if (this.a != null && aVar.a() != null) {
                aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.a.addView(aVar.a());
            }
            if (aVar.b() != null) {
                Iterator<View> it = aVar.b().iterator();
                while (it.hasNext()) {
                    it.next().setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.1.1
                        @Override // com.anythink.expressad.widget.a
                        protected final void a(View view) {
                            JSONObject jSONObject;
                            JSONException e2;
                            if (AnythinkVideoView.this.U != null) {
                                try {
                                    jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(com.anythink.expressad.foundation.g.a.ce, AnythinkVideoView.this.a(0));
                                    } catch (JSONException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                    }
                                } catch (JSONException e4) {
                                    jSONObject = null;
                                    e2 = e4;
                                }
                                AnythinkVideoView.this.U.a(105, jSONObject);
                                n.a().g();
                            }
                        }
                    });
                }
            }
            AnythinkVideoView.this.aI = aVar.c();
            AnythinkVideoView.this.b();
            boolean unused = AnythinkVideoView.av = false;
            AnythinkVideoView.this.S = this.b.j();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            o.d(AnythinkVideoView.TAG, "errorMsg：" + bVar.b());
        }
    }

    private static String a(int i2, int i3) {
        if (i3 != 0) {
            double d2 = i2 / i3;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(t.a(Double.valueOf(d2)));
                return sb.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return String.valueOf(i3);
    }

    private int a(c cVar) {
        if (cVar != null) {
            if (cVar.ao() != -1) {
                return cVar.ao();
            }
            return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ah, false).v();
    }

    private void a(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                if (bitmap != null) {
                    try {
                        if (bitmap.isRecycled() || AnythinkVideoView.this.I == null) {
                            return;
                        }
                        AnythinkVideoView.this.I.setVisibility(0);
                        ImageView imageView = AnythinkVideoView.this.I;
                        com.anythink.expressad.video.dynview.i.b.a();
                        imageView.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 20));
                    } catch (Throwable th) {
                        o.d(AnythinkVideoView.TAG, th.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(AnythinkVideoView.TAG, str2);
            }
        });
    }

    private boolean b(int i2, int i3) {
        return i2 > 0 && i3 > 0 && t.f(this.a) >= i2 && t.e(this.a) >= i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(boolean z2) {
        if (!this.au) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.aB) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cv);
            }
            if (this.aD) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cx);
            }
            if (this.aC) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cw);
            }
            jSONObject.put("complete_info", z2 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            o.d(TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    public AnythinkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMuteSwitch = 0;
        this.O = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.V = false;
        this.W = false;
        this.ah = "";
        this.ak = false;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.au = false;
        this.aw = 2;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = true;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aL = new b(this);
        this.aM = false;
        this.aN = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkVideoView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AnythinkVideoView.this.P != null) {
                    AnythinkVideoView.this.P.setVisibility(8);
                }
            }
        };
    }
}
