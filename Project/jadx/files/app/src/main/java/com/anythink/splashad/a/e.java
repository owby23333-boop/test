package com.anythink.splashad.a;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {
    int T;

    protected e(Context context) {
        super(context);
    }

    private void d(int i2) {
        this.T = i2;
    }

    @Override // com.anythink.core.common.h
    protected final void a(String str, com.anythink.core.common.l.a aVar) {
        super.a(str, aVar);
    }

    @Override // com.anythink.core.common.h
    public final void g() {
        j jVar = this.f7548j;
        if (jVar != null) {
            jVar.f7585f = null;
        }
        super.g();
    }

    @Override // com.anythink.core.common.h
    public final void h() {
        super.h();
    }

    public final void j() {
        g();
        a();
    }

    @Override // com.anythink.core.common.h
    public final void a(AdError adError) {
        super.a(adError);
    }

    @Override // com.anythink.core.common.h
    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter instanceof CustomSplashAdapter) {
            ((CustomSplashAdapter) aTBaseAdAdapter).setFetchAdTimeout(this.T);
        }
    }
}
