package com.duokan.reader.ui.general;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.duokan.core.ui.BoxView;
import com.yuewen.ia0;
import com.yuewen.kl2;
import com.yuewen.rt2;
import com.yuewen.rv1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"SoonBlockedPrivateApi"})
public class DkToast extends Toast {
    public static WeakReference<DkToast> c = null;
    public static final int d = 0;
    public static final int e = 1;
    public static Field f;
    public static Field g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f5399b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f5400a;

        public a(Handler handler) {
            this.f5400a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f5400a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f.getType().getDeclaredField("mHandler");
            g = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public DkToast(Context context) {
        this(context, 0);
    }

    public static void a() {
        WeakReference<DkToast> weakReference = c;
        if (weakReference != null) {
            DkToast dkToast = weakReference.get();
            if (dkToast != null) {
                dkToast.cancel();
            }
            c.clear();
        }
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static DkToast c(Context context) {
        a();
        DkToast dkToast = new DkToast(context.getApplicationContext());
        g(dkToast);
        return dkToast;
    }

    public static DkToast d(Context context, int i) {
        a();
        DkToast dkToast = new DkToast(context.getApplicationContext(), i);
        c = new WeakReference<>(dkToast);
        g(dkToast);
        return dkToast;
    }

    public static DkToast e(Context context, int i, int i2) {
        a();
        DkToast dkToast = new DkToast(context.getApplicationContext(), i, i2);
        c = new WeakReference<>(dkToast);
        g(dkToast);
        return dkToast;
    }

    public static DkToast f(Context context, View view, int i, int i2) {
        a();
        DkToast dkToast = new DkToast(context.getApplicationContext(), view, i, i2);
        c = new WeakReference<>(dkToast);
        g(dkToast);
        return dkToast;
    }

    public static void g(Toast toast) {
        try {
            Object obj = f.get(toast);
            g.set(obj, new a((Handler) g.get(obj)));
        } catch (Exception unused) {
        }
    }

    public static Toast i(Context context, String str, int i, int i2, int i3) {
        DkToast dkToastE = e(context, i2, i3);
        dkToastE.setText(str);
        dkToastE.setDuration(i);
        g(dkToastE);
        return dkToastE;
    }

    public static Toast j(Context context, int i) {
        return makeText(context, context.getString(i), 0);
    }

    public static Toast k(Context context, int i, int i2, int i3) {
        return m(context, context.getString(i), i2, i3);
    }

    public static Toast l(Context context, View view, int i, int i2, int i3) {
        DkToast dkToastF = f(context, view, i2, i3);
        dkToastF.setDuration(i);
        g(dkToastF);
        return dkToastF;
    }

    public static Toast m(Context context, CharSequence charSequence, int i, int i2) {
        DkToast dkToastD = d(context, i2);
        dkToastD.setText(charSequence);
        dkToastD.setDuration(i);
        g(dkToastD);
        return dkToastD;
    }

    public static Toast makeText(Context context, int i, int i2) {
        return makeText(context, context.getString(i), i2);
    }

    public static Toast n(Context context, String str) {
        return makeText(context, str, 0);
    }

    public static Toast o(Context context, int i, int i2) {
        return p(context, context.getString(i), i2);
    }

    public static Toast p(Context context, CharSequence charSequence, int i) {
        DkToast dkToast;
        DkToast dkToast2;
        WeakReference<DkToast> weakReference = c;
        if (weakReference != null && (dkToast2 = weakReference.get()) != null) {
            dkToast2.cancel();
        }
        WeakReference<DkToast> weakReference2 = c;
        if (weakReference2 == null || weakReference2.get() == null) {
            DkToast dkToast3 = new DkToast(context.getApplicationContext());
            c = new WeakReference<>(dkToast3);
            dkToast = dkToast3;
        } else {
            dkToast = c.get();
        }
        dkToast.setText(charSequence);
        dkToast.setDuration(i);
        g(dkToast);
        return dkToast;
    }

    public final void h(Context context) {
        BoxView boxView = (BoxView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(rt2.n.y3, (ViewGroup) null);
        this.f5399b = (TextView) boxView.findViewById(rt2.k.E3);
        setView(boxView);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f5399b.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void show() {
        if (!rv1.g()) {
            ia0.w().o("toast is not show on mainThread");
        }
        super.show();
    }

    public DkToast(Context context, int i) {
        super(context);
        this.f5398a = context;
        h(context);
        int iB = b(context);
        setGravity(17, 0, i == 0 ? (iB / 2) - (iB / 3) : iB / 3);
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        DkToast dkToastC = c(context);
        dkToastC.setText(charSequence);
        dkToastC.setDuration(i);
        g(dkToastC);
        return dkToastC;
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        setText(this.f5398a.getString(i));
    }

    public DkToast(Context context, int i, int i2) {
        super(context);
        this.f5398a = context;
        h(context);
        setGravity(i, 0, i2);
    }

    public DkToast(Context context, View view, int i, int i2) {
        super(context);
        this.f5398a = context;
        setView(view);
        setGravity(i, 0, i2);
    }
}
