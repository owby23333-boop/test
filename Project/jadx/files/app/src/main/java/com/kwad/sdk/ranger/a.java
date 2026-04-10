package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.ranger.c;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.x;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    static void a(Activity activity, @NonNull List<c.a> list) {
        try {
            for (c.a aVar : list) {
                if (aVar != null) {
                    String strC = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.axp)) {
                        strC = aVar.axp;
                    } else if (!TextUtils.isEmpty(aVar.axq) && activity.getClass().getName().startsWith(aVar.axp)) {
                        strC = c(activity, aVar.axq);
                    }
                    if (!TextUtils.isEmpty(strC)) {
                        int iC = x.c("ksadsdk_perf_ranger", strC, 0) + 1;
                        x.b("ksadsdk_perf_ranger", strC, iC);
                        com.kwad.sdk.core.d.b.d("Ranger_act", "act:" + strC + " num:" + iC);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("Ranger_act", "record:" + Log.getStackTraceString(th));
        }
    }

    static void a(@NonNull c cVar) {
        final List<c.a> list = cVar.axm;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kwad.sdk.ranger.a.1
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                super.onActivityCreated(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.e("Ranger_act", Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String c(Object obj, String str) {
        Object objD;
        return (TextUtils.isEmpty(str) || (objD = r.d(obj, str)) == null) ? "" : objD.getClass().getName();
    }
}
