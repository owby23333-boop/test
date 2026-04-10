package com.anythink.expressad.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;

/* JADX INFO: loaded from: classes2.dex */
public class ATImageView extends ImageView {
    private static final String a = "at-widget-imageview";
    private Bitmap b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12281c;

    /* JADX INFO: renamed from: com.anythink.expressad.widget.ATImageView$1, reason: invalid class name */
    final class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            ATImageView.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    public ATImageView(Context context) {
        super(context);
        this.b = null;
    }

    private void a() {
        if (getContext() != null) {
            b.a(getContext()).a(this.f12281c, new AnonymousClass1());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (this.b == null || !this.b.isRecycled()) {
                super.onDraw(canvas);
            } else if (getContext() != null) {
                b.a(getContext()).a(this.f12281c, new AnonymousClass1());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
        } else {
            this.b = null;
            super.setImageBitmap(null);
        }
    }

    public void setImageUrl(String str) {
        this.f12281c = str;
    }

    public ATImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public ATImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = null;
    }
}
