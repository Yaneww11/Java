package org.example.data;

import java.util.Map;
import java.util.Queue;


public interface CanGetGoods{
    Map<String, Queue<GoodShop>> getGoods();
    String getName();
}
