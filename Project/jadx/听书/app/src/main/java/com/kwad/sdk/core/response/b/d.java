package com.kwad.sdk.core.response.b;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static long dX(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eb(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dY(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eb(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dZ(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eb(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean ea(AdTemplate adTemplate) {
        if (adTemplate != null && e.ed(adTemplate)) {
            return eb(adTemplate).slideClick;
        }
        return false;
    }

    private static AdStyleInfo eb(AdTemplate adTemplate) {
        return e.el(adTemplate).adStyleInfo;
    }

    public static List<String> ec(AdTemplate adTemplate) {
        AdStyleInfo adStyleInfoEb = eb(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = adStyleInfoEb.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
