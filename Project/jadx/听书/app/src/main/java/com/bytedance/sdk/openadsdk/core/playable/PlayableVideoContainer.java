package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableVideoContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f1293a;
    private float dl;
    private long e;
    private float g;
    private View gc;
    private View.OnClickListener gz;
    private View m;
    private final Paint z;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.z = new Paint();
        this.e = 0L;
        g();
    }

    private void g() {
        int iDl = oq.dl(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iDl, iDl, iDl, iDl);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.f1293a = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.gc = dl();
        frameLayout.addView(this.gc, new ViewGroup.MarginLayoutParams(-1, -1));
        this.m = a();
        frameLayout.addView(this.m, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), oq.dl(zw.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    public void z() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = oq.dl(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = oq.dl(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    private View dl() {
        int iDl = oq.dl(getContext(), 8.0f);
        int iDl2 = oq.dl(getContext(), 7.0f);
        int iDl3 = oq.dl(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        tb.z(getContext(), "tt_arrow_up", imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDl2, iDl3);
        layoutParams2.setMargins(iDl, iDl, iDl, iDl);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        tb.z(getContext(), "tt_arrow_down", imageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iDl2, iDl3);
        layoutParams3.setMargins(iDl, iDl, iDl, iDl);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        tb.z(getContext(), "tt_arrow_left", imageView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iDl3, iDl2);
        layoutParams4.setMargins(iDl, iDl, iDl, iDl);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        tb.z(getContext(), "tt_arrow_right", imageView4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iDl3, iDl2);
        layoutParams5.setMargins(iDl, iDl, iDl, iDl);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public FrameLayout getVideoContainer() {
        return this.f1293a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = motionEvent.getX();
            this.dl = motionEvent.getY();
            this.e = SystemClock.elapsedRealtime();
        } else {
            if (action == 1) {
                float fAbs = Math.abs(motionEvent.getX() - this.g);
                float fAbs2 = Math.abs(motionEvent.getY() - this.dl);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.e;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    gc();
                    return true;
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.g;
                float y = motionEvent.getY() - this.dl;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int top2 = (int) (getTop() + y);
                    z(left, top2, getWidth() + left, getHeight() + top2);
                }
            } else if (action == 3) {
            }
            m();
            setPressed(false);
        }
        return true;
    }

    private void gc() {
        View.OnClickListener onClickListener = this.gz;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void m() {
        int height;
        final int height2;
        final int width;
        int width2;
        int iA = oq.a(getContext());
        int iGc = oq.gc(getContext());
        final int left = getLeft();
        final int top2 = getTop();
        int left2 = getLeft();
        int right = iA - getRight();
        int top3 = getTop();
        int bottom = iGc - getBottom();
        int iDl = oq.dl(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top3, bottom));
        if (left2 == iMin) {
            getWidth();
            int top4 = getTop();
            int bottom2 = getBottom();
            if (top4 < 0) {
                bottom2 = iDl + getHeight();
                top4 = iDl;
            }
            height2 = bottom2 > iGc ? (iGc - iDl) - getHeight() : top4;
            width = iDl;
        } else if (right == iMin) {
            width2 = (iA - iDl) - getWidth();
            int top5 = getTop();
            int bottom3 = getBottom();
            if (top5 < 0) {
                bottom3 = iDl + getHeight();
                top5 = iDl;
            }
            if (bottom3 > iGc) {
                height = (iGc - iDl) - getHeight();
                width = width2;
                height2 = height;
            } else {
                width = width2;
                height2 = top5;
            }
        } else if (top3 == iMin) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = iDl + getWidth();
                left3 = iDl;
            }
            width = right2 > iA ? (iA - iDl) - getWidth() : left3;
            height2 = iDl;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (iGc - iDl) - getHeight();
            if (left4 < 0) {
                right3 = iDl + getWidth();
                left4 = iDl;
            }
            if (right3 > iA) {
                width2 = (iA - iDl) - getWidth();
                width = width2;
                height2 = height;
            } else {
                height2 = height;
                width = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (left + ((width - r0) * animatedFraction));
                int i2 = (int) (top2 + ((height2 - r1) * animatedFraction));
                PlayableVideoContainer.this.z(i, i2, PlayableVideoContainer.this.getWidth() + i, PlayableVideoContainer.this.getHeight() + i2);
            }
        });
        duration.start();
    }

    public void z(boolean z) {
        if (z) {
            oq.z(this.m, 0);
            oq.z(this.gc, 8);
        } else {
            oq.z(this.m, 8);
        }
    }

    public void g(boolean z) {
        if (z) {
            oq.z(this.gc, 0);
            oq.z(this.m, 8);
        } else {
            oq.z(this.gc, 8);
        }
    }

    public void z(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        this.z.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.z.setColor(SupportMenu.CATEGORY_MASK);
        this.z.setStyle(Paint.Style.STROKE);
        this.z.setAntiAlias(true);
        this.z.setStrokeWidth(oq.dl(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), oq.dl(getContext(), 12.0f), oq.dl(getContext(), 12.0f), this.z);
        return zDrawChild;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.gz = onClickListener;
    }
}
