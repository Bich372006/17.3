public class Main {
    public static void main(String[] args) {
        XMLManager manager = new XMLManager("data.xml");

        // Tạo phần tử mới
        manager.createElement("student");
        manager.createElement("student");

        // Đọc XML
        System.out.println("Danh sách XML:");
        manager.readXML();

        // Cập nhật phần tử
        System.out.println("\nCập nhật XML:");
        manager.updateElement("student", "Nguyen Van A", "Le Van C");
        manager.readXML();

        // Xóa phần tử
        System.out.println("\nXóa phần tử:");
        manager.createElement("student");
        manager.readXML();

        // Ghép XML
        XMLMerger.mergeXMLFiles("data.xml", "data2.xml", "merged.xml");
    }
}
