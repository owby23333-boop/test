package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bytedance.adsdk.lottie.fo;

/* JADX INFO: loaded from: classes2.dex */
public class VideoFrame extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RenderScript f181a;
    private final fo.z.C0038z dl;
    private Bitmap e;
    private final Matrix g;
    private ScriptIntrinsicBlur gc;
    private int gz;
    private long m;
    private final TextureView z;

    public VideoFrame(Context context, TextureView textureView, fo.z.C0038z c0038z) {
        super(context);
        this.m = -1L;
        this.e = null;
        this.gz = 0;
        this.z = textureView;
        this.g = new Matrix();
        this.dl = c0038z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.m >= 40) {
            this.m = jElapsedRealtime;
            TextureView textureView = this.z;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.z.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.gz = (int) (this.z.getHeight() / width);
                }
                int i = this.gz;
                if (i > 0 && (bitmap2 = this.z.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.e;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.e.recycle();
                    }
                    this.e = z(bitmap2, this.dl.z);
                    bitmap2.recycle();
                }
            }
        }
        if (this.gz <= 0 || (bitmap = this.e) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.g.reset();
        this.g.setScale(getWidth() / 160.0f, getHeight() / this.gz);
        canvas.concat(this.g);
        canvas.drawBitmap(this.e, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.f181a;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.gc;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.f181a = renderScriptCreate;
        this.gc = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.gc;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.gc = null;
        }
        RenderScript renderScript = this.f181a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f181a = null;
        }
    }

    public Bitmap z(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.f181a;
            if (renderScript != null && this.gc != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.f181a, allocationCreateFromBitmap.getType());
                this.gc.setRadius(f);
                this.gc.setInput(allocationCreateFromBitmap);
                this.gc.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.wp.z(th);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmapCreateBitmap = null;
        }
    }
}
