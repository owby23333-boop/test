package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class p<T extends f> implements n<T> {
    private final Map<String, T> aih = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.n
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void e(@NonNull T t2) {
        this.aih.put(t2.actionId, t2);
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized void q(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.aih.remove(it.next().actionId);
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized long size() {
        int size;
        size = this.aih.size();
        com.kwad.sdk.core.d.b.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized List<T> xh() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.aih.size());
        Iterator<Map.Entry<String, T>> it = this.aih.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }
}
