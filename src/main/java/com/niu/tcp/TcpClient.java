/*
package com.niu.tcp;

import com.niu.util.IntUtil;
import sun.security.krb5.internal.NetClient;


import java.io.UnsupportedEncodingException;

*/
/**
 * @program: myChat
 * @description:
 * @author: niuzilian
 * @create: 2019-03-31 16:40
 **//*

public class TcpClient extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        super.start();
        NetClientOptions options = new NetClientOptions();

        options.setConnectTimeout(1000);

         NetClient netClient = vertx.createNetClient();

        netClient.connect(8082, "localhost", socket -> {
            if (socket.succeeded()) {
                System.out.println("tcp 客户端链接成功");
                NetSocket netSocket = socket.result();
                netSocket.handler(buff-> System.out.println(buff));

                byte[] cmd = IntUtil.int2ByteArr(1000);
                JsonObject body=new JsonObject();
                body.put("userId",1001);
                body.put("username","niuzilian");
                try {
                    byte[] bodyByte = body.encode().getBytes("UTF-8");
                    byte[] length = IntUtil.int2ByteArr(bodyByte.length);
                    Buffer buffer = Buffer.buffer().appendBytes(cmd).appendBytes(length).appendBytes(bodyByte);
                    netSocket.write(buffer);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                netClient.close();
            } else {
                System.out.println("链接失败 " + socket.cause());

            }
        });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(TcpClient.class.getName(), clientRes -> {
            System.out.println("client 测试类部署完成");
        });
    }
}
*/
