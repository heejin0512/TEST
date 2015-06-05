
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
                            public class TCPServer implements Runnable {
                                public static final int ServerPort = 9999; // ex: 5555
                                public static final String ServerIP = "211.111.174.25"; // ex: 192.168.0.100

                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub
                                    try{
                                        System.out.println("S: Connecting...");
                                        ServerSocket serverSocket = new ServerSocket(ServerPort);

                                        while (true) {
                                            Socket client = serverSocket.accept();
                                            System.out.println("S: Receiving...");

                                            try {
                                                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
                                                String str = in.readLine();
                            System.out.println("S: Received: '" + str + "'");

                            PrintWriter out =  new PrintWriter( new BufferedWriter( new OutputStreamWriter(client.getOutputStream(),"UTF-8")),true);
                            out.println("Server Message :  "+ str );

                          /*  File f = new File("c:\\TCP_TEST.jpg");
                            FileOutputStream output = new FileOutputStream(f);

                            DataInputStream dis = new DataInputStream(client.getInputStream());

                            int b = 0;
                            while((b= dis.read()) != -1){
                                output.write(b);
                            }
                            output.flush();
                            output.close();
                            */


                } catch(Exception e) {
                    System.out.println("S: Error");
                    e.printStackTrace();
                } finally {
                    client.close();
                    System.out.println("S: Done.");

                }
            }
        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread desktopServerThread = new Thread(new TCPServer());
        desktopServerThread.start();
    }
}
