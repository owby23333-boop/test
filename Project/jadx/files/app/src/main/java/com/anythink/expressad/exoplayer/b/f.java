package com.anythink.expressad.exoplayer.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a extends Exception {
        public a(int i2, int i3, int i4) {
            super("Unhandled format: " + i2 + " Hz, " + i3 + " channels in encoding " + i4);
        }
    }

    void a(ByteBuffer byteBuffer);

    boolean a();

    boolean a(int i2, int i3, int i4);

    int b();

    int c();

    int d();

    void e();

    ByteBuffer f();

    boolean g();

    void h();

    void i();
}
