package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.anythink.basead.c.h;
import com.anythink.core.common.e.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseShakeView extends LinearLayout {
    protected ImageView a;
    h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Animation f6158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f6160e;

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$2, reason: invalid class name */
    final class AnonymousClass2 implements Animation.AnimationListener {
        AnonymousClass2() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
            BaseShakeView.b(BaseShakeView.this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$3, reason: invalid class name */
    final class AnonymousClass3 implements Interpolator {
        AnonymousClass3() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            if ((BaseShakeView.this.f6159d / 2) % 3 == 0) {
                return 0.0f;
            }
            return f2;
        }
    }

    protected interface a {
        boolean a();
    }

    public BaseShakeView(Context context) {
        super(context);
        this.f6159d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.f6160e != null) {
                    return BaseShakeView.this.f6160e.a();
                }
                return false;
            }
        };
        a();
    }

    static /* synthetic */ int b(BaseShakeView baseShakeView) {
        int i2 = baseShakeView.f6159d;
        baseShakeView.f6159d = i2 + 1;
        return i2;
    }

    abstract void a();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.f6158c = new RotateAnimation(-10.0f, 10.0f, 1, 0.8f, 1, 0.8f);
            this.f6158c.setDuration(150L);
            this.f6158c.setRepeatMode(2);
            this.f6158c.setRepeatCount(-1);
            this.f6158c.setAnimationListener(new AnonymousClass2());
            this.f6158c.setInterpolator(new AnonymousClass3());
            this.a.startAnimation(this.f6158c);
        }
        com.anythink.expressad.shake.a.a().a(this.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animation animation = this.f6158c;
        if (animation != null) {
            animation.cancel();
        }
        com.anythink.expressad.shake.a.a().b(this.b);
    }

    public void setOnShakeListener(a aVar, k kVar) {
        this.b.a(kVar.N(), kVar.O());
        this.f6160e = aVar;
    }

    private void b() {
        if (this.a != null) {
            this.f6158c = new RotateAnimation(-10.0f, 10.0f, 1, 0.8f, 1, 0.8f);
            this.f6158c.setDuration(150L);
            this.f6158c.setRepeatMode(2);
            this.f6158c.setRepeatCount(-1);
            this.f6158c.setAnimationListener(new AnonymousClass2());
            this.f6158c.setInterpolator(new AnonymousClass3());
            this.a.startAnimation(this.f6158c);
        }
    }

    public BaseShakeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6159d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.f6160e != null) {
                    return BaseShakeView.this.f6160e.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6159d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.f6160e != null) {
                    return BaseShakeView.this.f6160e.a();
                }
                return false;
            }
        };
        a();
    }

    @RequiresApi(api = 21)
    public BaseShakeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f6159d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.f6160e != null) {
                    return BaseShakeView.this.f6160e.a();
                }
                return false;
            }
        };
        a();
    }
}
