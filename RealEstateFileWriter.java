import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RealEstateFileWriter {
    public static void saveToCSV(List<RealEstateData> dataList, String fileName) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8)) {
            writer.write("Title,Price,Address,Area,Description\n");
            for (RealEstateData data : dataList) {
                writer.write(data.toString() + "\n");
            }
            System.out.println("Dữ liệu đã được lưu vào file: " + fileName);
        } catch (Exception e) {
            System.err.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }




}
