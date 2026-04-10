package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: classes4.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 4.6.30.1";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 4.6.30.1", th);
    }
}
