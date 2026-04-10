package com.anythink.expressad.foundation.h;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final String a = "ViewUtils";
    private static boolean b = false;

    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.view.View r8) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.y.a(android.view.View):boolean");
    }

    private static boolean b(View view) {
        if (view.getAlpha() <= 0.5f) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getBackground() != null && view.getBackground().getAlpha() > 127;
        }
        return true;
    }

    private static boolean b(View view, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            o.d(a, "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0 && a(view, childAt)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    o.d(a, "View Judge : View Covered by WebView.");
                    b = true;
                }
                if (b(childAt)) {
                    o.d(a, "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    b = true;
                }
                if (b) {
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    b(view, (ViewGroup) childAt);
                }
            }
        }
        return b;
    }

    private static boolean a(View view, View view2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2) && ((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth();
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i2 = 0;
        while (i2 < viewGroup.getChildCount() && viewGroup.getChildAt(i2) != view) {
            i2++;
        }
        return i2;
    }
}
