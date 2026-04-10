package com.google.android.material.textfield;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CustomEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends e {
    b(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconOnLongClickListener(null);
    }
}
