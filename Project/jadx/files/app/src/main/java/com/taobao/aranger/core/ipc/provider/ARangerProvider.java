package com.taobao.aranger.core.ipc.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.IContentProvider;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.handler.reply.ReplyHandlerFactory;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import com.taobao.aranger.logs.IPCLog;
import com.taobao.aranger.utils.IPCThreadCaller;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ObjectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class ARangerProvider extends ContentProvider implements IRemoteService {
    private static final String TAG = ARangerProvider.class.getSimpleName();
    private static final AtomicBoolean isConnectFlag = new AtomicBoolean(false);
    private final RemoteService mRemoteService = new RemoteService();

    private class RemoteService extends Binder implements IContentProvider {
        /* JADX WARN: Multi-variable type inference failed */
        RemoteService() {
            attachInterface(this, Constants.DEFAULT_CONTENT_DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i2, @NonNull Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 0) {
                final Call callCreateFromParcel = Call.CREATOR.createFromParcel(parcel);
                if (i3 == 1) {
                    IPCThreadCaller.execute(new Runnable() { // from class: com.taobao.aranger.core.ipc.provider.ARangerProvider.RemoteService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ARangerProvider.this.sendCall(callCreateFromParcel);
                            } catch (Exception e2) {
                                IPCLog.e(ARangerProvider.TAG, "[onTransact][sendCall]", e2, new Object[0]);
                            }
                        }
                    });
                } else {
                    try {
                        Reply replySendCall = ARangerProvider.this.sendCall(callCreateFromParcel);
                        if (!Constants.VOID.equals(callCreateFromParcel.getMethodWrapper().getReturnType()) || replySendCall.isError() || replySendCall.getFlowParameterWrappers() != null) {
                            replySendCall.writeToParcel(parcel2, 0);
                        }
                    } catch (Exception e2) {
                        Reply.obtain().setErrorCode(10).setErrorMessage(e2.getMessage()).writeToParcel(parcel2, i3);
                    }
                }
                return true;
            }
            if (i2 == 1) {
                final ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                IPCThreadCaller.execute(new Runnable() { // from class: com.taobao.aranger.core.ipc.provider.ARangerProvider.RemoteService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ARangerProvider.this.recycle(arrayListCreateStringArrayList);
                        } catch (Exception e3) {
                            IPCLog.e(ARangerProvider.TAG, "[onTransact][recycle]", e3, new Object[0]);
                        }
                    }
                });
                return true;
            }
            if (i2 != 21) {
                return true;
            }
            parcel.enforceInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR);
            if (Build.VERSION.SDK_INT > 17) {
                parcel.readString();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                parcel.readString();
            }
            Bundle bundleCall = ARangerProvider.this.call(parcel.readString(), parcel.readString(), parcel.readBundle(RemoteService.class.getClassLoader()));
            parcel2.writeNoException();
            parcel2.writeBundle(bundleCall);
            return true;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // android.content.ContentProvider
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle call(java.lang.String r7, java.lang.String r8, android.os.Bundle r9) {
        /*
            r6 = this;
            java.lang.String r8 = "reply"
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            int r1 = r7.hashCode()
            r2 = 3045982(0x2e7a5e, float:4.26833E-39)
            r3 = 0
            java.lang.String r4 = "call"
            r5 = 1
            if (r1 == r2) goto L24
            r2 = 1930954610(0x73180772, float:1.2044985E31)
            if (r1 == r2) goto L1a
            goto L2c
        L1a:
            java.lang.String r1 = "recycle_remote"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L2c
            r7 = 1
            goto L2d
        L24:
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L2c
            r7 = 0
            goto L2d
        L2c:
            r7 = -1
        L2d:
            if (r7 == 0) goto L41
            if (r7 == r5) goto L32
            goto L77
        L32:
            java.lang.String r7 = "keys"
            java.util.ArrayList r7 = r9.getStringArrayList(r7)
            com.taobao.aranger.core.ipc.provider.ARangerProvider$1 r8 = new com.taobao.aranger.core.ipc.provider.ARangerProvider$1
            r8.<init>()
            com.taobao.aranger.utils.IPCThreadCaller.execute(r8)
            goto L77
        L41:
            java.lang.Class<com.taobao.aranger.ARanger> r7 = com.taobao.aranger.ARanger.class
            java.lang.ClassLoader r7 = r7.getClassLoader()
            r9.setClassLoader(r7)
            android.os.Parcelable r7 = r9.getParcelable(r4)
            com.taobao.aranger.core.entity.Call r7 = (com.taobao.aranger.core.entity.Call) r7
            com.taobao.aranger.core.entity.Reply r7 = r6.sendCall(r7)     // Catch: java.lang.Exception -> L58
            r0.putParcelable(r8, r7)     // Catch: java.lang.Exception -> L58
            goto L77
        L58:
            r7 = move-exception
            java.lang.String r9 = com.taobao.aranger.core.ipc.provider.ARangerProvider.TAG
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "[call][sendCall]"
            com.taobao.aranger.logs.IPCLog.e(r9, r2, r7, r1)
            com.taobao.aranger.core.entity.Reply r9 = com.taobao.aranger.core.entity.Reply.obtain()
            r1 = 10
            com.taobao.aranger.core.entity.Reply r9 = r9.setErrorCode(r1)
            java.lang.String r7 = r7.getMessage()
            com.taobao.aranger.core.entity.Reply r7 = r9.setErrorMessage(r7)
            r0.putParcelable(r8, r7)
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.aranger.core.ipc.provider.ARangerProvider.call(java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public void connect() {
        if (isConnectFlag.compareAndSet(false, true)) {
            IPCThreadCaller.execute(new Runnable() { // from class: com.taobao.aranger.core.ipc.provider.ARangerProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Constants.ACTION_CONNECT);
                        intent.putExtra(Constants.PARAM_PROCESS_NAME, IPCUtils.getCurrentProcessName());
                        ARanger.getContext().sendBroadcast(intent);
                    } catch (Throwable th) {
                        IPCLog.e(ARangerProvider.TAG, "[connect][sendBroadcast]", th, new Object[0]);
                    }
                }
            });
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Keep
    public IContentProvider getIContentProvider() {
        return this.mRemoteService;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public boolean isRemote() {
        return false;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        connect();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) {
        ObjectCenter.getInstance().deleteObjects(list);
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public Reply sendCall(Call call) {
        try {
            return ReplyHandlerFactory.createReplyHandler(call).handleReply();
        } catch (Exception e2) {
            IPCLog.e(TAG, "[sendCall][handleReply]", e2, new Object[0]);
            return e2 instanceof IPCException ? Reply.obtain().setErrorCode(((IPCException) e2).getErrorCode()).setErrorMessage(e2.getMessage()) : Reply.obtain().setErrorCode(11).setErrorMessage(e2.getMessage());
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
