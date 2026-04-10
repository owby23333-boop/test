package com.taobao.aranger.core.handler.invoc;

import android.net.Uri;
import com.taobao.aranger.annotation.method.oneway;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.adapter.impl.InvokeMethodWrapperAdapter;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.ChannelManager;
import com.taobao.aranger.core.ipc.channel.BaseRemoteChannel;
import com.taobao.aranger.core.wrapper.ObjectWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.ParameterTransformer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class MethodInvocationHandler extends IPCInvocationHandler {
    private final BaseRemoteChannel mBaseRemoteChannel;
    private final InvokeMethodWrapperAdapter mInvokeMethodAdapter;
    private final ObjectWrapper mObjectWrapper;
    private final Uri mRemoteProviderUri;

    public MethodInvocationHandler(ObjectWrapper objectWrapper, Uri uri) {
        this.mObjectWrapper = objectWrapper;
        this.mRemoteProviderUri = uri;
        this.mObjectWrapper.setType(3);
        this.mInvokeMethodAdapter = new InvokeMethodWrapperAdapter();
        this.mBaseRemoteChannel = ChannelManager.getRemoteChannel(this.mRemoteProviderUri);
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler
    public Reply internalInvoke(Method method, Object[] objArr) throws IPCException {
        ParameterWrapper[] parameterWrapperArrWrapperParameters = ParameterTransformer.wrapperParameters(method, objArr);
        return this.mBaseRemoteChannel.sendCall(Call.obtain().setObjectWrapper(this.mObjectWrapper).setParameterWrappers(parameterWrapperArrWrapperParameters).setMethodWrapper(this.mInvokeMethodAdapter.setMethod(method).wrapperMethod(parameterWrapperArrWrapperParameters)).setRemoteProviderUri(this.mRemoteProviderUri).setOneWay(method.getAnnotation(oneway.class) != null && Constants.VOID.equals(method.getReturnType().getName())));
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler, java.lang.reflect.InvocationHandler
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) throws IPCException {
        return super.invoke(obj, method, objArr);
    }
}
