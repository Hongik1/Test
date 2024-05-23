package Book;


import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println( "해당 ID(" + book.getId() + ") 는 이미 존재합니다.");
                return false;
            }
        }
        books.add(book);
        System.out.println(book + "도서가 추가되었습니다.");
        return true;
    }

    public List<Book> searchBook(String query) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().contains(query) || b.getAuthor().contains(query)) {
                result.add(b);
            }
        }
        if (result.isEmpty()) {
            System.out.println("검색된 도서가 없습니다.");
        } else {
            System.out.println("검색 결과:");
            for (Book b : result) {
                System.out.println(b);
            }
        }
        return result;
    }


    public boolean removeBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                books.remove(b);
                System.out.println(b + "도서를 삭제하였습니다.");
                return true;
            }
        }
        System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        return false;
    }
}

