package com.kwad.components.core.g;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private Object JS;
    private AdTemplate JT;

    public c(@NonNull AdTemplate adTemplate, int i2) {
        this.JS = null;
        try {
            this.JS = new b(adTemplate, i2);
        } catch (Throwable unused) {
            this.JT = adTemplate;
        }
    }

    public static List<AdTemplate> k(List<c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdTemplate());
        }
        return arrayList;
    }

    public final AdTemplate getAdTemplate() {
        AdTemplate adTemplate;
        Object obj = this.JS;
        if (obj != null) {
            try {
                adTemplate = ((b) obj).getAdTemplate();
            } catch (Exception unused) {
                adTemplate = null;
            }
        } else {
            adTemplate = null;
        }
        return adTemplate == null ? this.JT : adTemplate;
    }

    public final Object getHost() {
        return this.JS;
    }
}
