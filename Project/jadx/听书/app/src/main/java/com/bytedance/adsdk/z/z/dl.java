package com.bytedance.adsdk.z.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.z.z.z.fo;
import com.bytedance.sdk.component.utils.wp;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl<Decoder extends fo<?, ?>> extends Drawable implements g, fo.z {
    private static final String z = "dl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DrawFilter f279a;
    private final Decoder dl;
    private Bitmap e;
    private final Runnable fo;
    private final Paint g;
    private final Matrix gc;
    private final Handler gz;
    private final Set<WeakReference<Drawable.Callback>> kb;
    private final Set<Object> m;
    private boolean uy;
    private boolean wp;

    protected abstract Decoder g(com.bytedance.adsdk.z.z.dl.g gVar, fo.z zVar);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public dl(com.bytedance.adsdk.z.z.dl.g gVar) {
        Paint paint = new Paint();
        this.g = paint;
        this.f279a = new PaintFlagsDrawFilter(0, 3);
        this.gc = new Matrix();
        this.m = new HashSet();
        this.gz = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.z.z.dl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(dl.this.m).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(dl.this.m).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.fo = new Runnable() { // from class: com.bytedance.adsdk.z.z.dl.2
            @Override // java.lang.Runnable
            public void run() {
                dl.this.invalidateSelf();
            }
        };
        this.uy = true;
        this.kb = new HashSet();
        this.wp = false;
        paint.setAntiAlias(true);
        this.dl = (Decoder) g(gVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.dl.uy()) {
            this.dl.fo();
        }
        this.dl.kb();
        dl();
    }

    private void dl() {
        this.dl.z(this);
        if (this.uy) {
            this.dl.gz();
        } else {
            if (this.dl.uy()) {
                return;
            }
            this.dl.gz();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        a();
    }

    private void a() {
        this.dl.g(this);
        if (this.uy) {
            this.dl.fo();
        } else {
            this.dl.gc();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.dl.uy();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.f279a);
        canvas.drawBitmap(this.e, this.gc, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zG = this.dl.g(getBounds().width(), getBounds().height());
        this.gc.setScale(((getBounds().width() * 1.0f) * this.dl.wp()) / this.dl.m().width(), ((getBounds().height() * 1.0f) * this.dl.wp()) / this.dl.m().height());
        if (zG) {
            this.e = Bitmap.createBitmap(this.dl.m().width() / this.dl.wp(), this.dl.m().height() / this.dl.wp(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // com.bytedance.adsdk.z.z.z.fo.z
    public void z() {
        Message.obtain(this.gz, 1).sendToTarget();
    }

    @Override // com.bytedance.adsdk.z.z.z.fo.z
    public void g(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.e;
            if (bitmap == null || bitmap.isRecycled()) {
                this.e = Bitmap.createBitmap(this.dl.m().width() / this.dl.wp(), this.dl.m().height() / this.dl.wp(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.e.getByteCount()) {
                wp.a(z, "onRender:Buffer not large enough for pixels");
            } else {
                this.e.copyPixelsFromBuffer(byteBuffer);
                this.gz.post(this.fo);
            }
        }
    }

    @Override // com.bytedance.adsdk.z.z.z.fo.z
    public void g() {
        Message.obtain(this.gz, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        gc();
        if (this.uy) {
            if (z2) {
                if (!isRunning()) {
                    dl();
                }
            } else if (isRunning()) {
                a();
            }
        }
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.wp) {
            return -1;
        }
        try {
            return this.dl.m().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.wp) {
            return -1;
        }
        try {
            return this.dl.m().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void gc() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z2 = false;
        for (WeakReference weakReference : new HashSet(this.kb)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z2 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.kb.remove((WeakReference) it.next());
        }
        if (z2) {
            return;
        }
        this.kb.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.kb).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }
}
