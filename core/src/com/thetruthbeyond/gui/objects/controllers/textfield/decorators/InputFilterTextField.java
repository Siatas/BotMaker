/*
 * Copyleft (C) 2015 Piotr Siatkowski find me on Facebook;
 * This file is part of BotMaker. BotMaker is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version. BotMaker is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU General Public License for more details. You should have received a
 * copy of the GNU General Public License along with BotMaker (look at the
 * Documents directory); if not, either write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA, or visit
 * (http://www.gnu.org/licenses/gpl.txt).
 */

package com.thetruthbeyond.gui.objects.controllers.textfield.decorators;

import java.util.Set;
import java.util.TreeSet;

import com.thetruthbeyond.gui.input.Keyboard;
import com.thetruthbeyond.gui.objects.controllers.textfield.TextField;
import com.thetruthbeyond.gui.objects.controllers.textfield.TextFieldDecorator;

public class InputFilterTextField extends TextFieldDecorator {

	private final Keyboard keyboard;
	private final Set<Character> filterSet;
	
	public InputFilterTextField(TextField parent, String filteredSigns) {
		super(parent);
		
		keyboard = Keyboard.getInstance();
		
		filterSet = new TreeSet<>();
		for(int i = 0; i != filteredSigns.length(); i++)
			filterSet.add(filteredSigns.charAt(i));
	}
	
	@Override
	public void update(float delta) {
		if(keyboard.isCharacterWaiting()) {
			// Dismiss typed character if it is assigned to filter.
			Character character = keyboard.peekCharacter();
			if(filterSet.contains(character))
				keyboard.getCharacter();
		}
		
		super.update(delta);
	}
}
