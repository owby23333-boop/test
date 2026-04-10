package com.bytedance.sdk.component.z;

import android.net.Uri;
import com.bytedance.sdk.component.z.iq;
import com.bytedance.sdk.component.z.kb;
import com.bytedance.sdk.component.z.q;
import com.funny.audio.core.utils.FileUtils;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f865a;
    private final iq dl = p.z;
    private final Set<String> g;
    private kb.g gc;
    private final Set<String> z;

    tb(q qVar, Set<String> set, Set<String> set2) {
        this.f865a = qVar;
        if (set == null || set.isEmpty()) {
            this.z = new LinkedHashSet();
        } else {
            this.z = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.g = new LinkedHashSet();
        } else {
            this.g = new LinkedHashSet(set2);
        }
    }

    final synchronized zw z(boolean z, String str, g gVar) throws q.z {
        zw zwVarG;
        kb.g gVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        zw zwVar = this.g.contains(gVar.z()) ? zw.PUBLIC : null;
        for (String str2 : this.z) {
            if (uri.getHost().equals(str2) || host.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR.concat(String.valueOf(str2)))) {
                zwVar = zw.PRIVATE;
                break;
            }
        }
        if (zwVar == null && (gVar2 = this.gc) != null && gVar2.z(str)) {
            if (this.gc.z(str, gVar.z())) {
                return null;
            }
            zwVar = zw.PRIVATE;
        }
        if (z) {
            zwVarG = z(str, gVar);
        } else {
            zwVarG = g(str, gVar);
        }
        return zwVarG != null ? zwVarG : zwVar;
    }

    final synchronized zw z(String str, g gVar) throws q.z {
        return z(str, gVar, true);
    }

    final synchronized zw g(String str, g gVar) {
        return z(str, gVar, false);
    }

    void z(kb.g gVar) {
        this.gc = gVar;
    }

    void z(iq.z zVar) {
        iq iqVar = this.dl;
        if (iqVar != null) {
            iqVar.z(zVar);
        }
    }

    void g(iq.z zVar) {
        iq iqVar = this.dl;
        if (iqVar != null) {
            iqVar.g(zVar);
        }
    }

    private zw z(String str, g gVar, boolean z) {
        q qVar;
        if (!z || (qVar = this.f865a) == null) {
            return null;
        }
        q.dl dlVarZ = qVar.z(str, this.z);
        if (dlVarZ.dl.contains(gVar.z())) {
            return null;
        }
        if (dlVarZ.g.contains(gVar.z())) {
            return zw.PRIVATE;
        }
        if (dlVarZ.z.compareTo(gVar.g()) < 0) {
            return null;
        }
        return dlVarZ.z;
    }
}
