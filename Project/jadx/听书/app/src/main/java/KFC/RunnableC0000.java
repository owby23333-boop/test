package KFC;

import KFCKFC.Loader;
import KFCKFC.hidden.Hidden0;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: KFC.̅, reason: contains not printable characters */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC0000 extends Drawable implements Runnable {

    /* JADX INFO: renamed from: ̍, reason: not valid java name and contains not printable characters */
    Movie f4;

    /* JADX INFO: renamed from: ̒, reason: not valid java name and contains not printable characters */
    long f7;

    /* JADX INFO: renamed from: ̐, reason: not valid java name and contains not printable characters */
    boolean f6 = true;

    /* JADX INFO: renamed from: ̅, reason: not valid java name and contains not printable characters */
    Handler f3 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: ̎, reason: not valid java name and contains not printable characters */
    Paint f5 = new Paint(1);

    static {
        Loader.registerNativesForClass(1, RunnableC0000.class);
        Hidden0.special_clinit_1_100(RunnableC0000.class);
    }

    RunnableC0000(Movie movie) {
        this.f4 = movie;
        m10();
    }

    @Override // android.graphics.drawable.Drawable
    public native void draw(Canvas canvas);

    @Override // android.graphics.drawable.Drawable
    public native int getIntrinsicHeight();

    @Override // android.graphics.drawable.Drawable
    public native int getIntrinsicWidth();

    @Override // android.graphics.drawable.Drawable
    public native int getOpacity();

    @Override // java.lang.Runnable
    public native void run();

    @Override // android.graphics.drawable.Drawable
    public native void setAlpha(int i);

    @Override // android.graphics.drawable.Drawable
    public native void setColorFilter(ColorFilter colorFilter);

    /* JADX INFO: renamed from: ̖, reason: not valid java name and contains not printable characters */
    native void m10();

    /* JADX INFO: renamed from: ̗, reason: not valid java name and contains not printable characters */
    native void m11();
}
