package com.anythink.expressad.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.a.j;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.p;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.ATTempContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.dynview.h.b;
import com.anythink.expressad.video.signal.activity.AbstractJSActivity;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.c;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.b.n;
import com.anythink.expressad.videocommon.e.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ATRewardVideoActivity extends AbstractJSActivity {
    public static String a = "unitId";
    public static String b = "userId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11180c = "reward";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f11181d = "mute";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f11182e = "isIV";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f11183f = "isBid";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f11184g = "isBigOffer";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f11185h = "hasRelease";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f11186i = "ivRewardMode";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f11187j = "ivRewardValueType";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f11188k = "ivRewardValue";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f11189l = "extraData";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f11190m = "baserequestInfo";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11191p = "ATRewardVideoActivity";
    private h C;
    private d D;
    private c G;
    private com.anythink.expressad.foundation.d.c H;
    private List<c> I;
    private List<com.anythink.expressad.foundation.d.c> J;
    private ATTempContainer K;
    private AnythinkBTContainer L;
    private WindVaneWebView M;
    private com.anythink.expressad.video.bt.module.a.a N;
    private String O;
    private String P;
    private boolean Q;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f11192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f11193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f11194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.anythink.expressad.videocommon.c.c f11195t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11199x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11200y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11201z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f11196u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f11197v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11198w = false;
    private boolean A = false;
    private boolean B = false;
    private boolean E = false;
    private boolean F = false;
    private int R = 1;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private int X = 0;
    private com.anythink.expressad.video.dynview.f.a Y = new com.anythink.expressad.video.dynview.f.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.1
        @Override // com.anythink.expressad.video.dynview.f.a
        public final void a(Map<String, Object> map) {
            if (map.containsKey("mute")) {
                ATRewardVideoActivity.this.f11196u = ((Integer) map.get("mute")).intValue();
            }
            if (map.containsKey("position")) {
                int iIntValue = ((Integer) map.get("position")).intValue();
                if (ATRewardVideoActivity.this.J == null || ATRewardVideoActivity.this.J.size() <= 0 || iIntValue <= 0) {
                    return;
                }
                ATRewardVideoActivity aTRewardVideoActivity = ATRewardVideoActivity.this;
                aTRewardVideoActivity.H = (com.anythink.expressad.foundation.d.c) aTRewardVideoActivity.J.get(iIntValue);
                ATRewardVideoActivity.b(ATRewardVideoActivity.this);
                int i2 = iIntValue - 1;
                if (ATRewardVideoActivity.this.J.get(i2) != null) {
                    ATRewardVideoActivity aTRewardVideoActivity2 = ATRewardVideoActivity.this;
                    ATRewardVideoActivity.b(aTRewardVideoActivity2, ((com.anythink.expressad.foundation.d.c) aTRewardVideoActivity2.J.get(i2)).bi());
                }
                ATRewardVideoActivity aTRewardVideoActivity3 = ATRewardVideoActivity.this;
                ATRewardVideoActivity.this.H.b(aTRewardVideoActivity3.a(aTRewardVideoActivity3.H.i(), ATRewardVideoActivity.this.R));
                ATRewardVideoActivity aTRewardVideoActivity4 = ATRewardVideoActivity.this;
                aTRewardVideoActivity4.b(aTRewardVideoActivity4.H);
            }
        }
    };
    private com.anythink.expressad.video.dynview.f.d Z = new com.anythink.expressad.video.dynview.f.d() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.2
        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (cVar == null) {
                ATRewardVideoActivity.this.b("campaign is null");
                return;
            }
            if (ATRewardVideoActivity.this.L != null) {
                new b().d(ATRewardVideoActivity.this.L);
            }
            ATRewardVideoActivity.this.H = cVar;
            ATRewardVideoActivity aTRewardVideoActivity = ATRewardVideoActivity.this;
            aTRewardVideoActivity.b(aTRewardVideoActivity.H);
        }

        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a() {
            if (ATRewardVideoActivity.this.L != null) {
                new b().d(ATRewardVideoActivity.this.L);
            }
            ATRewardVideoActivity.f(ATRewardVideoActivity.this);
            ATRewardVideoActivity.this.b();
            if (ATRewardVideoActivity.this.K != null) {
                ATRewardVideoActivity.this.K.setNotchPadding(ATRewardVideoActivity.this.X, ATRewardVideoActivity.this.T, ATRewardVideoActivity.this.V, ATRewardVideoActivity.this.U, ATRewardVideoActivity.this.W);
            }
        }
    };

    private static final class a implements Runnable {
        private final List<c> a;
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11202c;

        public a(List<c> list, String str, String str2) {
            this.a = list;
            this.b = str;
            this.f11202c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a == null || this.a.size() <= 0) {
                    return;
                }
                for (c cVar : this.a) {
                    if (cVar != null && cVar.n() != null) {
                        com.anythink.expressad.foundation.d.c cVarN = cVar.n();
                        String str = cVarN.Z() + cVarN.aZ() + cVarN.S();
                        n nVarC = e.a().c(this.b);
                        if (nVarC != null) {
                            try {
                                nVarC.b(str);
                            } catch (Exception unused) {
                            }
                        }
                        if (cVarN != null && cVarN.M() != null) {
                            if (!TextUtils.isEmpty(cVarN.M().e())) {
                                com.anythink.expressad.videocommon.a.b(this.b + "_" + cVarN.aZ() + "_" + this.f11202c + "_" + cVarN.M().e());
                                com.anythink.expressad.videocommon.a.b(cVarN.w(), cVarN);
                            }
                            if (!TextUtils.isEmpty(cVarN.ar())) {
                                com.anythink.expressad.videocommon.a.b(this.b + "_" + this.f11202c + "_" + cVarN.ar());
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                o.a(ATRewardVideoActivity.f11191p, e2.getMessage());
            }
        }
    }

    static /* synthetic */ int b(ATRewardVideoActivity aTRewardVideoActivity) {
        int i2 = aTRewardVideoActivity.R;
        aTRewardVideoActivity.R = i2 + 1;
        return i2;
    }

    static /* synthetic */ boolean f(ATRewardVideoActivity aTRewardVideoActivity) {
        aTRewardVideoActivity.A = true;
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        int iA = i.a(this, "anythink_reward_activity_close", i.f10648f);
        int iA2 = i.a(this, "anythink_reward_activity_stay", i.f10648f);
        if (iA > 1 && iA2 > 1) {
            overridePendingTransition(iA2, iA);
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.K = null;
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.L = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.f11192q + "_1");
        com.anythink.expressad.foundation.f.b.a().c(this.f11192q + "_2");
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onBackPressed();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onBackPressed();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.K != null) {
            a(configuration.orientation);
            this.K.onConfigurationChanged(configuration);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String strAr = "";
        super.onCreate(bundle);
        com.anythink.expressad.a.f7980x = true;
        com.anythink.expressad.foundation.b.a.b().b(this);
        try {
            Intent intent = getIntent();
            this.f11192q = intent.getStringExtra(a);
            int iA = i.a(getApplicationContext(), "anythink_more_offer_activity", "layout");
            if (iA < 0) {
                b("no anythink_more_offer_activity layout");
                return;
            }
            setContentView(iA);
            if (TextUtils.isEmpty(this.f11192q)) {
                b("data empty error");
                return;
            }
            this.C = com.anythink.expressad.reward.b.a.f11139c.get(this.f11192q);
            this.f11193r = intent.getStringExtra(com.anythink.expressad.a.f7981y);
            this.f11195t = com.anythink.expressad.videocommon.c.c.b(intent.getStringExtra(f11180c));
            this.f11194s = intent.getStringExtra(b);
            this.f11196u = intent.getIntExtra(f11181d, 2);
            this.f11197v = intent.getBooleanExtra(f11182e, false);
            this.f11198w = intent.getBooleanExtra(f11183f, false);
            this.P = intent.getStringExtra(f11189l);
            if (this.f11197v) {
                this.f11199x = intent.getIntExtra(f11186i, 0);
                this.f11200y = intent.getIntExtra(f11187j, 0);
                this.f11201z = intent.getIntExtra(f11188k, 0);
            }
            this.f11964o = new com.anythink.expressad.video.signal.factory.b(this);
            a(this.f11964o);
            if (this.C == null) {
                b("showRewardListener is null");
                return;
            }
            this.D = com.anythink.expressad.reward.a.e.a().a(this.f11193r, this.f11192q);
            if (this.D == null) {
                this.D = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11192q);
                if (this.D == null) {
                    this.D = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11192q, this.f11197v);
                }
            }
            if (this.D != null) {
                this.f11195t.a(this.D.m());
                this.f11195t.a(this.D.n());
            }
            if (this.f11195t != null && this.f11195t.b() <= 0) {
                this.f11195t.a(1);
            }
            int iA2 = i.a(this, "anythink_reward_activity_open", i.f10648f);
            int iA3 = i.a(this, "anythink_reward_activity_stay", i.f10648f);
            if (iA2 > 1 && iA3 > 1) {
                overridePendingTransition(iA2, iA3);
            }
            if (bundle != null) {
                try {
                    this.F = bundle.getBoolean(f11185h);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.I = e.a().b(this.f11192q);
            this.A = intent.getBooleanExtra(f11184g, false);
            if (!this.A) {
                if (this.I != null && this.I.size() > 0) {
                    this.G = this.I.get(0);
                }
                if (this.G != null) {
                    this.H = this.G.n();
                    this.G.a(true);
                    this.G.b(false);
                }
                if (this.G == null || this.H == null || this.f11195t == null) {
                    b("data empty error");
                }
                b();
                return;
            }
            this.J = e.a().a(this.f11192q);
            this.O = "";
            if (this.J != null && this.J.size() > 0) {
                com.anythink.expressad.foundation.d.c cVar = this.J.get(0);
                strAr = cVar.ar();
                this.O = cVar.Z();
            }
            a.C0226a c0226aA = com.anythink.expressad.videocommon.a.a(this.f11192q + "_" + this.O + "_" + strAr);
            this.M = c0226aA != null ? c0226aA.a() : null;
            if (this.M != null) {
                c();
                return;
            }
            if (this.G == null && this.I != null && this.I.size() > 0) {
                this.G = this.I.get(0);
            }
            if (this.G == null) {
                e eVarA = e.a();
                int i2 = this.f11197v ? com.anythink.expressad.foundation.g.a.aU : 94;
                String str = this.f11192q;
                boolean z2 = this.f11198w;
                n nVarC = eVarA.c(str);
                this.G = nVarC != null ? nVarC.b(i2, z2) : null;
            }
            if (this.G != null) {
                this.H = this.G.n();
                this.G.a(true);
                this.G.b(false);
            }
            if (this.G == null || this.H == null || this.f11195t == null) {
                b("data empty error");
            }
            this.A = false;
            com.anythink.expressad.videocommon.a.a.a();
            List<com.anythink.expressad.foundation.d.c> listA = com.anythink.expressad.videocommon.a.a.a(this.J);
            if (listA == null) {
                b("no available campaign");
                return;
            }
            int size = listA.size();
            if (size == 0) {
                b("no available campaign");
                return;
            }
            if (listA.get(0) == null || !listA.get(0).j()) {
                b();
                return;
            }
            if (size != 1) {
                a(listA);
                return;
            }
            this.H = listA.get(0);
            if (this.H != null) {
                this.H.m();
            }
            b(this.H);
        } catch (Throwable th) {
            b("onCreate error".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Throwable unused) {
        }
        try {
            if (this.J != null && this.J.size() > 0) {
                Iterator<com.anythink.expressad.foundation.d.c> it = this.J.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
            if (this.H != null) {
                c(this.H);
            }
        } catch (Throwable th) {
            o.d(f11191p, th.getMessage());
        }
        com.anythink.expressad.video.module.b.a.a(this.f11192q);
        ATTempContainer aTTempContainer = this.K;
        com.anythink.expressad.foundation.d.c cVar = null;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.K = null;
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.L = null;
        }
        this.Y = null;
        this.Z = null;
        com.anythink.expressad.foundation.g.h.a.a().execute(new a(this.I, this.f11192q, this.O));
        List<com.anythink.expressad.foundation.d.c> list = this.J;
        if (list != null && list.size() > 0) {
            cVar = this.J.get(0);
        }
        if (cVar == null) {
            cVar = this.H;
        }
        if (cVar == null || TextUtils.isEmpty(cVar.S())) {
            return;
        }
        j.a().b();
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onPause();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onRestart();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onRestart();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().b(this);
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onResume();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f11185h, this.F);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.4
            @Override // com.anythink.expressad.foundation.f.a
            public final void a() {
                ATRewardVideoActivity.this.onPause();
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void b() {
                ATRewardVideoActivity.this.onResume();
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void c() {
                ATRewardVideoActivity.this.onResume();
            }
        };
        if (com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onStart();
            this.H.l(this.f11192q);
            com.anythink.expressad.foundation.f.b.a().a(this.f11192q + "_1", this.H);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStart();
            List<com.anythink.expressad.foundation.d.c> list = this.J;
            if (list != null && list.size() > 0) {
                com.anythink.expressad.foundation.d.c cVar = this.J.get(0);
                cVar.l(this.f11192q);
                com.anythink.expressad.foundation.f.b.a().a(this.f11192q + "_1", cVar);
            }
        }
        if (this.Q) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().b(this.f11192q + "_1", 1);
        com.anythink.expressad.foundation.f.b.a().c(this.f11192q + "_2");
        this.Q = true;
    }

    @Override // android.app.Activity
    protected void onStop() {
        com.anythink.expressad.a.f7980x = false;
        try {
            super.onStop();
        } catch (Throwable unused) {
        }
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.onStop();
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i.a(this, "anythink_transparent_theme", i.f10647e));
    }

    static /* synthetic */ int b(ATRewardVideoActivity aTRewardVideoActivity, int i2) {
        int i3 = aTRewardVideoActivity.S - i2;
        aTRewardVideoActivity.S = i3;
        return i3;
    }

    private void c() {
        p pVar;
        int iC = c("anythink_bt_container");
        if (iC < 0) {
            b("no anythink_webview_framelayout in anythink_more_offer_activity layout");
        }
        this.L = (AnythinkBTContainer) findViewById(iC);
        if (this.L == null) {
            b("env error");
        }
        this.L.setVisibility(0);
        this.N = d();
        this.L.setBTContainerCallback(this.N);
        this.L.setShowRewardVideoListener(this.C);
        this.L.setChoiceOneCallback(this.Z);
        this.L.setCampaigns(this.J);
        this.L.setCampaignDownLoadTasks(this.I);
        this.L.setRewardUnitSetting(this.D);
        this.L.setUnitId(this.f11192q);
        this.L.setPlacementId(this.f11193r);
        this.L.setUserId(this.f11194s);
        this.L.setActivity(this);
        this.L.setDeveloperExtraData(this.P);
        com.anythink.expressad.foundation.d.c cVar = this.H;
        if (((cVar != null && (pVar = cVar.aH) != null) || (this.J.get(0) != null && (pVar = this.J.get(0).aH) != null)) && !TextUtils.isEmpty(pVar.b()) && pVar.a() > 0) {
            com.anythink.expressad.videocommon.c.c cVar2 = new com.anythink.expressad.videocommon.c.c(pVar.b(), pVar.a());
            if (cVar2.b() < 0) {
                cVar2.a(1);
            }
            this.f11195t = cVar2;
        }
        this.L.setReward(this.f11195t);
        this.L.setIVRewardEnable(this.f11199x, this.f11200y, this.f11201z);
        this.L.setIV(this.f11197v);
        this.L.setMute(this.f11196u);
        this.L.setJSFactory((com.anythink.expressad.video.signal.factory.b) this.f11964o);
        this.L.init(this);
        this.L.onCreate();
    }

    private com.anythink.expressad.video.bt.module.a.a d() {
        if (this.N == null) {
            this.N = new com.anythink.expressad.video.bt.module.a.a() { // from class: com.anythink.expressad.reward.player.ATRewardVideoActivity.3
                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a();
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void b() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.b();
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void c() {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.c();
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(boolean z2, com.anythink.expressad.videocommon.c.c cVar) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(z2, cVar);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(boolean z2, int i2) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(z2, i2);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(String str) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(str);
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.a
                public final void a(com.anythink.expressad.foundation.d.c cVar) {
                    if (ATRewardVideoActivity.this.C != null) {
                        ATRewardVideoActivity.this.C.a(cVar);
                    }
                }
            };
        }
        return this.N;
    }

    private void e() {
        try {
            if (this.J != null && this.J.size() > 0) {
                Iterator<com.anythink.expressad.foundation.d.c> it = this.J.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
            if (this.H != null) {
                c(this.H);
            }
        } catch (Throwable th) {
            o.d(f11191p, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.d.c cVarN;
        try {
            if (this.I != null && this.I.size() > 0) {
                for (c cVar2 : this.I) {
                    if (cVar2 != null && (cVarN = cVar2.n()) != null && TextUtils.equals(cVarN.aZ(), cVar.aZ()) && TextUtils.equals(cVarN.Z(), cVar.Z())) {
                        this.G = cVar2;
                    }
                }
            }
            this.A = true;
            b();
            if (this.K != null) {
                this.K.setNotchPadding(this.X, this.T, this.V, this.U, this.W);
            }
        } catch (Exception e2) {
            o.d(f11191p, e2.getMessage());
            b("more offer to one offer exception");
        }
    }

    private int d(String str) {
        return i.a(getApplicationContext(), str, "layout");
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null) {
            b("no available campaign");
            return;
        }
        if (list.size() == 0) {
            b("no available campaign");
            return;
        }
        if ((list.get(0) != null ? list.get(0).k() : 0) != 5) {
            c();
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                this.S += cVar.bi();
            }
        }
        com.anythink.expressad.foundation.d.c cVar2 = list.get(0);
        if (cVar2 != null) {
            int iA = a(cVar2.i(), this.R);
            this.H = cVar2;
            this.H.m();
            this.R = 1;
            this.H.b(iA);
            b(this.H);
            return;
        }
        b("campaign is less");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        o.d(f11191p, str);
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(str);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<com.anythink.expressad.foundation.d.c> list;
        p pVar;
        List<com.anythink.expressad.foundation.d.c> list2;
        int iC = c("anythink_temp_container");
        if (iC < 0) {
            b("no id anythink_bt_container in anythink_more_offer_activity layout");
        }
        this.K = (ATTempContainer) findViewById(iC);
        if (this.K == null) {
            b("env error");
        }
        List<com.anythink.expressad.foundation.d.c> list3 = this.J;
        if (list3 != null && list3.size() > 0 && this.J.get(0).j()) {
            new b();
            b.e(this.K);
        } else {
            this.K.setVisibility(0);
        }
        a(-1);
        this.K.setVisibility(0);
        this.K.setActivity(this);
        this.K.setBidCampaign(this.f11198w);
        this.K.setBigOffer(this.A);
        this.K.setUnitId(this.f11192q);
        this.K.setCampaign(this.H);
        if (this.H.k() == 5 && (list2 = this.J) != null && list2.size() > 1) {
            View viewFindViewById = findViewById(c("anythink_reward_root_container"));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(-16777216);
            }
            this.K.removeAllViews();
            this.K.setCampOrderViewData(this.J, this.S);
            this.K.setCamPlayOrderCallback(this.Y, this.R);
        }
        this.K.setCampaignDownLoadTask(this.G);
        this.K.setIV(this.f11197v);
        com.anythink.expressad.foundation.d.c cVar = this.H;
        if (cVar != null && cVar.f() == 2) {
            this.K.setIVRewardEnable(0, 0, 0);
        } else {
            this.K.setIVRewardEnable(this.f11199x, this.f11200y, this.f11201z);
        }
        this.K.setMute(this.f11196u);
        this.K.setDeveloperExtraData(this.P);
        com.anythink.expressad.foundation.d.c cVar2 = this.H;
        if (((cVar2 != null && (pVar = cVar2.aH) != null) || ((list = this.J) != null && list.size() > 0 && this.J.get(0) != null && (pVar = this.J.get(0).aH) != null)) && !TextUtils.isEmpty(pVar.b()) && pVar.a() > 0) {
            com.anythink.expressad.videocommon.c.c cVar3 = new com.anythink.expressad.videocommon.c.c(pVar.b(), pVar.a());
            if (cVar3.b() < 0) {
                cVar3.a(1);
            }
            this.f11195t = cVar3;
        }
        this.K.setReward(this.f11195t);
        this.K.setRewardUnitSetting(this.D);
        this.K.setPlacementId(this.f11193r);
        this.K.setUserId(this.f11194s);
        this.K.setShowRewardListener(this.C);
        this.K.init(this);
        this.K.onCreate();
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            int iA = a(cVar.i(), this.R);
            this.H = cVar;
            this.H.m();
            this.R = 1;
            this.H.b(iA);
            b(this.H);
            return;
        }
        b("campaign is less");
    }

    private static WindVaneWebView a(String str) {
        a.C0226a c0226aA = com.anythink.expressad.videocommon.a.a(str);
        if (c0226aA != null) {
            return c0226aA.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2, int i3) {
        List<com.anythink.expressad.foundation.d.c> list = this.J;
        if (list == null || list.size() == 0) {
            return i2;
        }
        int iBi = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.J.size(); i5++) {
            if (this.J.get(0) != null) {
                if (i5 == 0) {
                    i4 = this.J.get(0).i();
                }
                iBi += this.J.get(i5).bi();
            }
        }
        if (i3 == 1) {
            if (i2 == 0) {
                if (iBi >= 45) {
                    return 45;
                }
            } else if (iBi > i2) {
                if (i2 > 45) {
                    return 45;
                }
                return i2;
            }
            return iBi;
        }
        int iBi2 = 0;
        for (int i6 = 0; i6 < i3 - 1; i6++) {
            if (this.J.get(i6) != null) {
                iBi2 += this.J.get(i6).bi();
            }
        }
        if (i4 > iBi2) {
            return i4 - iBi2;
        }
        return 0;
    }

    private int c(String str) {
        return i.a(getApplicationContext(), str, "id");
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).c(cVar.be());
            }
            if (TextUtils.isEmpty(cVar.bd())) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).c(cVar.bd());
        }
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        this.T = i3;
        this.V = i4;
        this.U = i5;
        this.W = i6;
        this.X = i2;
        ATTempContainer aTTempContainer = this.K;
        if (aTTempContainer != null) {
            aTTempContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        AnythinkBTContainer anythinkBTContainer = this.L;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.anythink.expressad.video.dynview.a.b.f11596e = i2;
        com.anythink.expressad.video.dynview.a.b.a = i3;
        com.anythink.expressad.video.dynview.a.b.b = i4;
        com.anythink.expressad.video.dynview.a.b.f11594c = i5;
        com.anythink.expressad.video.dynview.a.b.f11595d = i6;
    }

    private void a(int i2) {
        try {
            if (this.H == null || this.H.f() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K.getLayoutParams();
            int iB = t.b(this, 58.0f);
            int iB2 = t.b(this, 104.0f);
            if (this.H.M().c() == 0) {
                if (i2 == 2) {
                    layoutParams.setMargins(iB2, iB, iB2, iB);
                } else {
                    layoutParams.setMargins(iB, iB2, iB, iB2);
                }
            } else if (this.H.M().c() == 2) {
                layoutParams.setMargins(iB2, iB, iB2, iB);
            } else {
                layoutParams.setMargins(iB, iB2, iB, iB2);
            }
            this.K.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.d(f11191p, th.getMessage());
        }
    }
}
