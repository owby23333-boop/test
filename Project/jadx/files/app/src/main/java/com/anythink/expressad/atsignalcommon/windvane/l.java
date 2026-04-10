package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f8328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Object f8329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected WindVaneWebView f8330g;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f8328e = context;
        this.f8330g = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f8329f = obj;
        this.f8330g = windVaneWebView;
    }
}
