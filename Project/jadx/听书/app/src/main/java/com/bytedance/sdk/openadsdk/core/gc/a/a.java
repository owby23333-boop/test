package com.bytedance.sdk.openadsdk.core.gc.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.gc.a.m;
import com.bytedance.sdk.openadsdk.core.un.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private static final com.bytedance.sdk.component.a.g.dl z = x.z("open_ad_sdk_meta_cache_kv");

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, m.g gVar, boolean z2, long j, m.z zVar, com.bytedance.sdk.openadsdk.core.gc.a.z zVar2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        if (zVar.dl() <= 0) {
            return;
        }
        if (zVar.dl() > 0 && copyOnWriteArraySet.size() >= zVar.dl()) {
            z zVar3 = null;
            long j2 = 0;
            String str2 = null;
            for (String str3 : copyOnWriteArraySet) {
                z zVarZ = z.z(str3);
                if (str2 == null || j2 < zVarZ.z) {
                    j2 = zVarZ.z;
                    str2 = str3;
                    zVar3 = zVarZ;
                }
            }
            if (zVar3 != null) {
                zVar2.z(new m.g(zVar3.f1078a, zVar3.z, zVar3.g, zVar3.m));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new z(gVar.dl, gVar.z, gVar.g, z2, gVar.gc, j).toString());
        z.put(dl(str), copyOnWriteArraySet);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public m.g z(String str, m.z zVar, long j) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        return z(copyOnWriteArraySet, zVar, j, (List<String>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public m.g z(String str, m.z zVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        return z(copyOnWriteArraySet, zVar, j, list);
    }

    private m.g z(CopyOnWriteArraySet<String> copyOnWriteArraySet, m.z zVar, long j, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        z zVar2 = null;
        while (it.hasNext()) {
            z zVarZ = z.z(it.next());
            if (zVarZ.z(zVar)) {
                String str = zVarZ.m;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || zVarZ.z >= j) {
                        int i = AnonymousClass1.z[zVar.a().ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                return new m.g(zVarZ.f1078a, zVarZ.z, zVarZ.g, zVarZ.m);
                            }
                            if (zVar2 == null || zVar2.e < zVarZ.e) {
                                zVar2 = zVarZ;
                            }
                        } else if (zVar2 == null || zVar2.z < zVarZ.z) {
                            zVar2 = zVarZ;
                        }
                    }
                }
            }
        }
        if (zVar2 != null) {
            return new m.g(zVar2.f1078a, zVar2.z, zVar2.g, zVar2.m);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gc.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[m.z.g.values().length];
            z = iArr;
            try {
                iArr[m.z.g.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[m.z.g.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str) {
        z.remove(dl(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(m.z zVar) {
        z.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, m.z zVar, com.bytedance.sdk.openadsdk.core.gc.a.z zVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            z zVarZ = z.z((String) it.next());
            if (!zVarZ.g(zVar)) {
                copyOnWriteArraySet2.add(zVarZ.toString());
            } else if (zVar2 != null) {
                zVar2.z(new m.g(zVarZ.f1078a, zVarZ.z, zVarZ.g, zVarZ.m));
            }
        }
        z.put(dl(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, String str2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(z.z(str3).m, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        z.put(dl(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void g(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            z zVarZ = z.z((String) it.next());
            zVarZ.dl = false;
            copyOnWriteArraySet2.add(zVarZ.toString());
        }
        z.put(dl(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, String str2, boolean z2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(z.get(dl(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            z zVarZ = z.z(str3);
            if (TextUtils.equals(zVarZ.m, str2)) {
                zVarZ.dl = z2;
                copyOnWriteArraySet2.add(zVarZ.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        z.put(dl(str), copyOnWriteArraySet2);
    }

    private String dl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1078a;
        boolean dl;
        long e;
        long g;
        int gc;
        String m;
        long z;

        public static z z(String str) {
            long jOptLong;
            long jOptLong2;
            int i;
            boolean z;
            String str2;
            String str3;
            long jOptLong3;
            String str4;
            boolean z2;
            int i2;
            long j;
            long j2;
            JSONObject jSONObject;
            String strOptString;
            String strOptString2 = "";
            boolean zOptBoolean = true;
            int iOptInt = 0;
            try {
                jSONObject = new JSONObject(str);
                jOptLong = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong2 = jSONObject.optLong("expire_time", 0L);
                    try {
                        zOptBoolean = jSONObject.optBoolean("is_using", false);
                        strOptString = jSONObject.optString("material_data", "");
                    } catch (JSONException unused) {
                        i = 0;
                        z = zOptBoolean;
                        str2 = "";
                        str3 = strOptString2;
                        jOptLong3 = 0;
                        str4 = str2;
                        z2 = z;
                        i2 = i;
                        j = jOptLong;
                        j2 = jOptLong2;
                        return new z(str3, j, j2, z2, str4, jOptLong3, i2);
                    }
                } catch (JSONException unused2) {
                    jOptLong2 = 0;
                }
            } catch (JSONException unused3) {
                jOptLong = 0;
                jOptLong2 = 0;
            }
            try {
                iOptInt = jSONObject.optInt("save_version", 0);
                strOptString2 = jSONObject.optString("uuid", "");
                str4 = strOptString2;
                jOptLong3 = jSONObject.optLong("priority", 0L);
                z2 = zOptBoolean;
                i2 = iOptInt;
                j = jOptLong;
                j2 = jOptLong2;
                str3 = strOptString;
            } catch (JSONException unused4) {
                i = iOptInt;
                z = zOptBoolean;
                str2 = strOptString2;
                strOptString2 = strOptString;
                str3 = strOptString2;
                jOptLong3 = 0;
                str4 = str2;
                z2 = z;
                i2 = i;
                j = jOptLong;
                j2 = jOptLong2;
            }
            return new z(str3, j, j2, z2, str4, jOptLong3, i2);
        }

        public z(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this.z = j;
            this.g = j2;
            this.dl = z;
            this.f1078a = str;
            this.m = str2;
            this.e = j3;
            this.gc = i;
        }

        public z(String str, long j, long j2, boolean z, String str2, long j3) {
            this(str, j, j2, z, str2, j3, 7105);
        }

        public boolean z(m.z zVar) {
            return (g(zVar) || this.dl) ? false : true;
        }

        public boolean g(m.z zVar) {
            if (System.currentTimeMillis() <= this.g && !TextUtils.isEmpty(this.f1078a)) {
                return zVar.g() && 7105 != this.gc;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.z);
                jSONObject.put("expire_time", this.g);
                jSONObject.put("is_using", this.dl);
                jSONObject.put("material_data", this.f1078a);
                jSONObject.put("save_version", this.gc);
                jSONObject.put("uuid", this.m);
                jSONObject.put("priority", this.e);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }
}
