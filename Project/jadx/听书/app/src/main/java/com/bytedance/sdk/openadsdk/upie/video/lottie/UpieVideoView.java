package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.renderview.g;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.q;
import com.bytedance.adsdk.lottie.tb;
import com.bytedance.sdk.openadsdk.upie.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UpieVideoView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f1478a;
    private final Map<String, Bitmap> dl;
    private g.z e;
    private final LottieAnimationView g;
    private final Handler gc;
    private final Runnable m;
    private final com.bykv.vk.openvk.component.video.api.renderview.g z;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public View getView() {
        return this;
    }

    public UpieVideoView(final Context context, final com.bytedance.sdk.openadsdk.upie.z zVar) {
        super(context);
        this.dl = new HashMap();
        this.f1478a = new HashMap();
        this.gc = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.g != null && UpieVideoView.this.g.gc()) {
                    UpieVideoView.this.g.invalidate();
                }
                UpieVideoView.this.gc.postDelayed(UpieVideoView.this.m, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.z = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.g = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new a() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
            
                if (r1.startsWith("http") != false) goto L17;
             */
            @Override // com.bytedance.adsdk.lottie.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public android.graphics.Bitmap z(com.bytedance.adsdk.lottie.fo r6) {
                /*
                    r5 = this;
                    r0 = 0
                    if (r6 == 0) goto L56
                    java.lang.String r1 = r6.wp()
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L56
                    java.lang.String r2 = "${"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L38
                    java.lang.String r2 = "}"
                    boolean r2 = r1.endsWith(r2)
                    if (r2 == 0) goto L38
                    com.bytedance.sdk.openadsdk.upie.z r2 = r2
                    if (r2 == 0) goto L37
                    org.json.JSONObject r2 = r2.e()
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.upie.z.z.z(r1, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L37
                    java.lang.String r2 = "http"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L38
                L37:
                    return r0
                L38:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    java.util.Map r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.z(r2)
                    java.lang.Object r2 = r2.get(r1)
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                    if (r2 == 0) goto L47
                    return r2
                L47:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    android.content.Context r3 = r3
                    int r4 = r6.z()
                    int r6 = r6.g()
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.z(r2, r3, r1, r4, r6)
                L56:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.AnonymousClass1.z(com.bytedance.adsdk.lottie.fo):android.graphics.Bitmap");
            }
        });
        lottieAnimationView.setTextDelegate(new tb(lottieAnimationView) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.2
            @Override // com.bytedance.adsdk.lottie.tb
            public String z(String str) {
                com.bytedance.sdk.openadsdk.upie.z zVar2 = zVar;
                return com.bytedance.sdk.openadsdk.upie.z.z.z(str, zVar2 != null ? zVar2.e() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new q() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.3
            @Override // com.bytedance.adsdk.lottie.q
            public View z(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.z.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.z(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.g != null) {
                    UpieVideoView.this.g.g(this);
                }
                UpieVideoView.this.a();
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.g == view) {
                    UpieVideoView.this.dl();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        this.gc.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        dl();
        if (this.g != null) {
            this.gc.postDelayed(this.m, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, final String str, final int i, final int i2) {
        Integer num = this.f1478a.get(str);
        if (num == null || num.intValue() != 1) {
            this.f1478a.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.g.z().z(context, str, new g.z<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.7
                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieVideoView.this.dl.put(str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(int i3, String str2) {
                    UpieVideoView.this.f1478a.put(str, 2);
                }
            });
        }
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(com.bykv.vk.openvk.component.video.api.renderview.z zVar) {
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.z;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.g;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    public void z() {
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.a();
            }
        });
    }

    public void g() {
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.dl();
            }
        });
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(g.z zVar) {
        this.e = zVar;
    }
}
