package com.duokan.reader.ui.zxing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.zxing.camera.CameraManager;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.zxing.ResultPoint;
import com.yuewen.e84;
import com.yuewen.st2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewfinderView extends View {
    public static final long k = 80;
    public static final int l = 160;
    public static final int m = 20;
    public static final int n = 6;
    public static final int o = e84.k(DkApp.get(), 20.0f);
    public static final int p = e84.k(DkApp.get(), 5.0f);
    public static final int q = e84.k(DkApp.get(), 3.34f);
    public static final int r = e84.k(DkApp.get(), 0.33f);
    public static final int s = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6628b;
    public final int c;
    public final int d;
    public final int e;
    public List<ResultPoint> f;
    public List<ResultPoint> g;
    public LinearGradient h;
    public CameraManager i;
    public final Paint j;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new Paint(1);
        Resources resources = getResources();
        this.c = resources.getColor(st2.f.go);
        this.d = resources.getColor(st2.f.Js);
        this.e = resources.getColor(st2.f.ks);
        this.f = new ArrayList(5);
        this.g = null;
    }

    public void a(ResultPoint resultPoint) {
        List<ResultPoint> list = this.f;
        synchronized (list) {
            list.add(resultPoint);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    public void b() {
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Rect rectI;
        Canvas canvas2;
        CameraManager cameraManager = this.i;
        if (cameraManager == null || (rectI = cameraManager.i()) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int iK = e84.k(getContext(), 220.0f);
        int i = (int) ((width - iK) / 2.0f);
        int iK2 = (int) (((height - iK) - e84.k(getContext(), 46.67f)) / 2.0f);
        int i2 = i + iK;
        int i3 = iK2 + iK;
        this.j.setColor(this.c);
        float f = width;
        float f2 = iK2;
        canvas.drawRect(0.0f, 0.0f, f, f2, this.j);
        float f3 = i;
        float f4 = i3;
        canvas.drawRect(0.0f, f2, f3, f4, this.j);
        float f5 = i2;
        canvas.drawRect(f5, f2, f, f4, this.j);
        canvas.drawRect(0.0f, f4, f, height, this.j);
        this.j.setColor(this.d);
        int i4 = r;
        canvas.drawRect(f3, f2, f5, iK2 + i4, this.j);
        canvas.drawRect(f3, f2, i + i4, f4, this.j);
        canvas.drawRect(f3, i3 - i4, f5, f4, this.j);
        canvas.drawRect(i2 - i4, f2, f5, f4, this.j);
        this.j.setTextAlign(Paint.Align.CENTER);
        this.j.setTextSize(e84.g1(getContext(), 12.67f));
        canvas.drawText(getResources().getString(st2.s.E1), f / 2.0f, i3 + e84.k(getContext(), 46.67f), this.j);
        this.j.setColor(this.d);
        int i5 = o;
        int i6 = p;
        canvas.drawRect(f3, f2, i + i5, iK2 + i6, this.j);
        canvas.drawRect(f3, f2, i + i6, iK2 + i5, this.j);
        canvas.drawRect(i2 - i5, f2, f5, iK2 + i6, this.j);
        canvas.drawRect(i2 - i6, f2, f5, iK2 + i5, this.j);
        canvas.drawRect(f3, i3 - i6, i + i5, f4, this.j);
        canvas.drawRect(f3, i3 - i5, i + i6, f4, this.j);
        canvas.drawRect(i2 - i5, i3 - i6, f5, f4, this.j);
        canvas.drawRect(i2 - i6, i3 - i5, f5, f4, this.j);
        if (!this.f6628b) {
            this.f6628b = true;
            this.f6627a = iK2;
        }
        int i7 = this.f6627a + 12;
        this.f6627a = i7;
        if (i7 >= i3) {
            this.f6627a = iK2;
        }
        Paint paint = new Paint();
        int i8 = q;
        LinearGradient linearGradient = new LinearGradient(i + i8, this.f6627a, i2 - i8, r4 + i8, new int[]{DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, -419430401, -1, -419430401, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR}, new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f}, Shader.TileMode.MIRROR);
        this.h = linearGradient;
        paint.setShader(linearGradient);
        canvas.drawRect(i + i8, this.f6627a, i2 - i8, r1 + i8, paint);
        float f6 = iK;
        float fWidth = f6 / rectI.width();
        float fHeight = f6 / rectI.height();
        List<ResultPoint> list = this.f;
        List<ResultPoint> list2 = this.g;
        if (list.isEmpty()) {
            this.g = null;
            canvas2 = canvas;
        } else {
            this.f = new ArrayList(5);
            this.g = list;
            paint.setAlpha(160);
            paint.setColor(this.e);
            synchronized (list) {
                for (ResultPoint resultPoint : list) {
                    canvas.drawCircle(((int) (resultPoint.getX() * fWidth)) + i, ((int) (resultPoint.getY() * fHeight)) + iK2, 6.0f, paint);
                }
                canvas2 = canvas;
            }
        }
        if (list2 != null) {
            paint.setAlpha(80);
            paint.setColor(this.e);
            synchronized (list2) {
                for (ResultPoint resultPoint2 : list2) {
                    canvas2.drawCircle(((int) (resultPoint2.getX() * fWidth)) + i, ((int) (resultPoint2.getY() * fHeight)) + iK2, 3.0f, paint);
                }
            }
        }
        postInvalidateDelayed(80L, i - 6, iK2 - 6, i2 + 6, i3 + 6);
    }

    public void setCameraManager(CameraManager cameraManager) {
        this.i = cameraManager;
    }
}
