package org.example.hutool.core;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;

/**
 * @Author ys
 * @Date 2022/3/30 08:58
 */
public class CloneExample {
    public static void main(String[] args) {
        Cat cat0 = new Cat("aaa");
        Cat cat1 = cat0.clone();
        System.out.println(cat0.getName());
        System.out.println(cat1.getName());
    }
}

/**
 * 泛型克隆接口
 */
class Cat implements Cloneable<Cat> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Cat(String name) {
        this.name = name;
    }

    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}

class Dog extends CloneSupport<Dog> {
    private String name;
}
