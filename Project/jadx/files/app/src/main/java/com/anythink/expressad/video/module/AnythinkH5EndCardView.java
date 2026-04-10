package com.anythink.expressad.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.video.signal.h;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.widget.FeedBackButton;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkH5EndCardView extends AnythinkBaseView implements IMraidJSBridge, com.anythink.expressad.video.signal.f, h {
    private static final String A = "anythink_reward_endcard_h5";
    private static final String B = "portrait";
    private static final String C = "landscape";
    private static final int D = 1;
    private static final int E = 2;
    private static final int F = 20;
    private static final int G = 15;
    private static final int Q = 100;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final String f11820n = "orientation";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static final String f11821o = "webviewshow";
    private FeedBackButton H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private long P;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private boolean ab;
    private String ac;
    private com.anythink.expressad.video.signal.factory.b ad;
    private boolean ae;
    private boolean af;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected View f11822p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected RelativeLayout f11823q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected ImageView f11824r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected WindVaneWebView f11825s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected Handler f11826t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected String f11827u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f11828v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected boolean f11829w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected String f11830x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Handler f11831y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f11832z;

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView.this.H.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass6() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String string;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.f11825s, AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String string;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.f11825s, AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String string;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.f11825s, AbsFeedBackForH5.a, strEncodeToString);
        }
    }

    private class a implements Runnable {
        private AnythinkH5EndCardView b;

        public a(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handler;
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || (handler = anythinkH5EndCardView.f11831y) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    private class b implements Runnable {
        private AnythinkH5EndCardView b;

        public b(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.N) {
                return;
            }
            AnythinkH5EndCardView.d(this.b);
            this.b.f11828v = false;
            AnythinkH5EndCardView.this.reportRenderResult("timeout", 5);
            this.b.f11787e.a(127, "");
            o.a(AnythinkBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    private static class c implements Runnable {
        private AnythinkH5EndCardView a;
        private int b;

        public c(AnythinkH5EndCardView anythinkH5EndCardView, int i2) {
            this.a = anythinkH5EndCardView;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.a;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.b == null) {
                return;
            }
            try {
                if (anythinkH5EndCardView.M) {
                    o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                AnythinkH5EndCardView.n(this.a);
                if (w.b(this.a.b.I())) {
                    this.a.b.I().contains(".zip");
                }
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private class d implements Runnable {
        private AnythinkH5EndCardView b;

        public d(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                AnythinkH5EndCardView.e(anythinkH5EndCardView);
            }
        }
    }

    private class e implements Runnable {
        private AnythinkH5EndCardView b;

        public e(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                AnythinkH5EndCardView.f(anythinkH5EndCardView);
            }
        }
    }

    private class f implements Runnable {
        private AnythinkH5EndCardView b;

        public f(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                if (!anythinkH5EndCardView.aa) {
                    AnythinkH5EndCardView.this.setCloseVisible(0);
                }
                AnythinkH5EndCardView.l(this.b);
            }
        }
    }

    public AnythinkH5EndCardView(Context context) {
        super(context);
        this.I = false;
        this.f11826t = new Handler();
        this.f11828v = false;
        this.f11829w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.f11831y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (AnythinkH5EndCardView.this.R) {
                    AnythinkH5EndCardView.this.f11787e.a(122, "");
                }
                AnythinkH5EndCardView.this.f11787e.a(103, "");
            }
        };
        this.ae = false;
        this.af = false;
        this.f11832z = false;
    }

    static /* synthetic */ boolean d(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.N = true;
        return true;
    }

    static /* synthetic */ boolean e(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.V = true;
        return true;
    }

    static /* synthetic */ boolean f(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.W = true;
        return true;
    }

    private void g() {
        if (this.ae || this.T) {
            return;
        }
        this.ae = true;
        int i2 = this.K;
        if (i2 == 0) {
            this.V = true;
            return;
        }
        this.V = false;
        if (i2 >= 0) {
            this.f11826t.postDelayed(new d(this), this.K * 1000);
        }
    }

    private void i() {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b.a().c(this.f11830x + "_1");
                this.H = com.anythink.expressad.foundation.f.b.a().b(this.f11830x + "_2");
                if (this.H != null) {
                    ViewGroup viewGroup = (ViewGroup) this.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.H);
                    }
                    this.f11823q.addView(this.H);
                    this.f11823q.postDelayed(new AnonymousClass5(), 200L);
                }
                this.b.l(this.f11830x);
                com.anythink.expressad.foundation.f.b.a().a(this.f11830x + "_2", this.b);
                com.anythink.expressad.foundation.f.b.a().a(this.f11830x + "_2", new AnonymousClass6());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void k() {
    }

    static /* synthetic */ boolean l(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.S = true;
        return true;
    }

    static /* synthetic */ boolean n(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.M = true;
        return true;
    }

    public boolean canBackPress() {
        ImageView imageView = this.f11824r;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        o.d("EndCard_MRAID", com.anythink.expressad.foundation.d.c.cf);
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void excuteEndCardShowTask(int i2) {
        this.f11826t.postDelayed(new c(this, i2), i2 * 1000);
    }

    public void excuteTask() {
        if (this.J || this.K < 0) {
            return;
        }
        this.f11826t.postDelayed(new f(this), this.K * 1000);
    }

    public void executeEndCardShow(int i2) {
        this.f11826t.postDelayed(new b(this), i2 * 1000);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z2) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        o.d("========", "===========handlerPlayableException");
        if (this.f11829w) {
            return;
        }
        this.f11829w = true;
        this.f11828v = false;
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        int iFindLayout = findLayout(A);
        if (iFindLayout >= 0) {
            this.f11822p = this.f11785c.inflate(iFindLayout, (ViewGroup) null);
            try {
                View view = this.f11822p;
                this.f11824r = (ImageView) view.findViewById(findID("anythink_windwv_close"));
                this.f11823q = (RelativeLayout) view.findViewById(findID("anythink_windwv_content_rl"));
                this.f11825s = new WindVaneWebView(getContext());
                this.f11825s.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f11823q.addView(this.f11825s);
                this.f11788f = isNotNULL(this.f11824r, this.f11825s);
            } catch (Exception unused) {
                this.f11788f = false;
            }
            addView(this.f11822p, b());
            c();
            e();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
    }

    public boolean isLoadSuccess() {
        return this.f11828v;
    }

    public boolean isPlayable() {
        return this.J;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i2) {
        if (i2 == 0) {
            this.T = true;
        } else {
            if (i2 != 1) {
                return;
            }
            this.U = true;
        }
    }

    public void onBackPress() {
        if (this.S || ((this.T && this.U) || (!(this.T || !this.V || this.f11832z) || (!this.T && this.W && this.f11832z)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.f11825s == null) {
                this.f11787e.a(103, "");
                this.f11787e.a(119, "webview is null when closing webview");
            } else {
                j.a();
                j.a((WebView) this.f11825s, "onSystemDestory", "");
                new Thread(new a(this)).start();
            }
        } catch (Exception e2) {
            this.f11787e.a(103, "");
            this.f11787e.a(119, "close webview exception" + e2.getMessage());
            o.a(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0 || this.ab) {
            return;
        }
        this.ab = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        if (z2) {
            CallMraidJS.getInstance().fireSetIsViewable(this.f11825s, ITagManager.STATUS_TRUE);
        } else {
            CallMraidJS.getInstance().fireSetIsViewable(this.f11825s, ITagManager.STATUS_FALSE);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        o.d("EndCard_MRAID", "open : ".concat(String.valueOf(str)));
        try {
            String strAd = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.f11830x);
            this.b.p(strAd);
            this.f11787e.a(126, "");
        } catch (Exception e2) {
            try {
                o.d(AnythinkBaseView.TAG, e2.getMessage());
            } catch (Exception e3) {
                o.d(AnythinkBaseView.TAG, e3.getMessage());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", C);
            } else {
                jSONObject.put("orientation", B);
            }
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            j.a();
            j.a((WebView) this.f11825s, "orientation", strEncodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010a A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:13:0x006e, B:15:0x0090, B:17:0x0096, B:20:0x009e, B:22:0x00a4, B:24:0x00b1, B:26:0x00b9, B:28:0x00bc, B:30:0x00c0, B:32:0x00c8, B:34:0x00d0, B:36:0x00d6, B:38:0x00dd, B:46:0x010a, B:47:0x011b, B:39:0x00f6, B:41:0x00fb, B:43:0x0101), top: B:58:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #0 {all -> 0x0124, blocks: (B:13:0x006e, B:15:0x0090, B:17:0x0096, B:20:0x009e, B:22:0x00a4, B:24:0x00b1, B:26:0x00b9, B:28:0x00bc, B:30:0x00c0, B:32:0x00c8, B:34:0x00d0, B:36:0x00d6, B:38:0x00dd, B:46:0x010a, B:47:0x011b, B:39:0x00f6, B:41:0x00fb, B:43:0x0101), top: B:58:0x006e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void preLoadData(com.anythink.expressad.video.signal.factory.b r10) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkH5EndCardView.preLoadData(com.anythink.expressad.video.signal.factory.b):void");
    }

    @Override // com.anythink.expressad.video.signal.h
    public void readyStatus(int i2) {
    }

    public void release() {
        Handler handler = this.f11826t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11826t = null;
        }
        Handler handler2 = this.f11831y;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f11831y = null;
        }
        this.f11823q.removeAllViews();
        this.f11825s.release();
        this.f11825s = null;
    }

    public void reportRenderResult(String str, int i2) {
    }

    public void setCloseDelayShowTime(int i2) {
        this.K = i2;
    }

    public void setCloseVisible(int i2) {
        if (this.f11788f) {
            this.f11824r.setVisibility(i2);
        }
    }

    public void setCloseVisibleForMraid(int i2) {
        if (this.f11788f) {
            this.aa = true;
            if (i2 == 4) {
                this.f11824r.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.f11824r.setImageResource(findDrawable("anythink_reward_close"));
            }
            this.f11824r.setVisibility(0);
        }
    }

    public void setError(boolean z2) {
        this.f11829w = z2;
    }

    public void setHtmlSource(String str) {
        this.f11827u = str;
    }

    public void setLoadPlayable(boolean z2) {
        this.f11832z = z2;
    }

    public void setNotchValue(String str, int i2, int i3, int i4, int i5) {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || cVar.f() == 2) {
            return;
        }
        this.ac = str;
        o.d(AnythinkBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11824r.getLayoutParams();
        int iB = t.b(getContext(), 20.0f);
        int i6 = i4 + iB;
        layoutParams.setMargins(i2 + iB, i6, i3 + iB, i5 + iB);
        o.d(AnythinkBaseView.TAG, "NOTCH H5ENDCARD " + i6);
        this.f11824r.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i2) {
        this.L = i2;
    }

    public void setUnitId(String str) {
        this.f11830x = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String strI = this.b.I();
            int iA = 15;
            if (w.b(strI) && strI.contains("wfl=1")) {
                String[] strArrSplit = strI.split(DispatchConstants.SIGN_SPLIT_SYMBOL);
                if (strArrSplit != null && strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        if (w.b(str) && str.contains("timeout") && str.split("=") != null && str.split("=").length > 0) {
                            iA = t.a((Object) str.split("=")[1]);
                            o.b(AnythinkBaseView.TAG, "从url获取的wfl timeout :".concat(String.valueOf(iA)));
                        }
                    }
                }
                executeEndCardShow(iA);
            }
        } catch (Throwable th) {
            o.a(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i2) {
        int visibility = this.f11824r.getVisibility();
        if (i2 == 1) {
            this.S = true;
            visibility = 0;
        } else if (i2 == 2) {
            this.S = false;
            visibility = 8;
            if (this.f11832z) {
                if (!this.af && !this.T) {
                    this.af = true;
                    int i3 = this.L;
                    if (i3 == 0) {
                        this.W = true;
                    } else {
                        this.W = false;
                        if (i3 >= 0) {
                            this.f11826t.postDelayed(new e(this), this.L * 1000);
                        }
                    }
                }
            } else if (!this.ae && !this.T) {
                this.ae = true;
                int i4 = this.K;
                if (i4 == 0) {
                    this.V = true;
                } else {
                    this.V = false;
                    if (i4 >= 0) {
                        this.f11826t.postDelayed(new d(this), this.K * 1000);
                    }
                }
            }
        }
        setCloseVisible(visibility);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        o.d("EndCard_MRAID", "unload");
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z2) {
        o.d("EndCard_MRAID", "useCustomClose : ".concat(String.valueOf(z2)));
        try {
            setCloseVisibleForMraid(z2 ? 4 : 0);
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    public void volumeChange(double d2) {
        CallMraidJS.getInstance().fireAudioVolumeChange(this.f11825s, d2);
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f11825s;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.4
                @Override // java.lang.Runnable
                public final void run() {
                    String string;
                    try {
                        o.a(AnythinkBaseView.TAG, AnythinkH5EndCardView.f11821o);
                        try {
                            int[] iArr = new int[2];
                            AnythinkH5EndCardView.this.f11825s.getLocationOnScreen(iArr);
                            o.d(AnythinkBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context contextG = n.a().g();
                            if (contextG != null) {
                                jSONObject.put("startX", t.a(contextG, iArr[0]));
                                jSONObject.put("startY", t.a(contextG, iArr[1]));
                                jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(contextG));
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                            string = "";
                        }
                        String strEncodeToString = Base64.encodeToString(string.toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) AnythinkH5EndCardView.this.f11825s, AnythinkH5EndCardView.f11821o, strEncodeToString);
                        AnythinkH5EndCardView.this.f11787e.a(109, "");
                        AnythinkH5EndCardView.g(AnythinkH5EndCardView.this);
                        AnythinkH5EndCardView.this.startCounterEndCardShowTimer();
                        j.a();
                        j.a((WebView) AnythinkH5EndCardView.this.f11825s, "oncutoutfetched", Base64.encodeToString(AnythinkH5EndCardView.this.ac.getBytes(), 0));
                        AnythinkH5EndCardView.i(AnythinkH5EndCardView.this);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            r8 = this;
            java.lang.String r0 = "wfr=1"
            java.lang.String r1 = "="
            java.lang.String r2 = "AnythinkBaseView"
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lbc
            r8.P = r3     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.foundation.d.c r3 = r8.b     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r3 = r3.I()     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.videocommon.e.c r4 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.foundation.b.a r5 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r5 = r5.e()     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r6 = r8.f11830x     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.videocommon.e.d r4 = r4.a(r5, r6)     // Catch: java.lang.Throwable -> Lbc
            boolean r5 = r8.J     // Catch: java.lang.Throwable -> Lbc
            if (r5 == 0) goto Lbb
            boolean r5 = com.anythink.expressad.foundation.h.w.b(r3)     // Catch: java.lang.Throwable -> Lbc
            if (r5 == 0) goto Lbb
            boolean r5 = r3.contains(r0)     // Catch: java.lang.Throwable -> Lbc
            if (r5 != 0) goto L3c
            if (r4 == 0) goto Lbb
            int r5 = r4.o()     // Catch: java.lang.Throwable -> Lbc
            if (r5 <= 0) goto Lbb
        L3c:
            java.lang.String r5 = "需要上报endcard加载时间"
            com.anythink.expressad.foundation.h.o.d(r2, r5)     // Catch: java.lang.Throwable -> Lbc
            boolean r0 = r3.contains(r0)     // Catch: java.lang.Throwable -> Lbc
            r5 = 20
            if (r0 == 0) goto L91
            java.lang.String r0 = "&"
            java.lang.String[] r0 = r3.split(r0)     // Catch: java.lang.Throwable -> Lbc
            if (r0 == 0) goto L9e
            int r3 = r0.length     // Catch: java.lang.Throwable -> Lbc
            if (r3 <= 0) goto L9e
            int r3 = r0.length     // Catch: java.lang.Throwable -> Lbc
            r4 = 0
        L56:
            if (r4 >= r3) goto L9e
            r6 = r0[r4]     // Catch: java.lang.Throwable -> Lbc
            boolean r7 = com.anythink.expressad.foundation.h.w.b(r6)     // Catch: java.lang.Throwable -> Lbc
            if (r7 == 0) goto L8e
            java.lang.String r7 = "to"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> Lbc
            if (r7 == 0) goto L8e
            java.lang.String[] r7 = r6.split(r1)     // Catch: java.lang.Throwable -> Lbc
            if (r7 == 0) goto L8e
            java.lang.String[] r7 = r6.split(r1)     // Catch: java.lang.Throwable -> Lbc
            int r7 = r7.length     // Catch: java.lang.Throwable -> Lbc
            if (r7 <= 0) goto L8e
            java.lang.String[] r0 = r6.split(r1)     // Catch: java.lang.Throwable -> Lbc
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.Throwable -> Lbc
            int r0 = com.anythink.expressad.foundation.h.t.a(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r1 = "从url获取的waitingtime:"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r1 = r1.concat(r3)     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.foundation.h.o.b(r2, r1)     // Catch: java.lang.Throwable -> Lbc
            goto La0
        L8e:
            int r4 = r4 + 1
            goto L56
        L91:
            if (r4 == 0) goto L9e
            int r0 = r4.o()     // Catch: java.lang.Throwable -> Lbc
            if (r0 <= 0) goto L9e
            int r0 = r4.o()     // Catch: java.lang.Throwable -> Lbc
            goto La0
        L9e:
            r0 = 20
        La0:
            if (r0 < 0) goto Lb3
            r8.excuteEndCardShowTask(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r1 = "开启excuteEndCardShowTask:"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r0 = r1.concat(r0)     // Catch: java.lang.Throwable -> Lbc
            com.anythink.expressad.foundation.h.o.b(r2, r0)     // Catch: java.lang.Throwable -> Lbc
            return
        Lb3:
            r8.excuteEndCardShowTask(r5)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r0 = "开启excuteEndCardShowTask: 20s def"
            com.anythink.expressad.foundation.h.o.b(r2, r0)     // Catch: java.lang.Throwable -> Lbc
        Lbb:
            return
        Lbc:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.anythink.expressad.foundation.h.o.b(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkH5EndCardView.f():void");
    }

    private void h() {
        if (this.af || this.T) {
            return;
        }
        this.af = true;
        int i2 = this.L;
        if (i2 == 0) {
            this.W = true;
            return;
        }
        this.W = false;
        if (i2 >= 0) {
            this.f11826t.postDelayed(new e(this), this.L * 1000);
        }
    }

    private void j() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        int i2 = getResources().getConfiguration().orientation;
        String str = "undefined";
        if (i2 != 0) {
            if (i2 == 1) {
                str = B;
            } else if (i2 == 2) {
                str = C;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put(CallMraidJS.a, "Interstitial");
        map.put(CallMraidJS.b, "default");
        map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
        map.put(CallMraidJS.f8281d, jSONObject);
        if (getContext() instanceof Activity) {
            float fE = k.e(getContext());
            float f2 = k.f(getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            CallMraidJS.getInstance().fireSetScreenSize(this.f11825s, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.f11825s, f3, f4);
        }
        CallMraidJS.getInstance().fireSetDefaultPosition(this.f11825s, r7.getLeft(), this.f11825s.getTop(), this.f11825s.getWidth(), this.f11825s.getHeight());
        CallMraidJS.getInstance().fireSetCurrentPosition(this.f11825s, r13.getLeft(), this.f11825s.getTop(), this.f11825s.getWidth(), this.f11825s.getHeight());
        CallMraidJS.getInstance().fireChangeEventForPropertys(this.f11825s, map);
        CallMraidJS.getInstance().fireAudioVolumeChange(this.f11825s, MraidVolumeChangeReceiver.a);
        CallMraidJS.getInstance().fireReadyEvent(this.f11825s);
    }

    protected RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f11788f) {
            this.f11824r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnythinkH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    protected void e() {
        if (this.f11788f) {
            setMatchParent();
        }
    }

    protected String a() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            this.R = true;
            if (cVar.H()) {
                this.J = false;
                String strG = this.b.G();
                if (!TextUtils.isEmpty(strG)) {
                    File file = new File(strG);
                    try {
                        if (file.exists() && file.isFile() && file.canRead()) {
                            o.b(AnythinkBaseView.TAG, "Mraid file ".concat(String.valueOf(strG)));
                            strG = "file:////".concat(String.valueOf(strG));
                        } else {
                            o.b(AnythinkBaseView.TAG, "Mraid file not found. Will use endcard url.");
                            strG = this.b.P();
                        }
                        return strG;
                    } catch (Throwable th) {
                        if (!com.anythink.expressad.a.a) {
                            return strG;
                        }
                        th.printStackTrace();
                        return strG;
                    }
                }
                String strP = this.b.P();
                o.d(AnythinkBaseView.TAG, "getURL playable=false endscreenurl兜底:".concat(String.valueOf(strP)));
                return strP;
            }
            String strI = this.b.I();
            if (!w.a(strI)) {
                this.J = true;
                String strC = i.a().c(strI);
                if (TextUtils.isEmpty(strC)) {
                    try {
                        String path = Uri.parse(strI).getPath();
                        if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                            String strP2 = this.b.P();
                            if (TextUtils.isEmpty(strP2)) {
                                return null;
                            }
                            this.J = false;
                            excuteTask();
                            return strP2;
                        }
                    } catch (Throwable th2) {
                        o.d(AnythinkBaseView.TAG, th2.getMessage());
                    }
                    o.b(AnythinkBaseView.TAG, "getURL playable=true endcard本地资源地址为空拿服务端地址:".concat(String.valueOf(strI)));
                    return strI + "&native_adtype=" + this.b.w();
                }
                o.b(AnythinkBaseView.TAG, "getURL playable=true 资源不为空endcard地址:".concat(String.valueOf(strC)));
                return strC + "&native_adtype=" + this.b.w();
            }
            this.J = false;
            String strP3 = this.b.P();
            o.d(AnythinkBaseView.TAG, "getURL playable=false endscreenurl兜底:".concat(String.valueOf(strP3)));
            return strP3;
        }
        this.R = false;
        o.d(AnythinkBaseView.TAG, "getURL playable=false url为空");
        return null;
    }

    static /* synthetic */ void g(AnythinkH5EndCardView anythinkH5EndCardView) {
        com.anythink.expressad.foundation.d.c cVar = anythinkH5EndCardView.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        int i2 = anythinkH5EndCardView.getResources().getConfiguration().orientation;
        String str = "undefined";
        if (i2 != 0) {
            if (i2 == 1) {
                str = B;
            } else if (i2 == 2) {
                str = C;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put(CallMraidJS.a, "Interstitial");
        map.put(CallMraidJS.b, "default");
        map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
        map.put(CallMraidJS.f8281d, jSONObject);
        if (anythinkH5EndCardView.getContext() instanceof Activity) {
            float fE = k.e(anythinkH5EndCardView.getContext());
            float f2 = k.f(anythinkH5EndCardView.getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) anythinkH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            CallMraidJS.getInstance().fireSetScreenSize(anythinkH5EndCardView.f11825s, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(anythinkH5EndCardView.f11825s, f3, f4);
        }
        CallMraidJS.getInstance().fireSetDefaultPosition(anythinkH5EndCardView.f11825s, r7.getLeft(), anythinkH5EndCardView.f11825s.getTop(), anythinkH5EndCardView.f11825s.getWidth(), anythinkH5EndCardView.f11825s.getHeight());
        CallMraidJS.getInstance().fireSetCurrentPosition(anythinkH5EndCardView.f11825s, r13.getLeft(), anythinkH5EndCardView.f11825s.getTop(), anythinkH5EndCardView.f11825s.getWidth(), anythinkH5EndCardView.f11825s.getHeight());
        CallMraidJS.getInstance().fireChangeEventForPropertys(anythinkH5EndCardView.f11825s, map);
        CallMraidJS.getInstance().fireAudioVolumeChange(anythinkH5EndCardView.f11825s, MraidVolumeChangeReceiver.a);
        CallMraidJS.getInstance().fireReadyEvent(anythinkH5EndCardView.f11825s);
    }

    static /* synthetic */ void i(AnythinkH5EndCardView anythinkH5EndCardView) {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b.a().c(anythinkH5EndCardView.f11830x + "_1");
                anythinkH5EndCardView.H = com.anythink.expressad.foundation.f.b.a().b(anythinkH5EndCardView.f11830x + "_2");
                if (anythinkH5EndCardView.H != null) {
                    ViewGroup viewGroup = (ViewGroup) anythinkH5EndCardView.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(anythinkH5EndCardView.H);
                    }
                    anythinkH5EndCardView.f11823q.addView(anythinkH5EndCardView.H);
                    anythinkH5EndCardView.f11823q.postDelayed(anythinkH5EndCardView.new AnonymousClass5(), 200L);
                }
                anythinkH5EndCardView.b.l(anythinkH5EndCardView.f11830x);
                com.anythink.expressad.foundation.f.b.a().a(anythinkH5EndCardView.f11830x + "_2", anythinkH5EndCardView.b);
                com.anythink.expressad.foundation.f.b.a().a(anythinkH5EndCardView.f11830x + "_2", anythinkH5EndCardView.new AnonymousClass6());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public AnythinkH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = false;
        this.f11826t = new Handler();
        this.f11828v = false;
        this.f11829w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.f11831y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (AnythinkH5EndCardView.this.R) {
                    AnythinkH5EndCardView.this.f11787e.a(122, "");
                }
                AnythinkH5EndCardView.this.f11787e.a(103, "");
            }
        };
        this.ae = false;
        this.af = false;
        this.f11832z = false;
    }

    private boolean a(View view) {
        this.f11824r = (ImageView) view.findViewById(findID("anythink_windwv_close"));
        this.f11823q = (RelativeLayout) view.findViewById(findID("anythink_windwv_content_rl"));
        this.f11825s = new WindVaneWebView(getContext());
        this.f11825s.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f11823q.addView(this.f11825s);
        return isNotNULL(this.f11824r, this.f11825s);
    }

    private void a(long j2, boolean z2) {
        try {
            if (this.M) {
                o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                return;
            }
            this.M = true;
            String str = "2";
            if (w.b(this.b.I()) && this.b.I().contains(".zip")) {
                str = "1";
            }
            int i2 = 10;
            String str2 = "ready yes";
            if (z2) {
                i2 = 12;
                str2 = "ready timeout";
            } else if (this.O == 2) {
                i2 = 11;
                str2 = "ready no";
            }
            o.b(AnythinkBaseView.TAG, "insertEndCardReadyState result:" + i2 + " endCardLoadTime:" + j2 + " endcardurl:" + this.b.I() + "  id:" + this.b.aZ() + "  unitid:" + this.f11830x + "  reason:" + str2 + "  type:" + str);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
        }
    }

    private void a(String str) {
        try {
            String strAd = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.f11830x);
            this.b.p(strAd);
            this.f11787e.a(126, "");
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void a(AnythinkH5EndCardView anythinkH5EndCardView, long j2) {
        try {
            if (anythinkH5EndCardView.M) {
                o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                return;
            }
            anythinkH5EndCardView.M = true;
            String str = "2";
            if (w.b(anythinkH5EndCardView.b.I()) && anythinkH5EndCardView.b.I().contains(".zip")) {
                str = "1";
            }
            int i2 = 10;
            String str2 = "ready yes";
            if (anythinkH5EndCardView.O == 2) {
                i2 = 11;
                str2 = "ready no";
            }
            o.b(AnythinkBaseView.TAG, "insertEndCardReadyState result:" + i2 + " endCardLoadTime:" + j2 + " endcardurl:" + anythinkH5EndCardView.b.I() + "  id:" + anythinkH5EndCardView.b.aZ() + "  unitid:" + anythinkH5EndCardView.f11830x + "  reason:" + str2 + "  type:" + str);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
        }
    }
}
