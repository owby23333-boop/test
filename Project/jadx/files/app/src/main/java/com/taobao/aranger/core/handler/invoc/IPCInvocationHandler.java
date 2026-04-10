package com.taobao.aranger.core.handler.invoc;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.annotation.parameter.inout;
import com.taobao.aranger.annotation.parameter.out;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IDataFlow;
import com.taobao.aranger.logs.IPCLog;
import com.taobao.aranger.utils.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class IPCInvocationHandler implements InvocationHandler {
    private static final String TAG = IPCInvocationHandler.class.getName();

    IPCInvocationHandler() {
    }

    private Object processReply(Reply reply, Method method, Object[] objArr) throws IPCException {
        if (reply.getFlowParameterWrappers() != null && reply.getFlowParameterWrappers().length != 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            int i2 = 0;
            for (int i3 = 0; i3 < objArr.length; i3++) {
                try {
                    if (TypeUtils.arrayContainsAnnotation(parameterAnnotations[i3], out.class) || TypeUtils.arrayContainsAnnotation(parameterAnnotations[i3], inout.class)) {
                        int i4 = i2 + 1;
                        Object data = reply.getFlowParameterWrappers()[i2].getData();
                        if (objArr[i3] == null) {
                            objArr[i3] = data;
                        } else if (parameterTypes[i3].isArray()) {
                            TypeUtils.convertObjectToArray(parameterTypes[i3].getName(), objArr[i3], data);
                        } else if (List.class.isAssignableFrom(parameterTypes[i3])) {
                            Collections.copy((List) objArr[i3], (List) data);
                        } else if (Map.class.isAssignableFrom(parameterTypes[i3])) {
                            Map map = (Map) data;
                            Map map2 = (Map) objArr[i3];
                            map2.clear();
                            if (map != null) {
                                for (Map.Entry entry : map.entrySet()) {
                                    map2.put(entry.getKey(), entry.getValue());
                                }
                            }
                        } else if (IDataFlow.class.isAssignableFrom(parameterTypes[i3])) {
                            ((IDataFlow) objArr[i3]).readFromObject(data);
                        } else if (Parcelable.class.isAssignableFrom(parameterTypes[i3])) {
                            Method declaredMethod = parameterTypes[i3].getDeclaredMethod("readFromParcel", Parcel.class);
                            declaredMethod.setAccessible(true);
                            Parcel parcelObtain = Parcel.obtain();
                            ((Parcelable) data).writeToParcel(parcelObtain, 0);
                            parcelObtain.setDataPosition(0);
                            declaredMethod.invoke(objArr[i3], parcelObtain);
                            parcelObtain.recycle();
                        }
                        i2 = i4;
                    }
                } catch (Exception e2) {
                    IPCLog.e(TAG, "[processReply]", e2, new Object[0]);
                    throw new IPCException(26, e2);
                }
            }
        }
        return reply.getResult();
    }

    abstract Reply internalInvoke(Method method, Object[] objArr) throws IPCException;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws IPCException {
        if (method.getDeclaringClass() != Object.class) {
            return processReply(internalInvoke(method, objArr), method, objArr);
        }
        try {
            return method.invoke(this, objArr);
        } catch (Exception e2) {
            throw new IPCException(18, e2);
        }
    }
}
