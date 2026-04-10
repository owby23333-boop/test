package com.dangdang.zframework.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.dangdang.zframework.R;

/* JADX INFO: loaded from: classes10.dex */
public class CircularProgressView extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int max;
    private Paint paint;
    private int progress;
    private int progressColor;
    private float progressWidth;
    private int roundColor;
    private float roundWidth;
    private int startAngle;
    private int style;

    public CircularProgressView(Context context) {
        this(context, null);
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        float f2 = this.roundWidth;
        int i = (int) (f - (f2 / 2.0f));
        this.paint.setStrokeWidth(f2);
        this.paint.setColor(this.roundColor);
        this.paint.setAntiAlias(true);
        int i2 = this.style;
        if (i2 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
        } else if (i2 == 1) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        canvas.drawCircle(f, f, i, this.paint);
        this.paint.setStrokeWidth(this.progressWidth);
        this.paint.setColor(this.progressColor);
        float f3 = width - i;
        float f4 = width + i;
        RectF rectF = new RectF(f3, f3, f4, f4);
        int i3 = (this.progress * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) / this.max;
        int i4 = this.style;
        if (i4 == 0) {
            canvas.drawArc(rectF, this.startAngle, i3, false, this.paint);
        } else {
            if (i4 != 1) {
                return;
            }
            canvas.drawArc(rectF, this.startAngle, i3, true, this.paint);
        }
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = i;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        this.progress = i;
        postInvalidate();
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleRoundProgress);
        this.roundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.SimpleRoundProgress_srp_roundColor, -65536);
        this.roundWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.SimpleRoundProgress_srp_roundWidth, 5.0f);
        this.progressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.SimpleRoundProgress_srp_progressColor, -16711936);
        this.progressWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.SimpleRoundProgress_srp_progressWidth, this.roundWidth);
        this.max = typedArrayObtainStyledAttributes.getInteger(R.styleable.SimpleRoundProgress_srp_max, 100);
        this.style = typedArrayObtainStyledAttributes.getInt(R.styleable.SimpleRoundProgress_srp_style, 0);
        this.startAngle = typedArrayObtainStyledAttributes.getInt(R.styleable.SimpleRoundProgress_srp_startAngle, 90);
        typedArrayObtainStyledAttributes.recycle();
    }
}
