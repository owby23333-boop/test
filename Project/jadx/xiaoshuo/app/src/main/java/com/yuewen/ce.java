package com.yuewen;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ce extends ae {
    public final Context d;
    public final mb2 e;
    public final int f;

    public ce(Context context, mb2 mb2Var, int i, String str) {
        super(str);
        this.d = context;
        this.e = mb2Var;
        this.f = i;
    }

    public View g() {
        return new View(this.d);
    }
}
