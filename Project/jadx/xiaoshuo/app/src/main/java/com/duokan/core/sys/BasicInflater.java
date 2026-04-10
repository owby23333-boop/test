package com.duokan.core.sys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public class BasicInflater extends LayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2837a = {"android.widget.", "android.miui.webkit.", "android.app."};

    public BasicInflater(Context context) {
        super(context);
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new BasicInflater(this, context);
    }

    @Override // android.view.LayoutInflater
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View viewCreateView;
        for (String str2 : f2837a) {
            try {
                viewCreateView = createView(str, str2, attributeSet);
            } catch (ClassNotFoundException unused) {
            }
            if (viewCreateView != null) {
                return viewCreateView;
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    public BasicInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }
}
