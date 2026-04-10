package com.anythink.basead.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.anythink.basead.a.b.g;
import com.anythink.core.common.k.h;
import com.anythink.expressad.exoplayer.ad;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.i;
import com.anythink.expressad.exoplayer.l.g;
import com.anythink.expressad.exoplayer.w;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class PlayerView extends RelativeLayout {
    public static final String TAG = PlayerView.class.getSimpleName();
    private Handler A;
    private boolean B;
    private Thread C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private View H;
    private w.c I;
    private g J;
    int a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f6267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ad f6268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private s f6269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextureView f6270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f6272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f6280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f6284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f6285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f6286x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f6287y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f6288z;

    /* JADX INFO: renamed from: com.anythink.basead.ui.PlayerView$2, reason: invalid class name */
    final class AnonymousClass2 extends w.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
            boolean z2;
            long jT;
            super.onPlayerError(gVar);
            String str = "Play error and ExoPlayer have not message.";
            if (gVar != null) {
                int i2 = gVar.f9070d;
                z2 = true;
                if (i2 != 0) {
                    if (i2 == 1) {
                        str = "Play error, because have a RendererException.";
                    } else if (i2 == 2) {
                        str = "Play error, because have a UnexpectedException.";
                    }
                    z2 = false;
                } else {
                    str = "Play error, because have a SourceException.";
                }
                if (gVar.getCause() != null && !TextUtils.isEmpty(gVar.getCause().getMessage())) {
                    str = str + ",eception:" + gVar.getCause().getMessage();
                }
            } else {
                z2 = false;
            }
            if (PlayerView.this.f6266d && z2) {
                String str2 = PlayerView.TAG;
                StringBuilder sb = new StringBuilder("ExoPlayer onPlayerError()...error:");
                sb.append(str);
                sb.append(",and rePrepareVideoSourceAgain");
                PlayerView playerView = PlayerView.this;
                playerView.f6266d = false;
                PlayerView.p(playerView);
                return;
            }
            String str3 = PlayerView.TAG;
            PlayerView.this.e();
            if (PlayerView.this.f6288z != null) {
                try {
                    jT = PlayerView.this.f6268f.t();
                } catch (Throwable unused) {
                    jT = 0;
                }
                String str4 = jT <= 0 ? com.anythink.basead.c.f.f5911o : com.anythink.basead.c.f.f5907k;
                String str5 = "videoUrl:" + PlayerView.this.f6272j + ",readyRate:" + PlayerView.this.f6265c + ",cdRate:" + PlayerView.this.b + ",play process:" + jT + ",errorMessage:" + str;
                if (PlayerView.this.f6286x) {
                    PlayerView.this.f6288z.a(com.anythink.basead.c.f.a(str4, com.anythink.basead.c.f.C.concat(String.valueOf(str5))));
                } else {
                    PlayerView.this.f6288z.a(com.anythink.basead.c.f.a(str4, com.anythink.basead.c.f.K.concat(String.valueOf(str5))));
                }
            }
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerStateChanged(boolean z2, int i2) {
            super.onPlayerStateChanged(z2, i2);
            String str = PlayerView.TAG;
            if (i2 == 2) {
                if (PlayerView.this.f6287y) {
                    return;
                }
                PlayerView.this.f6287y = true;
                PlayerView.v(PlayerView.this);
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                PlayerView.this.e();
                PlayerView.y(PlayerView.this);
                PlayerView playerView = PlayerView.this;
                playerView.f6275m = playerView.f6276n;
                if (PlayerView.this.f6288z != null) {
                    PlayerView.this.f6288z.c();
                    return;
                }
                return;
            }
            if (!PlayerView.this.f6286x) {
                PlayerView.w(PlayerView.this);
                PlayerView.this.f6287y = false;
                PlayerView playerView2 = PlayerView.this;
                playerView2.f6276n = (int) playerView2.f6268f.s();
                if (PlayerView.this.f6288z != null) {
                    PlayerView.this.f6288z.c(PlayerView.this.f6276n);
                }
                PlayerView.this.f6277o = Math.round(r6.f6276n * 0.25f);
                PlayerView.this.f6278p = Math.round(r6.f6276n * 0.5f);
                PlayerView.this.f6279q = Math.round(r6.f6276n * 0.75f);
                PlayerView playerView3 = PlayerView.this;
                int i3 = playerView3.f6265c;
                if (i3 <= 0 || i3 >= 100) {
                    PlayerView.this.G = false;
                } else {
                    if (playerView3.b > i3) {
                        playerView3.b = i3 / 2;
                    }
                    PlayerView.this.a = Math.round(((r6.b * 1.0f) / 100.0f) * r6.f6276n);
                    r6.a -= 2000;
                    PlayerView.this.G = true;
                }
            }
            if (PlayerView.this.f6275m <= 0 || PlayerView.this.f6275m == PlayerView.this.f6268f.t()) {
                return;
            }
            PlayerView.this.f6268f.a(PlayerView.this.f6275m);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PlayerView$3, reason: invalid class name */
    final class AnonymousClass3 implements g {
        AnonymousClass3() {
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a(int i2, int i3) {
            PlayerView playerView = PlayerView.this;
            playerView.autoFitVideoSize(i2, i3, playerView.f6270h);
        }
    }

    public interface a {
        void a();

        void a(int i2);

        void a(com.anythink.basead.c.e eVar);

        void b();

        void b(int i2);

        void c();

        void c(int i2);

        void d();

        void e();

        void f();

        void g();
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6271i = "";
        this.f6272j = "";
        this.f6275m = -1;
        this.f6283u = false;
        this.f6284v = false;
        this.f6285w = false;
        this.f6286x = false;
        this.f6287y = false;
        this.b = 0;
        this.f6265c = 0;
        this.f6266d = false;
        this.f6267e = "";
        setSaveEnabled(true);
        this.A = new Handler(Looper.getMainLooper()) { // from class: com.anythink.basead.ui.PlayerView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                PlayerView.this.f6275m = message.what;
                if (PlayerView.this.f6275m <= 0) {
                    return;
                }
                if (!PlayerView.this.f6284v && !PlayerView.this.f6285w) {
                    PlayerView.d(PlayerView.this);
                    if (PlayerView.this.f6288z != null) {
                        PlayerView.this.f6288z.a();
                    }
                }
                if (PlayerView.this.f6288z != null) {
                    PlayerView.this.f6288z.a(PlayerView.this.f6275m);
                }
                if (!PlayerView.this.f6280r && PlayerView.this.f6275m >= PlayerView.this.f6277o) {
                    PlayerView.h(PlayerView.this);
                    if (PlayerView.this.f6288z != null) {
                        PlayerView.this.f6288z.b(25);
                    }
                } else if (!PlayerView.this.f6281s && PlayerView.this.f6275m >= PlayerView.this.f6278p) {
                    PlayerView.k(PlayerView.this);
                    if (PlayerView.this.f6288z != null) {
                        PlayerView.this.f6288z.b(50);
                    }
                } else if (!PlayerView.this.f6282t && PlayerView.this.f6275m >= PlayerView.this.f6279q) {
                    PlayerView.n(PlayerView.this);
                    if (PlayerView.this.f6288z != null) {
                        PlayerView.this.f6288z.b(75);
                    }
                }
                if (PlayerView.this.G) {
                    int i2 = PlayerView.this.f6275m;
                    PlayerView playerView = PlayerView.this;
                    if (i2 < playerView.a || playerView.f6288z == null) {
                        return;
                    }
                    PlayerView.this.G = false;
                    PlayerView.this.f6288z.g();
                }
            }
        };
        setBackgroundColor(-16777216);
    }

    static /* synthetic */ boolean h(PlayerView playerView) {
        playerView.f6280r = true;
        return true;
    }

    static /* synthetic */ boolean k(PlayerView playerView) {
        playerView.f6281s = true;
        return true;
    }

    static /* synthetic */ boolean n(PlayerView playerView) {
        playerView.f6282t = true;
        return true;
    }

    static /* synthetic */ void p(PlayerView playerView) {
        a aVar = playerView.f6288z;
        if (aVar != null) {
            aVar.g();
        }
        playerView.f6268f.a(playerView.f6269g);
    }

    static /* synthetic */ void v(PlayerView playerView) {
        View view = playerView.H;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    static /* synthetic */ boolean w(PlayerView playerView) {
        playerView.f6286x = true;
        return true;
    }

    static /* synthetic */ boolean y(PlayerView playerView) {
        playerView.f6285w = true;
        return true;
    }

    public void autoFitVideoSize(int i2, int i3, View view) {
        float fMax = Math.max(i2 / view.getMeasuredWidth(), i3 / view.getMeasuredHeight());
        int iCeil = (int) Math.ceil(r4 / fMax);
        int iCeil2 = (int) Math.ceil(r5 / fMax);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = iCeil;
        layoutParams.height = iCeil2;
        view.setLayoutParams(layoutParams);
    }

    public int getCurrentPosition() {
        return Math.max(this.f6275m, 0);
    }

    public int getVideoLength() {
        return this.f6276n;
    }

    public boolean hasVideo() {
        return this.F;
    }

    public void initMuteStatus(boolean z2) {
        this.B = z2;
    }

    public boolean isComplete() {
        return this.f6285w;
    }

    public boolean isMute() {
        return this.B;
    }

    public boolean isPlaying() {
        ad adVar = this.f6268f;
        return adVar != null && adVar.J();
    }

    public void load(String str, boolean z2) {
        boolean z3;
        int i2;
        this.f6272j = str;
        com.anythink.basead.a.f.a();
        this.f6271i = com.anythink.basead.a.f.a(4, str);
        if (new File(this.f6271i).exists() || !TextUtils.isEmpty(this.f6272j)) {
            this.F = true;
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            a aVar = this.f6288z;
            if (aVar != null) {
                aVar.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, com.anythink.basead.c.f.J));
                return;
            }
            return;
        }
        if (this.f6273k == 0 || this.f6274l == 0) {
            try {
                String strG = g();
                int i3 = this.D;
                int i4 = this.E;
                g.a aVarA = com.anythink.basead.a.b.g.a(strG);
                if (aVarA == null) {
                    aVarA = null;
                } else {
                    float f2 = (aVarA.a * 1.0f) / aVarA.b;
                    if (f2 < (i3 * 1.0f) / i4) {
                        aVarA.b = i4;
                        aVarA.a = (int) (aVarA.b * f2);
                    } else {
                        aVarA.a = i3;
                        aVarA.b = (int) (aVarA.a / f2);
                    }
                }
                if (aVarA != null) {
                    this.f6273k = aVarA.a;
                    this.f6274l = aVarA.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.f6273k);
                sb.append(", ");
                sb.append(this.f6274l);
                if (this.D == this.f6273k) {
                    if (this.E - this.f6274l <= h.a(getContext(), 1.0f)) {
                        this.f6274l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.f6274l);
                    }
                } else if (this.E == this.f6274l && this.D - this.f6273k <= h.a(getContext(), 1.0f)) {
                    this.f6273k = this.D;
                    new StringBuilder("computeVideoSize: update width -> ").append(this.f6273k);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f6270h == null) {
            this.f6270h = new TextureView(getContext());
            this.f6270h.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i5 = this.f6273k;
            if (i5 != 0 && (i2 = this.f6274l) != 0) {
                layoutParams.width = i5;
                layoutParams.height = i2;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.f6270h, layoutParams);
        }
        if (this.f6268f == null) {
            this.f6268f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            this.I = new AnonymousClass2();
            this.f6268f.a(this.I);
            this.J = new AnonymousClass3();
            this.f6268f.a(this.J);
            this.f6268f.a(this.B ? 0.0f : 1.0f);
            this.f6268f.a(z2);
            a(g(), false);
        }
        setOnClickListener(new e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        new StringBuilder("onRestoreInstanceState...").append(bVar.a());
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f6275m = bVar.a;
        this.f6280r = bVar.b;
        this.f6281s = bVar.f6289c;
        this.f6282t = bVar.f6290d;
        this.f6284v = bVar.f6291e;
        this.f6285w = bVar.f6292f;
        this.B = bVar.f6293g;
        this.G = bVar.f6294h;
        ad adVar = this.f6268f;
        if (adVar != null) {
            adVar.a(this.B ? 0.0f : 1.0f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = this.f6275m;
        bVar.b = this.f6280r;
        bVar.f6289c = this.f6281s;
        bVar.f6290d = this.f6282t;
        bVar.f6291e = this.f6284v;
        bVar.f6292f = this.f6285w;
        bVar.f6293g = this.B;
        bVar.f6294h = this.G;
        new StringBuilder("onSaveInstanceState...").append(bVar.a());
        return bVar;
    }

    public void pause() {
        e();
        ad adVar = this.f6268f;
        if (adVar != null) {
            adVar.a(false);
        }
    }

    public void release() {
        e();
        if (this.f6286x) {
            ad adVar = this.f6268f;
            if (adVar != null) {
                if (adVar.J()) {
                    this.f6268f.m();
                }
                w.c cVar = this.I;
                if (cVar != null) {
                    this.f6268f.b(cVar);
                }
                com.anythink.expressad.exoplayer.l.g gVar = this.J;
                if (gVar != null) {
                    this.f6268f.b(gVar);
                }
                this.f6268f.n();
                this.f6268f = null;
            }
            Handler handler = this.A;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f6286x = false;
        }
    }

    public void setListener(a aVar) {
        this.f6288z = aVar;
    }

    public void setLoadingView(View view) {
        this.H = view;
    }

    public void setMute(boolean z2) {
        this.B = z2;
        if (this.B) {
            ad adVar = this.f6268f;
            if (adVar != null) {
                adVar.a(0.0f);
            }
            a aVar = this.f6288z;
            if (aVar != null) {
                aVar.e();
                return;
            }
            return;
        }
        ad adVar2 = this.f6268f;
        if (adVar2 != null) {
            adVar2.a(1.0f);
        }
        a aVar2 = this.f6288z;
        if (aVar2 != null) {
            aVar2.f();
        }
    }

    public void setVideoRateConfig(int i2, int i3) {
        this.f6265c = i2;
        this.b = i3;
    }

    public void setVideoSize(int i2, int i3) {
        this.D = i2;
        this.E = i3;
    }

    public void start() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        ad adVar = this.f6268f;
        if (adVar != null) {
            adVar.a(true);
        }
        if (this.C == null) {
            this.f6283u = true;
            this.C = new Thread(new d(this));
            this.C.start();
        }
    }

    public void stop() {
        ad adVar = this.f6268f;
        if (adVar != null) {
            adVar.m();
        }
        a aVar = this.f6288z;
        if (aVar != null) {
            aVar.b();
        }
    }

    static /* synthetic */ boolean d(PlayerView playerView) {
        playerView.f6284v = true;
        return true;
    }

    private boolean f() {
        if (!new File(this.f6271i).exists() && TextUtils.isEmpty(this.f6272j)) {
            return true;
        }
        this.F = true;
        return false;
    }

    private String g() {
        return new File(this.f6271i).exists() ? this.f6271i : this.f6272j;
    }

    private void h() {
        int i2;
        if (this.f6270h == null) {
            this.f6270h = new TextureView(getContext());
            this.f6270h.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i3 = this.f6273k;
            if (i3 != 0 && (i2 = this.f6274l) != 0) {
                layoutParams.width = i3;
                layoutParams.height = i2;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.f6270h, layoutParams);
        }
    }

    private void i() {
        a aVar = this.f6288z;
        if (aVar != null) {
            aVar.g();
        }
        this.f6268f.a(this.f6269g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Handler handler;
        while (this.f6283u) {
            if (this.f6285w || !isPlaying() || (handler = this.A) == null) {
                try {
                    Thread.sleep(10L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    handler.sendEmptyMessage((int) this.f6268f.t());
                } catch (Throwable unused) {
                }
                try {
                    Thread.sleep(200L);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void c() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void d() {
        if (this.C != null) {
            return;
        }
        this.f6283u = true;
        this.C = new Thread(new d(this));
        this.C.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f6283u = false;
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.f6288z;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void b() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void a() {
        if (this.f6273k == 0 || this.f6274l == 0) {
            try {
                String strG = g();
                int i2 = this.D;
                int i3 = this.E;
                g.a aVarA = com.anythink.basead.a.b.g.a(strG);
                if (aVarA == null) {
                    aVarA = null;
                } else {
                    float f2 = (aVarA.a * 1.0f) / aVarA.b;
                    if (f2 < (i2 * 1.0f) / i3) {
                        aVarA.b = i3;
                        aVarA.a = (int) (aVarA.b * f2);
                    } else {
                        aVarA.a = i2;
                        aVarA.b = (int) (aVarA.a / f2);
                    }
                }
                if (aVarA != null) {
                    this.f6273k = aVarA.a;
                    this.f6274l = aVarA.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.f6273k);
                sb.append(", ");
                sb.append(this.f6274l);
                if (this.D == this.f6273k) {
                    if (this.E - this.f6274l <= h.a(getContext(), 1.0f)) {
                        this.f6274l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.f6274l);
                        return;
                    }
                    return;
                }
                if (this.E != this.f6274l || this.D - this.f6273k > h.a(getContext(), 1.0f)) {
                    return;
                }
                this.f6273k = this.D;
                new StringBuilder("computeVideoSize: update width -> ").append(this.f6273k);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void b(boolean z2) {
        if (this.f6268f == null) {
            this.f6268f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            this.I = new AnonymousClass2();
            this.f6268f.a(this.I);
            this.J = new AnonymousClass3();
            this.f6268f.a(this.J);
            this.f6268f.a(this.B ? 0.0f : 1.0f);
            this.f6268f.a(z2);
            a(g(), false);
        }
    }

    static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.anythink.basead.ui.PlayerView.b.1
            private static b a(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ b[] newArray(int i2) {
                return new b[i2];
            }

            private static b[] a(int i2) {
                return new b[i2];
            }
        };
        int a;
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f6289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f6290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f6291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f6292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f6293g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f6294h;

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            boolean[] zArr = new boolean[7];
            parcel.readBooleanArray(zArr);
            this.b = zArr[0];
            this.f6289c = zArr[1];
            this.f6290d = zArr[2];
            this.f6291e = zArr[3];
            this.f6292f = zArr[4];
            this.f6293g = zArr[5];
            this.f6294h = zArr[6];
        }

        public final String a() {
            return "SavedState(\nsavePosition - " + this.a + "\nsaveVideoPlay25 - " + this.b + "\nsaveVideoPlay50 - " + this.f6289c + "\nsaveVideoPlay75 - " + this.f6290d + "\nsaveIsVideoStart - " + this.f6291e + "\nsaveIsVideoPlayCompletion - " + this.f6292f + "\nsaveIsMute - " + this.f6293g + "\nsaveVideoNeedResumeByCdRate - " + this.f6294h + "\n)";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeBooleanArray(new boolean[]{this.b, this.f6289c, this.f6290d, this.f6291e, this.f6292f, this.f6293g, this.f6294h});
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.PlayerView.a(java.lang.String, boolean):void");
    }

    private void a(boolean z2) {
        boolean z3;
        int i2;
        if (new File(this.f6271i).exists() || !TextUtils.isEmpty(this.f6272j)) {
            this.F = true;
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            a aVar = this.f6288z;
            if (aVar != null) {
                aVar.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, com.anythink.basead.c.f.J));
                return;
            }
            return;
        }
        if (this.f6273k == 0 || this.f6274l == 0) {
            try {
                String strG = g();
                int i3 = this.D;
                int i4 = this.E;
                g.a aVarA = com.anythink.basead.a.b.g.a(strG);
                if (aVarA == null) {
                    aVarA = null;
                } else {
                    float f2 = (aVarA.a * 1.0f) / aVarA.b;
                    if (f2 < (i3 * 1.0f) / i4) {
                        aVarA.b = i4;
                        aVarA.a = (int) (aVarA.b * f2);
                    } else {
                        aVarA.a = i3;
                        aVarA.b = (int) (aVarA.a / f2);
                    }
                }
                if (aVarA != null) {
                    this.f6273k = aVarA.a;
                    this.f6274l = aVarA.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.f6273k);
                sb.append(", ");
                sb.append(this.f6274l);
                if (this.D == this.f6273k) {
                    if (this.E - this.f6274l <= h.a(getContext(), 1.0f)) {
                        this.f6274l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.f6274l);
                    }
                } else if (this.E == this.f6274l && this.D - this.f6273k <= h.a(getContext(), 1.0f)) {
                    this.f6273k = this.D;
                    new StringBuilder("computeVideoSize: update width -> ").append(this.f6273k);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f6270h == null) {
            this.f6270h = new TextureView(getContext());
            this.f6270h.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i5 = this.f6273k;
            if (i5 != 0 && (i2 = this.f6274l) != 0) {
                layoutParams.width = i5;
                layoutParams.height = i2;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.f6270h, layoutParams);
        }
        if (this.f6268f == null) {
            this.f6268f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            this.I = new AnonymousClass2();
            this.f6268f.a(this.I);
            this.J = new AnonymousClass3();
            this.f6268f.a(this.J);
            this.f6268f.a(this.B ? 0.0f : 1.0f);
            this.f6268f.a(z2);
            a(g(), false);
        }
        setOnClickListener(new e(this));
    }
}
