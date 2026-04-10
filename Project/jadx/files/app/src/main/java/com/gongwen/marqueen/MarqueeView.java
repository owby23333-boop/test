package com.gongwen.marqueen;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class MarqueeView<T extends View, E> extends ViewFlipper implements Observer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected com.gongwen.marqueen.a<T, E> f14895s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f14896t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f14897u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.gongwen.marqueen.d.b<T, E> f14898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f14899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final View.OnClickListener f14900x;

    class a extends com.gongwen.marqueen.d.a {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MarqueeView.this.a();
            if (animation != null) {
                animation.setAnimationListener(null);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MarqueeView.this.f14898v != null) {
                com.gongwen.marqueen.a<T, E> aVar = MarqueeView.this.f14895s;
                if (aVar == null || com.gongwen.marqueen.d.c.a(aVar.a()) || MarqueeView.this.getChildCount() == 0) {
                    MarqueeView.this.f14898v.a(null, null, -1);
                    return;
                }
                int displayedChild = MarqueeView.this.getDisplayedChild();
                MarqueeView.this.f14898v.a(MarqueeView.this.getCurrentView(), MarqueeView.this.f14895s.a().get(displayedChild), displayedChild);
            }
        }
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException unused) {
            stopFlipping();
        }
    }

    public void setAnimDuration(long j2) {
        if (getInAnimation() != null) {
            getInAnimation().setDuration(j2);
        }
        if (getOutAnimation() != null) {
            getOutAnimation().setDuration(j2);
        }
    }

    public void setMarqueeFactory(com.gongwen.marqueen.a<T, E> aVar) {
        this.f14895s = aVar;
        aVar.a((MarqueeView) this);
        a();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        if (!this.f14899w) {
            throw new UnsupportedOperationException("The setOnClickListener method is not supported,please use setOnItemClickListener method.");
        }
        super.setOnClickListener(onClickListener);
        this.f14899w = false;
    }

    public void setOnItemClickListener(com.gongwen.marqueen.d.b<T, E> bVar) {
        this.f14898v = bVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj != null && "UPDATE_DATA".equals(obj.toString())) {
            Animation inAnimation = getInAnimation();
            if (inAnimation == null || !inAnimation.hasStarted()) {
                a();
            } else {
                inAnimation.setAnimationListener(new a());
            }
        }
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14896t = R$anim.in_bottom;
        this.f14897u = R$anim.out_top;
        this.f14899w = true;
        this.f14900x = new b();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (getInAnimation() == null || getOutAnimation() == null) {
            setInAnimation(getContext(), this.f14896t);
            setOutAnimation(getContext(), this.f14897u);
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MarqueeView);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MarqueeView_marqueeAnimDuration)) {
            long j2 = typedArrayObtainStyledAttributes.getInt(R$styleable.MarqueeView_marqueeAnimDuration, -1);
            getInAnimation().setDuration(j2);
            getOutAnimation().setDuration(j2);
        }
        typedArrayObtainStyledAttributes.recycle();
        setOnClickListener(this.f14900x);
    }

    protected void a() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        List<T> listB = this.f14895s.b();
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addView(listB.get(i2));
        }
    }
}
