package com.airbnb.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface EpoxyDragCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
    void onDragReleased(T t, View view);

    void onDragStarted(T t, View view, int i);

    void onModelMoved(int i, int i2, T t, View view);
}
