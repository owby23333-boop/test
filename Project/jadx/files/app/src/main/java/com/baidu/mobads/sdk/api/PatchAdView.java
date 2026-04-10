package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class PatchAdView extends RelativeLayout {
    private static final String AD_CLICKED = "onAdClicked";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playFailure";
    private static final String PLAY_START = "onAdShow";
    private static final String TAG = "PacthAdView";
    private View mAdView;
    private IPatchAdListener mListener;
    private ClassLoader mLoader;
    private final String mRemoteClassName;
    private Context mViewContext;

    class InvocationHandlerImp implements InvocationHandler {
        InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(PatchAdView.PLAY_END)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playCompletion();
                }
            } else if (name.equals(PatchAdView.PLAY_ERROR)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playError();
                }
            } else if (name.equals(PatchAdView.PLAY_START)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.onAdShow();
                }
            } else if (name.equals(PatchAdView.AD_CLICKED) && PatchAdView.this.mListener != null) {
                PatchAdView.this.mListener.onAdClicked();
            }
            return null;
        }
    }

    public PatchAdView(Context context) {
        super(context);
        this.mRemoteClassName = w.f13184i;
        init(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {this.mViewContext};
        this.mLoader = bp.a(context);
        this.mAdView = (View) ar.a(this.mRemoteClassName, this.mLoader, (Class<?>[]) new Class[]{Context.class}, objArr);
        View view = this.mAdView;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object objA = ar.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
        if (objA instanceof Number) {
            return ((Long) objA).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object objA = ar.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0]);
        if (objA instanceof Number) {
            return ((Long) objA).longValue();
        }
        return 0L;
    }

    public void setAdData(XAdVideoResponse xAdVideoResponse) {
        View view;
        if (xAdVideoResponse == null || (view = this.mAdView) == null) {
            return;
        }
        ar.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        this.mListener = iPatchAdListener;
        try {
            Class<?> clsA = ar.a("com.component.patchad.IPatchAdListener", this.mLoader);
            if (clsA != null) {
                Object objNewProxyInstance = Proxy.newProxyInstance(clsA.getClassLoader(), new Class[]{clsA}, new InvocationHandlerImp());
                if (this.mAdView != null) {
                    ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setPatchAdListener", new Class[]{clsA}, objNewProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoVolume(boolean z2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }
}
