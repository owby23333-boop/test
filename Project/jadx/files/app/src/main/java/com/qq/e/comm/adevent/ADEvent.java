package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes3.dex */
public class ADEvent {
    private final int a;
    private final Object[] b;

    public ADEvent(int i2, Object... objArr) {
        this.a = i2;
        this.b = objArr;
        if (i2 < 100) {
            a("EventId 错误" + i2);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i2, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.b) == null || objArr.length <= i2) {
            return null;
        }
        T t2 = (T) objArr[i2];
        if (t2 == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.a);
            return null;
        }
        if (cls.isInstance(objArr[i2])) {
            return t2;
        }
        GDTLogger.e("ADEvent" + this.a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t2.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.a;
    }
}
