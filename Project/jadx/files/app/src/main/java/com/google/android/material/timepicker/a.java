package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: compiled from: MaxInputValidator.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements InputFilter {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f16062s;

    public a(int i2) {
        this.f16062s = i2;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            if (Integer.parseInt(sb.toString()) <= this.f16062s) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
