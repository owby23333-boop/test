package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements DislikeInfo {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public a(Function<SparseArray<Object>, Object> function) {
        this.g = com.bykv.z.z.z.z.dl.z;
        function = function == null ? com.bykv.z.z.z.z.dl.dl : function;
        this.z = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.g = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        List arrayList = (List) this.g.objectValue(243001, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new m(pf.z(it.next())));
            }
        }
        return arrayList2;
    }
}
