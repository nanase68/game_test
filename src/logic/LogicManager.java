package logic;

import core.MyButton;

public class LogicManager {
	private static AbstractLogic currentLogic = null;
	private static AbstractLogic mainGameLogic = new MainGameLogic();
	private static AbstractLogic testLogic = new TestLogic();

	public static void initialize() {

	}

	public static void actionMouseClicked(MyButton button) {
		currentLogic.actionMouseClicked(button);
	}

	public static void actionMouseEntered(MyButton button) {
		currentLogic.actionMouseEntered(button);
	}

	public static void setLogic(String str) {
		if (str.equals("mainGame")) {
			currentLogic = mainGameLogic;
		} else if (str.equals("test")) {
			currentLogic = testLogic;
		}
	}

	static void changeButton(MyButton button, String pass) {
		button.changeIcon(pass);
	}
}
