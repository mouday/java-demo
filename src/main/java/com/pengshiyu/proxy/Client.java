package com.pengshiyu.proxy;

import java.lang.reflect.Proxy;

// 客户
public class Client {
    public static void main(String[] args) {
        IVehicle car = new Car();

        IVehicle carProxy = (IVehicle)Proxy.newProxyInstance(
                car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),
                new VehicleInvocationHandler(car)
        );

        carProxy.run();

    }
}
