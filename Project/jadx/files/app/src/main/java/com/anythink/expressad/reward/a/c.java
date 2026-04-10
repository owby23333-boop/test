package com.anythink.expressad.reward.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.AnythinkBTLayout;
import com.anythink.expressad.video.bt.module.AnythinkBTRootLayout;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String a = "RewardCampaignsResourceManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, a> f10925d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10926f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10927g = 200;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10928h = 101;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f10929i = 201;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f10930j = 102;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f10931k = 202;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f10932l = 103;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f10933m = 203;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f10934n = 104;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f10935o = 204;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f10936p = 105;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f10937q = 205;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f10938r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f10939s = 1;
    private final h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, List<com.anythink.expressad.foundation.d.c>> f10940c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10941e;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile List<WindVaneWebView> f10942t;

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.c$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ WindVaneWebView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f10952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f10953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10954e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.videocommon.e.d f10955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f10956g;

        AnonymousClass3(boolean z2, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, List list, String str, com.anythink.expressad.videocommon.e.d dVar, String str2) {
            this.a = z2;
            this.b = windVaneWebView;
            this.f10952c = cVar;
            this.f10953d = list;
            this.f10954e = str;
            this.f10955f = dVar;
            this.f10956g = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a("RewardCampaignsResourceManager_test", "开始预加载播放模板 55");
            c.a(this.a, this.b, this.f10952c.M().e(), this.f10952c, this.f10953d, com.anythink.expressad.videocommon.b.i.a().c(this.f10952c.M().e()), this.f10954e, this.f10955f, this.f10956g, c.this.f10941e);
        }
    }

    private static class a {
        boolean a;
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f10960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f10961f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f10962g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f10963h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f10964i;

        public a(boolean z2, boolean z3, int i2, int i3, String str, String str2, int i4, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.a = z2;
            this.b = z3;
            this.f10958c = i2;
            this.f10959d = i3;
            this.f10960e = str;
            this.f10961f = str2;
            this.f10962g = i4;
            this.f10963h = copyOnWriteArrayList;
            this.f10964i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    private static class b extends com.anythink.expressad.atsignalcommon.a.a {
        private final Handler b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f10965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f10966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f10967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f10968f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f10969g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f10970h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f10971i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f10972j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private a.C0226a f10973k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f10974l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f10975m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f10976n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final j f10977o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f10979q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f10980r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f10982t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f10983u;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f10981s = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f10978p = false;

        public b(boolean z2, Handler handler, Runnable runnable, boolean z3, boolean z4, int i2, String str, String str2, String str3, String str4, a.C0226a c0226a, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, com.anythink.expressad.videocommon.e.d dVar, j jVar, long j2) {
            this.b = handler;
            this.f10965c = runnable;
            this.f10966d = z3;
            this.f10967e = z4;
            this.f10968f = i2;
            this.f10969g = str;
            this.f10971i = str2;
            this.f10970h = str3;
            this.f10972j = str4;
            this.f10973k = c0226a;
            this.f10974l = cVar;
            this.f10975m = copyOnWriteArrayList;
            this.f10976n = dVar;
            this.f10977o = jVar;
            this.f10982t = z2;
            this.f10983u = j2;
            o.a("RewardCampaignsResourceManager_test", "开始预加载大模板");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(String str, int i2, int i3) {
            o.a("RVWindVaneWebView", "loadAds: unitID " + str + " type " + i2 + " adType " + i3);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            Runnable runnable;
            super.onPageFinished(webView, str);
            o.a("RewardCampaignsResourceManager_test", "onPageFinished");
            if (this.f10979q) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10970h);
            sb.append("_");
            sb.append(this.f10969g);
            if (!str.contains("wfr=1")) {
                o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient templete preload wfr=1 不包含 ");
                com.anythink.expressad.videocommon.b.l.a().c(this.f10970h + "_" + this.f10972j + "_" + this.f10969g, true);
                Handler handler = this.b;
                if (handler != null && (runnable = this.f10965c) != null) {
                    handler.removeCallbacks(runnable);
                }
                a.C0226a c0226a = this.f10973k;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                if (this.f10977o != null) {
                    o.a(c.a, "CampaignTPLWindVaneWebviewClient rewardTemplatePreLoadListener.onPreLoadSuccess ");
                    this.f10977o.a(this.f10972j);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.f10979q = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            o.a("RewardCampaignsResourceManager_test", "onReceivedError： " + i2 + "  " + str);
            com.anythink.expressad.videocommon.b.l.a().c(this.f10970h + "_" + this.f10972j + "_" + this.f10969g, false);
            if (this.f10977o != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f10970h);
                sb.append("_");
                sb.append(this.f10969g);
                a.C0226a c0226a = this.f10973k;
                if (c0226a != null) {
                    c0226a.a(false);
                }
                this.f10977o.a(this.f10972j, str);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            Runnable runnable;
            o.a("RewardCampaignsResourceManager_test", "收到大模板 readyState 回调: ".concat(String.valueOf(i2)));
            if (this.f10980r) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10970h);
            sb.append("_");
            sb.append(this.f10969g);
            o.a("test_pre_load_tpl", "CampaignTPLWindVaneWebviewClient 开始预加载大模板资源 readyState： " + i2 + " isCache: " + this.f10978p);
            if (i2 == 1) {
                o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient templete preload readyState state = ".concat(String.valueOf(i2)));
                if (this.f10978p) {
                    com.anythink.expressad.videocommon.a.e(this.f10970h + "_" + this.f10972j);
                } else {
                    com.anythink.expressad.videocommon.a.d(this.f10970h + "_" + this.f10972j);
                }
                o.a("test_pre_load_tpl", "添加大模板： " + this.f10970h + "_" + this.f10972j + "_" + this.f10969g);
                com.anythink.expressad.videocommon.a.a(this.f10970h + "_" + this.f10972j + "_" + this.f10969g, this.f10973k, true, this.f10978p);
                Handler handler = this.b;
                if (handler != null && (runnable = this.f10965c) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.f10970h + "_" + this.f10972j + "_" + this.f10969g, true);
                a.C0226a c0226a = this.f10973k;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                if (this.f10977o != null) {
                    o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient rewardTemplatePreLoadListener.onPreLoadSuccess ");
                    this.f10977o.a(this.f10972j);
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.f10970h + "_" + this.f10972j + "_" + this.f10969g, false);
                a.C0226a c0226a2 = this.f10973k;
                if (c0226a2 != null) {
                    c0226a2.a(false);
                }
                j jVar = this.f10977o;
                if (jVar != null) {
                    jVar.a(this.f10972j, "state 2");
                }
            }
            this.f10980r = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final String a(String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x010e A[Catch: all -> 0x0146, TRY_LEAVE, TryCatch #0 {all -> 0x0146, blocks: (B:16:0x007e, B:18:0x0084, B:21:0x008c, B:23:0x009a, B:24:0x009f, B:27:0x00c7, B:29:0x00cb, B:30:0x00d4, B:32:0x00e2, B:34:0x00f2, B:35:0x00f8, B:36:0x010e, B:37:0x0113, B:40:0x013a, B:42:0x013e), top: B:58:0x007e, inners: #1, #3 }] */
        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.Object r18, java.lang.String r19) {
            /*
                Method dump skipped, instruction units count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.c.b.a(java.lang.Object, java.lang.String):void");
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.reward.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0212c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);

        void a(String str, String str2, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);
    }

    private static final class d implements i.b {
        public static final int a = 497;
        public static final int b = 313;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f10984c = 859;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f10986e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f10987f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f10988g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f10989h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f10990i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private i f10991j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Handler f10992k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<com.anythink.expressad.foundation.d.c> f10993l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f10985d = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final long f10994m = System.currentTimeMillis();

        public d(int i2, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, i iVar, Handler handler, List<com.anythink.expressad.foundation.d.c> list) {
            this.f10986e = i2;
            this.f10987f = str;
            this.f10988g = str2;
            this.f10989h = str3;
            this.f10990i = cVar;
            this.f10991j = iVar;
            this.f10992k = handler;
            this.f10993l = list;
        }

        public final void a(boolean z2) {
            this.f10985d = z2;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            int i2 = this.f10986e;
            if (i2 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.f10988g);
                bundle.putString(com.anythink.expressad.a.f7981y, this.f10987f);
                bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.f10992k.sendMessage(messageObtain);
                return;
            }
            if (i2 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.f10988g);
                bundle2.putString(com.anythink.expressad.a.f7981y, this.f10987f);
                bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.f10992k.sendMessage(messageObtain2);
                if (this.f10985d) {
                    System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (i2 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 105;
            Bundle bundle3 = new Bundle();
            bundle3.putString("unit_id", this.f10988g);
            bundle3.putString(com.anythink.expressad.a.f7981y, this.f10987f);
            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
            messageObtain3.setData(bundle3);
            this.f10992k.sendMessage(messageObtain3);
            i iVar = this.f10991j;
            if (iVar != null) {
                iVar.a(this.f10987f, this.f10988g, this.f10989h);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str, false);
            int i2 = this.f10986e;
            if (i2 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.f10988g);
                bundle.putString(com.anythink.expressad.a.f7981y, this.f10987f);
                bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                messageObtain.setData(bundle);
                this.f10992k.sendMessage(messageObtain);
                return;
            }
            if (i2 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.f10988g);
                bundle2.putString(com.anythink.expressad.a.f7981y, this.f10987f);
                bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                messageObtain2.setData(bundle2);
                this.f10992k.sendMessage(messageObtain2);
                if (this.f10985d) {
                    System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (i2 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 205;
            Bundle bundle3 = new Bundle();
            bundle3.putString("unit_id", this.f10988g);
            bundle3.putString(com.anythink.expressad.a.f7981y, this.f10987f);
            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10989h);
            bundle3.putString("message", str2);
            messageObtain3.setData(bundle3);
            this.f10992k.sendMessage(messageObtain3);
            i iVar = this.f10991j;
            if (iVar != null) {
                iVar.a(this.f10988g, this.f10989h);
            }
        }
    }

    private static final class g implements i.d {
        public static final int a = 497;
        public static final int b = 859;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11003c = 313;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11004d = 502;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Context f11006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f11008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f11009i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11010j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f11011k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Handler f11012l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private i f11013m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<com.anythink.expressad.foundation.d.c> f11014n;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11005e = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f11015o = System.currentTimeMillis();

        public g(Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, int i2, Handler handler, i iVar, List<com.anythink.expressad.foundation.d.c> list) {
            this.f11006f = context;
            this.f11008h = str;
            this.f11007g = str2;
            this.f11009i = str3;
            this.f11010j = cVar;
            this.f11011k = i2;
            this.f11012l = handler;
            this.f11013m = iVar;
            this.f11014n = list;
        }

        public final void a(boolean z2) {
            this.f11005e = z2;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            System.currentTimeMillis();
            int i2 = this.f11011k;
            if (i2 == 313) {
                o.a(c.a, "zip pause download success");
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.f11007g);
                bundle.putString(com.anythink.expressad.a.f7981y, this.f11008h);
                bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.f11012l.sendMessage(messageObtain);
                return;
            }
            if (i2 == 497) {
                o.a(c.a, "zip endcard download success");
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.f11007g);
                bundle2.putString(com.anythink.expressad.a.f7981y, this.f11008h);
                bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.f11012l.sendMessage(messageObtain2);
                if (this.f11005e) {
                }
                return;
            }
            if (i2 != 859) {
                return;
            }
            o.a(c.a, "zip template download success");
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString("unit_id", this.f11007g);
            bundle3.putString(com.anythink.expressad.a.f7981y, this.f11008h);
            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
            messageObtain3.setData(bundle3);
            this.f11012l.sendMessage(messageObtain3);
            i iVar = this.f11013m;
            if (iVar != null) {
                iVar.a(this.f11008h, this.f11007g, this.f11009i);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str2, false);
            System.currentTimeMillis();
            int i2 = this.f11011k;
            if (i2 == 313) {
                o.a(c.a, "zip pause download failed");
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.f11007g);
                bundle.putString(com.anythink.expressad.a.f7981y, this.f11008h);
                bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                this.f11012l.sendMessage(messageObtain);
                return;
            }
            if (i2 == 497) {
                o.a(c.a, "zip endcard download failed:  ".concat(String.valueOf(str)));
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.f11007g);
                bundle2.putString(com.anythink.expressad.a.f7981y, this.f11008h);
                bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                messageObtain2.setData(bundle2);
                this.f11012l.sendMessage(messageObtain2);
                if (this.f11005e) {
                }
                return;
            }
            if (i2 != 859) {
                return;
            }
            o.a(c.a, "zip template download failed");
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 203;
            Bundle bundle3 = new Bundle();
            bundle3.putString("unit_id", this.f11007g);
            bundle3.putString(com.anythink.expressad.a.f7981y, this.f11008h);
            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11009i);
            bundle3.putString("url", str2);
            bundle3.putString("message", str);
            messageObtain3.setData(bundle3);
            this.f11012l.sendMessage(messageObtain3);
            i iVar = this.f11013m;
            if (iVar != null) {
                iVar.a(this.f11007g, this.f11009i);
            }
        }
    }

    private static final class h extends Handler {
        private Context a;
        private InterfaceC0212c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConcurrentHashMap<String, InterfaceC0212c> f11016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c>> f11017d;

        public h(Looper looper) {
            super(looper);
            this.f11016c = new ConcurrentHashMap<>();
            this.f11017d = new ConcurrentHashMap<>();
        }

        public final void a(String str, String str2, InterfaceC0212c interfaceC0212c) {
            this.f11016c.put(str + "_" + str2, interfaceC0212c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean zA;
            Object obj;
            Bundle data = message.getData();
            String string = data.getString(com.anythink.expressad.a.f7981y);
            String string2 = data.getString("unit_id");
            String string3 = data.getString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID);
            String str = string2 + "_" + string3;
            a aVar = (a) c.f10925d.get(str);
            InterfaceC0212c interfaceC0212c = this.f11016c.get(str);
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.f11017d.get(str);
            o.a(c.a, "收到 Message，开始判断");
            int i2 = message.what;
            if (i2 == 0 || i2 == 1) {
                return;
            }
            switch (i2) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    break;
                default:
                    switch (i2) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && interfaceC0212c != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                StringBuilder sb = new StringBuilder("resource download failed ");
                                sb.append(c.b(message.what));
                                sb.append(" ");
                                sb.append(string4);
                                com.anythink.expressad.foundation.d.c cVar = null;
                                CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = aVar.f10963h;
                                if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                                    cVar = aVar.f10963h.get(0);
                                }
                                com.anythink.expressad.foundation.d.c cVar2 = cVar;
                                try {
                                    try {
                                        if (!aVar.a || aVar.f10964i == null) {
                                            obj = "resource download failed ";
                                            try {
                                                boolean zA2 = com.anythink.expressad.videocommon.b.e.a().a(aVar.f10960e, aVar.b, aVar.f10959d, aVar.a, aVar.f10958c, copyOnWriteArrayList);
                                                o.a(c.a, " failed Campaign是否下载成功： （回调）".concat(String.valueOf(zA2)));
                                                if (zA2) {
                                                    interfaceC0212c.a(string, string2, string3, aVar.f10963h);
                                                } else {
                                                    if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0) {
                                                        int i3 = message.what;
                                                        if (i3 != 200) {
                                                            if (i3 != 201) {
                                                                if (i3 != 203) {
                                                                    if (i3 == 205 && cVar2.aB().contains(3)) {
                                                                    }
                                                                } else if (cVar2.aB().contains(1)) {
                                                                }
                                                            } else if (cVar2.aB().contains(2)) {
                                                            }
                                                        } else if (cVar2.aB().contains(0)) {
                                                        }
                                                    }
                                                    interfaceC0212c.a(string2, string3, aVar.f10963h);
                                                }
                                                this.f11016c.remove(str);
                                                c.f10925d.remove(str);
                                                this.f11017d.remove(str);
                                            } catch (Exception e2) {
                                                e = e2;
                                                CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList3 = aVar.f10963h;
                                                new StringBuilder((String) obj).append(e.getMessage());
                                                interfaceC0212c.a(string2, string3, copyOnWriteArrayList3);
                                                return;
                                            }
                                        } else if (aVar.f10958c == 1) {
                                            if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0) {
                                                int i4 = message.what;
                                                if (i4 != 200) {
                                                    if (i4 != 201) {
                                                        if (i4 != 203) {
                                                            if (i4 == 205) {
                                                                if (!cVar2.aB().contains(3)) {
                                                                    if (aVar.f10963h != null && aVar.f10963h.size() > 0) {
                                                                        com.anythink.expressad.foundation.d.c cVar3 = aVar.f10963h.get(0);
                                                                        if (cVar3.ar().equals(cVar3.I()) && cVar2.aB().contains(2)) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else if (cVar2.aB().contains(1)) {
                                                        }
                                                    } else if (cVar2.aB().contains(2)) {
                                                    }
                                                } else if (cVar2.aB().contains(0)) {
                                                }
                                            }
                                            interfaceC0212c.a(string2, string3, aVar.f10963h);
                                            this.f11016c.remove(str);
                                            c.f10925d.remove(str);
                                            this.f11017d.remove(str);
                                        } else {
                                            String string5 = data.getString("url");
                                            int i5 = message.what;
                                            if (i5 == 200) {
                                                if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0) {
                                                    if (cVar2.aB().contains(0)) {
                                                        o.b(c.a, "Is TPL but  video download fail but hit ignoreCheckRule");
                                                    }
                                                    break;
                                                }
                                                for (int i6 = 0; i6 < aVar.f10964i.size(); i6++) {
                                                    if (aVar.f10964i.get(i6).S().equals(string5)) {
                                                        aVar.f10964i.remove(i6);
                                                    }
                                                }
                                                c.f10925d.remove(str);
                                                c.f10925d.put(str, aVar);
                                            } else if (i5 == 201) {
                                                if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0 && cVar2.aB().contains(2)) {
                                                    o.b(c.a, "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                } else {
                                                    for (int i7 = 0; i7 < aVar.f10964i.size(); i7++) {
                                                        com.anythink.expressad.foundation.d.c cVar4 = aVar.f10964i.get(i7);
                                                        if (cVar4.M() != null && cVar4.M().d().equals(string5)) {
                                                            aVar.f10964i.remove(i7);
                                                        }
                                                        if (!TextUtils.isEmpty(cVar4.I()) && cVar4.I().equals(string5)) {
                                                            aVar.f10964i.remove(i7);
                                                        }
                                                    }
                                                    c.f10925d.remove(str);
                                                    c.f10925d.put(str, aVar);
                                                }
                                                break;
                                            } else if (i5 == 203) {
                                                if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0 && cVar2.aB().contains(1)) {
                                                    o.b(c.a, "Is TPL but download template fail but hit ignoreCheckRule");
                                                } else {
                                                    for (int i8 = 0; i8 < aVar.f10964i.size(); i8++) {
                                                        com.anythink.expressad.foundation.d.c cVar5 = aVar.f10964i.get(i8);
                                                        if (cVar5.M() != null && cVar5.M().e().equals(string5)) {
                                                            aVar.f10964i.remove(i8);
                                                        }
                                                    }
                                                    c.f10925d.remove(str);
                                                    c.f10925d.put(str, aVar);
                                                }
                                                break;
                                            } else if (i5 == 205) {
                                                if (cVar2 != null && cVar2.aB() != null && cVar2.aB().size() > 0 && cVar2.aB().contains(3)) {
                                                    o.b(c.a, "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                } else {
                                                    aVar.f10964i.clear();
                                                    c.f10925d.remove(str);
                                                    c.f10925d.put(str, aVar);
                                                }
                                                break;
                                            }
                                            boolean zA3 = com.anythink.expressad.videocommon.b.e.a().a(aVar.f10960e, aVar.b, aVar.f10959d, aVar.a, aVar.f10958c, copyOnWriteArrayList);
                                            o.a(c.a, " failed Campaign是否下载成功：(回调) ".concat(String.valueOf(zA3)));
                                            if (zA3) {
                                                interfaceC0212c.a(string, string2, string3, aVar.f10963h);
                                                this.f11016c.remove(str);
                                                c.f10925d.remove(str);
                                                this.f11017d.remove(str);
                                            } else if (aVar.f10964i.size() == 0) {
                                                interfaceC0212c.a(string2, string3, aVar.f10963h);
                                                this.f11016c.remove(str);
                                                c.f10925d.remove(str);
                                                this.f11017d.remove(str);
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        obj = data;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    obj = "resource download failed ";
                                }
                                break;
                            }
                            break;
                    }
                    return;
            }
            if (aVar == null || interfaceC0212c == null) {
                return;
            }
            try {
                zA = com.anythink.expressad.videocommon.b.e.a().a(aVar.f10960e, aVar.b, aVar.f10959d, aVar.a, aVar.f10958c, copyOnWriteArrayList);
            } catch (Exception e5) {
                if (com.anythink.expressad.a.a) {
                    o.d(c.a, e5.getLocalizedMessage());
                }
                zA = false;
            }
            o.a(c.a, " success Campaign是否下载成功：(回调) ".concat(String.valueOf(zA)));
            if (zA) {
                interfaceC0212c.a(string, string2, string3, aVar.f10963h);
                this.f11016c.remove(str);
                c.f10925d.remove(str);
                this.f11017d.remove(str);
            }
        }

        public final void a(Context context) {
            this.a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.f11017d.put(str, copyOnWriteArrayList);
        }
    }

    public interface i {
        void a(String str, String str2);

        void a(String str, String str2, String str3);
    }

    public interface j {
        void a(String str);

        void a(String str, String str2);
    }

    private static class k extends com.anythink.expressad.atsignalcommon.a.b {
        private Handler a;
        private Runnable b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f11018c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f11019e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final j f11021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final WindVaneWebView f11022h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f11023i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f11024j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f11025k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final a.C0226a f11026l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final com.anythink.expressad.foundation.d.c f11027m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f11028n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f11029o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f11030p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f11031q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final Runnable f11032r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Runnable f11033s;

        public k(Handler handler, Runnable runnable, boolean z2, boolean z3, final String str, final j jVar, WindVaneWebView windVaneWebView, final String str2, final String str3, final String str4, final a.C0226a c0226a, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, long j2) {
            this.a = handler;
            this.b = runnable;
            this.f11018c = z2;
            this.f11019e = z3;
            this.f11020f = str;
            this.f11021g = jVar;
            this.f11022h = windVaneWebView;
            this.f11023i = str2;
            this.f11024j = str4;
            this.f11025k = str3;
            this.f11026l = c0226a;
            this.f11027m = cVar;
            this.f11028n = copyOnWriteArrayList;
            this.f11029o = j2;
            this.f11033s = new Runnable() { // from class: com.anythink.expressad.reward.a.c.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    a.C0226a c0226a2;
                    o.a("WindVaneWebView", "WebView onPageFinish timeout exception after 5s");
                    if (jVar != null && (c0226a2 = c0226a) != null) {
                        c0226a2.a(true);
                        com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("_");
                        sb.append(str2);
                        jVar2.a(str);
                    }
                    a.C0226a c0226a3 = c0226a;
                    if (c0226a3 == null || (windVaneWebViewA = c0226a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception unused) {
                    }
                }
            };
            this.f11032r = new Runnable() { // from class: com.anythink.expressad.reward.a.c.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    a.C0226a c0226a2;
                    o.a("WindVaneWebView", "WebView readyState timeout exception after 5s");
                    if (jVar != null && (c0226a2 = c0226a) != null) {
                        c0226a2.a(true);
                        com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("_");
                        sb.append(str2);
                        jVar2.a(str);
                    }
                    a.C0226a c0226a3 = c0226a;
                    if (c0226a3 == null || (windVaneWebViewA = c0226a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception unused) {
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(this.f11033s, 5000L);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.onPageFinished(webView, str);
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClient preLoadTemplate onPageFinished: ");
            Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.f11033s) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.f11030p) {
                return;
            }
            if (str.contains("wfr=1")) {
                Handler handler3 = this.a;
                if (handler3 != null && (runnable = this.f11032r) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f11024j);
                sb.append("_");
                sb.append(this.f11023i);
                com.anythink.expressad.videocommon.b.l.a().c(this.f11024j + "_" + this.f11020f + "_" + this.f11023i, true);
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                a.C0226a c0226a = this.f11026l;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                if (this.f11018c) {
                    if (this.f11027m.A()) {
                        o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.f11027m.aa(), this.f11026l);
                    } else {
                        o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.f11027m.aa(), this.f11026l);
                    }
                } else if (this.f11027m.A()) {
                    o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.f11027m.aa(), this.f11026l);
                } else {
                    o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.b(94, this.f11027m.aa(), this.f11026l);
                }
                j jVar = this.f11021g;
                if (jVar != null) {
                    jVar.a(this.f11020f);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.f11030p = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClient preLoadTemplate onReceivedError: ".concat(String.valueOf(str)));
            com.anythink.expressad.videocommon.b.l.a().c(this.f11024j + "_" + this.f11020f + "_" + this.f11023i, false);
            Handler handler = this.a;
            if (handler != null) {
                if (this.f11032r != null) {
                    handler.removeCallbacks(this.f11033s);
                }
                Runnable runnable = this.f11032r;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f11024j);
                sb.append("_");
                sb.append(this.f11023i);
                if (this.f11026l != null) {
                    this.f11026l.a(false);
                }
                if (this.f11021g != null) {
                    this.f11021g.a(this.f11020f, str);
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            StringBuilder sb = new StringBuilder("TempalteWindVaneWebviewClient preLoadTemplate onReceivedSslError: ");
            String string = "";
            sb.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
            o.a("WindVaneWebView", sb.toString());
            com.anythink.expressad.videocommon.b.l.a().c(this.f11024j + "_" + this.f11020f + "_" + this.f11023i, false);
            Handler handler = this.a;
            if (handler != null) {
                if (this.f11032r != null) {
                    handler.removeCallbacks(this.f11033s);
                }
                Runnable runnable = this.f11032r;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f11024j);
                sb2.append("_");
                sb2.append(this.f11023i);
                if (this.f11026l != null) {
                    this.f11026l.a(false);
                }
                if (this.f11021g != null) {
                    j jVar = this.f11021g;
                    String str = this.f11020f;
                    if (sslError != null) {
                        string = Integer.toString(sslError.getPrimaryError());
                    }
                    jVar.a(str, string);
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.readyState(webView, i2);
            Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.f11032r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.a;
            if (handler3 != null && (runnable = this.f11033s) != null) {
                handler3.removeCallbacks(runnable);
            }
            if (this.f11031q) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11024j);
            sb.append("_");
            sb.append(this.f11023i);
            if (i2 == 1) {
                o.a("WindVaneWebView", "TempalteWindVaneWebviewClient template 预加载成功 state ：".concat(String.valueOf(i2)));
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.f11024j + "_" + this.f11020f + "_" + this.f11023i, true);
                a.C0226a c0226a = this.f11026l;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                if (this.f11018c) {
                    if (this.f11019e) {
                        o.a("WindVaneWebView", "put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.f11027m.aa(), this.f11026l);
                    } else {
                        o.a("WindVaneWebView", "put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.f11027m.aa(), this.f11026l);
                    }
                } else if (this.f11019e) {
                    o.a("WindVaneWebView", "put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.f11027m.aa(), this.f11026l);
                } else {
                    o.a("WindVaneWebView", "put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.b(94, this.f11027m.aa(), this.f11026l);
                }
                j jVar = this.f11021g;
                if (jVar != null) {
                    jVar.a(this.f11020f);
                }
            } else {
                j jVar2 = this.f11021g;
                if (jVar2 != null) {
                    jVar2.a(this.f11020f, "state ".concat(String.valueOf(i2)));
                }
            }
            this.f11031q = true;
        }
    }

    private static class l extends com.anythink.expressad.atsignalcommon.a.b {
        private String a;
        private final boolean b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindVaneWebView f11044c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f11045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f11046f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a.C0226a f11047g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.anythink.expressad.foundation.d.c f11048h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11049i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f11050j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11051k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f11052l;

        public l(String str, WindVaneWebView windVaneWebView, String str2, String str3, a.C0226a c0226a, com.anythink.expressad.foundation.d.c cVar, boolean z2, String str4) {
            this.f11044c = windVaneWebView;
            this.f11045e = str2;
            this.f11046f = str3;
            this.f11047g = c0226a;
            this.f11048h = cVar;
            this.a = str;
            this.f11049i = z2;
            this.f11050j = str4;
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL init");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL preLoadTemplate onPageFinished: ");
            if (this.f11051k) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.f11044c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11044c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        if (com.anythink.expressad.a.a) {
                            o.d("WindVaneWebView", e2.getLocalizedMessage());
                        }
                    }
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.f11046f + "_" + this.f11050j + "_" + this.f11045e, true);
                a.C0226a c0226a = this.f11047g;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                String str2 = this.f11046f + "_" + this.f11048h.aZ() + "_" + this.f11048h.Z() + "_" + this.f11045e;
                if (this.b) {
                    if (this.f11048h.A()) {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.f11048h.aa(), this.f11047g);
                    } else {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.a(str2, this.f11047g, false, this.f11049i);
                    }
                } else if (this.f11048h.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.f11048h.aa(), this.f11047g);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.a(str2, this.f11047g, false, this.f11049i);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.f11051k = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL preLoadTemplate onReceivedError: ".concat(String.valueOf(str)));
            com.anythink.expressad.videocommon.b.l.a().c(this.f11046f + "_" + this.f11050j + "_" + this.f11045e, false);
            a.C0226a c0226a = this.f11047g;
            if (c0226a != null) {
                c0226a.a(false);
            }
            if (this.f11044c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11044c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        o.d("WindVaneWebView", e2.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            o.a("RewardCampaignsResourceManager_test", "收到大模板 播放模板 readyState 回调: ".concat(String.valueOf(i2)));
            if (this.f11052l) {
                return;
            }
            if (this.f11044c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i2);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11044c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        o.d("WindVaneWebView", e2.getLocalizedMessage());
                    }
                }
            }
            String str = this.f11046f + "_" + this.f11048h.aZ() + "_" + this.f11048h.Z() + "_" + this.f11045e;
            if (i2 == 1) {
                com.anythink.expressad.videocommon.b.l.a().c(this.f11046f + "_" + this.f11050j + "_" + this.f11045e, true);
                a.C0226a c0226a = this.f11047g;
                if (c0226a != null) {
                    c0226a.a(true);
                }
                if (this.b) {
                    if (this.f11048h.A()) {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(str, this.f11047g, false, this.f11049i);
                    } else {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.a(str, this.f11047g, false, this.f11049i);
                    }
                } else if (this.f11048h.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(str, this.f11047g, false, this.f11049i);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.a(str, this.f11047g, false, this.f11049i);
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.f11046f + "_" + this.f11050j + "_" + this.f11045e, false);
                a.C0226a c0226a2 = this.f11047g;
                if (c0226a2 != null) {
                    c0226a2.a(false);
                }
            }
            this.f11052l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class m {
        private static final c a = new c(0);

        private m() {
        }
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private static String c(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(a, "code to string is error");
            return "";
        }
    }

    private synchronized WindVaneWebView d() {
        return null;
    }

    private c() {
        this.f10942t = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f10925d = new HashMap();
        handlerThread.start();
        this.b = new h(handlerThread.getLooper());
        this.f10940c = new ConcurrentHashMap<>();
    }

    public static c a() {
        return m.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String b(int i2) {
        return i2 != 200 ? i2 != 201 ? i2 != 203 ? i2 != 205 ? "unknown" : "tpl" : "temp" : "zip/html" : "video";
    }

    public final synchronized void a(final Context context, boolean z2, int i2, boolean z3, final int i3, final String str, final String str2, final String str3, final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, InterfaceC0212c interfaceC0212c, final i iVar) {
        String str4 = str2 + "_" + str3;
        f10925d.put(str4, new a(z2, z3, i2, copyOnWriteArrayList.size(), str2, str3, i3, copyOnWriteArrayList));
        this.b.a(str2, str3, interfaceC0212c);
        this.b.a(context);
        this.b.a(str4, copyOnWriteArrayList);
        this.b.post(new Runnable() { // from class: com.anythink.expressad.reward.a.c.1
            /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x017b  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x01b4  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x01e5  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 740
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.c.AnonymousClass1.run():void");
            }
        });
    }

    private synchronized void c() {
    }

    private static final class e implements com.anythink.expressad.foundation.g.d.c {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f10995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f10996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10997e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f10998f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f10999g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11000h;

        public e(Handler handler, int i2, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar) {
            this.f10995c = handler;
            this.f10996d = i2;
            this.f10998f = str;
            this.f10997e = str2;
            this.f10999g = str3;
            this.f11000h = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            com.anythink.expressad.videocommon.b.l.a();
            com.anythink.expressad.videocommon.b.l.c(str);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f10996d == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.f10997e);
            bundle.putString(com.anythink.expressad.a.f7981y, this.f10998f);
            bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10999g);
            messageObtain.setData(bundle);
            this.f10995c.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f10996d == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.f10997e);
            bundle.putString(com.anythink.expressad.a.f7981y, this.f10998f);
            bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f10999g);
            messageObtain.setData(bundle);
            this.f10995c.sendMessage(messageObtain);
        }
    }

    private static final class f implements com.anythink.expressad.videocommon.d.b {
        private Handler a;
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11002d;

        public f(Handler handler, String str, String str2, String str3) {
            this.a = handler;
            this.f11001c = str;
            this.b = str2;
            this.f11002d = str3;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            o.d(c.a, "Video 下载成功: " + this.f11002d);
            com.anythink.expressad.videocommon.b.l.a().a(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.f7981y, this.f11001c);
            bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11002d);
            bundle.putString("url", str);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            o.d(c.a, "Video 下载失败： " + str + " " + this.f11002d);
            com.anythink.expressad.videocommon.b.l.a().a(str2, false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.f7981y, this.f11001c);
            bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f11002d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
        }
    }

    private void a(Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, String str4, i iVar, List<com.anythink.expressad.foundation.d.c> list) {
        if (TextUtils.isEmpty(str4) || cVar.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean zIsEmpty = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                g gVar = new g(context, str, str2, str3, cVar, 497, this.b, iVar, list);
                gVar.a(zIsEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (i.a) gVar);
                return;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d(a, e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            d dVar = new d(497, str, str2, str3, cVar, iVar, this.b, list);
            dVar.a(zIsEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                o.d(a, e3.getLocalizedMessage());
            }
        }
    }

    public final synchronized void a(Context context, com.anythink.expressad.foundation.d.c cVar, final String str, final String str2, final String str3, final i iVar) {
        this.b.a(context);
        if (cVar != null) {
            String strAr = cVar.ar();
            if (cVar.j()) {
                com.anythink.expressad.videocommon.b.l.a().b(strAr, true);
                Message messageObtain = Message.obtain();
                messageObtain.what = 105;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", str2);
                bundle.putString(com.anythink.expressad.a.f7981y, str);
                bundle.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, str3);
                bundle.putString("url", strAr);
                messageObtain.setData(bundle);
                this.b.sendMessage(messageObtain);
                iVar.a(str, str2, str3);
                return;
            }
        }
        if (cVar != null && !TextUtils.isEmpty(cVar.ar())) {
            try {
                com.anythink.expressad.videocommon.b.i.a().b(cVar.ar(), (i.a) new i.d() { // from class: com.anythink.expressad.reward.a.c.2
                    @Override // com.anythink.expressad.videocommon.b.i.a
                    public final void a(String str4) {
                        try {
                            o.a(c.a, "zip btl template download success");
                            com.anythink.expressad.videocommon.b.l.a().b(str4, true);
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.what = 105;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("unit_id", str2);
                            bundle2.putString(com.anythink.expressad.a.f7981y, str);
                            bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, str3);
                            bundle2.putString("url", str4);
                            messageObtain2.setData(bundle2);
                            c.this.b.sendMessage(messageObtain2);
                            if (iVar != null) {
                                iVar.a(str, str2, str3);
                            }
                        } catch (Exception e2) {
                            com.anythink.expressad.videocommon.b.l.a().b(str4, false);
                            Message messageObtain3 = Message.obtain();
                            messageObtain3.what = 205;
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("unit_id", str2);
                            bundle3.putString(com.anythink.expressad.a.f7981y, str);
                            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, str3);
                            bundle3.putString("url", str4);
                            messageObtain3.setData(bundle3);
                            c.this.b.sendMessage(messageObtain3);
                            i iVar2 = iVar;
                            if (iVar2 != null) {
                                String str5 = str2;
                                String str6 = str3;
                                e2.getLocalizedMessage();
                                iVar2.a(str5, str6);
                            }
                        }
                    }

                    @Override // com.anythink.expressad.videocommon.b.i.a
                    public final void a(String str4, String str5) {
                        o.a(c.a, "zip btl template download failed");
                        try {
                            com.anythink.expressad.videocommon.b.l.a().b(str5, false);
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.what = 205;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("unit_id", str2);
                            bundle2.putString(com.anythink.expressad.a.f7981y, str);
                            bundle2.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, str3);
                            bundle2.putString("url", str5);
                            bundle2.putString("message", str4);
                            messageObtain2.setData(bundle2);
                            c.this.b.sendMessage(messageObtain2);
                            if (iVar != null) {
                                iVar.a(str2, str3);
                            }
                        } catch (Exception e2) {
                            com.anythink.expressad.videocommon.b.l.a().b(str5, false);
                            Message messageObtain3 = Message.obtain();
                            messageObtain3.what = 105;
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("unit_id", str2);
                            bundle3.putString(com.anythink.expressad.a.f7981y, str);
                            bundle3.putString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, str3);
                            bundle3.putString("url", str5);
                            bundle3.putString("message", e2.getMessage());
                            messageObtain3.setData(bundle3);
                            c.this.b.sendMessage(messageObtain3);
                            i iVar2 = iVar;
                            if (iVar2 != null) {
                                iVar2.a(str2, str3);
                            }
                            if (com.anythink.expressad.a.a) {
                                o.d(c.a, e2.getLocalizedMessage());
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d(a, e2.getLocalizedMessage());
                }
            }
        }
    }

    public final synchronized void a(boolean z2, Handler handler, boolean z3, boolean z4, WindVaneWebView windVaneWebView, String str, int i2, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, String str2, String str3, String str4, String str5, com.anythink.expressad.videocommon.e.d dVar, j jVar) {
        String str6;
        WindVaneWebView windVaneWebView2;
        com.anythink.expressad.video.signal.a.j jVar2;
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append("_");
        sb.append(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (t.e(str)) {
                jVar.a(str5);
                return;
            }
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebViewD = m.a.d();
            if (windVaneWebViewD == null) {
                try {
                    windVaneWebView2 = new WindVaneWebView(n.a().g());
                } catch (Exception unused) {
                    c0226a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str5 + "_" + str, true);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append("_");
                    sb2.append(str);
                    jVar.a(str5);
                    return;
                } catch (Throwable unused2) {
                    c0226a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str5 + "_" + str, true);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str4);
                    sb3.append("_");
                    sb3.append(str);
                    jVar.a(str5);
                    return;
                }
            } else {
                windVaneWebView2 = windVaneWebViewD;
            }
            c0226a.a(windVaneWebView2);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
            } else {
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar3 = jVar2;
            jVar3.a(i2);
            jVar3.a(str4);
            jVar3.a(dVar);
            jVar3.b(z2);
            WindVaneWebView windVaneWebView3 = windVaneWebView2;
            try {
                windVaneWebView3.setWebViewListener(new k(handler, null, z3, z4, str5, jVar, windVaneWebView, str, str3, str4, c0226a, cVar, copyOnWriteArrayList, jCurrentTimeMillis));
                windVaneWebView3.setObject(jVar3);
                windVaneWebView3.loadUrl(str2);
                str6 = str5;
                try {
                    windVaneWebView3.setRid(str6);
                } catch (Exception e2) {
                    e = e2;
                    if (com.anythink.expressad.a.a) {
                        o.d(a, e.getLocalizedMessage());
                    }
                    jVar.a(str6, e.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                str6 = str5;
            }
        } catch (Exception e4) {
            e = e4;
            str6 = str5;
        }
    }

    public final synchronized void a(boolean z2, Handler handler, boolean z3, boolean z4, String str, String str2, String str3, String str4, int i2, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, String str5, String str6, com.anythink.expressad.videocommon.e.d dVar, j jVar) {
        String str7;
        com.anythink.expressad.video.signal.a.j jVar2;
        this.f10941e = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append("_");
        sb.append(str4);
        this.f10941e = false;
        if (t.e(str4)) {
            jVar.a(str);
            return;
        }
        try {
            o.a(a, "开始预加载大模板资源");
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebViewD = m.a.d();
            if (windVaneWebViewD == null) {
                windVaneWebViewD = new WindVaneWebView(n.a().g());
            }
            WindVaneWebView windVaneWebView = windVaneWebViewD;
            c0226a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            String strB = com.anythink.expressad.video.bt.a.c.b();
            com.anythink.expressad.video.bt.a.c.a();
            String strB2 = com.anythink.expressad.video.bt.a.c.b();
            c0226a.a(strB2);
            o.a(a, "preload BT wraper.setTag ".concat(String.valueOf(strB2)));
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                List<com.anythink.expressad.foundation.d.c> listA = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (listA != null && listA.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        com.anythink.expressad.foundation.d.c cVar2 = copyOnWriteArrayList.get(i3);
                        for (com.anythink.expressad.foundation.d.c cVar3 : listA) {
                            List<com.anythink.expressad.foundation.d.c> list = listA;
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                o.a(a, "设置 Campaign 的 isReady： true");
                                cVar2.au();
                                copyOnWriteArrayList.set(i3, cVar2);
                            }
                            listA = list;
                        }
                    }
                }
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
            } else {
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar);
            }
            com.anythink.expressad.video.signal.a.j jVar3 = jVar2;
            jVar3.a(i2);
            jVar3.a(str6);
            jVar3.c(strB2);
            jVar3.d(strB);
            jVar3.p();
            jVar3.a(dVar);
            jVar3.b(z2);
            try {
                windVaneWebView.setWebViewListener(new b(z2, handler, null, z3, z4, i2, str4, str2, str3, str, c0226a, cVar, copyOnWriteArrayList, dVar, jVar, jCurrentTimeMillis));
                windVaneWebView.setObject(jVar3);
                windVaneWebView.loadUrl(str5);
                str7 = str;
                try {
                    windVaneWebView.setRid(str7);
                    AnythinkBTRootLayout anythinkBTRootLayout = new AnythinkBTRootLayout(n.a().g());
                    anythinkBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    anythinkBTRootLayout.setInstanceId(strB);
                    anythinkBTRootLayout.setUnitId(str3);
                    AnythinkBTLayout anythinkBTLayout = new AnythinkBTLayout(n.a().g());
                    anythinkBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    anythinkBTLayout.setInstanceId(strB2);
                    anythinkBTLayout.setUnitId(str3);
                    anythinkBTLayout.setWebView(windVaneWebView);
                    LinkedHashMap<String, View> linkedHashMapB = com.anythink.expressad.video.bt.a.c.a().b(str3, str7);
                    linkedHashMapB.put(strB2, anythinkBTLayout);
                    linkedHashMapB.put(strB, anythinkBTRootLayout);
                    anythinkBTRootLayout.addView(anythinkBTLayout, new FrameLayout.LayoutParams(-1, -1));
                } catch (Exception e2) {
                    e = e2;
                    jVar.a(str7, e.getMessage());
                    if (com.anythink.expressad.a.a) {
                        o.d(a, e.getLocalizedMessage());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str7 = str;
            }
        } catch (Exception e4) {
            e = e4;
            str7 = str;
        }
    }

    private void a(boolean z2, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar != null && dVar != null && cVar.M() != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(cVar.M().e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", str2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "data is null");
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } catch (Exception e2) {
                        if (com.anythink.expressad.a.a) {
                            o.d(a, e2.getLocalizedMessage());
                            return;
                        }
                        return;
                    }
                }
                if (!TextUtils.isEmpty(cVar.M().e()) && cVar.M().e().contains(com.anythink.expressad.foundation.d.c.f10153d)) {
                    o.a(a, "getTeamplateUrl contains cmpt=1");
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(z2, windVaneWebView, cVar, list, str, dVar, str2), i2 * 1000);
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", str2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", 2);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    o.d(a, e3.getLocalizedMessage());
                }
            }
        }
    }

    private static void a(boolean z2, WindVaneWebView windVaneWebView, String str, int i2, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, String str4, boolean z3) {
        com.anythink.expressad.video.signal.a.j jVar;
        String strZ;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebViewD = m.a.d();
            if (windVaneWebViewD == null) {
                windVaneWebViewD = new WindVaneWebView(n.a().g());
            }
            WindVaneWebView windVaneWebView2 = windVaneWebViewD;
            c0226a.a(windVaneWebView2);
            if (list != null && list.size() > 0) {
                List<com.anythink.expressad.foundation.d.c> listA = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (listA != null && listA.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        com.anythink.expressad.foundation.d.c cVar2 = list.get(i3);
                        for (com.anythink.expressad.foundation.d.c cVar3 : listA) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i3, cVar2);
                            }
                        }
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                strZ = list.get(0).Z();
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                strZ = cVar.Z();
            }
            String str5 = strZ;
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(i2);
            jVar2.a(str3);
            jVar2.c(str4);
            jVar2.a(dVar);
            jVar2.b(z2);
            windVaneWebView2.setWebViewListener(new l(str4, windVaneWebView, str, str3, c0226a, cVar, z3, str5));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                o.d(a, e2.getLocalizedMessage());
            }
        }
    }

    static /* synthetic */ void a(c cVar, Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar2, String str4, i iVar, List list) {
        if (TextUtils.isEmpty(str4) || cVar2.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean zIsEmpty = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                g gVar = new g(context, str, str2, str3, cVar2, 497, cVar.b, iVar, list);
                gVar.a(zIsEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (i.a) gVar);
                return;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    o.d(a, e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            d dVar = new d(497, str, str2, str3, cVar2, iVar, cVar.b, list);
            dVar.a(zIsEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                o.d(a, e3.getLocalizedMessage());
            }
        }
    }

    private static /* synthetic */ void a(c cVar, boolean z2, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar2, List list, com.anythink.expressad.videocommon.e.d dVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar2 != null && dVar != null && cVar2.M() != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(cVar2.M().e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", str2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "data is null");
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } catch (Exception e2) {
                        if (com.anythink.expressad.a.a) {
                            o.d(a, e2.getLocalizedMessage());
                            return;
                        }
                        return;
                    }
                }
                if (!TextUtils.isEmpty(cVar2.M().e()) && cVar2.M().e().contains(com.anythink.expressad.foundation.d.c.f10153d)) {
                    o.a(a, "getTeamplateUrl contains cmpt=1");
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(cVar.new AnonymousClass3(z2, windVaneWebView, cVar2, list, str, dVar, str2), i2 * 1000);
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", str2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", 2);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (Exception e3) {
                if (com.anythink.expressad.a.a) {
                    o.d(a, e3.getLocalizedMessage());
                }
            }
        }
    }

    static /* synthetic */ void a(boolean z2, WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, String str4, boolean z3) {
        com.anythink.expressad.video.signal.a.j jVar;
        String strZ;
        try {
            a.C0226a c0226a = new a.C0226a();
            WindVaneWebView windVaneWebViewD = m.a.d();
            if (windVaneWebViewD == null) {
                windVaneWebViewD = new WindVaneWebView(n.a().g());
            }
            WindVaneWebView windVaneWebView2 = windVaneWebViewD;
            c0226a.a(windVaneWebView2);
            if (list != null && list.size() > 0) {
                List<com.anythink.expressad.foundation.d.c> listA = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (listA != null && listA.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) list.get(i2);
                        for (com.anythink.expressad.foundation.d.c cVar3 : listA) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i2, cVar2);
                            }
                        }
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                strZ = ((com.anythink.expressad.foundation.d.c) list.get(0)).Z();
            } else {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                strZ = cVar.Z();
            }
            String str5 = strZ;
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(0);
            jVar2.a(str3);
            jVar2.c(str4);
            jVar2.a(dVar);
            jVar2.b(z2);
            windVaneWebView2.setWebViewListener(new l(str4, windVaneWebView, str, str3, c0226a, cVar, z3, str5));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                o.d(a, e2.getLocalizedMessage());
            }
        }
    }
}
