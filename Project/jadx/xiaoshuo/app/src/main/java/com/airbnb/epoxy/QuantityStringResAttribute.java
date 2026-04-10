package com.airbnb.epoxy;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class QuantityStringResAttribute {

    @Nullable
    private final Object[] formatArgs;

    @PluralsRes
    private final int id;
    private final int quantity;

    public QuantityStringResAttribute(@PluralsRes int i, int i2, @Nullable Object[] objArr) {
        this.quantity = i2;
        this.id = i;
        this.formatArgs = objArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuantityStringResAttribute)) {
            return false;
        }
        QuantityStringResAttribute quantityStringResAttribute = (QuantityStringResAttribute) obj;
        if (this.id == quantityStringResAttribute.id && this.quantity == quantityStringResAttribute.quantity) {
            return Arrays.equals(this.formatArgs, quantityStringResAttribute.formatArgs);
        }
        return false;
    }

    @Nullable
    public Object[] getFormatArgs() {
        return this.formatArgs;
    }

    @PluralsRes
    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        return (((this.id * 31) + this.quantity) * 31) + Arrays.hashCode(this.formatArgs);
    }

    public CharSequence toString(Context context) {
        Object[] objArr = this.formatArgs;
        return (objArr == null || objArr.length == 0) ? context.getResources().getQuantityString(this.id, this.quantity) : context.getResources().getQuantityString(this.id, this.quantity, this.formatArgs);
    }

    public QuantityStringResAttribute(int i, int i2) {
        this(i, i2, null);
    }
}
