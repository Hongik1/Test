package Book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


class BookManagerTest {
	private BookManager bookManager;
	private Book book1;
	private Book book2;
	private Book book3;



	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	    book1 = new Book("1", "자바 기초", "Jane", 2021);
	    book2 = new Book("2", "소프트웨어 공학", "Tom", 2014);
	    book3 = new Book("3", "분산 컴퓨팅", "Yoon", 2024);
	}

	@Test
	void testAddBook() {
		  assertTrue(bookManager.addBook(book1));
		    assertFalse(bookManager.addBook(book1)); // 중복 발생

		    List<Book> books = bookManager.searchBook("자바 기초");
		    assertEquals(1, books.size());
		    assertEquals(book1, books.get(0));
	}

	@Test
	void testSearchBook() {
		   bookManager.addBook(book1);
		    bookManager.addBook(book2);
		    bookManager.addBook(book3);
		    //단어로 책 검색
	        // "자바"라는 검색어로 검색
	        List<Book> books = bookManager.searchBook("자바");
	        assertEquals(1, books.size());
	        assertEquals(book1, books.get(0));

	        // "Tom"이라는 저자로 검색
	        books = bookManager.searchBook("Tom");
	        assertEquals(1, books.size());
	        assertEquals(book2, books.get(0));

	        // "컴퓨팅"이라는 검색어로 검색
	        books = bookManager.searchBook("컴퓨팅");
	        assertEquals(1, books.size());
	        assertEquals(book3, books.get(0));

	        // 존재하지 않는 검색어로 검색
	        books = bookManager.searchBook("Python");
	        assertTrue(books.isEmpty());
	}

	@Test
	void testRemoveBook() {
	    bookManager.addBook(book1);
	    bookManager.addBook(book2);

	    assertTrue(bookManager.removeBook("1"));
	    assertFalse(bookManager.removeBook("1")); // 이미 삭제되었음

	    List<Book> books = bookManager.searchBook("자바 기초");
	    assertTrue(books.isEmpty());

	}

}
