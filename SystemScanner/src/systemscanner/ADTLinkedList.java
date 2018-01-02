package systemscanner;

public abstract class ADTLinkedList {
	
	public Node Head;
    public int Size = 0;
    public abstract void InsertFirst(String value);
    public abstract void InsertLast(String value);
    public abstract void InsertPos(int position, String value);
    public abstract void DeleteFirst();
    public abstract void DeleteLast();
    public abstract void DeletePos(int position);
    public abstract Node GetElement(int position);
    public abstract String DisplayElements();
}
