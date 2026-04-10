package com.yuewen;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dv3 extends mw0 {
    public dv3(int i, int i2) {
        super(i, i2);
    }

    @Override // com.yuewen.mw0
    public View a(View view, @IdRes int i) {
        ViewStub viewStub = (ViewStub) view.findViewById(i);
        if (viewStub == null) {
            return null;
        }
        return viewStub.inflate();
    }
}
