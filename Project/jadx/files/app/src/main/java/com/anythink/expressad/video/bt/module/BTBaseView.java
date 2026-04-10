package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.videocommon.e.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static int f11546n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static int f11547o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f11548p = -999;
    protected Context a;
    protected c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f11549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f11550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected d f11551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected LayoutInflater f11552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f11553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f11554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected float f11555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f11556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Rect f11557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f11558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f11559m;

    public BTBaseView(Context context) {
        this(context, null);
    }

    private String b() {
        return a(0).toString();
    }

    protected final JSONObject a(int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.cc, t.a(com.anythink.expressad.foundation.b.a.b().d(), this.f11555i));
                jSONObject.put(a.cd, t.a(com.anythink.expressad.foundation.b.a.b().d(), this.f11556j));
                jSONObject.put(a.cf, i2);
                try {
                    this.f11553g = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                jSONObject.put(a.cg, this.f11553g);
                jSONObject.put(a.ch, t.c(getContext()));
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

    protected void a() {
    }

    public void defaultShow() {
        o.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return i.a(this.a.getApplicationContext(), str, i.f10646d);
    }

    public int findDrawable(String str) {
        return i.a(this.a.getApplicationContext(), str, i.f10645c);
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

    public String getInstanceId() {
        return this.f11550d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
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

    public Rect getRect() {
        return this.f11557k;
    }

    public String getUnitId() {
        return this.f11549c;
    }

    public int getViewHeight() {
        return this.f11559m;
    }

    public int getViewWidth() {
        return this.f11558l;
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
        this.f11553g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f11555i = motionEvent.getRawX();
        this.f11556j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f11553g = configuration.orientation;
    }

    public void setCampaign(c cVar) {
        this.b = cVar;
    }

    public void setInstanceId(String str) {
        this.f11550d = str;
    }

    public void setLayout(int i2, int i3) {
        this.f11558l = i2;
        this.f11559m = i3;
    }

    public void setLayoutCenter(int i2, int i3) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
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
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i2 != -999) {
                parentFrameLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentFrameLayoutParams.height = i3;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
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
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i3;
            parentFrameLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentFrameLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentFrameLayoutParams.height = i5;
            }
            setLayoutParams(parentFrameLayoutParams);
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

    public void setRect(Rect rect) {
        this.f11557k = rect;
    }

    public void setRewardUnitSetting(d dVar) {
        this.f11551e = dVar;
    }

    public void setUnitId(String str) {
        this.f11549c = str;
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

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11550d = "";
        this.f11553g = 1;
        this.f11554h = false;
        this.a = context;
        this.f11552f = LayoutInflater.from(context);
        init(context);
    }

    protected static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11546n);
            jSONObject.put("id", str2);
            jSONObject.put("data", new JSONObject());
            j.a();
            j.a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(webView, e2.getMessage());
            o.a(TAG, e2.getMessage());
        }
    }
}
