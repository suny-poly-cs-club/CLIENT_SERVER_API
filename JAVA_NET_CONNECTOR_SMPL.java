package edu.nunezh.java_net_smpl;

// NotNull annotation only required for jetbrains i dont think you may need it in another JAVA IDE for this to compile.
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.*;

public class JAVA_NET_CONNECTOR_SMPL {

    public static void main(String [] args) throws IOException {

    }

    public static Socket getClientSideSocket(String serverName, int port) throws IOException {
        // serverName = args[0]; when run from main function you can use args[0] array to define the fqdn of the server as a string value input argument.
        // port = Integer.parseInt(args[1]); when run from main function you can use args[1] array to define the int value for port number as an input argument.
        Socket clientSideSocket = new Socket(serverName, port);
        //try {

            System.out.println("Connecting to " + serverName + " on port " + port);

        //} catch (IOException e) {
           // e.printStackTrace();
        //}
        return clientSideSocket;
    }
    @NotNull
    public static  DataOutputStream outBoundDataOutputStream(Socket clientSideSocket) throws IOException{

        //try {
            OutputStream serverSideOutputStream = clientSideSocket.getOutputStream();
            DataOutputStream serverSideDataOutputStream = new DataOutputStream(serverSideOutputStream);

            System.out.println("Just connected to " + clientSideSocket.getRemoteSocketAddress());
            serverSideDataOutputStream.writeUTF("Hello from " + clientSideSocket.getLocalSocketAddress());
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        return serverSideDataOutputStream;
    }

    public static DataInputStream getInboundDataInputStream(Socket clientSideSocket) throws IOException{

        //try {
            InputStream inboundInputStreamFromServer = clientSideSocket.getInputStream();
            DataInputStream inboundDataInputStream = new DataInputStream(inboundInputStreamFromServer);

        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        return inboundDataInputStream;
    }

    public static void closeSocketConnection(Socket clientSideSocket){
        try {
            clientSideSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
