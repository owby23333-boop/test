package com.bytedance.msdk.core.fo;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    protected static List<uy> z(com.bytedance.msdk.core.uy.g gVar, String str) {
        return z(gVar, str, 0.0d, 0.0d);
    }

    public static List<uy> z(com.bytedance.msdk.core.uy.g gVar, String str, double d, double d2) {
        int i;
        double dZ;
        if (gVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.bytedance.msdk.core.uy.a aVarGc = com.bytedance.msdk.core.g.g().gc(str);
        if (aVarGc != null) {
            double dZ2 = aVarGc.z();
            double dG = aVarGc.g();
            int iDl = aVarGc.dl();
            if (gVar.e() == 3 || gVar.e() == 4) {
                i = 1;
                double[] dArrZ = g.a().z(gVar.e(), d, d2, gVar.lq(), str);
                double d3 = dArrZ[0];
                gVar.m().put("price_from", Integer.valueOf((int) dArrZ[1]));
                dZ = d3;
            } else if (gVar.e() == 2) {
                dZ = g.a().z(3, str, iDl);
                i = 1;
            } else {
                i = 1;
                dZ = 0.0d;
            }
            if (!aVarGc.gc() && dZ > 0.0d) {
                if (aVarGc.getType() == i) {
                    g(dZ, dZ2, dG, gVar, copyOnWriteArrayList);
                } else if (aVarGc.getType() == 2) {
                    z(dZ, dZ2, dG, gVar, copyOnWriteArrayList);
                }
                List<com.bytedance.msdk.core.uy.dl> listM = com.bytedance.msdk.core.g.g().m(String.valueOf(gVar.ti()));
                if (listM != null) {
                    Iterator<com.bytedance.msdk.core.uy.dl> it = listM.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bytedance.msdk.core.uy.dl next = it.next();
                        if (dZ > next.m() && dZ <= next.gc()) {
                            gVar.m().put("user_label_value", next);
                            break;
                        }
                    }
                }
            }
            gVar.m().put("rule_id", aVarGc.a());
            gVar.m().put(MediationConstant.KEY_ECPM, Double.valueOf(dZ));
            gVar.m().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : i));
            gVar.m().put("group_type", Integer.valueOf(gVar.e()));
        }
        if (com.bytedance.msdk.z.gc.dl.g()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.bytedance.msdk.z.gc.dl.z("DynamicRuleCalculate", "rit：" + ((uy) copyOnWriteArrayList.get(i2)).fv() + ",level：" + ((uy) copyOnWriteArrayList.get(i2)).io());
                }
            } else {
                com.bytedance.msdk.z.gc.dl.z("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : gVar.t();
    }

    private static void z(double d, double d2, double d3, com.bytedance.msdk.core.uy.g gVar, List<uy> list) {
        if (gVar == null || d2 == 0.0d || d < gVar.uf()) {
            return;
        }
        if (d > gVar.io() && d3 <= 0.0d) {
            list.addAll(gVar.t());
        } else {
            z(gVar, d, d2, d3, list);
        }
    }

    public static void z(com.bytedance.msdk.core.uy.g gVar, double d, double d2, double d3, List<uy> list) {
        Map<Integer, List<uy>> mapGp = gVar.gp();
        if (mapGp != null) {
            ArrayList arrayList = new ArrayList(mapGp.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i2));
                } else {
                    List<uy> list2 = mapGp.get(arrayList.get(i2));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.bytedance.msdk.core.e.g.z(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int iMax = -1;
            int iMin = size;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                double d4 = i3;
                List<uy> list3 = mapGp.get(arrayList2.get(i3));
                if (list3 != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list3.size()) {
                            break;
                        }
                        uy uyVar = list3.get(i4);
                        if (uyVar != null && uyVar.js() == 0) {
                            double dDoubleValue = BigDecimal.valueOf(uyVar.zw()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d == dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) (d4 - d2), 0);
                                }
                                if (iMin == size || d == dDoubleValue) {
                                    if (d3 > 0.0d) {
                                        iMin = Math.min((int) (d4 + d3), size - 1);
                                    }
                                }
                            } else if (d > dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) Math.ceil(((d4 + (d4 - 1.0d)) / 2.0d) - d2), 0);
                                }
                                if (iMin == size) {
                                    if (d3 > 0.0d) {
                                        iMin = Math.min((int) Math.floor(((d4 + (d4 - 1.0d)) / 2.0d) + d3), size - 1);
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                    iMin = size - 1;
                }
            }
            if (iMax < 0) {
                iMax = 0;
            }
            if (iMin >= size) {
                iMin = size - 1;
            }
            int i5 = iMax;
            double d5 = -1.0d;
            double dZw = -1.0d;
            double dZw2 = -1.0d;
            while (i5 <= iMin) {
                List<uy> list4 = mapGp.get(arrayList2.get(i5));
                if (list4 != null && list4.size() != 0) {
                    while (i < list4.size()) {
                        uy uyVar2 = list4.get(i);
                        if (uyVar2 != null) {
                            if (dZw < uyVar2.zw() || dZw == -1.0d) {
                                dZw = uyVar2.zw();
                            }
                            if (dZw2 > uyVar2.zw() || dZw2 == -1.0d) {
                                dZw2 = uyVar2.zw();
                            }
                            list.add(uyVar2);
                            if (i5 == iMax) {
                                d5 = dZw;
                            }
                        }
                        i++;
                    }
                }
                i5++;
                i = 0;
            }
            gVar.m().put("upper_cpm_x", Double.valueOf(d5));
            gVar.m().put("max_ecpm", Double.valueOf(dZw));
            gVar.m().put("min_ecpm", Double.valueOf(dZw2));
        }
    }

    private static void g(double d, double d2, double d3, com.bytedance.msdk.core.uy.g gVar, List<uy> list) {
        if (d2 < d3 || d2 <= 0.0d || d < gVar.uf()) {
            return;
        }
        if (d > gVar.io() && d3 <= 0.0d) {
            list.addAll(gVar.t());
            return;
        }
        double dDoubleValue = BigDecimal.valueOf(d * d2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double dDoubleValue2 = BigDecimal.valueOf(d * d3).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<uy> listT = gVar.t();
        double dZw = -1.0d;
        double dZw2 = -1.0d;
        for (int i = 0; i < listT.size(); i++) {
            uy uyVar = listT.get(i);
            if (uyVar.js() == 0) {
                double dDoubleValue3 = BigDecimal.valueOf(uyVar.zw()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (dDoubleValue3 <= dDoubleValue && dDoubleValue3 >= dDoubleValue2) {
                    if (dZw == -1.0d || dZw < uyVar.zw()) {
                        dZw = uyVar.zw();
                    }
                    if (dZw2 == -1.0d || dZw2 > uyVar.zw()) {
                        dZw2 = uyVar.zw();
                    }
                    list.add(uyVar);
                }
            } else {
                list.add(uyVar);
            }
        }
        gVar.m().put("max_ecpm", Double.valueOf(dZw));
        gVar.m().put("min_ecpm", Double.valueOf(dZw2));
        gVar.m().put("upper_cpm_x", Double.valueOf(dDoubleValue));
    }
}
