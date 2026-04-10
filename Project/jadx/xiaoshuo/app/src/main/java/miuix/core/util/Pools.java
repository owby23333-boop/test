package miuix.core.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import miuix.core.util.concurrent.ConcurrentRingQueue;

/* JADX INFO: loaded from: classes7.dex */
public final class Pools {
    private static final HashMap<Class<?>, InstanceHolder<?>> mInstanceHolderMap = new HashMap<>();
    private static final HashMap<Class<?>, SoftReferenceInstanceHolder<?>> mSoftReferenceInstanceHolderMap = new HashMap<>();
    private static final Pool<StringBuilder> mStringBuilderPool = createSoftReferencePool(new Manager<StringBuilder>() { // from class: miuix.core.util.Pools.1
        @Override // miuix.core.util.Pools.Manager
        public StringBuilder createInstance() {
            return new StringBuilder();
        }

        @Override // miuix.core.util.Pools.Manager
        public void onRelease(StringBuilder sb) {
            sb.setLength(0);
        }
    }, 4);

    public static abstract class BasePool<T> implements Pool<T> {
        private final Object mFinalizeGuardian;
        private IInstanceHolder<T> mInstanceHolder;
        private final Manager<T> mManager;
        private final int mSize;

        public BasePool(Manager<T> manager, int i) {
            Object obj = new Object() { // from class: miuix.core.util.Pools.BasePool.1
                public void finalize() throws Throwable {
                    try {
                        BasePool.this.close();
                    } finally {
                        super.finalize();
                    }
                }
            };
            this.mFinalizeGuardian = obj;
            if (manager == null || i < 1) {
                this.mSize = obj.hashCode();
                throw new IllegalArgumentException("manager cannot be null and size cannot less then 1");
            }
            this.mManager = manager;
            this.mSize = i;
            T tCreateInstance = manager.createInstance();
            if (tCreateInstance == null) {
                throw new IllegalStateException("manager create instance cannot return null");
            }
            this.mInstanceHolder = createInstanceHolder(tCreateInstance.getClass(), i);
            doRelease(tCreateInstance);
        }

        @Override // miuix.core.util.Pools.Pool
        public T acquire() {
            return doAcquire();
        }

        @Override // miuix.core.util.Pools.Pool
        public void close() {
            IInstanceHolder<T> iInstanceHolder = this.mInstanceHolder;
            if (iInstanceHolder != null) {
                destroyInstanceHolder(iInstanceHolder, this.mSize);
                this.mInstanceHolder = null;
            }
        }

        public abstract IInstanceHolder<T> createInstanceHolder(Class<T> cls, int i);

        public abstract void destroyInstanceHolder(IInstanceHolder<T> iInstanceHolder, int i);

        public final T doAcquire() {
            IInstanceHolder<T> iInstanceHolder = this.mInstanceHolder;
            if (iInstanceHolder == null) {
                throw new IllegalStateException("Cannot acquire object after close()");
            }
            T tCreateInstance = iInstanceHolder.get();
            if (tCreateInstance == null && (tCreateInstance = this.mManager.createInstance()) == null) {
                throw new IllegalStateException("manager create instance cannot return null");
            }
            this.mManager.onAcquire(tCreateInstance);
            return tCreateInstance;
        }

        public final void doRelease(T t) {
            if (this.mInstanceHolder == null) {
                throw new IllegalStateException("Cannot release object after close()");
            }
            if (t == null) {
                return;
            }
            this.mManager.onRelease(t);
            if (this.mInstanceHolder.put(t)) {
                return;
            }
            this.mManager.onDestroy(t);
        }

        @Override // miuix.core.util.Pools.Pool
        public int getSize() {
            if (this.mInstanceHolder == null) {
                return 0;
            }
            return this.mSize;
        }

        @Override // miuix.core.util.Pools.Pool
        public void release(T t) {
            doRelease(t);
        }
    }

    public interface IInstanceHolder<T> {
        T get();

        Class<T> getElementClass();

        int getSize();

        boolean put(T t);

        void resize(int i);
    }

    public static class InstanceHolder<T> implements IInstanceHolder<T> {
        private final Class<T> mClazz;
        private final ConcurrentRingQueue<T> mQueue;

        public InstanceHolder(Class<T> cls, int i) {
            this.mClazz = cls;
            this.mQueue = new ConcurrentRingQueue<>(i, false, true);
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public T get() {
            return this.mQueue.get();
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public Class<T> getElementClass() {
            return this.mClazz;
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public int getSize() {
            return this.mQueue.getCapacity();
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public boolean put(T t) {
            return this.mQueue.put(t);
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public synchronized void resize(int i) {
            int capacity = i + this.mQueue.getCapacity();
            if (capacity <= 0) {
                synchronized (Pools.mInstanceHolderMap) {
                    Pools.mInstanceHolderMap.remove(getElementClass());
                }
            } else {
                if (capacity > 0) {
                    this.mQueue.increaseCapacity(capacity);
                } else {
                    this.mQueue.decreaseCapacity(-capacity);
                }
            }
        }
    }

    public static abstract class Manager<T> {
        public abstract T createInstance();

        public void onAcquire(T t) {
        }

        public void onDestroy(T t) {
        }

        public void onRelease(T t) {
        }
    }

    public interface Pool<T> {
        T acquire();

        void close();

        int getSize();

        void release(T t);
    }

    public static class SimplePool<T> extends BasePool<T> {
        public SimplePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ Object acquire() {
            return super.acquire();
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ void close() {
            super.close();
        }

        @Override // miuix.core.util.Pools.BasePool
        public final IInstanceHolder<T> createInstanceHolder(Class<T> cls, int i) {
            return Pools.onPoolCreate(cls, i);
        }

        @Override // miuix.core.util.Pools.BasePool
        public final void destroyInstanceHolder(IInstanceHolder<T> iInstanceHolder, int i) {
            Pools.onPoolClose((InstanceHolder) iInstanceHolder, i);
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ int getSize() {
            return super.getSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ void release(Object obj) {
            super.release(obj);
        }
    }

    public static class SoftReferenceInstanceHolder<T> implements IInstanceHolder<T> {
        private final Class<T> mClazz;
        private volatile SoftReference<T>[] mElements;
        private volatile int mIndex = 0;
        private volatile int mSize;

        public SoftReferenceInstanceHolder(Class<T> cls, int i) {
            this.mClazz = cls;
            this.mSize = i;
            this.mElements = new SoftReference[i];
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public synchronized T get() {
            int i = this.mIndex;
            SoftReference<T>[] softReferenceArr = this.mElements;
            while (i != 0) {
                i--;
                SoftReference<T> softReference = softReferenceArr[i];
                if (softReference != null) {
                    T t = softReference.get();
                    softReferenceArr[i] = null;
                    if (t != null) {
                        this.mIndex = i;
                        return t;
                    }
                }
            }
            return null;
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public Class<T> getElementClass() {
            return this.mClazz;
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public int getSize() {
            return this.mSize;
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public synchronized boolean put(T t) {
            int i;
            int i2 = this.mIndex;
            SoftReference<T>[] softReferenceArr = this.mElements;
            if (i2 < this.mSize) {
                softReferenceArr[i2] = new SoftReference<>(t);
                this.mIndex = i2 + 1;
                return true;
            }
            for (0; i < i2; i + 1) {
                SoftReference<T> softReference = softReferenceArr[i];
                i = (softReference == null || softReference.get() == null) ? 0 : i + 1;
                softReferenceArr[i] = new SoftReference<>(t);
                return true;
            }
            return false;
        }

        @Override // miuix.core.util.Pools.IInstanceHolder
        public synchronized void resize(int i) {
            int i2 = i + this.mSize;
            if (i2 <= 0) {
                synchronized (Pools.mSoftReferenceInstanceHolderMap) {
                    Pools.mSoftReferenceInstanceHolderMap.remove(getElementClass());
                }
                return;
            }
            this.mSize = i2;
            SoftReference<T>[] softReferenceArr = this.mElements;
            int i3 = this.mIndex;
            if (i2 > softReferenceArr.length) {
                SoftReference<T>[] softReferenceArr2 = new SoftReference[i2];
                System.arraycopy(softReferenceArr, 0, softReferenceArr2, 0, i3);
                this.mElements = softReferenceArr2;
            }
        }
    }

    public static class SoftReferencePool<T> extends BasePool<T> {
        public SoftReferencePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ Object acquire() {
            return super.acquire();
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ void close() {
            super.close();
        }

        @Override // miuix.core.util.Pools.BasePool
        public final IInstanceHolder<T> createInstanceHolder(Class<T> cls, int i) {
            return Pools.onSoftReferencePoolCreate(cls, i);
        }

        @Override // miuix.core.util.Pools.BasePool
        public final void destroyInstanceHolder(IInstanceHolder<T> iInstanceHolder, int i) {
            Pools.onSoftReferencePoolClose((SoftReferenceInstanceHolder) iInstanceHolder, i);
        }

        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ int getSize() {
            return super.getSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // miuix.core.util.Pools.BasePool, miuix.core.util.Pools.Pool
        public /* bridge */ /* synthetic */ void release(Object obj) {
            super.release(obj);
        }
    }

    public static <T> SimplePool<T> createSimplePool(Manager<T> manager, int i) {
        return new SimplePool<>(manager, i);
    }

    public static <T> SoftReferencePool<T> createSoftReferencePool(Manager<T> manager, int i) {
        return new SoftReferencePool<>(manager, i);
    }

    public static Pool<StringBuilder> getStringBuilderPool() {
        return mStringBuilderPool;
    }

    public static <T> void onPoolClose(InstanceHolder<T> instanceHolder, int i) {
        synchronized (mInstanceHolderMap) {
            instanceHolder.resize(-i);
        }
    }

    public static <T> InstanceHolder<T> onPoolCreate(Class<T> cls, int i) {
        IInstanceHolder iInstanceHolder;
        HashMap<Class<?>, InstanceHolder<?>> map = mInstanceHolderMap;
        synchronized (map) {
            iInstanceHolder = (InstanceHolder<T>) map.get(cls);
            if (iInstanceHolder == null) {
                iInstanceHolder = (InstanceHolder<T>) new InstanceHolder(cls, i);
                map.put((Class<?>) cls, (InstanceHolder<?>) iInstanceHolder);
            } else {
                iInstanceHolder.resize(i);
            }
        }
        return (InstanceHolder<T>) iInstanceHolder;
    }

    public static <T> void onSoftReferencePoolClose(SoftReferenceInstanceHolder<T> softReferenceInstanceHolder, int i) {
        synchronized (mSoftReferenceInstanceHolderMap) {
            softReferenceInstanceHolder.resize(-i);
        }
    }

    public static <T> SoftReferenceInstanceHolder<T> onSoftReferencePoolCreate(Class<T> cls, int i) {
        IInstanceHolder iInstanceHolder;
        HashMap<Class<?>, SoftReferenceInstanceHolder<?>> map = mSoftReferenceInstanceHolderMap;
        synchronized (map) {
            iInstanceHolder = (SoftReferenceInstanceHolder<T>) map.get(cls);
            if (iInstanceHolder == null) {
                iInstanceHolder = (SoftReferenceInstanceHolder<T>) new SoftReferenceInstanceHolder(cls, i);
                map.put((Class<?>) cls, (SoftReferenceInstanceHolder<?>) iInstanceHolder);
            } else {
                iInstanceHolder.resize(i);
            }
        }
        return (SoftReferenceInstanceHolder<T>) iInstanceHolder;
    }
}
