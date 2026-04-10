package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.a.gc;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class GifView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f598a;
    private long dl;
    private boolean e;
    private float fo;
    private Movie g;
    private AnimatedImageDrawable gc;
    private float gz;
    private volatile boolean i;
    private int kb;
    private boolean m;
    private boolean pf;
    private float uy;
    private boolean v;
    private int wp;
    private int z;

    interface z {
        void z(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.m = Build.VERSION.SDK_INT >= 28;
        this.e = false;
        this.v = true;
        this.pf = true;
        z();
    }

    void z() {
        if (this.m) {
            return;
        }
        setLayerType(1, null);
    }

    public void z(int i, boolean z2) {
        this.i = z2;
        this.z = i;
        if (i == -1) {
            return;
        }
        if (!this.m) {
            this.g = z(i);
        } else {
            z(i, new z() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.z
                public void z(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void z(byte[] bArr, boolean z2) {
        this.i = z2;
        if (bArr == null) {
            return;
        }
        if (!this.m) {
            this.g = z(bArr);
        } else {
            z(bArr, new z() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.z
                public void z(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.gc = animatedImageDrawable;
            if (!this.i) {
                animatedImageDrawable.start();
            }
            if (!this.pf) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        dl();
    }

    public void setRepeatConfig(boolean z2) {
        AnimatedImageDrawable animatedImageDrawable;
        this.pf = z2;
        if (z2) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.gc) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            wp.dl("GifView", "setRepeatConfig error", e);
        }
    }

    private Movie z(int i) {
        try {
            return Movie.decodeStream(tb.z(getContext()).openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie z(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void z(final int i, final z zVar) {
        if (i == -1) {
            return;
        }
        gc.z(new fo("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    GifView gifView = GifView.this;
                    zVar2.z(gifView.z(gifView.g(i)));
                }
            }
        }, 5);
    }

    private void z(final byte[] bArr, final z zVar) {
        if (bArr == null) {
            return;
        }
        gc.z(new fo("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    GifView gifView = GifView.this;
                    zVar2.z(gifView.z(gifView.g(bArr)));
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source g(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileZ;
        try {
            fileZ = z(getContext(), com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileZ);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT >= 28) {
                ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileZ);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return sourceCreateSource;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                wp.dl("GifView", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static File z(Context context, String str, String str2) {
        int iKb = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().kb();
        boolean zWp = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp();
        if (iKb == 1) {
            wp.a("splashLoadAd", "视频存储使用内部存储");
            return m.g(context, zWp, str, str2);
        }
        wp.a("splashLoadAd", "视频存储使用外存储");
        return m.z(context, zWp, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source g(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.createSource(tb.z(getContext()), i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable z(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void g() {
        if (this.g == null || !this.i) {
            return;
        }
        this.i = false;
        if (!this.m) {
            this.dl = SystemClock.uptimeMillis() - ((long) this.f598a);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.gc;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.gc.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.m || (movie = this.g) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.g.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.uy = fMax;
        int i3 = (int) (iWidth * fMax);
        this.kb = i3;
        int i4 = (int) (iHeight * fMax);
        this.wp = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (this.g != null && !this.m) {
            this.gz = (getWidth() - this.kb) / 2.0f;
            this.fo = (getHeight() - this.wp) / 2.0f;
        }
        this.v = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.g != null && !this.m) {
            try {
                if (!this.i) {
                    a();
                    z(canvas);
                    dl();
                    return;
                }
                z(canvas);
                return;
            } catch (Throwable th) {
                wp.dl("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void dl() {
        if (this.g == null || this.m || !this.v) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void a() {
        if (this.g == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.dl == 0) {
            this.dl = jUptimeMillis;
        }
        int iDuration = this.g.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.pf && Math.abs(iDuration - this.f598a) < 60) {
            this.f598a = iDuration;
            this.i = true;
        } else {
            this.f598a = (int) ((jUptimeMillis - this.dl) % ((long) iDuration));
        }
    }

    private void z(Canvas canvas) {
        Movie movie = this.g;
        if (movie == null) {
            return;
        }
        movie.setTime(this.f598a);
        float f = this.uy;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.g.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.g;
            float f2 = this.gz;
            float f3 = this.uy;
            movie2.draw(canvas, f2 / f3, this.fo / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.g != null) {
            this.v = i == 1;
            dl();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.g != null) {
            this.v = i == 0;
            dl();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.g != null) {
            this.v = i == 0;
            dl();
        }
    }
}
