package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

/* JADX INFO: loaded from: classes.dex */
class DatagramSocketWrapper extends Socket {

    public static class DatagramSocketImplWrapper extends SocketImpl {
        public DatagramSocketImplWrapper(DatagramSocket socket, FileDescriptor fd) {
            ((SocketImpl) this).localport = socket.getLocalPort();
            ((SocketImpl) this).fd = fd;
        }

        @Override // java.net.SocketImpl
        public void accept(SocketImpl newSocket) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public int available() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void bind(InetAddress address, int port) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void close() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(String host, int port) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void create(boolean isStreaming) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public InputStream getInputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public Object getOption(int optID) throws SocketException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void listen(int backlog) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void sendUrgentData(int value) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public void setOption(int optID, Object val) throws SocketException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(InetAddress address, int port) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(DatagramSocket socket, FileDescriptor fd) throws SocketException {
        super(new DatagramSocketImplWrapper(socket, fd));
    }
}
