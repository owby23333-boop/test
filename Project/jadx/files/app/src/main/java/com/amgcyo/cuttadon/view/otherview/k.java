package com.amgcyo.cuttadon.view.otherview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: CustomPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements PopupWindow.OnDismissListener {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private PopupWindow.OnDismissListener E;
    private int F;
    private boolean G;
    private View.OnTouchListener H;
    private Window I;
    private boolean J;
    private float K;
    private boolean L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f5115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5118v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f5119w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f5121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PopupWindow f5122z;

    /* JADX INFO: compiled from: CustomPopWindow.java */
    class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            k.this.f5122z.dismiss();
            return true;
        }
    }

    /* JADX INFO: compiled from: CustomPopWindow.java */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (motionEvent.getAction() != 0 || (x2 >= 0 && x2 < k.this.f5116t && y2 >= 0 && y2 < k.this.f5117u)) {
                return motionEvent.getAction() == 4;
            }
            String str = "width:" + k.this.f5122z.getWidth() + "height:" + k.this.f5122z.getHeight() + " x:" + x2 + " y  :" + y2;
            return true;
        }
    }

    /* synthetic */ k(Context context, a aVar) {
        this(context);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a();
    }

    /* JADX INFO: compiled from: CustomPopWindow.java */
    public static class c {
        private k a;

        public c(Context context) {
            this.a = new k(context, null);
        }

        public c a(int i2, int i3) {
            this.a.f5116t = i2;
            this.a.f5117u = i3;
            return this;
        }

        public c b(boolean z2) {
            this.a.f5119w = z2;
            return this;
        }

        public c a(boolean z2) {
            this.a.f5118v = z2;
            return this;
        }

        public c a(View view) {
            this.a.f5121y = view;
            this.a.f5120x = -1;
            return this;
        }

        public c a(int i2) {
            this.a.A = i2;
            return this;
        }

        public k a() {
            this.a.c();
            return this.a;
        }
    }

    private k(Context context) {
        this.f5118v = true;
        this.f5119w = true;
        this.f5120x = -1;
        this.A = -1;
        this.B = true;
        this.C = false;
        this.D = -1;
        this.F = -1;
        this.G = true;
        this.J = false;
        this.K = 0.0f;
        this.L = true;
        this.f5115s = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow c() {
        int i2;
        if (this.f5121y == null) {
            this.f5121y = LayoutInflater.from(this.f5115s).inflate(this.f5120x, (ViewGroup) null);
        }
        Activity activity = (Activity) this.f5121y.getContext();
        if (activity != null && this.J) {
            float f2 = this.K;
            if (f2 <= 0.0f || f2 >= 1.0f) {
                f2 = 0.7f;
            }
            this.I = activity.getWindow();
            WindowManager.LayoutParams attributes = this.I.getAttributes();
            attributes.alpha = f2;
            this.I.addFlags(2);
            this.I.setAttributes(attributes);
        }
        int i3 = this.f5116t;
        if (i3 != 0 && (i2 = this.f5117u) != 0) {
            this.f5122z = new PopupWindow(this.f5121y, i3, i2);
        } else {
            this.f5122z = new PopupWindow(this.f5121y, -2, -2);
        }
        int i4 = this.A;
        if (i4 != -1) {
            this.f5122z.setAnimationStyle(i4);
        }
        a(this.f5122z);
        if (this.f5116t == 0 || this.f5117u == 0) {
            this.f5122z.getContentView().measure(0, 0);
            this.f5116t = this.f5122z.getContentView().getMeasuredWidth();
            this.f5117u = this.f5122z.getContentView().getMeasuredHeight();
        }
        this.f5122z.setOnDismissListener(this);
        if (!this.L) {
            this.f5122z.setFocusable(true);
            this.f5122z.setOutsideTouchable(false);
            this.f5122z.setBackgroundDrawable(null);
            this.f5122z.getContentView().setFocusable(true);
            this.f5122z.getContentView().setFocusableInTouchMode(true);
            this.f5122z.getContentView().setOnKeyListener(new a());
            this.f5122z.setTouchInterceptor(new b());
        } else {
            this.f5122z.setFocusable(this.f5118v);
            this.f5122z.setBackgroundDrawable(new ColorDrawable(0));
            this.f5122z.setOutsideTouchable(this.f5119w);
        }
        this.f5122z.update();
        return this.f5122z;
    }

    public PopupWindow b() {
        return this.f5122z;
    }

    public k a(View view, int i2, int i3) {
        PopupWindow popupWindow = this.f5122z;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view, i2, i3);
        }
        return this;
    }

    public k a(View view) {
        PopupWindow popupWindow = this.f5122z;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view);
        }
        return this;
    }

    private void a(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.B);
        if (this.C) {
            popupWindow.setIgnoreCheekPress();
        }
        int i2 = this.D;
        if (i2 != -1) {
            popupWindow.setInputMethodMode(i2);
        }
        int i3 = this.F;
        if (i3 != -1) {
            popupWindow.setSoftInputMode(i3);
        }
        PopupWindow.OnDismissListener onDismissListener = this.E;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        View.OnTouchListener onTouchListener = this.H;
        if (onTouchListener != null) {
            popupWindow.setTouchInterceptor(onTouchListener);
        }
        popupWindow.setTouchable(this.G);
    }

    public void a() {
        PopupWindow.OnDismissListener onDismissListener = this.E;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Window window = this.I;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.I.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.f5122z;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f5122z.dismiss();
    }
}
