package com.zhaoyiheng.utils.com.zhaoyiheng.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件 工具类
 * @author zyh
 *
 */
public class FileUtils {
	
	private static File file;

	public static void main(String[] args) throws IOException {
		
		String readFileByLine = readFileByLine("D:\\1703A\\yunfu-parent\\pom.xml");
		System.out.println("filename is " + readFileByLine);
		//del("D:\\教学\\16.0\\小二 -副本");
		
		//file = new File("D:\\教学\\16.0\\小二 -副本");
		//file.delete();
		//copy("D:\\1703A\\groupparent\\groupparent.rar","D:\\1703A\\groupparent\\groupparent22.rar");
	}
	
	/**
	 * 删除文件或者文件夹，使用递归的算法
	 * @param path
	 */
	public static void del(String path) {
		
		File file = new File(path);
		//如果文件不存在
		if(!file.exists()) {
			System.out.println("不存在该路径" + path);
			return;
		}
		
		//如果是文件 则删除
		if(file.isFile()) {
			System.out.println("删除 文件  " + path);
			file.delete();
		}
		//如果是文件夹 则递归调用自己
		if(file.isDirectory()) {
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				String subFileName = path + "\\" + list[i];
				del(subFileName);
			}
			System.out.println("删除目录  " + path);
			file.delete();
		}
		
	}
	
	/**
	 * 拷贝文件
	 * @param src  源文件
	 * @param dst  目标文件
	 * @throws IOException 
	 */
	public static void copy(String src,String dst) throws IOException {
		File fileSrc = new File(src);
		if(!fileSrc.exists() || !fileSrc.isFile()) {
			System.out.println(src + " 文件不存在，不能复制啊！");
			return;
		}
		
		File fileDst = new File(dst);
		if(fileDst.exists()) {
			System.out.println("目标文件已经存在，不能复制");
		}
		
		// 获取输入流
		FileInputStream fis = new FileInputStream(fileSrc);
		FileOutputStream fos = new FileOutputStream(fileDst);
		
		byte bs[] = new byte[1024];
		while(fis.read(bs)>=0) {
			fos.write(bs);
		}
		
		/*fis.close();
		fos.close();*/
		//调用流工具类 去关闭流
		StreamUtils.closeStream(fis,fos);
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static String readFileByLine(String fileName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			sb.append(str).append("\r\n");// 追加
		}
		//关闭流
		StreamUtils.closeStream(fis);
		return sb.toString();
		
	} 
	
	
	public static List<String> readFile(String fileName) throws IOException {
		
		List<String> strList = new ArrayList();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			strList.add(str);
		}
		//关闭流
		StreamUtils.closeStream(fis);
		return strList;
		
	} 

}
