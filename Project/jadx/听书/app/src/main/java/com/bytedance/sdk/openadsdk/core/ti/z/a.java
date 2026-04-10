package com.bytedance.sdk.openadsdk.core.ti.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public interface z {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    public static Object z(z zVar, Class cls, Bundle bundle) {
        if (z(bundle)) {
            return new g(zVar);
        }
        if (z(cls)) {
            return new dl(zVar);
        }
        return null;
    }

    public static boolean z(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return z(cls) || z(bundle);
    }

    private static boolean z(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean z(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }

    private static class g extends com.bytedance.sdk.openadsdk.core.ti.a implements z {
        private z z;

        public g(z zVar) {
            this.z = zVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.bytedance.sdk.openadsdk.core.ti.a
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    return this.z != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999906:
                    return this.z != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999905:
                    if (this.z != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.z != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.z != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.z != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public void injectContext(Context context) {
            z zVar = this.z;
            if (zVar != null) {
                zVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public String getTableName() {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public void init() {
            z zVar = this.z;
            if (zVar != null) {
                zVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public String getType(Uri uri) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public Uri insert(Uri uri, ContentValues contentValues) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public int delete(Uri uri, String str, String[] strArr) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    private static class dl implements ITTProvider, z {
        private z z;

        public dl(z zVar) {
            this.z = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public void injectContext(Context context) {
            z zVar = this.z;
            if (zVar != null) {
                zVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public String getTableName() {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public void init() {
            z zVar = this.z;
            if (zVar != null) {
                zVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public String getType(Uri uri) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public Uri insert(Uri uri, ContentValues contentValues) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public int delete(Uri uri, String str, String[] strArr) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
