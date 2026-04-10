package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final FormatException f16111u;

    static {
        FormatException formatException = new FormatException();
        f16111u = formatException;
        formatException.setStackTrace(ReaderException.f16114t);
    }

    private FormatException() {
    }

    public static FormatException a(Throwable th) {
        return ReaderException.f16113s ? new FormatException(th) : f16111u;
    }

    public static FormatException f() {
        return ReaderException.f16113s ? new FormatException() : f16111u;
    }

    private FormatException(Throwable th) {
        super(th);
    }
}
