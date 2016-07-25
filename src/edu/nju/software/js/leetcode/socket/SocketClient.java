package edu.nju.software.js.leetcode.socket;

/**
 * Created by liveangel on 2016-3-23.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �ͻ���Socket
 *
 * @author Administrator
 *
 */
public class SocketClient {

    /**
     * �ͻ���Socket���췽��
     */
    public SocketClient() {
        try {

            // �򱾻���2121�˿ڷ����ͻ�����
            Socket socket = new Socket("localhost", 2121);

            System.out.println("Established a connection...");

            // ��ϵͳ��׼�����豸����BufferedReader����
            BufferedReader sysin = new BufferedReader(new InputStreamReader(
                    System.in));

            // ��Socket����õ������,������PrintWriter����
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            // ��Socket����õ�������,��������Ӧ��BufferedReader����
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

            String line; // ����һ������

            // ��ϵͳ��׼�������һ�ַ���
            line = sysin.readLine();

            while (!line.equals("bye")) { // ���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��

                // ����ϵͳ��׼���������ַ��������Server
                out.println(line);

                // ˢ�������,ʹServer�����յ����ַ���
                out.flush();

                // ��ϵͳ��׼����ϴ�ӡ������ַ���
                System.out.println("[Client]: " + line);

                // ��Server����һ�ַ���������ӡ����׼�����
                System.out.println("[Server]: " + in.readLine());

                // ��ϵͳ��׼�������һ�ַ���
                line = sysin.readLine();

            }

            out.close(); // �ر�Socket�����
            in.close(); // �ر�Socket������
            socket.close(); // �ر�Socket
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    /**
     * ������
     *
     * @param args
     */
    public static void main(String[] args) {
        new SocketClient();
    }

}
