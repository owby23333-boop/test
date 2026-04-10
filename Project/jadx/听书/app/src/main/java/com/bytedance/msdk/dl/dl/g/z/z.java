package com.bytedance.msdk.dl.dl.g.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.core.z.z.gc;
import com.bytedance.msdk.dl.z.e;
import com.bytedance.msdk.dl.z.fo;
import com.bytedance.msdk.dl.z.gz;
import com.bytedance.msdk.dl.z.m;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f442a;
    private int dl;
    private uy e;
    private int g;
    private com.bytedance.msdk.dl.m.g.g gc;
    private com.bytedance.msdk.api.z.g m;
    private dl z;

    public z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, dl dlVar) {
        this.g = gVar.iq();
        this.m = gVar;
        this.dl = gVar2.pf();
        this.gc = gVar2;
        this.z = dlVar;
        this.e = gVar2.gz();
    }

    public String z(Context context, String str, Object obj) {
        if (this.f442a != null) {
            Object objApply = this.f442a.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8139).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str).z(8044, obj).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.msdk.core.z.z.z.z zVarG;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        Class cls = (Class) pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == 8108) {
            this.z.z(new com.bytedance.msdk.api.z(pluginValueSetG.intValue(8014), pluginValueSetG.stringValue(8015)));
        } else if (iIntValue == 8112) {
            Function function = (Function) pluginValueSetG.objectValue(8303, Function.class);
            int iIntValue2 = pluginValueSetG.intValue(8014);
            String strStringValue = pluginValueSetG.stringValue(8015);
            ArrayList arrayList = new ArrayList(1);
            if (function instanceof com.bytedance.msdk.g.dl) {
                arrayList.add((com.bytedance.msdk.g.dl) function);
            } else if (function instanceof Function) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-99999977).g());
                if (objApply instanceof com.bytedance.msdk.g.dl) {
                    arrayList.add((com.bytedance.msdk.g.dl) objApply);
                }
            }
            this.z.z(arrayList, new com.bytedance.msdk.api.z(iIntValue2, strStringValue));
        } else if (iIntValue == 8107) {
            List list = (List) pluginValueSetG.objectValue(8303, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.bytedance.msdk.g.dl) {
                        arrayList2.add((com.bytedance.msdk.g.dl) obj);
                    } else if (obj instanceof Function) {
                        Object objApply2 = ((Function) obj).apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-99999977).g());
                        if (objApply2 instanceof com.bytedance.msdk.g.dl) {
                            arrayList2.add((com.bytedance.msdk.g.dl) objApply2);
                        }
                    }
                }
            }
            this.z.z(arrayList2);
        } else {
            if (iIntValue == 8127) {
                return z();
            }
            if (iIntValue == 8110) {
                return Boolean.valueOf(this.gc.z());
            }
            if (iIntValue == 8136) {
                return Boolean.valueOf(this.gc.zw());
            }
            if (iIntValue == 8141) {
                return Boolean.valueOf(this.gc.io());
            }
            if (iIntValue == 8137) {
                return this.gc.uf();
            }
            if (iIntValue == 8226) {
                return Integer.valueOf(this.gc.js());
            }
            if (iIntValue == 8138) {
                this.f442a = (Function) pluginValueSetG.objectValue(8043, Function.class);
            } else {
                if (iIntValue == 8210) {
                    return Boolean.valueOf(this.z.z());
                }
                if (iIntValue == 20000) {
                    Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSetG.objectValue(10010, Function.class);
                    String str = (String) pluginValueSetG.objectValue(10011, String.class);
                    Context context = (Context) pluginValueSetG.objectValue(10000, Context.class);
                    if (function2 != null && !TextUtils.isEmpty(str) && this.m != null && this.e != null && (zVarG = gc.g(str, this.g, this.dl)) != null) {
                        gc.z(this.m);
                        zVarG.z(context, function2, this.m, this.e, new com.bytedance.msdk.core.z.z.z.g() { // from class: com.bytedance.msdk.dl.dl.g.z.z.1
                            @Override // com.bytedance.msdk.core.z.z.z.g
                            public void z(List<com.bytedance.msdk.g.dl> list2) {
                                if (z.this.z != null) {
                                    z.this.z.z(list2);
                                }
                            }

                            @Override // com.bytedance.msdk.core.z.z.z.g
                            public void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z zVar) {
                                if (z.this.z != null) {
                                    z.this.z.z(dlVar, zVar);
                                }
                            }

                            @Override // com.bytedance.msdk.core.z.z.z.g
                            public void z(int i, String str2) {
                                if (z.this.z != null) {
                                    z.this.z.z(new com.bytedance.msdk.api.z(i, str2));
                                }
                            }
                        });
                    } else {
                        gc.g(this.m);
                    }
                }
            }
        }
        return com.bytedance.msdk.core.ls.z.z(cls);
    }

    private com.bytedance.msdk.g.dl z() {
        switch (this.g) {
            case 1:
                return new com.bytedance.msdk.dl.z.dl(this.gc);
            case 2:
                return new m(this.gc);
            case 3:
                return new fo(this.gc);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i = this.dl;
                if (i == 4) {
                    return new e(this.gc, this.z);
                }
                if (i == 3) {
                    return new com.bytedance.msdk.dl.z.dl(this.gc);
                }
                if (i == 5) {
                    return new e(this.gc, this.z);
                }
                return new e(this.gc, this.z);
            case 7:
                int i2 = this.dl;
                if (i2 == 6) {
                    return new gz(this.gc);
                }
                if (i2 == 7) {
                    return new com.bytedance.msdk.dl.z.gc(this.gc);
                }
                return new gz(this.gc);
            case 8:
                return new com.bytedance.msdk.dl.z.gc(this.gc);
            case 9:
                return new e(this.gc, this.z);
            case 10:
                int i3 = this.dl;
                if (i3 == 1) {
                    return new m(this.gc);
                }
                if (i3 == 2) {
                    return new com.bytedance.msdk.dl.z.gc(this.gc);
                }
                return null;
        }
    }
}
