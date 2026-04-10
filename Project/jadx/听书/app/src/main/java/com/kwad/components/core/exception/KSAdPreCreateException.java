package com.kwad.components.core.exception;

/* JADX INFO: loaded from: classes3.dex */
public class KSAdPreCreateException extends RuntimeException {
    private static final String LIBRARY_VERSION = ". Version: 4.6.30.1";

    public KSAdPreCreateException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public KSAdPreCreateException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }
}
