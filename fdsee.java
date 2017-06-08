import java.io.*;
import java.util.*;
import java.nio.file.*;

public class fdsee {

    public static final String SEARCH_OUTPUT = "fdsee_doclist.txt";
    public static final String TOKEN_OUTPUT = "fdsee_token.txt";
    public static final String TOKENDEBUG_OUTPUT = "fdsee_tokendebug.txt";
    public static final String STOPWORD_OUTPUT = "fdsee_stopword.txt";
    public static final String LEXICON_OUTPUT = "fdsee_lexicon.txt";

    public static final String[] stopWords = {"i", "a", "about", "an", "are", "as", "at", "be", "by", "com", "en", "for", "from", "how", "in", "is", "it", "of", "on", "or", "that", "this", "to", "was", "what", "when", "where", "who", "will", "with", "www"};

    public static PrintWriter writer;


    public static int docID = 1;
    public static int[] docIDList;


    public static Hashtable<String, Integer> hashWordList

    public static boolean stringInArray(String word, String[] array){

        int length = array.length;

        for(int i = 0; i < length; i++)
            if(array[i].equals(word))
                return true;
    
        return false;
    }
    
    public static int[] mergeLists(int[] list1, int[] list2){
  
        if(list1 == null && list2 == null)
            return null;

        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        int i = 0;
        int j = 0;

        int sizeTemp = list1.length + list2.length;

        int[] swit = list1;

        if(list1.length < list2.length){
            list1 = list2;
            list2 = swit;
        }
        int[] temp = new int[sizeTemp];

        for(int index = 0; index < sizeTemp; index++){
            
            if(i < list1.length && j < list2.length){
            
                if(list1[i] < list2[j])
                    temp[index] = list1[i++];
                else if(list1[i] > list2[j])
                    temp[index] = list2[j++];
                else 
                    temp[index] = list1[i++];

            } else {
               if(i < list1.length){
                   temp[index] = list1[i++]; 
               } else if(j < list1.length){
                   temp[index] = list2[j++];
               }
            }

        }

        if(i != list1.length)
            temp[sizeTemp - 1] = list1[i];
        else if(j != list2.length)
            temp[sizeTemp - 1] = list2[j];

        return temp;
    }
   
    // searching AND statemnt
    
    public static int[] findDuplicates(int[] list){
       
        if(list == null)
            return null;

        int size = list.length - 1;

        ArrayList<Integer> array = new ArrayList<Integer>();
       
        for(int i = 0; i < size; i++){
            if(list[i] == list[i+1]){
                array.add(list[i]);
            }
        }

        Integer[] arr = new Integer[array.size()];
        arr = array.toArray(arr);
      
        int[] array2 = new int[array.size()];

        for(int i = 0; i < array.size(); i++){
            array2[i] = arr[i];
        }

        return array2; 
    }
}
