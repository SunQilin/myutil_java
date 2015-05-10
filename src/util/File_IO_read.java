package util;

import java.io.File;
import java.util.ArrayList;

public class File_IO_read {
	
	/**
	 * read all the names of files under a specified file recusive

	 * @param filename : the root file
	 * @return all the names of files under a specified file and its subfolds
	 */
	public static ArrayList<String> getFilename_recusive(String filename)
	{
		ArrayList<String> filelist = new ArrayList<String>();
		ArrayList<File> diclist = new ArrayList<File>();
		File file1 = new File(filename);

		//read all names of files under a specified file recusive
		if(file1.isDirectory())
		{
			diclist.add(file1);
			while(!diclist.isEmpty())
			{
				if(diclist.get(0).isDirectory())
				{
					File[] subfilelist = diclist.get(0).listFiles();
					for(File temp : subfilelist)
						diclist.add(temp);
					diclist.remove(0);
				}
				else
				{
					filelist.add(diclist.get(0).getAbsolutePath());
					diclist.remove(0);
				}
			}
		}
		else {
			filelist.add(file1.getAbsolutePath());
		}
		return filelist;
	}
	
	
	/**
	 * read all the names of files under a specified file recusive and use the filters to filter the type of files
	 * @param filename : the root file
	 * @param filters : the filters to filter the type of files
	 * @return all the names of files under a specified file and its subfolds that satisfy the type defined in filters
	 */
	
	public static ArrayList<String> getFilename_recusive_filter(String filename, String[] filters)
	{	
		ArrayList<String> filelist_all = getFilename_recusive(filename);
		if(filters.length == 0)
		{
			System.out.println("Warring filters is empty!");
			return filelist_all;
		}
		ArrayList<String> filelist = new ArrayList<String>();
		for(String s : filelist_all)
		{
			for(String filter : filters)
			{
				if(s.endsWith(filter))
				{
					filelist.add(s);
					break;
				}
					
			}
		}
		
		return filelist;

	}

	
	
	public static void main(String[] argvs)
	{
		ArrayList<String> filenames = getFilename_recusive("E:/cmuconvert");
		filenames = getFilename_recusive_filter("E:/cmuconvert",  new String[]{".bvh"});
		System.out.println();

	}

}
