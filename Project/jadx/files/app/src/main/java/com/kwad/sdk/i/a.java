package com.kwad.sdk.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static View a(Context context, @LayoutRes int i2, @Nullable ViewGroup viewGroup, boolean z2) {
        RuntimeException runtimeException;
        boolean zHasInitFinish = ((e) ServiceProvider.get(e.class)).hasInitFinish();
        if (((e) ServiceProvider.get(e.class)).getIsExternal()) {
            if (!(context instanceof ResContext)) {
                runtimeException = new RuntimeException("expect ResContext in external:" + context.getClass().getName() + "--mIsSdkInit:" + zHasInitFinish);
                ((d) ServiceProvider.get(d.class)).gatherException(runtimeException);
            }
        } else if (context instanceof ResContext) {
            runtimeException = new RuntimeException("expect not ResContext:" + context.getClass().getName() + "--mIsSdkInit:" + zHasInitFinish);
            ((d) ServiceProvider.get(d.class)).gatherException(runtimeException);
        }
        return dv(Wrapper.wrapContextIfNeed(context)).inflate(i2, viewGroup, z2);
    }

    public static LayoutInflater dv(Context context) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (!((e) ServiceProvider.get(e.class)).getIsExternal()) {
            return layoutInflaterFrom;
        }
        LayoutInflater layoutInflaterWrapInflaterIfNeed = Wrapper.wrapInflaterIfNeed(layoutInflaterFrom);
        r.a(layoutInflaterWrapInflaterIfNeed, "mFactory", (Object) null);
        r.a(layoutInflaterWrapInflaterIfNeed, "mFactory2", (Object) null);
        return layoutInflaterWrapInflaterIfNeed;
    }

    public static View inflate(Context context, @LayoutRes int i2, @Nullable ViewGroup viewGroup) {
        return a(context, i2, viewGroup, viewGroup != null);
    }
}
