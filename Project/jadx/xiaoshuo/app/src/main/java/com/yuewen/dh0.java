package com.yuewen;

import android.util.LongSparseArray;
import com.duokan.reader.domain.document.epub.EpubCharAnchor;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class dh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<Integer> f10158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<EpubCharAnchor, Integer> f10159b;

    public dh0(LongSparseArray<Integer> longSparseArray, LinkedHashMap<EpubCharAnchor, Integer> linkedHashMap) {
        this.f10158a = longSparseArray;
        this.f10159b = linkedHashMap;
    }

    public int a() {
        int iIntValue = 0;
        for (int i = 0; i < this.f10158a.size(); i++) {
            iIntValue += this.f10158a.valueAt(i).intValue();
        }
        Iterator<EpubCharAnchor> it = this.f10159b.keySet().iterator();
        while (it.hasNext()) {
            iIntValue += this.f10159b.get(it.next()).intValue();
        }
        return iIntValue;
    }

    public int b(EpubCharAnchor epubCharAnchor, EpubCharAnchor epubCharAnchor2) {
        int iIntValue = 0;
        for (EpubCharAnchor epubCharAnchor3 : this.f10159b.keySet()) {
            try {
                if (!epubCharAnchor3.isBeforeOrEqual(epubCharAnchor) && !epubCharAnchor3.isAfter(epubCharAnchor2)) {
                    iIntValue += this.f10159b.get(epubCharAnchor3).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return iIntValue;
    }

    public int c(long j) {
        if (j < 0) {
            return 0;
        }
        return this.f10158a.get(j, 0).intValue();
    }

    public boolean d(dh0 dh0Var) {
        return dh0Var.f10159b.equals(this.f10159b);
    }

    public boolean e(dh0 dh0Var) {
        if (dh0Var.f10158a.size() != this.f10158a.size()) {
            return false;
        }
        for (int i = 0; i < dh0Var.f10158a.size(); i++) {
            int iIntValue = this.f10158a.get(dh0Var.f10158a.keyAt(i), -1).intValue();
            if (iIntValue == -1 || iIntValue != dh0Var.f10158a.valueAt(i).intValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dh0)) {
            return false;
        }
        dh0 dh0Var = (dh0) obj;
        return e(dh0Var) && d(dh0Var);
    }

    public void f(EpubCharAnchor epubCharAnchor, int i) {
        this.f10159b.put(epubCharAnchor, Integer.valueOf(i));
    }

    public void g(long j, int i) {
        this.f10158a.put(j, Integer.valueOf(i));
    }
}
