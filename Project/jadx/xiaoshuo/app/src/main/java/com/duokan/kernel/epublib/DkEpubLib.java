package com.duokan.kernel.epublib;

import com.duokan.kernel.DkNative;
import com.duokan.kernel.EpubLibInterface;
import com.duokan.kernel.KernelInterface;
import com.yuewen.w51;

/* JADX INFO: loaded from: classes11.dex */
public class DkEpubLib extends DkNative implements KernelInterface, EpubLibInterface {
    public static final int DK_CHARSET_ANSI = 0;
    public static final int DK_CHARSET_BIG5 = 136;
    public static final int DK_CHARSET_GB = 134;
    public static final int DK_CHARSET_JOHAB = 130;
    public static final int DK_CHARSET_SHITJIS = 128;
    public static final int DK_MEASURE_CM = 2;
    public static final int DK_MEASURE_CUSTOM = 5;
    public static final int DK_MEASURE_INCH = 4;
    public static final int DK_MEASURE_MM = 3;
    public static final int DK_MEASURE_PIXEL = 0;
    public static final int DK_MEASURE_POINT = 1;
    static DkEpubLib sEpubLib;

    public DkEpubLib() {
        sEpubLib = this;
    }

    public native boolean destroy();

    public native void freeFlexPageHandle(long j);

    public native String getKernelVersion();

    public native boolean initialize(String str);

    public final void registerFont(String str, String str2) {
        registerFont(str, str2, w51.l);
    }

    @Override // com.duokan.kernel.KernelInterface
    public native void registerFont(String str, String str2, double d);

    public native void setBackupFont(String str);

    @Override // com.duokan.kernel.EpubLibInterface
    public native void setChsToCht(boolean z);

    public native void setDefaultFont(String str, int i);

    public native void setDeviceParams(int i, int i2, int i3, int i4);

    public native void setUseBookStyle(boolean z);

    public native boolean verifyFont(String str, String str2);
}
