package a;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MakeExcelTest {

  


    public static void main(String[] args) {
        //��һ��������һ��workbook��Ӧһ��excel�ļ�
        HSSFWorkbook workbook = new HSSFWorkbook();
        //�ڶ�������workbook�д���һ��sheet��Ӧexcel�е�sheet
        HSSFSheet sheet = workbook.createSheet("�û���һ");
        //����������sheet������ӱ�ͷ��0�У��ϰ汾��poi��sheet������������
        HSSFRow row = sheet.createRow(0);
        //���Ĳ���������Ԫ�����ñ�ͷ
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("����");
      

        //���岽��д��ʵ�����ݣ�ʵ��Ӧ������Щ���ݴ����ݿ�õ�,�����װ���ݣ����ϰ����󡣶��������ֵ��Ӧ���ÿ�е�ֵ
    
        for (int i = 0; i < 5; i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            //������Ԫ����ֵ
            row1.createCell(0).setCellValue("aaa");
          
        }

        //���ļ����浽ָ����λ��
        try {
            FileOutputStream fos = new FileOutputStream("E:\\��ͼ�ַ�.xls");
            workbook.write(fos);
            System.out.println("д��ɹ�");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}