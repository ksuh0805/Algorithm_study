package com.programmers.방금그곡;

public class Solution_방금그곡 {
	public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replace(m);
        for(int i = 0; i < musicinfos.length; i++) {
        	musicinfos[i] = replace(musicinfos[i]);
        }
        int max = 0;
        for(int i = 0; i < musicinfos.length; i++) {
        	String music = musicinfos[i];
        	String[] ms = music.split(",");
        	int t = (Integer.parseInt(ms[1].substring(0,2)) - Integer.parseInt(ms[0].substring(0,2)))*60
        			+ Integer.parseInt(ms[1].substring(3,5)) - Integer.parseInt(ms[0].substring(3,5));
        	int len = ms[3].length();
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < t / len; j++) {
        		sb.append(ms[3]);
        	}
        	sb.append(ms[3].substring(0,t % len));
        	String s = sb.toString();
        	/*
        	outer:
        	for(int j = 0; j <= s.length() - m.length(); j++) {
        		if(m.charAt(0) == s.charAt(j)) {
        			for(int k = 0; k < m.length(); k++) {
        				if(m.charAt(k) != s.charAt(j + k)) continue outer;
        			}
        			if(max < t) {
        				max = t;
        				answer = ms[2];
        			}
        			break;
        		}
        	}
        	*/
        	if(s.indexOf(m) > -1) {
        		if(max < t) {
    				max = t;
    				answer = ms[2];
    			}
        	}
        }
        return answer;
    }
	private static String replace(String m) {
		m = m.replace("A#", "a");
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
		return m;
	}
	public static void main(String[] args) {
		System.out.println(solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(solution("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
		System.out.println(solution("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
	}
}
