package l.b.a;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: compiled from: ToastUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    private static Toast a;
    private static c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f21041c;

    public static void a(Application application, d dVar) {
        a(application);
        if (b == null) {
            a((c) new i());
        }
        a(b.a(application));
        a((View) a((Context) application, dVar));
        a(dVar.h(), dVar.j(), dVar.k());
    }

    private static Context getContext() {
        a();
        return a.getView().getContext();
    }

    public static void a(int i2) {
        a();
        try {
            a(getContext().getResources().getText(i2));
        } catch (Resources.NotFoundException unused) {
            a((CharSequence) String.valueOf(i2));
        }
    }

    public static synchronized void a(CharSequence charSequence) {
        a();
        if (charSequence != null && charSequence.length() != 0) {
            if (f21041c == null || !f21041c.a(a, charSequence)) {
                b.a(charSequence);
            }
        }
    }

    public static void a(int i2, int i3, int i4) {
        a();
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = Gravity.getAbsoluteGravity(i2, getContext().getResources().getConfiguration().getLayoutDirection());
        }
        a.setGravity(i2, i3, i4);
    }

    public static void a(View view) {
        a();
        a((Object) view);
        Context context = view.getContext();
        if (!(context instanceof Activity) && !(context instanceof Service)) {
            Toast toast = a;
            if (toast != null) {
                toast.setView(view);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The view must be initialized using the context of the application");
    }

    public static void a(Toast toast) {
        a((Object) toast);
        if (a != null && toast.getView() == null) {
            toast.setView(a.getView());
            toast.setGravity(a.getGravity(), a.getXOffset(), a.getYOffset());
            toast.setMargin(a.getHorizontalMargin(), a.getVerticalMargin());
        }
        a = toast;
        c cVar = b;
        if (cVar != null) {
            cVar.a(a);
        }
    }

    public static void a(c cVar) {
        a((Object) cVar);
        b = cVar;
        Toast toast = a;
        if (toast != null) {
            b.a(toast);
        }
    }

    private static void a() {
        if (a == null) {
            throw new IllegalStateException("ToastUtils has not been initialized");
        }
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("are you ok?");
        }
    }

    private static TextView a(Context context, d dVar) {
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setTextColor(dVar.d());
        textView.setTextSize(0, dVar.getTextSize());
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setPaddingRelative(dVar.b(), dVar.g(), dVar.a(), dVar.c());
        } else {
            textView.setPadding(dVar.b(), dVar.g(), dVar.a(), dVar.c());
        }
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(dVar.l());
        gradientDrawable.setCornerRadius(dVar.i());
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            textView.setZ(dVar.f());
        }
        if (dVar.e() > 0) {
            textView.setMaxLines(dVar.e());
        }
        return textView;
    }
}
