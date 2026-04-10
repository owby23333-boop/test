package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final SimpleArrayMap<String, i> a = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, PropertyValuesHolder[]> b = new SimpleArrayMap<>();

    public void a(String str, @Nullable i iVar) {
        this.a.put(str, iVar);
    }

    public i b(String str) {
        if (d(str)) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public boolean d(String str) {
        return this.a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.a.equals(((h) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }

    @NonNull
    public PropertyValuesHolder[] a(String str) {
        if (c(str)) {
            return a(this.b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public void a(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.b.put(str, propertyValuesHolderArr);
    }

    @NonNull
    private PropertyValuesHolder[] a(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    @NonNull
    public <T> ObjectAnimator a(@NonNull String str, @NonNull T t2, @NonNull Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t2, a(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        b(str).a((Animator) objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public long a() {
        int size = this.a.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i iVarValueAt = this.a.valueAt(i2);
            jMax = Math.max(jMax, iVarValueAt.a() + iVarValueAt.b());
        }
        return jMax;
    }

    @Nullable
    public static h a(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return a(context, resourceId);
    }

    @Nullable
    public static h a(@NonNull Context context, @AnimatorRes int i2) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return a(arrayList);
        } catch (Exception unused) {
            String str = "Can't load animation resource ID #0x" + Integer.toHexString(i2);
            return null;
        }
    }

    @NonNull
    private static h a(@NonNull List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, list.get(i2));
        }
        return hVar;
    }

    private static void a(@NonNull h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }
}
