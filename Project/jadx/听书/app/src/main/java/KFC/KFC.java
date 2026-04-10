package KFC;

import KFCKFC.Loader;
import KFCKFC.hidden.Hidden0;
import android.app.Dialog;
import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class KFC {

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    private static volatile Context f0;

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    private static volatile Dialog f1;

    /* JADX INFO: renamed from: ̎, reason: not valid java name and contains not printable characters */
    private static volatile boolean f2;

    static {
        Loader.registerNativesForClass(0, KFC.class);
        Hidden0.special_clinit_0_00(KFC.class);
    }

    private KFC() {
    }

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ Dialog m0();

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ boolean m1();

    /* JADX INFO: renamed from: ̎, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ void m2(Context context);

    /* JADX INFO: renamed from: ̐, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ void m3(Dialog dialog);

    /* JADX INFO: renamed from: ̒, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ void m4(boolean z);

    /* JADX INFO: renamed from: ̓, reason: not valid java name and contains not printable characters */
    static native /* bridge */ /* synthetic */ boolean m5(Context context);

    /* JADX INFO: renamed from: ̖, reason: not valid java name and contains not printable characters */
    public static native String m6(Context context, StringBuffer stringBuffer, String str, StringBuffer stringBuffer2);

    /* JADX INFO: renamed from: ̗, reason: not valid java name and contains not printable characters */
    public static native void m7(Context context);

    /* JADX INFO: renamed from: ̘, reason: not valid java name and contains not printable characters */
    private static native boolean m8(Context context);

    /* JADX INFO: renamed from: ̙, reason: not valid java name and contains not printable characters */
    static native /* synthetic */ void m9(Context context);
}
