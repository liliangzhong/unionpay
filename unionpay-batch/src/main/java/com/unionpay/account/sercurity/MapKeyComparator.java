package com.unionpay.account.sercurity;

import java.util.Comparator;

public class MapKeyComparator implements Comparator<String>
{

	public int compare(String st1, String st2)
	{
		return st1.compareToIgnoreCase(st2);
	}

}
