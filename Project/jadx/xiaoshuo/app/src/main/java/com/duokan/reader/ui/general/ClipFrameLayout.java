package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public class ClipFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f5357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Callable<Path> f5358b;
    public final PaintFlagsDrawFilter c;

    public class a implements Callable<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f5359a;

        public a(float[] fArr) {
            this.f5359a = fArr;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path call() {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, ClipFrameLayout.this.getWidth(), ClipFrameLayout.this.getHeight()), this.f5359a, Path.Direction.CW);
            return path;
        }
    }

    public ClipFrameLayout(@NonNull Context context) {
        super(context);
        this.c = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f5357a != null) {
            canvas.setDrawFilter(this.c);
            canvas.clipPath(this.f5357a);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Callable<Path> callable = this.f5358b;
        if (callable != null) {
            try {
                this.f5357a = callable.call();
            } catch (Exception unused) {
            }
        }
    }

    public void setClipPath(Path path) {
        setWillNotDraw(false);
        this.f5357a = path;
    }

    public void setCornerRadius(float[] fArr) {
        setWillNotDraw(false);
        this.f5358b = new a(fArr);
    }

    public ClipFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new PaintFlagsDrawFilter(0, 3);
    }

    public ClipFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new PaintFlagsDrawFilter(0, 3);
    }
}
