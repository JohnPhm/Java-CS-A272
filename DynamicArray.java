//PROGRAMMER: JOHN PHAM
import java.io.PrintWriter;
import java.io.IOException;
public class DynamicArray<E>
{
    //INSTANCE VARIABLES
    private final int INITIAL_SIZE = 8;
    private int numberOfElements;
    private E[] array;
    
    //CONSTRUCTORS
    public DynamicArray()
    {
        numberOfElements = 0;
        array = (E[]) new Object[INITIAL_SIZE];
    }
    
    //INSTANCE METHODS
    public void addToEnd(E element)
    {
        if (array.length == 0)
        {
            E[] largerArray = (E[]) new Object[INITIAL_SIZE]; 
            array = largerArray;
        }
        else if (numberOfElements == array.length)
        {
            E[] largerArray = (E[]) new Object[2 * numberOfElements];
            for (int index = 0; index < numberOfElements; index++)
            {
                largerArray[index] = array[index]; 
            }
            array = largerArray;
        }
        array[numberOfElements] = element;
        numberOfElements++;
    }
    
    public E remove(int index)
    {
        if (index < 0)
        {
            throw new IndexOutOfBoundsException("ArrayList index cannot be be a negatiive number.");
        }
        else if (index >= numberOfElements)
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds the index of the last element.");
        }
        
        E removedElement = (E) array[index];
        for ( ; index < (numberOfElements - 1); index++)
        {
            array[index] = array[index + 1];
        }
        
        array[numberOfElements - 1] = null;
        numberOfElements--;
        return (removedElement);
    }
    
    public int getNumberOfElements()
    {
        return numberOfElements;
    }
    
    public E get(int index)
    {
        if (index >= numberOfElements) 
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds the index of the last element.");
        }
        return array[index];
    }
    
    public void set(int index, E element)
    {
        if (index >= numberOfElements)
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds the index of the last element.");
        }
        array[index] = element;
    }
    
    public int occurences(E element)
    {
        int numberOfOccurences = 0; 
        for (int index = 0; index <= (numberOfElements - 1); index++)
        {
            if (array[index].equals(element))
            {
                numberOfOccurences++;
            }
        }
        return numberOfOccurences;
    }
    
    public void saveToFile(String filename) throws IOException
    {
        final String OUTPUT_FILE = "Output.txt";
        PrintWriter fileWriter = new PrintWriter(OUTPUT_FILE);
        for (int index = 0; index < (numberOfElements - 1); index++)
        {
            fileWriter.println(array[index]);
        }
        fileWriter.close();
    }
}
