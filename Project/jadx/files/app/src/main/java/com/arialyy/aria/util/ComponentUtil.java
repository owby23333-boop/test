package com.arialyy.aria.util;

import com.arialyy.aria.core.TaskOptionParams;
import com.arialyy.aria.core.inf.IEventHandler;
import com.arialyy.aria.core.inf.ITaskOption;
import com.arialyy.aria.core.inf.IUtil;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ComponentUtil {
    public static final int COMPONENT_TYPE_FTP = 2;
    public static final int COMPONENT_TYPE_HTTP = 1;
    public static final int COMPONENT_TYPE_M3U8 = 3;
    public static final int COMPONENT_TYPE_SFTP = 4;
    private static volatile ComponentUtil INSTANCE;
    private String TAG = CommonUtil.getClassName(ComponentUtil.class);

    private ComponentUtil() {
    }

    public static ComponentUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (ComponentUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ComponentUtil();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends com.arialyy.aria.core.listener.IEventListener> T buildListener(int r9, com.arialyy.aria.core.task.AbsTask r10, android.os.Handler r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "请添加FTP插件"
            r1 = 12
            r2 = 0
            if (r9 == r1) goto L1c
            r1 = 13
            if (r9 == r1) goto L19
            switch(r9) {
                case 1: goto L1c;
                case 2: goto L16;
                case 3: goto L1c;
                case 4: goto L16;
                case 5: goto L19;
                case 6: goto L19;
                case 7: goto L11;
                case 8: goto L11;
                default: goto Lf;
            }     // Catch: java.lang.Throwable -> L80
        Lf:
            r9 = r2
            goto L1e
        L11:
            java.lang.String r9 = "com.arialyy.aria.m3u8.M3U8Listener"
            java.lang.String r0 = "请添加m3u8插件"
            goto L1e
        L16:
            java.lang.String r9 = "com.arialyy.aria.core.listener.DownloadGroupListener"
            goto L1e
        L19:
            java.lang.String r9 = "com.arialyy.aria.core.listener.BaseUListener"
            goto L1e
        L1c:
            java.lang.String r9 = "com.arialyy.aria.core.listener.BaseDListener"
        L1e:
            if (r9 != 0) goto L22
            monitor-exit(r8)
            return r2
        L22:
            java.lang.Class r1 = r8.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Class r9 = r1.loadClass(r9)     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            r1 = 0
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.reflect.Constructor r3 = r9.getConstructor(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Object r3 = r3.newInstance(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            com.arialyy.aria.core.listener.IEventListener r3 = (com.arialyy.aria.core.listener.IEventListener) r3     // Catch: java.lang.reflect.InvocationTargetException -> L61 java.lang.InstantiationException -> L67 java.lang.IllegalAccessException -> L6d java.lang.NoSuchMethodException -> L73 java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.String r2 = "setParams"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Class<com.arialyy.aria.core.task.AbsTask> r6 = com.arialyy.aria.core.task.AbsTask.class
            r5[r1] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Class<android.os.Handler> r6 = android.os.Handler.class
            r7 = 1
            r5[r7] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.reflect.Method r9 = com.arialyy.aria.util.CommonUtil.getMethod(r9, r2, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            r2[r1] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            r2[r7] = r11     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            r9.invoke(r3, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L59 java.lang.InstantiationException -> L5b java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L5f java.lang.ClassNotFoundException -> L7a java.lang.Throwable -> L80
            goto L78
        L59:
            r9 = move-exception
            goto L63
        L5b:
            r9 = move-exception
            goto L69
        L5d:
            r9 = move-exception
            goto L6f
        L5f:
            r9 = move-exception
            goto L75
        L61:
            r9 = move-exception
            r3 = r2
        L63:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L80
            goto L78
        L67:
            r9 = move-exception
            r3 = r2
        L69:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L80
            goto L78
        L6d:
            r9 = move-exception
            r3 = r2
        L6f:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L80
            goto L78
        L73:
            r9 = move-exception
            r3 = r2
        L75:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L80
        L78:
            monitor-exit(r8)
            return r3
        L7a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L80
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L80
            throw r9     // Catch: java.lang.Throwable -> L80
        L80:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.ComponentUtil.buildListener(int, com.arialyy.aria.core.task.AbsTask, android.os.Handler):com.arialyy.aria.core.listener.IEventListener");
    }

    public synchronized <T extends ITaskOption> T buildTaskOption(Class<T> cls, TaskOptionParams taskOptionParams) {
        T tNewInstance;
        List<Field> allFields = CommonUtil.getAllFields(cls);
        try {
            tNewInstance = cls.newInstance();
        } catch (IllegalAccessException e2) {
            e = e2;
            tNewInstance = null;
        } catch (InstantiationException e3) {
            e = e3;
            tNewInstance = null;
        }
        try {
            for (Field field : allFields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                String name = field.getName();
                if (type != SoftReference.class) {
                    Object obj = taskOptionParams.getParams().get(name);
                    if (obj != null) {
                        field.set(tNewInstance, obj);
                    }
                } else {
                    IEventHandler iEventHandler = taskOptionParams.getHandler().get(name);
                    if (iEventHandler != null) {
                        field.set(tNewInstance, new SoftReference(iEventHandler));
                    }
                }
            }
        } catch (IllegalAccessException e4) {
            e = e4;
            e.printStackTrace();
        } catch (InstantiationException e5) {
            e = e5;
            e.printStackTrace();
        }
        return tNewInstance;
    }

    public synchronized <T extends IUtil> T buildUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        String str;
        T t2;
        int requestType = absTaskWrapper.getRequestType();
        if (requestType == 12) {
            str = "com.arialyy.aria.sftp.download.SFtpDLoaderUtil";
        } else if (requestType != 13) {
            switch (requestType) {
                case 1:
                    str = "com.arialyy.aria.http.download.HttpDLoaderUtil";
                    break;
                case 2:
                    str = "com.arialyy.aria.http.download.HttpDGLoaderUtil";
                    break;
                case 3:
                    str = "com.arialyy.aria.ftp.download.FtpDLoaderUtil";
                    break;
                case 4:
                    str = "com.arialyy.aria.ftp.download.FtpDGLoaderUtil";
                    break;
                case 5:
                    str = "com.arialyy.aria.http.upload.HttpULoaderUtil";
                    break;
                case 6:
                    str = "com.arialyy.aria.ftp.upload.FtpULoaderUtil";
                    break;
                case 7:
                    str = "com.arialyy.aria.m3u8.vod.M3U8VodUtil";
                    break;
                case 8:
                    str = "com.arialyy.aria.m3u8.live.M3U8LiveUtil";
                    break;
                default:
                    str = null;
                    break;
            }
        } else {
            str = "com.arialyy.aria.sftp.upload.SFtpULoaderUtil";
        }
        if (str == null) {
            ALog.e(this.TAG, "不识别的类名：" + str);
            return null;
        }
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass(str);
            t2 = (T) clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                CommonUtil.getMethod(clsLoadClass, "setParams", AbsTaskWrapper.class, IEventListener.class).invoke(t2, absTaskWrapper, iEventListener);
            } catch (ClassNotFoundException e2) {
                e = e2;
                e.printStackTrace();
            } catch (IllegalAccessException e3) {
                e = e3;
                e.printStackTrace();
            } catch (InstantiationException e4) {
                e = e4;
                e.printStackTrace();
            } catch (NoSuchMethodException e5) {
                e = e5;
                e.printStackTrace();
            } catch (InvocationTargetException e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e7) {
            e = e7;
            t2 = null;
        } catch (IllegalAccessException e8) {
            e = e8;
            t2 = null;
        } catch (InstantiationException e9) {
            e = e9;
            t2 = null;
        } catch (NoSuchMethodException e10) {
            e = e10;
            t2 = null;
        } catch (InvocationTargetException e11) {
            e = e11;
            t2 = null;
        }
        return t2;
    }

    public boolean checkComponentExist(int i2) {
        String str;
        String str2;
        if (i2 == 1) {
            str = "com.arialyy.aria.http.HttpTaskOption";
            str2 = "http插件不存在，请添加http插件";
        } else if (i2 == 2) {
            str = "com.arialyy.aria.ftp.FtpTaskOption";
            str2 = "ftp插件不存在，请添加ftp插件";
        } else if (i2 == 3) {
            str = "com.arialyy.aria.m3u8.M3U8TaskOption";
            str2 = "m3u8插件不存在，请添加m3u8插件";
        } else if (i2 != 4) {
            str2 = "";
            str = null;
        } else {
            str = "com.arialyy.aria.sftp.SFtpTaskOption";
            str2 = "sftp插件不存在，请添加sftp插件";
        }
        try {
            getClass().getClassLoader().loadClass(str);
            return true;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new IllegalArgumentException(str2);
        }
    }
}
