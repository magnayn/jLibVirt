package com.nirima.libvirt;

import com.nirima.libvirt.xdr.XDRInputStream;
import com.nirima.libvirt.xdr.XDROutputStream;
import net.schmizz.sshj.DefaultConfig;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Nigel Magnay
 */
public class Connection {

    private static final Logger log = LoggerFactory.getLogger(Connection.class);

    public XDRInputStream dataInputStream;
    public XDROutputStream dos;

    private final SSHClient client;

    public Connection(String host, int port, String username, String password) throws IOException {
        DefaultConfig theConfig = new DefaultConfig();

        client = new SSHClient(theConfig);
        client.addHostKeyVerifier(new HostKeyVerifier() {
            @Override
            public boolean verify(String hostname, int port, PublicKey key) {
                return true;
            }
        });

        client.connect(host, port);
        client.authPassword(username, password);
    }

    public void connect() throws ConnectionException, TransportException {
        Session session = client.startSession();

        Session.Command command = session.exec("netcat -U /var/run/libvirt/libvirt-sock");
        OutputStream outputStream = command.getOutputStream();
        InputStream inputStream = command.getInputStream();


        dos = new XDROutputStream(outputStream);

        InputStream is = command.getInputStream();
        dataInputStream = new XDRInputStream(is);
    }

    public boolean isConnected() {
        return client.isConnected();
    }

    public Packet sendPacket(Packet packet) throws IOException, IllegalAccessException, InstantiationException {

        packet.write(dos);

        log.debug("send: {}", packet);

        dos.flush();

        Packet response = Packet.readPacket(dataInputStream);

        log.debug("recv: {}", response);

        return response;
    }


    public void close() throws IOException {
        client.close();
    }
}
