package edu.nju.software.js.leetcode.socket;

/**
 * Created by liveangel on 2016-3-23.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    private static int number = 0; // ���汾���̵Ŀͻ�����

    Socket socket = null; // �����뱾�߳���ص�Socket����

    public ServerThread(Socket socket, int clientnum) {

        this.socket = socket;
        number = clientnum;
        System.out.println("��ǰ���ߵ��û���: " + number);
    }

    public void run() {
        try {

            // ��Socket����õ�������,��������Ӧ��BufferedReader����
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

            // ��Socket����õ������,������PrintWriter����
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            // ��ϵͳ��׼�����豸����BufferedReader����
            BufferedReader sysin = new BufferedReader(new InputStreamReader(
                    System.in));

            // �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
            System.out.println("[Client " + number + "]: " + in.readLine());

            String line; // ����һ������

            // �ӱ�׼�������һ�ַ���
            line = sysin.readLine();

            while (!line.equals("bye")) { // ������ַ���Ϊ "bye",��ֹͣѭ��

                // ��ͻ���������ַ���
                out.println(line);

                // ˢ�������,ʹClient�����յ����ַ���
                out.flush();

                // ��ϵͳ��׼����ϴ�ӡ������ַ���
                System.out.println("[Server]: " + line);

                // ��Client����һ�ַ���,����ӡ����׼�����
                System.out.println("[Client " + number + "]: " + in.readLine());

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

}