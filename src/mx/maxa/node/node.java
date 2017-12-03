package mx.maxa.node;

public class node<T> implements Comparable<T> {
	private T       value;
	private node<T> left 	= null;
	private node<T> right	= null;
	private long    index 	= 0;
	private boolean visited = false;
    private node<T> next    = null;
    private node<T> back    = null;
	

	public node() {
		// TODO Auto-generated constructor stub
		this.value = null;
		
	}

    public node<T> getNext() {
        return next;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }

    public node<T> getBack() {
        return back;
    }

    public void setBack(node<T> back) {
        this.back = back;
    }

    public long getIndex() {
        return index;
    }
    public void setIndex(long index) {
        this.index = index;
    }
	public node(T value){
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public node<T> getLeft() {
		return left;
	}
	public void setLeft(node<T> left) {
		this.left = left;
	}
	public node<T> getRight() {
		return right;
	}
	public void setRight(node<T> right) {
		this.right = right;
	}
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
