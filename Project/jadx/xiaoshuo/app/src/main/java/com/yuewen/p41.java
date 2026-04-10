package com.yuewen;

import com.duokan.common.FileTypeRecognizer;
import com.yuewen.es2;

/* JADX INFO: loaded from: classes13.dex */
public class p41 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15935a;

        static {
            int[] iArr = new int[FileTypeRecognizer.FileType.values().length];
            f15935a = iArr;
            try {
                iArr[FileTypeRecognizer.FileType.EPUB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15935a[FileTypeRecognizer.FileType.TXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15935a[FileTypeRecognizer.FileType.PDF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int a(FileTypeRecognizer.FileType fileType) {
        int i = a.f15935a[fileType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? es2.h.Va : es2.h.r8 : es2.h.s8 : es2.h.q8;
    }

    public static int b(FileTypeRecognizer.FileType fileType) {
        int i = a.f15935a[fileType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? es2.h.Va : es2.h.L9 : es2.h.Ua : es2.h.U8;
    }
}
