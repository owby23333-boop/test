package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.a.iq;
import com.funny.audio.core.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends Drawable implements Animatable, Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f151a;
    tb dl;
    private boolean e;
    private RectF eo;
    private g fo;
    private boolean fv;
    dl g;
    private final com.bytedance.adsdk.lottie.gc.m gc;
    private Rect gk;
    private boolean gz;
    private Canvas h;
    private final Matrix hh;
    private String i;
    private boolean io;
    private boolean iq;
    private boolean j;
    private boolean js;
    private final ValueAnimator.AnimatorUpdateListener kb;
    private Bitmap l;
    private Paint lq;
    private Map<String, Typeface> ls;
    private boolean m;
    private Rect mc;
    private q na;
    private Matrix oq;
    private boolean p;
    private com.bytedance.adsdk.lottie.g.z pf;
    private int q;
    private boolean sy;
    private com.bytedance.adsdk.lottie.model.layer.a tb;
    private RectF ti;
    private js uf;
    private Rect un;
    private final ArrayList<z> uy;
    private a v;
    private Matrix wj;
    private com.bytedance.adsdk.lottie.g.g wp;
    private RectF x;
    private LottieAnimationView xl;
    String z;
    private boolean zw;

    private enum g {
        NONE,
        PLAY,
        RESUME
    }

    private interface z {
        void z(m mVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public gz(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.gc.m mVar = new com.bytedance.adsdk.lottie.gc.m();
        this.gc = mVar;
        this.m = true;
        this.e = false;
        this.gz = false;
        this.fo = g.NONE;
        this.uy = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.gz.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (gz.this.tb != null) {
                    gz.this.tb.z(gz.this.gc.m());
                }
            }
        };
        this.kb = animatorUpdateListener;
        this.fv = false;
        this.js = true;
        this.q = 255;
        this.uf = js.AUTOMATIC;
        this.sy = false;
        this.hh = new Matrix();
        this.j = false;
        this.xl = lottieAnimationView;
        mVar.addUpdateListener(animatorUpdateListener);
    }

    public void z(q qVar) {
        this.na = qVar;
    }

    public q z() {
        return this.na;
    }

    public LottieAnimationView g() {
        return this.xl;
    }

    public void z(boolean z2, Context context) {
        if (this.p == z2) {
            return;
        }
        this.p = z2;
        if (this.f151a != null) {
            z(context);
        }
    }

    public void z(boolean z2) {
        if (z2 != this.js) {
            this.js = z2;
            com.bytedance.adsdk.lottie.model.layer.a aVar = this.tb;
            if (aVar != null) {
                aVar.g(z2);
            }
            invalidateSelf();
        }
    }

    public com.bytedance.adsdk.lottie.model.layer.a dl() {
        return this.tb;
    }

    public boolean a() {
        return this.js;
    }

    public void z(String str) {
        this.i = str;
    }

    public String gc() {
        return this.i;
    }

    public void g(boolean z2) {
        this.fv = z2;
    }

    public boolean m() {
        return this.fv;
    }

    public boolean z(m mVar, Context context) {
        if (this.f151a == mVar) {
            return false;
        }
        this.j = true;
        kb();
        this.f151a = mVar;
        z(context);
        this.gc.z(mVar);
        a(this.gc.getAnimatedFraction());
        Iterator it = new ArrayList(this.uy).iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (zVar != null) {
                zVar.z(mVar);
            }
            it.remove();
        }
        this.uy.clear();
        mVar.g(this.iq);
        lq();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void z(js jsVar) {
        this.uf = jsVar;
        lq();
    }

    public js e() {
        return this.sy ? js.SOFTWARE : js.HARDWARE;
    }

    private void lq() {
        m mVar = this.f151a;
        if (mVar == null) {
            return;
        }
        this.sy = this.uf.z(Build.VERSION.SDK_INT, mVar.z(), mVar.g());
    }

    public boolean gz() {
        return this.sy;
    }

    public void dl(boolean z2) {
        this.iq = z2;
        m mVar = this.f151a;
        if (mVar != null) {
            mVar.g(z2);
        }
    }

    public void a(boolean z2) {
        if (this.zw == z2) {
            return;
        }
        this.zw = z2;
        com.bytedance.adsdk.lottie.model.layer.a aVar = this.tb;
        if (aVar != null) {
            aVar.z(z2);
        }
    }

    public fv fo() {
        m mVar = this.f151a;
        if (mVar != null) {
            return mVar.dl();
        }
        return null;
    }

    public void gc(boolean z2) {
        this.io = z2;
    }

    public boolean uy() {
        return this.io;
    }

    private void z(Context context) {
        m mVar = this.f151a;
        if (mVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.a aVar = this.tb;
        if (aVar != null) {
            z(aVar);
        }
        com.bytedance.adsdk.lottie.model.layer.a aVar2 = new com.bytedance.adsdk.lottie.model.layer.a(this, iq.z(mVar), mVar.v(), mVar, context);
        this.tb = aVar2;
        if (this.zw) {
            aVar2.z(true);
        }
        this.tb.g(this.js);
    }

    private void z(com.bytedance.adsdk.lottie.model.layer.a aVar) {
        if (aVar != null) {
            aVar.dl();
            List<com.bytedance.adsdk.lottie.model.layer.dl> listV = aVar.v();
            if (listV != null) {
                for (com.bytedance.adsdk.lottie.model.layer.dl dlVar : listV) {
                    if (dlVar instanceof com.bytedance.adsdk.lottie.model.layer.a) {
                        z((com.bytedance.adsdk.lottie.model.layer.a) dlVar);
                    } else if (dlVar != null) {
                        dlVar.dl();
                    }
                }
            }
        }
    }

    public void kb() {
        if (this.gc.isRunning()) {
            this.gc.cancel();
            if (!isVisible()) {
                this.fo = g.NONE;
            }
        }
        this.f151a = null;
        com.bytedance.adsdk.lottie.model.layer.a aVar = this.tb;
        if (aVar != null) {
            z(aVar);
        }
        this.tb = null;
        this.wp = null;
        this.gc.gz();
        invalidateSelf();
    }

    public void m(boolean z2) {
        this.gz = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.j) {
            return;
        }
        this.j = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.q = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.gc.gc.g("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        gc.z("Drawable#draw");
        try {
            if (this.sy) {
                z(canvas, this.tb);
            } else {
                z(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.gc.gc.g("Lottie crashed in draw!", th);
        }
        this.j = false;
        gc.g("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        wp();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        i();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return zw();
    }

    public void wp() {
        if (this.tb == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.6
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.wp();
                }
            });
            return;
        }
        lq();
        if (mc() || iq() == 0) {
            if (isVisible()) {
                this.gc.kb();
                this.fo = g.NONE;
            } else {
                this.fo = g.PLAY;
            }
        }
        if (mc()) {
            return;
        }
        dl((int) (p() < 0.0f ? pf() : ls()));
        this.gc.wp();
        if (isVisible()) {
            return;
        }
        this.fo = g.NONE;
    }

    public void i() {
        this.uy.clear();
        this.gc.wp();
        if (isVisible()) {
            return;
        }
        this.fo = g.NONE;
    }

    public void v() {
        if (this.tb == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.7
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.v();
                }
            });
            return;
        }
        lq();
        if (mc() || iq() == 0) {
            if (isVisible()) {
                this.gc.v();
                this.fo = g.NONE;
            } else {
                this.fo = g.RESUME;
            }
        }
        if (mc()) {
            return;
        }
        dl((int) (p() < 0.0f ? pf() : ls()));
        this.gc.wp();
        if (isVisible()) {
            return;
        }
        this.fo = g.NONE;
    }

    public void z(final int i) {
        if (this.f151a == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.8
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.z(i);
                }
            });
        } else {
            this.gc.z(i);
        }
    }

    public float pf() {
        return this.gc.pf();
    }

    public void z(final float f) {
        m mVar = this.f151a;
        if (mVar == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.9
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar2) {
                    gz.this.z(f);
                }
            });
        } else {
            z((int) com.bytedance.adsdk.lottie.gc.gz.z(mVar.m(), this.f151a.e(), f));
        }
    }

    public void g(final int i) {
        if (this.f151a == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.10
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.g(i);
                }
            });
        } else {
            this.gc.g(i + 0.99f);
        }
    }

    public float ls() {
        return this.gc.ls();
    }

    public void g(final float f) {
        m mVar = this.f151a;
        if (mVar == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.11
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar2) {
                    gz.this.g(f);
                }
            });
        } else {
            this.gc.g(com.bytedance.adsdk.lottie.gc.gz.z(mVar.m(), this.f151a.e(), f));
        }
    }

    public void g(final String str) {
        m mVar = this.f151a;
        if (mVar == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.12
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar2) {
                    gz.this.g(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m mVarDl = mVar.dl(str);
        if (mVarDl == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        z((int) mVarDl.z);
    }

    public void dl(final String str) {
        m mVar = this.f151a;
        if (mVar == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.13
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar2) {
                    gz.this.dl(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m mVarDl = mVar.dl(str);
        if (mVarDl == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        g((int) (mVarDl.z + mVarDl.g));
    }

    public void a(final String str) {
        m mVar = this.f151a;
        if (mVar == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.2
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar2) {
                    gz.this.a(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m mVarDl = mVar.dl(str);
        if (mVarDl == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        int i = (int) mVarDl.z;
        z(i, ((int) mVarDl.g) + i);
    }

    public void z(final int i, final int i2) {
        if (this.f151a == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.3
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.z(i, i2);
                }
            });
        } else {
            this.gc.z(i, i2 + 0.99f);
        }
    }

    public void dl(float f) {
        this.gc.dl(f);
    }

    public float p() {
        return this.gc.uy();
    }

    public void z(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.gc.addUpdateListener(animatorUpdateListener);
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.gc.removeUpdateListener(animatorUpdateListener);
    }

    public void fv() {
        this.gc.removeAllUpdateListeners();
        this.gc.addUpdateListener(this.kb);
    }

    public void z(Animator.AnimatorListener animatorListener) {
        this.gc.addListener(animatorListener);
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.gc.removeListener(animatorListener);
    }

    public void js() {
        this.gc.removeAllListeners();
    }

    public void dl(final int i) {
        if (this.f151a == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.4
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.dl(i);
                }
            });
        } else {
            this.gc.z(i);
        }
    }

    public int tb() {
        return (int) this.gc.e();
    }

    public void a(final float f) {
        if (this.f151a == null) {
            this.uy.add(new z() { // from class: com.bytedance.adsdk.lottie.gz.5
                @Override // com.bytedance.adsdk.lottie.gz.z
                public void z(m mVar) {
                    gz.this.a(f);
                }
            });
            return;
        }
        gc.z("Drawable#setProgress");
        this.gc.z(this.f151a.z(f));
        gc.g("Drawable#setProgress");
    }

    public void a(int i) {
        this.gc.setRepeatMode(i);
    }

    public int q() {
        return this.gc.getRepeatMode();
    }

    public void gc(int i) {
        this.gc.setRepeatCount(i);
    }

    public int iq() {
        return this.gc.getRepeatCount();
    }

    public boolean zw() {
        com.bytedance.adsdk.lottie.gc.m mVar = this.gc;
        if (mVar == null) {
            return false;
        }
        return mVar.isRunning();
    }

    boolean io() {
        if (isVisible()) {
            return this.gc.isRunning();
        }
        return this.fo == g.PLAY || this.fo == g.RESUME;
    }

    private boolean mc() {
        return this.m || this.e;
    }

    public void z(Boolean bool) {
        this.m = bool.booleanValue();
    }

    public void e(boolean z2) {
        this.e = z2;
    }

    public void gz(boolean z2) {
        this.gc.dl(z2);
    }

    public void z(a aVar) {
        this.v = aVar;
        com.bytedance.adsdk.lottie.g.g gVar = this.wp;
        if (gVar != null) {
            gVar.z(aVar);
        }
    }

    public void z(dl dlVar) {
        this.g = dlVar;
        com.bytedance.adsdk.lottie.g.z zVar = this.pf;
        if (zVar != null) {
            zVar.z(dlVar);
        }
    }

    public void z(Map<String, Typeface> map) {
        if (map == this.ls) {
            return;
        }
        this.ls = map;
        invalidateSelf();
    }

    public void z(tb tbVar) {
        this.dl = tbVar;
    }

    public tb uf() {
        return this.dl;
    }

    public boolean sy() {
        return this.ls == null && this.dl == null && this.f151a.pf().size() > 0;
    }

    public m hh() {
        return this.f151a;
    }

    public void l() {
        this.uy.clear();
        this.gc.cancel();
        if (isVisible()) {
            return;
        }
        this.fo = g.NONE;
    }

    public void h() {
        this.uy.clear();
        this.gc.i();
        if (isVisible()) {
            return;
        }
        this.fo = g.NONE;
    }

    public float gk() {
        return this.gc.m();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        m mVar = this.f151a;
        if (mVar == null) {
            return -1;
        }
        return mVar.a().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        m mVar = this.f151a;
        if (mVar == null) {
            return -1;
        }
        return mVar.a().height();
    }

    public Bitmap z(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.g.g gVarUn = un();
        if (gVarUn == null) {
            com.bytedance.adsdk.lottie.gc.gc.g("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapZ = gVarUn.z(str, bitmap);
        invalidateSelf();
        return bitmapZ;
    }

    public Bitmap gc(String str) {
        com.bytedance.adsdk.lottie.g.g gVarUn = un();
        if (gVarUn != null) {
            return gVarUn.z(str);
        }
        return null;
    }

    public fo m(String str) {
        m mVar = this.f151a;
        if (mVar == null) {
            return null;
        }
        return mVar.p().get(str);
    }

    private com.bytedance.adsdk.lottie.g.g un() {
        com.bytedance.adsdk.lottie.g.g gVar = this.wp;
        if (gVar != null && !gVar.z(getContext())) {
            this.wp = null;
        }
        if (this.wp == null) {
            this.wp = new com.bytedance.adsdk.lottie.g.g(getCallback(), this.i, this.v, this.f151a.p());
        }
        return this.wp;
    }

    public Typeface z(com.bytedance.adsdk.lottie.model.dl dlVar) {
        Map<String, Typeface> map = this.ls;
        if (map != null) {
            String strZ = dlVar.z();
            if (map.containsKey(strZ)) {
                return map.get(strZ);
            }
            String strG = dlVar.g();
            if (map.containsKey(strG)) {
                return map.get(strG);
            }
            String str = dlVar.z() + "-" + dlVar.dl();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.g.z zVarTi = ti();
        if (zVarTi != null) {
            return zVarTi.z(dlVar);
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.g.z ti() {
        if (getCallback() == null) {
            return null;
        }
        if (this.pf == null) {
            com.bytedance.adsdk.lottie.g.z zVar = new com.bytedance.adsdk.lottie.g.z(getCallback(), this.g);
            this.pf = zVar;
            String str = this.z;
            if (str != null) {
                zVar.z(str);
            }
        }
        return this.pf;
    }

    public void e(String str) {
        this.z = str;
        com.bytedance.adsdk.lottie.g.z zVarTi = ti();
        if (zVarTi != null) {
            zVarTi.z(str);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean z4 = !isVisible();
        boolean visible = super.setVisible(z2, z3);
        if (z2) {
            if (this.fo == g.PLAY) {
                wp();
            } else if (this.fo == g.RESUME) {
                v();
            }
        } else if (this.gc.isRunning()) {
            h();
            this.fo = g.RESUME;
        } else if (!z4) {
            this.fo = g.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void z(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.a aVar = this.tb;
        m mVar = this.f151a;
        if (aVar == null || mVar == null) {
            return;
        }
        this.hh.reset();
        if (!getBounds().isEmpty()) {
            this.hh.preScale(r2.width() / mVar.a().width(), r2.height() / mVar.a().height());
            this.hh.preTranslate(r2.left, r2.top);
        }
        aVar.z(canvas, this.hh, this.q);
    }

    public RectF x() {
        return this.eo;
    }

    private void z(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.a aVar) {
        if (this.f151a == null || aVar == null) {
            return;
        }
        eo();
        canvas.getMatrix(this.oq);
        canvas.getClipBounds(this.gk);
        z(this.gk, this.x);
        this.oq.mapRect(this.x);
        z(this.x, this.gk);
        if (this.js) {
            this.eo.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            aVar.z(this.eo, (Matrix) null, false);
        }
        this.oq.mapRect(this.eo);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        z(this.eo, fWidth, fHeight);
        if (!oq()) {
            this.eo.intersect(this.gk.left, this.gk.top, this.gk.right, this.gk.bottom);
        }
        int iCeil = (int) Math.ceil(this.eo.width());
        int iCeil2 = (int) Math.ceil(this.eo.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        g(iCeil, iCeil2);
        if (this.j) {
            this.hh.set(this.oq);
            this.hh.preScale(fWidth, fHeight);
            this.hh.postTranslate(-this.eo.left, -this.eo.top);
            this.l.eraseColor(0);
            aVar.z(this.h, this.hh, this.q);
            this.oq.invert(this.wj);
            this.wj.mapRect(this.ti, this.eo);
            z(this.ti, this.un);
        }
        this.mc.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.l, this.mc, this.un, this.lq);
    }

    private void eo() {
        if (this.h != null) {
            return;
        }
        this.h = new Canvas();
        this.eo = new RectF();
        this.oq = new Matrix();
        this.wj = new Matrix();
        this.gk = new Rect();
        this.x = new RectF();
        this.lq = new com.bytedance.adsdk.lottie.z.z();
        this.mc = new Rect();
        this.un = new Rect();
        this.ti = new RectF();
    }

    private void g(int i, int i2) {
        Bitmap bitmap = this.l;
        if (bitmap == null || bitmap.getWidth() < i || this.l.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.l = bitmapCreateBitmap;
            this.h.setBitmap(bitmapCreateBitmap);
            this.j = true;
            return;
        }
        if (this.l.getWidth() > i || this.l.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.l, 0, 0, i, i2);
            this.l = bitmapCreateBitmap2;
            this.h.setBitmap(bitmapCreateBitmap2);
            this.j = true;
        }
    }

    private void z(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void z(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void z(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean oq() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
