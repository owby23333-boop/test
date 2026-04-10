package io.rx_cache2.internal;

import io.rx_cache2.Source;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Record<T> {
    private final T data;
    private final String dataClassName;
    private final String dataCollectionClassName;
    private final String dataKeyMapClassName;
    private Boolean expirable;
    private Long lifeTime;
    private transient float sizeOnMb;
    private Source source;
    private final long timeAtWhichWasPersisted;

    Record(T t2) {
        this(t2, true, null);
    }

    public T getData() {
        return this.data;
    }

    public String getDataClassName() {
        return this.dataClassName;
    }

    public String getDataCollectionClassName() {
        return this.dataCollectionClassName;
    }

    public String getDataKeyMapClassName() {
        return this.dataKeyMapClassName;
    }

    public Boolean getExpirable() {
        return this.expirable;
    }

    public Long getLifeTime() {
        return this.lifeTime;
    }

    public float getSizeOnMb() {
        return this.sizeOnMb;
    }

    public Source getSource() {
        return this.source;
    }

    public long getTimeAtWhichWasPersisted() {
        return this.timeAtWhichWasPersisted;
    }

    public void setExpirable(Boolean bool) {
        this.expirable = bool;
    }

    public void setLifeTime(Long l2) {
        this.lifeTime = l2;
    }

    public void setSizeOnMb(float f2) {
        this.sizeOnMb = f2;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Record() {
        this.data = null;
        this.timeAtWhichWasPersisted = 0L;
        this.dataClassName = null;
        this.dataCollectionClassName = null;
        this.dataKeyMapClassName = null;
        this.expirable = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Record(T t2, Boolean bool, Long l2) {
        this.data = t2;
        this.expirable = bool;
        this.lifeTime = l2;
        this.timeAtWhichWasPersisted = System.currentTimeMillis();
        this.source = Source.MEMORY;
        boolean zIsAssignableFrom = Collection.class.isAssignableFrom(t2.getClass());
        boolean zIsArray = t2.getClass().isArray();
        boolean zIsAssignableFrom2 = Map.class.isAssignableFrom(t2.getClass());
        if (zIsAssignableFrom) {
            this.dataKeyMapClassName = null;
            List list = (List) t2;
            if (list.size() > 0) {
                this.dataCollectionClassName = List.class.getName();
                this.dataClassName = list.get(0).getClass().getName();
                return;
            } else {
                this.dataClassName = null;
                this.dataCollectionClassName = null;
                return;
            }
        }
        if (zIsArray) {
            this.dataKeyMapClassName = null;
            Object[] objArr = (Object[]) t2;
            if (objArr.length > 0) {
                this.dataClassName = objArr[0].getClass().getName();
                this.dataCollectionClassName = t2.getClass().getName();
                return;
            } else {
                this.dataClassName = null;
                this.dataCollectionClassName = null;
                return;
            }
        }
        if (zIsAssignableFrom2) {
            Map map = (Map) t2;
            if (map.size() > 0) {
                this.dataCollectionClassName = Map.class.getName();
                Iterator it = map.entrySet().iterator();
                Map.Entry entry = (Map.Entry) it.next();
                Class<?> cls = entry.getValue().getClass();
                Class<?> cls2 = entry.getKey().getClass();
                while (true) {
                    if (!it.hasNext() && (cls != null || cls2 != null)) {
                        break;
                    }
                    Map.Entry entry2 = (Map.Entry) it.next();
                    if (cls2 != null && cls2 != entry2.getKey().getClass()) {
                        cls2 = null;
                    }
                    if (cls != null && cls != entry2.getValue().getClass()) {
                        cls = null;
                    }
                }
                this.dataClassName = cls != null ? cls.getName() : null;
                this.dataKeyMapClassName = cls2 != null ? cls2.getName() : null;
                return;
            }
            this.dataClassName = null;
            this.dataCollectionClassName = null;
            this.dataKeyMapClassName = null;
            return;
        }
        this.dataKeyMapClassName = null;
        this.dataClassName = t2.getClass().getName();
        this.dataCollectionClassName = null;
    }
}
