package systemscanner;

public class LinkedList extends ADTLinkedList {
	 public void DeleteFirst()
     {
         if(Head.Next != null)
         {
             Head = Head.Next;
             Size--;
         }
         else
         {
             Head = null;
         }
     }

     public void DeleteLast()
     {
         Node tmp = Head;
         Node prevLast = null;

         for (int i = 1; i < Size; i++)
         {
             prevLast = tmp;
             tmp = tmp.Next;
         }
         tmp = null;
         prevLast.Next = null;
         Size--;
     }

     public void DeletePos(int position)
     {
         Node tmp = Head;
         Node prevNode = null;
         for (int i = 1; i < position; i++)
         {
             prevNode = tmp;
             tmp = tmp.Next;
         }
         prevNode.Next = tmp.Next;
         tmp.Next = null;
         tmp = null;
         Size--;
     }

     public String DisplayElements()
     {
         String text = "";
         Node tmp = Head;
         for (int i = 0; i < Size; i++)
         {
             text += tmp.Value + "-->";
             tmp = tmp.Next;
         }
         return text;
     }

     public Node GetElement(int position)
     {
         Node tmp = Head;
         for (int i = 1; i < position; i++)
         {
             tmp = tmp.Next;
         }
         return tmp;
     }

     public void InsertFirst(String value)
     {
         Node tmp = new Node();
         tmp.Value = value;
         if(Head == null)
         {
             Head = tmp;
         }
         else
         {
             tmp.Next = Head;
             Head = tmp;
         }
         Size++;
     }

     public void InsertLast(String value)
     {

         Node newLast = new Node();
         newLast.Value = value;
         if (Head == null)
         {
             InsertFirst(value);
         }
         else if(Head.Next == null)
         {
             Head.Next = newLast;
         }
         else
         {
             Node tmp = Head;
             for (int i = 0; i < Size-1; i++)
             {
                 tmp = tmp.Next;
             }
             tmp.Next = newLast;
         }
         Size++;
     }

     public void InsertPos(int position, String value)
     {   
         Node newNode = new Node();
         newNode.Value = value ;
         Node tmp = Head;
         Node prevNode = null;
         if(position == 1)
         {
             InsertFirst(value);
         }
         else
         {
             for (int i = 1; i < position; i++)
             {
                 prevNode = tmp;
                 tmp = tmp.Next;
             }
             prevNode.Next = newNode;
             newNode.Next = tmp;
             Size++;
         }
     }
}
