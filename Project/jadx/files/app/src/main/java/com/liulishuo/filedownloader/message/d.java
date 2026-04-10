package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.download.e;
import com.liulishuo.filedownloader.h0.f;
import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;

/* JADX INFO: compiled from: MessageSnapshotTaker.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static MessageSnapshot a(int i2, File file, boolean z2) {
        long length = file.length();
        return length > 2147483647L ? z2 ? new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, length) : new LargeMessageSnapshot.CompletedSnapshot(i2, true, length) : z2 ? new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, (int) length) : new SmallMessageSnapshot.CompletedSnapshot(i2, true, (int) length);
    }

    public static MessageSnapshot a(int i2, long j2, long j3, boolean z2) {
        if (j3 > 2147483647L) {
            if (z2) {
                return new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i2, j2, j3);
            }
            return new LargeMessageSnapshot.WarnMessageSnapshot(i2, j2, j3);
        }
        if (z2) {
            return new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i2, (int) j2, (int) j3);
        }
        return new SmallMessageSnapshot.WarnMessageSnapshot(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot a(int i2, long j2, Throwable th) {
        if (j2 > 2147483647L) {
            return new LargeMessageSnapshot.ErrorMessageSnapshot(i2, j2, th);
        }
        return new SmallMessageSnapshot.ErrorMessageSnapshot(i2, (int) j2, th);
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.o() == -3) {
            return new BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.o())));
    }

    public static MessageSnapshot a(byte b, FileDownloadModel fileDownloadModel, e.a aVar) {
        MessageSnapshot errorMessageSnapshot;
        IllegalStateException illegalStateException;
        int iE = fileDownloadModel.e();
        if (b == -4) {
            throw new IllegalStateException(f.a("please use #catchWarn instead %d", Integer.valueOf(iE)));
        }
        if (b == -3) {
            if (fileDownloadModel.r()) {
                return new LargeMessageSnapshot.CompletedSnapshot(iE, false, fileDownloadModel.o());
            }
            return new SmallMessageSnapshot.CompletedSnapshot(iE, false, (int) fileDownloadModel.o());
        }
        if (b != -1) {
            if (b != 1) {
                if (b == 2) {
                    String strD = fileDownloadModel.s() ? fileDownloadModel.d() : null;
                    if (fileDownloadModel.r()) {
                        return new LargeMessageSnapshot.ConnectedMessageSnapshot(iE, aVar.c(), fileDownloadModel.o(), fileDownloadModel.b(), strD);
                    }
                    return new SmallMessageSnapshot.ConnectedMessageSnapshot(iE, aVar.c(), (int) fileDownloadModel.o(), fileDownloadModel.b(), strD);
                }
                if (b == 3) {
                    if (fileDownloadModel.r()) {
                        return new LargeMessageSnapshot.ProgressMessageSnapshot(iE, fileDownloadModel.g());
                    }
                    return new SmallMessageSnapshot.ProgressMessageSnapshot(iE, (int) fileDownloadModel.g());
                }
                if (b != 5) {
                    if (b != 6) {
                        String strA = f.a("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b));
                        com.liulishuo.filedownloader.h0.d.e(d.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b));
                        if (aVar.a() != null) {
                            illegalStateException = new IllegalStateException(strA, aVar.a());
                        } else {
                            illegalStateException = new IllegalStateException(strA);
                        }
                        if (fileDownloadModel.r()) {
                            return new LargeMessageSnapshot.ErrorMessageSnapshot(iE, fileDownloadModel.g(), illegalStateException);
                        }
                        return new SmallMessageSnapshot.ErrorMessageSnapshot(iE, (int) fileDownloadModel.g(), illegalStateException);
                    }
                    return new MessageSnapshot.StartedMessageSnapshot(iE);
                }
                if (fileDownloadModel.r()) {
                    errorMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(iE, fileDownloadModel.g(), aVar.a(), aVar.b());
                } else {
                    errorMessageSnapshot = new SmallMessageSnapshot.RetryMessageSnapshot(iE, (int) fileDownloadModel.g(), aVar.a(), aVar.b());
                }
            } else if (fileDownloadModel.r()) {
                errorMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(iE, fileDownloadModel.g(), fileDownloadModel.o());
            } else {
                return new SmallMessageSnapshot.PendingMessageSnapshot(iE, (int) fileDownloadModel.g(), (int) fileDownloadModel.o());
            }
        } else if (fileDownloadModel.r()) {
            errorMessageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(iE, fileDownloadModel.g(), aVar.a());
        } else {
            errorMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(iE, (int) fileDownloadModel.g(), aVar.a());
        }
        return errorMessageSnapshot;
    }
}
