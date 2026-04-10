package com.anythink.expressad.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.reward.a.c;
import com.anythink.expressad.reward.a.e;
import com.anythink.expressad.reward.player.ATRewardVideoActivity;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.videocommon.b.l;
import com.anythink.expressad.videocommon.b.m;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.anythink.expressad.reward.a.a {
    private static final int L = 8;
    private static final int M = 9;
    private static final int N = 16;
    private static final int O = 17;
    private static final int P = 5000;
    private static final int Q = 30000;
    public static final String a = "APP ALREADY INSTALLED";
    public static final String b = "Offer list is empty";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11053d = "1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11054e = "1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11055f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11056g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11057h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11058i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11059j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11060k = 6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f11061l = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f11062u = "RewardMVVideoAdapter";
    private int A;
    private int B;
    private boolean C;
    private String D;
    private String E;
    private com.anythink.expressad.video.bt.module.b.h F;
    private volatile com.anythink.expressad.reward.a.b G;
    private Runnable H;
    private com.anythink.expressad.videocommon.e.d I;
    private boolean T;
    private boolean U;
    private int W;
    private int X;
    private int Y;
    private com.anythink.expressad.foundation.d.d Z;
    private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> aa;
    private List<com.anythink.expressad.foundation.d.c> ag;
    private List<com.anythink.expressad.foundation.d.c> ah;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Context f11072v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f11073w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f11074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11075y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11076z;
    private boolean J = false;
    private boolean K = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11063c = new Object();
    private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> R = new CopyOnWriteArrayList<>();
    private int S = 2;
    private String V = "";
    private boolean ab = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f11064m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11065n = "";
    private long ac = 0;
    private Handler ad = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.reward.a.d.1
        /* JADX WARN: Removed duplicated region for block: B:78:0x01fb A[Catch: Exception -> 0x0193, all -> 0x0535, TryCatch #3 {all -> 0x0535, blocks: (B:3:0x0008, B:15:0x0028, B:17:0x004e, B:19:0x005e, B:20:0x0067, B:22:0x006f, B:24:0x0075, B:26:0x008c, B:28:0x0094, B:30:0x00a6, B:32:0x00b2, B:36:0x00cb, B:38:0x00dd, B:40:0x0102, B:42:0x0119, B:44:0x0130, B:45:0x0142, B:47:0x0148, B:49:0x0154, B:51:0x0160, B:52:0x0169, B:54:0x017c, B:56:0x0188, B:57:0x0193, B:59:0x0199, B:61:0x01a1, B:63:0x01ab, B:65:0x01b9, B:68:0x01c3, B:70:0x01cd, B:72:0x01db, B:74:0x01e3, B:76:0x01ed, B:78:0x01fb, B:81:0x0206, B:83:0x0232, B:85:0x023a, B:87:0x0240, B:89:0x024e, B:91:0x025e, B:93:0x0270, B:94:0x0277, B:97:0x0283, B:99:0x028d, B:102:0x0295, B:104:0x029d, B:106:0x02be, B:108:0x02ca, B:109:0x02d3, B:111:0x02d7, B:113:0x02df, B:114:0x02e8, B:116:0x02f6, B:118:0x0306, B:120:0x0310, B:122:0x0318, B:123:0x0321, B:125:0x032f, B:127:0x033f, B:129:0x0347, B:130:0x0350, B:132:0x0376, B:136:0x0390, B:138:0x0398, B:139:0x03a1, B:141:0x03be, B:143:0x03de, B:145:0x03e6, B:146:0x03f9, B:148:0x0400, B:150:0x0427, B:152:0x042a, B:154:0x0451, B:156:0x0454, B:157:0x0459, B:159:0x047b, B:161:0x0481, B:165:0x048e, B:167:0x0499, B:169:0x049e, B:171:0x04bd, B:174:0x04c6, B:176:0x04ce, B:178:0x04d6, B:180:0x04e4, B:184:0x04f4, B:186:0x04ff, B:188:0x0503, B:190:0x050b, B:192:0x0516, B:194:0x0522, B:196:0x052f), top: B:205:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0202  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r20) {
            /*
                Method dump skipped, instruction units count: 1366
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.d.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f11066o = false;
    private long ae = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    volatile boolean f11067p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    volatile boolean f11068q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    volatile boolean f11069r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    volatile boolean f11070s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    volatile boolean f11071t = false;
    private String af = "";

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.d$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.d a;

        AnonymousClass5(com.anythink.expressad.foundation.d.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
            o.b(d.f11062u, "在子线程处理业务逻辑 开始");
            com.anythink.expressad.foundation.d.d dVar = this.a;
            if (dVar != null && (arrayList = dVar.J) != null && arrayList.size() > 0) {
                d.a(d.this, this.a.J);
            }
            o.b(d.f11062u, "在子线程处理业务逻辑 完成");
        }
    }

    private static class a extends com.anythink.expressad.atsignalcommon.a.a {
        private d b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a.C0226a f11093e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11094f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11095g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11096h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private g f11097i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Handler f11098j;

        public a(String str, String str2, a.C0226a c0226a, com.anythink.expressad.foundation.d.c cVar, d dVar, g gVar, Handler handler) {
            this.f11091c = str;
            this.f11092d = str2;
            this.f11093e = c0226a;
            if (dVar != null) {
                this.b = dVar;
            }
            this.f11094f = cVar;
            this.f11097i = gVar;
            this.f11098j = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final String a(String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(String str, int i2, int i3) {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f11095g) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.f11095g = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            try {
                o.d("RVWindVaneWebView", "CampaignTPL TempalteWindVaneWebviewClient tempalte load failed");
                if (this.b != null) {
                    synchronized (this.b) {
                        o.d("RVWindVaneWebView", "CampaignTPL TempalteWindVaneWebviewClient tempalte load callback failed");
                        d.a(this.b, str, str2);
                        this.b = null;
                    }
                }
            } catch (Throwable th) {
                o.b("RVWindVaneWebView", th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            Handler handler;
            if (this.f11096h) {
                return;
            }
            g gVar = this.f11097i;
            if (gVar != null && (handler = this.f11098j) != null) {
                handler.removeCallbacks(gVar);
            }
            o.a("RVWindVaneWebView", "CampaignTPL templete preload readyState state = ".concat(String.valueOf(i2)));
            l.a().c(this.f11091c, true);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11092d);
            sb.append("_");
            sb.append(this.f11091c);
            a.C0226a c0226a = this.f11093e;
            if (c0226a != null) {
                c0226a.a(true);
            }
            this.f11096h = true;
        }
    }

    private static final class c implements com.anythink.expressad.foundation.g.d.c {
        private d a;
        private com.anythink.expressad.foundation.d.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11099c;

        public c(d dVar, com.anythink.expressad.foundation.d.c cVar, String str) {
            this.a = dVar;
            this.b = cVar;
            this.f11099c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    private class g implements Runnable {
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f11109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11110g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d f11111h;

        public g(String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, int i2, d dVar2) {
            this.b = str;
            this.f11106c = cVar;
            this.f11107d = str2;
            this.f11108e = str3;
            this.f11109f = dVar;
            this.f11110g = i2;
            this.f11111h = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.b(d.f11062u, "retry load tpl url = " + this.f11107d);
                a.C0226a c0226a = new a.C0226a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
                c0226a.a(windVaneWebView);
                com.anythink.expressad.video.bt.a.c.a();
                String strB = com.anythink.expressad.video.bt.a.c.b();
                c0226a.a(strB);
                com.anythink.expressad.video.signal.a.j jVar = (d.this.Z.J == null || d.this.Z.J.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.f11106c) : new com.anythink.expressad.video.signal.a.j(null, this.f11106c, d.this.Z.J);
                jVar.a(this.f11110g);
                jVar.a(this.f11108e);
                jVar.c(strB);
                jVar.a(this.f11109f);
                jVar.b(d.this.ab);
                windVaneWebView.setWebViewListener(new a(this.f11107d, this.b, c0226a, this.f11106c, this.f11111h, null, null));
                windVaneWebView.setObject(jVar);
                windVaneWebView.loadUrl(this.f11107d);
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                o.a(d.f11062u, th.getMessage());
            }
        }
    }

    private class h implements Runnable {
        private WindVaneWebView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<com.anythink.expressad.foundation.d.c> f11114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f11117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private d f11119j;

        public h(WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, int i2, d dVar2) {
            this.b = windVaneWebView;
            this.f11112c = str;
            this.f11113d = cVar;
            this.f11114e = list;
            this.f11115f = str2;
            this.f11116g = str3;
            this.f11117h = dVar;
            this.f11118i = i2;
            this.f11119j = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.b(d.f11062u, "retry load template url = " + this.f11115f);
                a.C0226a c0226a = new a.C0226a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
                c0226a.a(windVaneWebView);
                com.anythink.expressad.video.signal.a.j jVar = (this.f11114e == null || this.f11114e.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.f11113d) : new com.anythink.expressad.video.signal.a.j(null, this.f11113d, this.f11114e);
                jVar.a(this.f11118i);
                jVar.a(this.f11116g);
                jVar.a(this.f11117h);
                jVar.b(d.this.ab);
                windVaneWebView.setWebViewListener(new j(this.b, this.f11115f, this.f11112c, c0226a, this.f11113d, this.f11119j, null, null));
                windVaneWebView.setObject(jVar);
                windVaneWebView.loadUrl(this.f11115f);
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                o.a(d.f11062u, th.getMessage());
            }
        }
    }

    private static class j extends com.anythink.expressad.atsignalcommon.a.b {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f11129c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private WindVaneWebView f11130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private a.C0226a f11133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f11135j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11136k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private h f11137l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Handler f11138m;

        public j(WindVaneWebView windVaneWebView, String str, String str2, a.C0226a c0226a, com.anythink.expressad.foundation.d.c cVar, d dVar, h hVar, Handler handler) {
            this.f11130e = windVaneWebView;
            this.f11131f = str;
            this.f11132g = str2;
            this.f11133h = c0226a;
            if (dVar != null) {
                this.f11129c = dVar;
            }
            this.f11134i = cVar;
            this.f11137l = hVar;
            this.f11138m = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f11135j) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.f11135j = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            try {
                o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load failed");
                if (this.f11129c != null) {
                    synchronized (this.f11129c) {
                        o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load callback failed");
                        d.a(this.f11129c, str, str2);
                        this.f11129c = null;
                    }
                }
            } catch (Throwable th) {
                o.b("WindVaneWebView", th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            Handler handler;
            if (this.f11136k) {
                return;
            }
            h hVar = this.f11137l;
            if (hVar != null && (handler = this.f11138m) != null) {
                handler.removeCallbacks(hVar);
            }
            String str = this.f11132g + "_" + this.f11131f;
            a.C0226a c0226a = this.f11133h;
            if (c0226a != null) {
                c0226a.a(true);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
                jSONObject.put("id", str);
                jSONObject.put("unitid", this.f11132g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            o.a("WindVaneWebView", "Tempalte templete preload readyState state = ".concat(String.valueOf(i2)));
            l.a().c(this.f11131f, true);
            d dVar = this.f11129c;
            if (dVar == null || !dVar.T) {
                if (this.f11134i.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.f11134i.aa(), this.f11133h);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                }
            } else if (this.f11134i.A()) {
                o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.f11134i.aa(), this.f11133h);
            } else {
                o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
            }
            try {
                o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load SUCCESS ");
                if (this.f11129c != null) {
                    synchronized (this.f11129c) {
                        o.d("WindVaneWebView", "Tempalte adapter 341");
                        if (this.f11129c != null && this.f11129c.c()) {
                            o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load  callback success");
                            if (this.f11129c.ad != null) {
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 6;
                                o.a("WindVaneWebView", "WHAT_ON_RES_LOAD_SUCCESS Template");
                                messageObtain.obj = this.f11134i;
                                this.f11129c.ad.sendMessage(messageObtain);
                                this.f11129c.ad.removeMessages(5);
                                this.f11129c = null;
                            }
                        }
                    }
                } else {
                    o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load SUCCESS  mRewardMVVideoAdapter is null");
                }
            } catch (Throwable th) {
                o.b("WindVaneWebView", th.getMessage(), th);
            }
            this.f11136k = true;
        }
    }

    public d(Context context, String str, String str2) {
        try {
            this.f11072v = context.getApplicationContext();
            this.f11073w = str2;
            this.f11074x = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void i() {
    }

    private static void j() {
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    private static void o() {
    }

    private static void p() {
    }

    private void r() {
        try {
            if (w.b(this.f11073w)) {
                com.anythink.expressad.reward.b.a.a(this.f11073w, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String s() {
        try {
            return w.b(com.anythink.expressad.reward.b.a.b) ? com.anythink.expressad.reward.b.a.b : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String t() {
        return "";
    }

    private static void u() {
        try {
            if (com.anythink.expressad.foundation.g.a.f.f10442h == null || com.anythink.expressad.foundation.g.a.f.f10442h.size() <= 0) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.f10442h.clear();
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    private static void v() {
    }

    private static /* synthetic */ void w() {
    }

    private static /* synthetic */ void x() {
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean a() {
        return false;
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void b() {
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void d() {
    }

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.d$d, reason: collision with other inner class name */
    private static class C0216d implements i.b {
        private com.anythink.expressad.foundation.d.c a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f11100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f11101d;

        public C0216d(d dVar, com.anythink.expressad.foundation.d.c cVar, String str, com.anythink.expressad.videocommon.e.d dVar2) {
            this.a = cVar;
            this.b = str;
            this.f11100c = dVar2;
            this.f11101d = dVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            d dVar = this.f11101d;
            if (dVar != null) {
                dVar.a(this.a, str, this.b, this.f11100c);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            d dVar = this.f11101d;
            if (dVar != null) {
                d.a(dVar, "TemplateUrl source download failed", str);
            }
        }
    }

    private void g() {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        this.R.clear();
    }

    private int h() {
        return this.S;
    }

    private void k() {
        Handler handler = this.ad;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    private int q() {
        try {
            int iA = w.b(this.f11073w) ? com.anythink.expressad.reward.b.a.a(this.f11073w) : 0;
            if (this.I == null) {
                return 0;
            }
            if (iA > this.I.D()) {
                return 0;
            }
            return iA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final void b(boolean z2) {
        this.U = z2;
    }

    public final String c(boolean z2) {
        List<com.anythink.expressad.foundation.d.c> listA;
        com.anythink.expressad.foundation.d.c cVar;
        if (!z2) {
            return this.f11064m;
        }
        if (TextUtils.isEmpty(this.f11065n) && (listA = com.anythink.expressad.videocommon.b.e.a().a(this.f11073w)) != null && listA.size() > 0 && (cVar = listA.get(0)) != null) {
            this.f11065n = cVar.Z();
        }
        return this.f11065n;
    }

    public final void d(boolean z2) {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList;
        if (z2 || (copyOnWriteArrayList = this.aa) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.anythink.expressad.videocommon.a.a.a();
    }

    public final String e() {
        return this.f11073w;
    }

    public final boolean f(boolean z2) {
        if (z2) {
            List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(1);
                    if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                        l.a().c(this.f11073w + "_" + cVar.Z() + "_" + cVar.M().e(), true);
                    }
                }
            }
            return true;
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        for (com.anythink.expressad.foundation.d.c cVar2 : this.aa) {
            if (cVar2 != null) {
                cVar2.l(1);
                if (cVar2.M() != null && !TextUtils.isEmpty(cVar2.M().e())) {
                    l.a().c(this.f11073w + "_" + cVar2.Z() + "_" + cVar2.M().e(), true);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(List<com.anythink.expressad.foundation.d.c> list, boolean z2, int i2) {
        if (list != null && list.size() > 0) {
            com.anythink.expressad.foundation.d.c cVar = list.get(0);
            if (com.anythink.expressad.videocommon.b.e.a().b(this.f11073w, this.U, list.size(), z2, i2, list)) {
                if (z2) {
                    if (cVar.j()) {
                        return true;
                    }
                    if (cVar.aB() != null && cVar.aB().size() > 0) {
                        if (cVar.aB().contains(3)) {
                            o.b(f11062u, "Is not check big template download status");
                            return true;
                        }
                        if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                            o.b(f11062u, "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    if (l.a().d(this.f11073w + "_" + cVar.Z() + "_" + cVar.ar())) {
                        o.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else {
                    if (cVar != null && cVar.j()) {
                        return true;
                    }
                    if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(1)) {
                        o.b(f11062u, "Is not check template download status");
                        return true;
                    }
                    if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                        if (l.a().d(this.f11073w + "_" + cVar.Z() + "_" + cVar.M().e())) {
                            o.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                            return true;
                        }
                    } else {
                        o.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    }
                }
            }
        } else {
            o.a("RewardVideoController", "数据为空");
        }
        return false;
    }

    private void h(List<com.anythink.expressad.foundation.d.c> list) {
        this.ah = list;
    }

    public final void e(boolean z2) {
        if (z2) {
            List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(0);
                    if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                        l.a().c(this.f11073w + "_" + cVar.Z() + "_" + cVar.M().e(), false);
                    }
                }
            }
            return;
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar2 : this.aa) {
            if (cVar2 != null) {
                cVar2.l(0);
                if (cVar2.M() != null && !TextUtils.isEmpty(cVar2.M().e())) {
                    l.a().c(this.f11073w + "_" + cVar2.Z() + "_" + cVar2.M().e(), false);
                }
            }
        }
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.ar())) {
            return;
        }
        String strAr = cVar.ar();
        com.anythink.expressad.videocommon.b.i.a().b(strAr, (i.a) new i(cVar, this, this.f11073w, 502, this.I, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(strAr))));
    }

    private void g(List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f11075y += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.I == null || this.f11075y > this.I.D()) {
            o.b(f11062u, "onload 重置offset为0");
            this.f11075y = 0;
        }
        o.b(f11062u, "onload 算出 下次的offset是:" + this.f11075y);
        if (w.b(this.f11073w)) {
            com.anythink.expressad.reward.b.a.a(this.f11073w, this.f11075y);
        }
    }

    public final void a(boolean z2) {
        this.T = z2;
    }

    private void a(String str) {
        this.V = str;
    }

    public final void a(int i2) {
        this.S = i2;
    }

    private static final class f implements i.b {
        private d a;
        private com.anythink.expressad.foundation.d.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f11103c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11104d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11105e;

        public f(d dVar, com.anythink.expressad.foundation.d.c cVar, String str, boolean z2) {
            this.f11105e = true;
            this.f11104d = str;
            this.a = dVar;
            this.b = cVar;
            this.f11105e = z2;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            try {
                if (this.a.ad != null) {
                    o.d(d.f11062u, "H5SourceDownloadListener 源码下载成功 cid:" + this.b.aZ() + "  url:" + str);
                    this.a.ad.removeMessages(5);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 8;
                    messageObtain.obj = this.b;
                    this.a.ad.sendMessage(messageObtain);
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            try {
                o.d(d.f11062u, "H5SourceDownloadListener 源码下载失败 cid:" + this.b.aZ() + "  url:" + str);
                if (this.a != null) {
                    d.a(this.a, "H5 code resource download failed ", str);
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar) {
        com.anythink.expressad.video.signal.a.j jVar;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
            c0226a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            String strB = com.anythink.expressad.video.bt.a.c.b();
            c0226a.a(strB);
            if (this.Z != null && this.Z.J != null && this.Z.J.size() > 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, this.Z.J);
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(this.S);
            jVar2.a(str3);
            jVar2.c(strB);
            jVar2.a(dVar);
            jVar2.b(this.ab);
            g gVar = new g(str3, cVar, str2, str3, dVar, this.S, this);
            windVaneWebView.setWebViewListener(new a(str, str3, c0226a, cVar, this, gVar, this.ad));
            windVaneWebView.setObject(jVar2);
            windVaneWebView.loadUrl(str2);
            this.ad.postDelayed(gVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(f11062u, th.getMessage());
        }
    }

    private void d(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!TextUtils.isEmpty(cVar.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.bd(), new c(this, cVar, this.f11073w));
            }
            if (!TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new c(this, cVar, this.f11073w));
            }
        }
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean c() {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return false;
        }
        return b(this.aa, !TextUtils.isEmpty(r0.ar()), this.aa.get(0).ap());
    }

    private void f(List<com.anythink.expressad.foundation.d.c> list) {
        try {
            o.b(f11062u, "===准备下载");
            if (list != null && list.size() > 0) {
                o.b(f11062u, "onload 开始下载视频素材 size:" + list.size());
                this.R.clear();
                this.R.addAll(list);
                l.a().a(list);
                if (com.anythink.expressad.videocommon.b.e.a() != null) {
                    com.anythink.expressad.videocommon.b.e.a().a(this.f11073w, list, 94, new b(this, list.get(0)));
                    com.anythink.expressad.videocommon.b.e.a().d(this.f11073w);
                    return;
                }
                return;
            }
            o.b(f11062u, "onload 不用下载视频素材 size为0");
        } catch (Exception e2) {
            o.b(f11062u, e2.getMessage(), e2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.d$4, reason: invalid class name */
    final class AnonymousClass4 implements c.i {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f11087c;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, boolean z2, int i2) {
            this.a = cVar;
            this.b = z2;
            this.f11087c = i2;
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(final String str, final String str2, final String str3) {
            o.a(d.f11062u, "大模板业务，大模板下载成功");
            d dVar = d.this;
            dVar.f11068q = true;
            if (!dVar.f11067p || d.this.f11069r || d.this.ad == null) {
                o.a(d.f11062u, "大模板业务，大模板下载成功，Campaign 下载不成功，isCampaignsDownloadSuccess： " + d.this.f11067p + "  isCampaignTPLProLoad： " + d.this.f11069r);
                return;
            }
            o.a(d.f11062u, "大模板业务，大模板下载成功，Campaign 下载成功，开始预加载大模板");
            o.a("test_pre_load_tpl", "大模板下载成功，Campaign 下载成功，开始预加载大模板");
            synchronized (d.this.f11063c) {
                if (d.this.f11069r) {
                    return;
                }
                d.this.f11069r = true;
                d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.expressad.reward.a.c cVar = c.m.a;
                        boolean z2 = d.this.ab;
                        Handler handler = d.this.ad;
                        boolean z3 = d.this.T;
                        boolean z4 = d.this.U;
                        String str4 = str3;
                        AnonymousClass4.this.a.aa();
                        String str5 = str;
                        String str6 = str2;
                        String strAr = AnonymousClass4.this.a.ar();
                        int i2 = d.this.S;
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        cVar.a(z2, handler, z3, z4, str4, str5, str6, strAr, i2, anonymousClass4.a, d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(AnonymousClass4.this.a.ar()), str2, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.4.1.1
                            @Override // com.anythink.expressad.reward.a.c.j
                            public final void a(String str7) {
                                o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str7)));
                                d dVar2 = d.this;
                                CopyOnWriteArrayList copyOnWriteArrayList = dVar2.aa;
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                if (!dVar2.a(copyOnWriteArrayList, anonymousClass42.b, anonymousClass42.f11087c)) {
                                    o.a(d.f11062u, "大模板业务，大模板预加载成功，isReady false");
                                    List unused = d.this.ag;
                                    boolean unused2 = d.this.U;
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.f11071t) {
                                        return;
                                    }
                                    d dVar3 = d.this;
                                    dVar3.f11071t = true;
                                    dVar3.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                    o.a(d.f11062u, "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                                    return;
                                }
                                o.a(d.f11062u, "大模板业务，大模板预加载成功，isReady true");
                                String str8 = d.this.f11073w;
                                List unused3 = d.this.ag;
                                List list = d.this.ah;
                                boolean unused4 = d.this.U;
                                d.a(str8, list);
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.G == null || d.this.f11070s) {
                                    return;
                                }
                                d dVar4 = d.this;
                                dVar4.f11070s = true;
                                TextUtils.isEmpty(dVar4.f11073w);
                                d.this.G.a();
                                o.a(d.f11062u, "大模板业务，大模板预加载成功，isReady true onVideoLoadSuccess");
                            }

                            @Override // com.anythink.expressad.reward.a.c.j
                            public final void a(String str7, String str8) {
                                o.a(d.f11062u, "大模板业务，大模板预加载失败");
                                o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str7)));
                                List unused = d.this.ag;
                                boolean unused2 = d.this.U;
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.G == null || d.this.f11071t) {
                                    return;
                                }
                                d dVar2 = d.this;
                                dVar2.f11071t = true;
                                dVar2.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(String.valueOf(str8)));
                                o.a(d.f11062u, "大模板业务，大模板预加载失败 onVideoLoadFail");
                            }
                        });
                    }
                });
            }
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(String str, String str2) {
            o.a(d.f11062u, "大模板业务，大模板下载失败");
            o.d("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str2)));
            if (d.this.ag.get(0) != null) {
                d.this.ag.size();
            }
            if (this.a.aB() != null && this.a.aB().size() > 0) {
                if (this.a.aB().contains(3)) {
                    o.b(d.f11062u, "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.a.ar().equals(this.a.I()) && this.a.aB().contains(2)) {
                    o.b(d.f11062u, "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            d dVar = d.this;
            dVar.f11068q = false;
            List unused = dVar.ag;
            boolean unused2 = d.this.U;
            if (d.this.ad != null) {
                d.this.ad.removeMessages(5);
            }
            if (d.this.G == null || d.this.f11071t) {
                return;
            }
            d dVar2 = d.this;
            dVar2.f11071t = true;
            dVar2.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            o.a(d.f11062u, "大模板业务，大模板下载失败 onVideoLoadFail");
        }
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        this.Z = dVar;
        o.a(f11062u, "Campaign 请求成功： " + dVar.J.size() + " 条");
        this.aa = d(dVar);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(dVar));
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            o.b(f11062u, "onload load成功 size:" + this.aa.size());
            Handler handler = this.ad;
            if (handler != null) {
                handler.sendEmptyMessage(3);
            }
            if (dVar != null) {
                String strC = dVar.c();
                if (w.b(strC)) {
                    o.b(f11062u, "onload sessionId:".concat(String.valueOf(strC)));
                    com.anythink.expressad.reward.b.a.b = strC;
                }
            }
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
            if (copyOnWriteArrayList2 != null) {
                try {
                    if (copyOnWriteArrayList2.size() > 0) {
                        this.f11075y += copyOnWriteArrayList2.size();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.I == null || this.f11075y > this.I.D()) {
                o.b(f11062u, "onload 重置offset为0");
                this.f11075y = 0;
            }
            o.b(f11062u, "onload 算出 下次的offset是:" + this.f11075y);
            if (w.b(this.f11073w)) {
                com.anythink.expressad.reward.b.a.a(this.f11073w, this.f11075y);
            }
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList3 = this.aa;
            if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                o.b(f11062u, "#######onload 把广告存在本地 size:" + this.aa.size());
            }
            final com.anythink.expressad.foundation.d.c cVar = this.aa.get(0);
            final boolean z2 = !TextUtils.isEmpty(cVar.ar());
            final int iAp = cVar.ap();
            this.f11067p = false;
            this.f11068q = false;
            synchronized (this.f11063c) {
                if (this.f11069r) {
                    this.f11069r = false;
                }
            }
            this.f11071t = false;
            this.f11070s = false;
            c.m.a.a(this.f11072v, z2, iAp, this.U, this.T ? com.anythink.expressad.foundation.g.a.aU : 94, this.f11074x, this.f11073w, cVar.Z(), this.aa, new AnonymousClass2(z2, cVar, iAp), new c.i() { // from class: com.anythink.expressad.reward.a.d.3
                @Override // com.anythink.expressad.reward.a.c.i
                public final void a(String str, String str2, String str3) {
                    o.a(d.f11062u, "template 下载成功： ");
                }

                @Override // com.anythink.expressad.reward.a.c.i
                public final void a(final String str, String str2) {
                    o.a(d.f11062u, "template 下载失败： ");
                    if (!z2 && d.this.G != null && d.this.ad != null) {
                        o.a(d.f11062u, "播放模板下载失败，非大模板");
                        if (cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) {
                            d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.3.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    List unused = d.this.ag;
                                    boolean unused2 = d.this.U;
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.f11071t || d.this.G == null) {
                                        return;
                                    }
                                    d dVar2 = d.this;
                                    dVar2.f11071t = true;
                                    dVar2.G.a("errorCode: 3202 errorMessage: temp resource download failed");
                                    o.a(d.f11062u, "播放模板下载失败，非大模板 onVideoLoadFail");
                                }
                            });
                            return;
                        } else {
                            o.b(d.f11062u, "template download fail but hit ignoreCheckRule");
                            return;
                        }
                    }
                    if (iAp == 1) {
                        if (cVar.aB() != null && cVar.aB().size() > 0) {
                            if (cVar.aB().contains(3)) {
                                o.b(d.f11062u, "tpl download fail but hit ignoreCheckRule");
                                return;
                            } else if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                                o.b(d.f11062u, "endcard download fail but hit ignoreCheckRule at 3203");
                                return;
                            }
                        }
                        if (d.this.G == null || d.this.ad == null) {
                            return;
                        }
                        d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.3.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                List unused = d.this.ag;
                                boolean unused2 = d.this.U;
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.f11071t || d.this.G == null) {
                                    return;
                                }
                                d dVar2 = d.this;
                                dVar2.f11071t = true;
                                dVar2.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                                o.a(d.f11062u, "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
                            }
                        });
                    }
                }
            });
            if (z2) {
                c.m.a.a(this.f11072v, cVar, this.f11074x, this.f11073w, cVar.Z(), new AnonymousClass4(cVar, z2, iAp));
                return;
            }
            return;
        }
        o.b(f11062u, "onload load失败 返回的compaign 没有带视频素材");
        if (TextUtils.isEmpty(this.af)) {
            this.af = b;
        }
        b(this.af);
    }

    private void e(List<com.anythink.expressad.foundation.d.c> list) {
        List<c.C0205c.a> listF;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (com.anythink.expressad.foundation.d.c cVar : list) {
                        if (cVar.M() != null && cVar.M().f() != null && (listF = cVar.M().f()) != null) {
                            for (c.C0205c.a aVar : listF) {
                                if (aVar != null && aVar.b != null) {
                                    for (String str : aVar.b) {
                                        if (w.b(str)) {
                                            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new e(this, cVar, this.f11073w));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static final class e implements com.anythink.expressad.foundation.g.d.c {
        private d a;
        private com.anythink.expressad.foundation.d.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11102c;

        public e(d dVar, com.anythink.expressad.foundation.d.c cVar, String str) {
            this.a = dVar;
            this.b = cVar;
            this.f11102c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            try {
                l.a();
                l.c(str);
                o.d(d.f11062u, "DownTemplateImgCommonImageLoaderListener IMAGE SUCCESS".concat(String.valueOf(str)));
                if (this.a != null) {
                    synchronized (this.a) {
                        o.d(d.f11062u, "adapter 1433");
                        if (this.a.c() && this.a.ad != null) {
                            Message messageObtain = Message.obtain();
                            o.a(d.f11062u, "WHAT_ON_RES_LOAD_SUCCESS DownTemplateImgCommonImageLoaderListener");
                            messageObtain.what = 6;
                            messageObtain.obj = this.b;
                            this.a.ad.sendMessage(messageObtain);
                            this.a.ad.removeMessages(5);
                            this.a = null;
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            try {
                if (this.a != null) {
                    synchronized (this.a) {
                        o.d(d.f11062u, "DownTemplateImgCommonImageLoaderListener IMAGE failed");
                        d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }
    }

    private static final class b implements com.anythink.expressad.videocommon.d.b {
        private d a;
        private com.anythink.expressad.foundation.d.c b;

        public b(d dVar, com.anythink.expressad.foundation.d.c cVar) {
            this.a = dVar;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            try {
                l.a().a(str, true);
                o.d(d.f11062u, "CommonVideoDownloadListener VIDEO SUCCESS");
                if (this.a != null) {
                    synchronized (this.a) {
                        o.d(d.f11062u, "adapter 1613");
                        if (this.a != null && this.a.c()) {
                            o.d(d.f11062u, "CommonVideoDownloadListener VIDEO SUCCESS callback success");
                            if (this.a.ad != null) {
                                Message messageObtain = Message.obtain();
                                o.a(d.f11062u, "WHAT_ON_RES_LOAD_SUCCESS CommonVideoDownloadListener");
                                messageObtain.what = 6;
                                messageObtain.obj = this.b;
                                this.a.ad.sendMessage(messageObtain);
                                this.a.ad.removeMessages(5);
                                this.a = null;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            try {
                if (this.a != null) {
                    synchronized (this.a) {
                        o.d(d.f11062u, "CommonVideoDownloadListener VIDEO failed");
                        d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> d(com.anythink.expressad.foundation.d.d r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.d.d(com.anythink.expressad.foundation.d.d):java.util.concurrent.CopyOnWriteArrayList");
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        try {
            this.Z = dVar;
            o.b(f11062u, "onLoadCompaginSuccess 数据刚请求回来");
            o.b("HBOPTIMIZE", "V3 数据刚请求回来 requestId " + this.Z.f());
            if (this.Z != null && this.Z.J != null) {
                this.Z.J.size();
            }
            c(this.Z);
            this.f11064m = this.Z.f();
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            o.b(f11062u, "onLoadCompaginSuccess 数据刚请求失败");
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            List<com.anythink.expressad.foundation.d.c> list = this.ag;
            if (list != null) {
                list.clear();
            }
            this.f11067p = false;
            this.f11068q = false;
            synchronized (this.f11063c) {
                if (this.f11069r) {
                    this.f11069r = false;
                }
                this.f11071t = false;
                this.f11070s = false;
                b("exception after load success");
                r();
            }
        }
    }

    public final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f() {
        return this.aa;
    }

    private void e(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(dVar));
    }

    private static boolean e(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        try {
            return cVar.J() == 2;
        } catch (Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void a(WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar) {
        com.anythink.expressad.video.signal.a.j jVar;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(n.a().g());
            c0226a.a(windVaneWebView2);
            if (list != null && list.size() > 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(this.S);
            jVar2.a(str3);
            jVar2.a(dVar);
            jVar2.b(this.ab);
            h hVar = new h(windVaneWebView, str3, cVar, list, str2, str3, dVar, this.S, this);
            windVaneWebView2.setWebViewListener(new j(windVaneWebView, str, str3, c0226a, cVar, this, hVar, this.ad));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            this.ad.postDelayed(hVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(f11062u, th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.d$2, reason: invalid class name */
    final class AnonymousClass2 implements c.InterfaceC0212c {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.anythink.expressad.foundation.d.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f11077c;

        AnonymousClass2(boolean z2, com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = z2;
            this.b = cVar;
            this.f11077c = i2;
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0212c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            o.a(d.f11062u, "Campaign 下载成功： " + copyOnWriteArrayList.size());
            d.this.f11067p = true;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.size();
            }
            if (this.a) {
                o.a(d.f11062u, "Campaign 下载成功： 大模板");
                if (!d.this.f11068q || d.this.f11069r || d.this.ad == null) {
                    o.a(d.f11062u, "Campaign 下载成功： 大模板，大模板下载不成功： isCampaignTPLDownloadSuccess： " + d.this.f11068q + "  isCampaignTPLProLoad： " + d.this.f11069r);
                    return;
                }
                o.a(d.f11062u, "Campaign 下载成功： 大模板，大模板下载成功，开始预加载大模板");
                synchronized (d.this.f11063c) {
                    if (d.this.f11069r) {
                        return;
                    }
                    d.this.f11069r = true;
                    o.a("test_pre_load_tpl", "Campaign 下载成功，大模板下载成功，开始预加载大模板");
                    d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.anythink.expressad.reward.a.c cVar = c.m.a;
                            boolean z2 = d.this.ab;
                            Handler handler = d.this.ad;
                            boolean z3 = d.this.T;
                            boolean z4 = d.this.U;
                            String str4 = str3;
                            AnonymousClass2.this.b.aa();
                            String str5 = d.this.f11074x;
                            String str6 = str2;
                            String strAr = AnonymousClass2.this.b.ar();
                            int i2 = d.this.S;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            cVar.a(z2, handler, z3, z4, str4, str5, str6, strAr, i2, anonymousClass2.b, d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(AnonymousClass2.this.b.ar()), str2, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.2.2.1
                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str7) {
                                    try {
                                        o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str7)));
                                    } catch (Exception unused) {
                                    }
                                    o.a(d.f11062u, "Campaign 下载成功： 大模板预加载成功");
                                    d dVar = d.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList2 = dVar.aa;
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    if (!dVar.a(copyOnWriteArrayList2, anonymousClass22.a, anonymousClass22.f11077c)) {
                                        o.a(d.f11062u, "Campaign 下载成功： 大模板预加载成功,isReady false");
                                        List unused2 = d.this.ag;
                                        boolean unused3 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.f11071t) {
                                            return;
                                        }
                                        d dVar2 = d.this;
                                        dVar2.f11071t = true;
                                        TextUtils.isEmpty(dVar2.f11073w);
                                        d.this.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                        o.a(d.f11062u, "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                                        return;
                                    }
                                    o.a(d.f11062u, "Campaign 下载成功： 大模板预加载成功,isReady true");
                                    String str8 = d.this.f11073w;
                                    List list = d.this.ah;
                                    boolean unused4 = d.this.U;
                                    d.a(str8, list);
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.f11070s) {
                                        return;
                                    }
                                    d dVar3 = d.this;
                                    dVar3.f11070s = true;
                                    TextUtils.isEmpty(dVar3.f11073w);
                                    d.this.G.a();
                                    o.a(d.f11062u, "Campaign 下载成功： 大模板预加载成功,isReady true onVideoLoadSuccess");
                                }

                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str7, String str8) {
                                    o.a(d.f11062u, "Campaign 下载成功： 大模板预加载失败");
                                    o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str7)));
                                    if (AnonymousClass2.this.b.aB() == null || AnonymousClass2.this.b.aB().size() <= 0 || !AnonymousClass2.this.b.aB().contains(3)) {
                                        List unused = d.this.ag;
                                        boolean unused2 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.f11071t) {
                                            return;
                                        }
                                        d dVar = d.this;
                                        dVar.f11071t = true;
                                        dVar.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(String.valueOf(str8)));
                                        o.a(d.f11062u, "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                                        return;
                                    }
                                    o.b(d.f11062u, "template download fail but hit ignoreCheckRule");
                                }
                            });
                        }
                    });
                    return;
                }
            }
            o.a(d.f11062u, "Campaign 下载成功： 非大模板");
            for (final com.anythink.expressad.foundation.d.c cVar : copyOnWriteArrayList) {
                if (cVar == null || cVar.M() == null || TextUtils.isEmpty(cVar.M().e()) || cVar.M().e().contains(com.anythink.expressad.foundation.d.c.f10153d) || d.this.ad == null) {
                    o.a(d.f11062u, "Campaign 下载成功： 非大模板，不存在播放模板");
                    d dVar = d.this;
                    if (dVar.a(dVar.aa, this.a, this.f11077c)) {
                        o.a(d.f11062u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay true");
                        o.a("HBOPTIMIZE", "模板加载成功 requestId " + copyOnWriteArrayList.get(0).Z());
                        String str4 = d.this.f11073w;
                        List list = d.this.ah;
                        boolean unused = d.this.U;
                        d.a(str4, list);
                        if (d.this.ad != null) {
                            d.this.ad.removeMessages(5);
                        }
                        if (d.this.G != null && !d.this.f11070s) {
                            d dVar2 = d.this;
                            dVar2.f11070s = true;
                            TextUtils.isEmpty(dVar2.f11073w);
                            d.this.G.a();
                            o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true onVideoLoadSuccess");
                        }
                    } else {
                        o.a(d.f11062u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay false");
                        o.d("HBOPTIMIZE", "模板加载失败 requestId " + copyOnWriteArrayList.get(0).Z());
                        List unused2 = d.this.ag;
                        boolean unused3 = d.this.U;
                        if (d.this.ad != null) {
                            d.this.ad.removeMessages(5);
                        }
                        if (d.this.G != null && !d.this.f11071t) {
                            d dVar3 = d.this;
                            dVar3.f11071t = true;
                            if (!TextUtils.isEmpty(dVar3.f11073w) && cVar != null && !TextUtils.isEmpty(cVar.aa())) {
                                cVar.aa();
                            }
                            d.this.G.a("errorCode: 3503 errorMessage: have no temp but isReady false");
                            o.a(d.f11062u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                        }
                    }
                } else {
                    o.a(d.f11062u, "Campaign 下载成功： 非大模板，开始预加载播放模板");
                    d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.anythink.expressad.reward.a.c cVar2 = c.m.a;
                            boolean z2 = d.this.ab;
                            Handler handler = d.this.ad;
                            boolean z3 = d.this.T;
                            boolean z4 = d.this.U;
                            String strE = cVar.M().e();
                            int i2 = d.this.S;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.anythink.expressad.foundation.d.c cVar3 = anonymousClass2.b;
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = d.this.aa;
                            String strC = com.anythink.expressad.videocommon.b.i.a().c(cVar.M().e());
                            String str5 = str;
                            String str6 = str2;
                            String str7 = str3;
                            cVar.aa();
                            cVar2.a(z2, handler, z3, z4, (WindVaneWebView) null, strE, i2, cVar3, copyOnWriteArrayList2, strC, str5, str6, str7, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.2.1.1
                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str8) {
                                    o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功");
                                    o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str8)));
                                    d dVar4 = d.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList3 = dVar4.aa;
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    if (!dVar4.a(copyOnWriteArrayList3, anonymousClass22.a, anonymousClass22.f11077c)) {
                                        o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false");
                                        List unused4 = d.this.ag;
                                        boolean unused5 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.f11071t) {
                                            return;
                                        }
                                        d dVar5 = d.this;
                                        dVar5.f11071t = true;
                                        TextUtils.isEmpty(dVar5.f11073w);
                                        d.this.G.a("errorCode: 3502 errorMessage: temp preload success but isReady false");
                                        o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                                        return;
                                    }
                                    String str9 = d.this.f11073w;
                                    List list2 = d.this.ah;
                                    boolean unused6 = d.this.U;
                                    d.a(str9, list2);
                                    o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true");
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.f11070s) {
                                        return;
                                    }
                                    d dVar6 = d.this;
                                    dVar6.f11070s = true;
                                    TextUtils.isEmpty(dVar6.f11073w);
                                    o.a(d.f11062u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true onVideoLoadSuccess");
                                    d.this.G.a();
                                }

                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str8, String str9) {
                                    o.a(d.f11062u, "Campaign 下载失败： 非大模板，播放模板预加载失败");
                                    o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str8)));
                                    if (AnonymousClass2.this.b.aB() == null || AnonymousClass2.this.b.aB().size() <= 0 || !AnonymousClass2.this.b.aB().contains(1)) {
                                        List unused4 = d.this.ag;
                                        boolean unused5 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.f11071t) {
                                            return;
                                        }
                                        d dVar4 = d.this;
                                        dVar4.f11071t = true;
                                        TextUtils.isEmpty(dVar4.f11073w);
                                        d.this.G.a("errorCode: 3301 errorMessage: temp preload failed: ".concat(String.valueOf(str9)));
                                        o.a(d.f11062u, "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                                        return;
                                    }
                                    o.b(d.f11062u, "template preload fail but hit ignoreCheckRule");
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0212c
        public final void a(final String str, String str2, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            o.a(d.f11062u, "Campaign 下载失败： " + copyOnWriteArrayList.size());
            o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str2)));
            d.this.f11067p = false;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.size();
            }
            if (d.this.G == null || d.this.ad == null) {
                return;
            }
            d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.3
                @Override // java.lang.Runnable
                public final void run() {
                    List unused = d.this.ag;
                    boolean unused2 = d.this.U;
                    if (d.this.ad != null) {
                        d.this.ad.removeMessages(5);
                    }
                    if (d.this.f11071t || d.this.G == null) {
                        return;
                    }
                    d dVar = d.this;
                    dVar.f11071t = true;
                    TextUtils.isEmpty(dVar.f11073w);
                    d.this.G.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    o.a(d.f11062u, "Campaign 下载失败：onVideoLoadFail");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.ad != null) {
            if (TextUtils.isEmpty(str)) {
                this.ad.sendEmptyMessage(4);
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            if (str.contains("exception")) {
                this.ad.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                this.ad.sendMessage(messageObtain);
            }
        }
    }

    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        try {
            this.I = dVar;
            if (this.I == null || this.I.V() * 1000 == com.anythink.expressad.foundation.g.a.cq) {
                return;
            }
            com.anythink.expressad.foundation.g.a.cq = this.I.V() * 1000;
        } catch (Throwable th) {
            o.b(f11062u, th.getMessage(), th);
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.P())) {
            com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
        }
        if (cVar.M() != null) {
            c.C0205c c0205cM = cVar.M();
            if (!TextUtils.isEmpty(c0205cM.d())) {
                if (c0205cM.d().contains(".zip")) {
                    o.a(f11062u, "下载 paused url zip");
                    com.anythink.expressad.videocommon.b.i.a().b(c0205cM.d(), (i.a) new i(cVar, this, this.f11073w, 313, this.I, false));
                } else {
                    o.a(f11062u, "下载 paused url h5");
                    com.anythink.expressad.videocommon.b.i.a().b(c0205cM.d(), (i.a) null);
                }
            }
            if (TextUtils.isEmpty(c0205cM.e()) || c0205cM.e().contains(com.anythink.expressad.foundation.d.c.f10153d)) {
                return;
            }
            if (c0205cM.e().contains(".zip")) {
                o.a(f11062u, "下载 template zip");
                com.anythink.expressad.videocommon.b.i.a().b(c0205cM.e(), (i.a) new i(cVar, this, this.f11073w, 859, this.I, false));
            } else {
                o.a(f11062u, "下载 template h5");
                com.anythink.expressad.videocommon.b.i.a().b(c0205cM.e(), new C0216d(this, cVar, this.f11073w, this.I));
            }
        }
    }

    public final boolean a(List<com.anythink.expressad.foundation.d.c> list, boolean z2, int i2) {
        return b(list, z2, i2);
    }

    private static final class i implements i.d {
        public static final int a = 497;
        public static final int b = 859;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11120c = 313;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11121d = 502;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11122e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f11123f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f11124g = System.currentTimeMillis();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f11125h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11126i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f11127j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11128k;

        public i(com.anythink.expressad.foundation.d.c cVar, d dVar, String str, int i2, com.anythink.expressad.videocommon.e.d dVar2, boolean z2) {
            this.f11126i = 0;
            this.f11128k = true;
            this.f11125h = str;
            this.f11122e = cVar;
            this.f11126i = i2;
            this.f11127j = dVar2;
            this.f11123f = dVar;
            this.f11128k = z2;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            Context context;
            try {
                l.a().b(str, true);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f11124g;
                if (this.f11126i == 497) {
                    if (this.f11128k) {
                        r rVar = new r(r.f10364k, 14, String.valueOf(jCurrentTimeMillis), str, this.f11122e.aZ(), this.f11125h, "", "1");
                        rVar.d(this.f11122e.Z());
                        rVar.e(this.f11122e.aa());
                        rVar.g(this.f11122e.aZ());
                        rVar.b(this.f11122e.f());
                        if (this.f11122e.w() == 287) {
                            rVar.a("3");
                        } else if (this.f11122e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (this.f11126i == 859) {
                    o.a(d.f11062u, "模板资源下载成功");
                    r rVar2 = new r();
                    rVar2.h(r.f10366m);
                    if (this.f11123f != null) {
                        if (TextUtils.isEmpty(this.f11122e.ar())) {
                            this.f11123f.a(this.f11122e, str, this.f11125h, this.f11127j);
                        }
                        Context context2 = this.f11123f.f11072v;
                        if (context2 != null) {
                            context2.getApplicationContext();
                            rVar2.c(k.a());
                        }
                    }
                    rVar2.d(1);
                    if (this.f11122e != null) {
                        rVar2.g(this.f11122e.aZ());
                        rVar2.d(this.f11122e.Z());
                        rVar2.e(this.f11122e.aa());
                    }
                    rVar2.b(str);
                    rVar2.i("");
                    rVar2.f(this.f11125h);
                } else if (this.f11126i == 502) {
                    o.a(d.f11062u, "大模板下载成功");
                    r rVar3 = new r();
                    rVar3.h(r.f10366m);
                    if (this.f11123f != null && (context = this.f11123f.f11072v) != null) {
                        context.getApplicationContext();
                        rVar3.c(k.a());
                    }
                    rVar3.d(1);
                    if (this.f11122e != null) {
                        rVar3.g(this.f11122e.aZ());
                        rVar3.d(this.f11122e.Z());
                        rVar3.e(this.f11122e.aa());
                    }
                    rVar3.b(str);
                    rVar3.i("");
                    rVar3.f(this.f11125h);
                } else if (this.f11126i == 313) {
                    return;
                }
                o.d(d.f11062u, "RewardZipDownloadListener ZIP SUCCESS:".concat(String.valueOf(str)));
                if (this.f11123f != null) {
                    synchronized (this.f11123f) {
                        o.d(d.f11062u, "adapter 1286");
                        if (this.f11123f.c() && this.f11123f.ad != null) {
                            o.a(d.f11062u, "WHAT_ON_RES_LOAD_SUCCESS RewardZipDownloadListener");
                            this.f11123f.ad.sendEmptyMessage(6);
                            this.f11123f.ad.removeMessages(5);
                            this.f11123f = null;
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.f11062u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            Context context;
            o.d(d.f11062u, "RewardZipDownloadListener ZIP failed:".concat(String.valueOf(str2)));
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f11124g;
                if (this.f11126i == 497) {
                    if (this.f11128k) {
                        r rVar = new r(r.f10364k, 3, String.valueOf(jCurrentTimeMillis), str2, this.f11122e.aZ(), this.f11125h, "zip download failed", "1");
                        rVar.d(this.f11122e.Z());
                        rVar.e(this.f11122e.aa());
                        rVar.g(this.f11122e.aZ());
                        rVar.b(this.f11122e.f());
                        if (this.f11122e.w() == 287) {
                            rVar.a("3");
                        } else if (this.f11122e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (this.f11126i == 859) {
                    r rVar2 = new r();
                    rVar2.h(r.f10366m);
                    if (this.f11123f != null && (context = this.f11123f.f11072v) != null) {
                        context.getApplicationContext();
                        rVar2.c(k.a());
                    }
                    rVar2.d(3);
                    if (this.f11122e != null) {
                        rVar2.g(this.f11122e.aZ());
                        rVar2.d(this.f11122e.Z());
                        rVar2.e(this.f11122e.aa());
                    }
                    rVar2.b(str2);
                    rVar2.i(str);
                    rVar2.f(this.f11125h);
                } else if (this.f11126i == 313) {
                    return;
                }
                if (this.f11123f != null) {
                    o.d(d.f11062u, "RewardZipDownloadListener ZIP failed:".concat(String.valueOf(str2)));
                    d.a(this.f11123f, str, str2);
                }
            } catch (Exception e2) {
                try {
                    if (this.f11123f != null) {
                        this.f11123f.b("clear error info failed");
                    }
                } catch (Throwable th) {
                    o.b(d.f11062u, th.getMessage(), th);
                }
                o.b(d.f11062u, e2.getMessage(), e2);
            }
            if (this.f11123f != null) {
                this.f11123f = null;
            }
        }
    }

    public final void a(Activity activity, com.anythink.expressad.video.bt.module.b.h hVar, String str, String str2, int i2, String str3, com.anythink.core.common.e.j jVar) {
        try {
            this.F = hVar;
            o.b(f11062u, "show 进来");
            if (this.f11072v != null && !w.a(this.f11073w)) {
                Context context = (activity == null || activity.isFinishing()) ? this.f11072v : activity;
                o.b(f11062u, "show isReady true 打开播放器页面");
                Intent intent = new Intent(context, (Class<?>) ATRewardVideoActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                }
                intent.putExtra(ATRewardVideoActivity.a, this.f11073w);
                intent.putExtra(com.anythink.expressad.a.f7981y, this.f11074x);
                intent.putExtra(ATRewardVideoActivity.f11180c, str);
                intent.putExtra(ATRewardVideoActivity.f11181d, i2);
                intent.putExtra(ATRewardVideoActivity.f11182e, this.T);
                intent.putExtra(ATRewardVideoActivity.f11183f, this.U);
                intent.putExtra(ATRewardVideoActivity.f11189l, str3);
                intent.putExtra(ATRewardVideoActivity.f11190m, jVar);
                List<com.anythink.expressad.foundation.d.c> listA = com.anythink.expressad.videocommon.b.e.a().a(this.f11073w);
                StringBuilder sb = new StringBuilder("当前展示的Offer requestId");
                boolean z2 = false;
                sb.append(listA.get(0).Z());
                o.d("HBOPTIMIZE", sb.toString());
                if (listA != null && listA.size() > 0) {
                    o.a(f11062u, "可以 show 的数据： " + listA.size());
                    com.anythink.expressad.foundation.d.c cVar = listA.get(0);
                    if (cVar != null) {
                        this.f11065n = cVar.Z();
                    }
                    if (cVar != null && !TextUtils.isEmpty(cVar.ar())) {
                        z2 = true;
                    }
                } else {
                    o.a(f11062u, "可以 show 的数据： 0");
                    if (this.F != null) {
                        this.F.a("load failed");
                        return;
                    }
                }
                intent.putExtra(ATRewardVideoActivity.f11184g, z2);
                if (this.T) {
                    intent.putExtra(ATRewardVideoActivity.f11186i, this.W);
                    intent.putExtra(ATRewardVideoActivity.f11187j, this.X);
                    intent.putExtra(ATRewardVideoActivity.f11188k, this.Y);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(ATRewardVideoActivity.b, str2);
                }
                e.a.a.a(this.f11074x, this.f11073w, this.I);
                context.startActivity(intent);
                return;
            }
            if (this.F != null) {
                this.F.a("context or unitid is null");
            }
            o.b(f11062u, "show context munitid null");
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.expressad.video.bt.module.b.h hVar2 = this.F;
            if (hVar2 != null) {
                hVar2.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    private boolean b(com.anythink.expressad.foundation.d.c cVar) {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
            while (it.hasNext()) {
                if (it.next().aZ().equals(cVar.aZ())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void b(String str, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        o.a("test_isReay_db", "标记缓存数据 ： " + list.size());
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + "_" + cVar.aZ() + "_" + cVar.Z() + "_" + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    private void b(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                if (!TextUtils.isEmpty(cVar.P())) {
                    com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
                }
                if (cVar.M() != null) {
                    c.C0205c c0205cM = cVar.M();
                    if (!TextUtils.isEmpty(c0205cM.d())) {
                        if (c0205cM.d().contains(".zip")) {
                            o.a(f11062u, "下载 paused url zip");
                            com.anythink.expressad.videocommon.b.i.a().b(c0205cM.d(), (i.a) new i(cVar, this, this.f11073w, 313, this.I, false));
                        } else {
                            o.a(f11062u, "下载 paused url h5");
                            com.anythink.expressad.videocommon.b.i.a().b(c0205cM.d(), (i.a) null);
                        }
                    }
                    if (!TextUtils.isEmpty(c0205cM.e()) && !c0205cM.e().contains(com.anythink.expressad.foundation.d.c.f10153d)) {
                        if (c0205cM.e().contains(".zip")) {
                            o.a(f11062u, "下载 template zip");
                            com.anythink.expressad.videocommon.b.i.a().b(c0205cM.e(), (i.a) new i(cVar, this, this.f11073w, 859, this.I, false));
                        } else {
                            o.a(f11062u, "下载 template h5");
                            com.anythink.expressad.videocommon.b.i.a().b(c0205cM.e(), new C0216d(this, cVar, this.f11073w, this.I));
                        }
                    }
                }
            }
        }
    }

    private void c(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            String strI = cVar.I();
            if (!TextUtils.isEmpty(strI) && !cVar.H()) {
                if (strI.contains(".zip") && strI.contains(m.b)) {
                    o.a(f11062u, "下载 endcard zip");
                    com.anythink.expressad.videocommon.b.i.a().b(strI, (i.a) new i(cVar, this, this.f11073w, 497, this.I, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(strI))));
                } else {
                    o.a(f11062u, "下载 endcard h5");
                    com.anythink.expressad.videocommon.b.i.a().b(strI, new f(this, cVar, this.f11073w, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(strI))));
                }
            }
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, String str, String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Object[] objArr = new Object[5];
            if (!str.contains("zip") || this.ad == null) {
                return;
            }
            String strC = com.anythink.expressad.videocommon.b.i.a().c(str);
            o.a(f11062u, "寻找到的大模板： ".concat(String.valueOf(strC)));
            Message messageObtain = Message.obtain();
            messageObtain.what = 17;
            objArr[0] = cVar;
            objArr[1] = strC;
            objArr[2] = str2;
            objArr[3] = dVar;
            objArr[4] = str;
            messageObtain.obj = objArr;
            this.ad.sendMessage(messageObtain);
        } catch (Exception unused) {
        }
    }

    private static void c(String str) {
        if (w.b(str)) {
            o.b(f11062u, "onload sessionId:".concat(String.valueOf(str)));
            com.anythink.expressad.reward.b.a.b = str;
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.f11076z = 1;
        this.B = 8;
        this.C = true;
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        List<com.anythink.expressad.foundation.d.c> list = this.ag;
        if (list != null) {
            list.clear();
        }
        this.f11067p = false;
        this.f11068q = false;
        synchronized (this.f11063c) {
            if (this.f11069r) {
                this.f11069r = false;
            }
        }
        this.f11071t = false;
        this.f11070s = false;
        if (this.f11072v == null) {
            b("Context is null");
            return;
        }
        if (w.a(this.f11073w)) {
            b("UnitId is null");
            return;
        }
        if (this.I == null) {
            b("RewardUnitSetting is null");
            return;
        }
        try {
            if (com.anythink.expressad.foundation.g.a.f.f10442h != null && com.anythink.expressad.foundation.g.a.f.f10442h.size() > 0) {
                com.anythink.expressad.foundation.g.a.f.f10442h.clear();
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
        o.b(f11062u, "load 开始清除过期数据");
        try {
            this.Z = dVar;
            o.b(f11062u, "onLoadCompaginSuccess 数据刚请求回来");
            o.b("HBOPTIMIZE", "V3 数据刚请求回来 requestId " + this.Z.f());
            if (this.Z != null && this.Z.J != null) {
                this.Z.J.size();
            }
            c(this.Z);
            this.f11064m = this.Z.f();
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.printStackTrace();
            }
            o.b(f11062u, "onLoadCompaginSuccess 数据刚请求失败");
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
            List<com.anythink.expressad.foundation.d.c> list2 = this.ag;
            if (list2 != null) {
                list2.clear();
            }
            this.f11067p = false;
            this.f11068q = false;
            synchronized (this.f11063c) {
                if (this.f11069r) {
                    this.f11069r = false;
                }
                this.f11071t = false;
                this.f11070s = false;
                b("exception after load success");
                r();
            }
        }
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list) {
        o.b(f11062u, "onload 开始 更新本机已安装广告列表");
        if (this.f11072v != null && list != null && list.size() != 0) {
            boolean z2 = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.anythink.expressad.foundation.d.c cVar = list.get(i2);
                if (cVar != null && t.a(this.f11072v, cVar.ba())) {
                    z2 = true;
                }
            }
            if (z2) {
                o.b(f11062u, "更新安装列表");
                return;
            }
            return;
        }
        o.b(f11062u, "onload 列表为空 不做更新本机已安装广告列表");
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (com.anythink.expressad.videocommon.a.a.a() == null) {
                return true;
            }
            com.anythink.expressad.videocommon.a.a.a();
            return com.anythink.expressad.videocommon.a.a.a(cVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void a(com.anythink.expressad.reward.a.b bVar) {
        if (bVar != null) {
            o.b(f11062u, "======set listener is not null");
        } else {
            o.b(f11062u, "======set listener is  null");
        }
        this.G = bVar;
    }

    private void a(Runnable runnable) {
        this.H = runnable;
    }

    private void a(String str, String str2) {
        try {
            o.d(f11062u, "====delCampaignFromDownLoadCampaignListByUrld");
            if (this.R != null && !TextUtils.isEmpty(str2)) {
                Iterator<com.anythink.expressad.foundation.d.c> it = this.R.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.anythink.expressad.foundation.d.c next = it.next();
                    if (next != null) {
                        String strS = next.S();
                        if (!TextUtils.isEmpty(strS) && str2.equals(strS)) {
                            this.R.remove(next);
                            break;
                        }
                        String strI = next.I();
                        if (!TextUtils.isEmpty(strI) && str2.equals(strI)) {
                            this.R.remove(next);
                            break;
                        }
                        c.C0205c c0205cM = next.M();
                        if (c0205cM != null) {
                            List<c.C0205c.a> listF = c0205cM.f();
                            if (listF != null) {
                                Iterator<c.C0205c.a> it2 = listF.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    c.C0205c.a next2 = it2.next();
                                    if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                        this.R.remove(next);
                                        break;
                                    }
                                }
                            }
                            String strE = c0205cM.e();
                            if (!TextUtils.isEmpty(strE) && str2.equals(strE)) {
                                this.R.remove(next);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (this.G == null || this.R == null || this.R.size() != 0) {
                    return;
                }
                if (this.ad != null) {
                    this.ad.removeMessages(5);
                }
                o.d(f11062u, "====del campaign and callback failed");
                b(str);
                this.G.a(str);
                return;
            }
            if (this.G != null) {
                if (this.ad != null) {
                    this.ad.removeMessages(5);
                }
                o.d(f11062u, "====del campaign and callback failed");
                b(str);
                this.G.a(str);
            }
        } catch (Throwable th) {
            o.b(f11062u, th.getMessage(), th);
            try {
                if (this.G != null) {
                    if (this.ad != null) {
                        this.ad.removeMessages(5);
                    }
                    o.d(f11062u, "====del campaign and callback failed");
                    b(str);
                }
            } catch (Throwable th2) {
                o.b(f11062u, th2.getMessage(), th2);
            }
        }
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar) {
        if (list != null) {
            try {
                Iterator<com.anythink.expressad.foundation.d.c> it = list.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.foundation.d.c next = it.next();
                    boolean z2 = true;
                    boolean z3 = next != null;
                    if (next.M() == null) {
                        z2 = false;
                    }
                    if ((z2 & z3) && !TextUtils.isEmpty(next.M().e())) {
                        a(next, next.M().e(), this.f11073w, dVar);
                    }
                    if (next != null && !TextUtils.isEmpty(next.ar())) {
                        a(next, next.ar(), this.f11073w, dVar);
                    }
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, String str, String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strC = com.anythink.expressad.videocommon.b.i.a().c(str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 16;
            messageObtain.obj = new Object[]{cVar, strC, str2, dVar, str};
            if (this.ad != null) {
                this.ad.sendMessage(messageObtain);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(int i2, int i3, int i4) {
        this.W = i2;
        this.X = i3;
        this.Y = i4;
    }

    static /* synthetic */ void a(String str, List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        o.a("test_isReay_db", "标记缓存数据 ： " + list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) it.next();
            if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + "_" + cVar.aZ() + "_" + cVar.Z() + "_" + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    static /* synthetic */ void a(d dVar, WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        com.anythink.expressad.video.signal.a.j jVar;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(n.a().g());
            c0226a.a(windVaneWebView2);
            if (list != null && list.size() > 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(dVar.S);
            jVar2.a(str3);
            jVar2.a(dVar2);
            jVar2.b(dVar.ab);
            h hVar = dVar.new h(windVaneWebView, str3, cVar, list, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView2.setWebViewListener(new j(windVaneWebView, str, str3, c0226a, cVar, dVar, hVar, dVar.ad));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            dVar.ad.postDelayed(hVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(f11062u, th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        com.anythink.expressad.video.signal.a.j jVar;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
            c0226a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            String strB = com.anythink.expressad.video.bt.a.c.b();
            c0226a.a(strB);
            if (dVar.Z != null && dVar.Z.J != null && dVar.Z.J.size() > 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, dVar.Z.J);
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(dVar.S);
            jVar2.a(str3);
            jVar2.c(strB);
            jVar2.a(dVar2);
            jVar2.b(dVar.ab);
            g gVar = dVar.new g(str3, cVar, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView.setWebViewListener(new a(str, str3, c0226a, cVar, dVar, gVar, dVar.ad));
            windVaneWebView.setObject(jVar2);
            windVaneWebView.loadUrl(str2);
            dVar.ad.postDelayed(gVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(f11062u, th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            o.d(f11062u, "====delCampaignFromDownLoadCampaignListByUrld");
            if (dVar.R != null && !TextUtils.isEmpty(str2)) {
                Iterator<com.anythink.expressad.foundation.d.c> it = dVar.R.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.anythink.expressad.foundation.d.c next = it.next();
                    if (next != null) {
                        String strS = next.S();
                        if (!TextUtils.isEmpty(strS) && str2.equals(strS)) {
                            dVar.R.remove(next);
                            break;
                        }
                        String strI = next.I();
                        if (!TextUtils.isEmpty(strI) && str2.equals(strI)) {
                            dVar.R.remove(next);
                            break;
                        }
                        c.C0205c c0205cM = next.M();
                        if (c0205cM != null) {
                            List<c.C0205c.a> listF = c0205cM.f();
                            if (listF != null) {
                                Iterator<c.C0205c.a> it2 = listF.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    c.C0205c.a next2 = it2.next();
                                    if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                        dVar.R.remove(next);
                                        break;
                                    }
                                }
                            }
                            String strE = c0205cM.e();
                            if (!TextUtils.isEmpty(strE) && str2.equals(strE)) {
                                dVar.R.remove(next);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (dVar.G == null || dVar.R == null || dVar.R.size() != 0) {
                    return;
                }
                if (dVar.ad != null) {
                    dVar.ad.removeMessages(5);
                }
                o.d(f11062u, "====del campaign and callback failed");
                dVar.b(str);
                dVar.G.a(str);
                return;
            }
            if (dVar.G != null) {
                if (dVar.ad != null) {
                    dVar.ad.removeMessages(5);
                }
                o.d(f11062u, "====del campaign and callback failed");
                dVar.b(str);
                dVar.G.a(str);
            }
        } catch (Throwable th) {
            o.b(f11062u, th.getMessage(), th);
            try {
                if (dVar.G != null) {
                    if (dVar.ad != null) {
                        dVar.ad.removeMessages(5);
                    }
                    o.d(f11062u, "====del campaign and callback failed");
                    dVar.b(str);
                }
            } catch (Throwable th2) {
                o.b(f11062u, th2.getMessage(), th2);
            }
        }
    }

    static /* synthetic */ void a(d dVar, List list) {
        o.b(f11062u, "onload 开始 更新本机已安装广告列表");
        if (dVar.f11072v != null && list != null && list.size() != 0) {
            boolean z2 = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) list.get(i2);
                if (cVar != null && t.a(dVar.f11072v, cVar.ba())) {
                    z2 = true;
                }
            }
            if (z2) {
                o.b(f11062u, "更新安装列表");
                return;
            }
            return;
        }
        o.b(f11062u, "onload 列表为空 不做更新本机已安装广告列表");
    }
}
