package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends b {
    private Activity a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnythinkBTContainer f11942d;

    public i(Activity activity, AnythinkBTContainer anythinkBTContainer) {
        this.a = activity;
        this.f11942d = anythinkBTContainer;
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void click(int i2, String str) {
        super.click(i2, str);
        AnythinkBTContainer anythinkBTContainer = this.f11942d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.click(i2, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void handlerH5Exception(int i2, String str) {
        super.handlerH5Exception(i2, str);
        AnythinkBTContainer anythinkBTContainer = this.f11942d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.handlerH5Exception(i2, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.b
    public final void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        AnythinkBTContainer anythinkBTContainer = this.f11942d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.reactDeveloper(obj, str);
        }
    }
}
