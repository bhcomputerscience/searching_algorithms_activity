/**
 * An activity looking at different search algorithms (linear and binary). There are three tasks to complete!
 */

import java.util.Arrays;

public class SearchingAlgorithmsActivity
{
    public static void main(String [] args)
    {
        //create a new list of a certain size. 
        // Task #3: Change the size of the list to see if there are any differences in the run time 
        //remember! these are ints, so the numbers can only be so large!
        int [] numbers = new int[15];

        //find a search value in the range [1, 2*length]
        int searchValue = (int)(Math.random() * (numbers.length*2) + 1);

        //populate list with random numbers between 1 and double the list
        for(int i = 0; i<numbers.length; i++)
        {
            //create random values in the list in the range [1, 2*length]
            numbers[i] = (int)(Math.random() * (numbers.length*2) + 1);
        }

        //print the result of the search
        System.out.println("Searching for: " + searchValue);

        //Task #1: Complete the linear search coding. This line is to test that it works
        //when you are done, delete it and uncomment line 33
        System.out.println(linearSearch(numbers, searchValue));

        //Task #2 - uncomment the line below to run the timed method
        //runTimedMethods(searchValue, numbers);
    }

    /**
     * Prints the list
     * @param numbers list of numbers to be printed
     */
    public static void print(int [] numbers)
    {
        for(int v : numbers)
        {
            System.out.print(v + " ");
        }
        System.out.println("");
    }

    /**
     * Task #1 - complete!
     * Searches for value in numbers using a linear search
     * @param numbers the list of numbers
     * @param value the value to be found
     * @return true if found; false otherwise
     */
    public static boolean linearSearch(int [] numbers, int value)
    {
        boolean result = false;

        //loop through the array, checking if the current element is 
        //equal to the found value; stop when we have found the value
        //TO BE COMPELTED BY YOU


        return result;
    }

    /**
     * Searches for value in numbers using a binary search
     * @param numbers list of numbers
     * @param value value to be found
     * @return true if found; false otherwise
     */
    public static boolean binarySearch(int [] numbers, int value)
    {
        int lower = 0;  //starts at the beginning of the list
        int upper = numbers.length - 1; //upper bound always starts at the end
        int middle = (upper + lower)/2; //calculate the middle

        boolean found = false;

        //keep searching so long as upper > lower and value
        //hasn't be found
        while(upper >= lower && !found)
        {   
            if(numbers[middle] == value)
            {
                //value has been found, will cause
                //loop to terminate
                found = true;
            }
            else if(value > numbers[middle])
            {
                //ignore everything to the left of middle
                //therefore change the lower bound
                lower = middle + 1;
                middle = (upper + lower)/2;
            }
            else
            {
                //ignore everything to the right of middle
                upper = middle - 1;
                middle = (upper + lower)/2;
            }
        }

        return found;
    }

    /**
     * Runs and times both methods
     * @param searchNumber  the number we are searching for
     * @param list  the list of numbers
     */
    public static void runTimedMethods(int searchNumber, int [] list)
    {
        //start and end times
        double startLinear, endLinear;
        double startBinary, endBinary;
        boolean resultLinear, resultBinary;

        //run and print linear version
        startLinear = System.currentTimeMillis();
        resultLinear = linearSearch(list, searchNumber);
        endLinear = System.currentTimeMillis();
        System.out.println("Linear Search Result: " + resultLinear);
        System.out.println("Time (ms):" + (endLinear - startLinear));

        //run and print binary search version
        startBinary = System.currentTimeMillis();
        //sort the array - include this in the timing as it may impact
        Arrays.sort(list);
        resultBinary = binarySearch(list, searchNumber);
        endBinary = System.currentTimeMillis();
        System.out.println("Binary Search Result: " + resultBinary);
        System.out.println("Time (ms):" + (endBinary - startBinary));
    }    
}