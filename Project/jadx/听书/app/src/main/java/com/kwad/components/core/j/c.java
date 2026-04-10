package com.kwad.components.core.j;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private Object Rf;
    private AdTemplate Rg;

    public static List<AdTemplate> n(List<c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdTemplate());
        }
        return arrayList;
    }

    public c(AdTemplate adTemplate, int i) {
        this.Rf = null;
        try {
            this.Rf = new b(adTemplate, i);
        } catch (Throwable unused) {
            this.Rg = adTemplate;
        }
    }

    public final Object getHost() {
        return this.Rf;
    }

    public final AdTemplate getAdTemplate() {
        AdTemplate adTemplate;
        Object obj = this.Rf;
        if (obj != null) {
            try {
                adTemplate = ((b) obj).getAdTemplate();
            } catch (Exception unused) {
                adTemplate = null;
            }
        } else {
            adTemplate = null;
        }
        return adTemplate == null ? this.Rg : adTemplate;
    }
}
