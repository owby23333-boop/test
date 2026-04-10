package drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes8.dex */
public class RoundCornerDrawable extends Drawable {
    private final Drawable mOrigin;
    private Paint mPaint;
    private final float[] mRadius;
    private Path mRectPath;
    private Path mRoundPath;
    private PorterDuffXfermode mXferMode;

    public RoundCornerDrawable(Drawable drawable2, float f, float f2) {
        this(drawable2, f, f, f2, f2);
    }

    private void preparePaint() {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(0);
        this.mXferMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    private void prepareRegion() {
        this.mRectPath = new Path();
        this.mRoundPath = new Path();
    }

    private void resetBeforeDraw() {
        this.mRectPath.rewind();
        this.mRoundPath.rewind();
    }

    private void setRoundCornerRadius(float f, float f2, float f3, float f4) {
        float[] fArr = this.mRadius;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f3;
        fArr[5] = f3;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        setBounds(this.mOrigin.getBounds());
        int iSaveLayer = canvas.saveLayer(r8.left, r8.top, r8.right, r8.bottom, this.mPaint);
        this.mOrigin.draw(canvas);
        resetBeforeDraw();
        this.mRectPath.addRect(r8.left, r8.top, r8.right, r8.bottom, Path.Direction.CW);
        this.mRoundPath.addRoundRect(r8.left, r8.top, r8.right, r8.bottom, this.mRadius, Path.Direction.CW);
        this.mRectPath.op(this.mRoundPath, Path.Op.DIFFERENCE);
        this.mPaint.setXfermode(this.mXferMode);
        canvas.drawPath(this.mRectPath, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mOrigin.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mOrigin.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mOrigin.setColorFilter(colorFilter);
    }

    public RoundCornerDrawable(Drawable drawable2, float f, float f2, float f3, float f4) {
        this.mRadius = new float[8];
        this.mOrigin = drawable2;
        setRoundCornerRadius(f, f2, f3, f4);
        preparePaint();
        prepareRegion();
    }
}
