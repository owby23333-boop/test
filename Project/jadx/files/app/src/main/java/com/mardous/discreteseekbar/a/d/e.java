package com.mardous.discreteseekbar.a.d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: TrackRectDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends c {
    public e(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
    }

    @Override // com.mardous.discreteseekbar.a.d.c
    void a(Canvas canvas, Paint paint) {
        canvas.drawRect(getBounds(), paint);
    }
}
