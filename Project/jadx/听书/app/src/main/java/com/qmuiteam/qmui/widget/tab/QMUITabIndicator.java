package com.qmuiteam.qmui.widget.tab;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabIndicator {
    private int mFixedColor;
    private int mFixedColorAttr;
    private Drawable mIndicatorDrawable;
    private int mIndicatorHeight;
    private Paint mIndicatorPaint;
    private Rect mIndicatorRect;
    private boolean mIndicatorTop;
    private boolean mIsIndicatorWidthFollowContent;
    private boolean mShouldReGetFixedColor;

    public QMUITabIndicator(int i, boolean z, boolean z2) {
        this(i, z, z2, 0);
    }

    public QMUITabIndicator(int i, boolean z, boolean z2, int i2) {
        this.mIndicatorRect = null;
        this.mIndicatorPaint = null;
        this.mShouldReGetFixedColor = true;
        this.mFixedColor = 0;
        this.mIndicatorHeight = i;
        this.mIndicatorTop = z;
        this.mIsIndicatorWidthFollowContent = z2;
        this.mFixedColorAttr = i2;
    }

    public QMUITabIndicator(Drawable drawable, boolean z, boolean z2) {
        this(drawable, z, z2, 0);
    }

    public QMUITabIndicator(Drawable drawable, boolean z, boolean z2, int i) {
        this.mIndicatorTop = false;
        this.mIsIndicatorWidthFollowContent = true;
        this.mIndicatorRect = null;
        this.mIndicatorPaint = null;
        this.mFixedColorAttr = 0;
        this.mShouldReGetFixedColor = true;
        this.mFixedColor = 0;
        this.mIndicatorDrawable = drawable;
        this.mIndicatorHeight = drawable.getIntrinsicHeight();
        this.mIndicatorTop = z;
        this.mIsIndicatorWidthFollowContent = z2;
        this.mFixedColorAttr = i;
    }

    public boolean isIndicatorWidthFollowContent() {
        return this.mIsIndicatorWidthFollowContent;
    }

    public boolean isIndicatorTop() {
        return this.mIndicatorTop;
    }

    @Deprecated
    protected void updateInfo(int i, int i2, int i3) {
        Rect rect = this.mIndicatorRect;
        if (rect == null) {
            this.mIndicatorRect = new Rect(i, 0, i2 + i, 0);
        } else {
            rect.left = i;
            this.mIndicatorRect.right = i + i2;
        }
        if (this.mFixedColorAttr == 0) {
            updateColor(i3);
        }
    }

    protected void updateInfo(int i, int i2, int i3, float f) {
        updateInfo(i, i2, i3);
    }

    protected void updateColor(int i) {
        Drawable drawable = this.mIndicatorDrawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
            return;
        }
        if (this.mIndicatorPaint == null) {
            Paint paint = new Paint();
            this.mIndicatorPaint = paint;
            paint.setStyle(Paint.Style.FILL);
        }
        this.mIndicatorPaint.setColor(i);
    }

    protected void draw(View view, Canvas canvas, int i, int i2) {
        if (this.mIndicatorRect != null) {
            int i3 = this.mFixedColorAttr;
            if (i3 != 0 && this.mShouldReGetFixedColor) {
                this.mShouldReGetFixedColor = false;
                int skinColor = QMUISkinHelper.getSkinColor(view, i3);
                this.mFixedColor = skinColor;
                updateColor(skinColor);
            }
            if (this.mIndicatorTop) {
                this.mIndicatorRect.top = i;
                Rect rect = this.mIndicatorRect;
                rect.bottom = rect.top + this.mIndicatorHeight;
            } else {
                this.mIndicatorRect.bottom = i2;
                Rect rect2 = this.mIndicatorRect;
                rect2.top = rect2.bottom - this.mIndicatorHeight;
            }
            Drawable drawable = this.mIndicatorDrawable;
            if (drawable != null) {
                drawable.setBounds(this.mIndicatorRect);
                this.mIndicatorDrawable.draw(canvas);
            } else {
                canvas.drawRect(this.mIndicatorRect, this.mIndicatorPaint);
            }
        }
    }

    protected void handleSkinChange(QMUISkinManager qMUISkinManager, int i, Resources.Theme theme, QMUITab qMUITab) {
        this.mShouldReGetFixedColor = true;
        if (qMUITab == null || this.mFixedColorAttr != 0) {
            return;
        }
        updateColor(qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : QMUIResHelper.getAttrColor(theme, qMUITab.selectedColorAttr));
    }
}
