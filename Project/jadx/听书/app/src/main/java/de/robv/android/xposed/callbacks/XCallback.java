package de.robv.android.xposed.callbacks;

import android.os.Bundle;
import de.robv.android.xposed.XposedBridge;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class XCallback implements Comparable<XCallback> {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    public static abstract class Param {
        public final Object[] callbacks;
        private Bundle extra;

        public static class SerializeWrapper implements Serializable {
            private static final long serialVersionUID = 1;
            private final Object object;

            public SerializeWrapper(Object obj) {
                this.object = obj;
            }
        }

        @Deprecated
        public Param() {
            this.callbacks = null;
        }

        public Param(XposedBridge.CopyOnWriteSortedSet<? extends XCallback> copyOnWriteSortedSet) {
            this.callbacks = copyOnWriteSortedSet.getSnapshot();
        }

        public synchronized Bundle getExtra() {
            if (this.extra == null) {
                this.extra = new Bundle();
            }
            return this.extra;
        }

        public Object getObjectExtra(String str) {
            Serializable serializable = getExtra().getSerializable(str);
            if (serializable instanceof SerializeWrapper) {
                return ((SerializeWrapper) serializable).object;
            }
            return null;
        }

        public void setObjectExtra(String str, Object obj) {
            getExtra().putSerializable(str, new SerializeWrapper(obj));
        }
    }

    @Deprecated
    public XCallback() {
        this.priority = 50;
    }

    public XCallback(int i) {
        this.priority = i;
    }

    public static void callAll(Param param) {
        if (param.callbacks == null) {
            throw new IllegalStateException("This object was not created for use with callAll");
        }
        int i = 0;
        while (true) {
            Object[] objArr = param.callbacks;
            if (i >= objArr.length) {
                return;
            }
            try {
                ((XCallback) objArr[i]).call(param);
            } catch (Throwable th) {
                XposedBridge.log(th);
            }
            i++;
        }
    }

    public void call(Param param) {
    }

    @Override // java.lang.Comparable
    public int compareTo(XCallback xCallback) {
        if (this == xCallback) {
            return 0;
        }
        int i = xCallback.priority;
        int i2 = this.priority;
        return i != i2 ? i - i2 : System.identityHashCode(this) < System.identityHashCode(xCallback) ? -1 : 1;
    }
}
