import java.util.*;

public class ArraysAndStrings {

	public void HelloWorld() {
		System.out.println("Hello World");
	}

	public boolean noDuplocateString1(String s) {
		if(s == null) {
			return true;
		}
		boolean[] dups = new boolean[256];
		for(int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i);
			if(dups[cur]) return false;
			dups[cur] = true;
		}
		return true;
	}

	public boolean noDuplocateString2(String s) {
		/*
		Works if s only contains alphabetic characters ('a'~'z')
		Use bit manipulation
		*/

		if(s == null) {
			return true;
		}
		int checker = 0;
		for(int i = 0; i < s.length(); i++) {
			int dev = (s.charAt(i) - 'a');
			if((checker & (1 << dev)) > 0) {
				return false;
			}
			checker |= (1 << dev);
		}
		return true;
	}
}
