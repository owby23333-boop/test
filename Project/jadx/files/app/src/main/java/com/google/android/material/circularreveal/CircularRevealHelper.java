package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15212j;
    private final a a;

    @NonNull
    private final View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Path f15213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final Paint f15214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    private final Paint f15215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private b.e f15216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f15217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15219i;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f15212j = 2;
        } else if (i2 >= 18) {
            f15212j = 1;
        } else {
            f15212j = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(a aVar) {
        this.a = aVar;
        this.b = (View) aVar;
        this.b.setWillNotDraw(false);
        this.f15213c = new Path();
        this.f15214d = new Paint(7);
        this.f15215e = new Paint(1);
        this.f15215e.setColor(0);
    }

    private void g() {
        if (f15212j == 1) {
            this.f15213c.rewind();
            b.e eVar = this.f15216f;
            if (eVar != null) {
                this.f15213c.addCircle(eVar.a, eVar.b, eVar.f15223c, Path.Direction.CW);
            }
        }
        this.b.invalidate();
    }

    private boolean h() {
        b.e eVar = this.f15216f;
        boolean z2 = eVar == null || eVar.a();
        return f15212j == 0 ? !z2 && this.f15219i : !z2;
    }

    private boolean i() {
        return (this.f15218h || this.f15217g == null || this.f15216f == null) ? false : true;
    }

    private boolean j() {
        return (this.f15218h || Color.alpha(this.f15215e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f15212j == 0) {
            this.f15218h = true;
            this.f15219i = false;
            this.b.buildDrawingCache();
            Bitmap drawingCache = this.b.getDrawingCache();
            if (drawingCache == null && this.b.getWidth() != 0 && this.b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f15214d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f15218h = false;
            this.f15219i = true;
        }
    }

    public void b() {
        if (f15212j == 0) {
            this.f15219i = false;
            this.b.destroyDrawingCache();
            this.f15214d.setShader(null);
            this.b.invalidate();
        }
    }

    @Nullable
    public Drawable c() {
        return this.f15217g;
    }

    @ColorInt
    public int d() {
        return this.f15215e.getColor();
    }

    @Nullable
    public b.e e() {
        b.e eVar = this.f15216f;
        if (eVar == null) {
            return null;
        }
        b.e eVar2 = new b.e(eVar);
        if (eVar2.a()) {
            eVar2.f15223c = b(eVar2);
        }
        return eVar2;
    }

    public boolean f() {
        return this.a.c() && !h();
    }

    private float b(@NonNull b.e eVar) {
        return com.google.android.material.h.a.a(eVar.a, eVar.b, 0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
    }

    private void b(@NonNull Canvas canvas) {
        if (i()) {
            Rect bounds = this.f15217g.getBounds();
            float fWidth = this.f15216f.a - (bounds.width() / 2.0f);
            float fHeight = this.f15216f.b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f15217g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    public void a(@Nullable b.e eVar) {
        if (eVar == null) {
            this.f15216f = null;
        } else {
            b.e eVar2 = this.f15216f;
            if (eVar2 == null) {
                this.f15216f = new b.e(eVar);
            } else {
                eVar2.a(eVar);
            }
            if (com.google.android.material.h.a.a(eVar.f15223c, b(eVar), 1.0E-4f)) {
                this.f15216f.f15223c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public void a(@ColorInt int i2) {
        this.f15215e.setColor(i2);
        this.b.invalidate();
    }

    public void a(@Nullable Drawable drawable) {
        this.f15217g = drawable;
        this.b.invalidate();
    }

    public void a(@NonNull Canvas canvas) {
        if (h()) {
            int i2 = f15212j;
            if (i2 == 0) {
                b.e eVar = this.f15216f;
                canvas.drawCircle(eVar.a, eVar.b, eVar.f15223c, this.f15214d);
                if (j()) {
                    b.e eVar2 = this.f15216f;
                    canvas.drawCircle(eVar2.a, eVar2.b, eVar2.f15223c, this.f15215e);
                }
            } else if (i2 == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f15213c);
                this.a.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f15215e);
                }
                canvas.restoreToCount(iSave);
            } else if (i2 == 2) {
                this.a.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f15215e);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f15212j);
            }
        } else {
            this.a.a(canvas);
            if (j()) {
                canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f15215e);
            }
        }
        b(canvas);
    }
}
