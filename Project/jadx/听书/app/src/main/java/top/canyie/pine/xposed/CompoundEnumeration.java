package top.canyie.pine.xposed;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class CompoundEnumeration<E> implements Enumeration<E> {
    private Enumeration<E>[] enums;
    private int index = 0;

    public CompoundEnumeration(Enumeration<E>[] enumerationArr) {
        this.enums = enumerationArr;
    }

    private boolean next() {
        while (true) {
            int i = this.index;
            Enumeration<E>[] enumerationArr = this.enums;
            if (i >= enumerationArr.length) {
                return false;
            }
            Enumeration<E> enumeration = enumerationArr[i];
            if (enumeration != null && enumeration.hasMoreElements()) {
                return true;
            }
            this.index++;
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return next();
    }

    @Override // java.util.Enumeration
    public E nextElement() {
        if (next()) {
            return this.enums[this.index].nextElement();
        }
        throw new NoSuchElementException();
    }
}
