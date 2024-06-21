
public class MyLinkedListAppl
{
	public static void main(String[] args)
	{
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("Java");
		list.add("JS");
		list.add("HTML");
		list.add(null);
		System.out.println("Is empty: " + list.isEmpty());
		System.out.println("Size:" + list.size());
		System.out.println("Contains Java: " + list.contains("Java"));
		System.out.println("Contains java: " + list.contains("java"));
		System.out.println("Contains null: " + list.contains(null));
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("Index of Java: " + list.indexOf("Java"));
		System.out.println("Index of java: " + list.indexOf("java"));
		System.out.println("Index of null: " + list.indexOf(null));
		list.add(1, "CSS");
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("Remove at index 2: " + list.remove(2));
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		list.clear();
		System.out.println("Is empty: " + list.isEmpty());
	}
}
