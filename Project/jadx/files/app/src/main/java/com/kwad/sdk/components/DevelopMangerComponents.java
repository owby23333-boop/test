package com.kwad.sdk.components;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public interface DevelopMangerComponents extends a {

    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public <T> T getValue() {
            T t2 = (T) this.mValue;
            if (t2 != null) {
                return t2;
            }
            return null;
        }
    }

    String tZ();
}
