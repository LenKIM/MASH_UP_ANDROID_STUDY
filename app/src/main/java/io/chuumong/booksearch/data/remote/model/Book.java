package io.chuumong.booksearch.data.remote.model;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class Book {

    private String title;
    private String link;
    private String image;

    private String price;
    private String discount;

    private String author;
    private String publisher;
    private String pubdate;

    private String description;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getDescription() {
        return description;
    }
}
