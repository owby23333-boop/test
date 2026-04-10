package com.qmuiteam.qmui.util;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWindowHelper {
    public static final int KEYBOARD_HEIGHT_BOUNDARY_DP = 100;

    public static void setWindowType(WindowManager.LayoutParams layoutParams) {
        layoutParams.type = 2005;
    }

    public static Rect unSafeGetWindowVisibleInsets(View view) {
        Object attachInfoFromView = getAttachInfoFromView(view);
        if (attachInfoFromView == null) {
            return null;
        }
        try {
            Field declaredField = attachInfoFromView.getClass().getDeclaredField("mVisibleInsets");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(attachInfoFromView);
            if (obj instanceof Rect) {
                return (Rect) obj;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Rect unSafeGetContentInsets(View view) {
        Object attachInfoFromView = getAttachInfoFromView(view);
        if (attachInfoFromView == null) {
            return null;
        }
        try {
            Field declaredField = attachInfoFromView.getClass().getDeclaredField("mContentInsets");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(attachInfoFromView);
            if (obj instanceof Rect) {
                return (Rect) obj;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object getAttachInfoFromView(View view) {
        ViewParent parent;
        Object obj = null;
        if (Build.VERSION.SDK_INT > 28) {
            View rootView = view.getRootView();
            if (rootView != null && (parent = rootView.getParent()) != null) {
                Field declaredField = parent.getClass().getDeclaredField("mAttachInfo");
                declaredField.setAccessible(true);
                obj = declaredField.get(parent);
            }
            return obj;
        }
        Field declaredField2 = View.class.getDeclaredField("mAttachInfo");
        declaredField2.setAccessible(true);
        obj = declaredField2.get(view);
        return obj;
    }
}
