package kalkulator;

public class Calculator {
	private int state = 0;
	private boolean err = false;
	private int memory = 0;

	public int getState() { // zwraca wartość
		return state;
	}

	public void setState(int state) { // ustanawia wartość
		this.state = state;
	}

	// podstawowe operacje
	public void add(int value){ // dodawanie
		state += value;
	}

	public void mult(int value){ // mnożenie
		state *= value;
	}

	public void sub(int value){ // odejmowanie
		state -= value;
	}

	public void div(int value){ // dzielenie
		if (value == 0) {	// error dla dzielenia przez 0
			err = true;
		} else {
			state /= value;
		}
	}

	public void power(int n){ // potęgowanie
		if (n < 0) {
			err = true; // nie obsługujemy potęg mniejszych od 0
		}
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= state; // podnosimy aktualny stan do potęgi
		}
		state = result;
	}

	// przyciski MS, MR, M+, M-
	public void saveMem(){ // ustawia pamięć na aktualną wartość
		memory = state;
	}

	public void useMem(){ // dodaje zawartość pamięci do obecnej wartości
		state += memory;
	}

	public void addMem(){ // dodaje wartość do pamięci
		memory += state;
	}

	public void subMem(){ // odejmuje wartość od pamięci
		memory -= state;
	}

	public int getMem(){ // zwraca pamięć
		return memory;
	}

	public boolean getError(){
		return err;
	}

}
