package com.anythink.expressad.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.g;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;
import com.anythink.expressad.video.module.a.a.f;
import com.anythink.expressad.video.module.a.a.m;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.container.AbstractJSContainer;
import com.anythink.expressad.videocommon.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ATTempContainer extends AbstractJSContainer {
    private static final String A = ATTempContainer.class.getSimpleName();
    private static final long aa = 5000;
    private static final long ab = 2000;
    private static final long ac = 100;
    private static final int ad = -1;
    private static final int ae = -2;
    private static final int af = -3;
    private static final int ag = -3;
    private static final int ah = -4;
    private static final int al = 250;
    protected static final int b = 0;
    private View B;
    private com.anythink.expressad.foundation.d.c C;
    private com.anythink.expressad.videocommon.b.c D;
    private h E;
    private com.anythink.expressad.video.bt.module.a.b F;
    private com.anythink.expressad.video.dynview.f.a G;
    private int H;
    private String I;
    private com.anythink.expressad.video.signal.factory.b J;
    private int K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private String S;
    private String T;
    private List<com.anythink.expressad.foundation.d.c> U;
    private int V;
    private LayoutInflater W;
    protected boolean a;
    private int ai;
    private int aj;
    private int ak;
    private View am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private MraidVolumeChangeReceiver ax;
    private Runnable ay;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f11484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a f11485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected WindVaneWebView f11486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AnythinkVideoView f11487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected AnythinkContainerView f11488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Handler f11489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Runnable f11490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Runnable f11491j;

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass5() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String string;
            ATTempContainer.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.f11486e, AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String string;
            ATTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.f11486e, AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String string;
            ATTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.f11486e, AbsFeedBackForH5.a, strEncodeToString);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$6, reason: invalid class name */
    final class AnonymousClass6 implements MraidVolumeChangeReceiver.VolumeChangeListener {
        AnonymousClass6() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener
        public final void onVolumeChanged(double d2) {
            o.d(ATTempContainer.A, "volume is : ".concat(String.valueOf(d2)));
            try {
                if (!ATTempContainer.this.C.H() || ATTempContainer.this.f11488g == null || ATTempContainer.this.f11488g.getH5EndCardView() == null) {
                    return;
                }
                ATTempContainer.this.f11488g.getH5EndCardView().volumeChange(d2);
            } catch (Exception e2) {
                o.d(ATTempContainer.A, e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATTempContainer.this.am.setBackgroundColor(0);
            ATTempContainer.this.am.setVisibility(0);
            ATTempContainer.this.am.bringToFront();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$8, reason: invalid class name */
    final class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATTempContainer.this.am.setVisibility(8);
        }
    }

    public interface a {
        void a(String str);

        boolean a();

        void b();

        /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$a$a, reason: collision with other inner class name */
        public static class C0221a implements a {
            private static final String b = "ActivityErrorListener";
            private boolean a = false;

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public void a(String str) {
                o.d(b, str);
                this.a = true;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final void b() {
                this.a = true;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final boolean a() {
                return this.a;
            }
        }
    }

    private final class b extends f {
        private Activity V;
        private com.anythink.expressad.foundation.d.c W;

        public b(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
            this.V = activity;
            this.W = cVar;
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i2, Object obj) {
            Context context = ATTempContainer.this.getContext();
            if (context != null && context != context.getApplicationContext()) {
                ATTempContainer.this.getJSCommon().a(context);
            }
            if (this.V != null) {
                ATTempContainer.this.getJSCommon().a(this.V);
            }
            ATTempContainer.m(ATTempContainer.this);
            if (i2 == 108) {
                ATTempContainer.this.getJSCommon().a(new c.b(ATTempContainer.this.getJSCommon(), new d(ATTempContainer.this, (byte) 0)));
                ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            } else if (i2 == 113) {
                ATTempContainer.this.E.a(this.W);
            } else if (i2 == 117) {
                AnythinkVideoView anythinkVideoView = ATTempContainer.this.f11487f;
                if (anythinkVideoView != null) {
                    anythinkVideoView.setVisible(4);
                }
                ATTempContainer.m(ATTempContainer.this);
                ATTempContainer.this.E.c();
            } else if (i2 != 126 && i2 != 128) {
                switch (i2) {
                    case 103:
                    case 104:
                        ATTempContainer.k(ATTempContainer.this);
                        break;
                    case 105:
                        ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                    case 106:
                        if (ATTempContainer.this.F != null) {
                            ATTempContainer.this.F.a(ATTempContainer.this.I, this.W);
                        } else {
                            ATTempContainer.this.E.a(this.W);
                        }
                        if (this.V != null && this.W != null) {
                            n.a().a(new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.b.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ATTempContainer.k(ATTempContainer.this);
                                }
                            }, 50L);
                        }
                        break;
                }
            } else {
                ATTempContainer.this.E.a(this.W);
            }
            super.a(i2, obj);
        }
    }

    private final class c extends f {
        private c() {
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i2, Object obj) {
            super.a(i2, obj);
            try {
                String string = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (((AbstractJSContainer) ATTempContainer.this).f12085t && !TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    int iOptInt = jSONObject.optInt("type");
                    int iOptInt2 = jSONObject.optInt(com.anythink.expressad.foundation.d.c.bX);
                    if (iOptInt == 2) {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cx;
                    } else if (iOptInt != 3) {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cv;
                    } else {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cw;
                    }
                    ATTempContainer.this.L = iOptInt2;
                }
            } catch (Exception unused) {
                o.d("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i2 == 120) {
                ATTempContainer.this.E.c();
                return;
            }
            if (i2 == 126) {
                ATTempContainer.this.E.a(ATTempContainer.this.C);
                return;
            }
            if (i2 == 127) {
                ATTempContainer.h(ATTempContainer.this);
                ATTempContainer.this.E.a();
                ATTempContainer.this.E.c();
                ATTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i2) {
                case 100:
                    ATTempContainer.q(ATTempContainer.this);
                    ATTempContainer aTTempContainer = ATTempContainer.this;
                    aTTempContainer.f11489h.postDelayed(aTTempContainer.ay, 250L);
                    ATTempContainer.this.E.a();
                    break;
                case 101:
                case 102:
                    ATTempContainer.this.getJSCommon().j();
                    break;
                case 103:
                    ATTempContainer.h(ATTempContainer.this);
                    if (!ATTempContainer.this.C.H()) {
                        ATTempContainer.this.getJSCommon().j();
                    } else {
                        ATTempContainer.k(ATTempContainer.this);
                    }
                    break;
                case 104:
                    ATTempContainer.k(ATTempContainer.this);
                    break;
                case 105:
                    ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    break;
            }
        }

        /* synthetic */ c(ATTempContainer aTTempContainer, byte b) {
            this();
        }
    }

    private class d extends c.a {
        private d() {
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            super.a(cVar, str);
            ATTempContainer.s(ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void b() {
            super.b();
            ATTempContainer.this.receiveSuccess();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
            ATTempContainer aTTempContainer = ATTempContainer.this;
            Handler handler = aTTempContainer.f11489h;
            if (handler != null) {
                handler.removeCallbacks(aTTempContainer.f11490i);
            }
        }

        /* synthetic */ d(ATTempContainer aTTempContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, String str) {
            super.a(jVar, str);
            ATTempContainer.t(ATTempContainer.this);
            ATTempContainer.u(ATTempContainer.this);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                String strOptString = new JSONObject(ATTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                if (cVar.Q() == 3 && cVar.C() == 2 && strOptString.equals("1.0") && ((AbstractJSContainer) ATTempContainer.this).f12077l != null) {
                    if (!((AbstractJSContainer) ATTempContainer.this).f12090y) {
                        ((AbstractJSContainer) ATTempContainer.this).f12077l.finish();
                    } else {
                        ATTempContainer.k(ATTempContainer.this);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, String str) {
            super.b(jVar, str);
            ATTempContainer.u(ATTempContainer.this);
            ATTempContainer.t(ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
            super.a(cVar, z2);
            ATTempContainer.this.E.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i2, String str) {
            super.a(i2, str);
            ATTempContainer.this.defaultLoad(i2, str);
        }
    }

    private final class e extends f {
        private e() {
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i2, Object obj) {
            super.a(i2, obj);
            if (((AbstractJSContainer) ATTempContainer.this).f12085t) {
                try {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            ATTempContainer.this.K = jSONObject.getInt("Alert_window_status");
                            ATTempContainer.this.L = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (Exception e2) {
                    o.d("NotifyListener", e2.getMessage());
                }
            }
            if (i2 != 2) {
                if (i2 == 121) {
                    ATTempContainer.h(ATTempContainer.this);
                    ATTempContainer.this.E.b();
                    ATTempContainer.this.at = false;
                    return;
                }
                if (i2 == 16) {
                    ATTempContainer.k(ATTempContainer.this);
                    return;
                }
                if (i2 == 17) {
                    ATTempContainer.h(ATTempContainer.this);
                    AnythinkContainerView anythinkContainerView = ATTempContainer.this.f11488g;
                    if (anythinkContainerView != null) {
                        anythinkContainerView.setRewardStatus(true);
                        return;
                    }
                    return;
                }
                switch (i2) {
                    case 10:
                        ATTempContainer.this.at = true;
                        if (ATTempContainer.this.C != null) {
                            if (!ATTempContainer.this.C.j()) {
                                ATTempContainer.this.E.a();
                            } else if (!((AbstractJSContainer) ATTempContainer.this).f12090y) {
                                ATTempContainer.this.E.a();
                            } else if (ATTempContainer.this.C.l()) {
                                ATTempContainer.this.E.a();
                            }
                        }
                        break;
                }
                return;
            }
            if (i2 == 12 && !ATTempContainer.this.at) {
                if (((AbstractJSContainer) ATTempContainer.this).f12080o.U() == 0) {
                    ATTempContainer.this.E.a("play error");
                    ATTempContainer.this.at = false;
                    ATTempContainer.k(ATTempContainer.this);
                    return;
                } else if (ATTempContainer.this.C == null || !ATTempContainer.this.C.j() || !((AbstractJSContainer) ATTempContainer.this).f12090y || ATTempContainer.this.C.l()) {
                    ATTempContainer.this.E.a();
                }
            }
            ATTempContainer.this.getJSVideoModule().videoOperate(3);
            ATTempContainer.this.at = false;
        }

        /* synthetic */ e(ATTempContainer aTTempContainer, byte b) {
            this();
        }
    }

    public ATTempContainer(Context context) {
        super(context);
        this.H = 1;
        this.I = "";
        this.K = com.anythink.expressad.foundation.g.a.cv;
        this.M = false;
        this.S = "";
        this.U = new ArrayList();
        this.V = 0;
        this.a = false;
        this.f11484c = false;
        this.f11485d = new a.C0221a();
        this.f11489h = new Handler();
        this.ai = 0;
        this.aj = 0;
        this.ak = 0;
        this.f11490i = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() != 0) {
                    ATTempContainer.this.ai = -3;
                } else {
                    String unused = ATTempContainer.A;
                    ATTempContainer.this.defaultLoad(-1, "WebView load timeout");
                }
            }
        };
        this.f11491j = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() == 0) {
                    ATTempContainer.this.defaultLoad(-3, "JS bridge connect timeout");
                } else {
                    ATTempContainer.this.ai = -4;
                }
            }
        };
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.ar = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ay = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.am != null) {
                    ATTempContainer.this.am.setVisibility(8);
                }
            }
        };
        init(context);
    }

    static /* synthetic */ boolean h(ATTempContainer aTTempContainer) {
        aTTempContainer.ao = true;
        return true;
    }

    private void k() {
        int i2 = this.ai;
        Runnable runnable = i2 == -3 ? this.f11490i : i2 == -4 ? this.f11491j : null;
        if (runnable != null) {
            runnable.run();
            this.ai = 0;
        }
    }

    static /* synthetic */ boolean m(ATTempContainer aTTempContainer) {
        aTTempContainer.au = true;
        return true;
    }

    private static void n() {
    }

    private static void p() {
    }

    static /* synthetic */ boolean q(ATTempContainer aTTempContainer) {
        aTTempContainer.av = true;
        return true;
    }

    private void s() {
        if (this.ao) {
            o.a(A, "sendToServerRewardInfo");
            com.anythink.expressad.video.module.b.a.a(this.C, this.f12082q, this.f12078m, this.f12081p, this.T);
        }
    }

    static /* synthetic */ boolean t(ATTempContainer aTTempContainer) {
        aTTempContainer.as = true;
        return true;
    }

    private static int u() {
        try {
            com.anythink.expressad.videocommon.e.a aVarB = com.anythink.expressad.videocommon.e.c.a().b();
            if (aVarB == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            iG = aVarB != null ? (int) aVarB.g() : 5;
            o.b(A, "AnythinkBaseView buffetTimeout:".concat(String.valueOf(iG)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return iG;
    }

    public boolean canBackPress() {
        AnythinkContainerView anythinkContainerView = this.f11488g;
        return anythinkContainerView == null || anythinkContainerView.canBackPress();
    }

    public void defaultLoad(int i2, String str) {
        int i3;
        superDefaultLoad(i2, str);
        o.a(A, "hybrid load error ,start defaultLoad,desc:".concat(String.valueOf(str)));
        if (!isLoadSuccess()) {
            a(i2, str);
            Activity activity = this.f12077l;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        byte b2 = 0;
        if (this.C.J() == 2) {
            this.f11488g.setCampaign(this.C);
            this.f11488g.addOrderViewData(this.U);
            this.f11488g.setUnitID(this.f12078m);
            this.f11488g.setCloseDelayTime(this.C.g() > -2 ? this.C.g() : this.f12080o.p());
            this.f11488g.setPlayCloseBtnTm(this.f12080o.j());
            this.f11488g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.C, this.D, this.f12082q, b(), this.f12078m, new c(this, b2), this.f12080o.M(), this.f12090y));
            this.f11488g.preLoadData(this.J);
            this.f11488g.showPlayableView();
            return;
        }
        a(i2, str);
        this.am.setVisibility(8);
        loadModuleDatas();
        int iF = this.f12080o.f();
        int iE = e();
        int i4 = iE != 0 ? iE : iF;
        com.anythink.expressad.foundation.d.c cVar = this.C;
        if (cVar != null && cVar.j()) {
            this.f11487f.setContainerViewOnNotifyListener(new b(this.f12077l, this.C));
        }
        com.anythink.expressad.foundation.d.c cVar2 = this.C;
        int iE2 = (cVar2 == null || cVar2.h() <= -2) ? this.f12080o.e() : this.C.h();
        if (this.C.k() == 5 && (i3 = this.H) > 1) {
            iE2 = a(iE2, i3);
            this.C.a(iE2);
        }
        int i5 = iE2;
        this.f11487f.setVideoSkipTime(i5);
        AnythinkVideoView anythinkVideoView = this.f11487f;
        anythinkVideoView.setNotifyListener(new m(anythinkVideoView, this.f11488g, this.C, this.f12082q, this.D, b(), this.f12078m, i4, i5, new e(this, b2), this.f12080o.M(), this.f12090y, this.f12080o.U()));
        this.f11487f.defaultShow();
        AnythinkContainerView anythinkContainerView = this.f11488g;
        anythinkContainerView.setNotifyListener(new com.anythink.expressad.video.module.a.a.b(this.f11487f, anythinkContainerView, this.C, this.f12082q, this.D, b(), this.f12078m, new b(this.f12077l, this.C), this.f12080o.M(), this.f12090y));
        this.f11488g.defaultShow();
    }

    public AnythinkContainerView findAnythinkContainerView() {
        return (AnythinkContainerView) findViewById(findID("anythink_video_templete_container"));
    }

    public AnythinkVideoView findAnythinkVideoView() {
        return (AnythinkVideoView) findViewById(findID("anythink_video_templete_videoview"));
    }

    public int findID(String str) {
        return i.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return i.a(getContext(), str, "layout");
    }

    public WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.f12090y) {
                o.a(A, "当前非大模板");
                a.C0226a c0226aA = this.f12085t ? com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.C) : com.anythink.expressad.videocommon.a.a(94, this.C);
                if (c0226aA == null || !c0226aA.c()) {
                    return null;
                }
                if (this.f12085t) {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.C);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.C);
                }
                WindVaneWebView windVaneWebViewA = c0226aA.a();
                if (this.ar) {
                    windVaneWebViewA.setWebViewTransparent();
                }
                return windVaneWebViewA;
            }
            o.a(A, "当前大模板");
            if (this.C == null || this.C.M() == null) {
                return null;
            }
            o.a(A, "当前大模板，存在播放模板");
            a.C0226a c0226aA2 = com.anythink.expressad.videocommon.a.a(this.f12078m + "_" + this.C.aZ() + "_" + this.C.Z() + "_" + this.C.M().e());
            if (c0226aA2 != null) {
                return c0226aA2.a();
            }
            return null;
        } catch (Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public com.anythink.expressad.foundation.d.c getCampaign() {
        return this.C;
    }

    public String getInstanceId() {
        return this.I;
    }

    public int getLayoutID() {
        return findLayout(this.ar ? "anythink_reward_activity_video_templete_transparent" : "anythink_reward_activity_video_templete");
    }

    public void init(Context context) {
        this.W = LayoutInflater.from(context);
    }

    public boolean initViews() {
        this.am = findViewById(findID("anythink_video_templete_progressbar"));
        return this.am != null;
    }

    public boolean isLoadSuccess() {
        return this.f11484c;
    }

    public void loadModuleDatas() {
        int i2;
        int i3;
        com.anythink.expressad.video.signal.a.j jVarB = b(this.C);
        byte b2 = 0;
        int iB = jVarB != null ? jVarB.b() : 0;
        if (iB != 0) {
            this.f12084s = iB;
        }
        int iF = this.f12080o.f();
        int iE = e();
        int i4 = iE != 0 ? iE : iF;
        this.f11487f.setSoundState(this.f12084s);
        this.f11487f.setCampaign(this.C);
        this.f11487f.setPlayURL(this.D.r());
        com.anythink.expressad.foundation.d.c cVar = this.C;
        int iE2 = (cVar == null || cVar.h() <= -2) ? this.f12080o.e() : this.C.h();
        if (this.C.k() == 5 && (i3 = this.H) > 1) {
            iE2 = a(iE2, i3);
            this.C.a(iE2);
        }
        this.f11487f.setVideoSkipTime(iE2);
        this.f11487f.setCloseAlert(this.f12080o.k());
        this.f11487f.setBufferTimeout(u());
        this.f11487f.setNotifyListener(new com.anythink.expressad.video.module.a.a.n(this.J, this.C, this.f12082q, this.D, b(), this.f12078m, i4, iE2, new e(this, b2), this.f12080o.M(), this.f12090y, this.f12080o.U()));
        this.f11487f.setShowingTransparent(this.ar);
        if (this.f12085t && ((i2 = this.f12087v) == com.anythink.expressad.foundation.g.a.cr || i2 == com.anythink.expressad.foundation.g.a.cs)) {
            this.f11487f.setIVRewardEnable(this.f12087v, this.f12088w, this.f12089x);
            this.f11487f.setDialogRole(getJSCommon() != null ? getJSCommon().n() : 1);
        }
        this.f11488g.setCampaign(this.C);
        this.f11488g.addOrderViewData(this.U);
        this.f11488g.setUnitID(this.f12078m);
        this.f11488g.setCloseDelayTime(this.C.g() > -2 ? this.C.g() : this.f12080o.p());
        this.f11488g.setPlayCloseBtnTm(this.f12080o.j());
        this.f11488g.setVideoInteractiveType(this.f12080o.h());
        this.f11488g.setEndscreenType(this.f12080o.r());
        this.f11488g.setVideoSkipTime(iE2);
        this.f11488g.setShowingTransparent(this.ar);
        this.f11488g.setJSFactory(this.J);
        if (this.C.J() == 2) {
            this.f11488g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.C, this.D, this.f12082q, b(), this.f12078m, new c(this, (byte) 0), this.f12080o.M(), this.f12090y));
            this.f11488g.preLoadData(this.J);
            this.f11488g.showPlayableView();
        } else {
            this.f11488g.setNotifyListener(new com.anythink.expressad.video.module.a.a.c(this.J, this.C, this.f12082q, this.D, b(), this.f12078m, new b(this.f12077l, this.C), this.f12080o.M(), this.f12090y));
            this.f11488g.preLoadData(this.J);
            this.f11487f.preLoadData(this.J);
        }
        if (this.ar) {
            this.f11488g.setAnythinkClickMiniCardViewTransparent();
        }
    }

    public void notifyEvent(String str) {
        WindVaneWebView windVaneWebView = this.f11486e;
        if (windVaneWebView != null) {
            String str2 = this.I;
            j.a();
            j.a((WebView) windVaneWebView, str, Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    public void onBackPressed() {
        AnythinkContainerView anythinkContainerView;
        AnythinkContainerView anythinkContainerView2;
        AnythinkVideoView anythinkVideoView;
        AnythinkVideoView anythinkVideoView2;
        if (this.ar && (anythinkVideoView2 = this.f11487f) != null) {
            anythinkVideoView2.notifyVideoClose();
            return;
        }
        if (this.at && (anythinkVideoView = this.f11487f) != null) {
            if (!anythinkVideoView.isMiniCardShowing()) {
                this.f11487f.onBackPress();
                return;
            }
            AnythinkContainerView anythinkContainerView3 = this.f11488g;
            if (anythinkContainerView3 != null) {
                anythinkContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.av && (anythinkContainerView2 = this.f11488g) != null) {
            anythinkContainerView2.onPlayableBackPress();
            return;
        }
        if (this.au && (anythinkContainerView = this.f11488g) != null) {
            anythinkContainerView.onEndcardBackPress();
        }
        if (getJSCommon().g()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
                return;
            }
            return;
        }
        if (!canBackPress()) {
            o.a(A, "onBackPressed can't excute");
            return;
        }
        Activity activity = this.f12077l;
        if (activity == null || this.f12090y || this.aw) {
            return;
        }
        this.aw = true;
        activity.onBackPressed();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        ViewGroup viewGroup;
        o.a(A, "onCreate isBigOffer: " + this.f12090y);
        if (this.f12080o == null) {
            this.f12080o = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f12078m, this.f12085t);
        }
        byte b2 = 0;
        this.aw = false;
        try {
            if (!this.f12090y) {
                this.E = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.f12085t, this.f12080o, this.C, this.E, b(), this.f12078m);
            } else if (this.C == null || !this.C.j()) {
                this.E = new com.anythink.expressad.video.bt.module.b.d(this.F, this.I);
            } else {
                this.E = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.f12085t, this.f12080o, this.C, this.E, b(), this.f12078m);
            }
            registerErrorListener(new com.anythink.expressad.video.bt.module.b.f(this.E));
            a(this.f12080o, this.C);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            this.B = this.W.inflate(layoutID, (ViewGroup) null);
            addView(this.B, new RelativeLayout.LayoutParams(-1, -1));
            if (this.a) {
                setMatchParent();
            }
            this.f11486e = findWindVaneWebView();
            this.f11487f = findAnythinkVideoView();
            this.f11487f.setVideoLayout(this.C);
            this.f11487f.setIsIV(this.f12085t);
            this.f11487f.setUnitId(this.f12078m);
            this.f11487f.setCamPlayOrderCallback(this.G, this.U, this.H, this.V);
            if (this.f12090y) {
                this.f11487f.setNotchPadding(this.O, this.P, this.Q, this.R);
            }
            this.f11488g = findAnythinkContainerView();
            if (this.f12090y) {
                this.f11488g.setNotchPadding(this.N, this.O, this.P, this.Q, this.R);
            }
            if (!((this.f11487f == null || this.f11488g == null || !initViews()) ? false : true)) {
                this.f11485d.a(com.anythink.expressad.foundation.e.a.b);
                if (this.f12077l != null) {
                    this.f12077l.finish();
                    return;
                }
                return;
            }
            this.f11484c = true;
            WindVaneWebView windVaneWebView = this.f11486e;
            this.J = new com.anythink.expressad.video.signal.factory.b(this.f12077l, windVaneWebView, this.f11487f, this.f11488g, this.C, new d(this, b2));
            if (this.C != null && this.C.k() == 5 && this.U != null) {
                this.J.a(this.U);
            }
            registerJsFactory(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.f12078m + "_1", new AnonymousClass5());
            if (windVaneWebView == null) {
                o.a(A, "template webview is null");
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
            windVaneWebView.setApiManagerJSFactory(this.J);
            if (windVaneWebView.getParent() != null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                this.J.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
                getJSCommon().a(this.f12084s);
                getJSCommon().a(this.f12078m);
                getJSCommon().a(this.f12080o);
                getJSCommon().a(new d(this, b2));
                if (this.C != null && (this.C.H() || this.C.ay())) {
                    this.ax = new MraidVolumeChangeReceiver(getContext());
                    this.ax.registerReceiver();
                    this.ax.getCurrentVolume();
                    this.ax.setVolumeChangeListener(new AnonymousClass6());
                }
                getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
                j();
                ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).f11928r.b();
                if (this.f12090y) {
                    getJSCommon().f(this.aj);
                    getJSCommon().e(this.ak);
                }
            }
            if (getJSCommon().f() == 1 && (viewGroup = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
                ((ViewGroup) this.B).removeView(viewGroup);
                ((ViewGroup) this.B).addView(viewGroup, 1);
            }
            viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            a("onCreate error".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.M) {
            return;
        }
        boolean z2 = true;
        this.M = true;
        super.onDestroy();
        try {
            if (this.f11487f != null) {
                this.f11487f.releasePlayer();
            }
            if (this.f11486e != null) {
                ViewGroup viewGroup = (ViewGroup) this.f11486e.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f11486e.clearWebView();
                this.f11486e.release();
            }
            if (this.F != null) {
                this.F = null;
            }
            this.f11489h.removeCallbacks(this.f11490i);
            this.f11489h.removeCallbacks(this.f11491j);
            getJSCommon().k();
            if (this.f12085t) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.b.c(this.f12078m);
            }
            if (!this.an) {
                try {
                    this.an = true;
                    if (this.C != null && this.C.J() == 2) {
                        this.ao = true;
                    }
                    if (this.E != null) {
                        if (this.f12085t && (this.f12087v == com.anythink.expressad.foundation.g.a.cr || this.f12087v == com.anythink.expressad.foundation.g.a.cs)) {
                            h hVar = this.E;
                            if (this.L != 1) {
                                z2 = false;
                            }
                            hVar.a(z2, this.K);
                        }
                        if (!this.ao) {
                            this.f12082q.a(0);
                        }
                        this.E.a(this.ao, this.f12082q);
                    }
                    this.f11489h.removeCallbacks(this.ay);
                    if (((!this.f12085t && !this.f12090y) || (this.C != null && this.C.j())) && this.ao) {
                        o.a(A, "sendToServerRewardInfo");
                        com.anythink.expressad.video.module.b.a.a(this.C, this.f12082q, this.f12078m, this.f12081p, this.T);
                    }
                    if (!this.f12090y) {
                        if (this.f12085t) {
                            com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.C);
                        } else {
                            com.anythink.expressad.videocommon.a.b(94, this.C);
                        }
                    }
                    if (this.f11488g != null) {
                        this.f11488g.release();
                    }
                } catch (Throwable th) {
                    o.b(A, th.getMessage(), th);
                }
            }
            if (this.ax != null) {
                this.ax.unregisterReceiver();
            }
            if (!this.f12090y) {
                if (isLoadSuccess()) {
                    this.f11489h.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (((AbstractJSContainer) ATTempContainer.this).f12077l != null) {
                                ((AbstractJSContainer) ATTempContainer.this).f12077l.finish();
                            }
                        }
                    }, ac);
                } else if (this.f12077l != null) {
                    this.f12077l.finish();
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.I);
        } catch (Throwable th2) {
            o.a(A, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.ap = true;
        try {
            getJSVideoModule().videoOperate(2);
            if (this.f11488g != null) {
                this.f11488g.setOnPause();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        super.onResume();
        int i2 = this.ai;
        Runnable runnable = i2 == -3 ? this.f11490i : i2 == -4 ? this.f11491j : null;
        if (runnable != null) {
            runnable.run();
            this.ai = 0;
        }
        try {
            if (this.f11487f != null && !i() && !this.f11487f.isMiniCardShowing() && !com.anythink.expressad.foundation.f.b.f10401c) {
                this.f11487f.setCover(false);
            }
            if (this.f11488g != null) {
                this.f11488g.setOnResume();
            }
            if (this.ap && !i() && !com.anythink.expressad.foundation.f.b.f10401c) {
                getJSVideoModule().videoOperate(1);
            }
            if (this.f12077l != null) {
                t.a(this.f12077l.getWindow().getDecorView());
            }
            if (this.ar && this.as && this.f12077l != null) {
                this.f12077l.finish();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        AnythinkVideoView anythinkVideoView = this.f11487f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setCover(true);
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        o.a(A, "receiveSuccess ,start hybrid");
        this.f11489h.removeCallbacks(this.f11491j);
        this.f11489h.postDelayed(this.ay, 250L);
    }

    public void registerErrorListener(a aVar) {
        this.f11485d = aVar;
    }

    public void setAnythinkTempCallback(com.anythink.expressad.video.bt.module.a.b bVar) {
        this.F = bVar;
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, int i2) {
        this.G = aVar;
        this.H = i2;
    }

    public void setCampOrderViewData(List<com.anythink.expressad.foundation.d.c> list, int i2) {
        if (list != null) {
            this.U = list;
        }
        this.V = i2;
    }

    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        this.C = cVar;
        if (cVar != null) {
            if (TextUtils.isEmpty(cVar.K()) && !TextUtils.isEmpty(this.f12078m)) {
                cVar.l(this.f12078m);
            }
            com.anythink.expressad.foundation.f.b.a().a(cVar.K() + "_1", cVar);
        }
    }

    public void setCampaignDownLoadTask(com.anythink.expressad.videocommon.b.c cVar) {
        this.D = cVar;
    }

    public void setCampaignExpired(boolean z2) {
        try {
            if (this.C != null) {
                if (!z2) {
                    this.C.e(0);
                    if (this.C.A()) {
                        this.C.m(0);
                        return;
                    } else {
                        if (this.f12080o != null) {
                            this.C.m(this.f12080o.a());
                            return;
                        }
                        return;
                    }
                }
                this.C.e(1);
                if (this.f12086u) {
                    this.C.m(0);
                } else if (this.f12080o != null) {
                    if (this.f12080o.M() == 1) {
                        this.C.m(1);
                    } else {
                        this.C.m(0);
                    }
                }
            }
        } catch (Exception e2) {
            o.d(A, e2.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.T = str;
    }

    public void setH5Cbp(int i2) {
        this.ak = i2;
    }

    public void setInstanceId(String str) {
        this.I = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.J = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        this.N = i2;
        this.O = i3;
        this.P = i4;
        this.Q = i5;
        this.R = i6;
        this.S = com.anythink.expressad.foundation.h.h.a(i2, i3, i4, i5, i6);
        o.d(A, this.S);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.S)) {
            getJSCommon().b(this.S);
            if (this.f11486e != null && !TextUtils.isEmpty(this.S)) {
                j.a();
                j.a((WebView) this.f11486e, "oncutoutfetched", Base64.encodeToString(this.S.getBytes(), 0));
            }
        }
        AnythinkVideoView anythinkVideoView = this.f11487f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setNotchPadding(i3, i4, i5, i6);
        }
        AnythinkContainerView anythinkContainerView = this.f11488g;
        if (anythinkContainerView != null) {
            anythinkContainerView.setNotchPadding(i2, i3, i4, i5, i6);
        }
    }

    public void setShowRewardListener(h hVar) {
        this.E = hVar;
    }

    public void setShowingTransparent() {
        int iA;
        Activity activity;
        this.ar = h();
        if (this.ar || (iA = i.a(getContext(), "anythink_reward_theme", i.f10647e)) <= 1 || (activity = this.f12077l) == null) {
            return;
        }
        activity.setTheme(iA);
    }

    public void setWebViewFront(int i2) {
        this.aj = i2;
    }

    public void superDefaultLoad(int i2, String str) {
        o.d(A, "receiveError:" + i2 + ",descroption:" + str);
        this.f11489h.removeCallbacks(this.f11490i);
        this.f11489h.removeCallbacks(this.f11491j);
        this.f11485d.b();
        WindVaneWebView windVaneWebView = this.f11486e;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    private void d() {
        if (this.a) {
            setMatchParent();
        }
    }

    private int e() {
        com.anythink.expressad.video.signal.a.j jVarB = b(this.C);
        if (jVarB != null) {
            return jVarB.c();
        }
        return 0;
    }

    private int f() {
        if (getJSCommon() != null) {
            return getJSCommon().n();
        }
        return 1;
    }

    private int g() {
        com.anythink.expressad.video.signal.a.j jVarB = b(this.C);
        if (jVarB != null) {
            return jVarB.b();
        }
        return 0;
    }

    private boolean h() {
        com.anythink.expressad.video.signal.a.j jVarB = b(this.C);
        if (jVarB != null) {
            return jVarB.a();
        }
        return false;
    }

    private boolean i() {
        AnythinkVideoView anythinkVideoView = this.f11487f;
        if (anythinkVideoView != null) {
            return anythinkVideoView.isShowingAlertView() || this.f11487f.isInstallDialogShowing();
        }
        return false;
    }

    private void j() {
        int iF;
        int iE;
        try {
            if (this.f11486e != null) {
                int i2 = getResources().getConfiguration().orientation;
                if (h()) {
                    iF = t.g(getContext());
                    iE = t.h(getContext());
                    if (g.a(getContext())) {
                        int i3 = t.i(getContext());
                        if (i2 == 2) {
                            iF += i3;
                        } else {
                            iE += i3;
                        }
                    }
                } else {
                    iF = t.f(getContext());
                    iE = t.e(getContext());
                }
                int iC = this.C.M().c();
                if (c(this.C) == 1) {
                    iC = i2;
                }
                getJSNotifyProxy().a(i2, iC, iF, iE);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(getContext()));
                try {
                    if (this.f12082q != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.f12082q.a());
                        jSONObject2.put("amount", this.f12082q.b());
                        jSONObject2.put("id", this.f12083r);
                        jSONObject.put("userId", this.f12081p);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.f12084s);
                        jSONObject.put("extra", this.T);
                    }
                } catch (JSONException e2) {
                    o.a(A, e2.getMessage());
                } catch (Exception e3) {
                    o.a(A, e3.getMessage());
                }
                getJSNotifyProxy().a(jSONObject.toString());
                j.a();
                j.a((WebView) this.f11486e, "oncutoutfetched", Base64.encodeToString(this.S.getBytes(), 0));
                getJSCommon().h();
                loadModuleDatas();
                this.f11489h.postDelayed(this.f11490i, 2000L);
            }
        } catch (Exception e4) {
            if (com.anythink.expressad.a.a) {
                e4.printStackTrace();
            }
        }
    }

    private boolean l() {
        this.f11486e = findWindVaneWebView();
        this.f11487f = findAnythinkVideoView();
        this.f11487f.setVideoLayout(this.C);
        this.f11487f.setIsIV(this.f12085t);
        this.f11487f.setUnitId(this.f12078m);
        this.f11487f.setCamPlayOrderCallback(this.G, this.U, this.H, this.V);
        if (this.f12090y) {
            this.f11487f.setNotchPadding(this.O, this.P, this.Q, this.R);
        }
        this.f11488g = findAnythinkContainerView();
        if (this.f12090y) {
            this.f11488g.setNotchPadding(this.N, this.O, this.P, this.Q, this.R);
        }
        return (this.f11487f == null || this.f11488g == null || !initViews()) ? false : true;
    }

    private void m() {
        if (this.f12080o == null) {
            this.f12080o = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f12078m, this.f12085t);
        }
    }

    private void o() {
        try {
            if (this.F == null) {
                if (this.f12077l != null) {
                    this.f12077l.finish();
                    return;
                }
                return;
            }
            if (this.f12085t && (this.f12087v == com.anythink.expressad.foundation.g.a.cr || this.f12087v == com.anythink.expressad.foundation.g.a.cs)) {
                com.anythink.expressad.video.bt.module.a.b bVar = this.F;
                boolean z2 = true;
                if (this.L != 1) {
                    z2 = false;
                }
                bVar.a(z2, this.K);
            }
            this.F.a(this.I, this.ao, this.f12082q);
        } catch (Exception unused) {
            Activity activity = this.f12077l;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private void q() {
        ViewGroup viewGroup;
        List<com.anythink.expressad.foundation.d.c> list;
        WindVaneWebView windVaneWebView = this.f11486e;
        byte b2 = 0;
        this.J = new com.anythink.expressad.video.signal.factory.b(this.f12077l, windVaneWebView, this.f11487f, this.f11488g, this.C, new d(this, b2));
        com.anythink.expressad.foundation.d.c cVar = this.C;
        if (cVar != null && cVar.k() == 5 && (list = this.U) != null) {
            this.J.a(list);
        }
        registerJsFactory(this.J);
        com.anythink.expressad.foundation.f.b.a().a(this.f12078m + "_1", new AnonymousClass5());
        if (windVaneWebView == null) {
            o.a(A, "template webview is null");
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
        windVaneWebView.setApiManagerJSFactory(this.J);
        if (windVaneWebView.getParent() != null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
            this.J.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
            getJSCommon().a(this.f12084s);
            getJSCommon().a(this.f12078m);
            getJSCommon().a(this.f12080o);
            getJSCommon().a(new d(this, b2));
            com.anythink.expressad.foundation.d.c cVar2 = this.C;
            if (cVar2 != null && (cVar2.H() || this.C.ay())) {
                this.ax = new MraidVolumeChangeReceiver(getContext());
                this.ax.registerReceiver();
                this.ax.getCurrentVolume();
                this.ax.setVolumeChangeListener(new AnonymousClass6());
            }
            getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
            j();
            ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).f11928r.b();
            if (this.f12090y) {
                getJSCommon().f(this.aj);
                getJSCommon().e(this.ak);
            }
        }
        if (getJSCommon().f() == 1 && (viewGroup = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
            ((ViewGroup) this.B).removeView(viewGroup);
            ((ViewGroup) this.B).addView(viewGroup, 1);
        }
        viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r() {
        getJSCommon().a(this.f12084s);
        getJSCommon().a(this.f12078m);
        getJSCommon().a(this.f12080o);
        getJSCommon().a(new d(this, (byte) 0));
        com.anythink.expressad.foundation.d.c cVar = this.C;
        if (cVar != null) {
            if (cVar.H() || this.C.ay()) {
                this.ax = new MraidVolumeChangeReceiver(getContext());
                this.ax.registerReceiver();
                this.ax.getCurrentVolume();
                this.ax.setVolumeChangeListener(new AnonymousClass6());
            }
        }
    }

    private void t() {
        boolean z2 = true;
        try {
            this.an = true;
            if (this.C != null && this.C.J() == 2) {
                this.ao = true;
            }
            if (this.E != null) {
                if (this.f12085t && (this.f12087v == com.anythink.expressad.foundation.g.a.cr || this.f12087v == com.anythink.expressad.foundation.g.a.cs)) {
                    h hVar = this.E;
                    if (this.L != 1) {
                        z2 = false;
                    }
                    hVar.a(z2, this.K);
                }
                if (!this.ao) {
                    this.f12082q.a(0);
                }
                this.E.a(this.ao, this.f12082q);
            }
            this.f11489h.removeCallbacks(this.ay);
            if (((!this.f12085t && !this.f12090y) || (this.C != null && this.C.j())) && this.ao) {
                o.a(A, "sendToServerRewardInfo");
                com.anythink.expressad.video.module.b.a.a(this.C, this.f12082q, this.f12078m, this.f12081p, this.T);
            }
            if (!this.f12090y) {
                if (this.f12085t) {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.C);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.C);
                }
            }
            if (this.f11488g != null) {
                this.f11488g.release();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    private void v() {
        if (isLoadSuccess()) {
            this.f12077l.runOnUiThread(new AnonymousClass7());
        }
    }

    private void w() {
        if (isLoadSuccess()) {
            this.f12077l.runOnUiThread(new AnonymousClass8());
        }
    }

    private static RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    static /* synthetic */ void s(ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.f12077l.runOnUiThread(aTTempContainer.new AnonymousClass7());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    protected final void a(String str) {
        h hVar = this.E;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    static /* synthetic */ void k(ATTempContainer aTTempContainer) {
        try {
            if (aTTempContainer.F != null) {
                if (aTTempContainer.f12085t && (aTTempContainer.f12087v == com.anythink.expressad.foundation.g.a.cr || aTTempContainer.f12087v == com.anythink.expressad.foundation.g.a.cs)) {
                    com.anythink.expressad.video.bt.module.a.b bVar = aTTempContainer.F;
                    boolean z2 = true;
                    if (aTTempContainer.L != 1) {
                        z2 = false;
                    }
                    bVar.a(z2, aTTempContainer.K);
                }
                aTTempContainer.F.a(aTTempContainer.I, aTTempContainer.ao, aTTempContainer.f12082q);
                return;
            }
            if (aTTempContainer.f12077l != null) {
                aTTempContainer.f12077l.finish();
            }
        } catch (Exception unused) {
            Activity activity = aTTempContainer.f12077l;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static /* synthetic */ void u(ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.f12077l.runOnUiThread(aTTempContainer.new AnonymousClass8());
        }
    }

    private void a(int i2, String str) {
        try {
            r rVar = new r();
            rVar.h(r.f10362i);
            rVar.c("code=" + i2 + ",desc=" + str);
            rVar.b((this.C == null || this.C.M() == null) ? "" : this.C.M().e());
            rVar.f(this.f12078m);
            rVar.g(this.C != null ? this.C.aZ() : "");
            if (this.C != null && !TextUtils.isEmpty(this.C.Z())) {
                rVar.d(this.C.Z());
            }
            if (this.C != null && !TextUtils.isEmpty(this.C.aa())) {
                rVar.e(this.C.aa());
            }
            getContext();
            int iA = k.a();
            rVar.c(iA);
            rVar.j(k.a(getContext(), iA));
            r.a(rVar);
            com.anythink.expressad.video.module.b.a.a();
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    private int a(int i2, int i3) {
        List<com.anythink.expressad.foundation.d.c> list;
        if (i2 < 0 || (list = this.U) == null || list.size() == 0 || i3 <= 1) {
            return i2;
        }
        int iBi = 0;
        for (int i4 = 0; i4 < i3 - 1; i4++) {
            if (this.U.get(i4) != null) {
                iBi += this.U.get(i4).bi();
            }
        }
        if (i2 > iBi) {
            return i2 - iBi;
        }
        return 0;
    }

    public ATTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 1;
        this.I = "";
        this.K = com.anythink.expressad.foundation.g.a.cv;
        this.M = false;
        this.S = "";
        this.U = new ArrayList();
        this.V = 0;
        this.a = false;
        this.f11484c = false;
        this.f11485d = new a.C0221a();
        this.f11489h = new Handler();
        this.ai = 0;
        this.aj = 0;
        this.ak = 0;
        this.f11490i = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() != 0) {
                    ATTempContainer.this.ai = -3;
                } else {
                    String unused = ATTempContainer.A;
                    ATTempContainer.this.defaultLoad(-1, "WebView load timeout");
                }
            }
        };
        this.f11491j = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() == 0) {
                    ATTempContainer.this.defaultLoad(-3, "JS bridge connect timeout");
                } else {
                    ATTempContainer.this.ai = -4;
                }
            }
        };
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.ar = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ay = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.am != null) {
                    ATTempContainer.this.am.setVisibility(8);
                }
            }
        };
        init(context);
    }
}
