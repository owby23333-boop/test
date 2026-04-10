package com.kwad.sdk.g.kwai;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    protected List<c> awS;
    protected boolean enabled;

    public a() {
        this.enabled = true;
    }

    public a(boolean z2) {
        this.enabled = z2;
    }

    private List<c> getChildren() {
        return this.awS;
    }

    @Override // com.kwad.sdk.g.kwai.c
    public final boolean bC(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return bD(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().bC(context)) {
                return true;
            }
        }
        return false;
    }

    protected boolean bD(Context context) {
        return false;
    }
}
