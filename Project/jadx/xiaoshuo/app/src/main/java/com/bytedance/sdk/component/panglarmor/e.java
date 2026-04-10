package com.bytedance.sdk.component.panglarmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends View.AccessibilityDelegate {
    public static Field tg;
    public View bf;
    public View.AccessibilityDelegate e;
    public static e d = new e(null, null);
    public static int ga = 0;
    public static String vn = "";
    public static Set<Integer> p = new HashSet();

    static {
        tg = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                tg = declaredField;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public e(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.e = accessibilityDelegate;
        this.bf = view;
        SoftDecTool.h = true;
    }

    public static void e(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        Field field;
        if (p.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                field = tg;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (field != null) {
                accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
            } else {
                z = false;
                accessibilityDelegate = null;
            }
        }
        if (!(accessibilityDelegate instanceof e) && z) {
            view.setAccessibilityDelegate(new e(accessibilityDelegate, view));
            p.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            } else {
                super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        view.setAccessibilityDelegate(this.e);
        View.AccessibilityDelegate accessibilityDelegate = this.e;
        boolean zDispatchPopulateAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        if (e()) {
            return;
        }
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        viewGroup.setAccessibilityDelegate(this.e);
        View.AccessibilityDelegate accessibilityDelegate = this.e;
        boolean zOnRequestSendAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        SoftDecTool.f2096a = true;
        view.setAccessibilityDelegate(this.e);
        View.AccessibilityDelegate accessibilityDelegate = this.e;
        boolean zPerformAccessibilityAction = accessibilityDelegate != null ? accessibilityDelegate.performAccessibilityAction(view, i, bundle) : super.performAccessibilityAction(view, i, bundle);
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        ga = hashCode();
        vn = String.valueOf(this.e);
        view.setAccessibilityDelegate(this.e);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.e;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean e() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
