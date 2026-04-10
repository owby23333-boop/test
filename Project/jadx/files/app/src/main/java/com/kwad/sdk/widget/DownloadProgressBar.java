package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProgressBar extends View {
    private Runnable CY;
    Paint aBG;
    Paint aBH;
    Paint aBI;
    private String aBJ;
    private float aBK;
    private Rect aBL;
    private LinearGradient aBM;
    private LinearGradient aBN;
    private LinearGradient aBO;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.CY = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aBG = new Paint(1);
        this.aBH = new Paint(1);
        this.mRectF = new RectF();
        this.aBI = new Paint(1);
        this.aBI.setTextSize(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
        this.aBI.setColor(-1);
        this.aBI.setTextAlign(Paint.Align.CENTER);
        this.aBL = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.CY);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.aBG.setShader(this.aBM);
        canvas.drawRect(this.mRectF, this.aBG);
        this.aBG.setShader(this.aBN);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aBK) / 100.0f, getHeight(), this.aBG);
        float f2 = this.aBK;
        float f3 = 0.0f;
        if (f2 > 0.0f && f2 < 100.0f) {
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f4 = jElapsedRealtime >= 1500 ? 0.0f : jElapsedRealtime / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f4);
            this.aBO.setLocalMatrix(this.mMatrix);
            this.aBH.setShader(this.aBO);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aBK) / 100.0f) * f4, getHeight(), this.aBH);
            if (jElapsedRealtime > 500 && jElapsedRealtime <= 1500) {
                f3 = (jElapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.aBK) / 100.0f) * f3;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f4);
            this.aBO.setLocalMatrix(this.mMatrix);
            this.aBH.setShader(this.aBO);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.aBH);
        }
        String str = this.aBJ;
        if (str != null) {
            this.aBI.getTextBounds(str, 0, str.length(), this.aBL);
            Rect rect = this.aBL;
            canvas.drawText(this.aBJ, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.aBI);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aBM = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aBN = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aBG.setShader(this.aBM);
        this.aBO = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aBH.setShader(this.aBO);
        float f2 = i2;
        this.mRectF.set(0.0f, 0.0f, f2, i3);
        this.mPath.reset();
        float f3 = f2 / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f3, f3, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 != 0) {
            removeCallbacks(this.CY);
            return;
        }
        float f2 = this.aBK;
        if (f2 <= 0.0f || f2 >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.CY);
    }

    public void setProgress(float f2) {
        this.aBK = f2;
        invalidate();
        if (f2 == 0.0f || f2 == 100.0f) {
            removeCallbacks(this.CY);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.CY);
        }
    }

    public void setText(String str) {
        this.aBJ = str;
        invalidate();
    }
}
