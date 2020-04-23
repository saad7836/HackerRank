import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   
public static class Graph {
      Map<Integer, Set<Integer>> localGraph;

      public Graph(int size) {
      localGraph = new HashMap<Integer, Set<Integer>>();
      for(int i = 1; i <= size; i++) {
        localGraph.put(i, new HashSet<Integer>());
      }
    }
    public void addEdge(int first, int second) {
      localGraph.get(first).add(second);
      localGraph.get(second).add(first);
    }

    public int[] shortestReach(int startId) {
      int[] distance = new int[localGraph.size()+1];
      Arrays.fill(distance, -1);

      Set<Integer> visitNodes   = new HashSet<Integer>();
      Queue<Integer> nodesleftToVisit = new LinkedList<Integer>();
      nodesleftToVisit.add(startId);
      distance[startId] = 0;
      while( nodesleftToVisit.size() > 0) {
        Integer currentNode = nodesleftToVisit.poll();
        visitNodes.add(currentNode);
        for( Integer i : localGraph.get(currentNode)) {
          if( !visitNodes.contains(i)){
            nodesleftToVisit.add(i);
            visitNodes.add(i);
            distance[i] = distance[currentNode] + 1;
          }
        }
      }
      return distance;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int queries = scanner.nextInt();
    for (int query = 0;  query < queries; query++){
      Integer edges = scanner.nextInt();
      Graph graph   = new Graph(edges);
      int m         = scanner.nextInt();
      for( int i = 0; i < m; i++) {
        int first  = scanner.nextInt();
        int second = scanner.nextInt();
        graph.addEdge(first,second);
      }
      int startId = scanner.nextInt();
      int[] distances = graph.shortestReach(startId);

     for( int i = 1; i < distances.length ; i++){
        if( i != startId && distances[i] > -1) {
          System.out.printf("%d ",distances[i] * 6);
        } else if( i != startId && distances[i] == -1) {
          System.out.printf("%d ",distances[i]);
        }
      }
      System.out.printf("\n");
    }
  }
}