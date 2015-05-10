package util;

import java.util.Random;
/**
 *  This class is used to random an sequence order. It can be  used in training for machine learning.
 * @author sunqilin
 * 
 */
public class Random_order {
	/**
	 * When given a integer len, which larger then 0, it will return an random order from 0(include) to len(exclude) 
	 * else if will retuen null
	 * @param len the length for the return sequence
	 * @return
	 */
	public static int[] randomorder(int len)
	{ 
		if(len <= 0) return null;
		int[] seed = new int[len];
		for(int i = 0;i<len;++i)
			seed[i] = i;

		int[] result= new int[len];   
		Random random = new Random();   
		for (int i = 0; i < len; i++)
		{   
			int r = random.nextInt(len - i);   
			result[i] = seed[r];   
			seed[r] = seed[len - 1 - i];
		}
		return result.clone();
	}
	
	/**
	 * sample K number form integer between 0 to len without repetition
	 * @param len 
	 * @param K 
	 * @return
	 */
	public static int[] sampleK(int len, int K)
	{ 
		int[] seed = new int[len];
		for(int i = 0;i<len;++i)
			seed[i] = i;

		int[] result= new int[K];   
		Random random = new Random();   
		for (int i = 0; i < K; i++)
		{   
			int r = random.nextInt(len - i);   
			result[i] = seed[r];   
			seed[r] = seed[len - 1 - i];
		}
		return result.clone();
	}

}
