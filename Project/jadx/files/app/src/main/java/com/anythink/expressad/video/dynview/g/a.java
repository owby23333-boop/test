package com.anythink.expressad.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ShapeDrawable {
    private int a;
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f11626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f11629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f11630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f11632i;

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.g.a$a, reason: collision with other inner class name */
    public static class C0223a implements b {
        private RectShape a;
        private Bitmap b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap f11633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f11635e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11637g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f11638h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f11639i;

        /* synthetic */ C0223a(byte b) {
            this();
        }

        private C0223a() {
            this.f11636f = 100;
            this.f11637g = 10;
            this.a = new RectShape();
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(Bitmap bitmap) {
            this.f11633c = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b c(int i2) {
            this.f11637g = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a() {
            this.f11634d = true;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(float f2) {
            this.f11639i = f2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(int i2) {
            this.f11635e = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b b(int i2) {
            this.f11636f = i2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final b a(float f2) {
            this.f11638h = f2;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final a b() {
            return new a(this, (byte) 0);
        }
    }

    public interface b {
        b a();

        b a(float f2);

        b a(int i2);

        b a(Bitmap bitmap);

        b b(float f2);

        b b(int i2);

        b b(Bitmap bitmap);

        a b();

        b c(int i2);
    }

    /* synthetic */ a(C0223a c0223a, byte b2) {
        this(c0223a);
    }

    private void a(Canvas canvas) {
        float f2 = this.f11626c / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, (this.f11627d + f2) - this.f11628e);
        path.lineTo(this.b, (f2 - this.f11627d) - this.f11628e);
        path.lineTo(this.b, 0.0f);
        if (this.f11631h) {
            try {
                a(canvas, path);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f11629f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f11629f);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(0.0f, this.f11627d + f2 + this.f11628e);
        path2.lineTo(0.0f, this.f11626c);
        path2.lineTo(this.b, this.f11626c);
        path2.lineTo(this.b, (f2 - this.f11627d) + this.f11628e);
        if (this.f11631h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.f11630g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.f11630g);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void b(Canvas canvas) {
        float f2 = this.b / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, this.f11626c);
        path.lineTo((f2 - this.f11627d) - this.f11628e, this.f11626c);
        path.lineTo((this.f11627d + f2) - this.f11628e, 0.0f);
        if (this.f11631h) {
            try {
                a(canvas, path);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f11629f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f11629f);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(this.f11627d + f2 + this.f11628e, 0.0f);
        path2.lineTo(this.b, 0.0f);
        path2.lineTo(this.b, this.f11626c);
        path2.lineTo((f2 - this.f11627d) + this.f11628e, this.f11626c);
        if (this.f11631h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.f11630g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.f11630g);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.a == 1) {
            float f2 = this.f11626c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.f11627d + f2) - this.f11628e);
            path.lineTo(this.b, (f2 - this.f11627d) - this.f11628e);
            path.lineTo(this.b, 0.0f);
            if (this.f11631h) {
                try {
                    a(canvas, path);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f11629f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f11629f);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, this.f11627d + f2 + this.f11628e);
            path2.lineTo(0.0f, this.f11626c);
            path2.lineTo(this.b, this.f11626c);
            path2.lineTo(this.b, (f2 - this.f11627d) + this.f11628e);
            if (this.f11631h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            Bitmap bitmap2 = this.f11630g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.f11630g);
                return;
            } catch (Exception e5) {
                e5.printStackTrace();
                return;
            }
        }
        float f3 = this.b / 2.0f;
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.f11626c);
        path3.lineTo((f3 - this.f11627d) - this.f11628e, this.f11626c);
        path3.lineTo((this.f11627d + f3) - this.f11628e, 0.0f);
        if (this.f11631h) {
            try {
                a(canvas, path3);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else {
            Bitmap bitmap3 = this.f11629f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f11629f);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }
        Path path4 = new Path();
        path4.moveTo(this.f11627d + f3 + this.f11628e, 0.0f);
        path4.lineTo(this.b, 0.0f);
        path4.lineTo(this.b, this.f11626c);
        path4.lineTo((f3 - this.f11627d) + this.f11628e, this.f11626c);
        if (this.f11631h) {
            try {
                a(canvas, path4);
                return;
            } catch (Exception e8) {
                e8.printStackTrace();
                return;
            }
        }
        Bitmap bitmap4 = this.f11630g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.f11630g);
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    private a(C0223a c0223a) {
        super(c0223a.a);
        this.f11631h = false;
        this.f11629f = c0223a.b;
        this.f11630g = c0223a.f11633c;
        this.f11631h = c0223a.f11634d;
        this.a = c0223a.f11635e;
        this.f11627d = c0223a.f11636f;
        this.f11628e = c0223a.f11637g;
        this.b = c0223a.f11638h;
        this.f11626c = c0223a.f11639i;
        this.f11632i = new Paint();
        this.f11632i.setStyle(Paint.Style.FILL);
        this.f11632i.setAntiAlias(true);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f11632i.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawPath(path, this.f11632i);
    }

    private void a(Canvas canvas, Path path) {
        this.f11632i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f11632i);
    }

    public static C0223a a() {
        return new C0223a((byte) 0);
    }
}
