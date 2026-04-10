package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements FilterWord, Function<SparseArray<Object>, Object> {
    private FilterWord g;
    private final Function<SparseArray<Object>, Object> z;

    public m(FilterWord filterWord) {
        this.g = filterWord;
        this.z = com.bykv.z.z.z.z.dl.dl;
    }

    public m(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.z.apply(sparseArray);
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

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new m(filterWord));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.z.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.g == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 241101:
                this.g.addOption(new m(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 241102:
                this.g.setIsSelected(valueSetG.booleanValue(0));
                return null;
            case 241103:
                return this.g.getId();
            case 241104:
                return this.g.getName();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(this.g.getIsSelected()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(this.g.hasSecondOptions()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(this.g.isValid()));
            case 241108:
                return this.g.getOptions();
            default:
                return null;
        }
    }
}
