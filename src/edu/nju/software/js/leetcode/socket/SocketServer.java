package edu.nju.software.js.leetcode.socket;

/**
 * Created by liveangel on 2016-3-23.
 */
import java.net.ServerSocket;

/**
 * ��������Socket
 *
 * @author Administrator
 *
 */
public class SocketServer {

    /**
     * ��������Socket���췽��
     */
    public SocketServer() {
        try {

            int clientcount = 0; // ͳ�ƿͻ�������

            boolean listening = true; // �Ƿ�Կͻ��˽��м���

            ServerSocket server = null; // ��������Socket����

            try {
                // ����һ��ServerSocket�ڶ˿�2121�����ͻ�����
                server = new ServerSocket(2121);

                System.out.println("Server starts...");
            } catch (Exception e) {
                System.out.println("Can not listen to. " + e);
            }

            while (listening) {
                // �ͻ��˼���
                clientcount++;

                // �������ͻ�����,���ݵõ���Socket����Ϳͻ��������������߳�,������֮
                new ServerThread(server.accept(), clientcount).start();
            }
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
        new SocketServer();
    }
}