package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.openadsdk.core.a.uk;
import com.bytedance.sdk.openadsdk.core.lc;

/* JADX INFO: loaded from: classes10.dex */
public class l {
    private TextView bf;
    private Context d;
    private View e;
    private bf ga;
    private com.bykv.vk.openvk.component.video.api.d.d p;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.e tg;
    private ViewStub v;
    private boolean vn = false;
    private View zk;

    public interface bf {
        boolean m();

        void xu();
    }

    public enum e {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.d == null) {
            return;
        }
        tg();
    }

    private void tg() {
        View view = this.e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void bf() {
        this.p = null;
    }

    public void e(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.zk = view;
        this.d = lc.getContext().getApplicationContext();
        try {
            this.v = (ViewStub) LayoutInflater.from(context).inflate(dt.vn(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(dt.ga(context, "tt_video_traffic_tip_layout_viewStub"));
        } catch (Throwable unused) {
        }
    }

    private void e(Context context, View view, boolean z) {
        ViewStub viewStub;
        if (context == null || view == null || (viewStub = this.v) == null || viewStub.getParent() == null || this.e != null) {
            return;
        }
        this.v.inflate();
        this.e = view.findViewById(dt.ga(context, "tt_video_traffic_tip_layout"));
        this.bf = (TextView) view.findViewById(dt.ga(context, "tt_video_traffic_tip_tv"));
        View viewFindViewById = view.findViewById(dt.ga(context, "tt_video_traffic_continue_play_btn"));
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    l.this.d();
                    if (l.this.tg != null) {
                        l.this.tg.e(e.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar, bf bfVar) {
        this.ga = bfVar;
        this.tg = eVar;
    }

    public boolean e(int i, com.bykv.vk.openvk.component.video.api.d.d dVar, boolean z) {
        Context context = this.d;
        if (context != null && dVar != null) {
            try {
                e(context, this.zk, z);
                this.p = dVar;
                if (i == 1 || i == 2) {
                    return e(i);
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    private boolean e(int i) {
        bf bfVar;
        if (e() || this.vn) {
            return true;
        }
        if (this.tg != null && (bfVar = this.ga) != null) {
            if (bfVar.m()) {
                this.tg.ga(null, null);
            }
            this.tg.e(e.PAUSE_VIDEO, (String) null);
        }
        e(this.p, true);
        return false;
    }

    public void e(boolean z) {
        if (z) {
            bf();
        }
        tg();
    }

    public boolean e() {
        View view = this.e;
        return view != null && view.getVisibility() == 0;
    }

    private void e(com.bykv.vk.openvk.component.video.api.d.d dVar, boolean z) {
        View view;
        String str;
        View view2;
        if (dVar == null || (view = this.e) == null || this.d == null || view.getVisibility() == 0) {
            return;
        }
        bf bfVar = this.ga;
        if (bfVar != null) {
            bfVar.xu();
        }
        int iCeil = (int) Math.ceil((dVar.ga() * 1.0d) / 1048576.0d);
        if (z) {
            str = dt.e(this.d, "tt_video_without_wifi_tips") + iCeil + dt.e(this.d, "tt_video_bytesize_MB") + dt.e(this.d, "tt_video_bytesize");
        } else {
            str = dt.e(this.d, "tt_video_without_wifi_tips") + dt.e(this.d, "tt_video_bytesize");
        }
        uk.e(this.e, 0);
        uk.e(this.bf, str);
        if (!uk.tg(this.e) || (view2 = this.e) == null) {
            return;
        }
        view2.bringToFront();
    }
}
