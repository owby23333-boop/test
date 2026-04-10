package com.jpardogo.android.googleprogressbar.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleMusicDicesDrawable;
import com.jpardogo.android.googleprogressbar.library.NexusRotationCrossDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: com.jpardogo.android.googleprogressbar.library.GoogleProgressBar$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType = new int[ProgressType.values().length];

        static {
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType[ProgressType.FOLDING_CIRCLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType[ProgressType.GOOGLE_MUSIC_DICES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType[ProgressType.NEXUS_ROTATION_CROSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType[ProgressType.CHROME_FLOATING_CIRCLES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum ProgressType {
        FOLDING_CIRCLES,
        GOOGLE_MUSIC_DICES,
        NEXUS_ROTATION_CROSS,
        CHROME_FLOATING_CIRCLES
    }

    public GoogleProgressBar(Context context) {
        this(context, null);
    }

    private Drawable buildDrawable(Context context, int i2, int i3) {
        int i4 = AnonymousClass1.$SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleProgressBar$ProgressType[ProgressType.values()[i2].ordinal()];
        if (i4 == 1) {
            return new FoldingCirclesDrawable.Builder(context).colors(getResources().getIntArray(i3)).build();
        }
        if (i4 == 2) {
            return new GoogleMusicDicesDrawable.Builder().build();
        }
        if (i4 == 3) {
            return new NexusRotationCrossDrawable.Builder(context).colors(getResources().getIntArray(i3)).build();
        }
        if (i4 != 4) {
            return null;
        }
        return new ChromeFloatingCirclesDrawable.Builder(context).colors(getResources().getIntArray(i3)).build();
    }

    public GoogleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.progressBarStyle);
    }

    public GoogleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoogleProgressBar, i2, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.GoogleProgressBar_type, context.getResources().getInteger(R.integer.default_type));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GoogleProgressBar_colors, R.array.google_colors);
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawableBuildDrawable = buildDrawable(context, integer, resourceId);
        if (drawableBuildDrawable != null) {
            setIndeterminateDrawable(drawableBuildDrawable);
        }
    }
}
