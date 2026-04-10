package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.umeng.message.proguard.ad;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance;
    private static String mRealDexPath;
    protected static Service mService;
    private SpeedyDexClassLoader mClassLoader;

    private static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        @Override // java.lang.ClassLoader
        public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            return super.findClass(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public URL findResource(String str) {
            return super.findResource(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Enumeration<URL> findResources(String str) {
            return super.findResources(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public synchronized Package getPackage(String str) {
            return super.getPackage(str);
        }

        @Override // java.lang.ClassLoader
        public Package[] getPackages() {
            return super.getPackages();
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
            return super.loadClass(str, z2);
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private DexClassLoaderProvider(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        String str4 = "new DexClassLoaderDelegate: " + str + ", context: " + context;
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int iLastIndexOf = str.lastIndexOf("/") + 1;
        String str5 = str.substring(0, iLastIndexOf) + "fake_dex.jar";
        String strSubstring = str.substring(iLastIndexOf);
        if (supportSpeedyClassLoader() && is_first_load_tbs_dex(str2, strSubstring)) {
            String str6 = "new DexClassLoaderDelegate -- fake: " + str5;
            set_first_load_tbs_dex(str2, strSubstring);
            mInstance = new DexClassLoaderProvider(str5, str2, str3, classLoader, true);
            doAsyncDexLoad(strSubstring, str, str2, str3, classLoader);
        } else {
            String str7 = "new DexClassLoaderDelegate -- real: " + str;
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        return mInstance;
    }

    private static void doAsyncDexLoad(final String str, final String str2, final String str3, final String str4, final ClassLoader classLoader) {
        if (shouldUseDexLoaderService()) {
            new Timer().schedule(new TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        ArrayList<String> arrayList = new ArrayList<>(4);
                        arrayList.add(0, str);
                        arrayList.add(1, str2);
                        arrayList.add(2, str3);
                        arrayList.add(3, str4);
                        Intent intent = new Intent(DexClassLoaderProvider.mContext, (Class<?>) DexClassLoaderProviderService.class);
                        intent.putStringArrayListExtra("dex2oat", arrayList);
                        DexClassLoaderProvider.mContext.startService(intent);
                        String str5 = "shouldUseDexLoaderService(" + str + ", " + intent + ad.f20406s;
                    } catch (SecurityException unused) {
                    } catch (Throwable th) {
                        String str6 = "after shouldUseDexLoaderService exception: " + th;
                    }
                }
            }, 3000L);
            return;
        }
        String str5 = "Background real dex loading(" + str + ad.f20406s;
        new Timer().schedule(new TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z2;
                try {
                    File file = new File(str2.replace(".jar", ".dex"));
                    if (!file.exists() || file.length() == 0) {
                        String str6 = "" + file + " does not existed!";
                        z2 = false;
                    } else {
                        String str7 = "" + file + " existed!";
                        z2 = true;
                    }
                    File file2 = new File(str3);
                    File file3 = new File(str2);
                    boolean zExists = file2.exists();
                    boolean zIsDirectory = file2.isDirectory();
                    boolean zExists2 = file3.exists();
                    if (zExists && zIsDirectory && zExists2) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        new DexClassLoader(str2, str3, str4, classLoader);
                        String str8 = "" + String.format("load_dex completed -- cl_cost: %d, existed: %b", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Boolean.valueOf(z2));
                        if (DexClassLoaderProvider.mForceLoadDexFlag && DexClassLoaderProvider.LAST_DEX_NAME.equals(str)) {
                            String str9 = "Stop provider service after loading " + str;
                            if (DexClassLoaderProvider.mService != null) {
                                DexClassLoaderProvider.mService.stopSelf();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String str10 = "dex loading exception(" + zExists + ", " + zIsDirectory + ", " + zExists2 + ad.f20406s;
                } catch (Throwable th) {
                    String str11 = "@AsyncDexLoad task exception: " + th;
                }
            }
        }, 3000L);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        if (mForceLoadDexFlag) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("_");
        sb.append(IS_FIRST_LOAD_DEX_FLAG_FILE);
        return !new File(str, sb.toString()).exists();
    }

    static void setForceLoadDexFlag(boolean z2, Service service) {
        mForceLoadDexFlag = z2;
        mService = service;
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        File file = new File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean shouldUseDexLoaderService() {
        return !mForceLoadDexFlag && DexLoader.mCanUseDexLoaderProviderService;
    }

    private static boolean supportSpeedyClassLoader() {
        return Build.VERSION.SDK_INT != 21 || DexLoader.mCanUseDexLoaderProviderService;
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    @Override // java.lang.ClassLoader
    public void clearAssertionStatus() {
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
        } else {
            this.mClassLoader.clearAssertionStatus();
        }
    }

    @Override // java.lang.ClassLoader
    protected Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
        return useSelfClassloader() ? super.definePackage(str, str2, str3, str4, str5, str6, str7, url) : this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        return useSelfClassloader() ? super.findClass(str) : this.mClassLoader.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        return useSelfClassloader() ? super.findLibrary(str) : this.mClassLoader.findLibrary(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected URL findResource(String str) {
        return useSelfClassloader() ? super.findResource(str) : this.mClassLoader.findResource(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        return useSelfClassloader() ? super.findResources(str) : this.mClassLoader.findResources(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected synchronized Package getPackage(String str) {
        if (useSelfClassloader()) {
            return super.getPackage(str);
        }
        return this.mClassLoader.getPackage(str);
    }

    @Override // java.lang.ClassLoader
    protected Package[] getPackages() {
        return useSelfClassloader() ? super.getPackages() : this.mClassLoader.getPackages();
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        return useSelfClassloader() ? super.getResource(str) : this.mClassLoader.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String str) {
        return useSelfClassloader() ? getResourceAsStream(str) : this.mClassLoader.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        return useSelfClassloader() ? super.getResources(str) : this.mClassLoader.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return useSelfClassloader() ? super.loadClass(str) : this.mClassLoader.loadClass(str);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        return useSelfClassloader() ? super.loadClass(str, z2) : this.mClassLoader.loadClass(str, z2);
    }

    @Override // java.lang.ClassLoader
    public void setClassAssertionStatus(String str, boolean z2) {
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z2);
        } else {
            this.mClassLoader.setClassAssertionStatus(str, z2);
        }
    }

    @Override // java.lang.ClassLoader
    public void setDefaultAssertionStatus(boolean z2) {
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z2);
        } else {
            this.mClassLoader.setDefaultAssertionStatus(z2);
        }
    }

    @Override // java.lang.ClassLoader
    public void setPackageAssertionStatus(String str, boolean z2) {
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z2);
        } else {
            this.mClassLoader.setPackageAssertionStatus(str, z2);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        return useSelfClassloader() ? super.toString() : this.mClassLoader.toString();
    }
}
