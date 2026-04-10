package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class ChecksumException extends ReaderException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ChecksumException f16094u;

    static {
        ChecksumException checksumException = new ChecksumException();
        f16094u = checksumException;
        checksumException.setStackTrace(ReaderException.f16114t);
    }

    private ChecksumException() {
    }

    public static ChecksumException f() {
        return ReaderException.f16113s ? new ChecksumException() : f16094u;
    }
}
