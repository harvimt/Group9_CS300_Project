package tests;

import control.ChocAnApp;

public class EntityTester extends ChocAnApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			initializeDB();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
