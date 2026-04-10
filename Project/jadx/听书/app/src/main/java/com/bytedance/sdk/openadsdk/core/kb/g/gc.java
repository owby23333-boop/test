package com.bytedance.sdk.openadsdk.core.kb.g;

import com.bytedance.sdk.openadsdk.core.kb.g.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements z {
    private final ConcurrentHashMap<Integer, z> z = new ConcurrentHashMap<>();

    public void z(z zVar) {
        if (zVar != null) {
            this.z.put(Integer.valueOf(zVar.hashCode()), zVar);
        }
    }

    public void g() {
        if (this.z.isEmpty()) {
            return;
        }
        this.z.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void z() {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new g.z().z(next.getValue()).z("onIdle").z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void z(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new g.z().z(next.getValue()).z("onDownloadActive").z(j).g(j2).g(str).dl(str2).z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void g(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new g.z().z(next.getValue()).z("onDownloadPaused").z(j).g(j2).g(str).dl(str2).z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void dl(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new g.z().z(next.getValue()).z("onDownloadFailed").z(j).g(j2).g(str).dl(str2).z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void z(String str, String str2) {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().z(str, str2);
                new g.z().z(next.getValue()).z("onInstalled").g(str).dl(str2).z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
    public void z(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, z> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new g.z().z(next.getValue()).z("onDownloadFinished").z(j).g(str).dl(str2).z();
            }
        }
    }

    public boolean dl() {
        return this.z.size() > 0;
    }
}
