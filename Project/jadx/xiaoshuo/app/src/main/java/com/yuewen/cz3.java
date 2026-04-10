package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes12.dex */
public class cz3 extends ni {
    public static final int d = 24;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10039b;
    public final Rect c;

    public cz3() {
        this(-16777216);
        a().setTextSize(24.0f);
    }

    public void c() {
        a().setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void d(String str) {
        this.f10039b = str;
        a().getTextBounds(str, 0, str.length(), this.c);
        setBounds(0, 0, this.c.width(), this.c.height());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = this.c;
        canvas.translate(-rect.left, -rect.top);
        canvas.drawText(this.f10039b, 0.0f, 0.0f, a());
    }

    public void e(int i) {
        a().setTextSize(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.width();
    }

    public cz3(int i) {
        super(i);
        this.f10039b = "";
        this.c = new Rect();
        d("测试数据");
    }
}
