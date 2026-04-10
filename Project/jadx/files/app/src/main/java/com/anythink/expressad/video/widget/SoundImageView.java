package com.anythink.expressad.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class SoundImageView extends ImageView {
    private boolean a;

    public SoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
    }

    public boolean getStatus() {
        return this.a;
    }

    public void setSoundStatus(boolean z2) {
        this.a = z2;
        if (this.a) {
            setImageResource(i.a(getContext(), "anythink_reward_sound_open", i.f10645c));
        } else {
            setImageResource(i.a(getContext(), "anythink_reward_sound_close", i.f10645c));
        }
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public SoundImageView(Context context) {
        super(context);
        this.a = true;
    }
}
