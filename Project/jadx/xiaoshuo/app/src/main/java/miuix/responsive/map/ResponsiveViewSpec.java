package miuix.responsive.map;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public class ResponsiveViewSpec {
    private int mEffectiveScreenOrientation;
    private int mHideInScreenMode;

    @Nullable
    private View mView;
    private int mViewId;

    public ResponsiveViewSpec(int i) {
        this.mViewId = i;
    }

    public int getEffectiveScreenOrientation() {
        return this.mEffectiveScreenOrientation;
    }

    public int getHideInScreenMode() {
        return this.mHideInScreenMode;
    }

    public View getView() {
        return this.mView;
    }

    public int getViewId() {
        return this.mViewId;
    }

    public void onResponsiveState(ScreenSpec screenSpec) {
        int i = screenSpec.screenMode & 7;
        View view = this.mView;
        if (view != null) {
            view.setVisibility(this.mHideInScreenMode < i ? 0 : 8);
        }
    }

    public void setEffectiveScreenOrientation(int i) {
        this.mEffectiveScreenOrientation = i;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public ResponsiveViewSpec(int i, int i2) {
        this.mViewId = i;
        this.mHideInScreenMode = i2;
    }
}
