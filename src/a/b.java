package a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class b {
	static List<String> url_first = new ArrayList<>();
	static List<String> num_first = new ArrayList<>();
	static List<String> name_first = new ArrayList<>();
	static List<String> myid_first = new ArrayList<>();
	static List<String> pid_first = new ArrayList<>();
	static List<String> url = new ArrayList<>();
	static List<String> num = new ArrayList<>();
	static List<String> name = new ArrayList<>();
	static int myid=25843;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Document doc;
		//第一步，创建一个workbook对应一个excel文件
	     try {
			doc = Jsoup.connect("http://172.28.64.148:8080/login.html").get(); 
			Elements formElement_main = doc.getElementsByClass("category-item");
			Elements links = formElement_main.select("a[href]");
			Elements formElement_num = doc.getElementsByClass("category-code");
			Elements formElement_name = doc.getElementsByClass("category-title text-overflow");
		    for(int i=0;i<formElement_name.select("span").size();i++)
		    {
		    	Element n=formElement_name.select("span").get(i);
		    	String a=n.text();
		    	name.add(a);
		    }//获取name
		    for(int i=0;i<formElement_num.select("span").size();i++)
		    {
		    	Element n=formElement_num.select("span").get(i);
		    	String a=n.text();
		    	num.add(a);
		    }//获取编号
			for (Element link : links) {  
			    url.add("http://ztflh.xhma.com"+link.attr("href"));  
			}// 获取url
			
	     for(int i=17;i<formElement_num.select("span").size();i++) {
	    	
			find(url.get(i),num.get(i),name.get(i),myid++,0);
				 
			 HSSFWorkbook workbook = new HSSFWorkbook();
		      //第二部，在workbook中创建一个sheet对应excel中的sheet
		    HSSFSheet sheet = workbook.createSheet(i+"");
		       //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		    HSSFRow row = sheet.createRow(0);
		      //第四步，创建单元格，设置表头
		      row.createCell(0).setCellValue("url");
		      row.createCell(1).setCellValue("myid");
		      row.createCell(2).setCellValue("cat_desc");
		      row.createCell(3).setCellValue("cat_name");
		      row.createCell(4).setCellValue("pid");
			 for (int e = 0; e < url_first.size(); e++) { 
		   
		      HSSFRow row1 = sheet.createRow(e+ 1); //创建单元格设值
		      row1.createCell(0).setCellValue(url_first.get(e));
		      row1.createCell(1).setCellValue(myid_first.get(e));
			  row1.createCell(2).setCellValue(num_first.get(e));
			  row1.createCell(3).setCellValue(name_first.get(e));
			  row1.createCell(4).setCellValue(pid_first.get(e));
			  
			  }
			 
				  try {
			            FileOutputStream fos = new FileOutputStream("E:\\fen\\中图分法"+i+".xls");
			            workbook.write(fos);
			            System.out.println("写入成功");
			            fos.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }

			 } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static boolean find(String url, String num, String name,int myid_se,int pid) {
		Document doc;
		List<String> url_second = new ArrayList<>();
		List<String> num_second = new ArrayList<>();
		List<String> name_second = new ArrayList<>();
		System.out.println(url + " " + num + " " + name+" "+myid_se+" "+pid);
		String myid_st=myid_se+"";
		String pid_st=pid+"";
		
		url_first.add(url);
		num_first.add(num);
		name_first.add(name);
		myid_first.add(myid_st);
		pid_first.add(pid_st);
		//pid.add(pid+" ");

		try {
			doc = Jsoup.connect(url).get();
			Elements formElement = doc.getElementsByClass("category-item");
			Elements links = formElement.select("a[href]");
			Elements formElement1 = doc.getElementsByClass("category-code");
			Elements formElement2 = doc.getElementsByClass("category-title text-overflow");
			
			// System.out.println(formElement2);
			for (int i = 0; i < formElement2.select("span").size(); i++) {
				Element n = formElement2.select("span").get(i);
				String a = n.text();
				name_second.add(a);
			}
			for (int i = 0; i < formElement1.select("span").size(); i++) {
				Element n = formElement1.select("span").get(i);
				String a = n.text();

				num_second.add(a);
			}
			for (Element link : links) {

				url_second.add("http://ztflh.xhma.com" + link.attr("href"));
			}
			
			// System.out.println(name);
			for (int i = 0; i < formElement1.select("span").size(); i++) {
				if (url.equals(url_second.get(i)) == false) {
					find(url_second.get(i), num_second.get(i), name_second.get(i),myid++,myid_se);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub

	}

}
