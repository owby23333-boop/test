package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PendingPost.java */
/* JADX INFO: loaded from: classes3.dex */
final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<i> f21337d = new ArrayList();
    Object a;
    o b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    i f21338c;

    private i(Object obj, o oVar) {
        this.a = obj;
        this.b = oVar;
    }

    static i a(o oVar, Object obj) {
        synchronized (f21337d) {
            int size = f21337d.size();
            if (size <= 0) {
                return new i(obj, oVar);
            }
            i iVarRemove = f21337d.remove(size - 1);
            iVarRemove.a = obj;
            iVarRemove.b = oVar;
            iVarRemove.f21338c = null;
            return iVarRemove;
        }
    }

    static void a(i iVar) {
        iVar.a = null;
        iVar.b = null;
        iVar.f21338c = null;
        synchronized (f21337d) {
            if (f21337d.size() < 10000) {
                f21337d.add(iVar);
            }
        }
    }
}
