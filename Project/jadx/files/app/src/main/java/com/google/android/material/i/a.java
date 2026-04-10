package com.google.android.material.i;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends f {
    private final Typeface a;
    private final InterfaceC0324a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15423c;

    /* JADX INFO: renamed from: com.google.android.material.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0324a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0324a interfaceC0324a, Typeface typeface) {
        this.a = typeface;
        this.b = interfaceC0324a;
    }

    @Override // com.google.android.material.i.f
    public void a(Typeface typeface, boolean z2) {
        a(typeface);
    }

    @Override // com.google.android.material.i.f
    public void a(int i2) {
        a(this.a);
    }

    public void a() {
        this.f15423c = true;
    }

    private void a(Typeface typeface) {
        if (this.f15423c) {
            return;
        }
        this.b.a(typeface);
    }
}
