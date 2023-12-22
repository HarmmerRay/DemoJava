package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

/**
 * @description: csv文件读写测试demo
 * @author: HammerRay
 * @date: 2023/12/5 上午12:39
 */
public class CsvIo {

    public static void main(String []args){
        String filePath = "xxx.csv";
        writeCsv(filePath);

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // 使用逗号分隔符将每行的内容分割成字符串数组
                String[] data = line.split(cvsSplitBy);

                // 处理每个字符串数组，例如将其存储在数据结构中或执行其他操作
                System.out.println("Column 1: " + data[0] + ", Column 2: " + data[1] + ", Column 3: " + data[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CSVRecord> readCsv(String filePath){

        try (  FileReader fileReader = new FileReader(filePath);
               BufferedReader bufferedReader = new BufferedReader(fileReader);

               CSVParser parser = new CSVParser(fileReader,CSVFormat.DEFAULT.withHeader())){
            System.out.println(parser.getRecords());
            bufferedReader.close();
            fileReader.close();
            return parser.getRecords();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    public static void writeCsv(String filePath)  {
        try {
            Writer writer =new FileWriter(filePath);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name","Age","City"));
            csvPrinter.printRecord("JoHn Doe",30,"New York");
            csvPrinter.printRecord("Hammer Ray",20,"Strong King");
            csvPrinter.flush();

            csvPrinter.close();
            writer.close();
            System.out.println("Csv file was written successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
