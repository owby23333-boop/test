package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static g aI(Context context) {
        boolean zCy = ak.cy(context);
        com.kwad.sdk.core.d.b.d("InfoCollector", "queryAccessibilityServicePermission result: " + zCy);
        return new g(com.kuaishou.weapon.p0.g.f16731k, zCy ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> aJ(Context context) {
        String[] strArrCx;
        ArrayList arrayList = new ArrayList();
        if (context != null && (strArrCx = ai.cx(context)) != null) {
            for (String str : strArrCx) {
                int iAl = ak.al(context, str);
                arrayList.add(new g(str, iAl == 0 ? g.PERMISSION_GRANTED : iAl == -1 ? g.PERMISSION_DENIED : g.aaP));
            }
        }
        return arrayList;
    }

    @Nullable
    public static JSONArray tR() {
        Context context = ServiceProvider.getContext();
        List<g> listAJ = aJ(context);
        listAJ.add(aI(context));
        return g.m(listAJ);
    }
}
