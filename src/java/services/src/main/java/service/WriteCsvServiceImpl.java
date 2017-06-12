package service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import model.MasterReportCardtype;
import model.MasterReportDTO;
@Service
public class WriteCsvServiceImpl implements WriteCsvService {

	@Override
	public void wirteCsv(List<MasterReportDTO> dto) throws IOException {
		 	Workbook wb = new HSSFWorkbook();
	        CreationHelper helper = wb.getCreationHelper();
	        Sheet sheet = wb.createSheet("Tran");
	        NumberFormat formatter = NumberFormat.getCurrencyInstance();
			try {
				
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
				Row rowtieude = sheet.createRow((short) 0);
				String[] tieude = {"Bao Cao Transaction by Merchant"};
				for (int j = 0; j < tieude.length; j++)
					rowtieude.createCell(j)
					.setCellValue(helper.createRichTextString(tieude[j]));
				int r = 2;
				Row row1 = sheet.createRow((short) 1);
				String[] title = {"id","merchant_name","merchant_code","total_quantity_sale","total_quantity_return","total_amount_sale","total_amount_return"};
				for (int j = 0; j < title.length; j++)
					row1.createCell(j)
					.setCellValue(helper.createRichTextString(title[j]));
				for(int i =0; i< dto.size(); i++)
				{
					String[] tran =  {String.valueOf(dto.get(i).getId()),dto.get(i).getMearchant_name(),dto.get(i).getMerchant_code()
							,String.valueOf(dto.get(i).getTotal_quantity_sale())
							,String.valueOf(dto.get(i).getTotal_quantity_return())
							,String.valueOf(formatter.format(dto.get(i).getTotal_amout_sale()))
							,String.valueOf(formatter.format(dto.get(i).getTotal_amout_return()))};					
					if(tran != null){
						Row row = sheet.createRow((short) r++);
						
						for (int j = 0; j < tran.length; j++)
							row.createCell(j)
							.setCellValue(helper.createRichTextString(tran[j]));
						
					}
				}
				// Write the output to a file
				FileOutputStream fileOut = new FileOutputStream("data.xls");
				for(int colNum = 0; colNum<wb.getSheetAt(0).getRow(1).getLastCellNum();colNum++)   
				    wb.getSheetAt(0).autoSizeColumn(colNum);
				wb.write(fileOut);
				fileOut.close();		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void wirteCsvCardtype(List<MasterReportCardtype> dto) throws IOException {
		Workbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Tran");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
		try {
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
			Row rowtieude = sheet.createRow((short) 0);
			String[] tieude = {"Bao Cao Transaction by Merchant"};
			for (int j = 0; j < tieude.length; j++)
				rowtieude.createCell(j)
				.setCellValue(helper.createRichTextString(tieude[j]));
			int r = 2;
			Row row1 = sheet.createRow((short) 1);
			String[] title = {"id","merchant_name","merchant_code","card_type","total_quantity_sale","total_amount_sale","total_quantity_return","total_amount_return"};
			for (int j = 0; j < title.length; j++)
				row1.createCell(j)
				.setCellValue(helper.createRichTextString(title[j]));
			for(int i =0; i< dto.size(); i++)
			{
				String[] tran =  {String.valueOf(dto.get(i).getId()),dto.get(i).getMearchant_name(),dto.get(i).getMerchant_code()
						,String.valueOf(dto.get(i).getTotal_quantity_sale())
						,String.valueOf(dto.get(i).getTotal_quantity_return())
						,String.valueOf(formatter.format(dto.get(i).getTotal_amout_sale()))
						,String.valueOf(formatter.format(dto.get(i).getTotal_amout_return()))};					
				if(tran != null){
					Row row = sheet.createRow((short) r++);
					
					for (int j = 0; j < tran.length; j++)
						row.createCell(j)
						.setCellValue(helper.createRichTextString(tran[j]));
					
				}
			}
			// Write the output to a file
			FileOutputStream fileOut = new FileOutputStream("data2.xls");
			for(int colNum = 0; colNum<wb.getSheetAt(0).getRow(0).getLastCellNum();colNum++)   
			    wb.getSheetAt(0).autoSizeColumn(colNum);
			wb.write(fileOut);
			fileOut.close();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
