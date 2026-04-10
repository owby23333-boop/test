package com.yuewen;

import com.duokan.reader.domain.store.DkSignInReward;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class wk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f19525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19526b;
    public List<DkSignInReward> c;
    public boolean d;
    public boolean e;
    public boolean f;

    public HashMap a() {
        HashMap map = new HashMap();
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                DkSignInReward dkSignInReward = this.c.get(i);
                String strName = dkSignInReward.name();
                int i2 = Integer.parseInt(dkSignInReward.value());
                if (map.containsKey(strName)) {
                    map.put(strName, Integer.valueOf(((Integer) map.get(strName)).intValue() + i2));
                } else {
                    map.put(strName, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }
}
