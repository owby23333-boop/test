package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f12306c;
    String a = "InterstitialAuto";
    ATInterstitialAutoLoadListener b = new ATInterstitialAutoLoadListener() { // from class: com.anythink.interstitial.a.b.1
        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoadFail(final String str, final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.b.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.f12307d != null) {
                        b.this.f12307d.onInterstitialAutoLoadFail(str, adError);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoaded(final String str) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.f12307d != null) {
                        b.this.f12307d.onInterstitialAutoLoaded(str);
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ATInterstitialAutoLoadListener f12307d;

    public static void b(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                v.a().a(str, false);
                a.a(n.a().g(), str).k();
            }
        }
    }

    public static List<ATAdInfo> c(String str) {
        a aVarA = a.a(n.a().E(), str);
        if (aVarA != null) {
            return aVarA.a(n.a().E());
        }
        return null;
    }

    private ATAdStatusInfo d(String str) {
        a aVarA;
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q()) || (aVarA = a.a(n.a().E(), str)) == null) {
            return null;
        }
        return aVarA.a(n.a().E(), (Map<String, Object>) null);
    }

    public static b a() {
        if (f12306c == null) {
            synchronized (b.class) {
                if (f12306c == null) {
                    f12306c = new b();
                }
            }
        }
        return f12306c;
    }

    public final ATAdStatusInfo b(String str) {
        ATAdStatusInfo aTAdStatusInfo;
        if (TextUtils.isEmpty(str) || (aTAdStatusInfo = d(str)) == null) {
            aTAdStatusInfo = new ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.k.n.b(str, g.i.f6868n, g.i.f6875u, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }

    public final void a(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        if (context instanceof Activity) {
            n.a().a((Activity) context);
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (!v.a().f(str)) {
                    v.a().a(str, true);
                    a.a(context, str).a(context, 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        this.f12307d = aTInterstitialAutoLoadListener;
    }

    private ATInterstitialAutoLoadListener b() {
        return this.b;
    }

    public static void a(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && !v.a().f(str)) {
                v.a().a(str, true);
                a.a(n.a().E(), str).a(n.a().E(), 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
            }
        }
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v.a().a(str, map);
    }

    private void a(Activity activity, String str, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        a(activity, str, "", aTInterstitialAutoEventListener);
    }

    public final void a(Activity activity, String str, String str2, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        com.anythink.core.common.k.n.b(str, g.i.f6868n, g.i.f6873s, g.i.f6862h, "");
        if (TextUtils.isEmpty(str) || n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            return;
        }
        a.a(activity, str).a(activity, str2, new c(aTInterstitialAutoEventListener), (ATEventInterface) null, (Map<String, Object>) null);
    }

    public final boolean a(String str) {
        boolean zIsReady = false;
        if (!TextUtils.isEmpty(str)) {
            ATAdStatusInfo aTAdStatusInfoD = d(str);
            if (aTAdStatusInfoD == null) {
                return false;
            }
            zIsReady = aTAdStatusInfoD.isReady();
        }
        com.anythink.core.common.k.n.b(str, g.i.f6868n, g.i.f6874t, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a().a(str, str2, "3", map);
    }
}
