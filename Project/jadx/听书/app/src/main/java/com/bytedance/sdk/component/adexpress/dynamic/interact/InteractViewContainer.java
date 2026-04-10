package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.google.common.base.Ascii;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
public class InteractViewContainer extends FrameLayout implements gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f562a;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.e dl;
    private RippleView e;
    private int fo;
    private DynamicBaseWidget g;
    private e gc;
    private View.OnTouchListener gz;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.uy kb;
    private String m;
    private boolean uy;
    private com.bytedance.sdk.component.adexpress.g.i wp;
    private Context z;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        super(context);
        this.z = context;
        this.g = dynamicBaseWidget;
        this.dl = eVar;
        e();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, com.bytedance.sdk.component.adexpress.g.i iVar) {
        super(context);
        this.z = context;
        this.g = dynamicBaseWidget;
        this.dl = eVar;
        this.kb = uyVar;
        this.wp = iVar;
        e();
    }

    private void e() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.m = this.dl.xl();
        this.fo = this.dl.t();
        this.uy = this.dl.f();
        e eVarZ = fo.z(this.z, this.g, this.dl, this.kb, this.wp);
        this.gc = eVarZ;
        if (eVarZ != null) {
            this.f562a = eVarZ.dl();
            if (this.dl.j()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.m, "6")) {
                if (this.dl.yx() && !TextUtils.isEmpty(this.dl.qd())) {
                    this.e = new RippleView(this.z, com.bytedance.sdk.component.adexpress.dynamic.dl.e.z(this.dl.qd()));
                } else {
                    this.e = new RippleView(this.z, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.z);
                frameLayout.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.e.g();
                    }
                });
            }
            if (z(this.m) && com.bytedance.sdk.component.adexpress.a.z()) {
                int color = Color.parseColor("#99000000");
                if (this.dl.yx() && !TextUtils.isEmpty(this.dl.qd())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.dl.e.z(this.dl.qd());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.z);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.gc.dl());
            z(this.gc.dl());
            setVisibility(0);
        }
    }

    private boolean z(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gz instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.z.dl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void z(ViewGroup viewGroup) {
        if (this.f562a == null) {
            return;
        }
        String str = this.m;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 6;
                }
                break;
            case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b = 11;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    b = 12;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = 13;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b = 14;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b = 15;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b = 16;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.gc(this, this.fo);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.dl.yx() || TextUtils.isEmpty(this.dl.qd())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.m(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.g(this, this);
                break;
            case 3:
                if (this.dl.yx() && !TextUtils.isEmpty(this.dl.qd())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.dl.e.z(this.dl.qd()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.dl(this);
                this.f562a.setTag(2);
                break;
            case 6:
            case 9:
                this.g.setClipChildren(false);
                this.g.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.g.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.m(this);
                break;
            case 7:
            case 14:
                this.f562a.setTag(2);
                break;
            case 8:
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.a(this, this.fo, this.uy);
                break;
            case 10:
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.dl(this);
                this.f562a.setTag(2);
                break;
            case 11:
            case 19:
                if (this.m.equals("24") && com.bytedance.sdk.component.adexpress.a.z()) {
                    this.g.setClipChildren(false);
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.m(this);
                } else {
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.gc(this, this.fo);
                }
                break;
            case 12:
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.g(this, this);
                break;
            case 13:
                View view = this.f562a;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.f562a).getShakeLayout().setTag(2);
                }
                this.f562a.setTag(2);
                break;
            case 15:
                View view2 = this.f562a;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.f562a).getWriggleLayout().setTag(2);
                }
                this.f562a.setTag(2);
                break;
            case 16:
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.z(this, this.fo, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.gz(this, this.uy);
                } else {
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.e(this, this.fo, viewGroup);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.m(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.gz(this, this.uy);
                }
                break;
            case 21:
                View view3 = this.f562a;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.f562a).getShakeView().setTag(2);
                }
                this.gz = new com.bytedance.sdk.component.adexpress.dynamic.interact.z.gc(this, this.fo);
                break;
        }
        View.OnTouchListener onTouchListener = this.gz;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (gz()) {
            this.f562a.setTag(2);
            setOnClickListener((View.OnClickListener) this.g.getDynamicClickListener());
        }
    }

    private boolean gz() {
        return (this.dl.f() || TextUtils.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, this.m) || TextUtils.equals("16", this.m) || TextUtils.equals("17", this.m) || TextUtils.equals("18", this.m) || TextUtils.equals("20", this.m) || TextUtils.equals("29", this.m) || TextUtils.equals("10", this.m)) ? false : true;
    }

    public void dl() {
        e eVar = this.gc;
        if (eVar != null) {
            eVar.z();
        }
    }

    public void a() {
        e eVar = this.gc;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            e eVar = this.gc;
            if (eVar != null) {
                eVar.g();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl(e.getMessage());
        }
    }

    public void gc() {
        if (this.f562a != null && TextUtils.equals(this.m, "2")) {
            View view = this.f562a;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).dl();
            }
        }
    }

    public void m() {
        if (this.f562a != null && TextUtils.equals(this.m, "2")) {
            View view = this.f562a;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).a();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gz
    public void z() {
        if (TextUtils.equals(this.m, "6")) {
            RippleView rippleView = this.e;
            if (rippleView != null) {
                rippleView.dl();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.fo();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.m, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.fo();
                }
            }, 400L);
        } else {
            fo();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gz
    public void g() {
        if (gz()) {
            setOnClickListener((View.OnClickListener) this.g.getDynamicClickListener());
            performClick();
            if (this.dl.tf()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        if (this.gz != null) {
            setOnClickListener((View.OnClickListener) this.g.getDynamicClickListener());
            performClick();
            if (this.dl.tf()) {
                return;
            }
            setVisibility(8);
        }
    }
}
