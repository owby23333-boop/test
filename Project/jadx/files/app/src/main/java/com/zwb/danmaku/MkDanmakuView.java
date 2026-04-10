package com.zwb.danmaku;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.zwb.danmaku.b;
import com.zwb.danmaku.c.d;
import com.zwb.danmaku.c.e;
import com.zwb.danmaku.model.BaseDanmaku;
import com.zwb.danmaku.model.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MkDanmakuView extends View implements b {
    private int A;
    private int B;
    private DanmakuState C;
    private DanmakuState D;
    private float E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private List<BaseDanmaku> K;
    private long L;
    private int M;
    private boolean N;
    private boolean O;
    private e P;
    private HandlerThread Q;
    private Handler R;
    private b.a S;
    private d T;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f20618s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f20619t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f20620u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f20621v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f20622w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f20623x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f20624y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f20625z;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 17 && MkDanmakuView.this.getContext() != null) {
                if ((MkDanmakuView.this.getContext() instanceof Activity) && ((Activity) MkDanmakuView.this.getContext()).isFinishing()) {
                    return;
                }
                MkDanmakuView.this.i();
                if (MkDanmakuView.this.D != DanmakuState.START || MkDanmakuView.this.f20618s == null || MkDanmakuView.this.getMeasuredHeight() == 0 || MkDanmakuView.this.getMeasuredWidth() == 0) {
                    return;
                }
                int iB = MkDanmakuView.this.P.b();
                if (MkDanmakuView.this.P.b() != 1) {
                    if (iB != 0) {
                        MkDanmakuView.this.getDrawHelper().a(MkDanmakuView.this.getContext(), MkDanmakuView.this.f20618s, MkDanmakuView.this.f20619t, MkDanmakuView.this.getMeasuredWidth(), MkDanmakuView.this.getMeasuredHeight());
                        MkDanmakuView.this.postInvalidate();
                        return;
                    }
                    return;
                }
                if (MkDanmakuView.this.G < 0) {
                    MkDanmakuView.this.P.c();
                    return;
                }
                MkDanmakuView.h(MkDanmakuView.this);
                if (MkDanmakuView.this.H <= MkDanmakuView.this.G) {
                    MkDanmakuView.this.P.c();
                }
            }
        }
    }

    public MkDanmakuView(Context context) {
        super(context);
        this.f20621v = 24;
        this.f20622w = -1;
        this.f20623x = 0;
        this.f20624y = 0;
        this.f20625z = 0;
        this.A = -1;
        this.B = 1;
        DanmakuState danmakuState = DanmakuState.STOP;
        this.C = danmakuState;
        this.D = danmakuState;
        this.E = 2.0f;
        this.F = Integer.MAX_VALUE;
        this.G = -1;
        this.H = 0;
        this.I = 20.0f;
        this.K = new ArrayList();
        this.L = 1000L;
        this.M = 10;
        a(context, null, 0);
    }

    private Looper getLooper() {
        h();
        this.Q = new HandlerThread("Danmaku");
        this.Q.start();
        return this.Q.getLooper();
    }

    static /* synthetic */ int h(MkDanmakuView mkDanmakuView) {
        int i2 = mkDanmakuView.H;
        mkDanmakuView.H = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.R != null && this.Q != null) {
            this.R.removeMessages(17);
            this.R.removeMessages(18);
            this.R.sendEmptyMessageDelayed(17, 12L);
        }
    }

    private void j() {
        Handler handler = this.R;
        if (handler == null || this.Q == null) {
            return;
        }
        handler.removeMessages(17);
        this.R.removeMessages(18);
        this.R.sendEmptyMessage(18);
    }

    public List<BaseDanmaku> getDanmukus() {
        return this.K;
    }

    public e getDrawHelper() {
        if (this.P == null) {
            this.P = new e();
        }
        return this.P;
    }

    @Override // com.zwb.danmaku.b
    public b.a getOnDanmakuClickListener() {
        return this.S;
    }

    public DanmakuState getState() {
        return this.D;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N = true;
        d();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.N = false;
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
            return;
        }
        getDrawHelper().a(canvas, this.f20618s, this.f20619t, this.f20620u, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.T.a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.O = i2 == 0;
        if (this.O) {
            d();
        } else {
            c();
        }
    }

    public synchronized void setDanmukus(List<BaseDanmaku> list) {
        if (list != null) {
            this.K.clear();
            this.H = 0;
            this.K.addAll(list);
            getDrawHelper().a(list);
        }
    }

    public void setOnDanmakuClickListener(b.a aVar) {
        this.S = aVar;
    }

    public void setShadowStyle(int i2) {
        this.B = i2;
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this.J = getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MkDanmakuView, i2, 0);
        try {
            this.f20622w = typedArrayObtainStyledAttributes.getColor(R$styleable.MkDanmakuView_danmaku_textColor, this.f20622w);
            this.f20623x = typedArrayObtainStyledAttributes.getColor(R$styleable.MkDanmakuView_danmaku_textShadowColor, this.f20623x);
            this.f20621v = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MkDanmakuView_danmaku_textSize, (int) (this.J * this.f20621v));
            this.f20624y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MkDanmakuView_danmaku_textShadowWidth, (int) (this.f20624y * this.J));
            this.I = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MkDanmakuView_danmaku_trajectoryMargin, (int) (this.I * this.J));
            this.f20625z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MkDanmakuView_danmaku_lineSpacingExtra, (int) (this.f20625z * this.J));
            this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MkDanmakuView_danmaku_maxWidth, this.A);
            this.F = typedArrayObtainStyledAttributes.getInteger(R$styleable.MkDanmakuView_danmaku_trajectoryCount, 2);
            this.G = typedArrayObtainStyledAttributes.getInteger(R$styleable.MkDanmakuView_danmaku_repeatCount, -1);
            this.L = typedArrayObtainStyledAttributes.getInteger(R$styleable.MkDanmakuView_danmaku_interval, 1000);
            this.M = typedArrayObtainStyledAttributes.getInteger(R$styleable.MkDanmakuView_danmaku_countLimit, 10);
            this.E = typedArrayObtainStyledAttributes.getFloat(R$styleable.MkDanmakuView_danmaku_speed, this.E * this.J);
            this.B = typedArrayObtainStyledAttributes.getInt(R$styleable.MkDanmakuView_danmaku_shadowStyle, this.B);
            typedArrayObtainStyledAttributes.recycle();
            this.f20618s = new Paint();
            this.f20618s.setStyle(Paint.Style.FILL);
            this.f20618s.setDither(true);
            this.f20618s.setAntiAlias(true);
            this.f20620u = new Paint(this.f20618s);
            this.f20619t = new Paint(this.f20618s);
            this.f20619t.setStyle(Paint.Style.STROKE);
            c cVar = new c();
            cVar.a(this.E);
            cVar.d(this.f20622w);
            cVar.e(this.f20623x);
            cVar.f(this.f20624y);
            cVar.g(this.f20621v);
            cVar.c(this.B);
            cVar.b(this.A);
            cVar.a(this.f20625z);
            e drawHelper = getDrawHelper();
            drawHelper.a(this.J);
            drawHelper.a(cVar);
            drawHelper.b(this.I);
            drawHelper.b(this.F);
            drawHelper.a(this.L);
            drawHelper.a(this.M);
            this.T = new d(this);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void g() {
        Handler handler = this.R;
        if (handler != null) {
            handler.removeMessages(17);
            this.R.removeMessages(18);
        }
        this.R = new a(getLooper());
    }

    private void h() {
        HandlerThread handlerThread = this.Q;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.Q = null;
        }
    }

    public boolean b() {
        return this.D == DanmakuState.START;
    }

    public void c() {
        this.D = DanmakuState.STOP;
        j();
        h();
    }

    public void d() {
        if (this.N && this.O) {
            DanmakuState danmakuState = this.C;
            DanmakuState danmakuState2 = DanmakuState.START;
            if (danmakuState == danmakuState2) {
                this.D = danmakuState2;
                j();
                g();
                i();
            }
        }
    }

    public void e() {
        this.C = DanmakuState.START;
        d();
    }

    public void f() {
        this.C = DanmakuState.STOP;
        c();
    }

    public MkDanmakuView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20621v = 24;
        this.f20622w = -1;
        this.f20623x = 0;
        this.f20624y = 0;
        this.f20625z = 0;
        this.A = -1;
        this.B = 1;
        DanmakuState danmakuState = DanmakuState.STOP;
        this.C = danmakuState;
        this.D = danmakuState;
        this.E = 2.0f;
        this.F = Integer.MAX_VALUE;
        this.G = -1;
        this.H = 0;
        this.I = 20.0f;
        this.K = new ArrayList();
        this.L = 1000L;
        this.M = 10;
        a(context, attributeSet, 0);
    }

    public MkDanmakuView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20621v = 24;
        this.f20622w = -1;
        this.f20623x = 0;
        this.f20624y = 0;
        this.f20625z = 0;
        this.A = -1;
        this.B = 1;
        DanmakuState danmakuState = DanmakuState.STOP;
        this.C = danmakuState;
        this.D = danmakuState;
        this.E = 2.0f;
        this.F = Integer.MAX_VALUE;
        this.G = -1;
        this.H = 0;
        this.I = 20.0f;
        this.K = new ArrayList();
        this.L = 1000L;
        this.M = 10;
        a(context, attributeSet, i2);
    }

    public MkDanmakuView a(int i2) {
        if (i2 > 0) {
            this.F = i2;
            getDrawHelper().b(i2);
        }
        return this;
    }

    public void a(BaseDanmaku baseDanmaku, int i2) {
        if (baseDanmaku != null) {
            this.K.add(i2, baseDanmaku);
            getDrawHelper().a(baseDanmaku, i2);
        }
    }

    public synchronized void a() {
        this.H = 0;
        this.C = DanmakuState.STOP;
        this.D = DanmakuState.STOP;
        f();
        this.K.clear();
        getDrawHelper().a();
        invalidate();
    }

    @Override // com.zwb.danmaku.b
    public BaseDanmaku a(float f2, float f3) {
        if (getDrawHelper() != null) {
            return getDrawHelper().a(f2, f3);
        }
        return null;
    }
}
