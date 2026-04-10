package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.m;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class LottieAnimationView extends ImageView {
    private static final uy<Throwable> g = new uy<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.uy
        public void z(Throwable th) {
            if (com.bytedance.adsdk.lottie.gc.fo.z(th)) {
                com.bytedance.adsdk.lottie.gc.gc.z("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.gc.gc.z("Unable to parse composition:", th);
            }
        }
    };
    private static final String z = "LottieAnimationView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uy<Throwable> f135a;
    private final uy<m> dl;
    private final gz e;
    private int fo;
    private final Handler fv;
    private uy<Throwable> gc;
    private String gk;
    private String gz;
    private int h;
    private int hh;
    private final Set<a> i;
    private com.bytedance.adsdk.lottie.model.layer.m io;
    private volatile int iq;
    private int js;
    private boolean kb;
    private int l;
    private int lq;
    private m ls;
    private int m;
    private final Runnable mc;
    private final Handler p;
    private i<m> pf;
    private long q;
    private int sy;
    private Handler tb;
    private z ti;
    private List<com.bytedance.adsdk.lottie.model.layer.m> uf;
    private g un;
    private boolean uy;
    private final Set<Object> v;
    private boolean wp;
    private JSONArray x;
    private final Runnable zw;

    private enum a {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface g {
        void z(String str, JSONArray jSONArray);
    }

    public interface z {
        void g(Map<String, Object> map);

        void z(Map<String, Object> map);
    }

    static /* synthetic */ int gc(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.js;
        lottieAnimationView.js = i + 1;
        return i;
    }

    static /* synthetic */ int q(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.sy;
        lottieAnimationView.sy = i - 1;
        return i;
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.dl = new uy<m>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.uy
            public void z(m mVar) {
                LottieAnimationView.this.setComposition(mVar);
            }
        };
        this.f135a = new uy<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
            @Override // com.bytedance.adsdk.lottie.uy
            public void z(Throwable th) {
                if (LottieAnimationView.this.m != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.m);
                }
                (LottieAnimationView.this.gc == null ? LottieAnimationView.g : LottieAnimationView.this.gc).z(th);
            }
        };
        this.m = 0;
        this.e = new gz(this);
        this.uy = false;
        this.kb = false;
        this.wp = true;
        this.i = new HashSet();
        this.v = new HashSet();
        this.p = new Handler(Looper.getMainLooper());
        this.fv = new Handler(Looper.getMainLooper());
        this.js = 0;
        this.q = 0L;
        this.iq = 0;
        this.zw = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.ls();
                if (LottieAnimationView.this.iq == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.iq == 1) {
                        LottieAnimationView.this.iq = 2;
                        LottieAnimationView.this.fv();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.iq == 2) {
                    LottieAnimationView.this.iq = 1;
                    LottieAnimationView.this.js();
                }
            }
        };
        this.mc = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.sy + ", " + LottieAnimationView.this.hh);
                if (LottieAnimationView.this.sy <= LottieAnimationView.this.hh) {
                    LottieAnimationView.this.iq = 0;
                    LottieAnimationView.this.p();
                    if (LottieAnimationView.this.l >= 0 && LottieAnimationView.this.h >= 0) {
                        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.l);
                        LottieAnimationView.this.g();
                        LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                        lottieAnimationView.setFrame(lottieAnimationView.l);
                        LottieAnimationView.this.z(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.h - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.h + 2) {
                                    return;
                                }
                                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.h);
                                LottieAnimationView.this.g(this);
                                LottieAnimationView.this.e();
                            }
                        });
                    } else {
                        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.l + "," + LottieAnimationView.this.h);
                    }
                    if ((!TextUtils.isEmpty(LottieAnimationView.this.gk) || (LottieAnimationView.this.x != null && LottieAnimationView.this.x.length() > 0)) && LottieAnimationView.this.un != null) {
                        LottieAnimationView.this.un.z(LottieAnimationView.this.gk, LottieAnimationView.this.x);
                        return;
                    }
                    return;
                }
                LottieAnimationView.q(LottieAnimationView.this);
                LottieAnimationView.this.tb();
                LottieAnimationView.this.invalidate();
                LottieAnimationView.this.fv();
            }
        };
        fo();
    }

    private void fo() {
        setSaveEnabled(false);
        this.wp = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        z(0.0f, false);
        z(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.e.z(Boolean.valueOf(com.bytedance.adsdk.lottie.gc.fo.z(getContext()) != 0.0f));
        uy();
        kb();
        i();
    }

    private void uy() {
        z(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
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
                LottieAnimationView.this.g(this);
                LottieAnimationView.this.pf();
                LottieAnimationView.this.wp();
            }
        });
    }

    private void kb() {
        z(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.gc(LottieAnimationView.this);
                m.g globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.f157a > 0 && globalConfig.f157a > LottieAnimationView.this.js) {
                    LottieAnimationView.this.pf();
                    LottieAnimationView.this.z();
                    LottieAnimationView.this.setProgress(0.0f);
                } else {
                    LottieAnimationView.this.g(this);
                    if (LottieAnimationView.this.ti != null) {
                        LottieAnimationView.this.ti.g((globalConfig == null || globalConfig.dl == null) ? null : globalConfig.dl);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp() {
        final m.g globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.gc <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.m) && globalConfig.e == null) {
            return;
        }
        int maxFrame = globalConfig.gc;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        z(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.g(this);
                if (LottieAnimationView.this.un != null) {
                    LottieAnimationView.this.un.z(globalConfig.m, globalConfig.e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j) {
        m.g globalConfig = getGlobalConfig();
        if (this.ti != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j));
            if (globalConfig != null && globalConfig.g != null && !globalConfig.g.isEmpty()) {
                map.putAll(globalConfig.g);
            }
            this.ti.z(map);
        }
    }

    private void i() {
        z(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
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
                tb tbVarUf;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.q;
                LottieAnimationView.this.g(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (tbVarUf = LottieAnimationView.this.e.uf()) != null) {
                    try {
                        int i = Integer.parseInt(tbVarUf.z(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.q > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.q + ((long) i)) - SystemClock.elapsedRealtime();
                            com.bytedance.sdk.component.utils.wp.z("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.e();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.tb == null) {
                                    LottieAnimationView.this.tb = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.tb.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.tb.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.component.utils.wp.z("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.z();
                                        LottieAnimationView.this.z(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
                LottieAnimationView.this.z(jElapsedRealtime);
            }
        });
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        v();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        v();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        v();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        gz gzVar;
        if (!this.uy && drawable == (gzVar = this.e) && gzVar.zw()) {
            e();
        } else if (!this.uy && (drawable instanceof gz)) {
            gz gzVar2 = (gz) drawable;
            if (gzVar2.zw()) {
                gzVar2.h();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof gz) && ((gz) drawable).e() == js.SOFTWARE) {
            this.e.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        gz gzVar = this.e;
        if (drawable2 == gzVar) {
            super.invalidateDrawable(gzVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        m mVarHh;
        gz gzVar = this.e;
        if (gzVar == null || (mVarHh = gzVar.hh()) == null) {
            return null;
        }
        return mVarHh.fo();
    }

    private fo z(String str) {
        gz gzVar;
        m mVarHh;
        Map<String, fo> mapP;
        if (TextUtils.isEmpty(str) || (gzVar = this.e) == null || (mVarHh = gzVar.hh()) == null || (mapP = mVarHh.p()) == null) {
            return null;
        }
        return mapP.get(str);
    }

    private m.z getArea() {
        m mVarHh;
        gz gzVar = this.e;
        if (gzVar == null || (mVarHh = gzVar.hh()) == null) {
            return null;
        }
        return mVarHh.uy();
    }

    private m.dl getGlobalEvent() {
        m mVarHh;
        gz gzVar = this.e;
        if (gzVar == null || (mVarHh = gzVar.hh()) == null) {
            return null;
        }
        return mVarHh.kb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m.g getGlobalConfig() {
        m mVarHh;
        gz gzVar = this.e;
        if (gzVar == null || (mVarHh = gzVar.hh()) == null) {
            return null;
        }
        return mVarHh.wp();
    }

    private void z(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- inel enter, play anim, startframe: " + i);
            js();
            z();
            setFrame(i);
            z(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.g(this);
                    LottieAnimationView.this.e();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private void z(String str, String str2, JSONArray jSONArray) {
        g gVar;
        m.dl globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.z;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.dl;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (gVar = this.un) != null) {
            gVar.z(str2, jSONArray);
        }
    }

    private void z(m.z zVar) {
        zVar.gc = com.bytedance.adsdk.lottie.gc.fo.z("x", zVar.z, getWidth());
        zVar.m = com.bytedance.adsdk.lottie.gc.fo.z("y", zVar.g, getHeight());
        zVar.e = com.bytedance.adsdk.lottie.gc.fo.z((String) null, zVar.dl, getWidth());
        zVar.gz = com.bytedance.adsdk.lottie.gc.fo.z((String) null, zVar.f158a, getHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        m.z area = getArea();
        if (area != null) {
            if (area.gc == -1.0f) {
                z(area);
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x < area.gc || x > area.gc + area.e || y < area.m || y > area.m + area.gz) {
                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--:width: " + getWidth() + ", height: " + getHeight());
                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--:" + area);
                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--:pintx: " + x + ", pointY: " + y);
                return false;
            }
        }
        com.bytedance.adsdk.lottie.model.layer.dl dlVarZ = z(motionEvent);
        if (dlVarZ != null) {
            String strKb = dlVarZ.kb();
            if (dlVarZ instanceof com.bytedance.adsdk.lottie.model.layer.a) {
                if (getGlobalConfig() == null || getGlobalConfig().z != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            if (strKb != null && strKb.startsWith("CSJCLOSE")) {
                js();
            }
            fo foVarZ = z(dlVarZ.e());
            if (foVarZ != null && motionEvent.getAction() == 1) {
                z(strKb, foVarZ.e(), foVarZ.fo());
                int[][] iArrGz = foVarZ.gz();
                if (iArrGz != null) {
                    z(iArrGz);
                } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().g) != null) {
                    z(iArr);
                }
            }
            if (strKb != null && strKb.startsWith("CSJNTP")) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (getGlobalConfig() == null || getGlobalConfig().z != 1) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private com.bytedance.adsdk.lottie.model.layer.dl z(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.a aVarDl;
        gz gzVar = this.e;
        if (gzVar == null || (aVarDl = gzVar.dl()) == null) {
            return null;
        }
        return z(aVarDl, motionEvent);
    }

    private com.bytedance.adsdk.lottie.model.layer.dl z(com.bytedance.adsdk.lottie.model.layer.a aVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.dl dlVarZ;
        for (com.bytedance.adsdk.lottie.model.layer.dl dlVar : aVar.v()) {
            if (dlVar instanceof com.bytedance.adsdk.lottie.model.layer.a) {
                if (dlVar.uy() && dlVar.gz() > 0.0f) {
                    RectF rectF = new RectF();
                    dlVar.z(rectF, dlVar.m(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (dlVarZ = z((com.bytedance.adsdk.lottie.model.layer.a) dlVar, motionEvent)) != null) {
                        return dlVarZ;
                    }
                }
            } else if (dlVar.uy() && dlVar.gz() > 0.0f) {
                RectF rectF2 = new RectF();
                gz gzVar = this.e;
                if (gzVar != null && gzVar.gz()) {
                    dlVar.z(rectF2, dlVar.m(), true);
                    RectF rectFX = this.e.x();
                    if (rectFX != null) {
                        z(rectF2, rectFX);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    dlVar.z(rectF3, dlVar.m(), true);
                    g(rectF2, rectF3);
                }
                if (z(motionEvent, rectF2)) {
                    return dlVar;
                }
            }
        }
        return null;
    }

    private boolean z(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void z(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.z[getScaleType().ordinal()];
        if (i == 1) {
            z(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            g(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            dl(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            a(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            z = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void g(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.e.getBounds().width();
        float fHeight = this.e.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.z[getScaleType().ordinal()];
        if (i == 1) {
            z(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            g(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            dl(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            a(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void z(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    private void g(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void dl(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void a(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        dl dlVar = new dl(super.onSaveInstanceState());
        dlVar.z = this.gz;
        dlVar.g = this.fo;
        dlVar.dl = this.e.gk();
        dlVar.f138a = this.e.io();
        dlVar.gc = this.e.gc();
        dlVar.m = this.e.q();
        dlVar.e = this.e.iq();
        return dlVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof dl)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        dl dlVar = (dl) parcelable;
        super.onRestoreInstanceState(dlVar.getSuperState());
        this.gz = dlVar.z;
        if (!this.i.contains(a.SET_ANIMATION) && !TextUtils.isEmpty(this.gz)) {
            setAnimation(this.gz);
        }
        this.fo = dlVar.g;
        if (!this.i.contains(a.SET_ANIMATION) && (i = this.fo) != 0) {
            setAnimation(i);
        }
        if (!this.i.contains(a.SET_PROGRESS)) {
            z(dlVar.dl, false);
        }
        if (!this.i.contains(a.PLAY_OPTION) && dlVar.f138a) {
            z();
        }
        if (!this.i.contains(a.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(dlVar.gc);
        }
        if (!this.i.contains(a.SET_REPEAT_MODE)) {
            setRepeatMode(dlVar.m);
        }
        if (this.i.contains(a.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(dlVar.e);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.kb) {
            return;
        }
        this.e.wp();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        js();
        p();
        Handler handler = this.tb;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        a();
        dl();
        m();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.e.e(z2);
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.e.gz(z2);
    }

    public void z(boolean z2, Context context) {
        this.e.z(z2, context);
    }

    public void setClipToCompositionBounds(boolean z2) {
        this.e.z(z2);
    }

    public boolean getClipToCompositionBounds() {
        return this.e.a();
    }

    public void setCacheComposition(boolean z2) {
        this.wp = z2;
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        this.e.a(z2);
    }

    public void setAnimation(int i) {
        this.fo = i;
        this.gz = null;
        setCompositionTask(z(i));
    }

    private i<m> z(final int i) {
        if (isInEditMode()) {
            return new i<>(new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public wp<m> call() throws Exception {
                    return LottieAnimationView.this.wp ? e.g(LottieAnimationView.this.getContext(), i) : e.g(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.wp ? e.z(getContext(), i) : e.z(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.gz = str;
        this.fo = 0;
        setCompositionTask(g(str));
    }

    private i<m> g(final String str) {
        if (isInEditMode()) {
            return new i<>(new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public wp<m> call() throws Exception {
                    return LottieAnimationView.this.wp ? e.dl(LottieAnimationView.this.getContext(), str) : e.dl(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.wp ? e.g(getContext(), str) : e.g(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        z(str, (String) null);
    }

    public void z(String str, String str2) {
        z(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void z(InputStream inputStream, String str) {
        setCompositionTask(e.z(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.wp ? e.z(getContext(), str) : e.z(getContext(), str, (String) null));
    }

    public void setFailureListener(uy<Throwable> uyVar) {
        this.gc = uyVar;
    }

    public void setFallbackResource(int i) {
        this.m = i;
    }

    private void setCompositionTask(i<m> iVar) {
        this.i.add(a.SET_ANIMATION);
        q();
        v();
        this.pf = iVar.z(this.dl).dl(this.f135a);
    }

    private void v() {
        i<m> iVar = this.pf;
        if (iVar != null) {
            iVar.g(this.dl);
            this.pf.a(this.f135a);
        }
    }

    private com.bytedance.adsdk.lottie.model.layer.m z(com.bytedance.adsdk.lottie.model.layer.a aVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.dl dlVar : aVar.v()) {
            if (dlVar instanceof com.bytedance.adsdk.lottie.model.layer.a) {
                com.bytedance.adsdk.lottie.model.layer.m mVarZ = z((com.bytedance.adsdk.lottie.model.layer.a) dlVar, str);
                if (mVarZ != null) {
                    return mVarZ;
                }
            } else if (TextUtils.equals(str, dlVar.kb()) && (dlVar instanceof com.bytedance.adsdk.lottie.model.layer.m)) {
                return (com.bytedance.adsdk.lottie.model.layer.m) dlVar;
            }
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.model.layer.m dl(String str) {
        com.bytedance.adsdk.lottie.model.layer.a aVarDl;
        gz gzVar = this.e;
        if (gzVar == null || (aVarDl = gzVar.dl()) == null) {
            return null;
        }
        return z(aVarDl, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        gz gzVar;
        int i;
        int i2;
        int i3;
        if (this.ls == null || (gzVar = this.e) == null) {
            return;
        }
        tb tbVarUf = gzVar.uf();
        final m.a aVarGz = this.ls.gz();
        if (aVarGz == null || tbVarUf == null) {
            return;
        }
        final int i4 = aVarGz.z;
        if (i4 < 0) {
            com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer fail, ke is invalid: " + i4);
            return;
        }
        final int i5 = -1;
        if (aVarGz.gc == null || aVarGz.gc.length < 2) {
            i = -1;
            i2 = -1;
        } else {
            i = aVarGz.gc[0];
            i2 = aVarGz.gc[1];
        }
        String strZ = tbVarUf.z(aVarGz.dl);
        String strZ2 = tbVarUf.z(aVarGz.f156a);
        try {
            i3 = Integer.parseInt(strZ);
        } catch (NumberFormatException e) {
            e = e;
            i3 = -1;
        }
        try {
            i5 = Integer.parseInt(strZ2);
        } catch (NumberFormatException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- prepare timer, startS: " + i3 + ", lenS: " + i5);
        if (aVarGz.fo == 2 && aVarGz.uy != null) {
            this.uf = new ArrayList(3);
            for (String str : aVarGz.uy) {
                if (!TextUtils.isEmpty(str)) {
                    com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timers, id:" + aVarGz.g);
                    com.bytedance.adsdk.lottie.model.layer.m mVarDl = dl(str);
                    if (mVarDl != null) {
                        this.uf.add(mVarDl);
                    }
                }
            }
            if (this.uf.size() != 3) {
                com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer layers size != 3, is " + this.uf.size() + ", timer is invalid");
                return;
            }
        }
        if (!TextUtils.isEmpty(aVarGz.g)) {
            com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer, id:" + aVarGz.g);
            this.io = dl(aVarGz.g);
        }
        if (this.uf != null || this.io != null) {
            com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer success, timer tp: " + aVarGz.fo);
            this.lq = aVarGz.fo;
            this.gk = aVarGz.m;
            this.x = aVarGz.e;
            this.sy = i3;
            this.hh = i3 - i5;
            this.l = i;
            this.h = i2;
            tb();
            final int i6 = i3;
            z(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i4 - 1 || LottieAnimationView.this.getFrame() >= i4 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- enter timer point, frame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.g(this);
                    if (i6 >= 0 && i5 >= 0) {
                        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- enter timer callback, start timer");
                        LottieAnimationView.this.iq = 2;
                        if (aVarGz.gz == 1) {
                            LottieAnimationView.this.ls();
                        }
                        LottieAnimationView.this.fv();
                    } else {
                        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- enter timer callback, NOT start timer");
                    }
                    LottieAnimationView.this.e();
                }
            });
            return;
        }
        com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- timer fail, id is invalid: " + aVarGz.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        p();
        this.fv.postDelayed(this.zw, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.fv.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv() {
        js();
        this.p.postDelayed(this.mc, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js() {
        this.p.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        String[] strArrSplit;
        if (this.uf != null) {
            String strG = g(this.sy);
            if (TextUtils.isEmpty(strG) || (strArrSplit = strG.split(":")) == null || strArrSplit.length != 3) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                com.bytedance.adsdk.lottie.model.layer.m mVar = this.uf.get(i);
                if (mVar != null) {
                    mVar.z(strArrSplit[i]);
                }
            }
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.m mVar2 = this.io;
        if (mVar2 != null) {
            if (this.lq == 1) {
                mVar2.z(g(this.sy));
            } else {
                mVar2.z(new StringBuilder().append(this.sy).toString());
            }
        }
    }

    private String g(int i) {
        int i2 = i / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i3 = i % SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2).append(":");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4).append(":");
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        return sb.toString();
    }

    public void setComposition(m mVar) {
        boolean z2 = gc.z;
        this.e.setCallback(this);
        this.ls = mVar;
        this.uy = true;
        boolean z3 = this.e.z(mVar, getContext().getApplicationContext());
        this.uy = false;
        if (getDrawable() != this.e || z3) {
            if (!z3) {
                iq();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.v.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public m getComposition() {
        return this.ls;
    }

    public void z() {
        if (this.q == 0) {
            this.q = SystemClock.elapsedRealtime();
        }
        this.i.add(a.PLAY_OPTION);
        this.e.wp();
    }

    public void g() {
        this.i.add(a.PLAY_OPTION);
        this.e.v();
    }

    public void setMinFrame(int i) {
        this.e.z(i);
    }

    public float getMinFrame() {
        return this.e.pf();
    }

    public void setMinProgress(float f) {
        this.e.z(f);
    }

    public void setMaxFrame(int i) {
        this.e.g(i);
    }

    public float getMaxFrame() {
        return this.e.ls();
    }

    public void setMaxProgress(float f) {
        this.e.g(f);
    }

    public void setMinFrame(String str) {
        this.e.g(str);
    }

    public void setMaxFrame(String str) {
        this.e.dl(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.e.a(str);
    }

    public void setSpeed(float f) {
        this.e.dl(f);
    }

    public float getSpeed() {
        return this.e.p();
    }

    public void z(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.e.z(animatorUpdateListener);
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.e.g(animatorUpdateListener);
    }

    public void dl() {
        this.e.fv();
    }

    public void z(Animator.AnimatorListener animatorListener) {
        this.e.z(animatorListener);
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.e.g(animatorListener);
    }

    public void a() {
        this.e.js();
    }

    @Deprecated
    public void z(boolean z2) {
        this.e.gc(z2 ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.i.add(a.SET_REPEAT_MODE);
        this.e.a(i);
    }

    public int getRepeatMode() {
        return this.e.q();
    }

    public void setRepeatCount(int i) {
        this.i.add(a.SET_REPEAT_COUNT);
        this.e.gc(i);
    }

    public int getRepeatCount() {
        return this.e.iq();
    }

    public boolean gc() {
        return this.e.zw();
    }

    public void setImageAssetsFolder(String str) {
        this.e.z(str);
    }

    public String getImageAssetsFolder() {
        return this.e.gc();
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.e.g(z2);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.e.m();
    }

    public Bitmap z(String str, Bitmap bitmap) {
        return this.e.z(str, bitmap);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.a aVar) {
        this.e.z(aVar);
    }

    public void setDefaultFontFileExtension(String str) {
        this.e.e(str);
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.dl dlVar) {
        this.e.z(dlVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.e.z(map);
    }

    public void setTextDelegate(tb tbVar) {
        this.e.z(tbVar);
    }

    public void setViewDelegate(q qVar) {
        this.e.z(qVar);
    }

    public void m() {
        this.i.add(a.PLAY_OPTION);
        this.e.l();
    }

    public void e() {
        this.kb = false;
        this.e.h();
    }

    public void setFrame(int i) {
        this.e.dl(i);
    }

    public int getFrame() {
        return this.e.tb();
    }

    public void setProgress(float f) {
        z(f, true);
    }

    private void z(float f, boolean z2) {
        if (z2) {
            this.i.add(a.SET_PROGRESS);
        }
        this.e.a(f);
    }

    public float getProgress() {
        return this.e.gk();
    }

    public long getDuration() {
        m mVar = this.ls;
        if (mVar != null) {
            return (long) mVar.gc();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        this.e.dl(z2);
    }

    public fv getPerformanceTracker() {
        return this.e.fo();
    }

    private void q() {
        this.ls = null;
        this.e.kb();
    }

    public void setSafeMode(boolean z2) {
        this.e.m(z2);
    }

    public void setRenderMode(js jsVar) {
        this.e.z(jsVar);
    }

    public js getRenderMode() {
        return this.e.e();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.e.gc(z2);
    }

    private void iq() {
        boolean zGc = gc();
        setImageDrawable(null);
        setImageDrawable(this.e);
        if (zGc) {
            this.e.v();
        }
    }

    private static class dl extends View.BaseSavedState {
        public static final Parcelable.Creator<dl> CREATOR = new Parcelable.Creator<dl>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.dl.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public dl createFromParcel(Parcel parcel) {
                return new dl(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public dl[] newArray(int i) {
                return new dl[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f138a;
        float dl;
        int e;
        int g;
        String gc;
        int m;
        String z;

        dl(Parcelable parcelable) {
            super(parcelable);
        }

        private dl(Parcel parcel) {
            super(parcel);
            this.z = parcel.readString();
            this.dl = parcel.readFloat();
            this.f138a = parcel.readInt() == 1;
            this.gc = parcel.readString();
            this.m = parcel.readInt();
            this.e = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.z);
            parcel.writeFloat(this.dl);
            parcel.writeInt(this.f138a ? 1 : 0);
            parcel.writeString(this.gc);
            parcel.writeInt(this.m);
            parcel.writeInt(this.e);
        }
    }

    public void setLottieClicklistener(g gVar) {
        this.un = gVar;
    }

    public void setLottieAnimListener(z zVar) {
        this.ti = zVar;
    }
}
