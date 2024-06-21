import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E>
{
	private static class Node<E>
	{
		E data;
		Node<E> prev;
		Node<E> next;
		public Node(E data, Node<E> prev, Node<E> next)
		{
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
//		return size == 0;
		return head == null;
	}

	@Override
	public boolean contains(Object o)
	{
		return indexOf(o) >= 0;
	}

	@Override// - must
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override // - must
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e)
	{
		Node<E> node = new Node<E>(e, tail, null);
		if(head == null)
			head = node;
		else
			tail.next = node;
		tail = node;
		size++;
		return true;
	}

	@Override // - must
	public boolean remove(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		head = tail = null;
		size = 0;
	}

	@Override
	public E get(int index)
	{
		Node<E> temp = getNodeByIndex(index);
		return temp.data;
	}

	private Node<E> getNodeByIndex(int index)
	{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Node<E> temp;
		if(index < size / 2)
		{
			temp = head;//1
			for(int i=0; i<index; i++)
			{
				temp = temp.next;
			}
		} else 
		{
			temp = tail;
			for(int i= size-1; i>index; i--)
			{
				temp = temp.prev;
			}
		}
		return temp;
	}

	@Override // - must
	public E set(int index, E element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element)
	{
		if(index == size)
		{
			add(element);
		} else if(index == 0)
		{
			Node<E> node = new Node<E>(element, null, head);
			head.prev = node;
			head = node;
		} else
		{
			Node<E> temp = getNodeByIndex(index);
			Node<E> node = new Node<E>(element, temp.prev, temp);
			temp.prev.next = node;
			temp.prev = node;
		}
		size++;
	}

	@Override
	public E remove(int index)
	{
		Node<E> temp = getNodeByIndex(index);
		return unlink(temp);
	}

	private E unlink(Node<E> temp)
	{
		if(size == 1)
		{
			head = tail = null;
		} else if(tail == temp)
		{
			tail = temp.prev;
			temp.prev.next = null;
		} else if(head == temp)
		{
			head = temp.next;
			temp.next.prev = null;
		} else
		{
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		size--;
		return temp.data;
	}

	@Override
	public int indexOf(Object o)
	{
		int index = 0;
		if(o == null)
		{
			for(Node<E> node = head; node != null; node = node.next, index++)
			{
				if(node.data == null)
					return index;
			}
		} else
		{
			for(Node<E> node = head; node != null; node = node.next, index++)
			{
				if(o.equals(node.data))
					return index;
			}
		}
		return -1;
	}

	@Override // - must
	public int lastIndexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean containsAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
