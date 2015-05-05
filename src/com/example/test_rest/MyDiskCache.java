package com.example.test_rest;

import java.io.File;
import java.lang.reflect.Field;

import com.android.volley.toolbox.DiskBasedCache;

public class MyDiskCache extends DiskBasedCache{

	public MyDiskCache(File rootDirectory, int maxCacheSizeInBytes) {
		super(rootDirectory, maxCacheSizeInBytes);
		try {
			Field mTotalSize = DiskBasedCache.class.getDeclaredField("mTotalSize");
			mTotalSize.setAccessible(true);
			if(rootDirectory.exists()){
				long size = 0;
				for(File file : rootDirectory.listFiles()){
					size += file.length();
				}
				mTotalSize.set(this, size);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
