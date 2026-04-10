package com.amgcyo.cuttadon.utils.otherutils;

import android.text.method.ReplacementTransformationMethod;

/* JADX INFO: compiled from: AllCapTransformationMethod.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends ReplacementTransformationMethod {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private char[] f4391s = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private char[] f4392t = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4393u;

    public e(boolean z2) {
        this.f4393u = z2;
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getOriginal() {
        return this.f4393u ? this.f4391s : this.f4392t;
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getReplacement() {
        return this.f4393u ? this.f4392t : this.f4391s;
    }
}
