package org.example;

public class Bridge {

    public static void main(String[] args) {
        Book book = new Book();
        Artist artist = new Artist();

        BookResource bookResource = new BookResource(book);
        ArtistResource artistResource = new ArtistResource(artist);

        ShortForm shortForm = new ShortForm(bookResource);
        shortForm.show();

        LongForm longForm = new LongForm(artistResource);
        longForm.show();
    }
}

interface Resource {
    void getSnip();

    void getImage();
}

abstract class View {

    protected Resource resource;

    public View(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    abstract void show();

}


class LongForm extends View {

    public LongForm(Resource resource) {
        super(resource);
    }

    @Override
    void show() {
        super.getResource().getSnip();
        super.getResource().getImage();
    }
}

class ShortForm extends View {

    public ShortForm(Resource resource) {
        super(resource);
    }

    @Override
    void show() {
        super.getResource().getSnip();
    }
}

class Book {
    public String getDescription() {
        return "This is book";
    }

    public String getBookPicture() {
        return "This is book Picture";
    }
}

class Artist {
    public String getBio() {
        return "This is Artist";
    }

    public String getAvatar() {
        return "Artist Avatar";
    }
}

class ArtistResource implements Resource {
    private final Artist artist;

    public ArtistResource(Artist artist) {
        this.artist = artist;
    }

    @Override
    public void getSnip() {
        System.out.println(artist.getBio());
    }

    @Override
    public void getImage() {
        System.out.println(artist.getAvatar());
    }
}

class BookResource implements Resource {
    private final Book book;

    public BookResource(Book book) {
        this.book = book;
    }

    @Override
    public void getSnip() {
        System.out.println(book.getDescription());
    }

    @Override
    public void getImage() {
        System.out.println(book.getBookPicture());
    }
}
