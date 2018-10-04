package component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_READ;

public class Server extends AbstractChatComponent {

    public Server(String id, int port) throws IOException {
        super(id, port);
    }

    public int getPort() throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) channel;
        return serverChannel.socket().getLocalPort();
    }

    @Override
    protected Selector selector() throws IOException {
        AbstractSelector selector = SelectorProvider.provider().openSelector();
        channel.register(selector, OP_ACCEPT);
        return selector;
    }

    @Override
    protected AbstractSelectableChannel channel(InetSocketAddress address) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(address);
        return channel;
    }

    @Override
    protected void handleIncomingData(SelectionKey sender, byte[] data) throws IOException {
        for (SelectionKey key : selector.keys()) {
            if (key.channel() instanceof ServerSocketChannel) {
                continue;
            }
            if (key.equals(sender)) {
                continue;
            }
            String msg = new String(data).replace(MESSAGE_DELIMITER, "");
            msg = process(msg);
            key.attach(ByteBuffer.wrap(msg.getBytes()));
            write(key);
        }
    }

    private String process(String msg) {
        String arr[] = msg.split(" ");
        int f[] = new int[arr.length];
        try {
            for (int i = 0; i < f.length; i++) {
                f[i] = Integer.parseInt(arr[i]);
            }
        } catch (Exception e) {
            return "Chuá»—i khÃ´ng há»�p lá»‡.";
        }

        int start = 0, end = 0;
        int max_so_far = 0, max_ending_here = 0;
        int start_index = -1;
        for (int i = 0; i < f.length; i++) {
            max_ending_here += f[i];
            if (max_ending_here <= 0) {
                max_ending_here = 0;
                start_index = -1;
            } else {
                if (start_index == -1)
                    start_index = i;
                if (max_so_far < max_ending_here) {
                    max_so_far = max_ending_here;
                    start = start_index;
                    end = i;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Tong so " + max_so_far);
        builder.append(" Vi tri bat dau :" + (start + 1));
        builder.append(" Vi tri ket thuc :" + (end + 1));
        return builder.toString();
    }

    @Override
    protected void write(SelectionKey key) throws IOException {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel channel = (SocketChannel) key.channel();
        channel.write(buffer);
        key.interestOps(OP_READ);
    }
}
