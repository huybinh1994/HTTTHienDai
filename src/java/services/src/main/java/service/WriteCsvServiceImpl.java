package service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import model.MasterReportDTO;
@Service
public class WriteCsvServiceImpl implements WriteCsvService {

	@Override
	public void wirteCsv(List<MasterReportDTO> dto) throws IOException {
		 	Workbook wb = new HSSFWorkbook();
	        CreationHelper helper = wb.getCreationHelper();
	        Sheet sheet = wb.createSheet("Tran");
			try {
				int r = 1;
				Row row1 = sheet.createRow((short) 0);
				String[] title = {"merchan_code","Tong thanh tien","Tong so luong"};
//				title[0] = "merchan_code";
//				title[1];
//				title[2];
				for (int j = 0; j < title.length; j++)
					row1.createCell(j)
					.setCellValue(helper.createRichTextString(title[j]));
				for(int i =0; i< dto.size(); i++)
				{
					String[] tran =  new String[17];
					tran[0] = dto.get(i).getMerchant_code(); 
					tran[1] = String.valueOf(dto.get(i).getTong_thanh_tien()) ;
					tran[2] = String.valueOf(dto.get(i).getSo_luong()) ;

					
							
					
					if(tran != null){
						Row row = sheet.createRow((short) r++);
						
						for (int j = 0; j < tran.length; j++)
							row.createCell(j)
							.setCellValue(helper.createRichTextString(tran[j]));
						
					}
				}
				// Write the output to a file
				FileOutputStream fileOut = new FileOutputStream("data.xls");
				wb.write(fileOut);
				fileOut.close();		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
