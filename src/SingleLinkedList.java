import javax.naming.NamingEnumeration;
import java.util.Random;

public class SingleLinkedList
{
    public Node head;
    public void UnsortedAdd(Object dataToAdd)
    {
        if(head == null)
        {
                Node newnode = new Node(dataToAdd);
                head = newnode;
        }
        else{
            Node temp = head;
            while(temp.getLink() != null)
                temp = temp.getLink();
            Node newnode = new Node(dataToAdd);
            temp.setLink(newnode);
        }
    }
    public void SortedAdd(Object dataToAdd)
    {
        if(head == null){
            Node newnode = new Node(dataToAdd);
            head = newnode;
        }
        else if((Integer)dataToAdd <= (Integer)head.getData())
        {
            Node newnode = new Node(dataToAdd);
            newnode.setLink(head);
            head = newnode;
        }
        else
        {
            Node temp = head;
            Node previous = null;

            while(temp != null && (Integer)dataToAdd >= (Integer)temp.getData())
            {
                previous = temp;
                temp = temp.getLink();
            }
            if(temp == null){
                Node newnode = new Node(dataToAdd);
                previous.setLink(newnode);
            }
            else
            {
                Node newnode = new Node(dataToAdd);
                newnode.setLink(previous.getLink());
                previous.setLink(newnode);
            }
        }
    }
    public int size()
    {
        if(head == null) return 0;
        else
        {
            Node temp = head;
            int count = 0;

            while(temp != null)
            {
                count++;
                temp = temp.getLink();
            }
            return count;
        }
    }
    public void display()
    {
        if(head == null)
            System.out.println("List is empty.");

        else
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.getData() + " ");
                temp = temp.getLink();
            }
        }
    }
    public void delete(Object dataToDelete)
    {
        if(head == null)
            System.out.println("linked list is empty");
        else
        {
            if(head.getData() == dataToDelete)
                head = head.getLink();

            Node temp = head;
            Node previous = null;
            while(temp != null)
            {
                if(temp.getData() == dataToDelete)
                {
                    previous.setLink(temp.getLink());
                    temp = previous;
                }

                previous = temp;
                temp = temp.getLink();
            }
        }
    }
    public Object get(int index)
    {
        Node temp = head;
        for (int i = 0; i < index - 1; i++)
        {
            temp = temp.getLink();
        }
        return temp.getData();
    }
    public boolean search(String item)
    {
        boolean flag = false;
        if(head == null)
            System.out.print("");

        else
        {
            Node temp = head;
            while(temp != null)
            {
                if(item == temp.getData())
                    flag = true;
                temp = temp.getLink();
            }
        }
        return flag;
    }

    public void duplicate(SingleLinkedList duplicate)
    {
        boolean flag = false;
        if(head == null)
            System.out.print("Linked list is null");
        else
        {
            Node temp = head;
            while(temp != null){
                duplicate.UnsortedAdd(temp.getData());
                temp = temp.getLink();
            }
        }
    }
}
