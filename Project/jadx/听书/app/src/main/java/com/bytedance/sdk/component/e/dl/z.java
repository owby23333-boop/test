package com.bytedance.sdk.component.e.dl;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.e.g, com.bytedance.sdk.component.e.z {
    private final boolean g = false;
    private final com.bytedance.sdk.component.a.g.z z;

    public z(com.bytedance.sdk.component.a.g.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.component.e.z
    public Map<String, Object> z(File file) {
        if (file.getName().endsWith(".prop")) {
            return new g(this.z, this.g).z(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new g(this.z, this.g).z(file2);
        }
        if (file.getName().endsWith("xml")) {
            if (gc.z()) {
                return new gc(this.z, this.g).z(file);
            }
            return new m(this.z, this.g).z(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.sdk.component.e.g
    public void z(Map<String, Object> map, File file) throws Throwable {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new g(this.z, this.g).z(map, file);
    }
}
