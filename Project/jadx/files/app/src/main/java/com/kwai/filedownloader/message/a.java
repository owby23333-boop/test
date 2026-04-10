package com.kwai.filedownloader.message;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.kwai.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C0468a extends MessageSnapshot implements a {
        private final MessageSnapshot aGS;

        public C0468a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.Ge() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ge())));
            }
            this.aGS = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public final MessageSnapshot Ib() {
            return this.aGS;
        }
    }

    MessageSnapshot Ib();
}
