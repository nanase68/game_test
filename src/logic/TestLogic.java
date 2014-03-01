package logic;

import util.Log;
import core.MyButton;

public class TestLogic extends AbstractLogic {

	@Override
	void actionMouseClicked(MyButton button) {
		LogicManager.changeButton(button, "reimu001-2.png");
		Log.d("hoge");
	}

	@Override
	void actionMouseEntered(MyButton button) {
		LogicManager.changeButton(button, "reimu0012-2.png");
	}

}
