package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.module.a.a;
import com.anythink.expressad.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnythinkBaseView extends RelativeLayout {
    public static final String TAG = "AnythinkBaseView";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f11784n = -999;
    protected Context a;
    protected c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected LayoutInflater f11785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f11786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected a f11787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f11788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float f11789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected float f11790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f11791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f11792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f11793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f11794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f11795m;

    public AnythinkBaseView(Context context) {
        this(context, null);
    }

    protected final JSONObject a(int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.cc, t.a(n.a().g(), this.f11789g));
                jSONObject.put(com.anythink.expressad.foundation.g.a.cd, t.a(n.a().g(), this.f11790h));
                jSONObject.put(com.anythink.expressad.foundation.g.a.cf, i2);
                try {
                    this.f11786d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                jSONObject.put(com.anythink.expressad.foundation.g.a.cg, this.f11786d);
                jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(getContext()));
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    protected void c() {
    }

    protected final String d() {
        return a(0).toString();
    }

    public void defaultShow() {
        o.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z2, String str) {
        return z2 ? findDyID(str) : findID(str);
    }

    public int findColor(String str) {
        return i.a(this.a.getApplicationContext(), str, i.f10646d);
    }

    public int findDrawable(String str) {
        return i.a(this.a.getApplicationContext(), str, i.f10645c);
    }

    public int findDyID(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public int findID(String str) {
        return i.a(this.a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return i.a(this.a.getApplicationContext(), str, "layout");
    }

    public c getCampaign() {
        return this.b;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            if (viewArr[i2] == null) {
                return false;
            }
            i2++;
            z2 = true;
        }
        return z2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.f11786d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        String str = "onConfigurationChanged:" + configuration.orientation;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f11789g = motionEvent.getRawX();
        this.f11790h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f11786d = configuration.orientation;
        String str = "onSelfConfigurationChanged:" + configuration.orientation;
    }

    public void setCampaign(c cVar) {
        this.b = cVar;
    }

    public void setLayoutCenter(int i2, int i3) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i2 != -999) {
                parentRelativeLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentRelativeLayoutParams.height = i3;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i2 != -999) {
                parentLinearLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentLinearLayoutParams.height = i3;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setLayoutParam(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i3;
            parentRelativeLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentRelativeLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentRelativeLayoutParams.height = i5;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i3;
            parentLinearLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentLinearLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentLinearLayoutParams.height = i5;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setNotifyListener(a aVar) {
        this.f11787e = aVar;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }

    public AnythinkBaseView(Context context, AttributeSet attributeSet, boolean z2, int i2, boolean z3, int i3, int i4) {
        super(context, attributeSet);
        this.f11786d = 1;
        this.f11787e = new f();
        this.f11788f = false;
        this.f11794l = 1;
        this.f11795m = 0;
        this.a = context;
        this.f11785c = LayoutInflater.from(context);
        this.f11791i = z2;
        this.f11792j = i2;
        this.f11793k = z3;
        this.f11794l = i3;
        this.f11795m = i4;
        init(context);
    }

    public AnythinkBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11786d = 1;
        this.f11787e = new f();
        this.f11788f = false;
        this.f11794l = 1;
        this.f11795m = 0;
        this.a = context;
        this.f11785c = LayoutInflater.from(context);
        init(context);
    }
}
