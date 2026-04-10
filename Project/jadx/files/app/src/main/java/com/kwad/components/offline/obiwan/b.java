package com.kwad.components.offline.obiwan;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.d.kwai.b {
    private final IObiwanLogcat Xl;

    public b(IObiwanLogcat iObiwanLogcat) {
        this.Xl = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void d(String str, String str2) {
        this.Xl.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void e(String str, String str2) {
        this.Xl.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void i(String str, String str2) {
        this.Xl.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void printStackTraceOnly(Throwable th) {
        this.Xl.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2) {
        this.Xl.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2, boolean z2) {
        this.Xl.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2) {
        this.Xl.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2, boolean z2) {
        this.Xl.w(str, str2, z2);
    }
}
