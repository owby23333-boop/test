package com.duokan.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.ColorInt;
import com.yuewen.cw3;
import com.yuewen.dd0;
import com.yuewen.e84;
import com.yuewen.rd2;
import com.yuewen.yc0;

/* JADX INFO: loaded from: classes12.dex */
public class DialogBox implements yc0 {
    private b mOnDismissListener;
    private c mOnShowListener;
    private cw3 mSystemBarConfig;
    private final TopWindow mWindow;

    public class a extends TopWindow {
        public a(Context context, boolean z, boolean z2) {
            super(context, z, z2);
        }

        @Override // com.duokan.core.ui.TopWindow
        public boolean K() {
            return DialogBox.this.onBack();
        }

        @Override // com.duokan.core.ui.TopWindow
        public void L(Configuration configuration) {
            DialogBox.this.onConfigurationChanged(configuration);
        }

        @Override // com.duokan.core.ui.TopWindow
        public void M() {
            DialogBox.this.onDismiss();
            DialogBox.this.l();
            if (DialogBox.this.mSystemBarConfig != null) {
                DialogBox.this.mSystemBarConfig.d();
            }
        }

        @Override // com.duokan.core.ui.TopWindow
        public void N() {
            DialogBox.this.onShow();
            DialogBox.this.m();
            if (DialogBox.this.mSystemBarConfig != null) {
                DialogBox.this.mSystemBarConfig.a(this);
            }
        }

        @Override // com.duokan.core.ui.TopWindow
        public boolean O() {
            return DialogBox.this.onTouchOutside();
        }
    }

    public interface b {
        void a(DialogBox dialogBox);
    }

    public interface c {
        void a(DialogBox dialogBox);
    }

    public DialogBox(Context context) {
        this(context, false, false);
    }

    @Override // com.yuewen.yc0
    public void close() {
        dismiss();
    }

    public void dismiss() {
        this.mWindow.dismiss();
    }

    public cw3 ensureSystemBarConfig() {
        if (this.mSystemBarConfig == null) {
            this.mSystemBarConfig = new cw3();
        }
        return this.mSystemBarConfig;
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.mWindow.w(i);
    }

    public Activity getActivity() {
        return this.mWindow.x();
    }

    public BalloonView getBalloon(int i) {
        return this.mWindow.y(i);
    }

    public int getBalloonCount() {
        return this.mWindow.z();
    }

    public View getContentView() {
        return this.mWindow.getContentView();
    }

    public Context getContext() {
        return this.mWindow.A();
    }

    public dd0 getDecorView() {
        return this.mWindow.B();
    }

    public final Boolean getShowNavigationBar() {
        return Boolean.valueOf(this.mWindow.D().equalsValue(Boolean.TRUE));
    }

    public void initPortraitNavBar() {
    }

    public boolean isFocusable() {
        return this.mWindow.F();
    }

    @Override // com.yuewen.yc0
    public boolean isOpened() {
        return isShowing();
    }

    public boolean isShowing() {
        return this.mWindow.isShowing();
    }

    public final void l() {
        b bVar = this.mOnDismissListener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final void m() {
        c cVar = this.mOnShowListener;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public boolean onBack() {
        return false;
    }

    public void onCancel() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public boolean onTouchOutside() {
        return false;
    }

    public void removeBalloon(BalloonView balloonView) {
        this.mWindow.P(balloonView);
    }

    public void setBalloonPadding(int i, int i2, int i3, int i4) {
        this.mWindow.Q(i, i2, i3, i4);
    }

    public void setConsumeTouchEvents(boolean z) {
        this.mWindow.S(z);
    }

    public void setContentView(int i) {
        this.mWindow.T(i);
    }

    public void setDimAmount(float f) {
        this.mWindow.W(f);
    }

    public void setEnterAnimation(int i) {
        this.mWindow.X(i);
    }

    public void setExitAnimation(int i) {
        this.mWindow.Z(i);
    }

    public void setFloatNavigation(boolean z) {
        getDecorView().setFloatNavigation(z);
        useActivityNavigation(false);
    }

    public void setFocusable(boolean z) {
        this.mWindow.b0(z);
    }

    public void setGravity(int i) {
        this.mWindow.c0(i);
    }

    public void setLightNavigationBar(boolean z) {
        ensureSystemBarConfig().c = Boolean.valueOf(z);
    }

    public void setLightStatusBar(boolean z) {
        this.mWindow.e0(new rd2<>(Boolean.valueOf(z)));
    }

    public void setNavigationColor(@ColorInt int i) {
        ensureSystemBarConfig().f10010a = Integer.valueOf(i);
    }

    public void setOnDismissListener(b bVar) {
        this.mOnDismissListener = bVar;
    }

    public void setOnShowListener(c cVar) {
        this.mOnShowListener = cVar;
    }

    public void setResizeForSoftInput(boolean z) {
        this.mWindow.f0(z);
    }

    public void setShowNavigationBar(boolean z) {
        this.mWindow.h0(Boolean.valueOf(z));
        if (z) {
            return;
        }
        setFloatNavigation(true);
    }

    public void setShowStatusBar(boolean z) {
        this.mWindow.i0(new rd2<>(Boolean.valueOf(z)));
    }

    public void setWindowColor(@ColorInt int i) {
        this.mWindow.B().setBackgroundColor(i);
    }

    public void show() {
        this.mWindow.show();
    }

    public void showBalloon(BalloonView balloonView, View view) {
        this.mWindow.l0(balloonView, view);
    }

    public void useActivityNavigation(boolean z) {
        if (z || this.mSystemBarConfig != null) {
            ensureSystemBarConfig().f10011b = z;
        }
    }

    public DialogBox(Context context, boolean z) {
        this(context, z, false);
    }

    public void setContentView(View view) {
        this.mWindow.V(view, view.getLayoutParams() != null ? view.getLayoutParams() : new ViewGroup.LayoutParams(-1, -2));
    }

    public void setEnterAnimation(Animation animation) {
        this.mWindow.Y(animation);
    }

    public void setExitAnimation(Animation animation) {
        this.mWindow.a0(animation);
    }

    public void showBalloon(BalloonView balloonView, View view, ViewGroup.LayoutParams layoutParams) {
        this.mWindow.m0(balloonView, view, layoutParams);
    }

    public DialogBox(Context context, boolean z, boolean z2) {
        this.mOnShowListener = null;
        this.mOnDismissListener = null;
        a aVar = new a(context, z, z2);
        this.mWindow = aVar;
        boolean zZ0 = e84.z0(getContext());
        getDecorView().q(0.6f, zZ0);
        if (zZ0) {
            setNavigationColor(0);
        } else {
            initPortraitNavBar();
        }
        aVar.S(true);
        useActivityNavigation(true);
    }

    public void showBalloon(BalloonView balloonView, Rect rect) {
        this.mWindow.j0(balloonView, rect);
    }

    public void showBalloon(BalloonView balloonView, Rect rect, ViewGroup.LayoutParams layoutParams) {
        this.mWindow.k0(balloonView, rect, layoutParams);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mWindow.V(view, layoutParams);
    }
}
