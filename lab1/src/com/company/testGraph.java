package com.company;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGraph {
	private Graph graph;
	
    @Before
    public void setUp() throws Exception {
        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test.txt")));
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
        String[] input=new String[words.length-1];
        for(int i=0;i<words.length-1;i++)
            input[i]=words[i+1];
        graph=new Graph(input);
    }

    @After
    public void tearDown() throws Exception {
    }
	
	@Test
	public void testQueryBridgeWords1() {
		assertEquals("strange", graph.queryBridgeWords("explore", "new")[0]);
		assertEquals(1,graph.queryBridgeWords("explore", "new").length);
	}
	
	@Test
	public void testQueryBridgeWords2() {
		assertEquals("worlds", graph.queryBridgeWords("new", "and")[0]);
		assertEquals("life", graph.queryBridgeWords("new", "and")[1]);
		assertEquals(2,graph.queryBridgeWords("new", "and").length);
	}
	
	@Test
	public void testQueryBridgeWords3() {
		assertEquals(0,graph.queryBridgeWords("seek","to").length);
	}
	
	@Test
	public void testQueryBridgeWords4() {
		assertEquals(0,graph.queryBridgeWords("and", "exciting").length);
	}
	
	@Test
	public void testQueryBridgeWords5() {
			assertEquals(0,graph.queryBridgeWords("new", "new").length);
	}
	
	@Test
	public void testQueryBridgeWords6() {
	        String word=null;
			assertEquals(0,graph.queryBridgeWords("new", word).length);
	}

	@Test
	public void testQueryBridgeWords7() throws Exception {
		BufferedReader in;
        in = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test2.txt")));
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
        String[] input=new String[words.length-1];
        for(int i=0;i<words.length-1;i++)
            input[i]=words[i+1];
        Graph graph = new Graph(input);
		assertEquals(0,graph.queryBridgeWords("and", "exciting").length);
	}
	
}
