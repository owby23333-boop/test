package com.anythink.expressad.reward.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.m;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.videocommon.b.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private static final int A = 9;
    private static final int E = 16;
    private static final int F = 18;
    private static final int G = 17;
    private static final int H = 1001001;
    private static final int I = 1001002;
    public static final int a = 1;
    public static String b = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f11140i = "RewardVideoController";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f11141j = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f11142z = 8;
    private int B;
    private int C;
    private int D;
    private boolean N;
    private Queue<Integer> V;
    private String W;
    private List<com.anythink.expressad.foundation.d.c> af;
    private List<com.anythink.expressad.foundation.d.c> ag;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f11148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.anythink.expressad.reward.a.d f11150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.anythink.expressad.videocommon.e.d f11151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.anythink.expressad.videocommon.e.a f11152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile com.anythink.expressad.videocommon.d.a f11153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile c f11154q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f11155r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f11156s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile String f11157t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f11158u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f11159v;
    private static Map<String, Integer> T = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, d> f11139c = new HashMap();
    private static ConcurrentHashMap<String, String> U = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11160w = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11162y = 2;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean O = false;
    private ArrayList<Integer> P = new ArrayList<>(7);
    private boolean Q = false;
    private volatile boolean R = false;
    private final Object S = new Object();
    private com.anythink.expressad.foundation.c.c X = null;
    private volatile boolean Y = true;
    private volatile boolean Z = false;
    private volatile boolean aa = false;
    private volatile boolean ab = false;
    private volatile boolean ac = false;
    private volatile boolean ad = false;
    private volatile boolean ae = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f11143d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f11144e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f11145f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f11146g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f11147h = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Handler f11161x = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.reward.b.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 8) {
                if (a.this.af == null || a.this.af.size() <= 0) {
                    return;
                }
                boolean z2 = (a.this.ag == null || a.this.ag.size() <= 0) ? false : !TextUtils.isEmpty(((com.anythink.expressad.foundation.d.c) a.this.ag.get(0)).ar());
                int iAp = ((com.anythink.expressad.foundation.d.c) a.this.af.get(0)).ap();
                if (a.this.f11150m != null && a.this.f11150m.a(a.this.af, z2, iAp)) {
                    if (a.this.f11154q == null || !a.this.N) {
                        return;
                    }
                    c.a(a.this.f11154q, a.this.f11157t, a.this.f11156s);
                    return;
                }
                if (a.this.f11154q == null || !a.this.N) {
                    return;
                }
                com.anythink.expressad.videocommon.a.c(a.this.f11156s);
                com.anythink.expressad.videocommon.a.b();
                c.a(a.this.f11154q, "load timeout");
                return;
            }
            if (i2 == 9) {
                if (a.this.f11153p == null || !a.this.N) {
                    return;
                }
                Object obj = message.obj;
                Bundle data = message.getData();
                if (data != null && data.containsKey(com.anythink.expressad.a.f7981y)) {
                    TextUtils.isEmpty(data.getString(com.anythink.expressad.a.f7981y));
                }
                try {
                    if (a.this.K) {
                        a.b();
                    }
                    a.this.f11153p.b();
                    return;
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (i2 != a.I) {
                switch (i2) {
                    case 16:
                    case 18:
                        if (a.this.f11153p != null && a.this.N) {
                            Object obj2 = message.obj;
                            String string = obj2 instanceof String ? obj2.toString() : "";
                            com.anythink.expressad.videocommon.a.c(a.this.f11156s);
                            com.anythink.expressad.videocommon.a.b();
                            try {
                                if (a.this.K) {
                                    a.b();
                                }
                                a.this.f11153p.a(string);
                            } catch (Exception e3) {
                                if (com.anythink.expressad.a.a) {
                                    e3.printStackTrace();
                                    return;
                                }
                                return;
                            }
                            break;
                        }
                        break;
                    case 17:
                        if (a.this.f11153p != null && a.this.N) {
                            Object obj3 = message.obj;
                            Bundle data2 = message.getData();
                            if (data2 != null && data2.containsKey(com.anythink.expressad.a.f7981y)) {
                                TextUtils.isEmpty(data2.getString(com.anythink.expressad.a.f7981y));
                            }
                            try {
                                if (a.this.K) {
                                    a.b();
                                }
                                a.this.f11153p.a();
                            } catch (Exception e4) {
                                if (com.anythink.expressad.a.a) {
                                    e4.printStackTrace();
                                    return;
                                }
                                return;
                            }
                            break;
                        }
                        break;
                }
                return;
            }
            int iS = a.this.f11151n != null ? a.this.f11151n.S() : 0;
            if (a.this.f11150m == null) {
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadFail by mRewardMvVideoAdapter is null exception");
                    return;
                }
                return;
            }
            if (a.this.f11150m.c()) {
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadSuccess by isReady exception");
                    try {
                        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayListF = a.this.f11150m.f();
                        if (copyOnWriteArrayListF != null) {
                            copyOnWriteArrayListF.size();
                        }
                    } catch (Throwable th) {
                        o.d(a.f11140i, th.getMessage());
                    }
                    c.b(a.this.f11154q, a.this.f11157t, a.this.f11156s);
                    return;
                }
                return;
            }
            if (!a.this.f11150m.f(false)) {
                if (!a.this.f11150m.f(true)) {
                    if (a.this.f11154q != null) {
                        o.a(a.f11140i, "load timeout task called for onVideoLoadFail after " + iS + " s");
                        return;
                    }
                    return;
                }
                if (!a.this.f11150m.c()) {
                    if (a.this.f11154q != null) {
                        o.a(a.f11140i, "load timeout task called for onVideoLoadFail after " + iS + " s");
                    }
                    a.this.f11150m.e(true);
                    return;
                }
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState");
                    a.this.f11150m.d(true);
                    try {
                        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayListF2 = a.this.f11150m.f();
                        if (copyOnWriteArrayListF2 != null) {
                            copyOnWriteArrayListF2.size();
                        }
                    } catch (Throwable th2) {
                        o.d(a.f11140i, th2.getMessage());
                    }
                    c.b(a.this.f11154q, a.this.f11157t, a.this.f11156s);
                    return;
                }
                return;
            }
            if (a.this.f11150m.c()) {
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                    a.this.f11150m.d(false);
                    try {
                        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayListF3 = a.this.f11150m.f();
                        if (copyOnWriteArrayListF3 != null) {
                            copyOnWriteArrayListF3.size();
                        }
                    } catch (Throwable th3) {
                        o.d(a.f11140i, th3.getMessage());
                    }
                    c.b(a.this.f11154q, a.this.f11157t, a.this.f11156s);
                    return;
                }
                return;
            }
            a.this.f11150m.e(false);
            if (!a.this.f11150m.f(true)) {
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadFail after " + iS + "s exception");
                    return;
                }
                return;
            }
            if (!a.this.f11150m.c()) {
                if (a.this.f11154q != null) {
                    o.a(a.f11140i, "load timeout task called for onVideoLoadFail after " + iS + "s exception");
                }
                a.this.f11150m.e(true);
                return;
            }
            if (a.this.f11154q != null) {
                o.a(a.f11140i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                a.this.f11150m.d(true);
                try {
                    CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayListF4 = a.this.f11150m.f();
                    if (copyOnWriteArrayListF4 != null) {
                        copyOnWriteArrayListF4.size();
                    }
                } catch (Throwable th4) {
                    o.d(a.f11140i, th4.getMessage());
                }
                c.b(a.this.f11154q, a.this.f11157t, a.this.f11156s);
            }
        }
    };

    /* JADX INFO: renamed from: com.anythink.expressad.reward.b.a$a, reason: collision with other inner class name */
    public class RunnableC0217a implements Runnable {
        private com.anythink.expressad.reward.a.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11163c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11164d = true;

        public RunnableC0217a(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.d(a.f11140i, "adSource=" + this.f11163c + " CommonCancelTimeTask mIsDevCall：" + this.f11164d);
            a.this.b("v3 is timeout");
        }
    }

    public class b implements com.anythink.expressad.reward.a.b {
        private com.anythink.expressad.reward.a.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11165c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f11166d;

        public b(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        private Runnable c() {
            return this.f11166d;
        }

        public final void a(Runnable runnable) {
            this.f11166d = runnable;
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void b() {
            if (this.f11166d != null) {
                a.this.f11161x.removeCallbacks(this.f11166d);
            }
            if (a.this.f11154q != null) {
                c.c(a.this.f11154q, a.this.f11157t, a.this.f11156s);
            }
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a() {
            if (this.f11166d != null) {
                a.this.f11161x.removeCallbacks(this.f11166d);
            }
            if (a.this.f11154q != null) {
                c.a(a.this.f11154q, a.this.f11157t, a.this.f11156s);
            }
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a(String str) {
            if (this.f11166d != null) {
                a.this.f11161x.removeCallbacks(this.f11166d);
            }
            com.anythink.expressad.reward.a.a aVar = this.b;
            if (aVar != null) {
                aVar.a(null);
                this.b = null;
            }
            if (a.this.f11154q != null) {
                c.a(a.this.f11154q, str);
            }
        }
    }

    private final class c {
        private static final String b = "RewardVideoController_Listener";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f11167d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f11168e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f11169f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f11170g = 3;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<com.anythink.expressad.videocommon.d.a> f11171c;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile AtomicInteger f11172h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Handler f11173i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f11174j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<com.anythink.expressad.foundation.d.c> f11175k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f11176l;

        /* synthetic */ c(a aVar, com.anythink.expressad.videocommon.d.a aVar2, Handler handler, String str, byte b2) {
            this(aVar2, handler, str);
        }

        private int a() {
            return this.f11172h.get();
        }

        private void b(String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null || this.f11173i == null) {
                return;
            }
            if (a.this.aa) {
                o.a(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
                return;
            }
            o.d(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
            a.o(a.this);
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(com.anythink.expressad.a.f7981y, str);
            bundle.putString("unit_id", str2);
            messageObtain.setData(bundle);
            messageObtain.obj = str2;
            messageObtain.what = 17;
            this.f11173i.sendMessage(messageObtain);
        }

        private void d(String str, String str2) {
            Handler handler = this.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.f11172h.get() == 1 || this.f11172h.get() == 3) && this.f11173i != null) {
                if (this.f11172h.get() == 1) {
                    this.f11172h.set(3);
                }
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.f7981y, str);
                bundle.putString("unit_id", str2);
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f11173i.sendMessage(messageObtain);
                if (a.this.ac) {
                    this.f11172h.set(2);
                }
            }
        }

        private void e(String str) {
            com.anythink.expressad.videocommon.d.a aVar;
            a.l(a.this);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.b(str);
        }

        private c(com.anythink.expressad.videocommon.d.a aVar, Handler handler, String str) {
            this.f11171c = new WeakReference<>(aVar);
            this.f11172h = new AtomicInteger(0);
            this.f11173i = handler;
            this.f11174j = str;
        }

        private void a(int i2) {
            this.f11172h.set(i2);
        }

        private void c(String str, String str2) {
            Handler handler = this.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.f11172h.get() == 1 || this.f11172h.get() == 3) && this.f11173i != null) {
                this.f11172h.set(2);
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.f7981y, str);
                bundle.putString("unit_id", str2);
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f11173i.sendMessage(messageObtain);
            }
        }

        private void a(String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.f11172h.get() == 1 || this.f11172h.get() == 3) && this.f11173i != null) {
                if (!a.this.aa) {
                    o.d(b, "收到 onCampaignLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
                    a.o(a.this);
                    Message messageObtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(com.anythink.expressad.a.f7981y, str);
                    bundle.putString("unit_id", str2);
                    messageObtain.setData(bundle);
                    messageObtain.obj = str2;
                    messageObtain.what = 17;
                    this.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + this.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
            }
        }

        private void b(String str) {
            this.f11172h.set(2);
            if (this.f11173i != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                this.f11173i.sendMessage(messageObtain);
            }
        }

        private void a(String str) {
            Handler handler = this.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadFail，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.f11172h.get() == 1 || this.f11172h.get() == 3) && this.f11173i != null) {
                a.s(a.this);
                if (!a.this.ae || str.contains("resource load timeout")) {
                    a.u(a.this);
                }
                if (a.this.ab) {
                    this.f11172h.set(2);
                }
                if (a.this.ac && a.this.ad && !a.this.ab) {
                    this.f11172h.set(2);
                    o.d(b, "收到 onVideoLoadFail，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 响应");
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = str;
                    messageObtain.what = 16;
                    this.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onVideoLoadFail，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 无需响应");
            }
        }

        private void c(String str) {
            if (this.f11173i != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                this.f11173i.sendMessage(messageObtain);
            }
        }

        private void b() {
            com.anythink.expressad.videocommon.d.a aVar;
            a.l(a.this);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.c();
        }

        private void d(String str) {
            o.a(b, "收到 onVideoLoadFailForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.f11172h.get() == 1 || this.f11172h.get() == 3) && this.f11173i != null) {
                a.u(a.this);
                if (str.contains("resource load timeout")) {
                    a.s(a.this);
                }
                if (a.this.ad && a.this.ac && !a.this.ab) {
                    this.f11172h.set(2);
                    o.d(b, "收到 hasCalledVideoLoadFailedForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str + " 响应");
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = str;
                    messageObtain.what = 16;
                    this.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onVideoLoadFailForCache，当前状态： " + this.f11172h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str + " 无需响应");
            }
        }

        static /* synthetic */ void b(c cVar, String str, String str2) {
            Handler handler = cVar.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.f11172h.get() == 1 || cVar.f11172h.get() == 3) && cVar.f11173i != null) {
                if (cVar.f11172h.get() == 1) {
                    cVar.f11172h.set(3);
                }
                if (!a.this.ab) {
                    o.d(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                    a.q(a.this);
                    Message messageObtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(com.anythink.expressad.a.f7981y, str);
                    bundle.putString("unit_id", str2);
                    messageObtain.setData(bundle);
                    messageObtain.obj = str2;
                    messageObtain.what = 9;
                    cVar.f11173i.sendMessage(messageObtain);
                    if (a.this.ac) {
                        cVar.f11172h.set(2);
                        return;
                    }
                    return;
                }
                o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
            }
        }

        private void c() {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.f();
        }

        static /* synthetic */ void c(c cVar, String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.f11172h.get() == 1 || cVar.f11172h.get() == 3) && cVar.f11173i != null) {
                if (!a.this.aa) {
                    o.d(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
                    a.o(a.this);
                    Message messageObtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(com.anythink.expressad.a.f7981y, str);
                    bundle.putString("unit_id", str2);
                    messageObtain.setData(bundle);
                    messageObtain.obj = str2;
                    messageObtain.what = 17;
                    cVar.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
            }
        }

        private void a(boolean z2, String str, float f2) {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            if (a.this.K) {
                a.b();
                a.this.a();
            }
            aVar.a(z2, str, f2);
        }

        private void d() {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.d();
        }

        private void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f11171c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.a(cVar);
        }

        private void a(List<com.anythink.expressad.foundation.d.c> list) {
            this.f11175k = list;
        }

        private void a(boolean z2) {
            this.f11176l = z2;
        }

        static /* synthetic */ void b(c cVar, String str) {
            cVar.f11172h.set(2);
            if (cVar.f11173i != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                cVar.f11173i.sendMessage(messageObtain);
            }
        }

        static /* synthetic */ void a(c cVar, String str, String str2) {
            Handler handler = cVar.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.f11172h.get() == 1 || cVar.f11172h.get() == 3) && cVar.f11173i != null) {
                cVar.f11172h.set(2);
                if (!a.this.ab) {
                    o.d(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                    a.q(a.this);
                    Message messageObtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(com.anythink.expressad.a.f7981y, str);
                    bundle.putString("unit_id", str2);
                    messageObtain.setData(bundle);
                    messageObtain.obj = str2;
                    messageObtain.what = 9;
                    cVar.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
            }
        }

        static /* synthetic */ void b(c cVar) {
            cVar.f11172h.set(1);
        }

        static /* synthetic */ void a(c cVar, String str) {
            Handler handler = cVar.f11173i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadFail，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f11171c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.f11172h.get() == 1 || cVar.f11172h.get() == 3) && cVar.f11173i != null) {
                a.s(a.this);
                if (!a.this.ae || str.contains("resource load timeout")) {
                    a.u(a.this);
                }
                if (a.this.ab) {
                    cVar.f11172h.set(2);
                }
                if (a.this.ac && a.this.ad && !a.this.ab) {
                    cVar.f11172h.set(2);
                    o.d(b, "收到 onVideoLoadFail，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 响应");
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = str;
                    messageObtain.what = 16;
                    cVar.f11173i.sendMessage(messageObtain);
                    return;
                }
                o.a(b, "收到 onVideoLoadFail，当前状态： " + cVar.f11172h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 无需响应");
            }
        }

        static /* synthetic */ int a(c cVar) {
            return cVar.f11172h.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final class d implements h {
        private a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Handler f11178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f11179e;

        /* synthetic */ d(a aVar, a aVar2, Handler handler) {
            this(aVar2, handler, (byte) 0);
        }

        private void d() {
            a.this.P.clear();
            this.b = null;
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a() {
            a.l(a.this);
            o.a(a.f11140i, "=====================onAdShow=====================");
            try {
                if (this.b != null) {
                    this.b.Q = true;
                    if (this.b.f11150m != null) {
                        this.b.f11150m.f11065n = "";
                    }
                    if (this.b.f11153p != null) {
                        if (a.this.K) {
                            a.b();
                        }
                        this.b.f11153p.c();
                        this.f11179e = 2;
                    }
                }
            } catch (Throwable th) {
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void b() {
            o.a(a.f11140i, "=====================onVideoComplete=====================");
            o.a(a.f11140i, "onVideoComplete start");
            try {
                if (this.b == null || this.b.f11153p == null) {
                    return;
                }
                try {
                    this.b.f11153p.d();
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
                this.f11179e = 5;
                o.a(a.f11140i, "onEndcardShow callback");
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void c() {
            o.a(a.f11140i, "=====================onEndcardShow=====================");
            o.a(a.f11140i, "onEndcardShow start");
            try {
                if (this.b == null || this.b.f11153p == null) {
                    return;
                }
                try {
                    this.b.f11153p.f();
                    com.anythink.expressad.foundation.f.b.a().b("_2", 2);
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
                this.f11179e = 6;
                o.a(a.f11140i, "onEndcardShow callback");
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }

        private d(a aVar, Handler handler, byte b) {
            this.f11179e = 0;
            this.b = aVar;
            this.f11177c = 1;
            this.f11178d = handler;
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z2, com.anythink.expressad.videocommon.c.c cVar) {
            o.a(a.f11140i, "=====================onAdClose=====================");
            try {
                if (this.b == null || this.b.f11153p == null) {
                    return;
                }
                if (cVar == null) {
                    cVar = com.anythink.expressad.videocommon.c.c.b(this.b.f11159v);
                }
                if (a.this.K) {
                    a.b();
                    a.this.a();
                }
                this.b.f11153p.a(z2, cVar.a(), cVar.b());
                this.f11179e = 7;
                o.a(a.f11140i, "onAdClose start release");
                this.b.Q = false;
                a.this.P.clear();
                this.b = null;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(String str) {
            a.l(a.this);
            o.a(a.f11140i, "=====================onShowFail=====================");
            try {
                if (this.b != null) {
                    if (a.this.K) {
                        a.b();
                    }
                    this.b.Q = false;
                    if (this.b.f11153p != null) {
                        try {
                            if (a.this.af != null) {
                                a.this.af.size();
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            this.b.f11153p.b(str);
                        } catch (Exception e2) {
                            if (com.anythink.expressad.a.a) {
                                e2.printStackTrace();
                            }
                        }
                        this.f11179e = 4;
                    }
                }
            } catch (Exception e3) {
                this.f11179e = 0;
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            o.a(a.f11140i, "=====================onVideoAdClicked=====================");
            try {
                if (this.b == null || this.b.f11153p == null) {
                    return;
                }
                try {
                    if (a.this.K) {
                        a.b();
                    }
                    this.b.f11153p.a(cVar);
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z2, int i2) {
            o.a(a.f11140i, "=====================onAdCloseWithIVReward=====================");
            o.a(a.f11140i, "onAdCloseWithIVReward start");
            try {
                if (this.b == null || this.b.f11153p == null) {
                    return;
                }
                this.b.Q = false;
                try {
                    com.anythink.expressad.videocommon.d.a unused = this.b.f11153p;
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
                o.a(a.f11140i, "onAdCloseWithIVReward callback");
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void b() {
    }

    private static void c() {
    }

    static /* synthetic */ boolean l(a aVar) {
        aVar.R = false;
        return false;
    }

    static /* synthetic */ boolean o(a aVar) {
        aVar.aa = true;
        return true;
    }

    static /* synthetic */ boolean q(a aVar) {
        aVar.ab = true;
        return true;
    }

    static /* synthetic */ boolean s(a aVar) {
        aVar.ac = true;
        return true;
    }

    static /* synthetic */ boolean u(a aVar) {
        aVar.ad = true;
        return true;
    }

    @Override // com.anythink.core.common.a.g
    public boolean isReady() {
        try {
            j();
            if (this.K) {
                return false;
            }
            if (this.f11150m == null) {
                i();
            }
            if (this.f11150m != null) {
                return this.f11150m.c();
            }
            return false;
        } catch (Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void b(boolean z2) {
        this.K = z2;
    }

    private void c(boolean z2) {
        this.O = z2;
    }

    private String d() {
        com.anythink.expressad.reward.a.d dVar = this.f11150m;
        return dVar != null ? dVar.c(this.Q) : "";
    }

    private static void e() {
        m.a();
    }

    private void f() {
        try {
            List<com.anythink.expressad.videocommon.c.b> listI = this.f11151n.I();
            if (listI == null || listI.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < listI.size(); i2++) {
                com.anythink.expressad.videocommon.c.b bVar = listI.get(i2);
                v.a(this.f11148k, this.f11157t + "_" + bVar.a(), 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean g() {
        int iIntValue;
        try {
            List<com.anythink.expressad.videocommon.c.b> listI = this.f11151n.I();
            if (this.f11152o == null) {
                this.f11152o = com.anythink.expressad.videocommon.e.c.a().b();
            }
            Map<String, Integer> mapI = this.f11152o.i();
            if (listI == null || listI.size() <= 0) {
                return true;
            }
            for (int i2 = 0; i2 < listI.size(); i2++) {
                com.anythink.expressad.videocommon.c.b bVar = listI.get(i2);
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.a());
                if (mapI.containsKey(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(bVar.a());
                    iIntValue = mapI.get(sb2.toString()).intValue();
                } else {
                    iIntValue = 0;
                }
                Object objB = v.b(this.f11148k, this.f11157t + "_" + bVar.a(), 0);
                if ((objB != null ? ((Integer) objB).intValue() : 0) < iIntValue) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            o.d(f11140i, e2.getMessage());
            return true;
        }
    }

    private boolean h() {
        if (this.f11150m == null) {
            i();
        }
        com.anythink.expressad.reward.a.d dVar = this.f11150m;
        if (dVar != null) {
            return dVar.c();
        }
        return false;
    }

    private void i() {
        this.f11150m = new com.anythink.expressad.reward.a.d(this.f11148k, this.f11157t, this.f11156s);
        this.f11150m.a(this.J);
        this.f11150m.b(this.K);
        if (this.J) {
            this.f11150m.a(this.B, this.C, this.D);
        }
        this.f11150m.a(this.f11151n);
    }

    private boolean j() {
        try {
            if (this.X != null) {
                return false;
            }
            this.X = com.anythink.expressad.foundation.c.c.a(n.a().g());
            return false;
        } catch (Throwable unused) {
            o.d(f11140i, "cap check error");
            return false;
        }
    }

    private static void b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        U.put(str, str2);
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        try {
            o.a(f11140i, "开始从 SOURCE_MBAPI 请求新的 offer: 8");
            if (this.f11150m == null || !this.f11156s.equals(this.f11150m.e())) {
                this.f11150m = new com.anythink.expressad.reward.a.d(this.f11148k, this.f11157t, this.f11156s);
                this.f11150m.a(this.J);
                this.f11150m.b(this.K);
            }
            if (this.J) {
                this.f11150m.a(this.B, this.C, this.D);
            }
            this.f11150m.a(this.f11162y);
            this.f11150m.a(this.f11151n);
            RunnableC0217a runnableC0217a = new RunnableC0217a(this.f11150m);
            b bVar = new b(this.f11150m);
            bVar.a(runnableC0217a);
            this.f11150m.a(bVar);
            this.f11150m.a(dVar);
        } catch (Exception e2) {
            b(e2.getMessage());
        }
    }

    public final void a(boolean z2) {
        this.J = z2;
    }

    public final void a(int i2) {
        this.f11162y = i2;
    }

    private void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            v.a(this.f11148k, "Anythink_ConfirmTitle" + this.f11156s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            v.a(this.f11148k, "Anythink_ConfirmContent" + this.f11156s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            v.a(this.f11148k, "Anythink_CancelText" + this.f11156s, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        v.a(this.f11148k, "Anythink_ConfirmText" + this.f11156s, str3.trim());
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        try {
            c(dVar);
        } catch (Exception e2) {
            try {
                b("load mv api error:" + e2.getMessage());
            } catch (Exception e3) {
                b(com.anythink.expressad.foundation.g.b.b.b);
                if (com.anythink.expressad.a.a) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f11154q != null) {
            this.ad = true;
            c.a(this.f11154q, str);
        }
    }

    private void a(int i2, int i3, int i4) {
        this.B = i2;
        this.C = i3;
        if (this.C == com.anythink.expressad.foundation.g.a.cu) {
            this.D = i4 < 0 ? 5 : i4;
        }
        if (this.C == com.anythink.expressad.foundation.g.a.ct) {
            this.D = i4 < 0 ? 80 : i4;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.anythink.expressad.foundation.g.a.cr ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i3 == com.anythink.expressad.foundation.g.a.ct ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i4);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.e(this.f11156s, jSONObject.toString());
        } catch (Exception unused) {
            o.d(f11140i, "setIVRewardEnable to SP was ERROR");
        }
    }

    private com.anythink.expressad.videocommon.c.b b(int i2) {
        com.anythink.expressad.videocommon.e.d dVar = this.f11151n;
        com.anythink.expressad.videocommon.c.b bVar = null;
        if (dVar != null) {
            int size = dVar.I().size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f11151n.I().get(i3).a() == i2) {
                    bVar = this.f11151n.I().get(i3);
                }
            }
        }
        return bVar;
    }

    public static void a(String str, int i2) {
        try {
            if (T == null || !w.b(str)) {
                return;
            }
            T.put(str, Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str) {
        Integer num;
        try {
            if (!w.b(str) || T == null || !T.containsKey(str) || (num = T.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final void a() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.Q || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(d())) {
            return;
        }
        U.remove(d());
    }

    public final void a(com.anythink.expressad.videocommon.d.a aVar) {
        this.f11153p = aVar;
        this.f11154q = new c(this, aVar, this.f11161x, this.f11156s, (byte) 0);
    }

    public final void a(String str, String str2) {
        try {
            this.f11148k = n.a().g();
            this.f11156s = str2;
            this.f11157t = str;
            this.f11152o = com.anythink.expressad.videocommon.e.c.a().b();
            m.b();
            com.anythink.expressad.videocommon.b.m.a().b();
            j.a().b();
            com.anythink.expressad.videocommon.e.c.a().a(this.f11156s, this.J);
            if (this.X == null) {
                this.X = com.anythink.expressad.foundation.c.c.a(n.a().g());
            }
        } catch (Throwable th) {
            o.b(f11140i, th.getMessage(), th);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null) {
            o.d(f11140i, com.anythink.expressad.foundation.g.b.b.f10456f);
            c.b(this.f11154q, com.anythink.expressad.foundation.g.b.b.f10456f);
            return;
        }
        if (this.f11154q != null && c.a(this.f11154q) == 3) {
            this.Y = false;
        } else {
            this.Y = true;
            c.b(this.f11154q);
        }
        this.N = true;
        this.f11161x.removeMessages(H);
        this.ab = false;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        com.anythink.expressad.reward.a.c.a();
        try {
            this.f11151n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11156s, this.J);
            if (!TextUtils.isEmpty(this.f11157t)) {
                this.f11151n.b(this.f11157t);
            }
            int iS = this.f11151n.S() * 1000;
            if (this.f11161x != null) {
                o.a(f11140i, "start load timeout for " + iS + " ms");
                this.f11161x.sendEmptyMessageDelayed(I, (long) iS);
            }
            this.V = this.f11151n.Q();
            try {
                if (g()) {
                    o.a(f11140i, "当前 cap 全满，清除所有的 cap");
                    f();
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
            try {
                c(dVar);
            } catch (Exception e3) {
                try {
                    b("load mv api error:" + e3.getMessage());
                } catch (Exception e4) {
                    b(com.anythink.expressad.foundation.g.b.b.b);
                    if (com.anythink.expressad.a.a) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Exception e5) {
            if (this.f11154q != null) {
                c.a(this.f11154q, "load exception");
            }
            if (com.anythink.expressad.a.a) {
                e5.printStackTrace();
            }
        }
    }

    private static List<com.anythink.expressad.foundation.d.c> a(String str, List<com.anythink.expressad.foundation.d.c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (com.anythink.expressad.foundation.d.c cVar : list) {
                if (cVar != null && str.equals(cVar.B())) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    private void a(Activity activity, String str, com.anythink.core.common.e.j jVar) {
        Map<String, Integer> mapI;
        try {
            int iIntValue = (this.f11152o == null || (mapI = this.f11152o.i()) == null || !mapI.containsKey("1")) ? 0 : mapI.get("1").intValue();
            if (v.b(this.f11148k, this.f11157t + "_1", 0) != null) {
                this.f11149l = ((Integer) v.b(this.f11148k, this.f11157t + "_1", 0)).intValue();
            }
            if (this.f11150m == null) {
                i();
            }
            if (this.f11150m != null) {
                o.d(f11140i, "controller 819");
                if (this.f11150m.c()) {
                    if (this.f11149l >= iIntValue && iIntValue > 0) {
                        this.R = false;
                        return;
                    }
                    o.b(f11140i, "invoke adapter show isReady");
                    d dVar = new d(this, this, this.f11161x);
                    f11139c.put(this.f11156s, dVar);
                    this.f11150m.a(activity, dVar, str, this.f11155r, this.f11162y, this.f11158u, jVar);
                    return;
                }
            }
            this.R = false;
            if (this.f11153p != null) {
                try {
                    this.f11153p.b("can't show because load is failed");
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                o.d(f11140i, e3.getLocalizedMessage());
            }
            if (this.f11153p != null) {
                try {
                    this.f11153p.b("show exception");
                } catch (Exception unused) {
                    if (com.anythink.expressad.a.a) {
                        e3.printStackTrace();
                    }
                }
            }
            this.R = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.app.Activity r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.anythink.core.common.e.j r14) {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.b.a.a(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, com.anythink.core.common.e.j):void");
    }

    private static void a(boolean z2, boolean z3) {
        try {
            if (f11139c != null) {
                f11139c.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU);
                } else {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.a();
            com.anythink.expressad.videocommon.a.b();
        } catch (Throwable unused) {
            o.d(f11140i, "destory failed");
        }
    }

    private static void a(boolean z2, boolean z3, String str) {
        try {
            if (f11139c != null) {
                f11139c.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU);
                } else {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.c(str);
            com.anythink.expressad.videocommon.a.b();
        } catch (Throwable unused) {
            o.d(f11140i, "destory failed");
        }
    }
}
