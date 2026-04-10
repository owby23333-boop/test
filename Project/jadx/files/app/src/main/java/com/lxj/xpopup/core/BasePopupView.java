package com.lxj.xpopup.core;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.lxj.xpopup.util.KeyboardUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePopupView extends FrameLayout implements LifecycleObserver, LifecycleOwner {
    private int A;
    private boolean B;
    protected Handler C;
    protected LifecycleRegistry D;
    private final Runnable E;
    public com.lxj.xpopup.core.a F;
    private final Runnable G;
    protected Runnable H;
    private j I;
    protected Runnable J;
    Runnable K;
    private float L;
    private float M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.lxj.xpopup.core.b f17361s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected com.lxj.xpopup.b.c f17362t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected com.lxj.xpopup.b.f f17363u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected com.lxj.xpopup.b.a f17364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f17365w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PopupStatus f17366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected boolean f17367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17368z;

    /* JADX INFO: loaded from: classes3.dex */
    class a implements Runnable {

        /* JADX INFO: renamed from: com.lxj.xpopup.core.BasePopupView$a$a, reason: collision with other inner class name */
        class C0494a implements KeyboardUtils.b {
            C0494a() {
            }

            @Override // com.lxj.xpopup.util.KeyboardUtils.b
            public void a(int i2) {
                com.lxj.xpopup.c.h hVar;
                BasePopupView.this.a(i2);
                BasePopupView basePopupView = BasePopupView.this;
                com.lxj.xpopup.core.b bVar = basePopupView.f17361s;
                if (bVar != null && (hVar = bVar.f17423r) != null) {
                    hVar.a(basePopupView, i2);
                }
                if (i2 == 0) {
                    com.lxj.xpopup.util.b.a(BasePopupView.this);
                    BasePopupView.this.B = false;
                    return;
                }
                BasePopupView basePopupView2 = BasePopupView.this;
                if ((basePopupView2 instanceof PartShadowPopupView) && basePopupView2.f17366x == PopupStatus.Showing) {
                    return;
                }
                com.lxj.xpopup.util.b.b(i2, BasePopupView.this);
                BasePopupView.this.B = true;
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.w();
            KeyboardUtils.a(BasePopupView.this.getHostWindow(), BasePopupView.this, new C0494a());
            BasePopupView.this.o();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BasePopupView.this.getHostWindow() == null) {
                return;
            }
            BasePopupView basePopupView = BasePopupView.this;
            com.lxj.xpopup.c.h hVar = basePopupView.f17361s.f17423r;
            if (hVar != null) {
                hVar.d(basePopupView);
            }
            BasePopupView.this.e();
            BasePopupView.this.D.handleLifecycleEvent(Lifecycle.Event.ON_START);
            BasePopupView basePopupView2 = BasePopupView.this;
            if (!(basePopupView2 instanceof FullScreenPopupView)) {
                basePopupView2.m();
            }
            BasePopupView basePopupView3 = BasePopupView.this;
            if ((basePopupView3 instanceof AttachPopupView) || (basePopupView3 instanceof BubbleAttachPopupView) || (basePopupView3 instanceof PositionPopupView) || (basePopupView3 instanceof PartShadowPopupView)) {
                return;
            }
            basePopupView3.p();
            BasePopupView.this.l();
            BasePopupView.this.j();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.lxj.xpopup.c.h hVar;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f17366x = PopupStatus.Show;
            basePopupView.D.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            BasePopupView.this.t();
            BasePopupView basePopupView2 = BasePopupView.this;
            if (basePopupView2 instanceof FullScreenPopupView) {
                basePopupView2.m();
            }
            BasePopupView basePopupView3 = BasePopupView.this;
            com.lxj.xpopup.core.b bVar = basePopupView3.f17361s;
            if (bVar != null && (hVar = bVar.f17423r) != null) {
                hVar.c(basePopupView3);
            }
            if (BasePopupView.this.getHostWindow() == null || com.lxj.xpopup.util.b.a(BasePopupView.this.getHostWindow()) <= 0 || BasePopupView.this.B) {
                return;
            }
            com.lxj.xpopup.util.b.b(com.lxj.xpopup.util.b.a(BasePopupView.this.getHostWindow()), BasePopupView.this);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class d implements View.OnUnhandledKeyEventListener {
        d() {
        }

        @Override // android.view.View.OnUnhandledKeyEventListener
        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return BasePopupView.this.a(keyEvent.getKeyCode(), keyEvent);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class e implements View.OnUnhandledKeyEventListener {
        e() {
        }

        @Override // android.view.View.OnUnhandledKeyEventListener
        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return BasePopupView.this.a(keyEvent.getKeyCode(), keyEvent);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.g();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewById;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f17366x = PopupStatus.Dismiss;
            basePopupView.D.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            com.lxj.xpopup.core.b bVar = BasePopupView.this.f17361s;
            if (bVar == null) {
                return;
            }
            if (bVar.f17422q.booleanValue()) {
                BasePopupView basePopupView2 = BasePopupView.this;
                if (basePopupView2 instanceof PartShadowPopupView) {
                    KeyboardUtils.a(basePopupView2);
                }
            }
            BasePopupView.this.s();
            com.lxj.xpopup.a.f17319f = null;
            BasePopupView basePopupView3 = BasePopupView.this;
            com.lxj.xpopup.c.h hVar = basePopupView3.f17361s.f17423r;
            if (hVar != null) {
                hVar.e(basePopupView3);
            }
            Runnable runnable = BasePopupView.this.K;
            if (runnable != null) {
                runnable.run();
                BasePopupView.this.K = null;
            }
            BasePopupView basePopupView4 = BasePopupView.this;
            com.lxj.xpopup.core.b bVar2 = basePopupView4.f17361s;
            if (bVar2.D && bVar2.L && basePopupView4.getWindowDecorView() != null && (viewFindViewById = BasePopupView.this.getWindowDecorView().findViewById(R.id.content)) != null) {
                viewFindViewById.setFocusable(true);
                viewFindViewById.setFocusableInTouchMode(true);
            }
            BasePopupView.this.x();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static /* synthetic */ class h {
        static final /* synthetic */ int[] a = new int[PopupAnimation.values().length];

        static {
            try {
                a[PopupAnimation.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PopupAnimation.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PopupAnimation.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PopupAnimation.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PopupAnimation.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[PopupAnimation.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class i implements View.OnKeyListener {
        i() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            return BasePopupView.this.a(i2, keyEvent);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class j implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        View f17375s;

        public j(View view) {
            this.f17375s = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f17375s;
            if (view != null) {
                KeyboardUtils.b(view);
            }
        }
    }

    public BasePopupView(@NonNull Context context) {
        super(context);
        this.f17366x = PopupStatus.Dismiss;
        this.f17367y = false;
        this.f17368z = false;
        this.A = -1;
        this.B = false;
        this.C = new Handler(Looper.getMainLooper());
        this.E = new a();
        this.G = new b();
        this.H = new c();
        this.J = new g();
        if (context instanceof Application) {
            throw new IllegalArgumentException("XPopup的Context必须是Activity类型！");
        }
        this.D = new LifecycleRegistry(this);
        this.f17365w = ViewConfiguration.get(context).getScaledTouchSlop();
        setId(View.generateViewId());
        View viewInflate = LayoutInflater.from(context).inflate(getInnerLayoutId(), (ViewGroup) this, false);
        viewInflate.setAlpha(0.0f);
        addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        View viewFindViewById;
        if (this.f17361s == null) {
            throw new IllegalArgumentException("如果弹窗对象是复用的，则不要设置isDestroyOnDismiss(true)");
        }
        if (getContext() instanceof FragmentActivity) {
            ((FragmentActivity) getContext()).getLifecycle().addObserver(this);
        }
        if (!this.f17361s.L) {
            if (this.F == null) {
                com.lxj.xpopup.core.a aVar = new com.lxj.xpopup.core.a(getContext());
                aVar.a(this);
                this.F = aVar;
            }
            this.F.show();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        int measuredHeight = 0;
        if (Build.VERSION.SDK_INT >= 21 && (viewFindViewById = viewGroup.findViewById(R.id.navigationBarBackground)) != null) {
            measuredHeight = viewFindViewById.getMeasuredHeight();
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        viewGroup.addView(this, new FrameLayout.LayoutParams(-1, viewGroup.getMeasuredHeight() - measuredHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || !bVar.L) {
            com.lxj.xpopup.core.a aVar = this.F;
            if (aVar != null) {
                aVar.dismiss();
                return;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    protected void a(int i2) {
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void d() {
    }

    protected void e() {
    }

    public void f() {
        View view;
        View view2;
        View view3;
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar != null) {
            bVar.f17412g = null;
            bVar.f17413h = null;
            bVar.f17423r = null;
            com.lxj.xpopup.b.c cVar = bVar.f17415j;
            if (cVar != null && (view3 = cVar.b) != null) {
                view3.animate().cancel();
            }
            if (this.f17361s.L) {
                v();
            }
            if (this.f17361s.J) {
                this.f17361s = null;
            }
        }
        com.lxj.xpopup.core.a aVar = this.F;
        if (aVar != null) {
            aVar.f17407s = null;
            this.F = null;
        }
        com.lxj.xpopup.b.f fVar = this.f17363u;
        if (fVar != null && (view2 = fVar.b) != null) {
            view2.animate().cancel();
        }
        com.lxj.xpopup.b.a aVar2 = this.f17364v;
        if (aVar2 == null || (view = aVar2.b) == null) {
            return;
        }
        view.animate().cancel();
        Bitmap bitmap = this.f17364v.f17322f;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f17364v.f17322f.recycle();
        this.f17364v.f17322f = null;
    }

    public void g() {
        com.lxj.xpopup.c.h hVar;
        this.C.removeCallbacks(this.E);
        this.C.removeCallbacks(this.G);
        PopupStatus popupStatus = this.f17366x;
        if (popupStatus == PopupStatus.Dismissing || popupStatus == PopupStatus.Dismiss) {
            return;
        }
        this.f17366x = PopupStatus.Dismissing;
        clearFocus();
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar != null && (hVar = bVar.f17423r) != null) {
            hVar.f(this);
        }
        d();
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        k();
        i();
    }

    public int getAnimationDuration() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null) {
            return 0;
        }
        if (bVar.f17414i == PopupAnimation.NoAnimation) {
            return 1;
        }
        int i2 = bVar.O;
        return i2 >= 0 ? i2 : com.lxj.xpopup.a.a() + 1;
    }

    public Window getHostWindow() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar != null && bVar.L) {
            return ((Activity) getContext()).getWindow();
        }
        com.lxj.xpopup.core.a aVar = this.F;
        if (aVar == null) {
            return null;
        }
        return aVar.getWindow();
    }

    protected int getImplLayoutId() {
        return -1;
    }

    protected abstract int getInnerLayoutId();

    protected List<String> getInternalFragmentNames() {
        return null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.D;
    }

    protected int getMaxHeight() {
        return this.f17361s.f17418m;
    }

    protected int getMaxWidth() {
        return this.f17361s.f17417l;
    }

    protected com.lxj.xpopup.b.c getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    protected int getPopupHeight() {
        return this.f17361s.f17420o;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    protected int getPopupWidth() {
        return this.f17361s.f17419n;
    }

    public int getShadowBgColor() {
        int i2;
        com.lxj.xpopup.core.b bVar = this.f17361s;
        return (bVar == null || (i2 = bVar.N) == 0) ? com.lxj.xpopup.a.d() : i2;
    }

    public int getStatusBarBgColor() {
        int i2;
        com.lxj.xpopup.core.b bVar = this.f17361s;
        return (bVar == null || (i2 = bVar.P) == 0) ? com.lxj.xpopup.a.e() : i2;
    }

    protected View getWindowDecorView() {
        if (getHostWindow() == null) {
            return null;
        }
        return (ViewGroup) getHostWindow().getDecorView();
    }

    public void h() {
        if (KeyboardUtils.a == 0) {
            g();
        } else {
            KeyboardUtils.a(this);
        }
    }

    protected void i() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar != null && bVar.f17422q.booleanValue() && !(this instanceof PartShadowPopupView)) {
            KeyboardUtils.a(this);
        }
        this.C.removeCallbacks(this.J);
        this.C.postDelayed(this.J, getAnimationDuration());
    }

    protected void j() {
        this.C.removeCallbacks(this.H);
        this.C.postDelayed(this.H, getAnimationDuration());
    }

    protected void k() {
        com.lxj.xpopup.b.a aVar;
        com.lxj.xpopup.b.f fVar;
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null) {
            return;
        }
        if (bVar.f17410e.booleanValue() && !this.f17361s.f17411f.booleanValue() && (fVar = this.f17363u) != null) {
            fVar.a();
        } else if (this.f17361s.f17411f.booleanValue() && (aVar = this.f17364v) != null) {
            aVar.a();
        }
        com.lxj.xpopup.b.c cVar = this.f17362t;
        if (cVar != null) {
            cVar.a();
        }
    }

    protected void l() {
        com.lxj.xpopup.b.a aVar;
        com.lxj.xpopup.b.f fVar;
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null) {
            return;
        }
        if (bVar.f17410e.booleanValue() && !this.f17361s.f17411f.booleanValue() && (fVar = this.f17363u) != null) {
            fVar.b();
        } else if (this.f17361s.f17411f.booleanValue() && (aVar = this.f17364v) != null) {
            aVar.b();
        }
        com.lxj.xpopup.b.c cVar = this.f17362t;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void m() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || !bVar.D) {
            return;
        }
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        if (Build.VERSION.SDK_INT >= 28) {
            addOnUnhandledKeyEventListener(new d());
        } else {
            setOnKeyListener(new i());
        }
        ArrayList arrayList = new ArrayList();
        com.lxj.xpopup.util.b.a((ArrayList<EditText>) arrayList, (ViewGroup) getPopupContentView());
        if (arrayList.size() <= 0) {
            if (this.f17361s.f17422q.booleanValue()) {
                a((View) this);
                return;
            }
            return;
        }
        if (this.f17361s.L) {
            this.A = getHostWindow().getAttributes().softInputMode;
            getHostWindow().setSoftInputMode(16);
            this.f17368z = true;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EditText editText = (EditText) arrayList.get(i2);
            if (Build.VERSION.SDK_INT >= 28) {
                editText.addOnUnhandledKeyEventListener(new e());
            } else if (!com.lxj.xpopup.util.b.b(editText)) {
                editText.setOnKeyListener(new i());
            }
            if (i2 == 0) {
                com.lxj.xpopup.core.b bVar2 = this.f17361s;
                if (bVar2.E) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    if (this.f17361s.f17422q.booleanValue()) {
                        a(editText);
                    }
                } else if (bVar2.f17422q.booleanValue()) {
                    a((View) this);
                }
            }
        }
    }

    protected com.lxj.xpopup.b.c n() {
        PopupAnimation popupAnimation;
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || (popupAnimation = bVar.f17414i) == null) {
            return null;
        }
        switch (h.a[popupAnimation.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new com.lxj.xpopup.b.d(getPopupContentView(), getAnimationDuration(), this.f17361s.f17414i);
            case 6:
            case 7:
            case 8:
            case 9:
                return new com.lxj.xpopup.b.g(getPopupContentView(), getAnimationDuration(), this.f17361s.f17414i);
            case 10:
            case 11:
            case 12:
            case 13:
                return new com.lxj.xpopup.b.h(getPopupContentView(), getAnimationDuration(), this.f17361s.f17414i);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new com.lxj.xpopup.b.e(getPopupContentView(), getAnimationDuration(), this.f17361s.f17414i);
            case 22:
                return new com.lxj.xpopup.b.b(getPopupContentView(), getAnimationDuration());
            default:
                return null;
        }
    }

    protected void o() {
        if (this.f17363u == null) {
            this.f17363u = new com.lxj.xpopup.b.f(this, getAnimationDuration(), getShadowBgColor());
        }
        if (this.f17361s.f17411f.booleanValue()) {
            this.f17364v = new com.lxj.xpopup.b.a(this, getShadowBgColor());
            this.f17364v.f17323g = this.f17361s.f17410e.booleanValue();
            this.f17364v.f17322f = com.lxj.xpopup.util.b.c(com.lxj.xpopup.util.b.a((View) this).getWindow().getDecorView());
        }
        if ((this instanceof AttachPopupView) || (this instanceof BubbleAttachPopupView) || (this instanceof PartShadowPopupView) || (this instanceof PositionPopupView) || !this.f17367y) {
            q();
        }
        if (!this.f17367y) {
            this.f17367y = true;
            r();
            this.D.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            com.lxj.xpopup.c.h hVar = this.f17361s.f17423r;
            if (hVar != null) {
                hVar.a(this);
            }
        }
        this.C.postDelayed(this.G, 10L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        onDetachedFromWindow();
        x();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.C.removeCallbacksAndMessages(null);
        if (this.f17361s != null) {
            if (getWindowDecorView() != null) {
                KeyboardUtils.a(getHostWindow(), this);
            }
            if (this.f17361s.L && this.f17368z) {
                getHostWindow().setSoftInputMode(this.A);
                this.f17368z = false;
            }
            if (this.f17361s.J) {
                f();
            }
        }
        if (getContext() != null && (getContext() instanceof FragmentActivity)) {
            ((FragmentActivity) getContext()).getLifecycle().removeObserver(this);
        }
        this.f17366x = PopupStatus.Dismiss;
        this.I = null;
        this.B = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.lxj.xpopup.core.b bVar;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!com.lxj.xpopup.util.b.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.L = motionEvent.getX();
                this.M = motionEvent.getY();
                a(motionEvent);
            } else if (action == 1 || action == 2 || action == 3) {
                float fSqrt = (float) Math.sqrt(Math.pow(motionEvent.getX() - this.L, 2.0d) + Math.pow(motionEvent.getY() - this.M, 2.0d));
                if (!com.lxj.xpopup.util.b.a(motionEvent.getX(), motionEvent.getY(), rect2)) {
                    a(motionEvent);
                }
                if (fSqrt < this.f17365w && (bVar = this.f17361s) != null && bVar.f17408c.booleanValue()) {
                    g();
                    getPopupImplView().getGlobalVisibleRect(rect2);
                }
                this.L = 0.0f;
                this.M = 0.0f;
            }
        }
        return true;
    }

    protected void p() {
        com.lxj.xpopup.b.a aVar;
        getPopupContentView().setAlpha(1.0f);
        com.lxj.xpopup.b.c cVar = this.f17361s.f17415j;
        if (cVar != null) {
            this.f17362t = cVar;
            this.f17362t.b = getPopupContentView();
        } else {
            this.f17362t = n();
            if (this.f17362t == null) {
                this.f17362t = getPopupAnimator();
            }
        }
        if (this.f17361s.f17410e.booleanValue()) {
            this.f17363u.c();
        }
        if (this.f17361s.f17411f.booleanValue() && (aVar = this.f17364v) != null) {
            aVar.c();
        }
        com.lxj.xpopup.b.c cVar2 = this.f17362t;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    protected void q() {
    }

    protected void r() {
    }

    protected void s() {
    }

    protected void t() {
    }

    public BasePopupView u() {
        com.lxj.xpopup.core.b bVar;
        PopupStatus popupStatus;
        com.lxj.xpopup.core.a aVar;
        Activity activityA = com.lxj.xpopup.util.b.a((View) this);
        if (activityA != null && !activityA.isFinishing() && (bVar = this.f17361s) != null && (popupStatus = this.f17366x) != PopupStatus.Showing && popupStatus != PopupStatus.Dismissing) {
            this.f17366x = PopupStatus.Showing;
            if (bVar.D) {
                KeyboardUtils.c(activityA.getWindow());
            }
            if (!this.f17361s.L && (aVar = this.F) != null && aVar.isShowing()) {
                return this;
            }
            this.C.post(this.E);
        }
        return this;
    }

    protected void v() {
        if (getContext() instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
            List<Fragment> fragments = supportFragmentManager.getFragments();
            List<String> internalFragmentNames = getInternalFragmentNames();
            if (fragments == null || fragments.size() <= 0 || internalFragmentNames == null) {
                return;
            }
            for (int i2 = 0; i2 < fragments.size(); i2++) {
                if (internalFragmentNames.contains(fragments.get(i2).getClass().getSimpleName())) {
                    supportFragmentManager.beginTransaction().remove(fragments.get(i2)).commitAllowingStateLoss();
                }
            }
        }
    }

    protected void a(View view) {
        if (this.f17361s != null) {
            j jVar = this.I;
            if (jVar == null) {
                this.I = new j(view);
            } else {
                this.C.removeCallbacks(jVar);
            }
            this.C.postDelayed(this.I, 10L);
        }
    }

    protected boolean a(int i2, KeyEvent keyEvent) {
        com.lxj.xpopup.core.b bVar;
        com.lxj.xpopup.c.h hVar;
        if (i2 != 4 || keyEvent.getAction() != 1 || (bVar = this.f17361s) == null) {
            return false;
        }
        if (bVar.b.booleanValue() && ((hVar = this.f17361s.f17423r) == null || !hVar.b(this))) {
            h();
        }
        return true;
    }

    public void a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        this.C.postDelayed(new f(), j2);
    }

    private void a(MotionEvent motionEvent) {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || !bVar.F) {
            return;
        }
        if (bVar.L) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != this) {
                    childAt.dispatchTouchEvent(motionEvent);
                }
            }
            return;
        }
        ((Activity) getContext()).dispatchTouchEvent(motionEvent);
    }
}
