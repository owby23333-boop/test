package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ScaleSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f4487s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f4488t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f4489u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Bitmap f4490v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b f4491w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f4492x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Paint f4493y;

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        ScaleSeekBar a;

        a(ScaleSeekBar scaleSeekBar) {
            this.a = scaleSeekBar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i2;
            if ((seekBar != null ? seekBar.getProgress() : 0) < 13) {
                if (seekBar != null) {
                    seekBar.setProgress(0);
                }
                i2 = 1;
            } else if (seekBar.getProgress() < 38) {
                seekBar.setProgress(25);
                i2 = 2;
            } else if (seekBar.getProgress() < 63) {
                seekBar.setProgress(50);
                i2 = 3;
            } else if (seekBar.getProgress() < 88) {
                seekBar.setProgress(75);
                i2 = 4;
            } else {
                seekBar.setProgress(100);
                i2 = 5;
            }
            b bVar = this.a.f4491w;
            if (bVar != null) {
                bVar.a(i2);
            }
        }
    }

    public interface b {
        void a(int i2);
    }

    public ScaleSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4487s = Color.parseColor("#ffffff");
        this.f4488t = Color.parseColor("#ffffff");
        this.f4489u = Color.parseColor("#c5c5c5");
        this.f4492x = new a(this);
        this.f4493y = new Paint();
        a();
    }

    private void a() {
        this.f4490v = BitmapFactory.decodeResource(getResources(), R.drawable.read_seek_bar_thumb, null);
        setOnSeekBarChangeListener(this.f4492x);
    }

    private int b(int i2) {
        return i2 == 0 ? this.f4488t : i2 == 4 ? this.f4489u : i2 * 25 < getProgress() ? this.f4488t : this.f4489u;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4493y.setAntiAlias(true);
        this.f4493y.setStrokeWidth(2.0f);
        Bitmap bitmap = this.f4490v;
        double width = bitmap != null ? bitmap.getWidth() : 0;
        Double.isNaN(width);
        int i2 = (int) (width * 0.7d);
        float width2 = (getWidth() - (i2 * 2)) / 4.0f;
        for (int i3 = 0; i3 <= 4; i3++) {
            int iA = a(i3);
            int iB = b(i3);
            this.f4493y.setColor(iA);
            if (canvas != null) {
                canvas.drawCircle(i2 + (i3 * width2), getHeight() / 2.0f, com.amgcyo.cuttadon.utils.otherutils.g.a(4.0f), this.f4493y);
            }
            this.f4493y.setColor(iB);
            if (canvas != null) {
                canvas.drawCircle(i2 + (i3 * width2), getHeight() / 2.0f, com.amgcyo.cuttadon.utils.otherutils.g.a(2.5f), this.f4493y);
            }
        }
        if (this.f4490v != null) {
            float progress = width2 * 4.0f * getProgress() * 0.01f;
            if (canvas != null) {
                Bitmap bitmap2 = this.f4490v;
                int height = getHeight();
                canvas.drawBitmap(bitmap2, progress, (height - (this.f4490v != null ? r5.getHeight() : 0)) / 2.0f, this.f4493y);
            }
        }
    }

    public void setLevel(int i2) {
        setProgress(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 100 : 75 : 50 : 25 : 0);
    }

    public final void setScaleSeekBarListener(b bVar) {
        this.f4491w = bVar;
    }

    private int a(int i2) {
        if (i2 == 0) {
            return o.b(R.color.colorPrimary);
        }
        if (i2 == 4) {
            return this.f4487s;
        }
        if (i2 * 25 < getProgress()) {
            return o.b(R.color.colorPrimary);
        }
        return this.f4487s;
    }
}
