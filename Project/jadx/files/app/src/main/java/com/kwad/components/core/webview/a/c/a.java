package com.kwad.components.core.webview.a.c;

import com.kwad.components.core.webview.a.d.b;
import com.kwad.sdk.utils.bh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final Set<b> Vx;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.a.c.a$a, reason: collision with other inner class name */
    static class C0412a {
        private static final a Vz = new a(0);
    }

    private a() {
        this.Vx = new HashSet();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str) {
        if (this.Vx.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.Vx).iterator();
        while (it.hasNext()) {
            ((b) it.next()).u(str);
        }
    }

    public static a rE() {
        return C0412a.Vz;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.Vx.add(bVar);
        }
    }

    public final void aJ(final String str) {
        com.kwad.sdk.core.d.b.d("TkLoadFailedHelper", "notifyAdTkFailed : " + str);
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aI(str);
            }
        });
    }

    public final void b(b bVar) {
        this.Vx.remove(bVar);
    }

    public final void rF() {
        this.Vx.clear();
    }
}
