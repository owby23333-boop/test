package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class i implements wp, Function {
    wp g;
    Function z;

    public i(wp wpVar) {
        this.g = wpVar;
    }

    public i(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.g.cancelRequest());
            case 2:
                return this.g.getUrl();
            case 3:
                return Integer.valueOf(this.g.getWidth());
            case 4:
                return Integer.valueOf(this.g.getHeight());
            case 5:
                return this.g.getScaleType();
            case 6:
                return this.g.getRawCacheKey();
            case 7:
                return this.g.getMemoryCacheKey();
            case 8:
                return this.g.getBitmapConfig();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.m.wp
    public boolean cancelRequest() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.wp
    public Bitmap.Config getBitmapConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Bitmap.Config) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.wp
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getMemoryCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getRawCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.wp
    public ImageView.ScaleType getScaleType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (ImageView.ScaleType) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.wp
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }
}
