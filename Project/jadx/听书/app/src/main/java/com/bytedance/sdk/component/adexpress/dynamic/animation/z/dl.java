package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl z;

    private dl() {
    }

    public static dl z() {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl();
                }
            }
        }
        return z;
    }

    public a z(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        if (zVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(zVar.fo())) {
            return new kb(view, zVar);
        }
        if ("translate".equals(zVar.fo())) {
            return new pf(view, zVar);
        }
        if ("ripple".equals(zVar.fo())) {
            return new gz(view, zVar);
        }
        if ("marquee".equals(zVar.fo())) {
            return new e(view, zVar);
        }
        if ("waggle".equals(zVar.fo())) {
            return new ls(view, zVar);
        }
        if ("shine".equals(zVar.fo())) {
            return new wp(view, zVar);
        }
        if ("swing".equals(zVar.fo())) {
            return new v(view, zVar);
        }
        if ("fade".equals(zVar.fo())) {
            return new z(view, zVar);
        }
        if ("rubIn".equals(zVar.fo())) {
            return new uy(view, zVar);
        }
        if ("rotate".equals(zVar.fo())) {
            return new fo(view, zVar);
        }
        if ("cutIn".equals(zVar.fo())) {
            return new m(view, zVar);
        }
        if ("stretch".equals(zVar.fo())) {
            return new i(view, zVar);
        }
        if ("bounce".equals(zVar.fo())) {
            return new gc(view, zVar);
        }
        return null;
    }
}
