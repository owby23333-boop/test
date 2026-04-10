package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class EpoxyHolder {
    public EpoxyHolder(@NonNull ViewParent viewParent) {
        this();
    }

    public abstract void bindView(@NonNull View view);

    public EpoxyHolder() {
    }
}
