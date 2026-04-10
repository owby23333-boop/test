package com.bytedance.sdk.component.vn.e;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bf implements com.bytedance.sdk.component.vn.bf {
    private d bf;
    private com.bytedance.sdk.component.vn.e e;

    public bf(com.bytedance.sdk.component.vn.e eVar) {
        this.e = eVar;
    }

    private <T> T bf(String str, T t) {
        try {
            String strBf = this.e.bf(this.bf.e(str), "");
            return TextUtils.isEmpty(strBf) ? t : (T) new JSONObject((String) this.bf.bf(strBf)).get(str);
        } catch (Throwable unused) {
            return t;
        }
    }

    public void e(d dVar) {
        this.bf = dVar;
    }

    private <T> void e(String str, T t) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, t);
            this.e.e(this.bf.e(str), this.bf.e(jSONObject.toString()));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public int bf(String str, int i) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return i;
        }
        if (this.bf == null) {
            return eVar.bf(str, i);
        }
        return ((Integer) bf(str, Integer.valueOf(i))).intValue();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, int i) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, i);
        } else {
            e(str, Integer.valueOf(i));
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public long bf(String str, long j) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return j;
        }
        if (this.bf == null) {
            return eVar.bf(str, j);
        }
        return ((Long) bf(str, Long.valueOf(j))).longValue();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, long j) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, j);
        } else {
            e(str, Long.valueOf(j));
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public float bf(String str, float f) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return f;
        }
        if (this.bf == null) {
            return eVar.bf(str, f);
        }
        return ((Float) bf(str, Float.valueOf(f))).floatValue();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, float f) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, f);
        } else {
            e(str, Float.valueOf(f));
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public boolean bf(String str, boolean z) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return z;
        }
        if (this.bf == null) {
            return eVar.bf(str, z);
        }
        return ((Boolean) bf(str, Boolean.valueOf(z))).booleanValue();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, boolean z) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, z);
        } else {
            e(str, Boolean.valueOf(z));
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public String bf(String str, String str2) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return str2;
        }
        if (this.bf == null) {
            return eVar.bf(str, str2);
        }
        return (String) bf(str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, String str2) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, str2);
        } else {
            e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Set<String> bf(String str, Set<String> set) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return set;
        }
        d dVar = this.bf;
        if (dVar == null) {
            return eVar.bf(str, set);
        }
        Set<String> setBf = eVar.bf(dVar.e(str), set);
        HashSet hashSet = new HashSet();
        Iterator<String> it = setBf.iterator();
        while (it.hasNext()) {
            hashSet.add(this.bf.bf(it.next()));
        }
        return hashSet;
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, Set<String> set) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str, set);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(this.bf.e(it.next()));
        }
        this.e.e(this.bf.e(str), hashSet);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void bf() {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        eVar.bf();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Map<String, ?> e() {
        try {
            com.bytedance.sdk.component.vn.e eVar = this.e;
            if (eVar == null) {
                return Collections.emptyMap();
            }
            Map<String, ?> mapE = eVar.e();
            if (this.bf == null) {
                return mapE;
            }
            HashMap map = new HashMap();
            for (Map.Entry<String, ?> entry : mapE.entrySet()) {
                String str = (String) this.bf.bf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof Set) {
                    HashSet hashSet = new HashSet();
                    Iterator it = ((Set) value).iterator();
                    while (it.hasNext()) {
                        hashSet.add(this.bf.bf((String) it.next()));
                    }
                    map.put(str, hashSet);
                } else {
                    map.put(str, new JSONObject((String) this.bf.bf(value.toString())).get(str));
                }
            }
            return map;
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str) {
        com.bytedance.sdk.component.vn.e eVar = this.e;
        if (eVar == null) {
            return;
        }
        if (this.bf == null) {
            eVar.e(str);
        }
        this.e.e(this.bf.e(str));
    }
}
