package com.yuewen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.yuewen.es2;

/* JADX INFO: loaded from: classes13.dex */
public class jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f13036b;
    public final int c;

    public interface a {
        int a();

        int b();

        int c();

        int d();

        Context getContext();
    }

    public jp(a aVar) {
        this.f13035a = aVar;
        Context context = aVar.getContext();
        this.f13036b = ContextCompat.getDrawable(context, es2.f.vi);
        this.c = context.getResources().getDimensionPixelSize(es2.g.J0);
    }

    public void a(Canvas canvas) {
        this.f13036b.setBounds(this.f13035a.a() + this.c, this.f13035a.b(), this.f13035a.d() - this.c, this.f13035a.c());
        this.f13036b.draw(canvas);
    }
}
