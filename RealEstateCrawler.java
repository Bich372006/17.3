import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class RealEstateCrawler {
    public List<RealEstateData> crawlData(String url) {
        List<RealEstateData> dataList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10_000).get();
            Elements listings = doc.select(".listing-item"); // Cần điều chỉnh selector

            for (Element listing : listings) {
                String title = listing.select(".title a").text();
                String price = listing.select(".price").text();
                String address = listing.select(".address").text();
                String area = listing.select(".area").text();
                String description = listing.select(".description").text();

                dataList.add(new RealEstateData(title, price, address, area, description));
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi crawl dữ liệu từ: " + url + " - " + e.getMessage());
        }
        return dataList;
    }
}
