package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.swiper.z.dl;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.a {
    private static final Interpolator sy = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f245a;
    protected Context dl;
    private int e;
    private int fo;
    private int fv;
    protected ViewPager g;
    private int gc;
    private int gz;
    private final Runnable hh;
    private boolean i;
    private z io;
    private FrameLayout iq;
    private int js;
    private float kb;
    private final Runnable l;
    private boolean ls;
    private int m;
    private boolean p;
    private boolean pf;
    private int q;
    private int tb;
    private com.bytedance.adsdk.ugeno.swiper.z uf;
    private String uy;
    private boolean v;
    private boolean wp;
    protected List<T> z;
    private BaseIndicator zw;

    public abstract View e(int i);

    public BaseSwiper(Context context) {
        super(context);
        this.z = new CopyOnWriteArrayList();
        this.f245a = 2000;
        this.gc = 500;
        this.m = 500;
        this.e = 0;
        this.gz = -1;
        this.fo = -1;
        this.uy = "normal";
        this.kb = 1.0f;
        this.wp = true;
        this.i = true;
        this.v = true;
        this.pf = true;
        this.fv = 0;
        this.js = 0;
        this.tb = 0;
        this.q = 0;
        this.hh = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.g.getCurrentItem() + 1;
                if (BaseSwiper.this.v) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.g.z(512, false);
                        return;
                    } else {
                        BaseSwiper.this.g.z(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.viewpager.g adapter = BaseSwiper.this.g.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.z()) {
                        BaseSwiper.this.g.z(0, false);
                    } else {
                        BaseSwiper.this.g.z(currentItem, true);
                    }
                }
            }
        };
        this.l = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.i) {
                    int currentItem = BaseSwiper.this.g.getCurrentItem() + 1;
                    if (BaseSwiper.this.v) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.g.z(512, false);
                        } else {
                            BaseSwiper.this.g.z(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.l, BaseSwiper.this.f245a);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.viewpager.g adapter = BaseSwiper.this.g.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.z()) {
                            BaseSwiper.this.g.z(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.l, BaseSwiper.this.f245a);
                        } else {
                            BaseSwiper.this.g.z(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.l, BaseSwiper.this.f245a);
                        }
                    }
                }
            }
        };
        this.dl = context;
        this.iq = new FrameLayout(context);
        this.g = z();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.iq.addView(this.g, layoutParams);
        addView(this.iq);
    }

    public ViewPager z() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper z(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.zw = new RectangleIndicator(this.dl);
        } else {
            this.zw = new DotIndicator(this.dl);
        }
        addView(this.zw, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper z(boolean z2) {
        this.i = z2;
        dl();
        return this;
    }

    public BaseSwiper z(int i) {
        this.f245a = i;
        dl();
        return this;
    }

    public BaseSwiper g(boolean z2) {
        this.pf = z2;
        return this;
    }

    public BaseSwiper dl(boolean z2) {
        this.wp = z2;
        return this;
    }

    public BaseSwiper g(int i) {
        this.zw.setSelectedColor(i);
        return this;
    }

    public BaseSwiper dl(int i) {
        this.zw.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper a(boolean z2) {
        this.zw.setLoop(z2);
        if (this.v != z2) {
            int iZ = g.z(z2, this.g.getCurrentItem(), this.z.size());
            this.v = z2;
            z zVar = this.io;
            if (zVar != null) {
                zVar.dl();
                this.g.setCurrentItem(iZ);
            }
        }
        return this;
    }

    public BaseSwiper z(float f) {
        this.kb = f;
        return this;
    }

    public BaseSwiper g(String str) {
        this.uy = str;
        z(str, this.e, this.gz, this.fo, true);
        return this;
    }

    public BaseSwiper a(int i) {
        this.e = i;
        z(this.uy, i, this.gz, this.fo, true);
        return this;
    }

    public BaseSwiper<T> gc(int i) {
        this.gz = i;
        z(this.uy, this.e, i, this.fo, true);
        return this;
    }

    public BaseSwiper m(int i) {
        this.fo = i;
        z(this.uy, this.e, this.gz, i, true);
        return this;
    }

    public void z(String str, int i, int i2, int i3, boolean z2) {
        z zVar = this.io;
        if (zVar != null) {
            zVar.dl();
        }
        this.g.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.q == 1) {
                this.g.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.g.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.iq.setClipChildren(false);
            this.g.setClipChildren(false);
            this.g.setClipToPadding(false);
        }
        if (this.q == 1) {
            dl dlVar = new dl();
            dlVar.z(str);
            this.g.z(true, (ViewPager.gc) dlVar);
            this.g.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.g.z(false, (ViewPager.gc) new com.bytedance.adsdk.ugeno.swiper.z.g());
        } else if (TextUtils.equals(str, "cube")) {
            this.g.z(false, (ViewPager.gc) new com.bytedance.adsdk.ugeno.swiper.z.z());
        } else {
            this.g.z(false, (ViewPager.gc) null);
        }
        this.g.setOffscreenPageLimit((int) this.kb);
    }

    public void g() {
        int i;
        z(this.uy, this.e, this.gz, this.fo, true);
        if (this.io == null) {
            this.io = new z();
            this.g.z((ViewPager.a) this);
            this.g.setAdapter(this.io);
        }
        int i2 = this.fv;
        if (i2 < 0 || i2 >= this.z.size()) {
            this.fv = 0;
        }
        if (this.v) {
            i = this.fv + 512;
        } else {
            i = this.fv;
        }
        this.g.z(i, true);
        if (!this.v) {
            gz(i);
        }
        if (this.i) {
            dl();
        }
    }

    public void setTwoItems(boolean z2) {
        this.p = z2;
    }

    public View z(int i, int i2) {
        if (this.z.size() == 0) {
            return new View(getContext());
        }
        View viewE = e(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewE instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (e()) {
            viewE.setTag("two_items_tag");
        }
        if (viewE.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewE.getParent()).removeView(viewE);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewE, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (e()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> z(T t) {
        if (t != null) {
            this.z.add(t);
            if (this.wp) {
                this.zw.z();
            }
        }
        z zVar = this.io;
        if (zVar != null) {
            zVar.dl();
            this.zw.z(this.fv, this.g.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.a
    public void z(int i, float f, int i2) {
        if (this.uf != null) {
            g.z(this.v, i, this.z.size());
        }
        if (e()) {
            z(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                z(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.a
    public void gz(int i) {
        if (this.uf != null) {
            int iZ = g.z(this.v, i, this.z.size());
            this.uf.z(this.v, iZ, i, iZ == 0, iZ == this.z.size() - 1);
        }
        if (this.wp) {
            this.zw.z(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.a
    public void fo(int i) {
        if (i == 1 && this.ls) {
            a();
        }
    }

    class z extends com.bytedance.adsdk.ugeno.viewpager.g {
        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public int z(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public boolean z(View view, Object obj) {
            return view == obj;
        }

        z() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public int z() {
            if (BaseSwiper.this.v) {
                return 1024;
            }
            return BaseSwiper.this.z.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public Object z(ViewGroup viewGroup, int i) {
            View viewZ = BaseSwiper.this.z(i, g.z(BaseSwiper.this.v, i, BaseSwiper.this.z.size()));
            viewGroup.addView(viewZ);
            return viewZ;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public void z(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.g
        public float z(int i) {
            if (BaseSwiper.this.kb <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.kb;
        }
    }

    public void dl() {
        removeCallbacks(this.l);
        postDelayed(this.l, this.f245a);
    }

    public void a() {
        removeCallbacks(this.l);
    }

    public void gc() {
        int i;
        z(this.uy, this.e, this.gz, this.fo, true);
        if (this.io == null) {
            this.io = new z();
            this.g.z((ViewPager.a) this);
            this.g.setAdapter(this.io);
        }
        int i2 = this.fv;
        if (i2 < 0 || i2 >= this.z.size()) {
            this.fv = 0;
        }
        if (this.v) {
            i = this.fv + 512;
        } else {
            i = this.fv;
        }
        this.g.z(i, true);
    }

    public void uy(int i) {
        z(this.uy, this.e, this.gz, this.fo, true);
        if (this.io == null) {
            this.io = new z();
            this.g.z((ViewPager.a) this);
            this.g.setAdapter(this.io);
        }
        if (this.v) {
            if (i >= 1024) {
                this.g.z(512, false);
                return;
            } else {
                this.g.z(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.z.size()) {
            return;
        }
        this.g.z(i, true);
    }

    public void kb(int i) {
        removeCallbacks(this.hh);
        postDelayed(this.hh, i);
    }

    public void m() {
        removeCallbacks(this.hh);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.ls) {
                    dl();
                }
            } else if (action == 0) {
                a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.g.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.viewpager.g getAdapter() {
        return this.g.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.g;
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.z zVar) {
        this.uf = zVar;
    }

    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.pf) {
                return false;
            }
            try {
                if (BaseSwiper.this.q == 1) {
                    boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(z(motionEvent));
                    z(motionEvent);
                    return zOnInterceptTouchEvent;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                wp.z(e);
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.pf) {
                return false;
            }
            try {
                if (BaseSwiper.this.q == 1) {
                    return super.onTouchEvent(z(motionEvent));
                }
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                wp.z(e);
                return false;
            }
        }

        private MotionEvent z(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    private void z(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.z.get(g.z(true, i, this.z.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.g.dl) {
                viewFindViewWithTag = ((com.bytedance.adsdk.ugeno.g.dl) t).fo();
            } else if (t instanceof View) {
                viewFindViewWithTag = (View) t;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }

    private boolean e() {
        return this.z.size() <= 2 && this.v;
    }
}
