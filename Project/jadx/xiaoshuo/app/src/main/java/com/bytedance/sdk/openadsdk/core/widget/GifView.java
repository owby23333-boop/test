package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.lc;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"AppCompatCustomView"})
public class GifView extends ImageView {
    private Movie bf;
    private volatile boolean bh;
    private long d;
    private int e;
    private AnimatedImageDrawable ga;
    private float m;
    private boolean p;
    private boolean s;
    private boolean t;
    private int tg;
    private float v;
    private boolean vn;
    private int wu;
    private int xu;
    private float zk;

    public interface e {
        void e(Drawable drawable2);
    }

    public GifView(Context context) {
        super(context);
        this.vn = true;
        this.p = false;
        this.t = true;
        this.s = true;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source bf(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileE;
        try {
            fileE = e(getContext(), com.bytedance.sdk.openadsdk.core.multipro.bf.d() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileE);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileE);
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            return sourceCreateSource;
        } catch (Throwable th2) {
            th = th2;
            try {
                com.bytedance.sdk.component.utils.wu.d("GifView", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    private void d() {
        if (this.bf == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.d == 0) {
            this.d = jUptimeMillis;
        }
        int iDuration = this.bf.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.s || Math.abs(iDuration - this.tg) >= 60) {
            this.tg = (int) ((jUptimeMillis - this.d) % ((long) iDuration));
        } else {
            this.tg = iDuration;
            this.bh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable2) {
        if (drawable2 == null) {
            return;
        }
        setImageDrawable(drawable2);
        if (drawable2 instanceof AnimatedImageDrawable) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable2;
            this.ga = animatedImageDrawable;
            if (!this.bh) {
                animatedImageDrawable.start();
            }
            if (!this.s) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        bf();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.bf == null || this.vn) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.bh) {
                e(canvas);
            } else {
                d();
                e(canvas);
                bf();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.d("GifView", "onDraw->Throwable->", th);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bf != null && !this.vn) {
            this.v = (getWidth() - this.wu) / 2.0f;
            this.zk = (getHeight() - this.xu) / 2.0f;
        }
        this.t = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.vn || (movie = this.bf) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.bf.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.m = fMax;
        int i3 = (int) (iWidth * fMax);
        this.wu = i3;
        int i4 = (int) (iHeight * fMax);
        this.xu = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.bf != null) {
            this.t = i == 1;
            bf();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.bf != null) {
            this.t = i == 0;
            bf();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.bf != null) {
            this.t = i == 0;
            bf();
        }
    }

    public void setRepeatConfig(boolean z) {
        this.s = z;
        if (z) {
            return;
        }
        try {
            AnimatedImageDrawable animatedImageDrawable = this.ga;
            if (animatedImageDrawable != null) {
                animatedImageDrawable.setRepeatCount(0);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wu.d("GifView", "setRepeatConfig error", e2);
        }
    }

    public void e() {
        if (this.vn) {
            return;
        }
        setLayerType(1, null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vn = true;
        this.p = false;
        this.t = true;
        this.s = true;
        e();
        setWillNotDraw(false);
    }

    public void e(int i, boolean z) {
        this.bh = z;
        this.e = i;
        if (i == -1) {
            return;
        }
        if (!this.vn) {
            this.bf = e(i);
        } else {
            e(i, new e() { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.GifView.e
                public void e(final Drawable drawable2) {
                    try {
                        GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GifView.this.setDrawable(drawable2);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source bf(int i) {
        return ImageDecoder.createSource(getResources(), i);
    }

    private void bf() {
        if (this.bf == null || this.vn || !this.t) {
            return;
        }
        postInvalidateOnAnimation();
    }

    public void e(byte[] bArr, boolean z) {
        this.bh = z;
        if (bArr == null) {
            return;
        }
        if (!this.vn) {
            this.bf = e(bArr);
        } else {
            e(bArr, new e() { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.2
                @Override // com.bytedance.sdk.openadsdk.core.widget.GifView.e
                public void e(final Drawable drawable2) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable2);
                        }
                    });
                }
            });
        }
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vn = true;
        this.p = false;
        this.t = true;
        this.s = true;
        e();
    }

    private Movie e(int i) {
        try {
            return Movie.decodeStream(getResources().openRawResource(i));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.e("GifView", "createMovieWithResourceIdBySafely error", th);
            return null;
        }
    }

    private Movie e(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.e("GifView", "createMovieWithByteArrayBySafely error1", th);
            return null;
        }
    }

    private void e(final int i, final e eVar) {
        if (i == -1) {
            return;
        }
        com.bytedance.sdk.openadsdk.s.vn.e(new com.bytedance.sdk.component.zk.p("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    GifView gifView = GifView.this;
                    eVar2.e(gifView.e(gifView.bf(i)));
                }
            }
        });
    }

    private void e(final byte[] bArr, final e eVar) {
        if (bArr == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.s.vn.e(new com.bytedance.sdk.component.zk.p("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.openadsdk.core.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    GifView gifView = GifView.this;
                    eVar2.e(gifView.e(gifView.bf(bArr)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable e(ImageDecoder.Source source) {
        try {
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.e("GifView", "getAnimatedImageDrawable error", th);
            return null;
        }
    }

    public static File e(Context context, String str, String str2) {
        if (lc.bf().vs() == 1) {
            com.bytedance.sdk.component.utils.wu.vn("splashLoadAd", "视频存储使用内部存储");
            return com.bytedance.sdk.component.utils.vn.bf(context, com.bytedance.sdk.openadsdk.core.multipro.bf.d(), str, str2);
        }
        com.bytedance.sdk.component.utils.wu.vn("splashLoadAd", "视频存储使用外存储");
        return com.bytedance.sdk.component.utils.vn.e(context, com.bytedance.sdk.openadsdk.core.multipro.bf.d(), str, str2);
    }

    private void e(Canvas canvas) {
        Movie movie = this.bf;
        if (movie == null) {
            return;
        }
        movie.setTime(this.tg);
        float f = this.m;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.bf.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.bf;
            float f2 = this.v;
            float f3 = this.m;
            movie2.draw(canvas, f2 / f3, this.zk / f3);
        }
        canvas.restore();
    }
}
