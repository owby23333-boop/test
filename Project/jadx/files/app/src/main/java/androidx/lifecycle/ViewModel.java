package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {

    @Nullable
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @MainThread
    final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.mBagOfTags.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException(it.next());
                }
            }
        }
        onCleared();
    }

    <T> T getTag(String str) {
        T t2;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t2 = (T) this.mBagOfTags.get(str);
        }
        return t2;
    }

    protected void onCleared() {
    }

    <T> T setTagIfAbsent(String str, T t2) {
        Object obj;
        synchronized (this.mBagOfTags) {
            obj = this.mBagOfTags.get(str);
            if (obj == null) {
                this.mBagOfTags.put(str, t2);
            }
        }
        if (obj != null) {
            t2 = (T) obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t2);
        }
        return t2;
    }
}
