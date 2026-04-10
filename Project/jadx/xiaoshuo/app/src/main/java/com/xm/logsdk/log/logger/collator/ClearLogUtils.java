package com.xm.logsdk.log.logger.collator;

import android.util.Log;
import com.dangdang.reader.utils.DangdangFileManager;
import com.xm.logsdk.log.LogzConfig;
import com.xm.logsdk.utils.FileUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ClearLogUtils {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void deleteFilesByLimitSize(String str, long j) throws Throwable {
        long j2 = j * 1024;
        long j3 = (j2 / 4) * 1024;
        long j4 = (j2 * 1024) - j3;
        log("maxZipByte:" + j3 + ",maxLogByte:" + j4);
        List<File> willDelFilesByLimitSize = getWillDelFilesByLimitSize(str, j4, new FileFilter() { // from class: com.xm.logsdk.log.logger.collator.ClearLogUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return (file == null || file.getName().endsWith(DangdangFileManager.FONT_EXTEN) || file.getName().endsWith(LogzConfig.sFileSuffix)) ? false : true;
            }
        }, false);
        if (willDelFilesByLimitSize != null && !willDelFilesByLimitSize.isEmpty()) {
            String str2 = str + "/zip/" + System.currentTimeMillis() + DangdangFileManager.FONT_EXTEN;
            File file = new File(str2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileUtils.INSTANCE.zipFile(willDelFilesByLimitSize, str2);
            log("zipPathFileName:" + file.getName() + ",size:" + file.length());
            List<File> willDelFilesByLimitSize2 = getWillDelFilesByLimitSize(str, j3, new FileFilter() { // from class: com.xm.logsdk.log.logger.collator.ClearLogUtils.2
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 == null) {
                        return false;
                    }
                    return file2.getName().endsWith(DangdangFileManager.FONT_EXTEN);
                }
            }, false);
            if (willDelFilesByLimitSize2 != null && !willDelFilesByLimitSize2.isEmpty()) {
                willDelFilesByLimitSize.addAll(willDelFilesByLimitSize2);
            }
        }
        if (willDelFilesByLimitSize == null || willDelFilesByLimitSize.isEmpty()) {
            return;
        }
        log("will del file size:" + willDelFilesByLimitSize.size());
        for (File file2 : willDelFilesByLimitSize) {
            log("delete byMaxSize f:" + file2.getName() + ",size:" + file2.length());
            file2.delete();
        }
    }

    private static List<File> deleteFilesBylimitSize(List<File> list, long j, boolean z) {
        log("deleteFilesBylimitSize del:" + z + ",delSize:" + j);
        ArrayList arrayList = new ArrayList();
        if (j <= 0) {
            return arrayList;
        }
        for (File file : list) {
            if (file != null && file.exists()) {
                j -= file.length();
                arrayList.add(file);
                if (z) {
                    file.delete();
                    log("delete byMaxSize f:" + file.getName() + ",delSize:" + j + ",lastModified:" + file.lastModified());
                }
            }
            if (j <= 0) {
                break;
            }
        }
        return arrayList;
    }

    private static List<File> getWillDelFilesByLimitSize(String str, long j, FileFilter fileFilter, boolean z) {
        ArrayList arrayList = new ArrayList();
        long jSearchFile = FileUtils.INSTANCE.searchFile(new File(str), arrayList, fileFilter) - j;
        return jSearchFile > 0 ? deleteFilesBylimitSize(sortAscByLastModified(arrayList), jSearchFile, z) : new ArrayList();
    }

    private static void log(String str) {
        Log.i("LOGZ_FILE_DEL", str);
    }

    private static void quickSortAsc(File[] fileArr, int i, int i2) {
        if (i >= i2) {
            return;
        }
        File file = fileArr[i];
        int i3 = i;
        int i4 = i2;
        while (i3 < i4) {
            while (i3 < i4 && file.lastModified() <= fileArr[i4].lastModified()) {
                i4--;
            }
            fileArr[i3] = fileArr[i4];
            while (i3 < i4 && file.lastModified() >= fileArr[i3].lastModified()) {
                i3++;
            }
            fileArr[i4] = fileArr[i3];
        }
        fileArr[i3] = file;
        quickSortAsc(fileArr, i, i3 - 1);
        quickSortAsc(fileArr, i3 + 1, i2);
    }

    private static List<File> sortAscByLastModified(List<File> list) {
        if (list == null) {
            return null;
        }
        File[] fileArr = (File[]) list.toArray(new File[list.size()]);
        quickSortAsc(fileArr, 0, fileArr.length - 1);
        return Arrays.asList(fileArr);
    }
}
