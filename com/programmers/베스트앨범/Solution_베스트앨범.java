package com.programmers.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_베스트앨범 {
	public static class Song implements Comparable<Song>{
		int idx;
		int play;
		
		public Song(int idx, int play) {
			this.idx = idx;
			this.play = play;
		}

		@Override
		public int compareTo(Song o) {
			int c = o.play - this.play;
			return c == 0 ? this.idx - o.idx : c;
		}
	}
	public static class Genre implements Comparable<Genre>{
		String genre;
		int play;
		
		public Genre(String genre, int play) {
			this.genre = genre;
			this.play = play;
		}
		
		@Override
		public int compareTo(Genre o) {
			return o.play - this.play;
		}
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> playcnt = new HashMap<>();
        Map<String, ArrayList<Song>> songs = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
        	playcnt.put(genres[i], playcnt.getOrDefault(genres[i], 0) + plays[i]);
        	ArrayList<Song> s = songs.getOrDefault(genres[i], new ArrayList<Song>());
        	s.add(new Song(i, plays[i]));
        	songs.put(genres[i], s);
        }
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String key : playcnt.keySet() ){
            pq.offer(new Genre(key, playcnt.get(key)));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
        	Genre g = pq.poll();
        	String genre = g.genre;
        	ArrayList<Song> ss = songs.get(genre);
        	Collections.sort(ss);
        	for(int i = 0; i < 2; i++) {
        		list.add(ss.get(i).idx);
        	}
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] arr = solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
}
