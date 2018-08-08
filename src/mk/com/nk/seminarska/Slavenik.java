package mk.com.nk.seminarska;

public class Slavenik {
	private String ime;
	private String prezime;
	private int godini;
	private Lokacija lokacija;
	
	public Slavenik(){}
	
	public Slavenik(String ime, String prezime, int godini, Lokacija lokacija) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godini = godini;
		this.lokacija = lokacija;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodini() {
		return godini;
	}

	public void setGodini(int godini) {
		this.godini = godini;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}
}