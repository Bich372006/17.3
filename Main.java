import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final String[] URLS = {
            "https://batdongsan.com.vn/",
            "https://alonhadat.com.vn/",
            "https://nhadat247.com.vn/"
    };

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<List<RealEstateData>>> futures = new ArrayList<>();
        List<RealEstateData> allData = new ArrayList<>();

        for (String url : URLS) {
            futures.add(executor.submit(() -> new RealEstateCrawler().crawlData(url)));
        }

        // Nhận kết quả từ các thread
        for (Future<List<RealEstateData>> future : futures) {
            try {
                allData.addAll(future.get());
            } catch (Exception e) {
                System.err.println("Lỗi khi lấy dữ liệu từ thread: " + e.getMessage());
            }
        }

        // Đóng ExecutorService
        executor.shutdown();

        // Ghi dữ liệu vào file
        RealEstateFileWriter.saveToCSV(allData, "real_estate_data.csv");
        RealEstateFileWriter.saveToCSV(allData, "real_estate_data.json");

        // Hiển thị số lượng dữ liệu thu thập được
        System.out.println("Tổng số bất động sản thu thập được: " + allData.size());
    }
}
