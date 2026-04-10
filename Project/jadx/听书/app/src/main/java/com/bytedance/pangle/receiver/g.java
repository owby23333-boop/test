package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static g g;
    private final Map<String, z> dl = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<PluginBroadcastReceiver, BroadcastReceiver> f527a = new ConcurrentHashMap();
    public final Set<Integer> z = new CopyOnWriteArraySet();

    public static class z {
        public final Set<PluginBroadcastReceiver> g = new CopyOnWriteArraySet();
        public String z;

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.g.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.g.size() > 0) {
                        this.g.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.z + "[exception]:", th);
                }
            }
        }

        public void z(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.g;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.g) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }
    }

    private g() {
    }

    public static g z() {
        if (g == null) {
            synchronized (com.bytedance.pangle.service.z.z.class) {
                if (g == null) {
                    g = new g();
                }
            }
        }
        return g;
    }

    public boolean z(int i) {
        return this.z.contains(Integer.valueOf(i));
    }

    private void z(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> itActionsIterator = intentFilter.actionsIterator();
        while (itActionsIterator.hasNext()) {
            String next = itActionsIterator.next();
            if (next != null) {
                z zVar = this.dl.get(next);
                if (zVar != null) {
                    zVar.registerReceiver(pluginBroadcastReceiver);
                } else {
                    z zVar2 = new z();
                    zVar2.z = next;
                    zVar2.registerReceiver(pluginBroadcastReceiver);
                    this.dl.put(next, zVar2);
                }
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter);
        }
        this.f527a.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        z(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler);
        }
        this.f527a.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.z.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        z(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, i);
        this.f527a.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        z(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, i);
        this.f527a.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.z.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        z(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, z>> it = this.dl.entrySet().iterator();
        while (it.hasNext()) {
            z value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.f527a.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.z.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.f527a.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    public void z(Context context, Intent intent) {
        z value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, z> map = this.dl;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, z> entry : this.dl.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.z(context, intent);
            }
        }
    }
}
