package mx.maxa.btree;

import mx.maxa.node.node;

public class btree<T extends Comparable<T>> implements Comparable<T> {
	private node<T> root    = null;
	private int         height  = 0; 
	
	
	public btree() {
		this.root =  new node<>();
	}
	public btree(T value) {
		this.root =  new node<>(value);
	}
	public void add(T value) {
		if (root.getValue()== null)
			root.setValue(value);
		else
			add(value,root);
		
 	}
	private void add (T value,node<T> root) {
		if (root.getValue().compareTo(value) >= 1) {
			if (root.getLeft() == null) {
				root.setLeft(new node<>(value));
				return;
			}else 
				add(value,root.getLeft());
		}else if (root.getValue().compareTo(value) <= -1 
				|| root.getValue().compareTo(value) == 0) {
			if (root.getRight() == null) {
				root.setRight(new node<>(value));
				return;
			}
			else
				add(value, root.getRight());
		} 
	}
	public boolean remove (T value) {
		node<T> tmp =deepSearch(value); //si lo encontro
		if (tmp!= null)
			return remove(value,tmp,isChild(value));
		return false;
	}
	private boolean remove (T value, node<T> root, node<T> imyourfather) {

		if (isChild(value) == null) {
			node<T> miNode = minSearch(root.getRight());
			miNode.setLeft(root.getLeft());
			this.root =root.getRight();
			return true;
		}
		if (root.getLeft() == null && root.getRight() ==null) {
			if (imyourfather.getLeft()!=null && imyourfather.getLeft().equals(root) )
				imyourfather.setLeft(null);
			else if(imyourfather.getRight()!=null)
				imyourfather.setRight(null);
			return true;
		}else if( root.getLeft()!=null && root.getRight() ==null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getLeft());
			else
				imyourfather.setRight(root.getLeft());
			return true;
		}else if( root.getLeft()==null && root.getRight() !=null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getRight());
			else
				imyourfather.setRight(root.getRight());
			return true;
		}else {
			if (imyourfather.getLeft().equals(root)){
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setLeft(root.getRight());
			}else {
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setRight(root.getRight());
			}
			return true;
		}
		
	}
	
	public void printInorder() {
		printInorder(root);
	}
	private void printInorder(node<T> root) {
		if (root.getLeft() != null)
			printInorder(root.getLeft());
		
		System.out.print(" "+root.getValue().toString());
		
		if(root.getRight()!= null)
			printInorder(root.getRight());
	}
	public void printPreorder() {
		
	}
	public void printPostOrder() {
		
	}
	public node<T> isChild(T value){
		if (deepSearch(value)== null)
			return null;
		return isChild(value,root,null);
	}
	private node<T> isChild(T value,node<T>root,node<T> imyourfather ) {
		if (root != null) {
			if (root.getValue().equals(value)) 
				return imyourfather;
			if (root.getValue().compareTo(value)<=-1)
				return isChild(value,root.getRight(),root);
			else
				return isChild(value,root.getLeft(),root);
		}else 
			return null;
	}
	private boolean isEmpty() {
		return false;
	}
	public node<T> deepSearch(T value){
		return deepSearch(value,root);
	}
	private node<T> deepSearch(T value, node<T> root){
		if (root != null) {
			if (root.getValue().equals(value)) 
				return root;
			if (root.getValue().compareTo(value)<=-1)
				return deepSearch(value,root.getRight());
			else
				return deepSearch(value,root.getLeft());
		}else 
			return null;
	}
	public node<T> breadthSearch(T value) {
		return null;
	}
	
	private node<T> minSearch(node<T> root){
		while(root.getLeft()!=null) 
			root = root.getLeft();
		return root;
	}
	private node<T> maxSearch(node<T> root){
		while(root.getRight()!=null) 
			root = root.getRight();
		return root;
	}
	private int maxDepth() {
		return 0;
	}
	private void clear() {
		
	}
	private boolean exists(T value) {
		return false;
	}
	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}





