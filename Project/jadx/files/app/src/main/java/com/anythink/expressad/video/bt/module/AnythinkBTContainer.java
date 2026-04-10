package com.anythink.expressad.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.out.j;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.dynview.f.d;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.b;
import com.anythink.expressad.video.signal.container.AbstractJSContainer;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBTContainer extends AbstractJSContainer implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11492d = AnythinkBTContainer.class.getSimpleName();
    private Context A;
    private TextView B;
    private boolean C;
    private boolean D;
    private String E;
    private boolean F;
    private List<c> G;
    private List<com.anythink.expressad.videocommon.b.c> H;
    private com.anythink.expressad.video.bt.module.a.a I;
    private h J;
    private h K;
    private com.anythink.expressad.video.bt.module.a.b L;
    private String M;
    private String N;
    private boolean O;
    private int P;
    private boolean Q;
    private int R;
    private String S;
    private d T;
    c a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f11495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AnythinkBTLayout f11496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WindVaneWebView f11497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LayoutInflater f11498j;

    private class a extends c.a {
        private a() {
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            super.a(cVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void b() {
            super.b();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
        }

        /* synthetic */ a(AnythinkBTContainer anythinkBTContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(j jVar, String str) {
            super.a(jVar, str);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                String strOptString = new JSONObject(AnythinkBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                if (cVar.Q() == 3 && cVar.C() == 2 && strOptString.equals("1.0") && ((AbstractJSContainer) AnythinkBTContainer.this).f12077l != null) {
                    if (AnythinkBTContainer.this.D) {
                        AnythinkBTContainer.this.onAdClose();
                    } else {
                        ((AbstractJSContainer) AnythinkBTContainer.this).f12077l.finish();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(j jVar, String str) {
            super.b(jVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
            super.a(cVar, z2);
            AnythinkBTContainer.this.K.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i2, String str) {
            super.a(i2, str);
        }
    }

    public AnythinkBTContainer(Context context) {
        super(context);
        this.f11493e = 0;
        this.f11494f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    private static void d() {
    }

    private static boolean e() {
        return true;
    }

    private static int f() {
        return 1;
    }

    public void appendSubView(AnythinkBTContainer anythinkBTContainer, ATTempContainer aTTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context contextG = n.a().g();
                int iOptInt = jSONObject.optInt("left", com.anythink.expressad.video.bt.a.c.a);
                int iOptInt2 = jSONObject.optInt("top", com.anythink.expressad.video.bt.a.c.a);
                int iOptInt3 = jSONObject.optInt("right", com.anythink.expressad.video.bt.a.c.a);
                int iOptInt4 = jSONObject.optInt("bottom", com.anythink.expressad.video.bt.a.c.a);
                if (iOptInt != -999 && contextG != null) {
                    layoutParams.leftMargin = t.b(contextG, iOptInt);
                }
                if (iOptInt2 != -999 && contextG != null) {
                    layoutParams.topMargin = t.b(contextG, iOptInt2);
                }
                if (iOptInt3 != -999 && contextG != null) {
                    layoutParams.rightMargin = t.b(contextG, iOptInt3);
                }
                if (iOptInt4 != -999 && contextG != null) {
                    layoutParams.bottomMargin = t.b(contextG, iOptInt4);
                }
                int iOptInt5 = jSONObject.optInt("width");
                int iOptInt6 = jSONObject.optInt("height");
                if (iOptInt5 > 0) {
                    layoutParams.width = iOptInt5;
                }
                if (iOptInt6 > 0) {
                    layoutParams.height = iOptInt6;
                }
            }
            anythinkBTContainer.addView(aTTempContainer, layoutParams);
            aTTempContainer.setActivity(this.f12077l);
            aTTempContainer.setMute(this.f12084s);
            aTTempContainer.setBidCampaign(this.C);
            aTTempContainer.setIV(this.f12085t);
            aTTempContainer.setBigOffer(this.D);
            aTTempContainer.setIVRewardEnable(this.f12087v, this.f12088w, this.f12089x);
            aTTempContainer.setShowRewardListener(this.K);
            aTTempContainer.setCampaignDownLoadTask(d(aTTempContainer.getCampaign()));
            aTTempContainer.setAnythinkTempCallback(c());
            aTTempContainer.setH5Cbp(getJSCommon().e());
            aTTempContainer.setWebViewFront(getJSCommon().f());
            aTTempContainer.init(this.A);
            aTTempContainer.onCreate();
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f11497i != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.f11493e);
                jSONObject2.put("id", this.E);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11497i, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.f11497i, "broadcast", this.E);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i2, String str) {
    }

    public int findID(String str) {
        return i.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return i.a(getContext(), str, "layout");
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i2, String str) {
    }

    public void init(Context context) {
        this.A = context;
        this.f11498j = LayoutInflater.from(context);
    }

    public boolean isNativeKilledCallback(com.anythink.expressad.foundation.d.c cVar) {
        if (getJSCommon().e() != 1 && cVar != null) {
            if (cVar.n() == 1) {
                com.anythink.expressad.videocommon.e.d dVar = this.f12080o;
                if (dVar != null) {
                    if (dVar.M() == 1) {
                        cVar.m(1);
                        return true;
                    }
                    cVar.m(0);
                    return false;
                }
            } else {
                if (cVar.A()) {
                    cVar.m(0);
                    return false;
                }
                int iA = this.f12080o.a();
                cVar.m(iA);
                if (iA == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onAdClose() {
        Activity activity = this.f12077l;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onBackPressed();
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onBackPressed();
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onCreate() {
        String strAr;
        WindVaneWebView windVaneWebViewA;
        com.anythink.expressad.foundation.d.c cVar;
        RelativeLayout.LayoutParams layoutParams;
        try {
            int iFindLayout = findLayout("anythink_bt_container");
            if (iFindLayout < 0) {
                a("anythink_bt_container layout null");
                return;
            }
            this.f11495g = (FrameLayout) this.f11498j.inflate(iFindLayout, this);
            if (this.f11495g == null) {
                a("ViewIds null");
                return;
            }
            this.N = "";
            byte b = 0;
            if (this.G == null || this.G.size() <= 0) {
                strAr = "";
            } else {
                com.anythink.expressad.foundation.d.c cVar2 = this.G.get(0);
                strAr = cVar2.ar();
                this.N = cVar2.Z();
            }
            a.C0226a c0226aA = com.anythink.expressad.videocommon.a.a(this.f12078m + "_" + this.N + "_" + strAr);
            if (c0226aA != null) {
                this.E = c0226aA.b();
                o.a(f11492d, "get BT wraper.getTag = " + this.E);
                c0226aA.a("");
                windVaneWebViewA = c0226aA.a();
            } else {
                windVaneWebViewA = null;
            }
            this.f11497i = windVaneWebViewA;
            com.anythink.expressad.videocommon.a.b(this.f12078m + "_" + this.N + "_" + strAr);
            if (this.f11497i == null) {
                if (this.G == null || this.G.size() <= 0 || (cVar = this.G.get(0)) == null || !cVar.j()) {
                    a("big template webview is null");
                    return;
                }
                Context context = this.A;
                if (this.T == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                HashMap map = new HashMap();
                map.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(context, this.G, new AnonymousClass2(), map);
                return;
            }
            com.anythink.expressad.video.signal.factory.b bVar = new com.anythink.expressad.video.signal.factory.b(this.f12077l, this, this.f11497i);
            registerJsFactory(bVar);
            this.f11497i.setApiManagerJSFactory(bVar);
            if (this.f11497i.getParent() != null) {
                a("preload template webview is null or load error");
                return;
            }
            if (this.f11497i.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                bVar.a((com.anythink.expressad.video.signal.a.j) this.f11497i.getObject());
                if (this.f11497i != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(getContext()));
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.f12082q.a());
                        jSONObject2.put("amount", this.f12082q.b());
                        jSONObject2.put("id", this.f12083r);
                        jSONObject.put("userId", this.f12081p);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.f12084s);
                        jSONObject.put("extra", this.S);
                    } catch (JSONException e2) {
                        o.a(f11492d, e2.getMessage());
                    } catch (Exception e3) {
                        o.a(f11492d, e3.getMessage());
                    }
                    this.K = new com.anythink.expressad.video.bt.module.b.d(c(), "");
                    getJSNotifyProxy().a(jSONObject.toString());
                    getJSCommon().h();
                    getJSCommon().a(new a(this, b));
                }
                ((com.anythink.expressad.video.signal.a.c) getJSCommon()).f11928r.b();
            }
            this.f11497i.setBackgroundColor(0);
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || !linkedHashMapB.containsKey(this.E)) {
                a("big template webviewLayout is null");
                return;
            }
            View view = linkedHashMapB.get(this.E);
            if (view instanceof AnythinkBTLayout) {
                this.f11496h = (AnythinkBTLayout) view;
                this.f11496h.addView(this.f11497i, 0, new FrameLayout.LayoutParams(-1, -1));
                com.anythink.expressad.foundation.f.b.a().a(this.f12078m + "_1", new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTContainer.1
                    @Override // com.anythink.expressad.foundation.f.a
                    public final void a() {
                        String string;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 1);
                            }
                            string = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.f11492d, th.getMessage(), th);
                            string = "";
                        }
                        String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, AbsFeedBackForH5.a, strEncodeToString);
                    }

                    @Override // com.anythink.expressad.foundation.f.a
                    public final void b() {
                        String string;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 2);
                            }
                            string = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.f11492d, th.getMessage(), th);
                            string = "";
                        }
                        String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, AbsFeedBackForH5.a, strEncodeToString);
                    }

                    @Override // com.anythink.expressad.foundation.f.a
                    public final void c() {
                        String string;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 2);
                            }
                            string = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.f11492d, th.getMessage(), th);
                            string = "";
                        }
                        String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, AbsFeedBackForH5.a, strEncodeToString);
                    }
                });
                com.anythink.expressad.foundation.f.b.a().c(this.f12078m + "_2");
                FeedBackButton feedBackButtonB = com.anythink.expressad.foundation.f.b.a().b(this.f12078m + "_1");
                if (com.anythink.expressad.foundation.f.b.a().b() && feedBackButtonB != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                    }
                    layoutParams.topMargin = t.b(n.a().g(), 10.0f);
                    layoutParams.leftMargin = t.b(n.a().g(), 10.0f);
                    feedBackButtonB.setLayoutParams(layoutParams);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonB);
                    }
                    this.f11496h.addView(feedBackButtonB);
                }
                this.f11496h.setTag(this.E);
                linkedHashMapB.put(this.E, this.f11496h);
                Iterator<View> it = linkedHashMapB.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof AnythinkBTRootLayout) {
                        AnythinkBTRootLayout anythinkBTRootLayout = (AnythinkBTRootLayout) next;
                        this.M = anythinkBTRootLayout.getInstanceId();
                        this.f11495g.addView(anythinkBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                linkedHashMapB.remove(this.M);
                linkedHashMapB.put(this.M, this);
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.f12078m, this.f12084s);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.E, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.M, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.f12078m + "_" + this.N, this.f12077l);
            if (this.G == null || this.G.size() <= 0) {
                return;
            }
            a(this.f12080o, this.G.get(0));
        } catch (Throwable th) {
            a("onCreate exception ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.F) {
            return;
        }
        this.F = true;
        super.onDestroy();
        com.anythink.expressad.video.bt.a.c.a();
        com.anythink.expressad.video.bt.a.c.d(this.f12078m + "_" + this.N);
        try {
            if (this.f11497i != null) {
                ViewGroup viewGroup = (ViewGroup) this.f11497i.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f11497i.clearWebView();
                this.f11497i.release();
            }
            if (this.L != null) {
                this.L = null;
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.G != null && this.G.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar : this.G) {
                    if (cVar != null && cVar.M() != null) {
                        com.anythink.expressad.videocommon.a.b(this.f12078m + "_" + cVar.Z() + "_" + cVar.M().e());
                    }
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.E);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.g(this.f12078m);
            com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N).remove(this.E);
            com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N).remove(this.M);
            com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N).clear();
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        com.anythink.expressad.foundation.d.c cVar;
        super.onPause();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j()) {
            com.anythink.expressad.video.dynview.b.a.a();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        com.anythink.expressad.foundation.d.c cVar;
        com.anythink.expressad.video.dynview.e.a aVar;
        super.onResume();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j() && (aVar = com.anythink.expressad.video.dynview.b.a.a().a) != null) {
            aVar.a();
        }
        if (com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        com.anythink.expressad.foundation.d.c cVar;
        com.anythink.expressad.video.dynview.e.a aVar;
        super.onStop();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j() && (aVar = com.anythink.expressad.video.dynview.b.a.a().a) != null) {
            aVar.c();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.b
    public void reactDeveloper(Object obj, String str) {
        if (this.I == null || TextUtils.isEmpty(str)) {
            AbstractJSContainer.a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("hit");
            String strOptString = jSONObject.optString("unitId", getUnitId());
            jSONObject.optString(com.anythink.expressad.a.f7981y, getPlacementId());
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.anythink.expressad.foundation.d.c cVar = this.G.get(0);
            boolean z2 = true;
            if (iOptInt == 1) {
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
                if (cVar != null) {
                    if (zOptBoolean) {
                        cVar.e(1);
                    } else {
                        cVar.e(0);
                    }
                }
                this.O = isNativeKilledCallback(cVar);
            }
            switch (iOptInt) {
                case 1:
                    this.I.a();
                    break;
                case 2:
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("error");
                    String strOptString2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("msg") : "";
                    if (TextUtils.isEmpty(strOptString2)) {
                        strOptString2 = jSONObjectOptJSONObject.optString("error");
                    }
                    if (!this.O && iOptInt2 != this.P) {
                        this.I.a(strOptString2);
                    }
                    break;
                case 3:
                    this.I.b();
                    break;
                case 4:
                    this.I.c();
                    break;
                case 5:
                    com.anythink.expressad.video.bt.module.a.a aVar = this.I;
                    if (this.a != null) {
                        cVar = this.a;
                    }
                    aVar.a(cVar);
                    break;
                case 6:
                    if (jSONObjectOptJSONObject.optInt("convert") != 1) {
                        z2 = false;
                    }
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("reward");
                    com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectOptJSONObject.optJSONObject("campaign"));
                    com.anythink.expressad.videocommon.c.c cVarA = com.anythink.expressad.videocommon.c.c.a(jSONObjectOptJSONObject3);
                    if (cVarA == null) {
                        cVarA = this.f12082q;
                    }
                    String strOptString3 = jSONObjectOptJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(strOptString3)) {
                        this.S = strOptString3;
                    }
                    if (!this.O && iOptInt2 != this.P) {
                        if (this.f12085t && (this.f12087v == com.anythink.expressad.foundation.g.a.cr || this.f12087v == com.anythink.expressad.foundation.g.a.cs)) {
                            this.I.a(this.Q, this.R);
                        }
                        if (!z2) {
                            cVarA.a(0);
                        }
                        this.I.a(z2, cVarA);
                        o.a(f11492d, "sendToServerRewardInfo");
                        if (!this.f12085t && z2) {
                            if (cVarB == null) {
                                com.anythink.expressad.video.module.b.a.a(cVar, cVarA, strOptString, this.f12081p, this.S);
                            } else {
                                com.anythink.expressad.video.module.b.a.a(cVarB, cVarA, strOptString, this.f12081p, this.S);
                            }
                        }
                    }
                    break;
            }
            a(obj);
        } catch (JSONException e2) {
            AbstractJSContainer.a(obj, e2.getMessage());
            o.a(f11492d, e2.getMessage());
        }
    }

    public void setBTContainerCallback(com.anythink.expressad.video.bt.module.a.a aVar) {
        this.I = aVar;
    }

    public void setCampaignDownLoadTasks(List<com.anythink.expressad.videocommon.b.c> list) {
        this.H = list;
    }

    public void setCampaigns(List<com.anythink.expressad.foundation.d.c> list) {
        this.G = list;
    }

    public void setChoiceOneCallback(d dVar) {
        this.T = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.S = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.f12091z = bVar;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        try {
            String strA = com.anythink.expressad.foundation.h.h.a(i2, i3, i4, i5, i6);
            o.d(f11492d, strA);
            if (this.f11497i != null && (this.f11497i.getObject() instanceof com.anythink.expressad.video.signal.a.j) && !TextUtils.isEmpty(strA)) {
                ((com.anythink.expressad.video.signal.a.j) this.f11497i.getObject()).b(strA);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11497i, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
            }
            if (this.G != null && this.G.size() > 0) {
                try {
                    if (this.G.get(0).j() && this.B != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.B.getLayoutParams();
                        layoutParams.setMargins(i3, i5, i4, i6);
                        this.B.setLayoutParams(layoutParams);
                    }
                } catch (Exception e2) {
                    o.d(f11492d, e2.getMessage());
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(i2, i3, i4, i5, i6);
            LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(this.f12078m, this.N);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).setNotchPadding(i3, i4, i5, i6);
                }
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).setNotchPadding(i2, i3, i4, i5, i6);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(strA)) {
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(view, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
                }
            }
        } catch (Throwable th) {
            o.a(f11492d, th.getMessage());
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.J = hVar;
    }

    private WindVaneWebView b(String str) {
        a.C0226a c0226aA = com.anythink.expressad.videocommon.a.a(str);
        if (c0226aA == null) {
            return null;
        }
        this.E = c0226aA.b();
        o.a(f11492d, "get BT wraper.getTag = " + this.E);
        c0226aA.a("");
        return c0226aA.a();
    }

    private com.anythink.expressad.video.bt.module.a.b c() {
        if (this.L == null) {
            this.L = new com.anythink.expressad.video.bt.module.a.b() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTContainer.3
                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a() {
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str) {
                    if (AnythinkBTContainer.this.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.f7981y, ((AbstractJSContainer) AnythinkBTContainer.this).f12079n);
                            jSONObject2.put("unitId", ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void b(String str) {
                    if (AnythinkBTContainer.this.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(com.anythink.expressad.a.f7981y, ((AbstractJSContainer) AnythinkBTContainer.this).f12079n);
                            jSONObject2.put("unitId", ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void c(String str) {
                    if (AnythinkBTContainer.this.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.f7981y, ((AbstractJSContainer) AnythinkBTContainer.this).f12079n);
                            jSONObject2.put("unitId", ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, boolean z2, com.anythink.expressad.videocommon.c.c cVar) {
                    if (AnythinkBTContainer.this.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put("amount", cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z2);
                            jSONObject2.put("convert", z2 ? 1 : 2);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(boolean z2, int i2) {
                    AnythinkBTContainer.this.Q = z2;
                    AnythinkBTContainer.this.R = i2;
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, String str2) {
                    if (AnythinkBTContainer.this.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.f7981y, ((AbstractJSContainer) AnythinkBTContainer.this).f12079n);
                            jSONObject2.put("unitId", ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
                            jSONObject2.put("error", str2);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, com.anythink.expressad.foundation.d.c cVar) {
                    AnythinkBTContainer anythinkBTContainer = AnythinkBTContainer.this;
                    anythinkBTContainer.a = cVar;
                    if (anythinkBTContainer.f11497i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.f7981y, ((AbstractJSContainer) AnythinkBTContainer.this).f12079n);
                            jSONObject2.put("unitId", ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
                            jSONObject.put("data", jSONObject2);
                            o.a(AnythinkBTContainer.f11492d, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(AnythinkBTContainer.f11492d, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.f11497i, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            };
        }
        return this.L;
    }

    private com.anythink.expressad.videocommon.b.c d(com.anythink.expressad.foundation.d.c cVar) {
        List<com.anythink.expressad.videocommon.b.c> list = this.H;
        if (list == null || cVar == null) {
            return null;
        }
        for (com.anythink.expressad.videocommon.b.c cVar2 : list) {
            if (cVar2.n().aZ().equals(cVar.aZ())) {
                o.a(f11492d, "tempContainer task initSuccess");
                return cVar2;
            }
        }
        return null;
    }

    private boolean g() {
        try {
            if (this.f12080o == null) {
                return false;
            }
            double dL = this.f12080o.L();
            if (dL == 1.0d) {
                return false;
            }
            return new Random().nextDouble() > dL;
        } catch (Throwable th) {
            o.b(f11492d, "", th);
            return false;
        }
    }

    private void a(Context context) {
        if (this.T == null) {
            a("ChoiceOneCallback is null");
            return;
        }
        HashMap map = new HashMap();
        map.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(context, this.G, new AnonymousClass2(), map);
    }

    public AnythinkBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11493e = 0;
        this.f11494f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    protected final void a(String str) {
        h hVar = this.J;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    protected final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                List<String> listE = cVar.e();
                if (listE == null || listE.size() <= 0) {
                    return;
                }
                Iterator<String> it = listE.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.a.a.a(n.a().g(), cVar, this.f12078m, it.next(), true);
                }
            } catch (Throwable th) {
                o.d(f11492d, th.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.module.AnythinkBTContainer$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.expressad.video.dynview.f.h {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            com.anythink.expressad.foundation.d.c cVar;
            String str;
            if (AnythinkBTContainer.this.f11495g == null || aVar.a() == null) {
                AnythinkBTContainer.this.a("nativeview is null");
                return;
            }
            AnythinkBTContainer.this.f11495g.removeAllViews();
            AnythinkBTContainer.this.f11495g.addView(aVar.a());
            AnythinkBTContainer anythinkBTContainer = AnythinkBTContainer.this;
            anythinkBTContainer.B = (TextView) anythinkBTContainer.findViewById(anythinkBTContainer.findID("anythink_choice_one_countdown_tv"));
            if (AnythinkBTContainer.this.I != null) {
                AnythinkBTContainer.this.I.a();
            }
            if (AnythinkBTContainer.this.G == null || AnythinkBTContainer.this.G.size() <= 0 || (cVar = (com.anythink.expressad.foundation.d.c) AnythinkBTContainer.this.G.get(0)) == null) {
                return;
            }
            String strAi = cVar.ai();
            com.anythink.expressad.videocommon.e.d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), ((AbstractJSContainer) AnythinkBTContainer.this).f12078m);
            int iM = dVarA != null ? dVarA.M() : 1;
            if (cVar.n() == 1) {
                str = strAi + "&to=1&cbt=" + cVar.az() + "&tmorl=" + iM;
            } else {
                str = strAi + "&to=0&cbt=" + cVar.az() + "&tmorl=" + iM;
            }
            com.anythink.expressad.a.a.a(n.a().g(), cVar, ((AbstractJSContainer) AnythinkBTContainer.this).f12078m, str, false, true, com.anythink.expressad.a.a.a.f8007j);
            f.f10442h.put(cVar.ai(), Long.valueOf(System.currentTimeMillis()));
            AnythinkBTContainer.this.a(cVar);
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            String str;
            if (bVar != null) {
                str = "errorCode:" + bVar.a() + "Msg:" + bVar.b();
            } else {
                str = "";
            }
            AnythinkBTContainer.this.a("nativeview is null".concat(String.valueOf(str)));
        }
    }

    private boolean a(boolean z2) {
        try {
        } catch (Throwable th) {
            o.b(f11492d, "", th);
        }
        if (this.f12080o == null) {
            return false;
        }
        int iK = this.f12080o.K();
        if (iK == 1) {
            return z2;
        }
        if (iK == 2) {
            return z2 && g();
        }
        if (iK != 3) {
            return false;
        }
        return g();
    }
}
