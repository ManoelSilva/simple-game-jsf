package br.edu.uni7.tecnicas.jogoJsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PalpiteBean {

	private static final Integer MAX_TENTATIVAS = 3;
	private Integer palpite;
	private Integer numero = Integer.MIN_VALUE;
	private Integer tentativas = 0;
	private String dica;

	public PalpiteBean() {
		init();
	}

	public String init() {
		numero = (int) (Math.random() * 101);
		System.out.println("@@@@ numero:" + numero);
		dica = "";
		tentativas = 0;
		palpite = null;
		
		return "palpite";
	}

	public String execute() {
		String next = "tentar";

		if (tentativas < MAX_TENTATIVAS) {
			if (palpite == numero) {
				next = "sucesso";
			} else if (palpite > numero) {
				dica = "Tente um número MENOR";
				tentativas++;
			} else {
				dica = "Tente um número MAIOR";
				tentativas++;
			}
		} else {
			next = "game-over";
			init();
		}

		return next;
	}

	public Integer getPalpite() {
		return palpite;
	}

	public void setPalpite(Integer palpite) {
		this.palpite = palpite;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

}
