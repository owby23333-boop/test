package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements c {
    protected List<c> aWE;
    protected boolean enabled;

    protected boolean cm(Context context) {
        return false;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    public a() {
        this.enabled = true;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean cl(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            Iterator<c> it = children.iterator();
            while (it.hasNext()) {
                if (it.next().cl(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return cm(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private List<c> getChildren() {
        return this.aWE;
    }
}
