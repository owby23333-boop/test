package com.airbnb.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
interface BaseEpoxyTouchCallback<T extends EpoxyModel> {
    void clearView(T t, View view);

    int getMovementFlagsForModel(T t, int i);
}
