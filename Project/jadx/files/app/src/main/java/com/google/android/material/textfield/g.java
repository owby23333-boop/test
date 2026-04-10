package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: NoEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends e {
    g(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconDrawable((Drawable) null);
        this.a.setEndIconContentDescription((CharSequence) null);
    }
}
