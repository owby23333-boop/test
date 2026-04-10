package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.RelativeLayout;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseEndCardView extends RelativeLayout {
    protected String a;
    protected i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f6133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected k f6134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6135e;

    public BaseEndCardView(Context context, i iVar, j jVar) {
        super(context);
        this.a = getClass().getSimpleName();
        super.setWillNotDraw(false);
        this.b = iVar;
        this.f6133c = jVar;
        this.f6134d = jVar.f7312m;
    }

    private static RectF a(int i2, int i3) {
        int i4 = i2 / 2;
        float f2 = i3;
        int i5 = (int) (1.0f * f2);
        RectF rectF = new RectF();
        rectF.left = i4 - i5;
        rectF.top = i3 - (i5 * 2);
        rectF.right = i4 + i5;
        rectF.bottom = f2;
        return rectF;
    }

    protected abstract void a();

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (this.f6135e) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.draw(canvas);
                int width = getWidth();
                int height = getHeight();
                int width2 = getWidth();
                int i2 = width2 / 2;
                float height2 = getHeight();
                int i3 = (int) (1.0f * height2);
                RectF rectF = new RectF();
                rectF.left = i2 - i3;
                rectF.top = r4 - (i3 * 2);
                rectF.right = i2 + i3;
                rectF.bottom = height2;
                u.a(canvas, width, height, rectF);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.draw(canvas);
    }

    public void setNeedArc(boolean z2) {
        this.f6135e = z2;
        invalidate();
    }
}
