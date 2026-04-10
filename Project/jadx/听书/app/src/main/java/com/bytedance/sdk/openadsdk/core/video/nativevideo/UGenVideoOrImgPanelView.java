package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fv;
import com.bytedance.sdk.openadsdk.core.ugeno.express.g;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UGenVideoOrImgPanelView extends NativeExpressView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1404a;
    private final NativeVideoTsView dl;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.a g;
    private final CopyOnWriteArrayList<Message> gc;
    private volatile boolean hh;
    private ViewGroup io;
    private final z iq;
    private boolean l;
    private final AtomicBoolean sy;
    private final Context uf;
    private final na z;
    private View zw;

    public UGenVideoOrImgPanelView(Context context, na naVar, NativeVideoTsView nativeVideoTsView, View view, ViewGroup viewGroup, String str, boolean z2) {
        super(context, naVar, new com.bytedance.sdk.openadsdk.ls.dl.dl.g(new SparseArray()), str);
        this.gc = new CopyOnWriteArrayList<>();
        z zVar = new z(Looper.getMainLooper());
        this.iq = zVar;
        this.sy = new AtomicBoolean(true);
        this.hh = false;
        this.l = false;
        this.uf = context;
        this.z = naVar;
        this.dl = nativeVideoTsView;
        this.f1404a = view;
        this.io = viewGroup;
        zVar.z(this);
        this.l = z2;
        v();
    }

    public void v() {
        na naVar;
        JSONObject jSONObjectMn;
        JSONArray jSONArrayOptJSONArray;
        if (this.sy.getAndSet(false) && (naVar = this.z) != null) {
            if ((this.dl == null && this.f1404a == null) || (jSONObjectMn = naVar.mn()) == null || (jSONArrayOptJSONArray = jSONObjectMn.optJSONArray("components")) == null) {
                return;
            }
            this.tb = zw.g().a(eo.fo(this.z));
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                final int iOptInt = jSONObjectOptJSONObject.optInt("render_sequence");
                final int iOptInt2 = jSONObjectOptJSONObject.optInt("displayAreaAndroid");
                String strOptString = jSONObjectOptJSONObject.optString("ugen_md5");
                String strOptString2 = jSONObjectOptJSONObject.optString("ugen_url");
                final String strOptString3 = jSONObjectOptJSONObject.optString("ugen_id");
                uy.z(strOptString2, strOptString, new com.bytedance.sdk.openadsdk.core.ugeno.dl() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.1
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
                    public void z() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
                    public void z(String str) {
                        try {
                            UGenVideoOrImgPanelView.this.z(new JSONObject(str), iOptInt2, strOptString3, iOptInt);
                        } catch (Throwable th) {
                            wp.z(th);
                        }
                    }
                });
            }
        }
    }

    public static boolean z(na naVar) {
        JSONObject jSONObjectMn;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        return (naVar == null || (jSONObjectMn = naVar.mn()) == null || (jSONArrayOptJSONArray = jSONObjectMn.optJSONArray("components")) == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString("ugen_url"))) ? false : true;
    }

    public void setAdSlot(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.gz = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final JSONObject jSONObject, final int i, final String str, final int i2) {
        if (jSONObject == null) {
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.dl;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.2
                @Override // java.lang.Runnable
                public void run() {
                    UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                    uGenVideoOrImgPanelView.z(uGenVideoOrImgPanelView.dl, jSONObject, i, str, i2);
                }
            });
            return;
        }
        View view = this.f1404a;
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView.z(uGenVideoOrImgPanelView.io, jSONObject, i, str, i2);
                    } else {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView2.z(uGenVideoOrImgPanelView2.f1404a, jSONObject, i, str, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view, JSONObject jSONObject, int i, String str, int i2) {
        if (i2 == 3) {
            jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.z, com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(view), jSONObject, this.l, null);
        }
        JSONObject jSONObjectZ = uy.z(this.z, view, this.l);
        if (jSONObjectZ != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObjectZ.put("ugen_id", str);
            } catch (JSONException unused) {
            }
        }
        g.z zVar = new g.z();
        zVar.gc(jSONObjectZ);
        zVar.z(jSONObject);
        zVar.z((iq) new fv());
        zVar.g(view.getHeight());
        zVar.z(view.getWidth());
        zVar.z(com.bytedance.sdk.openadsdk.core.uy.ls().gc());
        zVar.uy(this.z.gc());
        com.bytedance.sdk.openadsdk.core.ugeno.express.g gVarZ = zVar.z();
        if (i2 == 3) {
            this.g = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(this.uf, this.z, gVarZ, this.io);
        } else {
            this.g = new com.bytedance.sdk.openadsdk.core.ugeno.express.a(this.uf, this.z, gVarZ, this.io);
        }
        this.g.z(this);
        dl(i, str);
    }

    private void dl(final int i, final String str) {
        this.g.z(new com.bytedance.sdk.component.adexpress.g.e() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.4
            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(View view, v vVar) {
                View childAt;
                if ((UGenVideoOrImgPanelView.this.dl == null && UGenVideoOrImgPanelView.this.f1404a == null) || view == null) {
                    return;
                }
                UGenVideoOrImgPanelView.this.zw = view;
                boolean z2 = UGenVideoOrImgPanelView.this.z(view, i);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() > 0 && (childAt = viewGroup.getChildAt(0)) != null && childAt.getVisibility() == 8) {
                        HashMap map = new HashMap();
                        map.put("error_code", 105);
                        map.put("render_type", 1);
                        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(UGenVideoOrImgPanelView.this.z, false, str, 3, (Map<String, Object>) map);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(UGenVideoOrImgPanelView.this.z, z2, str, 3, (Map<String, Object>) null);
            }

            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(int i2, String str2) {
                HashMap map = new HashMap();
                map.put("error_code", Integer.valueOf(i2));
                map.put("error_msg", str2);
                map.put("render_type", 1);
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(UGenVideoOrImgPanelView.this.z, false, str, 3, (Map<String, Object>) map);
            }
        });
    }

    static class z extends Handler {
        UGenVideoOrImgPanelView z;

        private z(Looper looper) {
            super(looper);
        }

        public void z(UGenVideoOrImgPanelView uGenVideoOrImgPanelView) {
            this.z = uGenVideoOrImgPanelView;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r3) {
            /*
                r2 = this;
                super.handleMessage(r3)
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r0 = r2.z
                if (r0 != 0) goto L8
                return
            L8:
                boolean r0 = com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.gc(r0)
                if (r0 == 0) goto Lf
                return
            Lf:
                if (r3 != 0) goto L12
                return
            L12:
                java.lang.Object r0 = r3.obj
                boolean r1 = r0 instanceof java.lang.ref.WeakReference
                if (r1 == 0) goto L25
                java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                java.lang.Object r0 = r0.get()
                boolean r1 = r0 instanceof android.view.View
                if (r1 == 0) goto L25
                android.view.View r0 = (android.view.View) r0
                goto L26
            L25:
                r0 = 0
            L26:
                if (r0 != 0) goto L29
                return
            L29:
                int r3 = r3.what
                if (r3 == 0) goto L37
                r1 = 2
                if (r3 == r1) goto L31
                goto L36
            L31:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.z
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.dl(r3, r0)
            L36:
                return
            L37:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.z
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.g(r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.z.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(View view, int i) {
        boolean zDl = false;
        if (this.hh) {
            return false;
        }
        if (i != 0) {
            if (i == 2) {
                if (this.io != null) {
                    zDl = g(view);
                } else {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.obj = new WeakReference(view);
                    this.gc.add(messageObtain);
                    zDl = true;
                }
            } else if (this.dl != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                view.setVisibility(0);
                this.dl.addView(view);
                zDl = true;
            } else if (this.f1404a != null) {
                zDl = z(view);
            }
        } else if (this.io != null) {
            zDl = dl(view);
        } else {
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 0;
            messageObtain2.obj = new WeakReference(view);
            this.gc.add(messageObtain2);
            zDl = true;
        }
        if (this.f1404a == null) {
            view.bringToFront();
            z(this.tb);
        }
        return zDl;
    }

    private boolean z(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.io;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        this.f1404a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.5
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                UGenVideoOrImgPanelView.this.f1404a.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                UGenVideoOrImgPanelView.this.io.getLocationInWindow(iArr2);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (UGenVideoOrImgPanelView.this.io instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UGenVideoOrImgPanelView.this.f1404a.getWidth(), UGenVideoOrImgPanelView.this.f1404a.getHeight());
                    layoutParams.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.io.addView(view, layoutParams);
                }
                if (UGenVideoOrImgPanelView.this.io instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UGenVideoOrImgPanelView.this.f1404a.getWidth(), UGenVideoOrImgPanelView.this.f1404a.getHeight());
                    layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.io.addView(view, layoutParams2);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(final View view) {
        ViewGroup viewGroup = this.io;
        if (viewGroup == null || view == null || this.dl == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.6
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.io.getWidth(), UGenVideoOrImgPanelView.this.io.getHeight()));
                view.setVisibility(0);
                UGenVideoOrImgPanelView.this.dl.removeView(view);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.dl.addView(view);
                UGenVideoOrImgPanelView.this.io.getGlobalVisibleRect(new Rect());
                UGenVideoOrImgPanelView.this.dl.getGlobalVisibleRect(new Rect());
                view.setTranslationY(r2.top - r3.top);
                for (ViewParent parent2 = UGenVideoOrImgPanelView.this.dl.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).setClipChildren(false);
                        if (parent2.hashCode() == UGenVideoOrImgPanelView.this.io.hashCode()) {
                            return;
                        }
                    }
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.io;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.7
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.io.getWidth(), UGenVideoOrImgPanelView.this.io.getHeight()));
                view.setVisibility(0);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.io.removeView(view);
                UGenVideoOrImgPanelView.this.io.addView(view);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
        super.z(view, i, dlVar);
        View view2 = this.dl;
        if (view2 == null) {
            view2 = this.f1404a;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(this.z, com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(view2, dlVar), com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(dlVar), 3, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
        super.z(view, i, dlVar, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z2) {
        if (this.dl == null) {
            return;
        }
        this.tb = z2;
        this.dl.g(z2, true);
        com.bykv.vk.openvk.component.video.api.a.dl nativeVideoController = this.dl.getNativeVideoController();
        if (nativeVideoController != null) {
            nativeVideoController.g(z2);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.a aVar = this.g;
        if (aVar == null) {
            return;
        }
        aVar.setSoundMute(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void i() {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.8
            @Override // java.lang.Runnable
            public void run() {
                UGenVideoOrImgPanelView.this.hh = true;
                if (UGenVideoOrImgPanelView.this.zw != null) {
                    ViewParent parent = UGenVideoOrImgPanelView.this.zw.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.zw);
                    }
                }
                UGenVideoOrImgPanelView.super.i();
                if (UGenVideoOrImgPanelView.this.g != null) {
                    UGenVideoOrImgPanelView.this.g.kb();
                }
            }
        });
    }
}
