package KFC;

import KFCKFC.Loader;
import KFCKFC.hidden.Hidden0;
import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: renamed from: KFC.̘, reason: contains not printable characters */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC0010 implements Runnable {

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    public final Context f35;

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    public final ImageView f36;

    static {
        Loader.registerNativesForClass(11, RunnableC0010.class);
        Hidden0.special_clinit_11_20(RunnableC0010.class);
    }

    public /* synthetic */ RunnableC0010(Context context, ImageView imageView) {
        this.f35 = context;
        this.f36 = imageView;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
