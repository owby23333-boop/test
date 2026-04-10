package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.a.g;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.gc;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class z extends a {
    public z(Context context, ViewGroup viewGroup, na naVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, naVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    protected m z(Context context, EnumSet<g.z> enumSet) {
        View layoutVideoDetail;
        if (this.wp) {
            layoutVideoDetail = z(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.wp) {
            return new m(context, view, true, enumSet, this.m, this, wj(), null);
        }
        return new gc(context, view, true, enumSet, this.m, this, false);
    }

    private View z(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        tTProgressBar.setIndeterminateDrawable(tb.dl(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
