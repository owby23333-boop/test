package com.bytedance.adsdk.g.g;

import com.bytedance.adsdk.g.g.dl.z.a;
import com.bytedance.adsdk.g.g.dl.z.dl;
import com.bytedance.adsdk.g.g.dl.z.e;
import com.bytedance.adsdk.g.g.dl.z.fo;
import com.bytedance.adsdk.g.g.dl.z.g;
import com.bytedance.adsdk.g.g.dl.z.gc;
import com.bytedance.adsdk.g.g.dl.z.gz;
import com.bytedance.adsdk.g.g.dl.z.m;
import com.bytedance.adsdk.g.g.dl.z.uy;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final com.bytedance.adsdk.g.g.dl.z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Deque<com.bytedance.adsdk.g.g.g.z> f134a = new LinkedList();
    private com.bytedance.adsdk.g.g.g.z dl;
    private final com.bytedance.adsdk.g.g.dl.z g;
    private String gc;

    static {
        int i = 8;
        m[] mVarArr = {new uy(), new a(), new fo(), new g(), new gc(), new com.bytedance.adsdk.g.g.dl.z.z(), new e(), new dl(), new gz()};
        final com.bytedance.adsdk.g.g.dl.z zVar = new com.bytedance.adsdk.g.g.dl.z() { // from class: com.bytedance.adsdk.g.g.z.1
            @Override // com.bytedance.adsdk.g.g.dl.z
            public int z(String str, int i2, Deque<com.bytedance.adsdk.g.g.g.z> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final m mVar = mVarArr[i];
            i--;
            zVar = new com.bytedance.adsdk.g.g.dl.z() { // from class: com.bytedance.adsdk.g.g.z.2
                @Override // com.bytedance.adsdk.g.g.dl.z
                public int z(String str, int i2, Deque<com.bytedance.adsdk.g.g.g.z> deque) {
                    return mVar.z(str, i2, deque, zVar);
                }
            };
        }
        z = zVar;
    }

    private z(String str, com.bytedance.adsdk.g.g.dl.z zVar) {
        this.g = zVar;
        this.gc = str;
        try {
            z();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.g.z.g(str, e);
        }
    }

    public static z z(String str) {
        return new z(str, z);
    }

    private void z() {
        int length = this.gc.length();
        int i = 0;
        while (i < length) {
            int iZ = this.g.z(this.gc, i, this.f134a);
            if (iZ == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.gc.substring(0, i));
            }
            i = iZ;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.g.g.g.z zVarPollFirst = this.f134a.pollFirst();
            if (zVarPollFirst != null) {
                arrayList.add(0, zVarPollFirst);
            } else {
                this.dl = com.bytedance.adsdk.g.g.gc.g.z(arrayList, this.gc, i);
                this.f134a = null;
                return;
            }
        }
    }

    public <T> T z(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) z(map);
    }

    public <T> T z(Map<String, JSONObject> map) {
        return (T) this.dl.z(map);
    }
}
