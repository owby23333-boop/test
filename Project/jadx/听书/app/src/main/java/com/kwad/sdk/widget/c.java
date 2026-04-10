package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class c extends Dialog {
    public c(Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
