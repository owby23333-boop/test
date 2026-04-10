package miuix.androidbasewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import miuix.androidbasewidget.R;
import miuix.reflect.Reflects;

/* JADX INFO: loaded from: classes8.dex */
public class ProgressBar extends android.widget.ProgressBar {
    private Drawable mIndeterminateDrawableOrignal;

    public ProgressBar(Context context) {
        this(context, null);
    }

    public void postConstruct(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBar, i, R.style.Widget_ProgressBar_Horizontal_DayNight);
        Drawable drawable2 = this.mIndeterminateDrawableOrignal;
        if (drawable2 != null && drawable2.getClass().getName().equals("android.graphics.drawable.AnimatedRotateDrawable")) {
            int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.ProgressBar_indeterminateFramesCount, 48);
            Class<?> cls = drawable2.getClass();
            Class cls2 = Integer.TYPE;
            Reflects.invoke(drawable2, Reflects.getMethod(cls, "setFramesCount", (Class<?>[]) new Class[]{cls2}), Integer.valueOf(i2));
            Reflects.invoke(drawable2, Reflects.getMethod(cls, "setFramesDuration", (Class<?>[]) new Class[]{cls2}), Integer.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.ProgressBar_indeterminateFramesDuration, 25)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable2) {
        super.setIndeterminateDrawable(drawable2);
        if (this.mIndeterminateDrawableOrignal != drawable2) {
            this.mIndeterminateDrawableOrignal = drawable2;
        }
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        postConstruct(context, attributeSet, i);
    }
}
