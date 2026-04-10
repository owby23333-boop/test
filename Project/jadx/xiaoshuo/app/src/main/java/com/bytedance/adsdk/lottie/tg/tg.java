package com.bytedance.adsdk.lottie.tg;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface tg extends Closeable {
    InputStream bf() throws IOException;

    String d();

    boolean e();

    String tg();
}
