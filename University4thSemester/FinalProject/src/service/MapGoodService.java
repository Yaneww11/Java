package service;

import data.CanGetGoods;
import data.GoodShop;
import data.Shop;

import java.util.LinkedList;
import java.util.Queue;

public abstract class MapGoodService {

    public void clearAllGoods(CanGetGoods mapGoods){
        mapGoods.getGoods().clear();
    }


    public void printGoodsCount(CanGetGoods mapGoods){
        mapGoods.getGoods()
                .forEach((name, queue) -> System.out.println(name + " - " + queue.size()));
    }

    public  void printGoods(CanGetGoods mapGoods){
        mapGoods.getGoods()
                .forEach((name, queue) -> System.out.println(name + " - " + queue));
    }

}
