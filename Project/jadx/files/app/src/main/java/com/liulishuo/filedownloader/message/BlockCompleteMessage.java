package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.h0.f;

/* JADX INFO: loaded from: classes3.dex */
public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final MessageSnapshot f17226u;

        public BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.e());
            if (messageSnapshot.o() != -3) {
                throw new IllegalArgumentException(f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.o())));
            }
            this.f17226u = messageSnapshot;
        }

        @Override // com.liulishuo.filedownloader.message.BlockCompleteMessage
        public MessageSnapshot b() {
            return this.f17226u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 4;
        }
    }

    MessageSnapshot b();
}
