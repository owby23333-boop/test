package com.anythink.core.common.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.anythink.core.common.k.a.f;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private static boolean a = false;

    private static void a(final View view, final int i2) {
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() { // from class: com.anythink.core.common.k.u.1
            @Override // java.lang.Runnable
            public final void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                int i3 = rect.top;
                int i4 = i2;
                rect.top = i3 - i4;
                rect.bottom += i4;
                rect.left -= i4;
                rect.right += i4;
                view2.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    public static boolean b(View view) {
        Rect rect = new Rect();
        return view.getLocalVisibleRect(rect) && rect.top >= 0 && rect.bottom <= view.getHeight() && ((float) rect.height()) > ((float) view.getHeight()) * 0.3f;
    }

    public static void a(final View view, final float f2) {
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() { // from class: com.anythink.core.common.k.u.2
            @Override // java.lang.Runnable
            public final void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                int iWidth = ((int) (rect.width() * (f2 - 1.0f))) / 2;
                int iHeight = ((int) (rect.height() * (f2 - 1.0f))) / 2;
                int i2 = rect.top;
                if (i2 - iHeight < 0) {
                    rect.top = 0;
                } else {
                    rect.top = i2 - iHeight;
                }
                if (rect.bottom + iHeight > view2.getHeight()) {
                    rect.bottom = view2.getHeight();
                } else {
                    rect.bottom += iHeight;
                }
                int i3 = rect.left;
                if (i3 - iWidth < 0) {
                    rect.left = 0;
                } else {
                    rect.left = i3 - iWidth;
                }
                if (rect.right + iWidth > view2.getWidth()) {
                    rect.right = view2.getWidth();
                } else {
                    rect.right += iWidth;
                }
                view2.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    private static Path a(int i2, int i3, int i4) {
        Path path = new Path();
        float f2 = i2;
        path.moveTo(f2, 0.0f);
        float f3 = i3 - i2;
        path.lineTo(f3, 0.0f);
        float f4 = i3;
        path.quadTo(f4, 0.0f, f4, f2);
        float f5 = i4 - i2;
        path.lineTo(f4, f5);
        float f6 = i4;
        path.quadTo(f4, f6, f3, f6);
        path.lineTo(f2, f6);
        path.quadTo(0.0f, f6, 0.0f, f5);
        path.lineTo(0.0f, f2);
        path.quadTo(0.0f, 0.0f, f2, 0.0f);
        path.close();
        return path;
    }

    public static void a(Canvas canvas, int i2, int i3, int i4) {
        try {
            Paint paint = new Paint(1);
            paint.setColor(-1);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            Path path = new Path();
            float f2 = i4;
            path.moveTo(f2, 0.0f);
            float f3 = i2 - i4;
            path.lineTo(f3, 0.0f);
            float f4 = i2;
            path.quadTo(f4, 0.0f, f4, f2);
            float f5 = i3 - i4;
            path.lineTo(f4, f5);
            float f6 = i3;
            path.quadTo(f4, f6, f3, f6);
            path.lineTo(f2, f6);
            path.quadTo(0.0f, f6, 0.0f, f5);
            path.lineTo(0.0f, f2);
            path.quadTo(0.0f, 0.0f, f2, 0.0f);
            path.close();
            canvas2.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Canvas canvas, int i2, int i3, RectF rectF) {
        try {
            Paint paint = new Paint(1);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawArc(rectF, 0.0f, 180.0f, true, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int[] a(int i2, int i3, float f2) {
        if (f2 > i2 / i3) {
            i3 = (int) Math.ceil(r0 / f2);
        } else {
            i2 = (int) Math.ceil(r1 * f2);
        }
        return new int[]{i2, i3};
    }

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void a(boolean z2) {
        a = z2;
    }

    public static boolean a(View view, f.b bVar) {
        if (view != null && view.getParent() != null && bVar != null) {
            Object parent = view.getParent();
            if ((parent instanceof View) && bVar.a((View) parent, view, 100, 0) && !a) {
                return true;
            }
        }
        return false;
    }
}
