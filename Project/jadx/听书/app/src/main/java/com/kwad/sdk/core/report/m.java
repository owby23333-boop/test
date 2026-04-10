package com.kwad.sdk.core.report;

import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> aGD = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void l(T t) {
        this.aGD.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.aGD.size();
        com.kwad.sdk.core.d.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final List<T> dE(int i) {
        ArrayList arrayList = new ArrayList(this.aGD.size());
        synchronized (this.aGD) {
            Iterator<Map.Entry<String, T>> it = this.aGD.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.aGD.remove(t.actionId);
            }
        }
    }
}
