package br.ucsal.model;

public class BookModel {
	private String title;
	private String author;
	private String year;
	private String isbn;
	private String edition;
	private String idioma;
	private String genre;
	private String sinopse;
	
	public BookModel() {
	}
	
	public BookModel(String title, String author, String year, String isbn, String edition, String idioma,
			String genre, String sinopse) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.edition = edition;
		this.idioma = idioma;
		this.genre = genre;
		this.sinopse = sinopse;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
