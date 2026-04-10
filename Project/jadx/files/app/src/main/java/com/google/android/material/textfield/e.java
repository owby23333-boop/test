package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class e {
    TextInputLayout a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f15992c;

    e(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.f15992c = textInputLayout.getEndIconView();
    }

    abstract void a();

    void a(boolean z2) {
    }

    boolean a(int i2) {
        return true;
    }

    boolean b() {
        return false;
    }
}
