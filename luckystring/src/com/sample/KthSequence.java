package com.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 *Today RK has a special task for you. RK gives you a positive integer N. First you have to find all the sequences of length N consisting of characters 'O' and 'Z' only such that no two 'Z' are adjacent in any sequence. After finding all such sequences you have to find Kth sequence when all found sequences are sorted lexicographically in ascending order. If no Kth sequence exist then print -1.

Input :
The first line contains the number of test cases T. Each test case consists of two positive integers N and K.

Output :
For each test case output Kth sequence or -1 if Kth sequence does not exist.

Constraint : 
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ K ≤ 1017

Sample Input(Plaintext Link)
 1
3 2
Sample Output(Plaintext Link)
 OOZ
Explanation
For sample, all valid sequences in lexicographic ascending order are :
OOO, OOZ, OZO, ZOO, ZOZ
2nd sequence in this order is OOZ.
 * 
 * 
 * */

public class KthSequence {

	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/
         
        List<String> tempList;
		int[] k=new int[10];
		int[] seqn=new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
            String line2 = brd.readLine();
            String[] strList=line2.split("\\s+");
            seqn[i]=Integer.parseInt(strList[0]);
            k[i]=Integer.parseInt(strList[1]);
        }
        for (int i = 0; i < N; i++) {             	
             	tempList=new ArrayList<>(generateStringList(seqn[i]));             	
             	System.out.println(tempList!=null?tempList.get(k[i]-1):-1);
             
        }
        
       
        
    }
    public static Set<String> generateStringList(int size){
		Set<String> tempString=new TreeSet<>();
		StringBuilder strBuild=new StringBuilder();

		for(int i=0;i<factorial(size)+4;i++){
			generateKthSequence(size, strBuild);  
			if(!(strBuild.toString().contains("ZZ"))){
				tempString.add(strBuild.toString());
			}
			strBuild.setLength(0);    		
		}
		//System.out.println(tempString);
		return tempString;
	}
	public static char generateRandomChar(){
		final String alphabet = "OZ";
		final int N=alphabet.length();

		Random r=new Random();
		return alphabet.charAt(r.nextInt(N));

	}
	public static void generateKthSequence(int size,StringBuilder strBuild){
		for(int i=0;i<size;i++){
			strBuild.append(generateRandomChar());
		}
	}
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
