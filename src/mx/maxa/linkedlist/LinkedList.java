package mx.maxa.linkedlist;


import java.util.Iterator;

import mx.maxa.node.node;

public class LinkedList<T> implements Iterator<String>{

	private node<T> sentinel = null;
	private node<T> auxletr =null;
	
	public LinkedList() {
		createList();
	}

	public LinkedList(T value) {
		this();
		node<T> tmp = new node<T>(value);
		tmp.setIndex(0);
		sentinel.setRight(tmp);
	}

	private void createList() {
		sentinel = new node<T>();
		sentinel.setIndex(-1);
	}

	public void addBefore(T value) {
		node<T> tmp = sentinel.getRight();
		node<T> _new = new node<T>(value);
		_new.setRight(tmp);
		sentinel.setRight(_new);
		_new.setRight(tmp);
		reIndex();
	}

	public void addBefore(long index,T value) {
		node<T> tmp = this.sentinel;
		node<T>_new = new node<>(value);
		node<T> old=null;
		while(tmp.getRight() != null) {
			if (tmp.getRight().getIndex() == index) {
				old.setRight(_new);
				_new.setRight(tmp);
				reIndex();
				break;
			}
			old = tmp;
			tmp=tmp.getRight();
		}
	}
	
	public void addBefore(T value,T newValue) {
		node<T> tmp = this.sentinel;
		node<T> _new=new node<>(newValue);
		while (tmp.getRight()!=null) {
			if (tmp.getRight().getValue().equals(value)) {
				_new.setRight(tmp.getRight());
				tmp.setRight(_new);
				reIndex();
				break;
			}
			tmp=tmp.getRight();
		}
	}
	
	public void addAfter(T value,T newValue) {
		node<T> tmp = this.sentinel;
		node<T> _new=new node<T>(newValue);
		while (tmp.getRight() != null) {
			if (tmp.getRight().getValue().equals(value)) {
				if (tmp.getRight().getRight() != null) {
					_new.setRight(tmp.getRight().getRight());
					tmp.getRight().setRight(_new);
					break;
				}else {
					
				}
			}
			tmp = tmp.getRight();
		}
		reIndex();
	}
	
	private void reIndex() {
		node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getRight() != null) {
			tmp = tmp.getRight();
			tmp.setIndex(i++);
		}
	}

	public void printer() {
		printer(sentinel);
	}

	private void printer(node<T> tmp) {
		if (tmp.getRight() == null) {
			return;
		} else {
			System.out.println("" + tmp.getRight().getValue());
			printer(tmp.getRight());
		}
	}

	public void pronter() {
		node<T> tmp = sentinel;
		while (tmp.getRight() != null) {
			tmp = tmp.getRight();
			System.out.println(tmp.getIndex() + " " + tmp.getValue());
		}
	}
	
	public void addFirst(T value) {
		if (!isEmpty()) {
			node<T> _new = new node<T>(value);
			_new.setRight(sentinel.getRight());
			sentinel.setRight(_new);
			reIndex();
		}
	}
	
	public void addLast(T value) {
		node<T> tmp = sentinel;
		// node<T> _new = new node<T>(value);
		while (tmp.getRight() != null) {
			tmp = tmp.getRight();
		}
		tmp.setRight(new node<T>(value));
		reIndex();
	}

	public void addLast2(T value) {
		node<T> tmp = sentinel;
		/*
		 * node<T> niu = new node<T>(value); if(tmp.getRight()!=null) {
		 * tmp=tmp.getRight(); addLast2(tmp.getValue(), niu); }else { tmp.setRight(niu); }
		 */
		addLast2(value, tmp);
	}

	private void addLast2(T value, node<T> list) {
		if (list.getRight() == null) {
			list.setRight(new node<T>(value));
			reIndex();
			return;
		} else {
			addLast2(value, list.getRight());
		}
	}

	public boolean isEmpty() {
		if (this.sentinel.getRight() != null) {
			return false;
		} else {
			return true;
		}
	}

	public String get(long index) {
		node<T> tmp = this.sentinel;
		if (!isEmpty()) {
			if (index >= 0 && index <= size()) {
				while (tmp.getRight() != null) {
					if (tmp.getRight().getIndex() == index) {
						return tmp.getRight().getValue().toString();
					}
					tmp = tmp.getRight();
				}
			} else {
				return "El index no se encuentra en la lista";
			}
		} else {
			return "La lista esta vacia";
		}
		return "";
	}
	public node<T> serch(T value){
		return serch(value, this.sentinel);
	}

	private node<T> serch(T value, node<T> list) {
		if (!isEmpty()) {
			if (list.getRight()!= null) {
				if (list.getRight().getValue().equals(value)) {
					return list.getRight();
				}else{
					return serch(value, list.getRight());
				}
			}else {
				return null;
			}
		}
		return null;
	}

	public void clear() {
		if (!isEmpty()) {
			this.sentinel = null;
			System.gc();
		}
		createList();
	}

	public int size() {
		node<T> tmp = this.sentinel;
		int cont = 0;
		while (tmp.getRight() != null) {
			cont++;
			tmp = tmp.getRight();
		}
		return cont;
	}

	public T getFirst() {
		T data = null;
		if (!isEmpty()) {
			data = sentinel.getRight().getValue();
		}
		return data;
	}

	public T getLast() {
		T data = null;
		node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getRight() != null) {
				tmp = tmp.getRight();
			}
			data = tmp.getValue();
		}
		return data;
	}

	public void remplace(T oldValue, T newValue) {
		node<T> tmp = this.sentinel;
		while (tmp.getRight() != null) {
			if (tmp.getRight().getValue() == oldValue) {
				tmp.getRight().setValue(newValue);
			}
			tmp = tmp.getRight();
		}
	}

	public void remplace(long index, T newValue) {
		node<T> tmp = this.sentinel;
		while (tmp.getRight() != null) {
			if (tmp.getRight().getIndex() == index) {
				tmp.getRight().setValue(newValue);
			}
			tmp = tmp.getRight();
		}
	}

	public void remove(T value) {
		node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getRight() != null) {
				if (tmp.getRight().getValue().equals(value)) {
					tmp.setRight(tmp.getRight().getRight());
					reIndex();
					break;
				}
				tmp = tmp.getRight();
			}
		}

	}

	public void remove(long index) {
		node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getRight() != null) {
				if (tmp.getRight().getIndex() == index) {
					tmp.setRight(tmp.getRight().getRight());
					reIndex();
					break;
				}
				tmp = tmp.getRight();
			}
		}
	}

	public void revomeLast() {
		node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getRight().getRight() != null) {
				tmp = tmp.getRight();
			}
			tmp.setRight(null);
			System.gc();
			reIndex();
		}
	}

	public void removeFirst() {
		if (!isEmpty()) {
			sentinel.setRight(sentinel.getRight().getRight());
			System.gc();
			reIndex();
		}
	}
	
	public void removeBefore(T value) {
		node<T> tmp = this.sentinel;
		node<T> old=null;
		if (!isEmpty()) {
			while(tmp.getRight() != null) {
				if (tmp.getRight().getValue().equals(value)) {
					if (old != null) {
						old.setRight(tmp.getRight());
						System.gc();
						reIndex();
						break;
					}else {
						System.out.println("No se puede eliminar un dato antes de la lista por que el valor" + value + "es el primer elemento de la lista");
						break;
					}
				}
				old=tmp;
				tmp=tmp.getRight();
			}
		}
	}
	
	public void removeAfter(T value) {
		node<T> tmp = this.sentinel;
		while (tmp.getRight() != null) {
			if (tmp.getRight().getValue().equals(value)) {
				if (tmp.getRight().getRight() != null) {
					node<T> aux = tmp.getRight().getRight();
					tmp.setRight(aux);
					System.gc();
					reIndex();
					break;
				}else {
					System.out.println("No se puede eliminar el valor despues de  " + value + " porque es el ultimo");
				}
			}
			tmp = tmp.getRight();
		}
	}
	
	public long indexOf(T value) {
		node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getRight() != null) {
				if (tmp.getRight().getValue() == value) {
					return tmp.getRight().getIndex();
				}
				tmp = tmp.getRight();
			}
		}
		return -1;
	}
	
	public void list() {
		auxletr =sentinel;
		if (!isEmpty()) {
			while(hasNext()) {
				System.out.println(next());
			}
		}
	}

	@Override
	public boolean hasNext() {
		return auxletr.getRight()!=null;
	}

	@Override
	public String next() {
		String value = auxletr.getRight().toString();
		auxletr = auxletr.getRight();
		return value;
	}

}
