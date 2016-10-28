package dk.rxajavaretrofit.entity;

import java.util.List;


public class BookListResponse extends Movie {
    private int count;
    private int start;
    private int total;
    protected List<Movie> books;


    public BookListResponse() {
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Movie> getBooks() {
        return books;
    }

    public void setBooks(List<Movie> books) {
        this.books = books;
    }
}
