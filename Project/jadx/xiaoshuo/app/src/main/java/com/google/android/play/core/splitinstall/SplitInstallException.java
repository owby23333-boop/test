package com.google.android.play.core.splitinstall;

/* JADX INFO: loaded from: classes7.dex */
public class SplitInstallException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6957a;

    public SplitInstallException(int i) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Split Install Error: ");
        sb.append(i);
        super(sb.toString());
        this.f6957a = i;
    }

    public int getErrorCode() {
        return this.f6957a;
    }
}
