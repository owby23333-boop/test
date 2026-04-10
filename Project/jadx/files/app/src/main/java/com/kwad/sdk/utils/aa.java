package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: classes3.dex */
public final class aa {
    @WorkerThread
    public static String a(Context context, String str, ab.a aVar, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strAg = ab.ag(context, ab.a(str, aVar));
        String strCD = at.cD(context);
        if (!TextUtils.isEmpty(strCD)) {
            strAg = strAg.replace("__MAC__", strCD).replace("__MAC2__", ac.el(strCD)).replace("__MAC3__", ac.el(strCD.replace(":", "")));
        }
        String strCB = at.cB(context);
        if (!TextUtils.isEmpty(strCB)) {
            strAg = strAg.replace("__IMEI__", strCB).replace("__IMEI2__", ac.el(strCB)).replace("__IMEI3__", ac.em(strCB));
        }
        String oaid = at.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            strAg = strAg.replace("__OAID__", oaid).replace("__OAID2__", ac.el(oaid));
        }
        String strCC = at.cC(context);
        if (!TextUtils.isEmpty(strCC)) {
            strAg = strAg.replace("__ANDROIDID2__", ac.el(strCC)).replace("__ANDROIDID3__", ac.em(strCC)).replace("__ANDROIDID__", strCC);
        }
        return ab.c(context, strAg, z2);
    }
}
