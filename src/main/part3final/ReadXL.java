/**exercise 3
*@author: Alexis
**/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL 
{

  private String getCellValue(Cell cell)
  {

      if(cell.getCellType() == CellType.STRING) {
          return cell.getStringCellValue();
      }
      else {
          return String.valueOf(cell.getNumericCellValue());
      }

  }

  public void readBooksFromExcelFile(KnowledgeGraph graph, String filename)
      throws IOException
  {
    
    FileInputStream inputStream = new FileInputStream(filename);

    try (Workbook workbook = new XSSFWorkbook(inputStream)) {
		
    Sheet firstSheet = workbook.getSheetAt(0);
		
    Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) 
		{

		  Row nextRow = iterator.next();
		  Iterator<Cell> cellIterator = nextRow.cellIterator();
		  
      String[] data = new String[3];

		  while (cellIterator.hasNext()) 
		  {
		    
		    Cell nextCell = cellIterator.next();
		    int columnIndex = nextCell.getColumnIndex();

		    switch (columnIndex) {
		    case 1:
		    	data[0] = getCellValue(nextCell);
		    	break;
		    case 2:
		    	data[1] = getCellValue(nextCell);
		    	break;
		    case 4:
		    	data[2] = getCellValue(nextCell);
		    	break;          
		    }

		    
		  }

		  graph.addRecord(data[0], data[1], data[2]);
        
		}
	}
    inputStream.close();
  }
}