package com.niu.tcp;

import com.alibaba.fastjson.JSONObject;
import com.niu.constants.CmdEnum;
import com.niu.util.ByteBuffer;
import com.niu.util.IntUtil;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: myChatClient
 * @description:
 * @author: niuzilian
 * @create: 2019-04-28 22:40
 **/
public class Mysocket {

    private Socket socket = null;

    public Mysocket(String ip, Integer port) throws IOException {
        this.socket = new Socket(ip, port);
    }


    public void sendJson(CmdEnum cmdEnum, JSONObject object) throws IOException {
        int cmd = cmdEnum.getCode();
        byte[] cmdByte = IntUtil.int2ByteArr(cmd);
        byte[] bodyByte = object.toJSONString().getBytes("UTF-8");
        byte[] lengthByte = IntUtil.int2ByteArr(bodyByte.length);
        ByteBuffer buffer = new ByteBuffer().append(cmdByte).append(lengthByte).append(bodyByte);
        BufferedOutputStream  bf = new BufferedOutputStream(socket.getOutputStream());
        bf.write(buffer.toBytes());
        bf.flush();
    }






}
