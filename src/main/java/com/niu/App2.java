package com.niu;

import com.alibaba.fastjson.JSONObject;
import com.niu.util.ByteBuffer;
import com.niu.util.IntUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args ) {
        try {
            Socket socket = new Socket("192.168.2.182",8082);


            OutputStream out = socket.getOutputStream();

            JSONObject body=new JSONObject();
            body.put("userId",1002);

            byte[] cmd = IntUtil.int2ByteArr(1200);
            byte[] bodyByte = body.toJSONString().getBytes("UTF-8");

            byte[] bodyLength = IntUtil.int2ByteArr(bodyByte.length);

            ByteBuffer byteBuffer = new ByteBuffer();
            byteBuffer.append(cmd).append(bodyLength).append(bodyByte);

            byte[] data = byteBuffer.toBytes();
            new Thread(()->{
                while (true){
                    if(!socket.isClosed()){
                        try {
                            System.out.println("2222222发送心跳");
                            out.write(data);
                            out.flush();

                            Thread.sleep(5000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
               }).start();

           // socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
