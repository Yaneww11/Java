package org.example.service;

import org.example.data.CanGetGoods;

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
