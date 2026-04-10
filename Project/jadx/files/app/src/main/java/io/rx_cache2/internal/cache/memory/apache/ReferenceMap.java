package io.rx_cache2.internal.cache.memory.apache;

import io.rx_cache2.internal.cache.memory.apache.AbstractReferenceMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ReferenceMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, boolean z2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, z2);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i2, float f2) {
        super(referenceStrength, referenceStrength2, i2, f2, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i2, float f2, boolean z2) {
        super(referenceStrength, referenceStrength2, i2, f2, z2);
    }
}
