package org.demo.trifttorest.Thrift;

import org.junit.jupiter.api.Test;

import calculator.CalculatorService.Client;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import static org.junit.jupiter.api.Assertions.*;

public class TriftToRestApplicationTests {

    @Test
    public void testAddFromGoServer() throws Exception {
        TTransport transport = new TSocket("localhost", 9090);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        Client client = new Client(protocol);

        int result = client.add(7, 4);
        assertEquals(11, result);

        transport.close();
    }
}
