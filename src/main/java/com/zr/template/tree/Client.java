package com.zr.template.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 曾睿
 * @Date: 2020/11/19 15:32
 */
public class Client {

    public static void main(String[] args) {
        List<Area> areas = new ArrayList<>();
        areas.add(new Area(1,0,"区域","1",1));
        areas.add(new Area(2,1,"区域","1",1));
        areas.add(new Area(3,1,"区域","1",1));
        areas.add(new Area(4,2,"区域","1",1));
        areas.add(new Area(5,4,"区域","1",1));
        List<Tree<Area>> trees = new ArrayList<>();
        if(areas.size() > 0){
            for(Area area : areas) {
                Tree<Area> tree = new Tree<>();
                tree.setId(area.getId());
                tree.setParentId(area.getParentId());
                tree.setName(area.getName());
                tree.setLevel(area.getLevel());
                trees.add(tree);
            }
        }
        List<Tree<Area>> treeArea = BuildTree.build(trees);
        //父级去重
        treeArea = treeArea.stream().distinct().collect(Collectors.toList());
        System.out.println(treeArea);
    }

}
