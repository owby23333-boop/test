package com.bytedance.sdk.openadsdk.core.zw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.kb.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.q;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.gc;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import com.bytedance.sdk.openadsdk.ls.dl.g.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f1433a;
    private final Context dl;
    private int e;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g fo;
    private final na g;
    private e gc;
    private int gz;
    private UGenVideoOrImgPanelView hh;
    private final boolean io;
    private com.bytedance.sdk.openadsdk.io.z.g.z.dl js;
    private volatile ViewGroup kb;
    private float ls;
    private gc m;
    private float pf;
    private TextView q;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a sy;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z tb;
    private v uy;
    private View wp;
    private final iq z;
    private boolean i = false;
    private boolean v = true;
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean fv = new AtomicBoolean(false);
    private boolean iq = false;
    private boolean zw = false;
    private volatile WeakReference<NativeVideoTsView> uf = null;
    private final com.bytedance.sdk.openadsdk.core.video.nativevideo.z l = new com.bytedance.sdk.openadsdk.core.video.nativevideo.z() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.1
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.z
        public void z() {
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.1.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.h();
                    a.this.x();
                }
            }, zw.g().gm());
        }
    };
    private volatile boolean h = false;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z gk = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String z(int i) {
        return i != 1 ? i != 2 ? i != 5 ? i != 6 ? i != 9 ? "embeded_ad" : "draw_ad" : "stream" : "embeded_ad" : "interaction" : "banner_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public View q() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
    }

    public a(Context context, final na naVar, int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z) {
        ls.z(naVar, "materialMeta不能为null");
        this.io = z;
        this.g = naVar;
        if (context == null) {
            this.dl = zw.getContext();
        } else {
            this.dl = context;
        }
        this.e = i;
        this.fo = gVar;
        iq iqVar = new iq(this.dl, this, naVar, z(i));
        this.z = iqVar;
        iqVar.z(i);
        this.uy = z(naVar);
        this.sy = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a(naVar, true, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int dl() {
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void dl(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void g(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void gc() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void m() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void setPauseFromExpressView(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(float f) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i2, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long z() {
                NativeVideoTsView nativeVideoTsView;
                com.bykv.vk.openvk.component.video.api.a.dl nativeVideoController;
                if (a.this.uf == null || (nativeVideoTsView = (NativeVideoTsView) a.this.uf.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.kb()) / 1000;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int g() {
                NativeVideoTsView nativeVideoTsView;
                if (a.this.uf == null || (nativeVideoTsView = (NativeVideoTsView) a.this.uf.get()) == null) {
                    return 0;
                }
                com.bykv.vk.openvk.component.video.api.a.dl nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.tb()) {
                    return 5;
                }
                if (nativeVideoController.iq()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) && ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) nativeVideoController).t()) ? 2 : 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long getActualPlayDuration() {
                return z();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view) {
                if (a.this.tb != null) {
                    a.this.tb.z(view, a.this);
                }
                na naVar2 = naVar;
                uy.z(naVar2, true, sy.dl(naVar2), 2, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view, int i2, com.bytedance.sdk.component.adexpress.dl dlVar) {
                com.bytedance.sdk.openadsdk.core.iq.uy uyVar;
                if (dlVar instanceof com.bytedance.sdk.openadsdk.core.iq.zw) {
                    com.bytedance.sdk.openadsdk.core.iq.zw zwVar = (com.bytedance.sdk.openadsdk.core.iq.zw) dlVar;
                    uyVar = new com.bytedance.sdk.openadsdk.core.iq.uy();
                    uyVar.z(zwVar.z);
                    uyVar.g(zwVar.g);
                    uyVar.dl(zwVar.dl);
                    uyVar.a(zwVar.f1208a);
                    uyVar.z(zwVar.gc);
                    uyVar.g(zwVar.m);
                    uyVar.z(zwVar.pf);
                } else {
                    uyVar = null;
                }
                if (i2 == 3) {
                    a.this.ti();
                } else {
                    a.this.z.z(view, uyVar);
                }
                boolean z2 = uy.z(a.this.uf == null ? null : (NativeVideoTsView) a.this.uf.get(), dlVar);
                na naVar2 = naVar;
                uy.z(naVar2, z2, sy.dl(naVar2), 1, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void g(View view, int i2, com.bytedance.sdk.component.adexpress.dl dlVar) {
                com.bytedance.sdk.openadsdk.core.iq.uy uyVar;
                if ((i2 == 1 || i2 == 2) && (dlVar instanceof com.bytedance.sdk.openadsdk.core.iq.zw)) {
                    com.bytedance.sdk.openadsdk.core.iq.zw zwVar = (com.bytedance.sdk.openadsdk.core.iq.zw) dlVar;
                    uyVar = new com.bytedance.sdk.openadsdk.core.iq.uy();
                    uyVar.z(zwVar.z);
                    uyVar.g(zwVar.g);
                    uyVar.dl(zwVar.dl);
                    uyVar.a(zwVar.f1208a);
                    uyVar.z(zwVar.gc);
                    uyVar.g(zwVar.m);
                    uyVar.z(zwVar.pf);
                } else {
                    uyVar = null;
                }
                if (i2 == 2) {
                    a.this.z.z(view, uyVar);
                }
                if (i2 == 1) {
                    a.this.z.g(view, uyVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        ls.z(viewGroup != null || this.fv.get(), "container不能为null");
        ls.z(view != null || this.fv.get(), "clickView不能为null");
        this.kb = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        z(viewGroup, arrayList, null, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        boolean z = false;
        ls.z(viewGroup != null || this.fv.get(), "container不能为null");
        ls.z(list != null || this.fv.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        ls.z(z, "clickViews数量必须大于等于1");
        this.kb = viewGroup;
        z(viewGroup, list, list2, null, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        boolean z = false;
        ls.z(viewGroup != null || this.fv.get(), "container不能为null");
        ls.z(list != null || this.fv.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        ls.z(z, "clickViews数量必须大于等于1");
        this.kb = viewGroup;
        z(viewGroup, null, list, list2, view, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        boolean z = false;
        ls.z(viewGroup != null || this.fv.get(), "container不能为null");
        ls.z(list2 != null || this.fv.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        ls.z(z, "clickViews数量必须大于等于1");
        this.kb = viewGroup;
        z(viewGroup, list, list2, list3, (List<View>) null, view, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        int i;
        List<View> listZ = list3;
        boolean z = false;
        ls.z(viewGroup != null || this.fv.get(), "container不能为null");
        ls.z(list2 != null || this.fv.get(), "clickView不能为null");
        ls.z(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.kb = viewGroup;
        this.tb = zVar;
        if (listZ != null && list3.size() > 0) {
            z = true;
        }
        dl(z);
        if (lq()) {
            listZ = z(list2, list3);
        }
        List<View> list5 = listZ;
        if (this.fv.get() && ((i = this.e) == 5 || i == 1 || i == 9)) {
            un();
        }
        if (!this.fv.get()) {
            iq iqVar = this.z;
            if (iqVar != null) {
                iqVar.z(this.l);
                this.z.z(viewGroup, list, list2, list5, list4, view, zVar, this.gk);
            }
            z(viewGroup);
        }
        e eVar = this.gc;
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.z) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.z) eVar).z(this.kb);
        }
    }

    private View g(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            z(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView2 = arrayList.get(i);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    private void z(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    z((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> z(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public void z(WeakReference<NativeVideoTsView> weakReference) {
        this.uf = weakReference;
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.hh;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.i();
        }
        if (UGenVideoOrImgPanelView.z(this.g) || !zw.g().ux().f1108a) {
            if (na.g(this.g)) {
                z();
            } else {
                gk();
            }
            iq iqVar = this.z;
            if (iqVar != null) {
                iqVar.z((NativeExpressView) this.hh);
            }
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = this.hh;
            if (uGenVideoOrImgPanelView2 != null) {
                uGenVideoOrImgPanelView2.setAdSlot(this.fo);
            }
        }
    }

    private void gk() {
        View viewG;
        if (na.g(this.g) || (viewG = g(this.kb)) == null) {
            return;
        }
        this.hh = new UGenVideoOrImgPanelView(this.dl, this.g, null, viewG, this.kb, eo.g(this.e), true);
    }

    public void z() {
        NativeVideoTsView nativeVideoTsView;
        if (this.uf == null || (nativeVideoTsView = this.uf.get()) == null || nativeVideoTsView.ls()) {
            return;
        }
        this.hh = new UGenVideoOrImgPanelView(this.dl, this.g, nativeVideoTsView, null, this.kb, eo.g(this.e), true);
    }

    public void g() {
        if (this.uf == null || this.uf.get() == null) {
            return;
        }
        this.uf.get().setEasyPlayableEventSender(this.sy.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        NativeVideoTsView nativeVideoTsView;
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(this.sy.z());
        }
        if (na.g(this.g)) {
            if (this.uf == null || this.uf.get() == null) {
                nativeVideoTsView = null;
            } else {
                nativeVideoTsView = this.uf.get();
                nativeVideoTsView.setEasyPlayableEventSender(this.sy.z());
            }
            this.sy.z(this.kb, nativeVideoTsView);
            return;
        }
        this.sy.z(this.kb, g(this.kb));
    }

    void z(ViewGroup viewGroup) {
        if (viewGroup != null && this.io && com.bytedance.sdk.openadsdk.hh.uy.z(this.g)) {
            NativeVideoTsView nativeVideoTsViewDl = dl(viewGroup);
            if (nativeVideoTsViewDl != null) {
                if (5 == this.e) {
                    nativeVideoTsViewDl.setIsAutoPlay(this.i ? this.fo.gc() : this.v);
                    return;
                } else {
                    nativeVideoTsViewDl.setIsAutoPlay(this.v);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.dl, this.g, false, false, eo.g(this.e), false, false);
            if (5 == this.e) {
                nativeVideoTsView.setIsAutoPlay(this.i ? this.fo.gc() : this.v);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.v);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    private NativeVideoTsView dl(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        ls.z(dlVar, "downloadListener不能为null");
        this.z.z(z.C0184z.z(dlVar, this.g));
        v vVar = this.uy;
        if (vVar != null) {
            vVar.z(dlVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public wp gc() {
        na naVar = this.g;
        if (naVar == null) {
            return gk.z(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.iq.eo.gz(this.g))) {
                return gk.z(0, 0, "", 0.0d);
            }
            return gk.z(com.bytedance.sdk.openadsdk.core.iq.eo.i(this.g), com.bytedance.sdk.openadsdk.core.iq.eo.wp(this.g), com.bytedance.sdk.openadsdk.core.iq.eo.gz(this.g), 0.0d);
        }
        if (tf.v(this.g) != null) {
            return gk.z(tf.dl(this.g), tf.a(this.g), tf.g(this.g), 0.0d);
        }
        List<gk> listJz = this.g.jz();
        if (listJz != null && !listJz.isEmpty() && listJz.get(0) != null && listJz.get(0).gc() && com.bytedance.sdk.openadsdk.gc.z.gz(this.g)) {
            return gk.z(listJz.get(0).dl(), listJz.get(0).g(), listJz.get(0).z(), 0.0d);
        }
        return gk.z(0, 0, "", 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public Bitmap m() {
        na naVar = this.g;
        if (naVar == null) {
            return BitmapFactory.decodeResource(this.dl.getResources(), tb.gc(zw.getContext(), "tt_ad_logo_new"));
        }
        String strSa = naVar.sa();
        if (TextUtils.isEmpty(strSa)) {
            return BitmapFactory.decodeResource(this.dl.getResources(), tb.gc(zw.getContext(), "tt_ad_logo_new"));
        }
        if (this.q == null) {
            this.q = new TextView(zw.getContext());
            this.q.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        oq.z(this.q, strSa, zw.getContext());
        return oq.e(this.q);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String e() {
        na naVar = this.g;
        if (naVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.g))) {
            return com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.g);
        }
        if (zw.g().yt()) {
            if (!TextUtils.isEmpty(this.g.li())) {
                return this.g.li();
            }
            if (this.g.c() != null && !TextUtils.isEmpty(this.g.c().dl())) {
                return this.g.c().dl();
            }
            if (!TextUtils.isEmpty(i())) {
                return i();
            }
        } else {
            if (this.g.c() != null && !TextUtils.isEmpty(this.g.c().dl())) {
                return this.g.c().dl();
            }
            if (!TextUtils.isEmpty(i())) {
                return i();
            }
            if (!TextUtils.isEmpty(this.g.li())) {
                return this.g.li();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String gz() {
        na naVar = this.g;
        if (naVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.iq.eo.m(this.g))) {
            return com.bytedance.sdk.openadsdk.core.iq.eo.m(this.g);
        }
        if (zw.g().yt()) {
            if (!TextUtils.isEmpty(this.g.he())) {
                return this.g.he();
            }
            if (!TextUtils.isEmpty(this.g.li())) {
                return this.g.li();
            }
        } else {
            if (!TextUtils.isEmpty(this.g.li())) {
                return this.g.li();
            }
            if (!TextUtils.isEmpty(this.g.he())) {
                return this.g.he();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String fo() {
        return this.g.no();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int uy() {
        if (this.g.c() != null) {
            return this.g.c().gc();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int kb() {
        if (this.g.c() != null) {
            return this.g.c().m();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int wp() {
        if (this.g.c() != null) {
            return this.g.c().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String i() {
        return this.g.hy();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public wp v() {
        if (!com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
            return this.g.kp() == null ? gk.z(0, 0, "", 0.0d) : gk.z(this.g.kp());
        }
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.g))) {
            return gk.z(0, 0, "", 0.0d);
        }
        return gk.z(com.bytedance.sdk.openadsdk.core.iq.eo.kb(this.g), com.bytedance.sdk.openadsdk.core.iq.eo.uy(this.g), com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.g), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public List<wp> pf() {
        ArrayList arrayList = new ArrayList();
        if (this.g.jz() != null && !this.g.jz().isEmpty()) {
            Iterator<gk> it = this.g.jz().iterator();
            while (it.hasNext()) {
                wp wpVarZ = gk.z(it.next());
                if (wpVarZ != null) {
                    arrayList.add(wpVarZ);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int ls() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        return naVar.lt();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int p() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        List<gk> listJz = naVar.jz();
        if (listJz == null || listJz.isEmpty() || listJz.get(0) == null || !listJz.get(0).gc() || !com.bytedance.sdk.openadsdk.gc.z.gz(this.g)) {
            return this.g.ou();
        }
        return listJz.get(0).g() >= listJz.get(0).dl() ? 5 : 15;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.ls.dl.g.a fv() {
        na naVar = this.g;
        if (naVar == null || naVar.ct() == null) {
            return null;
        }
        this.g.ct().g(z(this.e));
        return new com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.g.ct());
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.iq.wp js() {
        na naVar = this.g;
        if (naVar == null || naVar.lt() != 4) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.iq.wp(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public e z(Activity activity) {
        if (this.uy != null && this.fv.get()) {
            return this.uy.z(activity);
        }
        if (this.gc == null) {
            dl(activity);
        }
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public e z(final Dialog dialog, Integer[] numArr) {
        if (dialog == null) {
            throw new IllegalArgumentException("dialog is null, please check");
        }
        com.bytedance.sdk.openadsdk.core.dislike.z.g.z(this.g.ct(), dialog, numArr);
        return new e() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.3
            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public boolean dl() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z(com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z() {
                if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                    dialog.show();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public gc tb() {
        if (this.uy != null && this.p.get()) {
            return null;
        }
        na naVar = this.g;
        boolean z = naVar != null && naVar.lt() == 4;
        if (this.m == null && this.z != null && z) {
            this.m = new gc() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.4
                @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gc
                public void z() {
                    int iWp;
                    if (a.this.gk != null) {
                        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = a.this.z.z();
                        if ((dlVarZ instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) && (1 == (iWp = ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVarZ).wp()) || 4 == iWp || 6 == iWp || 7 == iWp)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            a aVar = a.this;
                            String strZ = aVar.z(aVar.e);
                            fo.z zVar = new fo.z();
                            float fM = oq.m(a.this.dl);
                            com.bytedance.sdk.openadsdk.core.i.a.z("click", a.this.g, zVar.z(fM).z(oq.gz(a.this.dl)).g(oq.e(a.this.dl)).z(), strZ, true, map, 1, false);
                        }
                        if (dlVarZ != null) {
                            dlVarZ.a(true);
                            dlVarZ.z(eo.js(a.this.g), false);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gc
                public void g() {
                    com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ;
                    if (a.this.gk == null || (dlVarZ = a.this.z.z()) == null) {
                        return;
                    }
                    dlVarZ.a();
                }
            };
        }
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void g(Activity activity) {
        if (activity != null) {
            this.z.z(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public Map<String, Object> iq() {
        na naVar = this.g;
        if (naVar != null) {
            return naVar.fq();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void zw() {
        mc();
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.g).z(this.e).g(this.gz);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void io() {
        this.h = true;
        v vVar = this.uy;
        if (vVar != null) {
            vVar.gc();
        }
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc());
        }
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.g();
        }
        this.sy.g();
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.hh;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.i();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc uf() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar) {
        this.js = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        this.sy.z(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        v vVar;
        if (zVar == null || activity == null || (vVar = this.uy) == null) {
            return;
        }
        vVar.z(activity, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.i.a.g(this.g, str);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void g(final Dialog dialog, final Integer[] numArr) {
        v vVar = this.uy;
        if (vVar != null) {
            vVar.z(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.zw.a.5
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.dl.g gVarCt = a.this.g != null ? a.this.g.ct() : null;
                    if (gVarCt != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.z.g.z(gVarCt, dialog, numArr);
                    }
                }
            });
        } catch (Throwable unused) {
        }
        z(dialog);
    }

    private void dl(Activity activity) {
        Context context = this.dl;
        Context context2 = activity;
        if (context instanceof Activity) {
            context2 = activity;
            if (!((Activity) context).isFinishing()) {
                context2 = this.dl;
            }
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(context2, this.g.ct(), z(this.e), false);
        this.gc = zVar;
        com.bytedance.sdk.openadsdk.core.dislike.dl.z(context2, this.g, zVar);
    }

    private void dl(boolean z) {
        com.bytedance.sdk.openadsdk.core.q.v.z().z(this.e, this.g, z);
    }

    private boolean lq() {
        na naVar = this.g;
        if (naVar == null || naVar.lt() == 5) {
            return false;
        }
        if (this.gz == 0) {
            this.gz = eo.fo(this.g);
        }
        return zw.g().gz(this.gz) == 1;
    }

    private v z(na naVar) {
        na naVar2 = this.g;
        if (naVar2 == null || vm.z(naVar2) != 2) {
            return null;
        }
        boolean z = tf.v(naVar) != null;
        int i = this.e;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.dl(this.dl, naVar, this.fo);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.g(this.dl, naVar, this.fo);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.iq(this.dl, naVar, this.fo);
        }
        if (z) {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.zw(this.dl, naVar, this.fo);
        }
        return new q(this.dl, naVar, this.fo);
    }

    private void mc() {
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar;
        if (this.uy == null) {
            com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar2 = this.js;
            if (dlVar2 != null) {
                dlVar2.z(this.kb, this.fo.gz(), this.fo.fo(), false);
                return;
            }
            return;
        }
        if (this.p.get() && (dlVar = this.js) != null) {
            dlVar.z(this.wp, this.pf, this.ls, this.fv.get());
        } else {
            this.uy.z(new com.bytedance.sdk.openadsdk.uf.z.g.z.g(null) { // from class: com.bytedance.sdk.openadsdk.core.zw.a.6
                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, int i) {
                    if (a.this.tb != null) {
                        a.this.tb.z(view, a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void g(View view, int i) {
                    if (a.this.tb != null) {
                        a.this.tb.z(a.this);
                    }
                    if (a.this.sy == null || a.this.sy.z() == null) {
                        return;
                    }
                    a.this.sy.z().a();
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, String str, int i) {
                    a.this.p.set(true);
                    a aVar = a.this;
                    aVar.wp = aVar.kb;
                    a aVar2 = a.this;
                    aVar2.pf = aVar2.fo.gz();
                    a aVar3 = a.this;
                    aVar3.ls = aVar3.fo.fo();
                    if (a.this.js != null) {
                        a.this.js.z(a.this.kb, a.this.fo.gz(), a.this.fo.fo(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, float f, float f2) {
                    a.this.p.set(true);
                    a.this.fv.set(true);
                    a.this.wp = view;
                    a.this.pf = f;
                    a.this.ls = f2;
                    if (a.this.js != null) {
                        a.this.js.z(view, f, f2, true);
                    }
                }
            });
            this.uy.a();
        }
    }

    public iq a() {
        return this.z;
    }

    private void un() {
        if (this.kb == null || this.uy == null || this.wp == null) {
            return;
        }
        this.kb.removeAllViews();
        if (this.wp.getParent() != null) {
            ((ViewGroup) this.wp.getParent()).removeAllViews();
        }
        this.kb.addView(this.wp);
    }

    private void z(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.wp.dl("dialog is null, please check");
        } else {
            this.f1433a = dialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        Dialog dialog = this.f1433a;
        if (dialog != null) {
            dialog.show();
            return;
        }
        e eVar = this.gc;
        if (eVar != null) {
            eVar.z();
        } else {
            TTDelegateActivity.z(getContext(), this.g);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.iq) {
            return;
        }
        h.z(this.g, d);
        this.iq = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.zw) {
            return;
        }
        h.z(this.g, d, str, str2);
        this.zw = true;
    }

    public na sy() {
        return this.g;
    }

    public Context getContext() {
        return this.dl;
    }

    public boolean hh() {
        return this.v;
    }

    public void z(boolean z) {
        this.v = z;
    }

    public boolean l() {
        return this.i;
    }

    public void g(boolean z) {
        this.i = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc(), gVar, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        this.gk = zVar;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.h) {
            return;
        }
        io();
    }
}
