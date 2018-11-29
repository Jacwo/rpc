/*
package com.yyl.rpc;

import com.yyl.rpc.provider.ProviderTest;
import com.yyl.rpc.provider.ProviderTestImpl;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
*/
/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年11月28日 18:17
 *//*

public class ProviderServer {
    public static void main(String[] args) {
        //用于存放生产者服务接口的Map,实际的框架中会有专门保存服务提供者的
        Map<String, Object> serviceMap = new HashMap();
        serviceMap.put(ProviderTest.class.getName(), new ProviderTestImpl());
        //服务器
        try {
            ServerSocket server = new ServerSocket(8899);
            while (true){
                Socket socket = server.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                String interfaceName = input.readUTF(); //获取服务消费者需要消费服务的接口名
                String methodName = input.readUTF(); ////获取服务消费者需要消费服务的方法名
                //参数的类型
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                //参数的对象
                Object[] rpcArgs = (Object[]) input.readObject();
                //执行调用过程
                Class providerInteface = Class.forName(interfaceName); //得到接口Class
                Object provider = serviceMap.get(interfaceName);//取得服务实现的对象
                //获取需要执行的方法
                Method method = providerInteface.getMethod(methodName, parameterTypes);
                //通过反射进行调用
                Object result = method.invoke(provider, rpcArgs);
                //返回给客户端即服务消费者数据
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
