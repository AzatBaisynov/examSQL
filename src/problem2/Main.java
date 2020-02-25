package problem2;

public class Main {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();

//        dbWorker.addNews("news", "Aaaaaaaaaaaaaaaaaaa");
//        dbWorker.addNews("newsAgain", "Bbbbbbbbbbbbbbbbbbbbbb");
//        dbWorker.deleteNews(2);
        dbWorker.changeNews("Aaaa", "Bbbbbbbbbbb", 1);
    }
}
