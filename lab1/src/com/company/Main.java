package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        String infile="D:\\test.txt";
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
        String line;
        String all=new String();
        while((line=in.readLine())!=null)
        {
            all+=" ";
            all+=line;

        }
        all = all.replaceAll("[^a-z^A-Z]", " ");
        all = all.toLowerCase();
        String[] words=all.split("\\s+");
        //当开头是空格时，一号字符会变成“”空字符，而这里处理换行时，第一行会自动添加一个空格
        //所以words[0]必定为“”
        String[] input=new String[words.length-1];
        for(int i=0;i<words.length-1;i++)
            input[i]=words[i+1];
        Graph g=new Graph(input);
        String[] brige=g.queryBridgeWords("explore","new");
        for (String e:brige) {
            System.out.println(e);
        }
        /*System.out.println(g.randomWalk());
        System.out.println(g.calcShortestPath("To","and"));
        String[] s=g.calcShortestPathOfAll("and");
        for (int i = 0; i < g.n; i++) {
            if (s[i]==null) continue;
            System.out.println(s[i]);
        }*/
        // write your code here
    }
}
