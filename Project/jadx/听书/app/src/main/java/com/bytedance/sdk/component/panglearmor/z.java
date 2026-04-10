package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z extends View.AccessibilityDelegate {
    public static Field g;
    public View e;
    public View.AccessibilityDelegate m;
    public static z z = new z(null, null);
    public static int dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f787a = "";
    public static Set<Integer> gc = new HashSet();

    static {
        g = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                g = declaredField;
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    public z(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.m = accessibilityDelegate;
        this.e = view;
        SoftDecTool.h = true;
    }

    public static void z(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        Field field;
        if (gc.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                field = g;
            } catch (Throwable th) {
                wp.z(th);
            }
            if (field != null) {
                accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
            } else {
                z2 = false;
                accessibilityDelegate = null;
            }
        }
        if (!(accessibilityDelegate instanceof z) && z2) {
            view.setAccessibilityDelegate(new z(accessibilityDelegate, view));
            gc.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        dl = hashCode();
        f787a = String.valueOf(this.m);
        SoftDecTool.f778a = true;
        view.setAccessibilityDelegate(this.m);
        View.AccessibilityDelegate accessibilityDelegate = this.m;
        if (accessibilityDelegate != null) {
            zPerformAccessibilityAction = accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        } else {
            zPerformAccessibilityAction = super.performAccessibilityAction(view, i, bundle);
        }
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent;
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        view.setAccessibilityDelegate(this.m);
        View.AccessibilityDelegate accessibilityDelegate = this.m;
        if (accessibilityDelegate != null) {
            zDispatchPopulateAccessibilityEvent = accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        dl = hashCode();
        f787a = String.valueOf(this.m);
        if (z()) {
            return;
        }
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        dl = hashCode();
        f787a = String.valueOf(this.m);
        view.setAccessibilityDelegate(this.m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            } else {
                super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean zOnRequestSendAccessibilityEvent;
        dl = hashCode();
        f787a = String.valueOf(this.m);
        viewGroup.setAccessibilityDelegate(this.m);
        View.AccessibilityDelegate accessibilityDelegate = this.m;
        if (accessibilityDelegate != null) {
            zOnRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            zOnRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    public boolean z() {
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
