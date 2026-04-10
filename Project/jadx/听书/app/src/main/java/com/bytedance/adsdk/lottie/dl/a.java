package com.bytedance.adsdk.lottie.dl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends Closeable {
    String a();

    String dl();

    InputStream g() throws IOException;

    boolean z();
}
