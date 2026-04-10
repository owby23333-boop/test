package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* JADX INFO: loaded from: classes.dex */
abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.applyTheme(drawable2, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getCurrent() : super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getPadding(rect) : super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getState() : super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.jumpToCurrentState(drawable2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.setLevel(i) : super.onLevelChange(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspotBounds(drawable2, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        Drawable drawable2 = this.mDelegateDrawable;
        return drawable2 != null ? drawable2.setState(iArr) : super.setState(iArr);
    }
}
