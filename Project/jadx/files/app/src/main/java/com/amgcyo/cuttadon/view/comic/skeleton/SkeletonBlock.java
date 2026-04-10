package com.amgcyo.cuttadon.view.comic.skeleton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.amgcyo.cuttadon.R$styleable;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class SkeletonBlock extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f4564s = 500;

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f4565s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ boolean f4566t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ int f4567u;

        a(int i2, boolean z2, int i3) {
            this.f4565s = i2;
            this.f4566t = z2;
            this.f4567u = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScaleAnimation scaleAnimation;
            float fNextFloat = new Random().nextFloat();
            double d2 = fNextFloat;
            if (d2 < 0.3d) {
                fNextFloat = 0.3f;
            } else if (d2 > 0.8d) {
                fNextFloat = 0.8f;
            }
            if (this.f4565s == 0) {
                scaleAnimation = new ScaleAnimation(this.f4566t ? 1.0f : fNextFloat, this.f4566t ? fNextFloat : 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
            } else {
                scaleAnimation = new ScaleAnimation(1.0f, 1.0f, this.f4566t ? 1.0f : fNextFloat, this.f4566t ? fNextFloat : 1.0f, 1, 0.0f, 1, 0.0f);
            }
            int i2 = this.f4567u;
            if (i2 == 0) {
                i2 = SkeletonBlock.f4564s;
            }
            scaleAnimation.setDuration(i2);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(-1);
            SkeletonBlock.this.startAnimation(scaleAnimation);
        }
    }

    public SkeletonBlock(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkeletonBlock(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SkeletonBlock);
        int integer = typedArrayObtainStyledAttributes.getInteger(0, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        post(new a(i3, new Random().nextBoolean(), integer));
    }
}
