package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.sdk.utils.bq;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ISystemProperties {
    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final String get(String str, String str2) {
        return bq.get(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final int getInt(String str, int i) {
        return bq.getInt(str, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final long getLong(String str, long j) {
        return bq.getLong(str, j);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final boolean getBoolean(String str, boolean z) {
        return bq.getBoolean(str, z);
    }
}
