package com.bytedance.sdk.openadsdk.upie.image.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.upie.g;
import com.bytedance.sdk.openadsdk.upie.z.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UpieImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1476a;
    private volatile LottieAnimationView dl;
    private final Map<String, Integer> e;
    private int fo;
    private ImageView g;
    private Bitmap gc;
    private int gz;
    private long kb;
    private final Map<String, Bitmap> m;
    private z uy;
    private final Context z;

    static /* synthetic */ int dl(UpieImageView upieImageView) {
        int i = upieImageView.fo;
        upieImageView.fo = i + 1;
        return i;
    }

    static /* synthetic */ int gz(UpieImageView upieImageView) {
        int i = upieImageView.gz;
        upieImageView.gz = i + 1;
        return i;
    }

    public UpieImageView(Context context, com.bytedance.sdk.openadsdk.upie.z zVar, z zVar2) {
        super(context);
        this.m = new HashMap();
        this.e = new HashMap();
        this.gz = 0;
        this.fo = 0;
        this.z = context;
        this.uy = zVar2;
        z(zVar, zVar2);
    }

    public synchronized void z(final com.bytedance.sdk.openadsdk.upie.z zVar, z zVar2) {
        if (zVar == null) {
            return;
        }
        if (this.dl != null) {
            return;
        }
        this.uy = zVar2;
        final String strDl = zVar.dl();
        String strZ = zVar.z();
        if (!TextUtils.isEmpty(strZ)) {
            this.dl = new LottieAnimationView(this.z);
            this.dl.setRepeatCount(-1);
            this.dl.setRepeatMode(1);
            this.dl.setClickable(false);
            this.dl.setImageAssetDelegate(new a() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.1
                @Override // com.bytedance.adsdk.lottie.a
                public Bitmap z(fo foVar) {
                    if (foVar != null) {
                        String strWp = foVar.wp();
                        if (!TextUtils.isEmpty(strWp)) {
                            if (strWp.startsWith("${") && strWp.endsWith("}")) {
                                strWp = com.bytedance.sdk.openadsdk.upie.z.z.z(strWp, zVar.e());
                                if (TextUtils.isEmpty(strWp)) {
                                    return null;
                                }
                                if (TextUtils.equals(strDl, strWp)) {
                                    Bitmap bitmap = UpieImageView.this.gc;
                                    if (bitmap != null && (bitmap.getWidth() != foVar.z() || bitmap.getHeight() != foVar.g())) {
                                        UpieImageView.this.gc = Bitmap.createScaledBitmap(bitmap, foVar.z(), foVar.g(), false);
                                    }
                                    return UpieImageView.this.gc;
                                }
                            }
                            Bitmap bitmap2 = (Bitmap) UpieImageView.this.m.get(strWp);
                            if (bitmap2 != null) {
                                return bitmap2;
                            }
                            UpieImageView.this.z(strWp, foVar.z(), foVar.g());
                        }
                    }
                    return null;
                }
            });
            this.dl.setTextDelegate(new tb(this.dl) { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.2
                @Override // com.bytedance.adsdk.lottie.tb
                public String z(String str) {
                    return com.bytedance.sdk.openadsdk.upie.z.z.z(str, zVar.e());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.z);
        this.g = imageView;
        addView(imageView, layoutParams);
        if (this.dl != null) {
            addView(this.dl, layoutParams);
        }
        this.kb = SystemClock.elapsedRealtime();
        z(strZ);
        g(strDl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            z(10000, "lottieJsonUrl为空");
        } else {
            g.dl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strZ = com.bytedance.sdk.openadsdk.upie.g.z().z(str);
                    if (!TextUtils.isEmpty(strZ)) {
                        UpieImageView.this.z(strZ, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.g.z().z(str, new g.z<String>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3.1
                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(String str2) {
                                wp.z("UpieImageView", "--==-- lottie jsonStr ok");
                                UpieImageView.this.z(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(int i, String str2) {
                                wp.z("UpieImageView", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    UpieImageView.this.z(i, str2);
                                    return;
                                }
                                UpieImageView.dl(UpieImageView.this);
                                if (UpieImageView.this.fo <= 3) {
                                    UpieImageView.this.z(str);
                                } else {
                                    UpieImageView.this.z(i, str2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str) {
        if (TextUtils.isEmpty(str)) {
            new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.g.z().g(str, new g.z<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4
                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(Bitmap bitmap) {
                    UpieImageView.this.gc = bitmap;
                    final Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(UpieImageView.this.z, UpieImageView.this.gc, 25);
                    com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.dl != null) {
                                UpieImageView.this.dl.invalidate();
                            }
                            UpieImageView.this.g.setImageBitmap(UpieImageView.this.gc);
                            UpieImageView.this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapZ != null) {
                                UpieImageView.this.g.setBackground(new BitmapDrawable(bitmapZ));
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(int i, String str2) {
                    UpieImageView.gz(UpieImageView.this);
                    if (UpieImageView.this.gz <= 3) {
                        UpieImageView.this.g(str);
                    } else {
                        new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final int i, final int i2) {
        Integer num = this.e.get(str);
        if (num == null || num.intValue() != 1) {
            this.e.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.g.z().z(this.z, str, new g.z<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5
                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieImageView.this.m.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpieImageView.this.dl != null) {
                                    UpieImageView.this.dl.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(int i3, String str2) {
                    UpieImageView.this.e.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        z zVar = this.uy;
        if (zVar != null) {
            zVar.z(i, str);
        }
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.dl != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.dl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j) {
        if (this.uy != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j - this.kb));
            this.uy.z(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final String str2) {
        this.f1476a = str;
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.dl != null) {
                    UpieImageView.this.dl.z(str, str2);
                    UpieImageView.this.dl.z(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7.1
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
                            UpieImageView.this.dl.g(this);
                            UpieImageView.this.z(SystemClock.elapsedRealtime());
                        }
                    });
                    UpieImageView.this.dl.z();
                }
            }
        });
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.dl != null) {
                this.dl.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dl == null || this.f1476a == null) {
            return;
        }
        this.dl.z();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dl != null) {
            this.dl.m();
        }
    }
}
