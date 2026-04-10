package com.taobao.aranger.core.ipc;

import android.net.Uri;
import android.os.IBinder;
import com.taobao.aranger.core.ipc.channel.BaseClientChannel;
import com.taobao.aranger.core.ipc.channel.BaseRemoteChannel;
import com.taobao.aranger.core.ipc.channel.DefaultClientChannel;
import com.taobao.aranger.core.ipc.channel.MixRemoteChannel;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelManager {
    private static final ConcurrentHashMap<Uri, BaseRemoteChannel> sRemoteChannelMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<IBinder, BaseClientChannel> sClientChannelMap = new ConcurrentHashMap<>();

    public static BaseClientChannel getClientChannel(IBinder iBinder) {
        BaseClientChannel baseClientChannel = sClientChannelMap.get(iBinder);
        if (baseClientChannel != null) {
            return baseClientChannel;
        }
        DefaultClientChannel defaultClientChannel = new DefaultClientChannel(iBinder);
        sClientChannelMap.putIfAbsent(iBinder, defaultClientChannel);
        return defaultClientChannel;
    }

    public static BaseRemoteChannel getRemoteChannel(Uri uri) {
        BaseRemoteChannel baseRemoteChannel = sRemoteChannelMap.get(uri);
        if (baseRemoteChannel != null) {
            return baseRemoteChannel;
        }
        MixRemoteChannel mixRemoteChannel = new MixRemoteChannel(uri);
        sRemoteChannelMap.putIfAbsent(uri, mixRemoteChannel);
        return mixRemoteChannel;
    }
}
