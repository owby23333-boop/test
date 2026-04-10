package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes2.dex */
public class CloseFrameLayout extends FrameLayout implements a {
    private static final String a = CloseFrameLayout.class.getSimpleName();
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f6165c;

    public CloseFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || this.f6165c.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
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
            post(new Runnable() { // from class: com.anythink.basead.ui.CloseFrameLayout.1
                @Override // java.lang.Runnable
                public final void run() {
                    CloseFrameLayout.this.f6165c = new Rect();
                    CloseFrameLayout closeFrameLayout = CloseFrameLayout.this;
                    closeFrameLayout.getHitRect(closeFrameLayout.f6165c);
                    int iWidth = ((int) (CloseFrameLayout.this.f6165c.width() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    int iHeight = ((int) (CloseFrameLayout.this.f6165c.height() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    CloseFrameLayout.this.f6165c.top -= iHeight;
                    CloseFrameLayout.this.f6165c.bottom += iHeight;
                    CloseFrameLayout.this.f6165c.left -= iWidth;
                    CloseFrameLayout.this.f6165c.right += iWidth;
                }
            });
        } else if (f3 > 1.0f) {
            u.a(this, f3);
        }
    }
}
