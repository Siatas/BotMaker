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

import com.thetruthbeyond.gui.objects.controllers.textfield.TextField;
import com.thetruthbeyond.gui.objects.controllers.textfield.TextFieldDecorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import  com.thetruthbeyond.chatterbean.text.transformations.Tokenizer;

public class TokenizedTextField extends TextFieldDecorator {

	private final Tokenizer tokenizer = new Tokenizer( new String[] {"...", ".", ",", "?", "!", ":", ";"},
												       new String[] {"(", "[", "{"},
												       new String[] {")", "]", "}"}  );
	
	protected List<String> words = new ArrayList<>(8);
	
	public TokenizedTextField(TextField parent) {
		super(parent);
	}
	
	public List<String> getWords() {
		return Collections.unmodifiableList(words);
	}
	
	@Override
	public void appendToInput(String input) {
		super.appendToInput(input);
		words = tokenizer.tokenize(getInput());
	}
	
	@Override
	public void setInput(String input) {
		super.setInput(input);
		words = tokenizer.tokenize(getInput());
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		if(hasChanged())
			words = tokenizer.tokenize(getInput());
	}
}
