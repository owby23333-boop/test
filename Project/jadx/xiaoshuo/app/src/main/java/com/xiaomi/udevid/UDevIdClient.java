package com.xiaomi.udevid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.accountsdk.account.AccountIntent;
import com.xiaomi.accountsdk.futureservice.ClientFuture;
import com.xiaomi.accountsdk.futureservice.ServerServiceConnector;
import com.xiaomi.accountsdk.futureservice.SimpleClientFuture;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.xiaomi.udevid.IUDevIdService;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes8.dex */
public class UDevIdClient {
    private static final String TAG = "UDevIdClient";

    public static abstract class ConnectorBase<T> extends ServerServiceConnector<IUDevIdService, T, T> {
        private ConnectorBase(Context context, ClientFuture<T, T> clientFuture) {
            super(context, AccountIntent.ACTION_UDEVID_SERVICE, AccountIntent.PACKAGE_XIAOMI_ACCOUNT, clientFuture);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaomi.accountsdk.futureservice.ServerServiceConnector
        public final IUDevIdService binderToServiceType(IBinder iBinder) {
            return IUDevIdService.Stub.asInterface(iBinder);
        }
    }

    private static boolean checkServiceAvailable(Context context) {
        Intent intent = new Intent(AccountIntent.ACTION_UDEVID_SERVICE);
        intent.setPackage(AccountIntent.PACKAGE_XIAOMI_ACCOUNT);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            return true;
        }
        AccountLogger.log(TAG, "component not found");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getUDevIdFromSystemAccount(Context context) throws UDevIdServiceNotAvailableException, ExecutionException, UDevIdNullException, InterruptedException {
        if (!checkServiceAvailable(context)) {
            throw new UDevIdServiceNotAvailableException("UDevIdService is not available");
        }
        SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
        new ConnectorBase<Bundle>(context, simpleClientFuture) { // from class: com.xiaomi.udevid.UDevIdClient.1
            @Override // com.xiaomi.accountsdk.futureservice.ServerServiceConnector
            public Bundle callServiceWork() throws RemoteException {
                return getIService().getUDevIdFromSystemAccount(new Bundle());
            }
        }.bind();
        String string = ((Bundle) simpleClientFuture.get()).getString(Constants.UDEVID);
        if (string != null) {
            return string;
        }
        throw new UDevIdNullException("UDevId is null");
    }
}
