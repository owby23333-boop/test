package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static JSONArray DI() {
        Context context = ServiceProvider.getContext();
        List<g> listBl = bl(context);
        listBl.add(bk(context));
        return g.w(listBl);
    }

    private static g bk(Context context) {
        boolean zDk = au.dk(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + zDk);
        return new g(com.kuaishou.weapon.p0.g.k, zDk ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    private static List<g> bl(Context context) {
        String[] strArrCN;
        int i;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (strArrCN = y.cN(context)) != null) {
            for (String str : strArrCN) {
                int iAt = au.at(context, str);
                if (iAt == 0) {
                    i = g.PERMISSION_GRANTED;
                } else if (iAt == -1) {
                    i = g.PERMISSION_DENIED;
                } else {
                    i = g.avh;
                }
                copyOnWriteArrayList.add(new g(str, i));
            }
        }
        return copyOnWriteArrayList;
    }
}
