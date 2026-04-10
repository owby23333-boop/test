package com.anythink.expressad.video.dynview.i;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.k.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static boolean a(List<com.anythink.expressad.foundation.d.c> list) {
        com.anythink.expressad.foundation.d.c cVar;
        if (list == null || list.size() <= 0 || (cVar = list.get(0)) == null) {
            return false;
        }
        return cVar.j();
    }

    private static int b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.M() == null) {
            return 1;
        }
        return cVar.M().c();
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar, Activity activity) {
        if (cVar == null || cVar.M() == null) {
            return;
        }
        int iC = cVar.M().c();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (iC == 1) {
            activity.setRequestedOrientation(7);
            return;
        }
        if (iC != 2) {
            if (a((Context) activity)) {
                activity.setRequestedOrientation(6);
                return;
            } else {
                activity.setRequestedOrientation(7);
                return;
            }
        }
        activity.setRequestedOrientation(6);
    }

    private static void a(Activity activity) {
        if (a((Context) activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private static String a(long j2, Context context) {
        String strF = d.f(context);
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
            if (!strF.contains(com.anythink.expressad.video.dynview.a.a.ad) && !strF.contains(com.anythink.expressad.video.dynview.a.a.ae)) {
                return j2 + com.anythink.expressad.video.dynview.a.a.F;
            }
            return j2 + com.anythink.expressad.video.dynview.a.a.G;
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
            return j2 + com.anythink.expressad.video.dynview.a.a.I;
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.X)) {
            return com.anythink.expressad.video.dynview.a.a.J + j2 + " Sekunden";
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.Y)) {
            return j2 + com.anythink.expressad.video.dynview.a.a.K;
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.Z)) {
            return com.anythink.expressad.video.dynview.a.a.L + j2 + " secondes";
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.aa)) {
            return " ثوان" + j2 + com.anythink.expressad.video.dynview.a.a.M;
        }
        if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.ab)) {
            return com.anythink.expressad.video.dynview.a.a.N + j2 + " секунд";
        }
        return com.anythink.expressad.video.dynview.a.a.H + j2 + " s";
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int a(com.anythink.expressad.foundation.d.c cVar) {
        int iB;
        if (cVar != null && cVar.M() != null && (iB = cVar.M().b()) != 102 && iB != 202) {
            if (iB == 302 || iB == 802) {
                return -3;
            }
            if (iB == 904) {
                return !a(cVar.M().e()) ? -1 : -3;
            }
        }
        return 100;
    }
}
