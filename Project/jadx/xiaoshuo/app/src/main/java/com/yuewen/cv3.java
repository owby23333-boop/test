package com.yuewen;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class cv3 {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
