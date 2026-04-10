package com.market.pm.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import com.market.ServiceProxy;
import com.market.pm.IMarketInstallerService;
import com.market.pm.api.MarketInstallObserver;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MarketInstallerService extends ServiceProxy implements IMarketInstallerService, IMarketInstallerContract {
    private IMarketInstallerService mService;

    private MarketInstallerService(Context context, Intent intent) {
        super(context, intent);
    }

    public static IMarketInstallerService openService(Context context) throws ComponentNotFoundException {
        Intent intent = new Intent(IMarketInstallerContract.ACTION);
        intent.setPackage(IMarketInstallerContract.MARKET_PACKAGE);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || !listQueryIntentServices.isEmpty()) {
            return new MarketInstallerService(context, intent);
        }
        throw new ComponentNotFoundException("Not found MarketInstallerService");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.market.pm.IMarketInstallerService
    public void installPackage(final Uri uri, final ResultReceiver resultReceiver, final Bundle bundle) throws RemoteException {
        setTask(new ServiceProxy.ProxyTask() { // from class: com.market.pm.api.MarketInstallerService.1
            @Override // com.market.ServiceProxy.ProxyTask
            public void run() throws RemoteException {
                if (MarketInstallerService.this.mService == null) {
                    return;
                }
                try {
                    MarketInstallerService.this.mService.installPackage(uri, resultReceiver, bundle);
                } catch (RemoteException e) {
                    Log.w(((ServiceProxy) MarketInstallerService.this).mTag, "fail install package", e);
                    ResultReceiver resultReceiver2 = resultReceiver;
                    if (resultReceiver2 instanceof MarketInstallObserver) {
                        new MarketInstallObserver.Proxy(resultReceiver2).onServiceDead();
                    }
                    throw e;
                }
            }
        }, "installPackage");
    }

    @Override // com.market.ServiceProxy
    public void onConnected(IBinder iBinder) {
        this.mService = IMarketInstallerService.Stub.asInterface(iBinder);
    }

    @Override // com.market.ServiceProxy
    public void onDisconnected() {
    }
}
