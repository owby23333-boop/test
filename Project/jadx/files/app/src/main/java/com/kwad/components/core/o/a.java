package com.kwad.components.core.o;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.pC();
        return b.wrapInputStream(inputStream);
    }
}
