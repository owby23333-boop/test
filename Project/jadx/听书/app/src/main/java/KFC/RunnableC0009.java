package KFC;

import KFCKFC.Loader;
import KFCKFC.hidden.Hidden0;
import android.content.Context;
import android.graphics.Movie;
import android.widget.ImageView;

/* JADX INFO: renamed from: KFC.̗, reason: contains not printable characters */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC0009 implements Runnable {

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    public final Movie f32;

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    public final ImageView f33;

    /* JADX INFO: renamed from: ̎, reason: not valid java name and contains not printable characters */
    public final Context f34;

    static {
        Loader.registerNativesForClass(10, RunnableC0009.class);
        Hidden0.special_clinit_10_20(RunnableC0009.class);
    }

    public /* synthetic */ RunnableC0009(Movie movie, ImageView imageView, Context context) {
        this.f32 = movie;
        this.f33 = imageView;
        this.f34 = context;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
