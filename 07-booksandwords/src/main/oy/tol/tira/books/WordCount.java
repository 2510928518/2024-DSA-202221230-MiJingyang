package oy.tol.tira.books;

//this file is used to caculate the hash code、wordcount、where to store the BST as an array and the method to insert and return string
public class WordCount implements Comparable<WordCount> {
    String word; //get the word
    int count;// get the count
    WordCount left;// get the left node and insert it into an array later
    WordCount right;// get the right node and insert it into an array later
    int hash;// get the hash code
    LinkedListImplementation<WordCount> list = null;// use the file before

    public WordCount(){
        this.word="";
        this.count=0;
        WordCount left=null;
        WordCount right=null;
        hash=hashCode();
    }

    public WordCount(final WordCount wordcount) {
        this.word = new String(wordcount.word);
        this.count = wordcount.count;
        WordCount left=null;
        WordCount right=null;
        hash=hashCode();
    }
    
    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
        WordCount left=null;
        WordCount right=null;
        hash=hashCode();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word){
        this.word=word;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count){
        this.count=count;
    }




    public static void binaryTreeToListArray(WordCount node) {
        if (node == null)
            return;
            // if the node is null, there is no need to insert, just finnish
        if(node.list!=null){
            for (int i = 0; i < node.list.size(); i++) {
                WordCount current = node.list.get(i);
                BinarySearchTreeBookImplementation.words[BinarySearchTreeBookImplementation.indexOfWordCount++]=current;
            }
            // if the node is not null, just insert it into an array and set it as "current" and keep running
        }else{
            BinarySearchTreeBookImplementation.words[BinarySearchTreeBookImplementation.indexOfWordCount++]=node;
        }   // if the programming is not running above, this is still a "node" and need to caculate 

        binaryTreeToListArray(node.left);
        binaryTreeToListArray(node.right);
    }


 void insert(WordCount wordCount, int toInsertHash) throws RuntimeException {
      if (toInsertHash < this.hash) {
         if (null == left) {
            left = wordCount;
            BinarySearchTreeBookImplementation.uniqueWordCount++; // find a uniqueword. than plus one
         } else {
            left.insert(wordCount, toInsertHash);// not  a unique one, than insert
         }
      } else if (toInsertHash > this.hash) {
         if (null == right) {
            right = wordCount;
            BinarySearchTreeBookImplementation.uniqueWordCount++;
         } else {
            right.insert(wordCount, toInsertHash);
         }// right node is as the same
      } else { 
         if (this.equals(wordCount)){
            this.count++;
         } else {
            if (null == list) {
               list = new LinkedListImplementation<>();
               list.add(wordCount);
               BinarySearchTreeBookImplementation.uniqueWordCount++;
            } else {
               WordCount newItem = wordCount;
               int index = list.indexOf(newItem);
               if (index < 0) {
                  list.add(newItem);
                  BinarySearchTreeBookImplementation.uniqueWordCount++;
               } else {
                  list.get(index).count++;
               }
            }
            if (list.size() > BinarySearchTreeBookImplementation.maxProbingSteps) {
                BinarySearchTreeBookImplementation.maxProbingSteps = list.size();
            }
         }
      }
   }



    @Override
    public String toString() {
        return "word="+word+" count="+count;
    }

    @Override
    public int hashCode() {
        int hash=0;
        String hashString=word;
        for (int i = 0; i < hashString.length(); i++) {
            hash=31*hash+hashString.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof WordCount) {
            return this.word.equals(((WordCount)other).word);
        }
        return false;
    }

    @Override
    public int compareTo(WordCount other) {
        return (other.count)-count;
    }
}
