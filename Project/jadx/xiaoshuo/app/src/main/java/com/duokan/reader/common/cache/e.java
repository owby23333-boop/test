package com.duokan.reader.common.cache;

import com.duokan.reader.common.cache.ListCache;
import com.duokan.reader.common.cache.f;

/* JADX INFO: loaded from: classes2.dex */
public class e<TInfo, TItem, TItemJson> extends ListCache<TInfo, TItem, TItemJson, f.a<TItem>, f.b<TItem>> {
    public e(String str, ListCache.c<TItemJson> cVar, ListCache.g<TInfo, TItem, TItemJson> gVar, int i) {
        this(str, cVar, gVar, null, i);
    }

    public e(String str, ListCache.c<TItemJson> cVar, ListCache.g<TInfo, TItem, TItemJson> gVar, f.b<TItem> bVar, int i) {
        super(str, cVar, gVar, bVar, new g(gVar), i);
    }
}
