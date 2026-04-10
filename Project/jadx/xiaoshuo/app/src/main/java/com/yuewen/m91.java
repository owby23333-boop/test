package com.yuewen;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class m91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f14329a = false;

    public static void a(float[] fArr, int i, float f, float f2, float f3, float f4) {
        fArr[i + 0] = f;
        float f5 = f4 + f2;
        fArr[i + 1] = f5;
        float f6 = f3 + f;
        fArr[i + 2] = f6;
        fArr[i + 3] = f5;
        fArr[i + 4] = f6;
        fArr[i + 5] = f2;
        fArr[i + 6] = f;
        fArr[i + 7] = f2;
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static ShortBuffer c(short[] sArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer shortBufferAsShortBuffer = byteBufferAllocateDirect.asShortBuffer();
        shortBufferAsShortBuffer.put(sArr);
        shortBufferAsShortBuffer.position(0);
        return shortBufferAsShortBuffer;
    }

    public static int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }
}
