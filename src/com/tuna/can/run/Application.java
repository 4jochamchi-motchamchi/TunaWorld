
package com.tuna.can.run;

import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.UserDTO;

public class Application {

	public static void main(String[] args) {
		
		UserDTO ud = new UserDTO();
		ud.setUserNo(2);
		ud.setCoin(20);
		
		TunaController tc = new TunaController();
		tc.selectUSerCoin(ud);
		tc.updateCoin(ud);
		
		
	}
}
