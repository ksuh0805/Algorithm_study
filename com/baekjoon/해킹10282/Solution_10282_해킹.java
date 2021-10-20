package com.baekjoon.해킹10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_10282_해킹 {
	static class Edge implements Comparable<Edge>{
        int v, time;
        public Edge(int v, int time){
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Edge>[] edgeList = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                edgeList[i] = new ArrayList<>();
            }
            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edgeList[b].add(new Edge(a, s));
            }

            Edge[] D = new Edge[n + 1];
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            for(int i = 1; i < n + 1; i++) {
                if(i == c) D[i] = new Edge(i, 0);
                else D[i] = new Edge(i, Integer.MAX_VALUE);
                queue.offer(D[i]);
            }

            while(!queue.isEmpty()){
                Edge edge = queue.poll();
                if(edge.time == Integer.MAX_VALUE) break;

                for(Edge next : edgeList[edge.v]){
                    if(visited[next.v]) continue;
                    if(D[next.v].time > D[edge.v].time + next.time){
                        D[next.v].time = D[edge.v].time + next.time;

                        queue.remove(D[next.v]);
                        queue.offer(D[next.v]);
                    }
                }
                visited[edge.v] = true;
            }

            int max = 0;
            int cnt = 0;
            for(int i = 1; i < n + 1; i++){
                if(D[i].time == Integer.MAX_VALUE) continue;
                if(max < D[i].time) max = D[i].time;
                cnt++;
            }
            System.out.println(cnt + " " + max);
        }
    }
}
