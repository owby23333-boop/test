package com.anythink.expressad.splash.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.c.e;
import com.anythink.expressad.splash.view.ATSplashView;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static String a = "ResManager";
    private static int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f11257c = new ConcurrentHashMap<>();

    private static String b(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e2) {
                e2.getMessage();
                return "";
            }
        }
    }

    private static com.anythink.expressad.foundation.d.c a(com.anythink.expressad.foundation.d.c cVar) {
        if (!TextUtils.isEmpty(cVar.c()) || (!TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
        } else {
            cVar.a(false);
            cVar.b(true);
        }
        return cVar;
    }

    public static void a(final ATSplashView aTSplashView, final com.anythink.expressad.foundation.d.c cVar, final com.anythink.expressad.splash.view.a aVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.c.b.1
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str) {
                b.f11257c.put(cVar.be(), Boolean.TRUE);
                com.anythink.expressad.splash.view.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
                ATSplashView aTSplashView2 = aTSplashView;
                if (aTSplashView2 != null) {
                    aTSplashView2.setImageReady(true);
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str, String str2) {
                b.f11257c.put(cVar.be(), Boolean.FALSE);
                com.anythink.expressad.splash.view.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                ATSplashView aTSplashView2 = aTSplashView;
                if (aTSplashView2 != null) {
                    aTSplashView2.setImageReady(false);
                }
            }
        });
        if (TextUtils.isEmpty(cVar.bd())) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.bd(), new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.c.b.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str) {
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str, String str2) {
            }
        });
    }

    private static void a(ATSplashView aTSplashView, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, boolean z2, int i2, boolean z3) {
        e.c cVar2 = new e.c();
        cVar2.c(str3);
        cVar2.b(str2);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(z2);
        cVar2.a(i2);
        cVar2.a(z3);
        e.a.a.a(aTSplashView, cVar2, null);
    }

    public static boolean a(ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar) {
        if (aTSplashView == null) {
            o.d(a, "mbSplashView  is null");
            return false;
        }
        boolean zIsImageReady = true;
        if (!TextUtils.isEmpty(cVar.S())) {
            zIsImageReady = aTSplashView.isVideoReady();
            o.d(a, "======isReady isVideoReady:".concat(String.valueOf(zIsImageReady)));
        }
        if (zIsImageReady && !TextUtils.isEmpty(cVar.c())) {
            zIsImageReady = aTSplashView.isH5Ready();
            o.d(a, "======isReady getAdZip:".concat(String.valueOf(zIsImageReady)));
        }
        if (zIsImageReady && TextUtils.isEmpty(cVar.c()) && !TextUtils.isEmpty(cVar.d())) {
            zIsImageReady = aTSplashView.isH5Ready();
            o.d(a, "======isReady getAdHtml:".concat(String.valueOf(zIsImageReady)));
        }
        if (TextUtils.isEmpty(cVar.c()) && TextUtils.isEmpty(cVar.d())) {
            o.d(a, "======isReady getAdHtml  getAdZip all are empty");
            zIsImageReady = false;
        }
        if (cVar.j()) {
            zIsImageReady = !TextUtils.isEmpty(cVar.be()) ? aTSplashView.isImageReady() : false;
            o.d(a, "======isReady DYNAMIC VIEW and image state is : ".concat(String.valueOf(zIsImageReady)));
        }
        return zIsImageReady;
    }

    public static void a(String str) {
        f11257c.remove(str);
    }
}
