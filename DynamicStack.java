//PROGRAMMER: JOHN PHAM
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class DynamicStack<E>
{
    //INSTANCE VARIABLES
    private DynamicArray<E> stack;
    //CONSTRUCTORS
    public DynamicStack()
    {
        stack = new DynamicArray<E>();
    }
    /*public DynamicStack(String filename) throws IOException
    {
        Scanner fileInput = new Scanner(new File(filename));
        while (fileInput.hasNextLine())
        {
            stack.addToEnd();
        }
        fileInput.close();
    }*/
    
    //INSTANCE METHODS
    public void push(E element)
    {
        stack.addToEnd(element);
    }
    
    public boolean empty()
    {
        int numElements = stack.getNumberOfElements();
        if (numElements == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public E peek()
    {
        int indexToPeek = stack.getNumberOfElements();
        if (indexToPeek == 0)
        {
            throw new RuntimeException("Caused By Dynamic Stack Peek Method.");
        }
        else
        {
            return stack.get(indexToPeek - 1);
        }
    }
    
    public E pop()
    {
        int indexToPop = stack.getNumberOfElements();
        if (indexToPop == 0)
        {
            throw new RuntimeException("Caused By Dynamic Stack Pop Method.");
        }
        else
        {
            return stack.remove(indexToPop - 1);
        }
    }
    
    public void saveToFile(String filename) throws IOException
    {
        PrintWriter fileWriter = new PrintWriter(filename);
        int maxIndex = stack.getNumberOfElements();
        for (int i = 0; i < (maxIndex - 1); i++)
        {
            fileWriter.println(stack.get(i));
        }
        fileWriter.close();
    }
}
