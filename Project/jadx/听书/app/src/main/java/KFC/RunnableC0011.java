package KFC;

import KFCKFC.Loader;
import KFCKFC.hidden.Hidden0;
import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: renamed from: KFC.̙, reason: contains not printable characters */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC0011 implements Runnable {

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    public final String f37;

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    public final ImageView f38;

    /* JADX INFO: renamed from: ̎, reason: not valid java name and contains not printable characters */
    public final Context f39;

    static {
        Loader.registerNativesForClass(12, RunnableC0011.class);
        Hidden0.special_clinit_12_20(RunnableC0011.class);
    }

    public /* synthetic */ RunnableC0011(String str, ImageView imageView, Context context) {
        this.f37 = str;
        this.f38 = imageView;
        this.f39 = context;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
