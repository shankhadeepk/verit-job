package com.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class TestClass {
	int count;
	
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