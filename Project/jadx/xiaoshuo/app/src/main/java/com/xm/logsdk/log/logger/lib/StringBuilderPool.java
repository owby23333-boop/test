package com.xm.logsdk.log.logger.lib;

import com.xm.logsdk.log.logger.lib.ObjectPool;

/* JADX INFO: loaded from: classes8.dex */
public class StringBuilderPool {
    private static ObjectPool<StringBuilder> sStringBPool = new ObjectPool<>(50, new ObjectPool.ObjectCallback<StringBuilder>() { // from class: com.xm.logsdk.log.logger.lib.StringBuilderPool.1
        @Override // com.xm.logsdk.log.logger.lib.ObjectPool.ObjectCallback
        public void release(StringBuilder sb) {
        }

        @Override // com.xm.logsdk.log.logger.lib.ObjectPool.ObjectCallback
        public StringBuilder initialize() {
            return new StringBuilder();
        }

        @Override // com.xm.logsdk.log.logger.lib.ObjectPool.ObjectCallback
        public void reset(StringBuilder sb) {
            if (sb != null) {
                sb.setLength(0);
            }
        }
    });

    public static void clear() {
        sStringBPool.clear();
    }

    public static StringBuilder obtain() {
        StringBuilder sbObtain = sStringBPool.obtain();
        return sbObtain == null ? new StringBuilder() : sbObtain;
    }

    public static void recycle(StringBuilder sb) {
        sStringBPool.recycle(sb);
    }
}
