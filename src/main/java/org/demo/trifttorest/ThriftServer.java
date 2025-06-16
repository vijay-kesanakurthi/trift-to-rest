package org.demo.trifttorest;


import calculator.CalculatorService;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class ThriftServer {

    public static class CalculatorHandler implements CalculatorService.Iface {
        @Override
        public int add(int num1, int num2) {
            System.out.println("Received add request: " + num1 + " + " + num2);
            return num1 + num2;
        }

        @Override
        public int subtract(int num1, int num2) throws TException {
            System.out.println("Received sub request: " + num1 + " - " + num2);

            return num1 - num2;
        }
    }

    public static void main(String[] args) {
        try {
            CalculatorHandler handler = new CalculatorHandler();
            TProcessor processor = new CalculatorService.Processor<>(handler);

            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport)
                    .processor(processor)
                    .protocolFactory(new TBinaryProtocol.Factory()));

            System.out.println("Starting Java Thrift server on port 9090...");
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

