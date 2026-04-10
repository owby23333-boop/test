package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes2.dex */
public class CloseImageView extends ImageView implements a {
    private static final String a = CloseImageView.class.getSimpleName();
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f6166c;

    public CloseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        float f2 = this.b;
        if (f2 > 1.0f) {
            u.a(this, f2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || this.f6166c.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.anythink.basead.ui.a
    public void setClickAreaScaleFactor(float f2) {
        this.b = f2;
        if (this.b <= 0.0f) {
            this.b = 1.0f;
        }
        new StringBuilder("setClickAreaScaleFactor: ").append(this.b);
        float f3 = this.b;
        if (f3 < 1.0f) {
            post(new Runnable() { // from class: com.anythink.basead.ui.CloseImageView.1
                @Override // java.lang.Runnable
                public final void run() {
                    CloseImageView.this.f6166c = new Rect();
                    CloseImageView closeImageView = CloseImageView.this;
                    closeImageView.getHitRect(closeImageView.f6166c);
                    int iWidth = ((int) (CloseImageView.this.f6166c.width() * (CloseImageView.this.b - 1.0f))) / 2;
                    int iHeight = ((int) (CloseImageView.this.f6166c.height() * (CloseImageView.this.b - 1.0f))) / 2;
                    CloseImageView.this.f6166c.top -= iHeight;
                    CloseImageView.this.f6166c.bottom += iHeight;
                    CloseImageView.this.f6166c.left -= iWidth;
                    CloseImageView.this.f6166c.right += iWidth;
                }
            });
        } else if (f3 > 1.0f) {
            u.a(this, f3);
        }
    }
}
