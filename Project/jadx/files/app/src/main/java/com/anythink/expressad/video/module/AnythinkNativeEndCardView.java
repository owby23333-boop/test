package com.anythink.expressad.video.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.f.a;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.shake.MBShakeView;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView;
import com.anythink.expressad.video.module.a.a.j;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.anythink.expressad.videocommon.view.StarLevelView;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkNativeEndCardView extends AnythinkBaseView implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11833n = "anythink_reward_endcard_native_hor";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f11834o = "anythink_reward_endcard_native_land";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11835p = "anythink_reward_endcard_native_half_portrait";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11836q = "anythink_reward_endcard_native_half_landscape";
    private ImageView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private LinearLayout E;
    private FeedBackButton F;
    private Runnable G;
    private RelativeLayout H;
    private b I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private AlphaAnimation P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private View V;
    private TextView W;
    private boolean aa;
    private String ab;
    private d ac;
    private MBShakeView ad;
    private com.anythink.expressad.shake.b ae;
    private AnythinkBaitClickView af;
    private int ag;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ViewGroup f11837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ViewGroup f11838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RelativeLayout f11839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RelativeLayout f11840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f11841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f11842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f11843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f11844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f11845z;

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$10, reason: invalid class name */
    final class AnonymousClass10 implements c {
        AnonymousClass10() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                if (AnythinkNativeEndCardView.this.f11842w != null) {
                    if (AnythinkNativeEndCardView.this.f11791i) {
                        AnythinkNativeEndCardView.this.f11842w.setBackgroundDrawable(null);
                    }
                    AnythinkNativeEndCardView.this.f11842w.setImageBitmap(bitmap);
                }
                Bitmap bitmapBlurBitmap = AnythinkNativeEndCardView.this.blurBitmap(bitmap);
                if (bitmapBlurBitmap == null || bitmapBlurBitmap.isRecycled() || AnythinkNativeEndCardView.this.f11841v == null) {
                    return;
                }
                if (AnythinkNativeEndCardView.this.f11791i) {
                    AnythinkNativeEndCardView.this.f11841v.setBackgroundDrawable(null);
                }
                AnythinkNativeEndCardView.this.f11841v.setImageBitmap(bitmapBlurBitmap);
            } catch (Throwable unused) {
                if (AnythinkNativeEndCardView.this.f11841v != null) {
                    AnythinkNativeEndCardView.this.f11841v.setVisibility(4);
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$11, reason: invalid class name */
    final class AnonymousClass11 implements c {
        AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled() || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                int iB = t.b(AnythinkNativeEndCardView.this.a, 12.0f);
                AnythinkNativeEndCardView.this.f11844y.getLayoutParams().height = iB;
                AnythinkNativeEndCardView.this.f11844y.getLayoutParams().width = (int) (iB * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                AnythinkNativeEndCardView.this.f11844y.setImageBitmap(bitmap);
                AnythinkNativeEndCardView.this.f11844y.setBackgroundColor(1426063360);
            } catch (Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$12, reason: invalid class name */
    final class AnonymousClass12 implements View.OnClickListener {
        final /* synthetic */ String a;

        AnonymousClass12(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(AnythinkNativeEndCardView.this.a, this.a);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$4, reason: invalid class name */
    final class AnonymousClass4 implements a {
        AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            AnythinkNativeEndCardView.this.O = true;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            AnythinkNativeEndCardView.this.O = false;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            AnythinkNativeEndCardView.this.O = false;
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$6, reason: invalid class name */
    final class AnonymousClass6 extends com.anythink.expressad.shake.b {
        AnonymousClass6(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (!AnythinkNativeEndCardView.this.O && AnythinkNativeEndCardView.this.N) {
                AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 4);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$8, reason: invalid class name */
    final class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 2);
        }
    }

    public AnythinkNativeEndCardView(Context context) {
        super(context);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    static /* synthetic */ boolean a(AnythinkNativeEndCardView anythinkNativeEndCardView) {
        anythinkNativeEndCardView.K = true;
        return true;
    }

    static /* synthetic */ void o(AnythinkNativeEndCardView anythinkNativeEndCardView) {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = anythinkNativeEndCardView.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        anythinkNativeEndCardView.b.l(anythinkNativeEndCardView.ab);
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.new AnonymousClass4());
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.b);
        com.anythink.expressad.foundation.f.b.a().c(anythinkNativeEndCardView.ab + "_1");
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        if (anythinkNativeEndCardView.F != null) {
            com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript renderScriptCreate = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(25.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean canBackPress() {
        View view = this.V;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        d dVar;
        ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j() || (dVar = this.ac) == null || (arrayList = dVar.J) == null || arrayList.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar2 : this.ac.J) {
            if (!TextUtils.isEmpty(cVar2.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).c(cVar2.bd());
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.U;
    }

    public void notifyShowListener() {
        this.f11787e.a(110, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i2;
        int i3;
        int i4;
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this);
                    if (AnythinkNativeEndCardView.this.V != null) {
                        AnythinkNativeEndCardView.this.V.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.L * 1000);
            if (!this.N) {
                this.N = true;
            }
            try {
                if (this.b != null && this.b.j()) {
                    String strI = this.b.I();
                    if (TextUtils.isEmpty(strI)) {
                        strI = this.b.P();
                    }
                    String strA = x.a(strI, "alac");
                    if (!TextUtils.isEmpty(strA) && strA.equals("1")) {
                        postDelayed(new AnonymousClass8(), 1000L);
                    }
                }
            } catch (Throwable th) {
                o.d(AnythinkBaseView.TAG, th.getMessage());
            }
        }
        try {
            if (this.b != null && this.b.j()) {
                String strI2 = this.b.I();
                if (TextUtils.isEmpty(strI2)) {
                    strI2 = this.b.P();
                }
                String strA2 = x.a(strI2, "bait_click");
                try {
                    i4 = Integer.parseInt(strA2);
                } catch (Throwable th2) {
                    o.d(AnythinkBaseView.TAG, th2.getMessage());
                    i4 = 1;
                }
                if (!TextUtils.isEmpty(strA2) && i4 != 0 && this.af == null) {
                    this.af = new AnythinkBaitClickView(getContext());
                    this.af.init(1342177280, i4);
                    this.af.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    if (this.f11840u != null) {
                        this.f11840u.addView(this.af);
                        this.af.startAnimation();
                        this.af.setOnClickListener(new AnonymousClass7());
                    }
                }
            }
        } catch (Throwable th3) {
            o.d(AnythinkBaseView.TAG, th3.getMessage());
        }
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String strI3 = this.b.I();
            if (TextUtils.isEmpty(strI3)) {
                strI3 = this.b.P();
            }
            String strA3 = x.a(strI3, "shake_show");
            String strA4 = x.a(strI3, "shake_strength");
            String strA5 = x.a(strI3, "shake_time");
            if (!TextUtils.isEmpty(strA3) && strA3.equals("1") && this.ad == null) {
                if (this.af != null) {
                    this.af.setVisibility(8);
                }
                this.ad = new MBShakeView(getContext());
                this.ad.initView(this.b.cU, true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (isLandscape()) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(2, findID("anythink_iv_logo"));
                    layoutParams.addRule(14);
                    this.ad.setPadding(0, 0, 0, t.b(getContext(), 20.0f));
                }
                this.ad.setLayoutParams(layoutParams);
                if (this.f11839t != null && this.f11839t.isShown()) {
                    if (this.W != null) {
                        this.f11839t.addView(this.ad);
                    }
                    this.W.setVisibility(4);
                    this.ad.setOnClickListener(new AnonymousClass5());
                    int i5 = 10;
                    if (!TextUtils.isEmpty(strA4) && (i3 = Integer.parseInt(strA4)) >= 0) {
                        i5 = i3;
                    }
                    int i6 = 5000;
                    if (!TextUtils.isEmpty(strA5) && (i2 = Integer.parseInt(strA5)) > 0) {
                        i6 = i2 * 1000;
                    }
                    this.ae = new AnonymousClass6(i5, i6);
                    com.anythink.expressad.shake.a.a().a(this.ae);
                }
            }
        } catch (Throwable th4) {
            o.d(AnythinkBaseView.TAG, th4.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.ae != null) {
            com.anythink.expressad.shake.a.a().b(this.ae);
            this.ae = null;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            this.f11786d = configuration.orientation;
            o.d(AnythinkBaseView.TAG, " native onSelfConfigurationChanged:" + this.f11786d);
            if (this.f11786d == 2) {
                removeView(this.f11837r);
                a(this.f11838s);
            } else {
                removeView(this.f11838s);
                a(this.f11837r);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        this.I = bVar;
        try {
            if (this.b == null || !this.f11788f) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.be(), new AnonymousClass10());
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new j(this.f11843x, t.b(n.a().g(), 8.0f)));
            this.B.setText(this.b.bb());
            if (this.W != null) {
                this.W.setText(this.b.cU);
            }
            if (this.C != null) {
                this.C.setText(this.b.bc());
            }
            if (this.D != null) {
                this.D.setText(this.b.aY() + ad.f20406s);
            }
            this.E.removeAllViews();
            double dAX = this.b.aX();
            if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                dAX = 5.0d;
            }
            if (this.E instanceof StarLevelView) {
                ((StarLevelView) this.E).initScore(dAX);
            }
            if (this.E instanceof AnyThinkLevelLayoutView) {
                ((AnyThinkLevelLayoutView) this.E).setRatingAndUser(dAX, this.b.aY());
            }
            if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.J = true;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new AnonymousClass11());
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
            if (aVarB != null) {
                String strJ = aVarB.J();
                if (TextUtils.isEmpty(strJ)) {
                    this.f11845z.setVisibility(8);
                }
                this.f11845z.setOnClickListener(new AnonymousClass12(strJ));
            } else {
                this.f11845z.setVisibility(8);
            }
            if (!this.K) {
                this.V.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT >= 17 || this.f11841v == null) {
                return;
            }
            this.f11841v.setVisibility(8);
        } catch (Throwable th) {
            o.a(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    public void release() {
        try {
            removeAllViews();
            if (this.P != null) {
                this.P.cancel();
            }
            this.ae = null;
            this.G = null;
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    public void setCloseBtnDelay(int i2) {
        this.L = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLayout() {
        /*
            r6 = this;
            boolean r0 = r6.f11791i
            if (r0 == 0) goto L21
            com.anythink.expressad.video.dynview.j.c r0 = new com.anythink.expressad.video.dynview.j.c
            r0.<init>()
            android.content.Context r0 = r6.getContext()
            com.anythink.expressad.foundation.d.c r1 = r6.b
            int r2 = r6.f11792j
            com.anythink.expressad.video.dynview.c r0 = com.anythink.expressad.video.dynview.j.c.a(r0, r1, r2)
            com.anythink.expressad.video.dynview.b.a()
            com.anythink.expressad.video.module.AnythinkNativeEndCardView$9 r1 = new com.anythink.expressad.video.module.AnythinkNativeEndCardView$9
            r1.<init>()
            com.anythink.expressad.video.dynview.b.a(r0, r1)
            return
        L21:
            int r0 = r6.ag
            java.lang.String r1 = "anythink_reward_endcard_native_half_landscape"
            java.lang.String r2 = "anythink_reward_endcard_native_land"
            java.lang.String r3 = "anythink_reward_endcard_native_half_portrait"
            java.lang.String r4 = "anythink_reward_endcard_native_hor"
            if (r0 != 0) goto L41
            boolean r0 = r6.aa
            if (r0 == 0) goto L32
            goto L33
        L32:
            r3 = r4
        L33:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L58
            boolean r0 = r6.aa
            if (r0 == 0) goto L3f
        L3d:
            r3 = r1
            goto L58
        L3f:
            r3 = r2
            goto L58
        L41:
            r5 = 1
            if (r0 != r5) goto L4b
            boolean r0 = r6.aa
            if (r0 == 0) goto L49
            goto L4e
        L49:
            r3 = r4
            goto L4e
        L4b:
            java.lang.String r0 = ""
            r3 = r0
        L4e:
            int r0 = r6.ag
            r4 = 2
            if (r0 != r4) goto L58
            boolean r0 = r6.aa
            if (r0 == 0) goto L3f
            goto L3d
        L58:
            int r0 = r6.findLayout(r3)
            if (r0 <= 0) goto L95
            boolean r1 = r6.isLandscape()
            r2 = 0
            if (r1 == 0) goto L7b
            android.view.LayoutInflater r1 = r6.f11785c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.f11838s = r0
            android.view.ViewGroup r0 = r6.f11838s
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.f11838s
            boolean r0 = r6.b(r0)
            goto L90
        L7b:
            android.view.LayoutInflater r1 = r6.f11785c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.f11837r = r0
            android.view.ViewGroup r0 = r6.f11837r
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.f11837r
            boolean r0 = r6.b(r0)
        L90:
            r6.f11788f = r0
            r6.e()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkNativeEndCardView.setLayout():void");
    }

    public void setMoreOfferCampaignUnit(d dVar) {
        ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        MBShakeView mBShakeView;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            return;
        }
        this.ac = dVar;
        d dVar2 = this.ac;
        if (dVar2 == null || (arrayList = dVar2.J) == null || arrayList.size() <= 5 || (mBShakeView = this.ad) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, t.b(getContext(), 5.0f));
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        o.d(AnythinkBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        this.Q = i2;
        this.R = i3;
        this.S = i4;
        this.T = i5;
        h();
    }

    public void setOnPause() {
        this.N = false;
    }

    public void setOnResume() {
        this.N = true;
    }

    public void setUnitId(String str) {
        this.ab = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c();
        if (!this.f11788f) {
            this.f11787e.a(104, "");
        }
        this.P = new AlphaAnimation(0.0f, 100.0f);
        this.P.setDuration(200L);
    }

    private void f() {
        ImageView imageView;
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.be(), new AnonymousClass10());
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new j(this.f11843x, t.b(n.a().g(), 8.0f)));
        this.B.setText(this.b.bb());
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(this.b.cU);
        }
        TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setText(this.b.bc());
        }
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setText(this.b.aY() + ad.f20406s);
        }
        this.E.removeAllViews();
        double dAX = this.b.aX();
        if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            dAX = 5.0d;
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout instanceof StarLevelView) {
            ((StarLevelView) linearLayout).initScore(dAX);
        }
        LinearLayout linearLayout2 = this.E;
        if (linearLayout2 instanceof AnyThinkLevelLayoutView) {
            ((AnyThinkLevelLayoutView) linearLayout2).setRatingAndUser(dAX, this.b.aY());
        }
        if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
            this.J = true;
        }
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new AnonymousClass11());
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
        if (aVarB != null) {
            String strJ = aVarB.J();
            if (TextUtils.isEmpty(strJ)) {
                this.f11845z.setVisibility(8);
            }
            this.f11845z.setOnClickListener(new AnonymousClass12(strJ));
        } else {
            this.f11845z.setVisibility(8);
        }
        if (!this.K) {
            this.V.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 17 || (imageView = this.f11841v) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int g() {
        /*
            r6 = this;
            int r0 = r6.ag
            java.lang.String r1 = "anythink_reward_endcard_native_half_landscape"
            java.lang.String r2 = "anythink_reward_endcard_native_land"
            java.lang.String r3 = "anythink_reward_endcard_native_half_portrait"
            java.lang.String r4 = "anythink_reward_endcard_native_hor"
            if (r0 != 0) goto L20
            boolean r0 = r6.aa
            if (r0 == 0) goto L11
            goto L12
        L11:
            r3 = r4
        L12:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L37
            boolean r0 = r6.aa
            if (r0 == 0) goto L1e
        L1c:
            r3 = r1
            goto L37
        L1e:
            r3 = r2
            goto L37
        L20:
            r5 = 1
            if (r0 != r5) goto L2a
            boolean r0 = r6.aa
            if (r0 == 0) goto L28
            goto L2d
        L28:
            r3 = r4
            goto L2d
        L2a:
            java.lang.String r0 = ""
            r3 = r0
        L2d:
            int r0 = r6.ag
            r4 = 2
            if (r0 != r4) goto L37
            boolean r0 = r6.aa
            if (r0 == 0) goto L1e
            goto L1c
        L37:
            int r0 = r6.findLayout(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkNativeEndCardView.g():int");
    }

    private void h() {
        RelativeLayout relativeLayout;
        if (!this.f11788f || (relativeLayout = this.H) == null) {
            return;
        }
        relativeLayout.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.3
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.foundation.d.c cVar = AnythinkNativeEndCardView.this.b;
                if (cVar != null && !cVar.j() && AnythinkNativeEndCardView.this.b.f() != 2) {
                    AnythinkNativeEndCardView.this.H.setPadding(AnythinkNativeEndCardView.this.Q, AnythinkNativeEndCardView.this.S, AnythinkNativeEndCardView.this.R, AnythinkNativeEndCardView.this.T);
                    AnythinkNativeEndCardView.this.H.startAnimation(AnythinkNativeEndCardView.this.P);
                }
                AnythinkNativeEndCardView.this.H.setVisibility(0);
                if (AnythinkNativeEndCardView.this.V.getVisibility() != 0 && AnythinkNativeEndCardView.this.K) {
                    AnythinkNativeEndCardView.this.V.setVisibility(0);
                }
                AnythinkNativeEndCardView.o(AnythinkNativeEndCardView.this);
            }
        }, 200L);
    }

    private void i() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = this.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ab);
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", new AnonymousClass4());
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.b);
        com.anythink.expressad.foundation.f.b.a().c(this.ab + "_1");
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.F);
        if (this.F != null) {
            com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.F);
        }
    }

    private void j() {
        int i2;
        int i3;
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String strI = this.b.I();
            if (TextUtils.isEmpty(strI)) {
                strI = this.b.P();
            }
            String strA = x.a(strI, "shake_show");
            String strA2 = x.a(strI, "shake_strength");
            String strA3 = x.a(strI, "shake_time");
            if (!TextUtils.isEmpty(strA) && strA.equals("1") && this.ad == null) {
                if (this.af != null) {
                    this.af.setVisibility(8);
                }
                this.ad = new MBShakeView(getContext());
                this.ad.initView(this.b.cU, true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (isLandscape()) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(2, findID("anythink_iv_logo"));
                    layoutParams.addRule(14);
                    this.ad.setPadding(0, 0, 0, t.b(getContext(), 20.0f));
                }
                this.ad.setLayoutParams(layoutParams);
                if (this.f11839t != null && this.f11839t.isShown()) {
                    if (this.W != null) {
                        this.f11839t.addView(this.ad);
                    }
                    this.W.setVisibility(4);
                    this.ad.setOnClickListener(new AnonymousClass5());
                    int i4 = 10;
                    if (!TextUtils.isEmpty(strA2) && (i3 = Integer.parseInt(strA2)) >= 0) {
                        i4 = i3;
                    }
                    int i5 = 5000;
                    if (!TextUtils.isEmpty(strA3) && (i2 = Integer.parseInt(strA3)) > 0) {
                        i5 = i2 * 1000;
                    }
                    this.ae = new AnonymousClass6(i4, i5);
                    com.anythink.expressad.shake.a.a().a(this.ae);
                }
            }
        } catch (Throwable th) {
            o.d(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    private void k() {
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String strI = this.b.I();
            if (TextUtils.isEmpty(strI)) {
                strI = this.b.P();
            }
            String strA = x.a(strI, "bait_click");
            int i2 = 1;
            try {
                i2 = Integer.parseInt(strA);
            } catch (Throwable th) {
                o.d(AnythinkBaseView.TAG, th.getMessage());
            }
            if (TextUtils.isEmpty(strA) || i2 == 0 || this.af != null) {
                return;
            }
            this.af = new AnythinkBaitClickView(getContext());
            this.af.init(1342177280, i2);
            this.af.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.f11840u != null) {
                this.f11840u.addView(this.af);
                this.af.startAnimation();
                this.af.setOnClickListener(new AnonymousClass7());
            }
        } catch (Throwable th2) {
            o.d(AnythinkBaseView.TAG, th2.getMessage());
        }
    }

    private void l() {
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String strI = this.b.I();
            if (TextUtils.isEmpty(strI)) {
                strI = this.b.P();
            }
            String strA = x.a(strI, "alac");
            if (TextUtils.isEmpty(strA) || !strA.equals("1")) {
                return;
            }
            postDelayed(new AnonymousClass8(), 1000L);
        } catch (Throwable th) {
            o.d(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        if (this.f11788f) {
            this.f11839t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (AnythinkNativeEndCardView.this.J) {
                        AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 1);
                    }
                }
            });
            this.V.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnythinkNativeEndCardView.this.f11787e.a(104, "");
                }
            });
            TextView textView = this.W;
            if (textView != null) {
                textView.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.15
                    @Override // com.anythink.expressad.widget.a
                    protected final void a(View view) {
                        AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                    }
                });
            }
            this.f11843x.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.16
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                }
            });
            this.f11842w.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.2
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                }
            });
        }
    }

    private boolean b(int i2) {
        if (isLandscape()) {
            this.f11838s = (ViewGroup) this.f11785c.inflate(i2, (ViewGroup) null);
            addView(this.f11838s);
            return b(this.f11838s);
        }
        this.f11837r = (ViewGroup) this.f11785c.inflate(i2, (ViewGroup) null);
        addView(this.f11837r);
        return b(this.f11837r);
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$9, reason: invalid class name */
    final class AnonymousClass9 implements h {
        AnonymousClass9() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            AnythinkNativeEndCardView.this.addView(aVar.a());
            AnythinkNativeEndCardView.this.U = aVar.c();
            AnythinkNativeEndCardView anythinkNativeEndCardView = AnythinkNativeEndCardView.this;
            anythinkNativeEndCardView.f11788f = anythinkNativeEndCardView.b(aVar.a());
            AnythinkNativeEndCardView.this.e();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            o.d(AnythinkBaseView.TAG, "errorMsg:" + bVar.b());
        }
    }

    private void a() {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c cVarA = com.anythink.expressad.video.dynview.j.c.a(getContext(), this.b, this.f11792j);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(cVarA, new AnonymousClass9());
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.I);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        h();
    }

    private void c(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i2));
                if (this.b.k() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
        }
        this.f11787e.a(105, jSONObject);
    }

    public AnythinkNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view) {
        try {
            this.f11839t = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layout"));
            this.f11840u = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layer_layout"));
            this.f11842w = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner"));
            this.f11843x = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_icon"));
            this.f11844y = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_flag"));
            this.f11845z = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_link"));
            this.B = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_apptitle"));
            this.E = (LinearLayout) view.findViewById(filterFindViewId(this.U, "anythink_sv_starlevel"));
            this.V = view.findViewById(filterFindViewId(this.U, "anythink_iv_close"));
            View viewFindViewById = view.findViewById(filterFindViewId(this.U, "anythink_tv_cta"));
            if (viewFindViewById != null && (viewFindViewById instanceof TextView)) {
                this.W = (TextView) viewFindViewById;
            }
            this.F = (FeedBackButton) view.findViewById(filterFindViewId(this.U, "anythink_native_endcard_feed_btn"));
            this.H = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_controller"));
            this.f11841v = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner_bg"));
            if (this.f11791i) {
                if (this.f11842w != null && (this.f11842w instanceof RoundImageView)) {
                    ((RoundImageView) this.f11842w).setBorderRadius(10);
                }
                if (this.f11843x != null && (this.f11843x instanceof RoundImageView)) {
                    ((RoundImageView) this.f11843x).setBorderRadius(10);
                }
                return isNotNULL(this.f11841v, this.f11842w, this.f11843x, this.B, this.E, this.V);
            }
            this.C = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_appdesc"));
            this.D = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_number"));
            return isNotNULL(this.f11841v, this.f11842w, this.f11843x, this.B, this.C, this.D, this.E, this.V, this.W);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    static /* synthetic */ void a(AnythinkNativeEndCardView anythinkNativeEndCardView, int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkNativeEndCardView.a(i2));
                if (anythinkNativeEndCardView.b.k() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
        }
        anythinkNativeEndCardView.f11787e.a(105, jSONObject);
    }

    public AnythinkNativeEndCardView(Context context, AttributeSet attributeSet, boolean z2, int i2, boolean z3, int i3, int i4) {
        super(context, attributeSet, z2, i2, z3, i3, i4);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r6 = this;
            int r0 = r6.ag
            java.lang.String r1 = "anythink_reward_endcard_native_half_landscape"
            java.lang.String r2 = "anythink_reward_endcard_native_land"
            java.lang.String r3 = "anythink_reward_endcard_native_half_portrait"
            java.lang.String r4 = "anythink_reward_endcard_native_hor"
            if (r0 != 0) goto L20
            boolean r0 = r6.aa
            if (r0 == 0) goto L11
            goto L12
        L11:
            r3 = r4
        L12:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L37
            boolean r0 = r6.aa
            if (r0 == 0) goto L1e
        L1c:
            r3 = r1
            goto L37
        L1e:
            r3 = r2
            goto L37
        L20:
            r5 = 1
            if (r0 != r5) goto L2a
            boolean r0 = r6.aa
            if (r0 == 0) goto L28
            goto L2d
        L28:
            r3 = r4
            goto L2d
        L2a:
            java.lang.String r0 = ""
            r3 = r0
        L2d:
            int r0 = r6.ag
            r4 = 2
            if (r0 != r4) goto L37
            boolean r0 = r6.aa
            if (r0 == 0) goto L1e
            goto L1c
        L37:
            int r0 = r6.findLayout(r3)
            if (r0 <= 0) goto L74
            boolean r1 = r6.isLandscape()
            r2 = 0
            if (r1 == 0) goto L5a
            android.view.LayoutInflater r1 = r6.f11785c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.f11838s = r0
            android.view.ViewGroup r0 = r6.f11838s
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.f11838s
            boolean r0 = r6.b(r0)
            goto L6f
        L5a:
            android.view.LayoutInflater r1 = r6.f11785c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.f11837r = r0
            android.view.ViewGroup r0 = r6.f11837r
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.f11837r
            boolean r0 = r6.b(r0)
        L6f:
            r6.f11788f = r0
            r6.e()
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkNativeEndCardView.b():void");
    }
}
