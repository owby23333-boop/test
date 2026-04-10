package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static final boolean f16113s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final StackTraceElement[] f16114t;

    static {
        f16113s = System.getProperty("surefire.test.class.path") != null;
        f16114t = new StackTraceElement[0];
    }

    ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    ReaderException(Throwable th) {
        super(th);
    }
}
