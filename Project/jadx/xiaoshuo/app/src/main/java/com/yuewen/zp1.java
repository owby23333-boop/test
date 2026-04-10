package com.yuewen;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

/* JADX INFO: loaded from: classes5.dex */
public class zp1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int e = 300;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20886b = false;
    public Window c;
    public View d;

    public interface a {
        void onKeyboardChange(boolean z, int i);
    }

    public zp1(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            this.d = e(activity);
            this.c = activity.getWindow();
        } else if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            this.d = f(dialog);
            this.c = dialog.getWindow();
        }
        if (this.d == null || this.c == null) {
            return;
        }
        a();
    }

    public static zp1 b(Activity activity) {
        return new zp1(activity);
    }

    public static zp1 c(Dialog dialog) {
        return new zp1(dialog);
    }

    public final void a() {
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void d() {
        View view = this.d;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public final View e(Activity activity) {
        return activity.findViewById(R.id.content);
    }

    public final View f(Dialog dialog) {
        return dialog.findViewById(R.id.content);
    }

    public final int g() {
        Display defaultDisplay = this.c.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point.y;
    }

    public void h(a aVar) {
        this.f20885a = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.d;
        if (view == null || this.c == null || view.getHeight() == 0) {
            return;
        }
        int iG = g();
        Rect rect = new Rect();
        this.c.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = iG - rect.bottom;
        a aVar = this.f20885a;
        if (aVar != null) {
            boolean z = i > 300;
            if (this.f20886b != z) {
                this.f20886b = z;
                aVar.onKeyboardChange(z, i);
            }
        }
    }
}
