package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;

/* JADX INFO: loaded from: classes2.dex */
public class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.g f1423a;
    private Context dl;
    private com.bykv.vk.openvk.component.video.api.dl.dl e;
    private View fo;
    private TextView g;
    private g gc;
    private TTViewStub gz;
    private boolean m = false;
    private View z;

    public interface g {
        boolean uy();

        void wp();
    }

    public enum z {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public void z(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.fo = view;
        this.dl = zw.getContext().getApplicationContext();
        try {
            this.gz = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.gz());
        } catch (Throwable unused) {
        }
    }

    private void z(Context context, View view, boolean z2) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.gz) == null || tTViewStub.getParent() == null || this.z != null) {
            return;
        }
        this.gz.z();
        this.z = view.findViewById(2114387870);
        this.g = (TextView) view.findViewById(2114387817);
        View viewFindViewById = view.findViewById(2114387880);
        if (z2) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pf.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    pf.this.dl();
                    if (pf.this.f1423a != null) {
                        pf.this.f1423a.z(z.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar, g gVar2) {
        this.gc = gVar2;
        this.f1423a = gVar;
    }

    private void g() {
        this.e = null;
    }

    public boolean z(int i, com.bykv.vk.openvk.component.video.api.dl.dl dlVar, boolean z2) {
        Context context = this.dl;
        if (context != null && dlVar != null) {
            try {
                z(context, this.fo, z2);
                this.e = dlVar;
                if (i == 1 || i == 2) {
                    return z(i);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        return true;
    }

    private boolean z(int i) {
        g gVar;
        if (z() || this.m) {
            return true;
        }
        if (this.f1423a != null && (gVar = this.gc) != null) {
            if (gVar.uy()) {
                this.f1423a.gc(null, null);
            }
            this.f1423a.z(z.PAUSE_VIDEO, (String) null);
        }
        z(this.e, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        if (this.dl == null) {
            return;
        }
        a();
    }

    public void z(boolean z2) {
        if (z2) {
            g();
        }
        a();
    }

    public boolean z() {
        View view = this.z;
        return view != null && view.getVisibility() == 0;
    }

    private void a() {
        View view = this.z;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void z(com.bykv.vk.openvk.component.video.api.dl.dl dlVar, boolean z2) {
        View view;
        String str;
        View view2;
        if (dlVar == null || (view = this.z) == null || this.dl == null || view.getVisibility() == 0) {
            return;
        }
        g gVar = this.gc;
        if (gVar != null) {
            gVar.wp();
        }
        int iCeil = (int) Math.ceil((dlVar.gc() * 1.0d) / 1048576.0d);
        if (z2) {
            str = tb.z(this.dl, "tt_video_without_wifi_tips") + iCeil + tb.z(this.dl, "tt_video_bytesize_MB") + tb.z(this.dl, "tt_video_bytesize");
        } else {
            str = tb.z(this.dl, "tt_video_without_wifi_tips") + tb.z(this.dl, "tt_video_bytesize");
        }
        oq.z(this.z, 0);
        oq.z(this.g, str);
        if (!oq.a(this.z) || (view2 = this.z) == null) {
            return;
        }
        view2.bringToFront();
    }
}
