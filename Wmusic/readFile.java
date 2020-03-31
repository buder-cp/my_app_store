package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class readFile {
	public static void main(String[] args) {
		// traverseFolder2("D:/git_my_appStore/my_app_store/Wmusic/app/src/main/java/com/example/wanegi");
		traverseFolder2("D:/git_my_appStore/my_app_store/Wmusic/app/src/main/java/com");
	}

	public static void readFile01() throws IOException {
		FileReader fr = new FileReader("D:/BaseActivity.java");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		int daInt = 0;
		while ((line = br.readLine()) != null) {
			if (line.contains("{")) {
				daInt++;
			}
			if (daInt >= 2) {
				String newString = line.replace(";",
						";System.out.println(newString);;System.out.println(newString);;System.out.println(newString);");
				System.out.println(newString);
			} else {
				System.out.println(line);
			}
		}
		br.close();
		fr.close();
	}

	public static void traverseFolder2(String path) {

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (null == files || files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						// System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						try {
							readFile02(file2.getAbsolutePath().replaceAll("/", "\\"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("文件:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}

	/**
	 * 一行一行读取文件，解决读取中文字符时出现乱码
	 * 
	 * 流的关闭顺序：先打开的后关，后打开的先关， 否则有可能出现java.io.IOException: Stream closed异常
	 * 
	 * @throws IOException
	 */
	public static void readFile02(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		CharArrayWriter caw = new CharArrayWriter();

		String line = "";
		int daInt = 0;
		while ((line = br.readLine()) != null) {
			if (line.contains("{")) {
				daInt++;
			}
			if (daInt >= 4 && isLegel(line)) {
				String newString = line.replace(";",
						";System.out.println(\"hehe\");;System.out.println(\"hehe\");;System.out.println(\"hehe\");"
						+ "System.out.println(\"hehe\");;System.out.println(\"hehe\");System.out.println(\"hehe\");;System.out.println(\"hehe\");"
						+ "System.out.println(\"hehe\");;System.out.println(\"hehe\");System.out.println(\"hehe\");;System.out.println(\"hehe\");"
						+ "System.out.println(\"hehe\");;System.out.println(\"hehe\");System.out.println(\"hehe\");;System.out.println(\"hehe\");"
						+ "System.out.println(\"hehe\");;System.out.println(\"hehe\");System.out.println(\"hehe\");;System.out.println(\"hehe\");");
				System.out.println(newString);
				caw.write(newString);
				caw.append(System.getProperty("line.separator"));
			} else {
				System.out.println(line);
				caw.write(line);
				caw.append(System.getProperty("line.separator"));
			}
		}
		br.close();
		isr.close();
		fis.close();

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		caw.writeTo(writer);
		writer.close();
	}

	private static boolean isLegel(String line) {
		return !line.contains("break") && !line.contains("return") && !line.contains("private")
				&& !line.contains("View") && !line.contains("void") && !line.contains("long")
				&& !line.contains("}") && !line.contains("build");
	}

	/**
	 * 一行一行写入文件，适合字符写入，若写入中文字符时会出现乱码
	 * 
	 * 流的关闭顺序：先打开的后关，后打开的先关， 否则有可能出现java.io.IOException: Stream closed异常
	 * 
	 * @throws IOException
	 */
	public static void writeFile01() throws IOException {
		String[] arrs = { "zhangsan,23,FuJian", "lisi,30,ShangHai", "wangwu,43,BeiJing", "laolin,21,ChongQing",
				"ximenqing,67,GuiZhou" };
		FileWriter fw = new FileWriter(new File("D:/BaseActivity.java"));
		// 写入中文字符时会出现乱码
		BufferedWriter bw = new BufferedWriter(fw);

		for (String arr : arrs) {
			bw.write(arr + "\t\n");
		}
		bw.close();
		fw.close();
	}

	/**
	 * 一行一行写入文件，解决写入中文字符时出现乱码
	 * 
	 * 流的关闭顺序：先打开的后关，后打开的先关， 否则有可能出现java.io.IOException: Stream closed异常
	 * 
	 * @throws IOException
	 */
	public static void writeFile02() throws IOException {
		String[] arrs = { "zhangsan,23,福建", "lisi,30,上海", "wangwu,43,北京", "laolin,21,重庆", "ximenqing,67,贵州" };
		// 写入中文字符时解决中文乱码问题
		FileOutputStream fos = new FileOutputStream(new File("D:/BaseActivity02.java"));
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		// 简写如下：
		// BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
		// new FileOutputStream(new
		// File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

		for (String arr : arrs) {
			bw.write(arr + "\t\n");
		}

		// 注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
		bw.close();
		osw.close();
		fos.close();
	}

}
