package com.zr.template.tree;


import java.util.ArrayList;
import java.util.List;

public class BuildTree {

	public static <T> List<Tree<T>> build(List<Tree<T>> nodes) {
		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<>();
		for (Tree<T> children : nodes) {
			Integer pid = children.getParentId();
			if (pid == null || 0 == pid) {
				topNodes.add(children);
				continue;
			}
			for (Tree<T> parent : nodes) {
				Integer id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
                }
			}
		}
		return topNodes;
	}

}
