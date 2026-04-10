package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyView extends View implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f910a;
    private z dl;
    private List<View> e;
    private final Handler fo;
    private volatile boolean g;
    private List<View> gc;
    private int gz;
    private String i;
    private int kb;
    private final AtomicBoolean ls;
    private List<View> m;
    private int p;
    private boolean pf;
    private final AtomicBoolean uy;
    private boolean v;
    private na wp;
    private volatile boolean z;

    public interface z {
        void g();

        void z();

        void z(View view, Map<String, Object> map);

        void z(boolean z);
    }

    static /* synthetic */ int dl(EmptyView emptyView) {
        int i = emptyView.p;
        emptyView.p = i + 1;
        return i;
    }

    public EmptyView(Context context, View view) {
        super(zw.getContext());
        this.g = true;
        this.uy = new AtomicBoolean(true);
        this.kb = 1000;
        this.v = false;
        this.pf = false;
        this.ls = new AtomicBoolean(false);
        this.p = 0;
        this.f910a = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.fo = new com.bytedance.sdk.component.utils.l(com.bytedance.sdk.openadsdk.hh.e.g(), this);
        this.v = zw.g().ts();
        this.pf = zw.g().fn();
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.kb = i;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        z zVar = this.dl;
        if (zVar != null) {
            zVar.z(z2);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ls.set(false);
        a();
        if (this.v) {
            z("checkWhenAddToWindow");
        }
        g();
    }

    private void g() {
        z zVar;
        if (!this.uy.getAndSet(false) || (zVar = this.dl) == null) {
            return;
        }
        zVar.z();
    }

    private void dl() {
        z zVar;
        if (this.uy.getAndSet(true) || (zVar = this.dl) == null) {
            return;
        }
        zVar.g();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ls.set(false);
        gc();
        dl();
    }

    public void setRefClickViews(List<View> list) {
        this.gc = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.m = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.e = list;
    }

    public void z() {
        z(this.gc, (com.bytedance.sdk.openadsdk.core.g.a) null);
        z(this.m, (com.bytedance.sdk.openadsdk.core.g.a) null);
        z(this.e, (com.bytedance.sdk.openadsdk.core.g.a) null);
    }

    public void z(List<View> list, com.bytedance.sdk.openadsdk.core.g.a aVar) {
        if (com.bytedance.sdk.component.utils.uy.g(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(aVar);
                    view.setOnTouchListener(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.fo.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.g || EmptyView.this.z) {
                    return;
                }
                EmptyView.this.z = true;
                EmptyView.dl(EmptyView.this);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                EmptyView.this.fo.handleMessage(messageObtain);
            }
        });
    }

    public void z(final String str) {
        this.fo.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.g) {
                        EmptyView.this.z(8, (String) null);
                    }
                    if (!EmptyView.this.z) {
                        EmptyView.this.z(EmptyView.this.ls.get() ? 10 : 9, (String) null);
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.fo.handleMessage(messageObtain);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        this.fo.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.z = false;
                EmptyView.this.fo.removeMessages(1);
            }
        });
    }

    public void setNeedCheckingShow(final boolean z2) {
        this.ls.set(false);
        this.fo.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.g = z2;
                if (!z2 && EmptyView.this.z) {
                    EmptyView.this.gc();
                } else {
                    if (!z2 || EmptyView.this.z) {
                        return;
                    }
                    EmptyView.this.a();
                }
            }
        });
    }

    public void setCallback(z zVar) {
        this.dl = new g(zVar);
    }

    public void setAdType(int i) {
        this.gz = i;
    }

    public void z(na naVar, String str) {
        this.wp = naVar;
        this.i = str;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int iZ;
        boolean z2 = false;
        boolean z3 = this.v || this.pf;
        if ((message.obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", message.obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z2 = true;
        }
        if (message.what != 1) {
            return;
        }
        if (this.z || (z3 && z2)) {
            String message2 = null;
            if (!z3) {
                if (ti.g(this.f910a, 20, this.gz)) {
                    gc();
                    z zVar = this.dl;
                    if (zVar != null) {
                        zVar.z(this.f910a, null);
                        return;
                    }
                    return;
                }
                this.fo.sendEmptyMessageDelayed(1, this.kb);
                return;
            }
            try {
                iZ = ti.z(this.f910a, 20, this.gz);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
                message2 = th.getMessage();
                iZ = 7;
            }
            if (iZ == 0) {
                gc();
                if (this.dl != null && !this.ls.get()) {
                    this.ls.set(true);
                    this.dl.z(this.f910a, z(z2, message));
                }
            } else if (!z2) {
                this.fo.sendEmptyMessageDelayed(1, this.kb);
            }
            if ((message.obj instanceof String) && TextUtils.equals("checkWhenClicked", message.obj.toString())) {
                z(iZ, message2);
            }
        }
    }

    private Map<String, Object> z(boolean z2, Message message) {
        if (!z2) {
            return null;
        }
        HashMap map = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            map.put("show_send_type", 2);
        } else if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            map.put("show_send_type", 1);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put("is_success", Boolean.TRUE);
        } else {
            map.put("is_success", Boolean.FALSE);
            if (i != 7) {
                str = ti.z(i);
            }
            map.put("error_code", Integer.valueOf(i));
            map.put("error_message", str);
        }
        map.put("checking_cnt", Integer.valueOf(this.p));
        com.bytedance.sdk.openadsdk.core.i.a.z(this.wp, this.i, map);
    }

    public static final class g implements z {
        private final z z;

        public g(z zVar) {
            this.z = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
        public void z(final boolean z) {
            if (this.z != null) {
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z.z(z);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
        public void z() {
            if (this.z != null) {
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z.z();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
        public void g() {
            if (this.z != null) {
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z.g();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
        public void z(final View view, final Map<String, Object> map) {
            if (this.z != null) {
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z.z(view, map);
                    }
                });
            }
        }
    }
}
