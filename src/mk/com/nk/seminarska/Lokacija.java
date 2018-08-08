package mk.com.nk.seminarska;

public class Lokacija {
	private String ulica;
	private String grad;
	private String lokal;
	private int brNaGosti;

	public Lokacija(String ulica, String grad, String lokal, int brNaGosti) {
		super();
		this.ulica = ulica;
		this.grad = grad;
		this.lokal = lokal;
		this.brNaGosti = brNaGosti;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getLokal() {
		return lokal;
	}

	public void setLokal(String lokal) {
		this.lokal = lokal;
	}

	public int getBrNaGosti() {
		return brNaGosti;
	}

	public void setBrNaGosti(int brNaGosti) {
		this.brNaGosti = brNaGosti;
	}

	public int toString(int brNaGosti) {
		return brNaGosti;
	}

}
