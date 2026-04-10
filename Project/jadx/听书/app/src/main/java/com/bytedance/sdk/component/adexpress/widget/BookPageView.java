package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class BookPageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Point f589a;
    Point dl;
    Point e;
    Paint g;
    Point gc;
    Point m;
    Paint z;

    public BookPageView(Context context) {
        super(context);
        this.z = new Paint();
        this.g = new Paint();
        this.dl = new Point();
        this.f589a = new Point();
        this.gc = new Point();
        this.m = new Point();
        this.e = new Point();
        this.z.setColor(-16711936);
        this.z.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.dl.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.dl.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.g.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), QMUIProgressBar.DEFAULT_BACKGROUND_COLOR, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.g.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.g.setStrokeWidth(6.0f);
                BookPageView.this.g.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void z(Point point) {
        this.dl.x = point.x;
        this.dl.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        z();
        Path path = new Path();
        path.moveTo(this.m.x, this.m.y);
        path.lineTo(this.dl.x, this.dl.y);
        path.lineTo(this.e.x, this.e.y);
        path.close();
        canvas.drawPath(path, this.g);
    }

    private void z() {
        this.f589a.x = getWidth();
        this.f589a.y = getHeight();
        this.gc.x = (this.dl.x + this.f589a.x) / 2;
        this.gc.y = (this.dl.y + this.f589a.y) / 2;
        this.m.x = this.gc.x - (((this.f589a.y - this.gc.y) * (this.f589a.y - this.gc.y)) / (this.f589a.x - this.gc.x));
        this.m.y = this.f589a.y;
        this.e.x = this.f589a.x;
        this.e.y = this.gc.y - (((this.f589a.x - this.gc.x) * (this.f589a.x - this.gc.x)) / (this.f589a.y - this.gc.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.f589a.x, this.f589a.y);
        path.lineTo(this.m.x, this.m.y);
        path.lineTo(this.e.x, this.e.y);
        path.close();
        return path;
    }
}
