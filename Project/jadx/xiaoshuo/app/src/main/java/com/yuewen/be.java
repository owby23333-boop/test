package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.duokan.core.sys.AsyncCache;

/* JADX INFO: loaded from: classes2.dex */
public class be extends AsyncCache {

    public static abstract class a extends AsyncCache.e {
        public static final /* synthetic */ boolean k = false;
        public final int e;
        public final int f;
        public final Bitmap.Config g;
        public final Rect h = new Rect();
        public final Rect i = new Rect();
        public Bitmap j = null;

        public a(int i, int i2, Bitmap.Config config) {
            this.e = i;
            this.f = i2;
            this.g = config;
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public final int B() {
            return com.duokan.core.utils.a.G(this.j);
        }

        public final boolean C(Canvas canvas, int i, int i2, float f, Paint paint) {
            if (!j() || !q()) {
                return false;
            }
            if (Float.compare(f, 1.0f) == 0) {
                canvas.drawBitmap(this.j, i, i2, paint);
                return true;
            }
            canvas.save();
            float f2 = i;
            float f3 = i2;
            canvas.translate(f2, f3);
            canvas.scale(f, f);
            canvas.translate(-i, -i2);
            canvas.drawBitmap(this.j, f2, f3, paint);
            canvas.restore();
            return true;
        }

        public final boolean D(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, float f, Paint paint) {
            if (!j() || !q()) {
                return false;
            }
            this.h.set(i3, i4, i5, i6);
            this.i.set(i, i2, this.h.width() + i, this.h.height() + i2);
            canvas.save();
            if (Float.compare(f, 1.0f) == 0) {
                canvas.clipRect(this.i);
                canvas.drawBitmap(this.j, this.h, this.i, paint);
            } else {
                canvas.translate(i, i2);
                canvas.scale(f, f);
                canvas.translate(-i, -i2);
                canvas.clipRect(this.i);
                canvas.drawBitmap(this.j, this.h, this.i, paint);
            }
            canvas.restore();
            return true;
        }

        public abstract void E(Bitmap bitmap);

        @Override // com.duokan.core.sys.AsyncCache.e
        public final int s() {
            return com.duokan.core.utils.a.F(this.e, this.f, this.g);
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public final boolean t() {
            this.j = com.duokan.core.utils.a.d(this.e, this.f, this.g);
            return true;
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public final void v() {
            E(this.j);
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public final void w() {
            Bitmap bitmap = this.j;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.j.recycle();
            this.j = null;
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public final boolean x(AsyncCache.e eVar) {
            a aVar;
            Bitmap bitmap;
            if (!eVar.getClass().equals(getClass()) || (bitmap = (aVar = (a) eVar).j) == null || this.g != bitmap.getConfig() || this.e > aVar.j.getWidth() || this.f > aVar.j.getHeight()) {
                return false;
            }
            this.j = aVar.j;
            aVar.j = null;
            return true;
        }
    }

    public static class b extends AsyncCache.g {
        public final RectF d;
        public final float e;
        public final int f;

        public b(String str, String str2, RectF rectF) {
            this(str, str2, rectF, 1.0f);
        }

        @Override // com.duokan.core.sys.AsyncCache.g
        public int c(AsyncCache.g gVar) {
            b bVar = (b) gVar;
            RectF rectF = new RectF(this.d);
            RectF rectF2 = new RectF(bVar.d);
            if (!TextUtils.equals(b(), gVar.b())) {
                return 0;
            }
            if (Float.compare(this.e, bVar.e) == 0 && rectF.contains(rectF2)) {
                return Integer.MAX_VALUE;
            }
            if (!rectF.intersect(rectF2)) {
                return 0;
            }
            return (int) Math.floor(((double) (Math.min(this.e, bVar.e) / Math.max(this.e, bVar.e))) * (((double) (rectF.width() * rectF.height())) / ((double) (rectF2.width() * rectF2.height()))) * 2.147483647E9d);
        }

        public RectF d() {
            return this.d;
        }

        public float e() {
            return this.e;
        }

        public b(String str, String str2, Rect rect, float f) {
            super(str, str2);
            this.d = new RectF(rect);
            this.e = f;
            this.f = Integer.MAX_VALUE;
        }

        public b(String str, String str2, RectF rectF, float f) {
            super(str, str2);
            this.d = new RectF(rectF);
            this.e = f;
            this.f = Integer.MAX_VALUE;
        }
    }
}
