package com.kwad.components.core.n;

import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b {
    @Override // com.kwad.components.core.n.b
    public void a(int i2, String str, boolean z2) {
        onError(i2, str);
    }

    @Override // com.kwad.components.core.n.h
    public void a(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.n.b
    public void a(@NonNull AdResultData adResultData, boolean z2) {
        a(adResultData);
    }

    @Override // com.kwad.components.core.n.h
    public void onError(int i2, String str) {
    }
}
