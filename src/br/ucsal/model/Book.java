package br.ucsal.model;

public class Book {
	private String title;
	private String nameAuthor;
	private String yearOfPublication;
	private String isbn;
	private String edition;
	private String idioma;
	private String genre;
	private String sinopse;
	
	public Book() {
	}
	
	public Book(String title, String nameAuthor, String yearOfPublication, String isbn, String edition, String idioma,
			String genre, String sinopse) {
		this.title = title;
		this.nameAuthor = nameAuthor;
		this.yearOfPublication = yearOfPublication;
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

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
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
