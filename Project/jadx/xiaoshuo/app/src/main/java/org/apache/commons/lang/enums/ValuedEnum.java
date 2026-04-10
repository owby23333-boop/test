package org.apache.commons.lang.enums;

import com.iflytek.aikit.media.param.MscKeys;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang.ClassUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ValuedEnum extends Enum {
    private static final long serialVersionUID = -7129650521543789085L;
    private final int iValue;

    public ValuedEnum(String str, int i) {
        super(str);
        this.iValue = i;
    }

    public static Enum getEnum(Class cls, int i) {
        if (cls == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        for (ValuedEnum valuedEnum : Enum.getEnumList(cls)) {
            if (valuedEnum.getValue() == i) {
                return valuedEnum;
            }
        }
        return null;
    }

    private int getValueInOtherClassLoader(Object obj) {
        try {
            return ((Integer) obj.getClass().getMethod("getValue", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    @Override // org.apache.commons.lang.enums.Enum, java.lang.Comparable
    public int compareTo(Object obj) {
        int i;
        int valueInOtherClassLoader;
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() == getClass()) {
            i = this.iValue;
            valueInOtherClassLoader = ((ValuedEnum) obj).iValue;
        } else {
            if (!obj.getClass().getName().equals(getClass().getName())) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Different enum class '");
                stringBuffer.append(ClassUtils.getShortClassName(obj.getClass()));
                stringBuffer.append("'");
                throw new ClassCastException(stringBuffer.toString());
            }
            i = this.iValue;
            valueInOtherClassLoader = getValueInOtherClassLoader(obj);
        }
        return i - valueInOtherClassLoader;
    }

    public final int getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.lang.enums.Enum
    public String toString() {
        if (this.iToString == null) {
            String shortClassName = ClassUtils.getShortClassName(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(shortClassName);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append(MscKeys.KEY_VAL_SEP);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
