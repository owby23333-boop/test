package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b aal;
    private b aam;
    private SurfaceTexture aan;
    private TextView aao;
    public Surface aap;
    private a aaq;
    private PhotoInfo.VideoInfo aar;
    private boolean aas;
    private final RectF aat;
    private int aau;
    private int aav;
    private final d aaw;
    private Matrix mMatrix;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.aas = false;
        this.aat = new RectF();
        this.aau = 0;
        this.aav = 0;
        this.aaw = new d();
        B(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aas = false;
        this.aat = new RectF();
        this.aau = 0;
        this.aav = 0;
        this.aaw = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.aal = new com.kwad.components.core.page.widget.b(context);
        addView(this.aal, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        tH();
    }

    public void setIsAlphaVideoView(boolean z) {
        com.kwad.components.core.page.widget.b bVar;
        this.aas = z;
        if (!z || (bVar = this.aal) == null) {
            return;
        }
        bVar.setOpaque(false);
    }

    private void tH() {
        com.kwad.components.core.page.widget.b bVar;
        if (this.aas && (bVar = this.aal) != null) {
            bVar.setOpaque(false);
        }
        this.aal.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.aan == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.aan = surfaceTexture;
                DetailVideoView.this.tI();
                DetailVideoView.this.aap = new Surface(surfaceTexture);
                if (DetailVideoView.this.aam != null) {
                    DetailVideoView.this.aam.setSurface(DetailVideoView.this.aap);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        Surface surface = this.aap;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            this.aap = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tI();
        SurfaceTexture surfaceTexture = this.aan;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.aan = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.aau;
        if (i6 <= 0 || (i5 = this.aav) <= 0) {
            return;
        }
        adaptVideoSize(i6, i5);
    }

    public void setMediaPlayer(b bVar) {
        this.aam = bVar;
        Surface surface = this.aap;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    public final void adaptVideoSize(int i, int i2) {
        VideoAdapters.a cVar;
        if (this.aal == null) {
            com.kwad.sdk.core.d.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.aav = i2;
        this.aau = i;
        if (this.aaw.tJ()) {
            int iTK = this.aaw.tK();
            if (iTK == 1) {
                cVar = new VideoAdapters.c();
            } else {
                cVar = iTK != 2 ? null : new VideoAdapters.b();
            }
            if (cVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.aal;
                cVar.a(bVar, (View) bVar.getParent(), i, i2);
                return;
            }
            return;
        }
        if (this.aaw.tP()) {
            com.kwad.sdk.c.a.a.H(this.aal);
            return;
        }
        if (this.aaw.tL()) {
            com.kwad.sdk.c.a.a.e(this.aal, i, i2);
            return;
        }
        if (this.aaw.tN()) {
            com.kwad.sdk.c.a.a.f(this.aal, i, i2);
            return;
        }
        if (this.aaw.tM()) {
            com.kwad.sdk.c.a.a.d(this.aal, i, i2);
            return;
        }
        if (this.aaw.tO()) {
            a(this.aal, i, i2);
            return;
        }
        View view = (View) this.aal.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.aar;
        if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.aal.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.aal.setTransform(this.mMatrix);
            this.aal.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.aal.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
            this.mMatrix.reset();
            this.aal.setTransform(this.mMatrix);
            this.aal.setLayoutParams(layoutParams2);
        }
        this.aat.set(this.aal.getLeft(), this.aal.getTop(), this.aal.getRight(), this.aal.getBottom());
    }

    private void a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f = j / j2;
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.aal.setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.aaw.setAd(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.aaw.setHorizontalVideo(z);
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.aaw.aU(z);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.aaw.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.aaw.setForce(z);
    }

    public final void g(boolean z, int i) {
        this.aaw.setAd(true);
        this.aaw.bd(i);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.aar = videoInfo;
    }

    public void setClickListener(a aVar) {
        this.aaq = aVar;
        setOnClickListener(this);
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.aal;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.aal.requestLayout();
        }
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.aal;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aal) {
            a aVar = this.aaq;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.aaq;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        com.kwad.components.core.widget.h.b(this, f);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean zW = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.el(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt((int) height, i);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (zW) {
                    int i2 = (int) (iIntValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = iIntValue;
                        layoutParams.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, iIntValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = iIntValue;
                        layoutParams.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setInterpolator(interpolatorCreate);
        return valueAnimatorOfInt;
    }

    public final void bc(int i) {
        if (com.kwad.components.core.a.oz.booleanValue()) {
            if (this.aao == null) {
                if (getContext() == null) {
                    return;
                } else {
                    this.aao = new TextView(getContext());
                }
            }
            removeView(this.aao);
            this.aao.setText(String.valueOf(i));
            this.aao.setTextColor(SupportMenu.CATEGORY_MASK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            addView(this.aao, getChildCount(), layoutParams);
        }
    }
}
