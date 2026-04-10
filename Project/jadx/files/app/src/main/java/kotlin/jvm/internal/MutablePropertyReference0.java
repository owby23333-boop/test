package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        k.a(this);
        return this;
    }

    @Override // kotlin.reflect.KProperty0
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.b.a
    public Object invoke() {
        return get();
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty0
    public KProperty0.a getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public KMutableProperty0.a getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
