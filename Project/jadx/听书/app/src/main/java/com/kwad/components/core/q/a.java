package com.kwad.components.core.q;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.sy();
        return b.wrapInputStream(inputStream);
    }
}
