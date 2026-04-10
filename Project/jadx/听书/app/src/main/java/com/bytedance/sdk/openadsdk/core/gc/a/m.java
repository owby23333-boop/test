package com.bytedance.sdk.openadsdk.core.gc.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final Map<String, AtomicBoolean> dl = new ConcurrentHashMap();
    private final com.bytedance.sdk.openadsdk.core.gc.a.g g;
    z z;

    public m(int i) {
        this.z = z(i);
        if (AnonymousClass3.z[this.z.gc.ordinal()] == 1) {
            this.g = new a();
        } else {
            this.g = new dl();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gc.a.m$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[z.dl.values().length];
            z = iArr;
            try {
                iArr[z.dl.KV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[z.dl.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void z(String str, g gVar, boolean z2, long j) {
        try {
            this.g.z(str, gVar, z2, j, this.z, zw.g().ka() ? new com.bytedance.sdk.openadsdk.core.gc.a.z() { // from class: com.bytedance.sdk.openadsdk.core.gc.a.m.1
                @Override // com.bytedance.sdk.openadsdk.core.gc.a.z
                public void z(g gVar2) {
                    try {
                        na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(com.bytedance.sdk.openadsdk.api.plugin.dl.g.g(gVar2.dl)));
                        naVarZ.ac().a(3);
                        com.bytedance.sdk.openadsdk.core.i.a.dl(naVarZ, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null);
        } catch (Throwable unused) {
        }
    }

    public g z(String str, boolean z2, long j) {
        g gVarZ;
        try {
            synchronized (a(str)) {
                System.currentTimeMillis();
                gVarZ = this.g.z(str, this.z, j);
                if (gVarZ != null && gVarZ.z()) {
                    if (z2) {
                        this.g.z(str, gVarZ.gc, true);
                    }
                    System.currentTimeMillis();
                }
            }
            return gVarZ;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<g> z(String str, boolean z2, long j, int i) {
        ArrayList<g> arrayList = new ArrayList();
        try {
            synchronized (a(str)) {
                System.currentTimeMillis();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    g gVarZ = this.g.z(str, this.z, j, arrayList2);
                    if (gVarZ == null || !gVarZ.z()) {
                        break;
                    }
                    arrayList2.add(gVarZ.gc);
                    arrayList.add(gVarZ);
                }
                for (g gVar : arrayList) {
                    if (z2) {
                        this.g.z(str, gVar.gc, true);
                    }
                    System.currentTimeMillis();
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public g z(String str, long j, List<String> list) {
        g gVarZ;
        try {
            synchronized (a(str)) {
                System.currentTimeMillis();
                gVarZ = this.g.z(str, this.z, j, list);
                if (gVarZ != null && gVarZ.z()) {
                    System.currentTimeMillis();
                }
            }
            return gVarZ;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void z() {
        try {
            this.g.z(this.z);
        } catch (Throwable unused) {
        }
    }

    public void z(String str) {
        try {
            this.g.z(str);
        } catch (Throwable unused) {
        }
    }

    public void g(String str) {
        try {
            this.g.z(str, this.z, zw.g().rh() ? new com.bytedance.sdk.openadsdk.core.gc.a.z() { // from class: com.bytedance.sdk.openadsdk.core.gc.a.m.2
                @Override // com.bytedance.sdk.openadsdk.core.gc.a.z
                public void z(g gVar) {
                    try {
                        na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(com.bytedance.sdk.openadsdk.api.plugin.dl.g.g(gVar.dl)));
                        naVarZ.ac().a(2);
                        com.bytedance.sdk.openadsdk.core.i.a.dl(naVarZ, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null);
        } catch (Throwable unused) {
        }
    }

    public void dl(String str) {
        try {
            if (a(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.g.g(str);
                System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void z(String str, String str2, boolean z2) {
        try {
            synchronized (a(str)) {
                this.g.z(str, str2, z2);
            }
        } catch (Throwable unused) {
        }
    }

    public void z(String str, String str2) {
        try {
            synchronized (a(str)) {
                this.g.z(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1080a = 7105;
        public String dl;
        public long g;
        public String gc;
        public long z;

        public g(String str, long j, long j2, String str2) {
            this.z = j;
            this.g = j2;
            this.dl = str;
            this.gc = str2;
        }

        public boolean z() {
            return (TextUtils.isEmpty(this.dl) || this.z == 0) ? false : true;
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1081a;
        private final boolean dl;
        private final int g;
        private final dl gc;
        private final g m;
        private final String z;

        public enum dl {
            KV,
            DB;

            public static dl z(int i) {
                if (i == 1) {
                    return KV;
                }
                return DB;
            }
        }

        public enum g {
            Random,
            TimeLast,
            CustomPriority;

            public static g z(int i) {
                if (i == 0) {
                    return Random;
                }
                if (i == 2) {
                    return CustomPriority;
                }
                return TimeLast;
            }
        }

        private z(C0172z c0172z) {
            this.z = c0172z.z;
            this.g = c0172z.g;
            this.dl = c0172z.dl;
            this.gc = c0172z.gc;
            this.m = c0172z.m;
            this.f1081a = c0172z.f1083a;
        }

        public String z() {
            return this.z;
        }

        public boolean g() {
            return this.dl;
        }

        public int dl() {
            return this.f1081a;
        }

        public g a() {
            return this.m;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gc.a.m$z$z, reason: collision with other inner class name */
        public static class C0172z {
            private int g;
            private String z = "Default";
            private boolean dl = true;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f1083a = 1;
            private dl gc = dl.DB;
            private g m = g.TimeLast;

            public C0172z z(String str) {
                this.z = str;
                return this;
            }

            public C0172z z(boolean z) {
                this.dl = z;
                return this;
            }

            public C0172z z(dl dlVar) {
                this.gc = dlVar;
                return this;
            }

            public C0172z z(g gVar) {
                this.m = gVar;
                return this;
            }

            public C0172z z(int i) {
                this.f1083a = i;
                return this;
            }

            public z z() {
                return new z(this);
            }
        }
    }

    private z z(int i) {
        String str;
        gz.g gVarZ = gz.z(i);
        switch (i) {
            case 1:
                str = "Banner";
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = ExploreConstants.SCENE_SPLASH;
                break;
            case 5:
                str = ExploreConstants.SCENE_FEED;
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = ExploreConstants.SCENE_REWARD;
                break;
            case 8:
                str = ExploreConstants.SCENE_FULL;
                break;
            case 9:
                str = "Draw";
                break;
        }
        if (gVarZ == null) {
            return new z.C0172z().z();
        }
        return new z.C0172z().z(str).z((i == 3 || i == 4) ? false : true).z(z.dl.z(gVarZ.gc())).z(z.g.z(gVarZ.g())).z(gVarZ.dl()).z();
    }

    private AtomicBoolean a(String str) {
        Map<String, AtomicBoolean> map = dl;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }
}
