package com.duokan.reader.common.cache;

import android.text.TextUtils;
import com.duokan.reader.common.cache.ListCache;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ListCache.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4003a = new c();

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
