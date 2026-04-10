package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import android.util.LruCache;
import com.xiaomi.onetrack.util.k;

/* JADX INFO: loaded from: classes8.dex */
class l extends LruCache<String, k.a> {
    public l(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, k.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f7716a)) {
            return 0;
        }
        return aVar.f7716a.length();
    }
}
