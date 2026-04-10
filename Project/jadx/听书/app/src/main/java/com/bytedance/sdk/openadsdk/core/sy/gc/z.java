package com.bytedance.sdk.openadsdk.core.sy.gc;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.g.dl;
import com.bytedance.sdk.openadsdk.ats.a;
import com.bytedance.sdk.openadsdk.core.sy.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class z implements g {
    private static volatile z z;

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String g() {
        return "ugen_render";
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String z(String str) {
        int i = a.z(g()).get(str, 0);
        return (i == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(String str, String str2) {
        dl dlVarZ = a.z(g());
        synchronized (dlVarZ) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(dlVarZ.get("key_h5_render_result_list", new HashSet()));
                if (linkedHashSet.size() >= 100) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (TextUtils.isEmpty(str3)) {
                            it.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str3.substring(0, str3.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet.size() < 100) {
                                break;
                            }
                            it.remove();
                            if (str3.endsWith("0")) {
                                dlVarZ.put("h5_render_success", dlVarZ.get("h5_render_success", 0) - 1);
                            } else if (str3.endsWith("1")) {
                                dlVarZ.put("h5_render_fail", dlVarZ.get("h5_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    dlVarZ.put("h5_render_success", dlVarZ.get("h5_render_success", 0) + 1);
                } else {
                    dlVarZ.put("h5_render_fail", dlVarZ.get("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                dlVarZ.put("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(dlVarZ.get("native_key_render_result_list", new HashSet()));
                if (linkedHashSet2.size() >= 100) {
                    Iterator it2 = linkedHashSet2.iterator();
                    while (it2.hasNext()) {
                        String str4 = (String) it2.next();
                        if (TextUtils.isEmpty(str4)) {
                            it2.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str4.substring(0, str4.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet2.size() < 100) {
                                break;
                            }
                            it2.remove();
                            if (str4.endsWith("0")) {
                                dlVarZ.put("native_render_success", dlVarZ.get("native_render_success", 0) - 1);
                            } else if (str4.endsWith("1")) {
                                dlVarZ.put("native_render_fail", dlVarZ.get("native_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    dlVarZ.put("native_render_success", dlVarZ.get("native_render_success", 0) + 1);
                } else {
                    dlVarZ.put("native_render_fail", dlVarZ.get("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                dlVarZ.put("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
