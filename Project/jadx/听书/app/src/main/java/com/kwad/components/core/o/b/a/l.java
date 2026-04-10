package com.kwad.components.core.o.b.a;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends IOfflineCompoWrapper {
    public l(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.a.j(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return com.kwad.library.b.c.a.a(layoutInflater, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.a.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapGetApplication(Context context) {
        return com.kwad.sdk.o.m.Ta();
    }
}
