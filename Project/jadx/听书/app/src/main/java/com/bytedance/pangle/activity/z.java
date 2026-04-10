package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f507a;
    private final int dl;
    private final String g;
    private final Activity z;

    public z(Activity activity, int i, String str) {
        this.z = activity;
        this.g = str;
        this.dl = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f507a == null) {
            z(this.z, this.g);
        }
        try {
            this.f507a.invoke(this.z, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void z(Activity activity, String str) {
        try {
            Method method = activity.getClass().getMethod(this.g, View.class);
            if (method != null) {
                this.f507a = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.g + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.dl);
    }
}
