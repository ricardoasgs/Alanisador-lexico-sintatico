package com.analisador.lista;

public class Lista {

	public No head;
	public No tail;
	public int cont;

	public Lista() {
		head = null;
		tail = null;
		cont = 0;
	}

	public void insertLast(String palavra) {
		No novo = new No();
		novo.setPalavra(palavra);
		if (cont == 0) {
			head = novo;
			tail = novo;
		} else {
			tail.setNext(novo);
			tail = novo;
		}
		cont++;
	}


	public void Print() {
		if (cont == 0) {
			System.out.println("Lista Vazia !!!");
		} else {
			No aux = head;
			while (aux != null) {
				if(!aux.getIgnorar()) {
				System.out.println("Token: "+aux.getPalavra()+" - Código: "+aux.getSimbolo());
				}
				aux = aux.getNext();
			}
		}

	}
	
	public void VericarLista() {
		if (cont == 0) {
			System.out.println("Lista Vazia !!!");
		} else {
			No aux = head;
			while (aux != null) {
				if(aux.getPalavra().equals("")) {
					aux.setIgnorar(true);
				}
				aux = aux.getNext();
			}
		}

	}

}
