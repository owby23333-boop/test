package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class TailFrameBarAppPortraitHorizontal extends a {
    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_horizontal;
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void j(AdTemplate adTemplate) {
        if (e.O(adTemplate)) {
            this.GD.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.nr.setTextColor(Color.parseColor("#FFFFFF"));
            this.MU.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.GD.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        super.j(adTemplate);
    }
}
