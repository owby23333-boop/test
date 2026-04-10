package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final NotFoundException f16112u;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f16112u = notFoundException;
        notFoundException.setStackTrace(ReaderException.f16114t);
    }

    private NotFoundException() {
    }

    public static NotFoundException f() {
        return f16112u;
    }
}
